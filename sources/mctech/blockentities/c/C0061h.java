package mctech.blockentities.c;

import java.util.EnumSet;
import java.util.stream.IntStream;
import mctech.MCTech;
import mctech.api.features.IClickable;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.api.tiles.IFluidMachine;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.api.util.DirectionList;
import mctech.init.MCTechSounds;
import mctech.init.MCTechTiles;
import mctech.m.b.C0156p;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: mctech.blockentities.c.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/h.class */
public class C0061h extends mctech.blockentities.k implements IClickable, INetworkFluidTankFillListener, IFluidMachine, IProgressMachine, mctech.i.d, mctech.i.e, mctech.m.a.k, mctech.utils.r, IMachineTier, GeoAnimatable, GeoBlockEntity {
    private final AnimatableInstanceCache d;

    @NetworkInfo(fieldName = "waterTank")
    @GuiField(fieldName = "waterTank")
    public final mctech.fluid.h<?> a;

    @NetworkInfo(fieldName = "lavaTank")
    @GuiField(fieldName = "lavaTank")
    public final mctech.fluid.h<?> b;

    @NetworkInfo(fieldName = "waterConsumption")
    private int e;

    @NetworkInfo(fieldName = "lavaConsumption")
    private int f;

    @NetworkInfo(fieldName = "generationAmount")
    private int g;

    @NetworkInfo(fieldName = "progress")
    @GuiField(fieldName = "progress")
    public float c;
    private int h;
    private mctech.m.e.j<C0061h> i;

