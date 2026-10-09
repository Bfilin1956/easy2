package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import java.util.ArrayList;
import java.util.List;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechTiles;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootParams;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/t.class */
public class t extends mctech.p.b.a.a<mctech.blockentities.c.E, mctech.p.b.b> {
    public t(BlockBehaviour.Properties properties) {
        super(properties, MCTechTiles.MOLECULAR_CONVERTER, MCTechTiles.MOLECULAR_CONVERTER_TEMPLATE);
        registerDefaultState((BlockState) defaultBlockState().setValue(mctech.i.i.m, mctech.i.i.MOLECULAR_CONVERTER));
    }

    @Override // mctech.p.b.a.a, mctech.p.b.a
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{mctech.i.i.m});
    }

    @Override // mctech.p.b.a
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return MCTechCodecs.MOLECULAR_CONVERTER_BLOCK_CODEC;
    }

    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return a(blockState) ? RenderShape.ENTITYBLOCK_ANIMATED : RenderShape.INVISIBLE;
    }

    @NotNull
    public List<ItemStack> getDrops(@NotNull BlockState blockState, LootParams.Builder builder) {
        return new ArrayList();
    }
}
