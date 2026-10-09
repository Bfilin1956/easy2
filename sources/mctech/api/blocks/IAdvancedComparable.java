package mctech.api.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/IAdvancedComparable.class */
public interface IAdvancedComparable {
    int getComparatorInputOverride(BlockState blockState, Level level, BlockPos blockPos, Direction direction);
}
