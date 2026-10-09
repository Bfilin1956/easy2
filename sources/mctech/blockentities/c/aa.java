package mctech.blockentities.c;

import java.util.Set;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.api.tiles.IFluidMachine;
import mctech.api.tiles.readers.IFuelStorage;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.api.util.DirectionList;
import mctech.init.MCTechTiles;
import mctech.m.b.aA;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/aa.class */
public class aa extends mctech.blockentities.t implements IWrenchableTile, INetworkFluidTankFillListener, IFluidMachine, IFuelStorage, IProgressMachine, mctech.i.d, mctech.i.g {

    @NetworkInfo(fieldName = "fluidTank")
    @GuiField(fieldName = "fluidTank")
    public final mctech.fluid.h<?> f;

    @NetworkInfo(fieldName = "progress")
    @GuiField(fieldName = "progress")
    public float g;

    @NetworkInfo(fieldName = "fluidGenerationAmount")
    @GuiField(fieldName = "fluidGenerationAmount")
    private int i;

    @NetworkInfo(fieldName = "burnTime")
    @GuiField(fieldName = "burnTime")
    private int j;

    @NetworkInfo(fieldName = "burnDuration")
    @GuiField(fieldName = "burnDuration")
    private int k;
    protected mctech.blocks.base.a.a h;

    @NetworkInfo(fieldName = "energyConsume")
    private int l;

    @NetworkInfo(fieldName = "operationLength")
    private int m;
    private final mctech.m.e.j<aa> n;

    public aa(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.STONE_FLUID_GENERATOR.get(), blockPos, blockState);
    }

    public aa(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        this(blockEntityType, blockPos, blockState, blockState.getValue(mctech.i.c.d) == mctech.i.c.LAVA ? mctech.h.a.c.b.get(blockState.getValue(MachineTier.PROPERTY)) : mctech.h.a.c.a.get(blockState.getValue(MachineTier.PROPERTY)));
    }

    public aa(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, mctech.h.a.c.g gVar) {
        super(blockEntityType, blockPos, blockState, mctech.h.a.c.g.a(blockState));
        this.l = gVar.d;
        this.i = gVar.b;
        this.m = gVar.c;
        this.f = new mctech.fluid.h<>(gVar.g, fluidStack -> {
            return fluidStack.is(g().a());
        });
        this.h = new mctech.blocks.base.a.a(this, this.f, 0, 1);
        this.n = new mctech.m.e.j<>(this);
        this.n.a(new mctech.m.g.y(mctech.m.e.k.h, 0).a(mctech.m.e.a.IMPORT).a(DirectionList.ALL).a(mctech.m.c.f.a));
        this.n.a(new mctech.m.g.y(mctech.m.e.k.l, 1).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c).b(mctech.m.c.r.d));
        this.n.a(new mctech.m.g.y(mctech.m.e.k.n, 2).a(mctech.m.e.a.IMPORT).a(DirectionList.ALL).a(mctech.m.c.a.f.b));
        if (g() == mctech.i.c.LAVA) {
            this.n.a(new mctech.m.g.y(mctech.m.e.k.h, 3).a(mctech.m.e.a.IMPORT).a(DirectionList.ALL).a(new mctech.utils.E(Set.of(Tags.Items.STONES, Tags.Items.COBBLESTONES))));
        }
        this.n.i();
        addComparator(new mctech.blocks.base.a.a.a.a.i("fluidTank", mctech.blocks.base.a.a.d.o, this.f));
        addComparator(new mctech.blocks.base.a.a.a.a.f("progress", mctech.blocks.base.a.a.d.m, this));
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
        addComparator(new mctech.blocks.base.a.a.a.a.d("burnDuration", mctech.blocks.base.a.a.d.f, this));
    }

    @NotNull
    public BlockEntityType<?> getType() {
        return (BlockEntityType) MCTechTiles.STONE_FLUID_GENERATOR.get();
    }

    @Override // mctech.blockentities.q
    public void onLoaded() {
        super.onLoaded();
    }

    @Override // mctech.blockentities.i, mctech.blockentities.q
    public void onUnloaded(boolean z) {
        super.onUnloaded(z);
    }

    public boolean d() {
        if (this.level == null) {
            return false;
        }
        return BlockPos.betweenClosedStream(this.worldPosition.offset(-1, -1, -1), this.worldPosition.offset(1, 1, 1)).anyMatch(blockPos -> {
            return this.level.getFluidState(blockPos).is(g().b());
        });
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        ItemStack itemStack2 = (ItemStack) this.inventory.getFirst();
        if (itemStack2.isEmpty()) {
            return itemStack.getMaxStackSize();
        }
        if (mctech.utils.c.h.d(itemStack2, itemStack)) {
            return mctech.utils.c.h.b(itemStack2);
        }
        return 0;
    }

    protected void a(int i, ItemStack itemStack, ItemStack itemStack2) {
        switch (g()) {
            case LAVA:
                if (i > 1 && !mctech.utils.c.h.d(itemStack, itemStack2)) {
                    this.g = 0.0f;
                    break;
                }
                break;
        }
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.g;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return this.m;
    }

    private void i() {
        int iFill;
        if (getInventoryHandler().t() && clock(20) && this.f.getFluidAmount() > 0 && this.level != null) {
            for (Direction direction : Direction.values()) {
                BlockPos blockPosRelative = this.worldPosition.relative(direction);
                IFluidHandler iFluidHandler = (IFluidHandler) this.level.getCapability(Capabilities.FluidHandler.BLOCK, blockPosRelative, direction.getOpposite());
                if (!(this.level.getBlockEntity(blockPosRelative) instanceof aa) && !(this.level.getBlockEntity(blockPosRelative) instanceof C0069p)) {
                    mctech.m.e.a aVarD = getInventoryHandler().d(direction);
                    if (iFluidHandler != null && ((aVarD == mctech.m.e.a.EXPORT || aVarD == mctech.m.e.a.BOTH) && (iFill = iFluidHandler.fill(new FluidStack(this.f.getFluid().getFluid(), Math.min(this.f.getFluidAmount(), 1000)), IFluidHandler.FluidAction.EXECUTE)) > 0)) {
                        this.f.drain(iFill, IFluidHandler.FluidAction.EXECUTE);
                        setChanged();
                        return;
                    }
                }
            }
        }
    }

    private boolean a(ItemStack itemStack) {
        return itemStack.is(Tags.Items.STONES) || itemStack.is(Tags.Items.COBBLESTONES);
    }

    @Override // mctech.blockentities.t
    public void a() {
        this.c = this.n.g();
    }

    @Override // mctech.api.tiles.readers.IFuelStorage
    public int getFuel() {
        return this.j;
    }

    @Override // mctech.api.tiles.readers.IFuelStorage
    public int getMaxFuel() {
        return this.k;
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
        return new aA(this, player, i);
    }

    @Override // mctech.i.g
    @NotNull
    public mctech.i.c g() {
        return (mctech.i.c) getBlockState().getValue(mctech.i.c.d);
    }

    @Override // mctech.i.g
    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T1;
    }

    @Override // mctech.i.g
    public float e() {
        return this.f.getFluidAmount();
    }

    @Override // mctech.i.g
    public float f() {
        return this.f.getCapacity();
    }

    @Override // mctech.api.tiles.IFluidMachine
    public IFluidHandler getConnectedTank(@NotNull Direction direction) {
        return provide(direction, getInventoryHandler(), (IFluidHandler) this.f);
    }

    @Override // mctech.api.network.tile.INetworkFluidTankFillListener
    @Nullable
    public IFluidHandler getFluidHandler(int i) {
        return this.f;
    }
}
