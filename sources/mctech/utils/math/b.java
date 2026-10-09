package mctech.utils.math;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Iterator;
import mctech.api.util.DirectionList;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/b.class */
public final class b {
    static final b[] a = h();
    int b;
    int c;
    a[] d;

    private b() {
        throw new RuntimeException("NOT ALLOWED!");
    }

    private b(int i) {
        this.b = Mth.clamp(i, 0, 15);
        ObjectList objectListI = mctech.utils.a.b.i();
        for (int i2 = 0; i2 < 4; i2++) {
            if ((i & (1 << i2)) != 0) {
                objectListI.add(a.a(i2));
            }
        }
        this.c = objectListI.size();
        this.d = (a[]) objectListI.toArray(new a[objectListI.size()]);
    }

    public static b a(DirectionList directionList, Direction direction) {
        int iA = 0;
        Iterator<Direction> it = directionList.remove(DirectionList.ofAxis(direction.getAxis())).iterator();
        while (it.hasNext()) {
            iA |= 1 << a.a(it.next(), direction).a();
        }
        return a[iA];
    }

    public static b a(DirectionList directionList, Direction.Axis axis) {
        int iA = 0;
        Iterator<Direction> it = directionList.remove(DirectionList.ofAxis(axis)).iterator();
        while (it.hasNext()) {
            iA |= 1 << a.a(it.next(), axis).a();
        }
        return a[iA];
    }

    public static b a(int i) {
        return a[i];
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public b c() {
        return a[15 - this.b];
    }

    public b d() {
        int iA = 0;
        for (a aVar : this.d) {
            iA |= 1 << aVar.b().a();
        }
        return a[iA];
    }

    public String toString() {
        return "ConnectionState: " + String.valueOf(ObjectArrayList.wrap(this.d));
    }

    public String e() {
        switch (this.c) {
            case 0:
                return "full";
            case 1:
                return "end_" + this.d[0].e();
            case 2:
                if (this.d[0].b() == this.d[1]) {
                    return this.d[0].c() ? "straight_vertical" : "straight_horizontal";
                }
                return this.d[0].a(this.d[1]);
            case 3:
                return "side_" + a[15 - this.b].d[0].e();
            default:
                return "empty";
        }
    }

    public int f() {
        switch (this.c) {
            case 0:
                return 0;
            case 1:
                return this.d[0].a();
            case 2:
                if (this.d[0].b() == this.d[1]) {
                    return this.d[0].c() ? 0 : 1;
                }
                return this.d[0].b(this.d[1]);
            case 3:
                return a[15 - this.b].d[0].a();
            default:
                return 0;
        }
    }

    public float[] g() {
        switch (this.c) {
            case 0:
                return new float[]{0.0f, 0.0f, 16.0f, 16.0f};
            case 1:
                return this.d[0].d();
            case 2:
                return this.d[0].b() == this.d[1] ? this.d[0].d() : this.d[0].c(this.d[1]);
            case 3:
                return a[15 - this.b].d[0].d();
            default:
                return new float[]{0.0f, 0.0f, 16.0f, 16.0f};
        }
    }

    static b[] h() {
        b[] bVarArr = new b[16];
        for (int i = 0; i < 16; i++) {
            bVarArr[i] = new b(i);
        }
        return bVarArr;
    }

    public static float[] a(float[][][] fArr, Direction direction, int i, int i2, int i3, int i4) {
        int i5 = i - 1;
        int i6 = i5 % i2;
        int i7 = (i5 / (i2 * i4)) % i3;
        int i8 = (i3 - 1) - ((i5 / i2) % i4);
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 1:
                return fArr[i6][(i4 - 1) - i8];
            case 2:
                return fArr[i6][i8];
            case 3:
                return fArr[(i2 - 1) - i6][i7];
            case 4:
                return fArr[i6][i7];
            case 5:
                return fArr[(i4 - 1) - i8][i7];
            case 6:
                return fArr[i8][i7];
            default:
                return new float[]{0.0f, 0.0f, 16.0f, 16.0f};
        }
    }

