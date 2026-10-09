package mctech.api.blocks.wrench;

import mctech.api.blocks.IWrenchable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/wrench/PillarWrenchHandler.class */
public class PillarWrenchHandler extends BaseWrenchHandler {
    public static final IWrenchable INSTANCE = new PillarWrenchHandler();

    /* JADX INFO: renamed from: mctech.api.blocks.wrench.PillarWrenchHandler$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/wrench/PillarWrenchHandler$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$core$Direction$Axis = new int[Direction.Axis.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$core$Direction$Axis[Direction.Axis.X.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction$Axis[Direction.Axis.Y.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction$Axis[Direction.Axis.Z.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Override // mctech.api.blocks.IWrenchable
    public Direction getFacing(BlockState blockState, Level level, BlockPos blockPos) {
        switch (AnonymousClass1.$SwitchMap$net$minecraft$core$Direction$Axis[blockState.getValue(RotatedPillarBlock.AXIS).ordinal()]) {
            case 1:
                return Direction.EAST;
            case 2:
                return Direction.UP;
            case 3:
                return Direction.SOUTH;
            default:
                return null;
        }
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean canSetFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction) {
        return blockState.getValue(RotatedPillarBlock.AXIS) != direction.getAxis();
    }

    @Override // mctech.api.blocks.IWrenchable
    public boolean setFacing(BlockState blockState, Level level, BlockPos blockPos, Player player, Direction direction) {
        return level.setBlockAndUpdate(blockPos, (BlockState) blockState.setValue(RotatedPillarBlock.AXIS, direction.getAxis()));
    }
}
