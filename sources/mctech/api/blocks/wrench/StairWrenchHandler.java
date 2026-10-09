package mctech.api.blocks.wrench;

import mctech.api.blocks.IWrenchable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/wrench/StairWrenchHandler.class */
public class StairWrenchHandler extends BaseWrenchHandler {
    public static final IWrenchable INSTANCE = new StairWrenchHandler();

    @Override // mctech.api.blocks.IWrenchable
    public Direction getFacing(BlockState blockState, Level level, BlockPos blockPos) {
        return blockState.getValue(StairBlock.FACING).getOpposite();
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean canSetFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction) {
        if (!direction.getAxis().isVertical()) {
            return blockState.getValue(StairBlock.FACING).getOpposite() != direction;
        }
        if (direction == Direction.DOWN) {
            return blockState.getValue(StairBlock.HALF) == Half.TOP;
        }
        return blockState.getValue(StairBlock.HALF) == Half.BOTTOM;
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean setFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction) {
        if (direction.getAxis().isVertical()) {
            return level.setBlockAndUpdate(blockPos, (BlockState) blockState.setValue(StairBlock.HALF, direction == Direction.UP ? Half.TOP : Half.BOTTOM));
        }
        return level.setBlockAndUpdate(blockPos, (BlockState) blockState.setValue(StairBlock.FACING, direction.getOpposite()));
    }
}
