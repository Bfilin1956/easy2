package mctech.blockentities.b;

import java.util.Iterator;
import mctech.api.energy.tile.IEnergySource;
import mctech.api.energy.tile.IEnergyTile;
import mctech.api.reactor.IReactor;
import mctech.api.util.DirectionList;
import mctech.blockentities.n;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/f.class */
public class f extends n implements IEnergyTile {
    public IReactor a;

    public f(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.REACTOR_CHAMBER.get(), blockPos, blockState);
    }

    public f(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, blockState.getValue(MachineTier.PROPERTY));
    }

    @NotNull
    public BlockEntityType<?> getType() {
        return (BlockEntityType) MCTechTiles.REACTOR_CHAMBER.get();
    }

    @Override // mctech.api.reactor.IReactorChamber
    public IReactor getReactor() {
        if (this.a != null && this.a.isRemoved()) {
            this.a = null;
        }
        if (this.a == null) {
            Iterator<Direction> it = DirectionList.ALL.iterator();
            while (it.hasNext()) {
                IReactor neighborTile = DirectionList.getNeighborTile(this, it.next());
                if ((neighborTile instanceof IReactor) && (neighborTile instanceof IEnergySource)) {
                    this.a = neighborTile;
                }
            }
        }
        return this.a;
    }

    @Override // mctech.blockentities.q, mctech.api.features.IWrenchableTile
    public void setFacing(Direction direction) {
    }
}
