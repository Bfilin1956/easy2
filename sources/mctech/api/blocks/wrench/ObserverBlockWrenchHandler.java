package mctech.api.blocks.wrench;

import mctech.api.blocks.IWrenchable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ObserverBlock;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/wrench/ObserverBlockWrenchHandler.class */
public class ObserverBlockWrenchHandler extends BaseWrenchHandler {
    public static final IWrenchable INSTANCE = new ObserverBlockWrenchHandler();

    @Override // mctech.api.blocks.IWrenchable
    public Direction getFacing(BlockState blockState, Level level, BlockPos blockPos) {
        return blockState.getValue(ObserverBlock.FACING);
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean canSetFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction) {
        return blockState.getValue(ObserverBlock.FACING) != direction;
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean setFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction) {
        return level.setBlockAndUpdate(blockPos, (BlockState) blockState.setValue(ObserverBlock.FACING, direction));
    }
}
