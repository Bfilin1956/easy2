package mctech.blocks.base.blocks;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import mctech.blocks.b;
import mctech.init.MCTechCodecs;
import net.mcskill.msregistry.core.MachineTier;
import net.mcskill.msregistry.registry.holder.LBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/blocks/a.class */
public class a extends b {
    public static final MapCodec<a> c = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(propertiesCodec(), MCTechCodecs.MACHINE_TIER_CODEC.fieldOf("machineTier").forGetter((v0) -> {
            return v0.a();
        })).apply(instance, a::new);
    });
    private final MachineTier d;
    private LBlockEntity<?> e;

    public a(BlockBehaviour.Properties properties, MachineTier machineTier) {
        super(properties);
        this.d = machineTier;
        registerDefaultState((BlockState) ((BlockState) this.stateDefinition.any().setValue(FACING, Direction.NORTH)).setValue(MachineTier.PROPERTY, a()));
    }

    public a a(LBlockEntity<?> lBlockEntity) {
        this.e = lBlockEntity;
        return this;
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) ((BlockState) defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())).setValue(ACTIVE, false);
    }

    @Override // mctech.blocks.base.blocks.BaseActivityBlock, mctech.blocks.base.blocks.BaseFacingBlock
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(new Property[]{MachineTier.PROPERTY}));
    }

    @Override // mctech.blocks.b
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return c;
    }

    @Override // mctech.blocks.base.e
    @NotNull
    public List<ItemStack> getDrops(@NotNull BlockState blockState, LootParams.Builder builder) {
        ResourceKey lootTable = getLootTable();
        if (lootTable == BuiltInLootTables.EMPTY) {
            return Collections.emptyList();
        }
        LootParams lootParamsCreate = builder.withParameter(LootContextParams.BLOCK_STATE, blockState).create(LootContextParamSets.BLOCK);
        return lootParamsCreate.getLevel().getServer().reloadableRegistries().getLootTable(lootTable).getRandomItems(lootParamsCreate);
    }

    @Override // mctech.blocks.base.e
    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return ((BlockEntityType) this.e.get()).create(blockPos, blockState);
    }

    public MachineTier a() {
        return this.d;
    }
}
