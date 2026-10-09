package mctech.blockentities.c;

import java.util.EnumSet;
import java.util.function.Consumer;
import mctech.api.blocks.IMultiblock;
import mctech.api.features.IClickable;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.api.tiles.IFluidMachine;
import mctech.api.tiles.IRecipeMachine;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.api.util.DirectionList;
import mctech.api.util.ItemInsertionHelper;
import mctech.init.MCTechFluids;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechSounds;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: mctech.blockentities.c.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/u.class */
public class C0074u extends mctech.blockentities.k implements IMultiblock, IClickable, INetworkFluidTankFillListener, IFluidMachine, IRecipeMachine, IProgressMachine, mctech.m.a.k, mctech.utils.r, GeoBlockEntity {
    public static final int a = 6;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 100000;
    public static final int f = 30;
    public static final int g = 100;
    public static final int h = 40;
    public static final int i = 25;
    public static final int j = 10;
    public static final int k = 0;
    public static final int l = 32;
    public static final int m = 40;
    public static final int n = 1638400;
    public static final int o = 16384;
    private final AnimatableInstanceCache s;

    @NetworkInfo(fieldName = "lavaTank")
    @GuiField(fieldName = "lavaTank")
    public final mctech.fluid.h<?> p;

    @NetworkInfo(fieldName = "moltenGlassTank")
    @GuiField(fieldName = "moltenGlassTank")
    public final mctech.fluid.h<?> q;

    @NetworkInfo(fieldName = "heatLevel")
    @GuiField(fieldName = "heatLevel")
    public int r;

    @NetworkInfo(fieldName = "multiProgress")
    @GuiField(fieldName = "multiProgress")
    private float[] t;

    @NetworkInfo(fieldName = "multiProgressMax")
    @GuiField(fieldName = "multiProgressMax")
    private int[] u;

    @NetworkInfo(fieldName = "multiRecipeEnergy")
    @GuiField(fieldName = "multiRecipeEnergy")
    private int[] v;

    @NetworkInfo(fieldName = "operatingSlots")
    @GuiField(fieldName = "operatingSlots")
    private int w;

    @NetworkInfo(fieldName = "autoSortingEnabled")
    private boolean x;
    private boolean y;

