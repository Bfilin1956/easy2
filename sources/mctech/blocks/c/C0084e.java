package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import javax.annotation.Nullable;
import mctech.blockentities.c.C0058e;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
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

/* JADX INFO: renamed from: mctech.blocks.c.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/e.class */
public class C0084e extends mctech.blocks.b {
    public C0084e(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) this.stateDefinition.any().setValue(FACING, Direction.NORTH)).setValue(mctech.i.i.m, mctech.i.i.ATOMIC_SMELTER));
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
        return MCTechCodecs.ATOMIC_SMELTER_BLOCK_CODEC;
    }

    @Override // mctech.blocks.base.e
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override // mctech.blocks.base.e
    public List<ItemStack> getDrops(BlockState blockState, LootParams.Builder builder) {
        BlockEntity blockEntity = (BlockEntity) builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockEntity instanceof C0058e) {
            C0058e c0058e = (C0058e) blockEntity;
            ItemStack itemStack = new ItemStack(this);
            IntStream intStream = c0058e.getInventoryHandler().h().intStream();
            Objects.requireNonNull(c0058e);
            ArrayList arrayList = new ArrayList(intStream.mapToObj(c0058e::getStackInSlot).filter(itemStack2 -> {
                return !itemStack2.isEmpty();
            }).toList());
            arrayList.add(itemStack);
            return arrayList;
        }
        return super.getDrops(blockState, builder);
    }

    @Override // mctech.blocks.base.e
    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return ((BlockEntityType) MCTechTiles.ATOMIC_SMELTER.get()).create(blockPos, blockState);
    }
}
