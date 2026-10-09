package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/C.class */
public class C extends mctech.blocks.b {
    private static final VoxelShape c = a();

    public C(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) this.stateDefinition.any().setValue(FACING, Direction.NORTH)).setValue(mctech.i.i.m, mctech.i.i.QUANTUM_WORKBENCH));
    }

    @Override // mctech.blocks.base.blocks.BaseActivityBlock, mctech.blocks.base.blocks.BaseFacingBlock
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{mctech.i.i.m});
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) ((BlockState) defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())).setValue(ACTIVE, false);
    }

    @Override // mctech.blocks.b
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return MCTechCodecs.QUANTUM_WORKBENCH_BLOCK_CODEC;
    }

    @Override // mctech.blocks.base.e
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @NotNull
    protected VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return c;
    }

    @Override // mctech.blocks.base.e
    @NotNull
    public List<ItemStack> getDrops(@NotNull BlockState blockState, LootParams.Builder builder) {
        mctech.m.a.g gVar = (BlockEntity) builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (gVar instanceof mctech.m.a.g) {
            mctech.m.a.g gVar2 = gVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ItemStack(this));
            arrayList.addAll(gVar2.U_().toList());
            return arrayList;
        }
        return super.getDrops(blockState, builder);
    }

    @Override // mctech.blocks.base.e
    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return ((BlockEntityType) MCTechTiles.QUANTUM_WORKBENCH.get()).create(blockPos, blockState);
    }

    private static VoxelShape a() {
        return Shapes.join(Shapes.join(Shapes.empty(), Shapes.box(0.0625d, 0.0d, 0.0625d, 0.9375d, 0.25d, 0.9375d), BooleanOp.OR), Shapes.box(0.15625d, 0.25d, 0.15625d, 0.84375d, 0.75d, 0.84375d), BooleanOp.OR);
    }
}
