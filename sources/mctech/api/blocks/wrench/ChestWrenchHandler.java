package mctech.api.blocks.wrench;

import mctech.api.blocks.IWrenchable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/wrench/ChestWrenchHandler.class */
public class ChestWrenchHandler extends HorizontalWrenchHandler {
    public static final IWrenchable INSTANCE = new ChestWrenchHandler();

    @Override // mctech.api.blocks.wrench.HorizontalWrenchHandler, mctech.api.blocks.IWrenchable
    public boolean canSetFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction) {
        return (!blockState.hasProperty(ChestBlock.TYPE) || blockState.getValue(ChestBlock.TYPE) == ChestType.SINGLE) && direction.getAxis().isHorizontal() && blockState.getValue(HorizontalDirectionalBlock.FACING) != direction;
    }
}
