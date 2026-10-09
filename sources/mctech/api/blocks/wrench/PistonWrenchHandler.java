package mctech.api.blocks.wrench;

import mctech.api.blocks.IWrenchable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/wrench/PistonWrenchHandler.class */
public class PistonWrenchHandler extends BaseWrenchHandler {
    public static final IWrenchable INSTANCE = new PistonWrenchHandler();

    @Override // mctech.api.blocks.IWrenchable
    public Direction getFacing(BlockState blockState, Level level, BlockPos blockPos) {
        return blockState.getValue(PistonBaseBlock.FACING);
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean canSetFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction) {
        return (blockState.getValue(PistonBaseBlock.FACING) == direction || ((Boolean) blockState.getValue(PistonBaseBlock.EXTENDED)).booleanValue()) ? false : true;
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean setFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction) {
        return !((Boolean) blockState.getValue(PistonBaseBlock.EXTENDED)).booleanValue() && level.setBlockAndUpdate(blockPos, (BlockState) blockState.setValue(PistonBaseBlock.FACING, direction));
    }

    @Override // mctech.api.blocks.wrench.BaseWrenchHandler, mctech.api.blocks.IWrenchable
    public boolean canRemoveBlock(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        return true;
    }

    @Override // mctech.api.blocks.wrench.BaseWrenchHandler, mctech.api.blocks.IWrenchable
    public double getDropRate(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        return 1.0d;
    }
}
