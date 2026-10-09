package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import javax.annotation.Nullable;
import mctech.blockentities.c.C0069p;
import mctech.blockentities.c.aa;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/i.class */
public class i extends mctech.blocks.b {
    private final MachineTier c;
    private final mctech.i.c d;

    public i(MachineTier machineTier, mctech.i.c cVar, BlockBehaviour.Properties properties) {
        super(properties);
        this.c = machineTier;
        this.d = cVar;
        registerDefaultState((BlockState) ((BlockState) ((BlockState) this.stateDefinition.any().setValue(mctech.i.i.m, mctech.i.i.FLUID_GENERATOR)).setValue(MachineTier.PROPERTY, machineTier)).setValue(mctech.i.c.d, cVar));
    }

    @Override // mctech.blocks.base.blocks.BaseActivityBlock, mctech.blocks.base.blocks.BaseFacingBlock
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{mctech.i.i.m, MachineTier.PROPERTY, mctech.i.c.d});
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) ((BlockState) defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())).setValue(ACTIVE, false);
    }

    @Override // mctech.blocks.b
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return MCTechCodecs.FLUID_GENERATOR_BLOCK_CODEC;
    }

    @Override // mctech.blocks.base.e
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @NotNull
    public static String a(MachineTier machineTier, mctech.i.c cVar) {
        return String.format("%s_%s_generator", machineTier.name, cVar.c);
    }

    @Override // mctech.blocks.base.e
    public List<ItemStack> getDrops(BlockState blockState, LootParams.Builder builder) {
        BlockEntity blockEntity = (BlockEntity) builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockEntity instanceof C0069p) {
            C0069p c0069p = (C0069p) blockEntity;
            ItemStack itemStack = new ItemStack(this);
            IntStream intStream = c0069p.getInventoryHandler().h().intStream();
            Objects.requireNonNull(c0069p);
            ArrayList arrayList = new ArrayList(intStream.mapToObj(c0069p::getStackInSlot).filter(itemStack2 -> {
                return !itemStack2.isEmpty();
            }).toList());
            arrayList.add(itemStack);
            return arrayList;
        }
        if (blockEntity instanceof aa) {
            aa aaVar = (aa) blockEntity;
            ItemStack itemStack3 = new ItemStack(this);
            IntStream intStream2 = aaVar.getInventoryHandler().h().intStream();
            Objects.requireNonNull(aaVar);
            ArrayList arrayList2 = new ArrayList(intStream2.mapToObj(aaVar::getStackInSlot).filter(itemStack4 -> {
                return !itemStack4.isEmpty();
            }).toList());
            arrayList2.add(itemStack3);
            return arrayList2;
        }
        return super.getDrops(blockState, builder);
    }

    @Override // mctech.blocks.base.e
    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return (this.c == MachineTier.T1 ? (BlockEntityType) MCTechTiles.STONE_FLUID_GENERATOR.get() : (BlockEntityType) MCTechTiles.FLUID_GENERATOR.get()).create(blockPos, blockState);
    }

    public MachineTier a() {
        return this.c;
    }

    public mctech.i.c b() {
        return this.d;
    }
}
