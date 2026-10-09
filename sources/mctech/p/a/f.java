package mctech.p.a;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/a/f.class */
public class f {
    public VoxelShape a;
    private final VoxelShape[] b;
    private final VoxelShape[] c;

    public f(VoxelShape voxelShape) {
        this.a = voxelShape;
        this.b = a(voxelShape);
        this.c = b(voxelShape);
    }

    public VoxelShape a(Direction direction, boolean z) {
        return (z ? this.c : this.b)[direction.get2DDataValue()];
    }

    public VoxelShape a(Direction direction) {
        return a(direction, false);
    }

    protected static VoxelShape[] a(VoxelShape voxelShape) {
        VoxelShape[] voxelShapeArr = new VoxelShape[4];
        voxelShapeArr[Direction.NORTH.get2DDataValue()] = voxelShape;
        voxelShapeArr[Direction.SOUTH.get2DDataValue()] = a(voxelShape, Direction.SOUTH);
        voxelShapeArr[Direction.WEST.get2DDataValue()] = a(voxelShape, Direction.WEST);
        voxelShapeArr[Direction.EAST.get2DDataValue()] = a(voxelShape, Direction.EAST);
        return voxelShapeArr;
    }

    protected static VoxelShape[] b(VoxelShape voxelShape) {
        return a(c(voxelShape));
    }

    public static VoxelShape a(VoxelShape voxelShape, Direction direction) {
        VoxelShape[] voxelShapeArr = {Shapes.empty()};
        voxelShape.forAllBoxes((d, d2, d3, d4, d5, d6) -> {
            double d;
            double d2;
            double d3;
            double d4;
            double d5 = d * 16.0d;
            double d6 = d2 * 16.0d;
            double d7 = d3 * 16.0d;
            double d8 = d4 * 16.0d;
            double d9 = d5 * 16.0d;
            double d10 = d6 * 16.0d;
            switch (AnonymousClass1.a[direction.ordinal()]) {
                case 1:
                    d = 16.0d - d8;
                    d2 = 16.0d - d10;
                    d3 = 16.0d - d5;
                    d4 = 16.0d - d7;
                    break;
                case 2:
                    d = d7;
                    d2 = 16.0d - d8;
                    d3 = d10;
                    d4 = 16.0d - d5;
                    break;
                case 3:
                    d = 16.0d - d10;
                    d2 = d5;
                    d3 = 16.0d - d7;
                    d4 = d8;
                    break;
                default:
                    d = d5;
                    d2 = d7;
                    d3 = d8;
                    d4 = d10;
                    break;
            }
            voxelShapeArr[0] = Shapes.or(voxelShapeArr[0], Block.box(Math.min(d, d3), d6, Math.min(d2, d4), Math.max(d, d3), d9, Math.max(d2, d4)));
        });
        return voxelShapeArr[0];
    }

    /* JADX INFO: renamed from: mctech.p.a.f$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/a/f$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Direction.values().length];

        static {
            try {
                a[Direction.SOUTH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Direction.WEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Direction.EAST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    protected static VoxelShape c(VoxelShape voxelShape) {
        VoxelShape[] voxelShapeArr = {Shapes.empty()};
        voxelShape.forAllBoxes((d, d2, d3, d4, d5, d6) -> {
            voxelShapeArr[0] = Shapes.or(voxelShapeArr[0], Block.box(16.0d - (d4 * 16.0d), d2 * 16.0d, d3 * 16.0d, 16.0d - (d * 16.0d), d5 * 16.0d, d6 * 16.0d));
        });
        return voxelShapeArr[0];
    }
}
