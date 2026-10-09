package mctech.blocks.base.a;

import mctech.init.MCTechProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/e.class */
public interface e extends BucketPickup, LiquidBlockContainer {
    default boolean a(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, Fluid fluid) {
        return !((Boolean) blockState.getValue(MCTechProperties.LAVA_LOGGED)).booleanValue() && fluid == Fluids.LAVA;
    }

    default boolean placeLiquid(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, FluidState fluidState) {
        if (!((Boolean) blockState.getValue(MCTechProperties.LAVA_LOGGED)).booleanValue() && fluidState.getType() == Fluids.LAVA) {
            if (!levelAccessor.isClientSide()) {
                levelAccessor.setBlock(blockPos, (BlockState) blockState.setValue(MCTechProperties.LAVA_LOGGED, Boolean.TRUE), 3);
                levelAccessor.scheduleTick(blockPos, fluidState.getType(), fluidState.getType().getTickDelay(levelAccessor));
                return true;
            }
            return true;
        }
        return false;
    }

    default Fluid a(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState) {
        if (((Boolean) blockState.getValue(MCTechProperties.LAVA_LOGGED)).booleanValue()) {
            levelAccessor.setBlock(blockPos, (BlockState) blockState.setValue(MCTechProperties.LAVA_LOGGED, Boolean.FALSE), 3);
            return Fluids.LAVA;
        }
        return Fluids.EMPTY;
    }
}
