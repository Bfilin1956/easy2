package mctech.blockentities.c;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.IntStream;
import mctech.api.features.IClickable;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.api.tiles.IFluidMachine;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.api.util.DirectionList;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: mctech.blockentities.c.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/p.class */
public class C0069p extends mctech.blockentities.k implements IClickable, INetworkFluidTankFillListener, IFluidMachine, IProgressMachine, mctech.i.d, mctech.i.g, mctech.m.a.k, mctech.utils.r, IMachineTier, GeoAnimatable, GeoBlockEntity {
    private final AnimatableInstanceCache e;

    @NetworkInfo(fieldName = "fluidTank")
    @GuiField(fieldName = "fluidTank")
    public final mctech.fluid.h<?> a;

    @NetworkInfo(fieldName = "machineTier")
    @GuiField(fieldName = "machineTier")
    private final int f;

    @NetworkInfo(fieldName = "generatorType")
    @GuiField(fieldName = "generatorType")
    private final int g;

    @NetworkInfo(fieldName = "progress")
    @GuiField(fieldName = "progress")
    public float b;

    @NetworkInfo(fieldName = "fluidGenerationAmount")
    @GuiField(fieldName = "fluidGenerationAmount")
    private int h;
    protected mctech.blocks.base.a.a c;
    protected mctech.blocks.base.a.a d;

    @NetworkInfo(fieldName = "generationFluidEnergyConsumption")
    private int i;

    @NetworkInfo(fieldName = "generationFluidTimeConsumption")
    private int j;

    @NetworkInfo(fieldName = "autoSortingEnabled")
    @GuiField(fieldName = "autoSortingEnabled")
    private boolean k;
    private boolean l;
    private mctech.m.e.j<C0069p> m;