    public C0074u(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.GLASS_FURNACE.get(), blockPos, blockState);
    }

    public C0074u(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 18, 4, 32, 40, n, o);
        this.s = GeckoLibUtil.createInstanceCache(this);
        this.redstoneSensitive = true;
        this.r = 0;
        this.w = 2;
        this.t = new float[6];
        this.u = new int[6];
        this.v = new int[6];
        this.p = new mctech.fluid.h(e, fluidStack -> {
            return fluidStack.is(Fluids.LAVA);
        }).a(true).a(this, () -> {
        });
        this.q = new mctech.fluid.h(e, fluidStack2 -> {
            return fluidStack2.is(MCTechFluids.MELTED_GLASS.getSource());
        }).a(true).a(this, () -> {
        });
        this.inventoryManager = new mctech.m.e.j<>(this, 4);
        for (int i2 = 0; i2 < 6; i2++) {
            this.inventoryManager.a(mctech.m.g.y.f(a(i2)).a(new mctech.m.c.n(this, 0)).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT));
            this.inventoryManager.a(mctech.m.g.y.f(b(i2)).a(new mctech.m.c.n(this, 1)).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT));
            this.inventoryManager.a(mctech.m.g.y.d(c(i2)).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT));
        }
        this.inventoryManager.a(this);
        this.inventoryManager.i();
        addGuiFields(this);
        addNetworkFields(this);
    }

    public int a(int i2) {
        return i2 * 3;
    }

    public int b(int i2) {
        return a(i2) + 1;
    }

    public int c(int i2) {
        return a(i2) + 2;
    }

    public int a() {
        return this.w;
    }

    public int b() {
        return this.r;
    }

    public boolean d(int i2) {
        return i2 < this.w;
    }

    private boolean f(int i2) {
        if (i2 < 0 || i2 >= 18) {
            return true;
        }
        return d(i2 / 3);
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public boolean canInsert(int i2, ItemStack itemStack) {
        return f(i2) && super.canInsert(i2, itemStack);
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public boolean canExtract(int i2, ItemStack itemStack) {
        return f(i2) && super.canExtract(i2, itemStack);
    }

    public mctech.fluid.h<?> c() {
        return this.p;
    }

    public mctech.fluid.h<?> d() {
        return this.q;
    }

    @Override // mctech.api.network.tile.INetworkFluidTankFillListener
    @Nullable
    public IFluidHandler getFluidHandler(int i2) {
        switch (i2) {
            case 0:
                return this.p;
            case 1:
                return this.q;
            default:
                return null;
        }
    }

    @Override // mctech.blockentities.q
    public Direction getFacing() {
        return (Direction) getBlockState().getOptionalValue(mctech.p.b.c.b).orElse(Direction.NORTH);
    }

    @Override // mctech.blockentities.k, mctech.blockentities.e, mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return false;
    }

    @Override // mctech.blockentities.k, mctech.blockentities.e, mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 1.0d;
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    @Override // mctech.blockentities.k
    protected void createInvCaches() {
        this.inOut = this.inventoryManager.g();
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.s;
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD, IUpgradeItem.UpgradeType.EXPAND_MOD, IUpgradeItem.UpgradeType.TRANSFORMER_MOD);
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ItemInsertionHelper.getValidRoom(this, itemStack);
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return getProgressSlot(0);
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return getMaxProgressSlot(0);
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgressSlot(int i2) {
        if (i2 < 0 || i2 >= this.t.length) {
            return 0.0f;
        }
        return this.t[i2];
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgressSlot(int i2) {
        if (i2 < 0 || i2 >= this.u.length) {
            return 0.0f;
        }
        return this.u[i2];
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public int getSlots() {
        return this.w;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return (RecipeType) MCTechRecipes.GLASS_FURNACE.get();
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public float getProgressPerTick() {
        return this.upgradeHandler.a();
    }

    @Override // mctech.blockentities.k
    public DeferredHolder<SoundEvent, SoundEvent> getWorkingSound() {
        return MCTechSounds.ELECTRIC_FURNACE;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i2) {
        return new mctech.m.b.L(this, player, i2);
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkClientEventListener
    public void onClientDataReceived(Player player, int i2, int i3) {
        super.onClientDataReceived(player, i2, i3);
        if (i2 == 0) {
            this.x = !this.x;
            if (this.x) {
                this.y = true;
            }
            updateNetworkFields(this);
        }
    }

    public boolean e() {
        return this.x;
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public void setStackInSlot(int i2, ItemStack itemStack) {
        if (this.x) {
            this.y = true;
        }
        super.setStackInSlot(i2, itemStack);
    }

    @Override // mctech.utils.r
    public void a(int i2, ItemStack itemStack) {
        super.setStackInSlot(i2, itemStack);
    }

    @Override // mctech.utils.r
    public int[] a(boolean z) {
        int i2 = this.w;
        int[] iArr = new int[i2 * 2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3 * 2] = a(i3);
            iArr[(i3 * 2) + 1] = b(i3);
        }
        return iArr;
    }

    @Override // mctech.api.features.IClickable
    public boolean onRightClick(Player player, InteractionHand interactionHand, Direction direction, BlockHitResult blockHitResult) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (itemInHand.isEmpty()) {
            return false;
        }
        return mctech.utils.c.b.b(itemInHand, player, new mctech.fluid.i(this.p, this.q)) || mctech.utils.c.b.a(itemInHand, player, new mctech.fluid.i(this.p, this.q));
    }

    @Override // mctech.api.tiles.IFluidMachine
    public IFluidHandler getConnectedTank(Direction direction) {
        if (direction == null) {
            return new mctech.fluid.i(this.p, this.q);
        }
        if (getInventoryHandler().d(direction) != mctech.m.e.a.DISABLED) {
            return new mctech.fluid.i(this.p, this.q);
        }
        return null;
    }

    @Override // mctech.api.blocks.IMultiblock
    public void forStructureBlocks(@NotNull Consumer<BlockPos> consumer) {
        if (this.level == null) {
            return;
        }
        for (Direction direction : Direction.values()) {
            mctech.p.b.c block = this.level.getBlockState(getMasterPosition().relative(direction)).getBlock();
            if (block instanceof mctech.p.b.c) {
                block.a((BlockGetter) this.level, this.worldPosition, getBlockState(), consumer);
                return;
            }
        }
    }

    @Override // mctech.api.blocks.IMultiblock
    public BlockPos getMasterPosition() {
        return this.worldPosition;
    }
}
