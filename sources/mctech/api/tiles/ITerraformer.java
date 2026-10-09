package mctech.api.tiles;

import mctech.api.util.ILocation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/ITerraformer.class */
public interface ITerraformer extends ILocation {
    boolean setBiome(Level level, BlockPos blockPos, ResourceLocation resourceLocation);

    default Holder<Biome> getBiome(Level level, BlockPos blockPos) {
        return level.getBiome(blockPos);
    }

    default BlockPos getFirstSolidBlockFrom(Level level, BlockPos blockPos) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos().set(blockPos);
        while (mutableBlockPos.getY() > -1) {
            if (level.getBlockState(mutableBlockPos).isRedstoneConductor(level, mutableBlockPos)) {
                return mutableBlockPos.immutable();
            }
            mutableBlockPos.move(Direction.DOWN);
        }
        return mutableBlockPos.immutable();
    }

    default BlockPos getFirstBlockFrom(Level level, BlockPos blockPos) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos().set(blockPos);
        while (mutableBlockPos.getY() > 0) {
            if (!level.isEmptyBlock(mutableBlockPos)) {
                return mutableBlockPos.immutable();
            }
            mutableBlockPos.move(Direction.DOWN);
        }
        mutableBlockPos.setY(-1);
        return mutableBlockPos.immutable();
    }

    default boolean switchGround(Level level, BlockPos blockPos, BlockState blockState, BlockState blockState2, boolean z, boolean z2) {
        if (z) {
            BlockPos.MutableBlockPos withOffset = new BlockPos.MutableBlockPos().setWithOffset(blockPos, Direction.UP);
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos().set(blockPos);
            BlockPos blockPosImmutable = withOffset.immutable();
            while (true) {
                if (!level.isEmptyBlock(mutableBlockPos)) {
                    BlockState blockState3 = level.getBlockState(mutableBlockPos);
                    if (blockState3.getBlock() != blockState.getBlock() || (z2 && blockState3 != blockState)) {
                        break;
                    }
                    withOffset.move(Direction.DOWN);
                    mutableBlockPos.move(Direction.DOWN);
                }
            }
            if (withOffset.getY() == blockPosImmutable.getY()) {
                return false;
            }
            level.setBlockAndUpdate(withOffset.immutable(), blockState2);
            return true;
        }
        BlockPos.MutableBlockPos mutableBlockPos2 = new BlockPos.MutableBlockPos().set(blockPos);
        while (true) {
            if (!level.isEmptyBlock(mutableBlockPos2)) {
                BlockState blockState4 = level.getBlockState(mutableBlockPos2);
                if (blockState4.getBlock() != blockState2.getBlock() || (z2 && blockState4 != blockState)) {
                    break;
                }
                mutableBlockPos2.move(Direction.DOWN);
            }
        }
        if (mutableBlockPos2.getY() < 0 || level.isEmptyBlock(mutableBlockPos2)) {
            return false;
        }
        BlockState blockState5 = level.getBlockState(mutableBlockPos2);
        if (blockState5.getBlock() != blockState.getBlock()) {
            return false;
        }
        if (z2 && blockState5 != blockState) {
            return false;
        }
        level.setBlockAndUpdate(mutableBlockPos2.immutable(), blockState2);
        return true;
    }
}
