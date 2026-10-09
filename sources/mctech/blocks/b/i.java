package mctech.blocks.b;

import mctech.init.MCTechBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/b/i.class */
public class i extends Block {
    public static final IntegerProperty a = IntegerProperty.create("offset_x", 0, 2);
    public static final IntegerProperty b = IntegerProperty.create("offset_y", 0, 2);
    public static final IntegerProperty c = IntegerProperty.create("offset_z", 0, 2);

    public i() {
        super(BlockBehaviour.Properties.of().noOcclusion().noTerrainParticles().strength(-1.0f, 3600000.0f).noLootTable().lightLevel(blockState -> {
            return 0;
        }).isRedstoneConductor((blockState2, blockGetter, blockPos) -> {
            return false;
        }));
        registerDefaultState((BlockState) ((BlockState) ((BlockState) this.stateDefinition.any().setValue(a, 0)).setValue(b, 0)).setValue(c, 0));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{a, b, c});
    }

    public static int a(int i) {
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            default:
                return 0;
        }
    }

    public static int b(int i) {
        switch (i) {
            case mctech.utils.math.a.b /* -1 */:
                return 1;
            case 1:
                return 2;
            default:
                return 0;
        }
    }

    public static BlockPos a(BlockState blockState, BlockPos blockPos) {
        return blockPos.offset(a(((Integer) blockState.getValue(a)).intValue()), a(((Integer) blockState.getValue(b)).intValue()), a(((Integer) blockState.getValue(c)).intValue()));
    }

    public static BlockState a(BlockPos blockPos, BlockPos blockPos2) {
        return (BlockState) ((BlockState) ((BlockState) ((i) MCTechBlocks.THERMONUCLEAR_REACTOR_DUMMY.get()).defaultBlockState().setValue(a, Integer.valueOf(b(Mth.clamp(blockPos.getX() - blockPos2.getX(), -1, 1))))).setValue(b, Integer.valueOf(b(Mth.clamp(blockPos.getY() - blockPos2.getY(), -1, 1))))).setValue(c, Integer.valueOf(b(Mth.clamp(blockPos.getZ() - blockPos2.getZ(), -1, 1))));
    }

    @Nullable
    public PushReaction getPistonPushReaction(@NotNull BlockState blockState) {
        return PushReaction.IGNORE;
    }

    @NotNull
    protected ItemInteractionResult useItemOn(@NotNull ItemStack itemStack, @NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        BlockPos blockPosA = a(blockState, blockPos);
        if (!level.isLoaded(blockPosA)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        BlockState blockState2 = level.getBlockState(blockPosA);
        h block = blockState2.getBlock();
        if (block instanceof h) {
            return block.useItemOn(itemStack, blockState2, level, blockPosA, player, interactionHand, new BlockHitResult(blockHitResult.getLocation(), blockHitResult.getDirection(), blockPosA, blockHitResult.isInside()));
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @NotNull
    protected InteractionResult useWithoutItem(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult blockHitResult) {
        BlockPos blockPosA = a(blockState, blockPos);
        if (!level.isLoaded(blockPosA)) {
            return InteractionResult.PASS;
        }
        BlockState blockState2 = level.getBlockState(blockPosA);
        h block = blockState2.getBlock();
        if (block instanceof h) {
            return block.useWithoutItem(blockState2, level, blockPosA, player, new BlockHitResult(blockHitResult.getLocation(), blockHitResult.getDirection(), blockPosA, blockHitResult.isInside()));
        }
        return InteractionResult.PASS;
    }

    protected void onRemove(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState2, boolean z) {
        BlockPos blockPosA = a(blockState, blockPos);
        if (!level.isLoaded(blockPosA)) {
            return;
        }
        BlockState blockState3 = level.getBlockState(blockPosA);
        h block = blockState3.getBlock();
        if (block instanceof h) {
            block.onRemove(blockState3, level, blockPosA, blockState2, z);
            level.removeBlock(blockPosA, false);
        }
    }

    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.INVISIBLE;
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return getCollisionShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @NotNull
    public VoxelShape getCollisionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return Shapes.box(0.0d, 0.0d, 0.0d, 1.0d, ((Integer) blockState.getValue(b)).intValue() == 0 ? 1.0d : 0.3375d, 1.0d);
    }

    @NotNull
    protected VoxelShape getInteractionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return getCollisionShape(blockState, blockGetter, blockPos, CollisionContext.empty());
    }

    @NotNull
    protected VoxelShape getVisualShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return Shapes.empty();
    }

    @NotNull
    public VoxelShape getOcclusionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return Shapes.empty();
    }

    @NotNull
    public ItemStack getCloneItemStack(@NotNull BlockState blockState, @NotNull HitResult hitResult, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos, @NotNull Player player) {
        BlockState blockState2 = levelReader.getBlockState(a(blockState, blockPos));
        if (blockState2.getBlock() instanceof h) {
            return new ItemStack(blockState2.getBlock());
        }
        return ItemStack.EMPTY;
    }
}
