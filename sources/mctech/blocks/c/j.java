package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import javax.annotation.Nullable;
import mctech.blockentities.c.C0070q;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.fluids.SimpleFluidContent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/j.class */
public class j extends mctech.blocks.b implements mctech.i.h {
    public static final VoxelShape c = Block.box(2.0d, 0.0d, 2.0d, 14.0d, 16.0d, 14.0d);
    private final MachineTier d;

    public j(MachineTier machineTier, BlockBehaviour.Properties properties) {
        super(properties);
        this.d = machineTier;
        registerDefaultState((BlockState) this.stateDefinition.any().setValue(MachineTier.PROPERTY, this.d));
    }

    @Override // mctech.blocks.base.blocks.BaseActivityBlock, mctech.blocks.base.blocks.BaseFacingBlock
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{MachineTier.PROPERTY});
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) defaultBlockState().setValue(MachineTier.PROPERTY, this.d);
    }

    public MachineTier machineTier() {
        return this.d;
    }

    @Override // mctech.i.h
    public mctech.i.i d() {
        return mctech.i.i.FLUID_TANK;
    }

    @Override // mctech.i.h
    public MachineTier a(@NotNull BlockState blockState) {
        return blockState.getValue(MachineTier.PROPERTY);
    }

    @Override // mctech.i.h
    public mctech.i.i b(@NotNull BlockState blockState) {
        return (mctech.i.i) blockState.getValue(mctech.i.i.m);
    }

    @Override // mctech.i.h
    @NotNull
    public String V_() {
        return String.format("%s_fluid_tank", machineTier().getSerializedName());
    }

    @Override // mctech.i.h
    @NotNull
    public String c(@NotNull BlockState blockState) {
        return String.format("%s_fluid_tank", a(blockState).getSerializedName());
    }

    @Override // mctech.blocks.b
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return MCTechCodecs.TANK_BLOCK_CODEC;
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
    public List<ItemStack> getDrops(BlockState blockState, LootParams.Builder builder) {
        BlockEntity blockEntity = (BlockEntity) builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockEntity instanceof C0070q) {
            C0070q c0070q = (C0070q) blockEntity;
            ItemStack itemStack = new ItemStack(this);
            if (!c0070q.i().getFluid().isEmpty()) {
                itemStack.set(MCTechDataComponent.TANK_CONTENT, SimpleFluidContent.copyOf(c0070q.i().getFluid()));
            }
            IntStream intStream = c0070q.getInventoryHandler().h().intStream();
            Objects.requireNonNull(c0070q);
            ArrayList arrayList = new ArrayList(intStream.mapToObj(c0070q::getStackInSlot).filter(itemStack2 -> {
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
        return ((BlockEntityType) MCTechTiles.FLUID_TANK.get()).create(blockPos, blockState);
    }
}
