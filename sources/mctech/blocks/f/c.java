package mctech.blocks.f;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.api.blocks.IBlockDropProvider;
import mctech.blockentities.f;
import mctech.blocks.base.blocks.BaseFacingBlock;
import mctech.init.MCTechProperties;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/f/c.class */
public class c extends BaseFacingBlock<f> {
    public static final MapCodec<c> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(IBlockDropProvider.CODEC.fieldOf("drop").forGetter((v0) -> {
            return v0.getDropProvider();
        })).apply(instance, c::new);
    });
    public static final BlockBehaviour.Properties b = BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1.5f, 7.5f).requiresCorrectToolForDrops();
    public static final IntegerProperty c = MCTechProperties.ACTIVE_0_3;

    public c(IBlockDropProvider iBlockDropProvider) {
        super(b);
        setDropProvider(iBlockDropProvider);
        registerDefaultState((BlockState) ((BlockState) defaultBlockState().setValue(FACING, Direction.NORTH)).setValue(c, 0));
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{c});
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    protected Direction getFacing(BlockPlaceContext blockPlaceContext) {
        if (blockPlaceContext.getPlayer() == null) {
            return Direction.NORTH;
        }
        int iRound = Math.round(blockPlaceContext.getPlayer().getXRot());
        if (iRound >= 65) {
            return Direction.UP;
        }
        return iRound <= -65 ? Direction.DOWN : blockPlaceContext.getHorizontalDirection().getOpposite();
    }

    protected MapCodec<? extends BaseEntityBlock> codec() {
        return a;
    }
}
