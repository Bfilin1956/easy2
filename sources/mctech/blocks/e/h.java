package mctech.blocks.e;

import java.util.List;
import mctech.api.blocks.PainterHelper;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/e/h.class */
public class h extends mctech.blocks.base.d implements mctech.v.c.a.b {
    public static final DirectionProperty a = MCTechProperties.HORIZONTAL_FACINGS;
    public static final BooleanProperty d = BooleanProperty.create("resin");
    public static final BooleanProperty e = BooleanProperty.create("collectable");
    public static final EnumProperty<Direction.Axis> f = RotatedPillarBlock.AXIS;
    private boolean g;

    public h(boolean z) {
        super(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(1.0f, 5.0f).randomTicks());
        registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(f, Direction.Axis.Y)).setValue(d, false)).setValue(e, false)).setValue(a, Direction.NORTH));
        this.g = z;
    }

    @Override // mctech.blocks.base.a
    public mctech.items.base.g createItem() {
        return new mctech.items.base.g(this);
    }

    public BlockState getToolModifiedState(BlockState blockState, UseOnContext useOnContext, ItemAbility itemAbility, boolean z) {
        if (itemAbility == ItemAbilities.AXE_STRIP && !this.g && useOnContext.getItemInHand().canPerformAction(itemAbility)) {
            return PainterHelper.copyProperties(blockState, ((mctech.blocks.base.d) MCTechBlocks.RUBBER_LOG_STRIPPED.get()).defaultBlockState());
        }
        return super.getToolModifiedState(blockState, useOnContext, itemAbility, z);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{a, d, e, f});
    }

    public void destroy(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState) {
        if (levelAccessor.isAreaLoaded(blockPos, 5)) {
            for (BlockPos blockPos2 : BlockPos.betweenClosed(blockPos.offset(-4, -4, -4), blockPos.offset(4, 4, 4))) {
                if (levelAccessor.getBlockState(blockPos2).is(BlockTags.LEAVES)) {
                    Blocks.AIR.defaultBlockState().updateNeighbourShapes(levelAccessor, blockPos2, 2);
                }
            }
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) defaultBlockState().setValue(f, blockPlaceContext.getClickedFace().getAxis());
    }

    @Override // mctech.blocks.base.d
    public void a(List<ItemStack> list, BlockState blockState, ItemStack itemStack, RandomSource randomSource) {
    }

    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        a(blockState, serverLevel, blockPos, randomSource);
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        a(blockState, serverLevel, blockPos, randomSource);
    }

    public void a(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (((Boolean) blockState.getValue(d)).booleanValue() && !((Boolean) blockState.getValue(e)).booleanValue()) {
            if (randomSource.nextInt(200) == 0) {
                serverLevel.setBlockAndUpdate(blockPos, (BlockState) blockState.setValue(e, true));
            } else {
                serverLevel.scheduleTick(blockPos, this, 200 - 100);
            }
        }
    }

    @Override // mctech.v.c.a.b
    public boolean a(BlockState blockState, Direction direction) {
        Direction.Axis value = blockState.getValue(f);
        return value != Direction.Axis.Y && (value == Direction.Axis.X || direction == Direction.EAST || direction == Direction.WEST);
    }

    @Override // mctech.v.c.a.b
    public int b(BlockState blockState, Direction direction) {
        Direction.Axis value = blockState.getValue(f);
        if (value == Direction.Axis.Y) {
            return 0;
        }
        return (value == Direction.Axis.X || direction == Direction.EAST || direction == Direction.WEST) ? 90 : 0;
    }

    @Override // mctech.v.c.a.b
    public boolean c(BlockState blockState, Direction direction) {
        return false;
    }

    @Override // mctech.v.c.a.b
    public float[] d(BlockState blockState, Direction direction) {
        return null;
    }

    public int getFlammability(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        return 20;
    }

    public int getFireSpreadSpeed(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        return 4;
    }

    public PushReaction getPistonPushReaction(BlockState blockState) {
        if (((Boolean) blockState.getValue(d)).booleanValue()) {
            return PushReaction.DESTROY;
        }
        return null;
    }
}
