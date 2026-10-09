package mctech.d;

import java.util.function.Predicate;
import mctech.api.util.DirectionList;
import mctech.api.util.ILocation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.BlockCapability;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/d/c.class */
public class c<T> extends a<T> {
    BlockCapability<T, Direction> f;
    Predicate<BlockEntity> g;

    public c(ILocation iLocation, DirectionList directionList, BlockCapability<T, Direction> blockCapability, Predicate<BlockEntity> predicate) {
        super(iLocation, directionList);
        this.f = blockCapability;
        this.g = predicate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.d.d
    public void d() {
        Object capability;
        Level level = this.a.getLevel();
        BlockPos position = this.a.getPosition();
        for (Direction direction : this.e.invert().remove(this.b.invert())) {
            BlockEntity neighborTile = DirectionList.getNeighborTile(level, position, direction);
            if (neighborTile != null && this.g.test(neighborTile) && (capability = this.f.getCapability(level, neighborTile.getBlockPos(), neighborTile.getBlockState(), neighborTile, direction.getOpposite())) != null) {
                a(direction, capability);
            }
        }
    }
}
