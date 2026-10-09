package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import mctech.blockentities.c.ae;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
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
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/F.class */
public class F extends mctech.blocks.b {
    public F(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) this.stateDefinition.any().setValue(FACING, Direction.NORTH)).setValue(mctech.i.i.m, mctech.i.i.TRANSFORMATION_ASSEMBLER));
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
        return MCTechCodecs.TRANSFORMATION_ASSEMBLER_BLOCK_CODEC;
    }

    @Override // mctech.blocks.base.e
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override // mctech.blocks.base.e
    public List<ItemStack> getDrops(BlockState blockState, LootParams.Builder builder) {
        BlockEntity blockEntity = (BlockEntity) builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockEntity instanceof ae) {
            ae aeVar = (ae) blockEntity;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ItemStack(this));
            for (int i = 0; i < aeVar.getSlotCount(); i++) {
                ItemStack stackInSlot = aeVar.getStackInSlot(i);
                if (!stackInSlot.isEmpty()) {
                    arrayList.add(stackInSlot.copy());
                }
            }
            return arrayList;
        }
        return super.getDrops(blockState, builder);
    }

    @Override // mctech.blocks.base.e
    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return ((BlockEntityType) MCTechTiles.TRANSFORMATION_ASSEMBLER.get()).create(blockPos, blockState);
    }

    @Override // mctech.blocks.base.e
    public void onNeighborChange(@NotNull BlockState blockState, @NotNull LevelReader levelReader, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        super.onNeighborChange(blockState, levelReader, blockPos, blockPos2);
        BlockEntity blockEntity = levelReader.getBlockEntity(blockPos);
        if (blockEntity instanceof ae) {
            ((ae) blockEntity).a();
        }
    }

    @Override // mctech.blocks.base.e
    public void neighborChanged(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Block block, @NotNull BlockPos blockPos2, boolean z) {
        super.neighborChanged(blockState, level, blockPos, block, blockPos2, z);
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof ae) {
            ((ae) blockEntity).a();
        }
    }
}
