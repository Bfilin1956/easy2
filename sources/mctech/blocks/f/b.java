package mctech.blocks.f;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.blocks.base.e;
import mctech.init.MCTechProperties;
import mctech.items.base.f;
import mctech.items.base.g;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/f/b.class */
public class b extends e implements mctech.blocks.base.b<mctech.blockentities.d> {
    public static final DirectionProperty a = MCTechProperties.HORIZONTAL_FACINGS;
    public static final MapCodec<b> b = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(propertiesCodec()).apply(instance, b::new);
    });
    private static final VoxelShape d = a();
    public static final IntegerProperty c = MCTechProperties.ACTIVE_0_3;

    public b() {
        this(mctech.blocks.b.b.noTerrainParticles());
        registerDefaultState((BlockState) defaultBlockState().setValue(a, Direction.NORTH));
    }

    public b(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) defaultBlockState().setValue(c, 0));
    }

    @Override // mctech.blocks.base.a
    public g createItem() {
        return new f(this);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{c, a});
    }

    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return d;
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) defaultBlockState().setValue(a, a(blockPlaceContext));
    }

    protected Direction a(BlockPlaceContext blockPlaceContext) {
        return blockPlaceContext.getHorizontalDirection().getOpposite();
    }

    @Override // mctech.blocks.base.b
    public void a(Level level, BlockPos blockPos, BlockState blockState, mctech.blockentities.d dVar) {
        dVar.setState((BlockState) blockState.setValue(c, Integer.valueOf(dVar.f())));
    }

    @Override // mctech.blocks.base.e
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    public static String a(int i) {
        switch (i) {
            case 0:
                return "empty";
            case 1:
                return "missing";
            case 2:
                return "charging";
            default:
                return "charged";
        }
    }

    public static int b(int i) {
        switch (i) {
            case 0:
                return 3;
            case 1:
                return 4;
            case 2:
                return 1;
            case 3:
                return 0;
            default:
                return 0;
        }
    }

    protected MapCodec<? extends BaseEntityBlock> codec() {
        return b;
    }

    private static VoxelShape a() {
        return Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.empty(), Shapes.box(0.0d, 0.0d, 0.0d, 1.0d, 0.25d, 1.0d), BooleanOp.OR), Shapes.box(0.125d, 0.25d, 0.125d, 0.875d, 0.9375d, 0.875d), BooleanOp.OR), Shapes.box(0.9375d, 0.25d, 0.125d, 0.9375d, 0.9375d, 0.875d), BooleanOp.OR), Shapes.box(0.5d, 0.25d, 0.5625d, 0.5d, 0.9375d, 1.3125d), BooleanOp.OR), Shapes.box(0.0625d, 0.25d, 0.125d, 0.0625d, 0.9375d, 0.875d), BooleanOp.OR), Shapes.box(0.0d, 0.25d, 0.0d, 0.125d, 0.875d, 0.125d), BooleanOp.OR), Shapes.box(0.503125d, 0.25d, -0.3125d, 0.503125d, 0.9375d, 0.4375d), BooleanOp.OR), Shapes.box(0.75d, 0.875d, 0.0d, 1.0d, 1.0d, 1.0d), BooleanOp.OR), Shapes.box(0.25d, 0.875d, 0.0d, 0.75d, 1.0d, 0.25d), BooleanOp.OR), Shapes.box(0.25d, 0.875d, 0.75d, 0.75d, 1.0d, 1.0d), BooleanOp.OR), Shapes.box(0.0d, 0.875d, 0.0d, 0.25d, 1.0d, 1.0d), BooleanOp.OR), Shapes.box(0.875d, 0.25d, 0.0d, 1.0d, 0.875d, 0.125d), BooleanOp.OR), Shapes.box(0.0d, 0.25d, 0.875d, 0.125d, 0.875d, 1.0d), BooleanOp.OR), Shapes.box(0.875d, 0.25d, 0.875d, 1.0d, 0.875d, 1.0d), BooleanOp.OR);
    }
}
