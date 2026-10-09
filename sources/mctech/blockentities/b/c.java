package mctech.blockentities.b;

import mctech.MCTech;
import mctech.api.features.IClickable;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IFluidMachine;
import mctech.api.util.DirectionList;
import mctech.init.MCTechFluids;
import mctech.m.b.K;
import mctech.m.b.S;
import mctech.m.c.r;
import mctech.m.g.y;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/c.class */
public class c extends mctech.blockentities.g implements IClickable, IFluidMachine, IFluidHandler {

    @NetworkInfo(fieldName = "maxFuel")
    public int h;
    mctech.d.d<IFluidHandler> i;

    public c(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 3);
        this.h = 24000;
        this.c = 20;
        this.d = MCTech.CONFIG.geothermalOutput.get();
        this.i = new mctech.d.b(this, DirectionList.ALL, Capabilities.FluidHandler.BLOCK);
        this.inventoryManager.a().a(y.c(0)).a(y.a(1).a(new mctech.m.c.f(Fluids.LAVA, (Fluid) MCTechFluids.BLAZING_LAVA.get())).b(r.c)).a(y.d(2)).i();
    }

    @Override // mctech.api.tiles.readers.IFuelStorage
    public int getMaxFuel() {
        return this.h;
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new K(this, player, i);
    }

    @Override // mctech.api.features.IClickable
    public boolean onRightClick(Player player, InteractionHand interactionHand, Direction direction, BlockHitResult blockHitResult) {
        return mctech.utils.c.b.a(player.getItemInHand(interactionHand), player, this);
    }

    @Override // mctech.api.tiles.IFluidMachine
    public IFluidHandler getConnectedTank(Direction direction) {
        return provide(direction, this.i, getInventoryHandler(), this);
    }

    @Override // mctech.blockentities.g
    public boolean c() {
        return this.a <= 23000;
    }

    @Override // mctech.api.tiles.readers.IEUProducer
    public float getEUProduction() {
        if (this.a > 0) {
            return this.d;
        }
        return 0.0f;
    }

    @Override // mctech.blockentities.g
    public boolean g() {
        return true;
    }

    @Override // mctech.blockentities.g
    public int i() {
        return 10;
    }

    public int getTanks() {
        return 1;
    }

    public FluidStack getFluidInTank(int i) {
        if (this.a == 0) {
            return FluidStack.EMPTY;
        }
        return new FluidStack(Fluids.LAVA, this.a);
    }

    public int getTankCapacity(int i) {
        return this.h;
    }

    public boolean isFluidValid(int i, FluidStack fluidStack) {
        return fluidStack.getFluid() == Fluids.LAVA || fluidStack.getFluid() == MCTechFluids.BLAZING_LAVA.get();
    }

    public int fill(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
        return 0;
    }

    public FluidStack drain(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
        if (fluidStack.getFluid() != Fluids.LAVA) {
            return FluidStack.EMPTY;
        }
        return drain(fluidStack.getAmount(), fluidAction);
    }

    public FluidStack drain(int i, IFluidHandler.FluidAction fluidAction) {
        return new FluidStack(Fluids.LAVA, 0);
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public void onPacketFailed() {
        if (this.b < this.c && this.a > 0) {
            this.b = Math.min(this.c, this.b + this.d);
            this.a--;
        }
    }
}
