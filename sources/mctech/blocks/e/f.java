package mctech.blocks.e;

import mctech.api.blocks.PainterHelper;
import mctech.init.MCTechBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/e/f.class */
public class f extends mctech.blocks.base.d {
    private final boolean a;

    public f(boolean z) {
        super(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(1.0f, 5.0f).randomTicks());
        registerDefaultState((BlockState) defaultBlockState().setValue(h.f, Direction.Axis.Y));
        this.a = z;
    }

    @Override // mctech.blocks.base.a
    public mctech.items.base.g createItem() {
        return new mctech.items.base.g(this);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{h.f});
    }

    public BlockState getToolModifiedState(BlockState blockState, UseOnContext useOnContext, ItemAbility itemAbility, boolean z) {
        if (itemAbility == ItemAbilities.AXE_STRIP && !this.a && useOnContext.getItemInHand().canPerformAction(itemAbility)) {
            return PainterHelper.copyProperties(blockState, ((mctech.blocks.base.d) MCTechBlocks.RUBBER_LOG_BARKED_STRIPPED.get()).defaultBlockState());
        }
        return super.getToolModifiedState(blockState, useOnContext, itemAbility, z);
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) defaultBlockState().setValue(h.f, blockPlaceContext.getClickedFace().getAxis());
    }

    public int getFlammability(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        return 20;
    }

    public int getFireSpreadSpeed(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        return 4;
    }
}
