package mctech.blocks.f;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.api.blocks.IBlockDropProvider;
import mctech.blockentities.q;
import mctech.blocks.base.blocks.BaseActivityBlock;
import mctech.blocks.base.blocks.BaseFacingBlock;
import mctech.items.base.f;
import mctech.items.base.g;
import mctech.v.c.a.h;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/f/d.class */
public class d extends BaseActivityBlock<q> implements h {
    public static final MapCodec<d> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(IBlockDropProvider.CODEC.fieldOf("drop").forGetter((v0) -> {
            return v0.getDropProvider();
        })).apply(instance, d::new);
    });
    private static final VoxelShape[] b = new VoxelShape[6];

    static {
        b[0] = Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.empty(), Shapes.box(0.0625d, 0.0625d, 0.0625d, 0.9375d, 0.9375d, 0.9375d), BooleanOp.OR), Shapes.box(0.0d, 0.0d, 0.0d, 0.0625d, 1.0d, 1.0d), BooleanOp.OR), Shapes.box(0.3125d, 0.875d, 0.0d, 0.6875d, 1.0d, 1.0d), BooleanOp.OR), Shapes.box(0.125d, 0.125d, 0.0d, 0.875d, 0.875d, 1.0d), BooleanOp.OR), Shapes.box(0.3125d, 0.0d, 0.0d, 0.6875d, 0.125d, 1.0d), BooleanOp.OR), Shapes.box(0.9375d, 0.0d, 0.0d, 1.0d, 1.0d, 1.0d), BooleanOp.OR);
        b[1] = Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.join(Shapes.empty(), Shapes.box(0.0625d, 0.0625d, 0.0625d, 0.9375d, 0.9375d, 0.9375d), BooleanOp.OR), Shapes.box(0.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0625d), BooleanOp.OR), Shapes.box(0.0d, 0.875d, 0.3125d, 1.0d, 1.0d, 0.6875d), BooleanOp.OR), Shapes.box(0.0d, 0.125d, 0.125d, 1.0d, 0.875d, 0.875d), BooleanOp.OR), Shapes.box(0.0d, 0.0d, 0.3125d, 1.0d, 0.125d, 0.6875d), BooleanOp.OR), Shapes.box(0.0d, 0.0d, 0.9375d, 1.0d, 1.0d, 1.0d), BooleanOp.OR);
    }

    public d(IBlockDropProvider iBlockDropProvider) {
        super(c.b.noTerrainParticles());
        setDropProvider(iBlockDropProvider);
    }

    @Override // mctech.blocks.base.e
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    /* JADX INFO: renamed from: mctech.blocks.f.d$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/f/d$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Direction.values().length];

        static {
            try {
                a[Direction.NORTH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Direction.SOUTH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Direction.UP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[Direction.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        switch (AnonymousClass1.a[blockState.getValue(BaseFacingBlock.FACING).ordinal()]) {
            case 1:
            case 2:
                return b[0];
            case 3:
                return b[0];
            case 4:
                return b[0];
            default:
                return b[1];
        }
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

    @Override // mctech.blocks.base.blocks.BaseFacingBlock, mctech.blocks.base.a
    public g createItem() {
        return new f(this);
    }
}
