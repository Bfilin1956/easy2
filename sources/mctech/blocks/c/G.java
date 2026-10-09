package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import javax.annotation.Nullable;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/G.class */
public class G extends mctech.blocks.b {
    public static final MapCodec<mctech.blocks.b> c = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(propertiesCodec()).apply(instance, G::new);
    });
    private static final VoxelShape g = a();
    public static BooleanProperty d = BooleanProperty.create("busy");
    public static BooleanProperty e = BooleanProperty.create("disabled");
    public static IntegerProperty f = IntegerProperty.create("mode", 0, 2);

    public G(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) this.stateDefinition.any().setValue(d, false)).setValue(e, false)).setValue(f, 0));
    }

    public boolean onDestroyedByPlayer(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, boolean z, @NotNull FluidState fluidState) {
        if (blockState.hasProperty(d) && ((Boolean) blockState.getOptionalValue(d).orElse(false)).booleanValue()) {
            return false;
        }
        return super.onDestroyedByPlayer(blockState, level, blockPos, player, z, fluidState);
    }

    @Override // mctech.blocks.base.blocks.BaseActivityBlock, mctech.blocks.base.blocks.BaseFacingBlock
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(new Property[]{d, e, f}));
    }

    @Override // mctech.blocks.base.blocks.BaseFacingBlock
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) ((BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())).setValue(d, false)).setValue(e, false)).setValue(f, 0);
    }

    @Override // mctech.blocks.base.e
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Override // mctech.blocks.b
    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return c;
    }

    @NotNull
    protected VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return g;
    }

    @Override // mctech.blocks.base.e
    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return ((BlockEntityType) MCTechTiles.VENDING_MACHINE.get()).create(blockPos, blockState);
    }

    private static VoxelShape a() {
        return Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.empty(), Shapes.box(0.0625d, 0.0625d, 0.0625d, 0.9375d, 0.9375d, 0.9375d), BooleanOp.OR), Shapes.box(0.0d, 0.0d, 0.0d, 0.25d, 0.25d, 0.25d), BooleanOp.OR), Shapes.box(0.75d, 0.0d, 0.0d, 1.0d, 0.25d, 0.25d), BooleanOp.OR), Shapes.box(0.75d, 0.0d, 0.75d, 1.0d, 0.25d, 1.0d), BooleanOp.OR), Shapes.box(0.0d, 0.0d, 0.75d, 0.25d, 0.25d, 1.0d), BooleanOp.OR), Shapes.box(0.75d, 0.75d, 0.75d, 1.0d, 1.0d, 1.0d), BooleanOp.OR), Shapes.box(0.0d, 0.75d, 0.0d, 0.25d, 1.0d, 0.25d), BooleanOp.OR), Shapes.box(0.75d, 0.75d, 0.0d, 1.0d, 1.0d, 0.25d), BooleanOp.OR), Shapes.box(0.0d, 0.75d, 0.75d, 0.25d, 1.0d, 1.0d), BooleanOp.OR);
    }
}