    public C0061h(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.COBBLESTONE_GENERATOR.get(), blockPos, blockState);
    }

    @Override // mctech.blockentities.k
    public DeferredHolder<SoundEvent, SoundEvent> getWorkingSound() {
        return MCTechSounds.ELECTRIC_FURNACE;
    }

    public C0061h(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        this(blockEntityType, blockPos, blockState, mctech.h.a.c.c.get(blockState.getValue(MachineTier.PROPERTY)));
    }

    public C0061h(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, mctech.h.a.c.C0020c c0020c) {
        super(blockEntityType, blockPos, blockState, c0020c.k, c0020c.j, c0020c.g, c0020c.e, c0020c.i, c0020c.h);
        this.d = GeckoLibUtil.createInstanceCache(this);
        this.upgradeHandler.c(c0020c.g);
        this.upgradeHandler.e(c0020c.i);
        this.upgradeHandler.d(c0020c.e);
        this.e = c0020c.a;
        this.f = c0020c.b;
        this.g = c0020c.f;
        this.a = new mctech.fluid.h(c0020c.c, fluidStack -> {
            return fluidStack.is(Fluids.WATER);
        }).a(true);
        this.b = new mctech.fluid.h(c0020c.d, fluidStack2 -> {
            return fluidStack2.is(Fluids.LAVA);
        }).a(true);
        int i = c0020c.k;
        this.i = new mctech.m.e.j<>(this, c0020c.j);
        this.i.a(new mctech.m.g.y(mctech.m.e.k.l, IntStream.range(0, i).toArray()).a(mctech.m.e.a.EXPORT).a(DirectionList.ALL).a(mctech.m.c.r.c).b(mctech.m.c.r.d));
        if (c0020c.j > 0) {
            this.i.a(new mctech.m.g.y(mctech.m.e.k.c, IntStream.range(i, i + c0020c.j).toArray()).a(mctech.m.e.a.DISABLED).a(DirectionList.EMPTY));
        }
        this.i.i();
        setFuelSlot(-1);
        addNetworkFields(this);
        addComparator(new mctech.blocks.base.a.a.a.a.i("waterTank", mctech.blocks.base.a.a.d.o, this.a));
        addComparator(new mctech.blocks.base.a.a.a.a.i("lavaTank", mctech.blocks.base.a.a.d.o, this.b));
        addComparator(new mctech.blocks.base.a.a.a.a.f("progress", mctech.blocks.base.a.a.d.m, this));
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
    }

    @Override // mctech.utils.r
    public int[] a(boolean z) {
        return this.i.a(this.i.b(mctech.m.e.k.l));
    }

    @Override // mctech.blockentities.q
    public void onLoaded() {
        super.onLoaded();
    }

    @Override // mctech.blockentities.k, mctech.blockentities.i, mctech.blockentities.q
    public void onUnloaded(boolean z) {
        super.onUnloaded(z);
    }

    @Override // mctech.blockentities.k
    protected void createInvCaches() {
        this.inOut = this.i.g();
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public boolean canExtract(int i, ItemStack itemStack) {
        mctech.m.e.a.a aVarC = getInventoryHandler().c(i);
        return aVarC == null || aVarC.matches(i, itemStack);
    }

    /* JADX INFO: renamed from: mctech.blockentities.c.h$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/h$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MachineTier.values().length];

        static {
            try {
                a[MachineTier.T3.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[MachineTier.T4.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[MachineTier.T5.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        switch (AnonymousClass1.a[machineTier().ordinal()]) {
            case 1:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 2:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 3:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM, IUpgradeItem.UpgradeType.TRANSFORMER_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            default:
                return EnumSet.noneOf(IUpgradeItem.UpgradeType.class);
        }
    }

    @Override // mctech.utils.r
    public void a(int i, ItemStack itemStack) {
        super.setStackInSlot(i, itemStack);
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ((Integer) this.inventory.stream().filter(itemStack2 -> {
            return mctech.utils.c.h.d(itemStack, itemStack2);
        }).map(mctech.utils.c.h::b).filter(num -> {
            return num.intValue() > 0;
        }).findAny().orElse(0)).intValue();
    }

    protected boolean a() {
        return !g();
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.c;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return this.upgradeHandler.c();
    }

    @Override // mctech.api.features.IClickable
    public boolean onRightClick(Player player, InteractionHand interactionHand, Direction direction, BlockHitResult blockHitResult) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        FluidStack fluidStack = (FluidStack) FluidUtil.getFluidContained(itemInHand).orElse(FluidStack.EMPTY);
        if (fluidStack.is(Fluids.WATER)) {
            return mctech.utils.c.b.a(itemInHand, player, (IFluidHandler) this.a);
        }
        if (fluidStack.is(Fluids.LAVA)) {
            return mctech.utils.c.b.a(itemInHand, player, (IFluidHandler) this.b);
        }
        return false;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.d;
    }

    private void e() {
        this.a.a(this.e, IFluidHandler.FluidAction.EXECUTE);
        this.b.a(this.f, IFluidHandler.FluidAction.EXECUTE);
        for (int i : a(true)) {
            ItemStack stackInSlot = getStackInSlot(i);
            if (stackInSlot.isEmpty()) {
                setStackInSlot(i, f());
            } else if (a(stackInSlot) && stackInSlot.getCount() + this.g <= stackInSlot.getMaxStackSize()) {
                setStackInSlot(i, stackInSlot.copyWithCount(stackInSlot.getCount() + this.g));
            }
        }
        setChanged();
    }

    private ItemStack f() {
        return new ItemStack(Items.COBBLESTONE, this.g);
    }

    private boolean g() {
        return hasEnergy(this.upgradeHandler.b()) && (this.a.getFluidAmount() >= this.e) && (this.b.getFluidAmount() >= this.f) && (getValidRoom(f()) > 0 || this.inventory.stream().anyMatch((v0) -> {
            return v0.isEmpty();
        }));
    }

    private boolean a(ItemStack itemStack) {
        return itemStack.is(Items.COBBLESTONE);
    }

    private void b(boolean z) {
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0156p(this, player, i);
    }

    public ResourceLocation b() {
        return MCTech.loc(String.format("textures/gui/container/cobblestone_generator/cobblestone_generator_t%s.png", machineTier().asIntegerString()));
    }

    public MachineTier machineTier() {
        return getBlockState().getValue(MachineTier.PROPERTY);
    }

    @Override // mctech.api.tiles.IFluidMachine
    public IFluidHandler getConnectedTank(@NotNull Direction direction) {
        return provide(direction, getInventoryHandler(), new mctech.fluid.i(this.a.a(this, direction), this.b.a(this, direction)));
    }

    private boolean i() {
        IFluidHandler iFluidHandler;
        mctech.m.e.a aVarD;
        if (clock(20)) {
            for (Direction direction : Direction.values()) {
                if (this.level == null) {
                    return false;
                }
                BlockPos blockPosRelative = this.worldPosition.relative(direction);
                BlockEntity blockEntity = this.level.getBlockEntity(blockPosRelative);
                if (blockEntity != null && !(blockEntity instanceof C0061h) && !(blockEntity instanceof X) && (iFluidHandler = (IFluidHandler) this.level.getCapability(Capabilities.FluidHandler.BLOCK, blockPosRelative, direction.getOpposite())) != null && (((aVarD = getInventoryHandler().d(direction)) == mctech.m.e.a.BOTH || aVarD == mctech.m.e.a.IMPORT) && !FluidUtil.tryFluidTransfer(getConnectedTank(direction), iFluidHandler, 1000, true).isEmpty())) {
                    setChanged();
                    if (this.level != null && !this.level.isClientSide) {
                        this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), 3);
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // mctech.i.e
    public float c() {
        return this.a.getFluidAmount() / this.a.getCapacity();
    }

    @Override // mctech.i.e
    public float d() {
        return this.b.getFluidAmount() / this.b.getCapacity();
    }

    @Override // mctech.api.network.tile.INetworkFluidTankFillListener
    @Nullable
    public IFluidHandler getFluidHandler(int i) {
        switch (i) {
            case 0:
                return this.a;
            case 1:
                return this.b;
            default:
                return null;
        }
    }
}
