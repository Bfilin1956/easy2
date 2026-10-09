package mctech.blocks.b;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.api.blocks.IBlockDropProvider;
import mctech.blocks.base.blocks.BaseFacingBlock;
import mctech.init.MCTechProperties;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/b/g.class */
public class g extends BaseFacingBlock<mctech.blockentities.b.j> {
    public static final MapCodec<g> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(propertiesCodec()).apply(instance, g::new);
    });
    public static final IntegerProperty b = MCTechProperties.ACTIVE_0_2;

    public g(BlockBehaviour.Properties properties) {
        super(properties);
        setDropProvider(IBlockDropProvider.SELF_OR_GENERATOR);
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    protected void setDefaultState() {
        registerDefaultState((BlockState) ((BlockState) defaultBlockState().setValue(FACING, Direction.NORTH)).setValue(b, 0));
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{b});
    }

    protected MapCodec<? extends BaseEntityBlock> codec() {
        return a;
    }
}
