package mctech.blocks.b;

import com.mojang.serialization.MapCodec;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/b/h.class */
public class h extends b {
    private static final List<BlockPos> d = List.of((Object[]) new BlockPos[]{new BlockPos(-1, 0, -1), new BlockPos(0, 0, -1), new BlockPos(1, 0, -1), new BlockPos(-1, 0, 0), new BlockPos(1, 0, 0), new BlockPos(-1, 0, 1), new BlockPos(0, 0, 1), new BlockPos(1, 0, 1), new BlockPos(-1, 1, -1), new BlockPos(0, 1, -1), new BlockPos(1, 1, -1), new BlockPos(-1, 1, 0), new BlockPos(0, 1, 0), new BlockPos(1, 1, 0), new BlockPos(-1, 1, 1), new BlockPos(0, 1, 1), new BlockPos(1, 1, 1)});
    public static VoxelShape c = a();

    public h(BlockBehaviour.Properties properties) {
        super(properties.sound(SoundType.METAL).strength(5.0f).noOcclusion());
    }

    @NotNull
    public InteractionResult useWithoutItem(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult blockHitResult) {
        return super.useWithoutItem(blockState, level, blockPos, player, blockHitResult);
    }

    protected boolean canSurvive(@NotNull BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos) {
        Iterator<BlockPos> it = d.iterator();
        while (it.hasNext()) {
            BlockPos blockPosOffset = blockPos.offset(it.next());
            if (!levelReader.getWorldBorder().isWithinBounds(blockPosOffset)) {
                return false;
            }
            BlockState blockState2 = levelReader.getBlockState(blockPosOffset);
            if (!blockState2.isAir() && !blockState2.canBeReplaced() && blockState2.getBlock() != this) {
                return false;
            }
        }
        return super.canSurvive(blockState, levelReader, blockPos);
    }

    public void setPlacedBy(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @Nullable LivingEntity livingEntity, @NotNull ItemStack itemStack) {
        super.setPlacedBy(level, blockPos, blockState, livingEntity, itemStack);
        if (!level.isClientSide) {
            Iterator<BlockPos> it = d.iterator();
            while (it.hasNext()) {
                BlockPos blockPosOffset = blockPos.offset(it.next());
                if (!blockPosOffset.equals(blockPos) && (level.isEmptyBlock(blockPosOffset) || level.getBlockState(blockPosOffset).canBeReplaced())) {
                    level.setBlock(blockPosOffset, i.a(blockPos, blockPosOffset), 3);
                    level.updateNeighborsAt(blockPosOffset, this);
                }
            }
        }
    }

    public void onRemove(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState2, boolean z) {
        if (!level.isClientSide) {
            Iterator<BlockPos> it = d.iterator();
            while (it.hasNext()) {
                BlockPos blockPosOffset = blockPos.offset(it.next());
                if (!blockPosOffset.equals(blockPos) && level.getBlockState(blockPosOffset).getBlock() == MCTechBlocks.THERMONUCLEAR_REACTOR_DUMMY.get()) {
                    level.removeBlock(blockPosOffset, false);
                }
            }
        }
        super.onRemove(blockState, level, blockPos, blockState2, z);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return c;
    }

    @NotNull
    public VoxelShape getCollisionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return c;
    }

    @NotNull
    public VoxelShape getOcclusionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return Shapes.empty();
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) ((BlockState) defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())).setValue(ACTIVE, false);
    }

    @Override // mctech.blocks.b.b
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return MCTechCodecs.THERMONUCLEAR_REACTOR;
    }

    @Override // mctech.blocks.base.e
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return ((BlockEntityType) MCTechTiles.THERMONUCLEAR_REACTOR.get()).create(blockPos, blockState);
    }

    private static VoxelShape a() {
        return Shapes.join(Shapes.join(Shapes.join(Shapes.empty(), Shapes.box(0.25d, 0.0d, -1.0d, 0.75d, 1.3375d, 2.0d), BooleanOp.OR), Shapes.box(-1.0d, 0.0d, 0.25d, 2.0d, 1.3375d, 0.75d), BooleanOp.OR), Shapes.box(-0.95d, 0.0d, -0.95d, 1.95d, 1.2d, 1.95d), BooleanOp.OR);
    }
}
