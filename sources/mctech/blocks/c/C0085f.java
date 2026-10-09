package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import javax.annotation.Nullable;
import mctech.blockentities.c.C0061h;
import mctech.blockentities.c.X;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
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

/* JADX INFO: renamed from: mctech.blocks.c.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/f.class */
public class C0085f extends mctech.blocks.b {
    private final MachineTier c;

    public C0085f(MachineTier machineTier, BlockBehaviour.Properties properties) {
        super(properties);
        this.c = machineTier;
        registerDefaultState((BlockState) ((BlockState) ((BlockState) this.stateDefinition.any().setValue(FACING, Direction.NORTH)).setValue(mctech.i.i.m, mctech.i.i.COBBLESTONE_GENERATOR)).setValue(MachineTier.PROPERTY, machineTier));
    }

    @Override // mctech.blocks.base.blocks.BaseActivityBlock, mctech.blocks.base.blocks.BaseFacingBlock
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{mctech.i.i.m, MachineTier.PROPERTY});
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) ((BlockState) defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())).setValue(ACTIVE, false);
    }

    @Override // mctech.blocks.b
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return MCTechCodecs.COBBLESTONE_GENERATOR_BLOCK_CODEC;
    }

    @Override // mctech.blocks.base.e
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override // mctech.blocks.base.e
    public List<ItemStack> getDrops(BlockState blockState, LootParams.Builder builder) {
        BlockEntity blockEntity = (BlockEntity) builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockEntity instanceof C0061h) {
            C0061h c0061h = (C0061h) blockEntity;
            ItemStack itemStack = new ItemStack(this);
            IntStream intStream = c0061h.getInventoryHandler().h().intStream();
            Objects.requireNonNull(c0061h);
            ArrayList arrayList = new ArrayList(intStream.mapToObj(c0061h::getStackInSlot).filter(itemStack2 -> {
                return !itemStack2.isEmpty();
            }).toList());
            arrayList.add(itemStack);
            return arrayList;
        }
        if (blockEntity instanceof X) {
            X x = (X) blockEntity;
            ItemStack itemStack3 = new ItemStack(this);
            IntStream intStream2 = x.getInventoryHandler().h().intStream();
            Objects.requireNonNull(x);
            ArrayList arrayList2 = new ArrayList(intStream2.mapToObj(x::getStackInSlot).filter(itemStack4 -> {
                return !itemStack4.isEmpty();
            }).toList());
            arrayList2.add(itemStack3);
            return arrayList2;
        }
        return super.getDrops(blockState, builder);
    }

    @Override // mctech.blocks.base.e
    public void onNeighborChange(BlockState blockState, LevelReader levelReader, BlockPos blockPos, BlockPos blockPos2) {
        super.onNeighborChange(blockState, levelReader, blockPos, blockPos2);
    }

    @Override // mctech.blocks.base.e
    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return (this.c == MachineTier.T1 ? (BlockEntityType) MCTechTiles.STONE_COBBLESTONE_GENERATOR.get() : (BlockEntityType) MCTechTiles.COBBLESTONE_GENERATOR.get()).create(blockPos, blockState);
    }

    public MachineTier a() {
        return this.c;
    }
}
