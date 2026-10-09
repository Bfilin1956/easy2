package mctech.blockentities.c;

import mctech.api.features.IClickable;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.api.tiles.IFluidMachine;
import mctech.api.tiles.readers.IFuelStorage;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.api.util.DirectionList;
import mctech.init.MCTechTiles;
import mctech.m.b.ax;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/X.class */
public class X extends mctech.blockentities.t implements IClickable, IWrenchableTile, INetworkFluidTankFillListener, IFluidMachine, IFuelStorage, IProgressMachine, mctech.i.d, mctech.i.e, IMachineTier {
    private final AnimatableInstanceCache i;

    @NetworkInfo(fieldName = "waterTank")
    @GuiField(fieldName = "waterTank")
    public final mctech.fluid.h<?> f;

    @NetworkInfo(fieldName = "lavaTank")
    @GuiField(fieldName = "lavaTank")
    public final mctech.fluid.h<?> g;

    @NetworkInfo(fieldName = "waterConsumption")
    private int j;

    @NetworkInfo(fieldName = "lavaConsumption")
    private int k;

    @NetworkInfo(fieldName = "generationAmount")
    private int l;

    @NetworkInfo(fieldName = "progress")
    @GuiField(fieldName = "progress")
    public float h;

    @NetworkInfo(fieldName = "burnTime")
    @GuiField(fieldName = "burnTime")
    private int m;

    @NetworkInfo(fieldName = "burnDuration")
    @GuiField(fieldName = "burnDuration")
    private int n;

    @NetworkInfo(fieldName = "energyConsume")
    private int o;

    @NetworkInfo(fieldName = "operationLength")
    private int p;
    private final mctech.m.e.j<X> q;

    public X(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.STONE_COBBLESTONE_GENERATOR.get(), blockPos, blockState);
    }

    public X(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, mctech.h.a.c.c.get(MachineTier.T1).k + 1);
        this.i = GeckoLibUtil.createInstanceCache(this);
        mctech.h.a.c.C0020c c0020c = mctech.h.a.c.c.get(MachineTier.T1);
        this.o = c0020c.g;
        this.j = c0020c.a;
        this.k = c0020c.b;
        this.l = c0020c.f;
        this.p = c0020c.e;
        this.f = new mctech.fluid.h(c0020c.c, fluidStack -> {
            return fluidStack.is(Fluids.WATER);
        }).a(true);
        this.g = new mctech.fluid.h(c0020c.d, fluidStack2 -> {
            return fluidStack2.is(Fluids.LAVA);
        }).a(true);
        this.q = new mctech.m.e.j<>(this);
        this.q.a(new mctech.m.g.y(mctech.m.e.k.n, 0).a(mctech.m.e.a.IMPORT).a(DirectionList.ALL).a(mctech.m.c.a.f.b));
        this.q.a(new mctech.m.g.y(mctech.m.e.k.l, 1).a(mctech.m.e.a.EXPORT).a(DirectionList.ALL).a(mctech.m.c.r.c));
        this.q.i();
        addComparator(new mctech.blocks.base.a.a.a.a.i("waterTank", mctech.blocks.base.a.a.d.o, this.f));
        addComparator(new mctech.blocks.base.a.a.a.a.i("lavaTank", mctech.blocks.base.a.a.d.o, this.g));
        addComparator(new mctech.blocks.base.a.a.a.a.f("progress", mctech.blocks.base.a.a.d.m, this));
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
        addComparator(new mctech.blocks.base.a.a.a.a.d("burnDuration", mctech.blocks.base.a.a.d.f, this));
    }

    @Override // mctech.blockentities.t
    public void a() {
        this.c = this.q.g();
    }

    @Override // mctech.blockentities.q
    public void onLoaded() {
        super.onLoaded();
    }

    @Override // mctech.blockentities.i, mctech.blockentities.q
    public void onUnloaded(boolean z) {
        super.onUnloaded(z);
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ((Integer) this.inventory.stream().filter(itemStack2 -> {
            return mctech.utils.c.h.d(itemStack, itemStack2);
        }).map(mctech.utils.c.h::b).filter(num -> {
            return num.intValue() > 0;
        }).findAny().orElse(0)).intValue();
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.h;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return this.p;
    }

    private ItemStack e() {
        return new ItemStack(Items.COBBLESTONE, this.l);
    }

    private boolean f() {
        return (this.f.getFluidAmount() >= this.j) && (this.g.getFluidAmount() >= this.k) && (getValidRoom(e()) > 0 || this.inventory.stream().anyMatch((v0) -> {
            return v0.isEmpty();
        }));
    }

    private void b(boolean z) {
    }

    @Override // mctech.blockentities.t
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.i;
    }

    @Override // mctech.api.tiles.readers.IFuelStorage
    public int getFuel() {
        return this.m;
    }

    @Override // mctech.api.tiles.readers.IFuelStorage
    public int getMaxFuel() {
        return this.n;
    }

    @Override // mctech.blockentities.t, mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return getFacing() != direction && direction.getAxis().isHorizontal();
    }

    @Override // mctech.blockentities.t, mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.blockentities.t, mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 1.0d;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new ax(this, player, i);
    }

    public MachineTier machineTier() {
        return getBlockState().getValue(MachineTier.PROPERTY);
    }

    @Override // mctech.api.tiles.IFluidMachine
    public IFluidHandler getConnectedTank(@NotNull Direction direction) {
        return provide(direction, getInventoryHandler(), new mctech.fluid.i(this.f.a(this, direction), this.g.a(this, direction)));
    }

    private boolean g() {
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

    @Override // mctech.api.features.IClickable
    public boolean onRightClick(Player player, InteractionHand interactionHand, Direction direction, BlockHitResult blockHitResult) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        FluidStack fluidStack = (FluidStack) FluidUtil.getFluidContained(itemInHand).orElse(FluidStack.EMPTY);
        if (fluidStack.is(Fluids.WATER)) {
            return mctech.utils.c.b.a(itemInHand, player, (IFluidHandler) this.f);
        }
        if (fluidStack.is(Fluids.LAVA)) {
            return mctech.utils.c.b.a(itemInHand, player, (IFluidHandler) this.g);
        }
        return false;
    }

    @Override // mctech.i.e
    public float c() {
        return this.f.getFluidAmount() / this.f.getCapacity();
    }

    @Override // mctech.i.e
    public float d() {
        return this.g.getFluidAmount() / this.g.getCapacity();
    }

    @Override // mctech.api.network.tile.INetworkFluidTankFillListener
    @Nullable
    public IFluidHandler getFluidHandler(int i) {
        switch (i) {
            case 0:
                return this.f;
            case 1:
                return this.g;
            default:
                return null;
        }
    }
}