    public C0069p(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.FLUID_GENERATOR.get(), blockPos, blockState);
    }

    public C0069p(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        this(blockEntityType, blockPos, blockState, blockState.getValue(mctech.i.c.d) == mctech.i.c.LAVA ? mctech.h.a.c.b.get(blockState.getValue(MachineTier.PROPERTY)) : mctech.h.a.c.a.get(blockState.getValue(MachineTier.PROPERTY)));
    }

    public C0069p(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, mctech.h.a.c.g gVar) {
        int i;
        super(blockEntityType, blockPos, blockState, mctech.h.a.c.g.a(blockState), gVar.h, gVar.d, gVar.c, gVar.f, gVar.e);
        this.e = GeckoLibUtil.createInstanceCache(this);
        this.g = ((mctech.i.c) blockState.getValue(mctech.i.c.d)).ordinal();
        this.upgradeHandler.c(gVar.d);
        this.upgradeHandler.e(gVar.f);
        this.upgradeHandler.d(gVar.c);
        this.i = gVar.d;
        this.h = gVar.b;
        this.j = this.h;
        this.f = blockState.getValue(MachineTier.PROPERTY).ordinal();
        this.a = new mctech.fluid.h(gVar.g, fluidStack -> {
            return fluidStack.is(g().a());
        }).b(true);
        this.m = new mctech.m.e.j<>(this, gVar.h);
        this.m.a(new mctech.m.g.y(mctech.m.e.k.v, 0).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(mctech.m.c.f.a));
        this.m.a(new mctech.m.g.y(mctech.m.e.k.l, 1).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c).b(mctech.m.c.r.d));
        if (g() == mctech.i.c.LAVA) {
            switch (AnonymousClass1.a[machineTier().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    i = 1;
                    break;
                case 4:
                    i = 3;
                    break;
                case 5:
                    i = 6;
                    break;
                default:
                    i = 0;
                    break;
            }
            this.m.a(new mctech.m.g.y(mctech.m.e.k.g, IntStream.range(2, 2 + i).toArray()).a(mctech.m.e.a.IMPORT).a(DirectionList.ALL).a(new mctech.utils.E(Set.of(Tags.Items.STONES, Tags.Items.COBBLESTONES))));
        }
        switch (AnonymousClass1.a[machineTier().ordinal()]) {
            case 3:
            case 4:
            case 5:
                this.m.a(new mctech.m.g.y(mctech.m.e.k.c, IntStream.range(this.m.c(), this.m.c() + this.m.d()).toArray()).a(DirectionList.ALL).a(mctech.m.e.a.DISABLED));
                break;
        }
        this.c = new mctech.blocks.base.a.a(this, this.a, ((Integer) this.m.b(mctech.m.e.k.v).getFirst()).intValue(), ((Integer) this.m.b(mctech.m.e.k.l).getFirst()).intValue());
        this.d = new mctech.blocks.base.a.a(this, this.a, ((Integer) this.m.b(mctech.m.e.k.v).getFirst()).intValue(), ((Integer) this.m.b(mctech.m.e.k.l).getFirst()).intValue());
        this.m.i();
        setFuelSlot(-1);
        addNetworkFields(this);
        addComparator(new mctech.blocks.base.a.a.a.a.i("fluidTank", mctech.blocks.base.a.a.d.o, this.a));
        addComparator(new mctech.blocks.base.a.a.a.a.f("progress", mctech.blocks.base.a.a.d.m, this));
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
    }

    @NotNull
    public BlockEntityType<?> getType() {
        return (BlockEntityType) MCTechTiles.FLUID_GENERATOR.get();
    }

    @Override // mctech.blockentities.q
    public void onLoaded() {
        super.onLoaded();
    }

    @Override // mctech.blockentities.k, mctech.blockentities.i, mctech.blockentities.q
    public void onUnloaded(boolean z) {
        super.onUnloaded(z);
    }

    public void a() {
        sendToServer(0, 0);
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkClientEventListener
    public void onClientDataReceived(Player player, int i, int i2) {
        super.onClientDataReceived(player, i, i2);
        if (i == 0) {
            this.k = !this.k;
            if (this.k && !this.l) {
                this.l = true;
            }
        }
    }

    public boolean b() {
        return this.k;
    }

    @Override // mctech.utils.r
    public int[] a(boolean z) {
        if (g() == mctech.i.c.WATER) {
            return new int[0];
        }
        return this.m.a(this.m.b(mctech.m.e.k.g));
    }

    @Override // mctech.blockentities.k
    protected void createInvCaches() {
        this.inOut = this.m.g();
    }

    public boolean c() {
        if (this.level == null) {
            return false;
        }
        return BlockPos.betweenClosedStream(this.worldPosition.offset(-1, -1, -1), this.worldPosition.offset(1, 1, 1)).anyMatch(blockPos -> {
            return this.level.getFluidState(blockPos).is(g().b());
        });
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        switch (AnonymousClass1.a[machineTier().ordinal()]) {
            case 3:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 4:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 5:
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

    /* JADX INFO: renamed from: mctech.blockentities.c.p$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/p$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            try {
                b[mctech.i.c.WATER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[mctech.i.c.LAVA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            a = new int[MachineTier.values().length];
            try {
                a[MachineTier.T1.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[MachineTier.T2.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[MachineTier.T3.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[MachineTier.T4.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[MachineTier.T5.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    protected void a(int i, ItemStack itemStack, ItemStack itemStack2) {
        switch (g()) {
            case LAVA:
                if (i > 1 && !mctech.utils.c.h.d(itemStack, itemStack2)) {
                    this.b = 0.0f;
                    break;
                }
                break;
        }
    }

    protected boolean d() {
        return false;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.b;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return this.upgradeHandler.c();
    }

    @Override // mctech.api.features.IClickable
    public boolean onRightClick(Player player, InteractionHand interactionHand, Direction direction, BlockHitResult blockHitResult) {
        return false;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.e;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new mctech.m.b.D(this, player, i);
    }

    @Override // mctech.i.g
    @NotNull
    public MachineTier machineTier() {
        return getBlockState().getValue(MachineTier.PROPERTY);
    }

    @Override // mctech.i.g
    public float e() {
        return this.a.getFluidAmount();
    }

    @Override // mctech.i.g
    public float f() {
        return this.a.getCapacity();
    }

    @Override // mctech.i.g
    @NotNull
    public mctech.i.c g() {
        return (mctech.i.c) getBlockState().getValue(mctech.i.c.d);
    }

    @Override // mctech.api.tiles.IFluidMachine
    public IFluidHandler getConnectedTank(@NotNull Direction direction) {
        return provide(direction, getInventoryHandler(), (IFluidHandler) this.a);
    }

    @Override // mctech.api.network.tile.INetworkFluidTankFillListener
    public IFluidHandler getFluidHandler(int i) {
        return this.a;
    }
}
