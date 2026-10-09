package mctech.blocks.c;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import mctech.init.MCTechTiles;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/B.class */
public class B extends mctech.blocks.b {
    public static final int c = 8;
    public static final int d = 0;
    public static final int e = 7;
    public static final IntegerProperty f = BlockStateProperties.LEVEL_COMPOSTER;
    private static final VoxelShape g = Shapes.block();
    private static final VoxelShape[] h = (VoxelShape[]) Util.make(new VoxelShape[9], voxelShapeArr -> {
        for (int i = 0; i < 8; i++) {
            voxelShapeArr[i] = Shapes.join(g, Block.box(2.0d, Math.max(2, 1 + (i * 2)), 2.0d, 14.0d, 16.0d, 14.0d), BooleanOp.ONLY_FIRST);
        }
        voxelShapeArr[8] = voxelShapeArr[7];
    });

    public B(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) defaultBlockState().setValue(f, 0));
    }

    @NotNull
    protected VoxelShape getShape(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return h[((Integer) blockState.getValue(f)).intValue()];
    }

    @NotNull
    protected VoxelShape getInteractionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return g;
    }

    @NotNull
    protected VoxelShape getCollisionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return h[0];
    }

    @Override // mctech.blocks.base.e
    @NotNull
    public List<ItemStack> getDrops(@NotNull BlockState blockState, LootParams.Builder builder) {
        mctech.m.e.e eVar = (BlockEntity) builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (eVar instanceof mctech.m.e.e) {
            mctech.m.e.e eVar2 = eVar;
            if (eVar instanceof mctech.m.a.g) {
                mctech.m.a.g gVar = (mctech.m.a.g) eVar;
                ItemStack itemStack = new ItemStack(this);
                IntStream intStream = eVar2.getInventoryHandler().h().intStream();
                Objects.requireNonNull(gVar);
                ArrayList arrayList = new ArrayList(intStream.mapToObj(gVar::getStackInSlot).filter(itemStack2 -> {
                    return !itemStack2.isEmpty();
                }).toList());
                arrayList.add(itemStack);
                return arrayList;
            }
        }
        return super.getDrops(blockState, builder);
    }

    @Override // mctech.blocks.base.blocks.BaseActivityBlock, mctech.blocks.base.blocks.BaseFacingBlock
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(new Property[]{f}));
    }

    public void handlePrecipitation(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, Biome.Precipitation precipitation) {
        super.handlePrecipitation(blockState, level, blockPos, precipitation);
    }

    @Override // mctech.blocks.base.e
    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return ((BlockEntityType) MCTechTiles.QUANTUM_COMPOSTER.get()).create(blockPos, blockState);
    }
}
