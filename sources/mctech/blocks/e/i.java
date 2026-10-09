package mctech.blocks.e;

import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/e/i.class */
public class i extends mctech.blocks.base.d implements BonemealableBlock {
    public static final VoxelShape a = Block.box(2.0d, 0.0d, 2.0d, 14.0d, 12.0d, 14.0d);
    private static ConfiguredFeature<?, ?> d;

    public i() {
        super(BlockBehaviour.Properties.of().sound(SoundType.GRASS).randomTicks());
    }

    @Override // mctech.blocks.base.a
    public mctech.items.base.g createItem() {
        return new mctech.items.a.c(this);
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (!a(serverLevel.getBlockState(blockPos))) {
            Block.dropResources(blockState, serverLevel, blockPos);
            serverLevel.setBlockAndUpdate(blockPos, Blocks.AIR.defaultBlockState());
        } else if (serverLevel.getMaxLocalRawBrightness(blockPos.above()) >= 9 && randomSource.nextInt(7) == 0) {
            performBonemeal(serverLevel, randomSource, blockPos, blockState);
        }
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return a;
    }

    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return Shapes.empty();
    }

    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        serverLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 4);
        if (d == null) {
            Optional optional = serverLevel.registryAccess().lookupOrThrow(Registries.CONFIGURED_FEATURE).get(ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.parse("mctech_rubber_tree_sapling")));
            if (optional.isPresent() && !((ConfiguredFeature) ((Holder.Reference) optional.get()).value()).place(serverLevel, serverLevel.getChunkSource().getGenerator(), randomSource, blockPos)) {
                d = (ConfiguredFeature) ((Holder.Reference) optional.get()).value();
                serverLevel.setBlock(blockPos, blockState, 4);
                return;
            }
            return;
        }
        if (d.place(serverLevel, serverLevel.getChunkSource().getGenerator(), randomSource, blockPos)) {
            serverLevel.setBlock(blockPos, blockState, 4);
        }
    }

    protected boolean a(BlockState blockState) {
        Block block = blockState.getBlock();
        return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.FARMLAND;
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        return blockState.canSurvive(levelAccessor, blockPos) ? blockState : Blocks.AIR.defaultBlockState();
    }

    @Override // mctech.blocks.base.d
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        if (blockState.getBlock() == this) {
            return !levelReader.getBlockState(blockPos).canSustainPlant(levelReader, blockPos, Direction.UP, blockState).isFalse();
        }
        return a(levelReader.getBlockState(blockPos));
    }
}
