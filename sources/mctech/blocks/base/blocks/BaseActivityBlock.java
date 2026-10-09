package mctech.blocks.base.blocks;

import mctech.blockentities.q;
import mctech.init.MCTechProperties;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/blocks/BaseActivityBlock.class */
public abstract class BaseActivityBlock<T extends q> extends BaseFacingBlock<T> {
    public static final BooleanProperty ACTIVE = MCTechProperties.ACTIVE;

    public BaseActivityBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    protected void setDefaultState() {
        registerDefaultState((BlockState) ((BlockState) defaultBlockState().setValue(FACING, Direction.NORTH)).setValue(ACTIVE, false));
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{ACTIVE});
    }
}
