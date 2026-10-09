package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.blocks.c.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/g.class */
public class C0086g extends mctech.blocks.b implements SimpleWaterloggedBlock {
    private static final BooleanProperty c = BlockStateProperties.WATERLOGGED;

    public C0086g(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) getStateDefinition().any().setValue(c, false));
    }

    @Override // mctech.blocks.base.blocks.BaseActivityBlock, mctech.blocks.base.blocks.BaseFacingBlock
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(new Property[]{c}));
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())).setValue(ACTIVE, false)).setValue(c, Boolean.valueOf(blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos()).getType() == Fluids.WATER));
    }

    @Override // mctech.blocks.b
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return MCTechCodecs.FARMING_STATION_BLOCK_CODEC;
    }

    @Override // mctech.blocks.base.e
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override // mctech.blocks.base.e
    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return ((BlockEntityType) MCTechTiles.FARMING_STATION.get()).create(blockPos, blockState);
    }

    @NotNull
    protected FluidState getFluidState(BlockState blockState) {
        return ((Boolean) blockState.getValue(c)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, @NotNull Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (((Boolean) blockState.getValue(c)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }
}
