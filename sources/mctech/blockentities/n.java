package mctech.blockentities;

import javax.annotation.Nullable;
import mctech.api.features.IWrenchRemovable;
import mctech.api.features.redstone.IComparable;
import mctech.api.reactor.IChamberReactor;
import mctech.api.reactor.IReactor;
import mctech.api.reactor.IReactorChamber;
import mctech.api.tiles.IFluidMachine;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.VoidFluidHandler;
import net.neoforged.neoforge.items.IItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/n.class */
public abstract class n extends q implements IWrenchRemovable, IReactorChamber, IFluidMachine {
    private MachineTier a;

    public n(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, MachineTier machineTier) {
        super(blockEntityType, blockPos, blockState);
        this.a = machineTier;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.75d;
    }

    @Override // mctech.blockentities.q
    public void onLoaded() {
        super.onLoaded();
        IReactor reactor = getReactor();
        if (reactor instanceof IChamberReactor) {
            ((IChamberReactor) reactor).refreshChambers();
        }
    }

    @Override // mctech.blockentities.q
    public void onUnloaded(boolean z) {
        if (isSimulating()) {
        }
        IReactor reactor = getReactor();
        if (reactor instanceof IChamberReactor) {
            ((IChamberReactor) reactor).refreshChambers();
        }
        super.onUnloaded(z);
    }

    @Override // mctech.blockentities.q
    public void onBlockUpdate(Block block, BlockPos blockPos) {
        super.onBlockUpdate(block, blockPos);
        IReactor reactor = getReactor();
        if (reactor == null) {
            return;
        }
        reactor.getLevel().neighborChanged(reactor.getPosition(), getBlockState().getBlock(), blockPos);
    }

    @Override // mctech.blockentities.q, mctech.api.features.redstone.IComparable
    public mctech.blocks.base.a.a.c getManager() {
        IReactor reactor = getReactor();
        if (reactor instanceof IComparable) {
            return ((IComparable) reactor).getManager();
        }
        return null;
    }

    @Nullable
    public IItemHandler a(Direction direction) {
        IReactor reactor = getReactor();
        if (reactor instanceof m) {
            return ((m) reactor).getItemHandler(direction);
        }
        return null;
    }

    @Override // mctech.api.tiles.IFluidMachine
    @Nullable
    public IFluidHandler getConnectedTank(@Nullable Direction direction) {
        if (this.level == null) {
            return VoidFluidHandler.INSTANCE;
        }
        IReactor reactor = getReactor();
        if (reactor instanceof m) {
            return ((m) reactor).getConnectedTank(direction);
        }
        return null;
    }
}
