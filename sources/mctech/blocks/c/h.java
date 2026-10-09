package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.blocks.base.blocks.BaseFacingBlock;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/h.class */
public class h extends BaseEntityBlock {
    public h(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) defaultBlockState().setValue(BaseFacingBlock.FACING, Direction.NORTH));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(new Property[]{BaseFacingBlock.FACING}));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) defaultBlockState().setValue(BaseFacingBlock.FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
    }

    @NotNull
    protected ItemInteractionResult useItemOn(@NotNull ItemStack itemStack, @NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos.relative(Direction.DOWN));
        if (blockEntity instanceof mctech.blockentities.c.a.b) {
            mctech.blockentities.c.a.b bVar = (mctech.blockentities.c.a.b) blockEntity;
            if (player.isShiftKeyDown()) {
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }
            return ((MCTech.PLATFORM.h() && bVar.a(player, interactionHand, blockHitResult.getDirection())) || MCTech.PLATFORM.a(player, interactionHand, blockHitResult.getDirection(), bVar)) ? ItemInteractionResult.SUCCESS : ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return MCTechCodecs.FARMING_STATION_CULTIVATOR_BLOCK_CODEC;
    }

    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return ((BlockEntityType) MCTechTiles.FARMING_STATION_CULTIVATOR.get()).create(blockPos, blockState);
    }
}
