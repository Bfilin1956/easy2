package mctech.blocks.base.blocks;

import mctech.blockentities.q;
import mctech.blocks.base.e;
import mctech.init.MCTechProperties;
import mctech.items.base.g;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/blocks/BaseFacingBlock.class */
public abstract class BaseFacingBlock<T extends q> extends e {
    public static final DirectionProperty FACING = MCTechProperties.ALL_FACINGS;

    public BaseFacingBlock(BlockBehaviour.Properties properties) {
        super(properties);
        setDefaultState();
    }

    protected void setDefaultState() {
        registerDefaultState((BlockState) defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
    }

    @Override // mctech.blocks.base.a
    public g createItem() {
        return new g(this);
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) defaultBlockState().setValue(FACING, getFacing(blockPlaceContext));
    }

    protected Direction getFacing(BlockPlaceContext blockPlaceContext) {
        return blockPlaceContext.getHorizontalDirection().getOpposite();
    }

    protected void setPlaceData(q qVar, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
    }

    public boolean hasRotation(BlockState blockState) {
        return true;
    }

    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.hasProperty(FACING) ? (BlockState) blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING))) : blockState;
    }

    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.hasProperty(FACING) ? (BlockState) blockState.setValue(FACING, mirror.mirror(blockState.getValue(FACING))) : blockState;
    }

    public Direction getRotation(BlockState blockState) {
        return blockState.getValue(FACING);
    }
}
