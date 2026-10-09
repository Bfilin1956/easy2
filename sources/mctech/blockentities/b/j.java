package mctech.blockentities.b;

import java.util.List;
import java.util.Map;
import mctech.MCTech;
import mctech.api.features.IAreaOfEffect;
import mctech.api.features.IClickable;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IFluidMachine;
import mctech.api.tiles.readers.IWorkProvider;
import mctech.m.b.S;
import mctech.m.b.aE;
import mctech.m.c.r;
import mctech.m.g.y;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/j.class */
public class j extends mctech.blockentities.g implements IAreaOfEffect, IClickable, IFluidMachine, IWorkProvider, IFluidHandler {
    static final int h = 30000000;
    static final int i = 29000000;
    static final int j = 1500000;
    static final int k = 1500;
    boolean l;

    @NetworkInfo(fieldName = "subProduction")
    public mctech.blocks.base.a.g m;
    boolean n;
    int o;

    public j(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 3);
        this.l = false;
        this.m = new mctech.blocks.base.a.g();
        this.n = false;
        this.o = -1;
        this.d = MCTech.CONFIG.thermalGenerator.getProduction();
        this.c = 8000;
        this.e = 2;
        this.inventoryManager.a().a(y.c(0)).a(y.a(1).a(new mctech.m.c.f(Fluids.LAVA)).b(r.c)).a(y.d(2).b(new mctech.m.c.k(new mctech.m.c.f(Fluids.LAVA)))).i();
    }

    @Override // mctech.blockentities.g
    protected boolean b() {
        return super.b() && !j();
    }

    @Override // mctech.api.features.IClickable
    public boolean onRightClick(Player player, InteractionHand interactionHand, Direction direction, BlockHitResult blockHitResult) {
        return mctech.utils.c.b.a(player.getItemInHand(interactionHand), player, this);
    }

    @Override // mctech.blockentities.g
    public boolean g() {
        return true;
    }

    @Override // mctech.blockentities.g
    public int i() {
        return 10;
    }

    @Override // mctech.api.features.IAreaOfEffect
    public AABB getAreaOfEffect() {
        return new AABB(this.worldPosition).inflate(7.0d);
    }

    @Override // mctech.api.features.IAreaOfEffect
    public int getAreaOfEffectColor() {
        return -2132855788;
    }

    @Override // mctech.api.features.IAreaOfEffect
    public void setVisualizationId(int i2) {
        this.o = i2;
    }

    @Override // mctech.api.features.IAreaOfEffect
    public int getVisualizationId() {
        return this.o;
    }

    public boolean j() {
        return this.l;
    }

    @Override // mctech.api.tiles.readers.IWorkProvider
    public boolean isWorking() {
        return this.m.b() > 0;
    }

    public void a(boolean z) {
        if (z != this.l) {
            this.l = z;
        }
    }

    @Override // mctech.api.tiles.readers.IFuelStorage
    public int getMaxFuel() {
        return 20000;
    }

    @Override // mctech.blockentities.g, mctech.api.tiles.readers.IFuelStorage
    public int getFuel() {
        return super.getFuel() / 1500;
    }

    @Override // mctech.blockentities.g
    public boolean c() {
        return this.a <= i;
    }

    @Override // mctech.api.tiles.readers.IEUProducer
    public float getEUProduction() {
        return this.a > 0 ? this.d * 3 : this.m.a(MCTech.CONFIG.thermalGenerator.getPassiveProduction());
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i2) {
        return new aE(this, player, i2);
    }

    @Override // mctech.blockentities.g, mctech.api.energy.tile.IEnergySource
    public int getMaxEnergyOutput() {
        return this.d * 3;
    }

    @Override // mctech.blockentities.g, mctech.api.energy.tile.IEnergySource
    public int getProvidedEnergy() {
        return Math.min(this.b, this.d * 3);
    }

    @Override // mctech.blockentities.g
    public boolean d() {
        return this.a > 0 && this.b + (this.d * 3) <= this.c;
    }

    @Override // mctech.blockentities.g
    protected void f() {
    }

    @Override // mctech.blockentities.g
    public boolean e() {
        return false;
    }

    public int getTanks() {
        return 1;
    }

    public FluidStack getFluidInTank(int i2) {
        return new FluidStack(Fluids.LAVA, this.a / 1500);
    }

    public int getTankCapacity(int i2) {
        return 20000;
    }

    public boolean isFluidValid(int i2, FluidStack fluidStack) {
        return fluidStack.getFluid() == Fluids.LAVA;
    }

    public FluidStack drain(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
        return FluidStack.EMPTY;
    }

    public FluidStack drain(int i2, IFluidHandler.FluidAction fluidAction) {
        return FluidStack.EMPTY;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/j$a.class */
    static class a implements mctech.utils.c.a.b {
        a() {
        }

        @Override // mctech.utils.c.a.InterfaceC0043a
        public boolean isValid(BlockState blockState) {
            return true;
        }

        @Override // mctech.utils.c.a.b
        public void a(LevelReader levelReader, BlockPos blockPos, Map<Block, List<BlockPos>> map) {
            BlockState blockState = levelReader.getBlockState(blockPos);
            blockState.getBlock();
            blockState.getFluidState().getType();
        }
    }

    @Override // mctech.api.tiles.IFluidMachine
    public IFluidHandler getConnectedTank(Direction direction) {
        return provide(direction, getInventoryHandler(), this);
    }

    public int fill(FluidStack fluidStack, IFluidHandler.FluidAction fluidAction) {
        return 0;
    }
}