    public static float[][][] a(int i, int i2) {
        float f = 16.0f / i;
        float f2 = 16.0f / i2;
        float[][][] fArr = new float[i][i2][4];
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                fArr[i3][i4] = new float[]{i3 * f, i4 * f2, (i3 + 1) * f, (i4 + 1) * f2};
            }
        }
        return fArr;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/b$a.class */
    public enum a implements mctech.utils.a.b.InterfaceC0041b {
        UP(0, 2, "bottom"),
        EAST(1, 3, "left"),
        DOWN(2, 0, "top"),
        WEST(3, 1, "right");

        static final a[] e = values();
        int f;
        int g;
        String h;

        a(int i2, int i3, String str) {
            this.f = i2;
            this.g = i3;
            this.h = str;
        }

        public a b() {
            return e[this.g];
        }

        public String a(a aVar) {
            if (aVar.a() == this.f || aVar.a() == this.g) {
                throw new IllegalStateException("Illegal State");
            }
            return "corner_" + (c() ? this.h + "_" + aVar.e() : aVar.e() + "_" + this.h);
        }

        public int b(a aVar) {
            if (aVar.a() == this.f || aVar.a() == this.g) {
                throw new IllegalStateException("Illegal State");
            }
            if (c()) {
                if (aVar == WEST) {
                    return this == UP ? 3 : 2;
                }
                return this == UP ? 0 : 1;
            }
            if (this == WEST) {
                return aVar == UP ? 3 : 2;
            }
            return aVar == UP ? 0 : 1;
        }

        public boolean c() {
            return this.f == 0 || this.f == 2;
        }

        @Override // mctech.utils.a.b.InterfaceC0041b
        public int a() {
            return this.f;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.h;
        }

        public float[] c(a aVar) {
            if (!c() && aVar.c()) {
                return aVar.c(this);
            }
            float[] fArr = new float[4];
            switch (aVar.ordinal()) {
                case 1:
                    fArr[0] = 0.0f;
                    fArr[2] = 5.3333335f;
                    break;
                case 3:
                    fArr[0] = 10.666667f;
                    fArr[2] = 16.0f;
                    break;
                default:
                    fArr[0] = 0.0f;
                    fArr[2] = 16.0f;
                    break;
            }
            switch (ordinal()) {
                case 0:
                    fArr[1] = 10.666667f;
                    fArr[3] = 16.0f;
                    break;
                case 2:
                    fArr[1] = 0.0f;
                    fArr[3] = 5.3333335f;
                    break;
                default:
                    fArr[0] = 0.0f;
                    fArr[2] = 16.0f;
                    break;
            }
            return fArr;
        }

        public float[] d() {
            switch (this) {
                case UP:
                    return new float[]{5.3333335f, 0.0f, 10.666667f, 5.3333335f};
                case EAST:
                    return new float[]{10.666667f, 5.3333335f, 16.0f, 10.666667f};
                case DOWN:
                    return new float[]{5.3333335f, 10.666667f, 10.666667f, 16.0f};
                case WEST:
                    return new float[]{0.0f, 5.3333335f, 5.3333335f, 10.666667f};
                default:
                    throw new IllegalStateException();
            }
        }

        public String e() {
            return this.h;
        }

        public static a a(Direction direction, Direction direction2) {
            switch (AnonymousClass1.b[direction2.getAxis().ordinal()]) {
                case 1:
                    switch (AnonymousClass1.a[direction.ordinal()]) {
                        case 1:
                            return DOWN;
                        case 2:
                            return UP;
                        case 3:
                            return direction2.getAxisDirection() == Direction.AxisDirection.POSITIVE ? EAST : WEST;
                        case 4:
                            return direction2.getAxisDirection() == Direction.AxisDirection.POSITIVE ? WEST : EAST;
                        default:
                            throw new IllegalStateException("Not a Valid Facing");
                    }
                case 2:
                    return e[((direction2.getAxisDirection() == Direction.AxisDirection.POSITIVE || direction.getAxis() == Direction.Axis.X) ? direction.getOpposite() : direction).get2DDataValue()];
                case 3:
                    switch (AnonymousClass1.a[direction.ordinal()]) {
                        case 1:
                            return DOWN;
                        case 2:
                            return UP;
                        case 3:
                        case 4:
                        default:
                            throw new IllegalStateException("Not a Valid Facing");
                        case 5:
                            return direction2.getAxisDirection() == Direction.AxisDirection.POSITIVE ? EAST : WEST;
                        case 6:
                            return direction2.getAxisDirection() == Direction.AxisDirection.POSITIVE ? WEST : EAST;
                    }
                default:
                    throw new IllegalStateException("Not a Valid Axis");
            }
        }

        public static a a(Direction direction, Direction.Axis axis) {
            switch (AnonymousClass1.b[axis.ordinal()]) {
                case 1:
                    switch (AnonymousClass1.a[direction.ordinal()]) {
                        case 1:
                            return DOWN;
                        case 2:
                            return UP;
                        case 3:
                            return WEST;
                        case 4:
                            return EAST;
                        default:
                            throw new IllegalStateException("Not a Valid Facing");
                    }
                case 2:
                    return e[direction.get2DDataValue()];
                case 3:
                    switch (AnonymousClass1.a[direction.ordinal()]) {
                        case 1:
                            return DOWN;
                        case 2:
                            return UP;
                        case 3:
                        case 4:
                        default:
                            throw new IllegalStateException("Not a Valid Facing");
                        case 5:
                            return EAST;
                        case 6:
                            return WEST;
                    }
                default:
                    throw new IllegalStateException("Not a Valid Axis");
            }
        }

        public static a a(int i2) {
            return e[i2 & 3];
        }
    }

    /* JADX INFO: renamed from: mctech.utils.math.b$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/b$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[Direction.Axis.values().length];

        static {
            try {
                b[Direction.Axis.X.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[Direction.Axis.Y.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[Direction.Axis.Z.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            a = new int[Direction.values().length];
            try {
                a[Direction.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[Direction.UP.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[Direction.SOUTH.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[Direction.EAST.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[Direction.WEST.ordinal()] = 6;
            } catch (NoSuchFieldError e9) {
            }
        }
    }
}
