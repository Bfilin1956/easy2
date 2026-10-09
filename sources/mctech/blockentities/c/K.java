package mctech.blockentities.c;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import mctech.api.features.IClickable;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.api.tiles.IFluidMachine;
import mctech.api.util.DirectionList;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import mctech.m.b.C0132ae;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/K.class */
public class K extends BasicMachineTileEntity implements IClickable, INetworkFluidTankFillListener, IFluidMachine, mctech.i.g, mctech.i.h, GeoBlockEntity {
    private final AnimatableInstanceCache f;

    @NetworkInfo(fieldName = "fluidTank")
    @GuiField(fieldName = "fluidTank")
    public mctech.fluid.h<?> a;

    @NetworkInfo(fieldName = "progress")
    @GuiField(fieldName = "progress")
    public float[] b;

    @NetworkInfo(fieldName = "maxProgress")
    @GuiField(fieldName = "maxProgress")
    public float[] c;

    @NetworkInfo(fieldName = "recipeEnergy")
    public int[] d;
    private final mctech.u.O[] g;
    private final mctech.blocks.base.a.a h;
    static final /* synthetic */ boolean e;

    static {
        e = !K.class.desiredAssertionStatus();
    }

    public K(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.PLASMA_GENERATOR.get(), blockPos, blockState);
    }

    public K(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        this(blockEntityType, blockPos, blockState, mctech.h.a.c.d.get(blockState.getValue(MachineTier.PROPERTY)));
    }

    public K(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, mctech.h.a.c.o oVar) {
        super(blockEntityType, blockPos, blockState, oVar.e + 2, oVar.d, oVar.b, 0, oVar.c, oVar.b);
        this.f = GeckoLibUtil.createInstanceCache(this);
        this.inventoryManager = new mctech.m.e.j<>(this, oVar.d);
        this.a = new mctech.fluid.h<>(oVar.a);
        switch (AnonymousClass1.a[a(blockState).ordinal()]) {
            case 1:
                this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.g, 0).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(new mctech.m.c.m(this)));
                this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.w, 1).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(mctech.m.c.f.a));
                this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.l, 2).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c));
                this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.c, 3, 4, 5, 6).a(DirectionList.ALL).a(mctech.m.e.a.DISABLED));
                break;
            case 2:
                this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.g, 0, 1).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(new mctech.m.c.m(this)));
                this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.w, 2).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(mctech.m.c.f.a));
                this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.l, 3).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c));
                this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.c, 4, 5, 6, 7).a(DirectionList.ALL).a(mctech.m.e.a.DISABLED));
                break;
            case 3:
                this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.g, 0, 1, 2).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(new mctech.m.c.m(this)));
                this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.w, 3).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(mctech.m.c.f.a));
                this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.l, 4).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c));
                this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.c, 5, 6, 7, 8).a(DirectionList.ALL).a(mctech.m.e.a.DISABLED));
                break;
        }
        this.inventoryManager.i();
        this.h = new mctech.blocks.base.a.a(this, this.a, ((Integer) this.inventoryManager.b(mctech.m.e.k.w).getFirst()).intValue(), ((Integer) this.inventoryManager.b(mctech.m.e.k.l).getFirst()).intValue());
        int size = this.inventoryManager.b(mctech.m.e.k.g).size();
        this.b = new float[size];
        this.c = new float[size];
        this.d = new int[size];
        this.g = new mctech.u.O[size];
        setFuelSlot(-1);
    }

    /* JADX INFO: renamed from: mctech.blockentities.c.K$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/K$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MachineTier.values().length];

        static {
            try {
                a[MachineTier.T4.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[MachineTier.T6.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[MachineTier.T8.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @NotNull
    public BlockEntityType<?> getType() {
        return (BlockEntityType) MCTechTiles.PLASMA_GENERATOR.get();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.blockentities.k, mctech.api.tiles.IMachineInfo
    public int getEnergyPerTick() {
        return Arrays.stream(this.d).max().orElse(0);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.blockentities.k
    protected void createInvCaches() {
        this.inOut = this.inventoryManager.g();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        int iB;
        if (!e && this.level == null) {
            throw new AssertionError();
        }
        ItemStack itemStackCopy = itemStack.copy();
        if (mctech.u.O.a(this.level, itemStackCopy)) {
            for (ItemStack itemStack2 : c()) {
                if (itemStack2.isEmpty()) {
                    return itemStackCopy.getMaxStackSize();
                }
                if (mctech.utils.c.h.d(itemStack2, itemStackCopy) && (iB = mctech.utils.c.h.b(itemStack2)) > 0) {
                    return iB;
                }
            }
            return 0;
        }
        return 0;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    public boolean isVanilla() {
        return false;
    }

    @Override // mctech.api.tiles.IFluidMachine
    public IFluidHandler getConnectedTank(@NotNull Direction direction) {
        return provide(direction, getInventoryHandler(), (IFluidHandler) this.a);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        if (machineTier() == MachineTier.T8) {
            EnumSet<IUpgradeItem.UpgradeType> enumSetCopyOf = EnumSet.copyOf((EnumSet) defaultUpgrades(MachineTier.T7));
            enumSetCopyOf.add(IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM);
            return enumSetCopyOf;
        }
        return defaultUpgrades(machineTier());
    }

    @Override // mctech.api.features.IClickable
    public boolean onRightClick(Player player, InteractionHand interactionHand, Direction direction, BlockHitResult blockHitResult) {
        return mctech.utils.c.b.a(player.getItemInHand(interactionHand), player, (IFluidHandler) this.a) || mctech.utils.c.b.b(player.getItemInHand(interactionHand), player, this.a);
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    protected void onSlotChanged(int i, ItemStack itemStack, ItemStack itemStack2) {
    }

    private boolean a(mctech.u.O o) {
        return this.a.isEmpty() || FluidStack.isSameFluid(this.a.getFluid(), o.e());
    }

    private boolean b(mctech.u.O o) {
        return a(o) && this.a.getSpace() >= o.e().getAmount();
    }

    private List<ItemStack> c() {
        return this.inventoryManager.a(mctech.m.e.k.g);
    }

    private List<ItemStack> i() {
        return this.inventoryManager.a(mctech.m.e.k.c);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        float f = 0.0f;
        for (float f2 : this.c) {
            f += f2;
        }
        return f / this.inventoryManager.b(mctech.m.e.k.g).size();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        float f = 0.0f;
        for (float f2 : this.b) {
            f += f2;
        }
        return f / this.inventoryManager.b(mctech.m.e.k.g).size();
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.f;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public RecipeType<mctech.u.O> getRecipeType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get(d().getSerializedName()).get();
    }

    @Override // mctech.i.h
    public mctech.i.i d() {
        return b(getBlockState());
    }

    @Override // mctech.i.g
    public mctech.i.c g() {
        return null;
    }

    @Override // mctech.i.g
    @NotNull
    public Fluid N_() {
        return this.a.getFluid().getFluid();
    }

    @Override // mctech.i.g
    @NotNull
    public MachineTier machineTier() {
        return a(getBlockState());
    }

    @Override // mctech.i.g
    public float e() {
        return this.a.getFluidAmount();
    }

    @Override // mctech.i.g
    public float f() {
        return this.a.getCapacity();
    }

    @Override // mctech.i.h
    public MachineTier a(@NotNull BlockState blockState) {
        return blockState.getValue(MachineTier.PROPERTY);
    }

    @Override // mctech.i.h
    public mctech.i.i b(@NotNull BlockState blockState) {
        return (mctech.i.i) blockState.getValue(mctech.i.i.m);
    }

    @Override // mctech.i.h
    @NotNull
    public String V_() {
        return c(getBlockState());
    }

    @Override // mctech.i.h
    @NotNull
    public String c(@NotNull BlockState blockState) {
        return b(blockState).getSerializedName();
    }

    public void b() {
        sendToServer(0, 0);
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkClientEventListener
    public void onClientDataReceived(Player player, int i, int i2) {
        super.onClientDataReceived(player, i, i2);
        if (i == 0 && i2 == 0) {
            this.a.a();
        }
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0132ae(this, player, i);
    }

    @Override // mctech.api.network.tile.INetworkFluidTankFillListener
    @Nullable
    public IFluidHandler getFluidHandler(int i) {
        return this.a;
    }
}
