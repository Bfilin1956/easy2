package mctech.blocks.base.a;

import mctech.init.MCTechProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/d.class */
public interface d extends e, SimpleWaterloggedBlock {
    @Override // mctech.blocks.base.a.e
    default boolean a(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, Fluid fluid) {
        return (fluid != Fluids.LAVA || a(blockState)) && !((Boolean) blockState.getValue(MCTechProperties.LAVA_LOGGED)).booleanValue() && !((Boolean) blockState.getValue(BlockStateProperties.WATERLOGGED)).booleanValue() && (fluid == Fluids.LAVA || fluid == Fluids.WATER);
    }

    default boolean a(BlockState blockState) {
        return true;
    }

    @Override // mctech.blocks.base.a.e
    default boolean placeLiquid(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, FluidState fluidState) {
        if (a(levelAccessor, blockPos, blockState, fluidState.getType())) {
            if (!levelAccessor.isClientSide()) {
                levelAccessor.setBlock(blockPos, (BlockState) blockState.setValue(fluidState.getType() == Fluids.LAVA ? MCTechProperties.LAVA_LOGGED : BlockStateProperties.WATERLOGGED, true), 3);
                levelAccessor.scheduleTick(blockPos, fluidState.getType(), fluidState.getType().getTickDelay(levelAccessor));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // mctech.blocks.base.a.e
    default Fluid a(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState) {
        if (a(blockState) && ((Boolean) blockState.getValue(MCTechProperties.LAVA_LOGGED)).booleanValue()) {
            levelAccessor.setBlock(blockPos, (BlockState) blockState.setValue(MCTechProperties.LAVA_LOGGED, false), 3);
            return Fluids.LAVA;
        }
        if (((Boolean) blockState.getValue(BlockStateProperties.WATERLOGGED)).booleanValue()) {
            levelAccessor.setBlock(blockPos, (BlockState) blockState.setValue(BlockStateProperties.WATERLOGGED, false), 3);
            return Fluids.WATER;
        }
        return Fluids.EMPTY;
    }

    default ItemStack b(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState) {
        if (((Boolean) blockState.getValue(BlockStateProperties.WATERLOGGED)).booleanValue()) {
            levelAccessor.setBlock(blockPos, (BlockState) blockState.setValue(BlockStateProperties.WATERLOGGED, false), 3);
            if (!blockState.canSurvive(levelAccessor, blockPos)) {
                levelAccessor.destroyBlock(blockPos, true);
            }
            return new ItemStack(Items.WATER_BUCKET);
        }
        if (a(blockState) && ((Boolean) blockState.getValue(MCTechProperties.LAVA_LOGGED)).booleanValue()) {
            levelAccessor.setBlock(blockPos, (BlockState) blockState.setValue(MCTechProperties.LAVA_LOGGED, false), 3);
            if (!blockState.canSurvive(levelAccessor, blockPos)) {
                levelAccessor.destroyBlock(blockPos, true);
            }
            return new ItemStack(Items.LAVA_BUCKET);
        }
        return ItemStack.EMPTY;
    }

    static FluidState b(BlockState blockState) {
        if (blockState.hasProperty(BlockStateProperties.WATERLOGGED) && ((Boolean) blockState.getValue(BlockStateProperties.WATERLOGGED)).booleanValue()) {
            return Fluids.WATER.defaultFluidState();
        }
        return (blockState.hasProperty(MCTechProperties.LAVA_LOGGED) && ((Boolean) blockState.getValue(MCTechProperties.LAVA_LOGGED)).booleanValue()) ? Fluids.LAVA.defaultFluidState() : Fluids.EMPTY.defaultFluidState();
    }
}
