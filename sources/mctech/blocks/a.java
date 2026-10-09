package mctech.blocks;

import mctech.api.blocks.IBlockDropProvider;
import mctech.blockentities.q;
import mctech.blocks.base.blocks.BaseFacingBlock;
import mctech.blocks.c.o;
import mctech.init.MCTechProperties;
import mctech.items.base.g;
import mctech.v.c.a.h;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/a.class */
public abstract class a<T extends q> extends mctech.blocks.base.e implements mctech.blocks.base.b<T>, o, h {
    public a(IBlockDropProvider iBlockDropProvider) {
        super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(5.0f, 25.0f).requiresCorrectToolForDrops().noOcclusion());
        setDropProvider(iBlockDropProvider);
        a();
    }

    protected void a() {
        registerDefaultState((BlockState) ((BlockState) defaultBlockState().setValue(BaseFacingBlock.FACING, Direction.NORTH)).setValue(MCTechProperties.ACTIVE, false));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BaseFacingBlock.FACING, MCTechProperties.ACTIVE});
    }

    @Override // mctech.blocks.base.a
    public g createItem() {
        return new g((Block) this, new Item.Properties());
    }

    public BlockState getStateForPlacement(@NotNull BlockPlaceContext blockPlaceContext) {
        return (BlockState) defaultBlockState().setValue(BaseFacingBlock.FACING, a(blockPlaceContext));
    }

    protected Direction a(BlockPlaceContext blockPlaceContext) {
        return blockPlaceContext.getHorizontalDirection().getOpposite();
    }

    public void setPlacedBy(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState, LivingEntity livingEntity, @NotNull ItemStack itemStack) {
    }

    protected void a(q qVar, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
    }

    @Override // mctech.v.c.a.h
    public boolean hasRotation(BlockState blockState) {
        return true;
    }

    @NotNull
    public BlockState rotate(BlockState blockState, @NotNull Rotation rotation) {
        return blockState.hasProperty(BaseFacingBlock.FACING) ? (BlockState) blockState.setValue(BaseFacingBlock.FACING, rotation.rotate(blockState.getValue(BaseFacingBlock.FACING))) : blockState;
    }

    @NotNull
    public BlockState mirror(@NotNull BlockState blockState, @NotNull Mirror mirror) {
        return blockState.hasProperty(BaseFacingBlock.FACING) ? (BlockState) blockState.setValue(BaseFacingBlock.FACING, mirror.mirror(blockState.getValue(BaseFacingBlock.FACING))) : blockState;
    }

    @Override // mctech.v.c.a.h
    public Direction getRotation(BlockState blockState) {
        return blockState.getValue(BaseFacingBlock.FACING);
    }

    @Override // mctech.blocks.base.b
    public void a(Level level, BlockPos blockPos, BlockState blockState, T t) {
        t.withState(BaseFacingBlock.FACING, t.getFacing());
    }
}
