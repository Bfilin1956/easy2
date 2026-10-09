package mctech.utils.math.geometry;

import it.unimi.dsi.fastutil.longs.LongIterator;
import java.util.Iterator;
import mctech.api.util.DirectionList;
import mctech.utils.a.f;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.ByteArrayTag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/geometry/a.class */
public class a implements Iterable<BlockPos> {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;

    public a() {
        this(0, 0, 0, 0, 0, 0);
    }

    public a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.a = Math.min(i, i4);
        this.b = Math.min(i2, i5);
        this.c = Math.min(i3, i6);
        this.d = Math.max(i, i4);
        this.e = Math.max(i2, i5);
        this.f = Math.max(i3, i6);
    }

    public static a a(IntArrayTag intArrayTag) {
        return a(intArrayTag.getAsIntArray());
    }

    public static a a(byte[] bArr) {
        if (bArr.length != 6) {
            throw new IllegalStateException("Array has to be size of 6");
        }
        return new a(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5]);
    }

    public static a a(int[] iArr) {
        if (iArr.length != 6) {
            throw new IllegalStateException("Array has to be size of 6");
        }
        return new a(iArr[0], iArr[1], iArr[2], iArr[3], iArr[4], iArr[5]);
    }

    public static a a(BlockPos blockPos) {
        return a(blockPos, blockPos.offset(1, 1, 1));
    }

    public static a a(BlockPos blockPos, boolean z) {
        return a(blockPos, z ? blockPos : blockPos.offset(1, 1, 1));
    }

    public static a a(BlockPos blockPos, BlockPos blockPos2) {
        return new a(blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockPos2.getX(), blockPos2.getY(), blockPos2.getZ());
    }

    public static a a(BlockPos blockPos, int i) {
        return a(blockPos.offset(-i, -i, -i), blockPos.offset(i, i, i));
    }

    public static a a(AABB aabb) {
        return new a((int) Math.floor(aabb.minX), (int) Math.floor(aabb.minY), (int) Math.floor(aabb.minZ), (int) Math.floor(aabb.maxX), (int) Math.floor(aabb.maxY), (int) Math.floor(aabb.maxZ));
    }

    public static a a(long[] jArr) {
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMin3 = Integer.MAX_VALUE;
        int iMax = Integer.MIN_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        int iMax3 = Integer.MIN_VALUE;
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            int x = BlockPos.getX(jArr[i]);
            int y = BlockPos.getY(jArr[i]);
            int z = BlockPos.getZ(jArr[i]);
            iMin = Math.min(x, iMin);
            iMin2 = Math.min(y, iMin2);
            iMin3 = Math.min(z, iMin3);
            iMax = Math.max(x, iMax);
            iMax2 = Math.max(y, iMax2);
            iMax3 = Math.max(z, iMax3);
        }
        return new a(iMin, iMin2, iMin3, iMax, iMax2, iMax3);
    }

    public static a a(LongIterator longIterator) {
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMin3 = Integer.MAX_VALUE;
        int iMax = Integer.MIN_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        int iMax3 = Integer.MIN_VALUE;
        while (true) {
            int i = iMax3;
            if (longIterator.hasNext()) {
                long jNextLong = longIterator.nextLong();
                int x = BlockPos.getX(jNextLong);
                int y = BlockPos.getY(jNextLong);
                int z = BlockPos.getZ(jNextLong);
                iMin = Math.min(x, iMin);
                iMin2 = Math.min(y, iMin2);
                iMin3 = Math.min(z, iMin3);
                iMax = Math.max(x, iMax);
                iMax2 = Math.max(y, iMax2);
                iMax3 = Math.max(z, i);
            } else {
                return new a(iMin, iMin2, iMin3, iMax, iMax2, i);
            }
        }
    }

    public static a a(Iterable<BlockPos> iterable) {
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMin3 = Integer.MAX_VALUE;
        int iMax = Integer.MIN_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        int iMax3 = Integer.MIN_VALUE;
        for (BlockPos blockPos : iterable) {
            iMin = Math.min(blockPos.getX(), iMin);
            iMin2 = Math.min(blockPos.getY(), iMin2);
            iMin3 = Math.min(blockPos.getZ(), iMin3);
            iMax = Math.max(blockPos.getX(), iMax);
            iMax2 = Math.max(blockPos.getY(), iMax2);
            iMax3 = Math.max(blockPos.getZ(), iMax3);
        }
        return new a(iMin, iMin2, iMin3, iMax, iMax2, iMax3);
    }

    public a a() {
        return new a(this.a, this.b, this.c, this.d, this.e, this.f);
    }

    public AABB b() {
        return new AABB(this.a, this.b, this.c, this.d, this.e, this.f);
    }

    public a c() {
        return new a(this.a, this.b, this.c, this.d + 1, this.e + 1, this.f + 1);
    }

    public AABB d() {
        return new AABB(this.a, this.b, this.c, this.d + 1, this.e + 1, this.f + 1);
    }

    public a a(Direction.Axis axis, int i) {
        return a(DirectionList.ofAxis(axis).invert(), i);
    }

    public a b(Direction.Axis axis, int i) {
        return a(DirectionList.ofAxis(axis), i);
    }

    public a a(Direction direction, int i) {
        return a(DirectionList.ofFacing(direction), i);
    }

    public a a(DirectionList directionList, int i) {
        this.a -= directionList.contains(Direction.WEST) ? i : 0;
        this.b -= directionList.contains(Direction.DOWN) ? i : 0;
        this.c -= directionList.contains(Direction.NORTH) ? i : 0;
        this.d += directionList.contains(Direction.EAST) ? i : 0;
        this.e += directionList.contains(Direction.UP) ? i : 0;
        this.f += directionList.contains(Direction.SOUTH) ? i : 0;
        return this;
    }

    public a b(BlockPos blockPos) {
        this.d = Math.min(blockPos.getX(), this.d);
        this.e = Math.min(blockPos.getY(), this.e);
        this.f = Math.min(blockPos.getZ(), this.f);
        return this;
    }

    public a c(BlockPos blockPos) {
        this.a = Math.max(blockPos.getX(), this.a);
        this.b = Math.max(blockPos.getY(), this.b);
        this.c = Math.max(blockPos.getZ(), this.c);
        return this;
    }

    public a b(DirectionList directionList, int i) {
        this.a = directionList.contains(Direction.WEST) ? i : this.a;
        this.b = directionList.contains(Direction.DOWN) ? i : this.b;
        this.c = directionList.contains(Direction.NORTH) ? i : this.c;
        this.d = directionList.contains(Direction.EAST) ? i : this.d;
        this.e = directionList.contains(Direction.UP) ? i : this.e;
        this.f = directionList.contains(Direction.SOUTH) ? i : this.f;
        if (this.d < this.a) {
            int i2 = this.a;
            this.a = this.d;
            this.a = i2;
        }
        if (this.e < this.b) {
            int i3 = this.b;
            this.b = this.e;
            this.b = i3;
        }
        if (this.f < this.c) {
            int i4 = this.c;
            this.c = this.f;
            this.c = i4;
        }
        return this;
    }

    public a a(Vec3i vec3i) {
        return a(vec3i.getX(), vec3i.getY(), vec3i.getZ());
    }

    public a a(Direction direction) {
        return a(direction.getNormal());
    }

    public a a(int i, int i2, int i3) {
        this.a += i;
        this.b += i2;
        this.c += i3;
        this.d += i;
        this.e += i2;
        this.f += i3;
        return this;
    }

    public int e() {
        int iAbs = Math.abs(this.d - this.a) + 1;
        int iAbs2 = Math.abs(this.e - this.b) + 1;
        return iAbs * iAbs2 * (Math.abs(this.f - this.c) + 1);
    }

    public String toString() {
        return "BoundingBox[minX=" + this.a + ", minY=" + this.b + ", minZ=" + this.c + ", maxX=" + this.d + ", maxY=" + this.e + ", maxZ=" + this.f;
    }

    public int b(Direction direction) {
        switch (AnonymousClass5.a[direction.ordinal()]) {
            case 1:
                return this.b;
            case 2:
                return this.e;
            case 3:
                return this.a;
            case 4:
                return this.d;
            case 5:
                return this.c;
            case 6:
                return this.f;
            default:
                return 0;
        }
    }

    /* JADX INFO: renamed from: mctech.utils.math.geometry.a$5, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/geometry/a$5.class */
    static /* synthetic */ class AnonymousClass5 {
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
                a[Direction.EAST.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[Direction.WEST.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[Direction.NORTH.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[Direction.SOUTH.ordinal()] = 6;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public int a(Direction.Axis axis) {
        switch (AnonymousClass5.b[axis.ordinal()]) {
            case 1:
                return o();
            case 2:
                return p();
            case 3:
                return q();
            default:
                return 0;
        }
    }

    public int b(Direction.Axis axis) {
        switch (AnonymousClass5.b[axis.ordinal()]) {
            case 1:
                return this.a;
            case 2:
                return this.b;
            case 3:
                return this.c;
            default:
                return 0;
        }
    }

    public int c(Direction.Axis axis) {
        switch (AnonymousClass5.b[axis.ordinal()]) {
            case 1:
                return this.d;
            case 2:
                return this.e;
            case 3:
                return this.f;
            default:
                return 0;
        }
    }

    public int f() {
        return this.a;
    }

    public int g() {
        return this.b;
    }

    public int h() {
        return this.c;
    }

    public BlockPos i() {
        return new BlockPos(this.a, this.b, this.c);
    }

    public int j() {
        return this.d;
    }

    public int k() {
        return this.e;
    }

    public int l() {
        return this.f;
    }

    public BlockPos m() {
        return new BlockPos(this.d, this.e, this.f);
    }

    public BlockPos b(int i, int i2, int i3) {
        return new BlockPos(this.a + i, this.b + i2, this.c + i3);
    }

    public BlockPos n() {
        return new BlockPos(this.a + ((this.d - this.a) / 2), this.b + ((this.e - this.b) / 2), this.c + ((this.f - this.c) / 2));
    }

    public int o() {
        return Math.abs(this.d - this.a);
    }

    public int p() {
        return Math.abs(this.e - this.b);
    }

    public int q() {
        return Math.abs(this.f - this.c);
    }

    public boolean a(int i) {
        return o() > i && p() > i && q() > i;
    }

    public int r() {
        a(DirectionList.ALL, -1);
        int iE = e();
        a(DirectionList.ALL, 1);
        return e() - iE;
    }

    public boolean d(BlockPos blockPos) {
        return blockPos.getX() >= this.a && blockPos.getX() <= this.d && blockPos.getY() >= this.b && blockPos.getY() <= this.e && blockPos.getZ() >= this.c && blockPos.getZ() <= this.f;
    }

    public boolean a(BlockEntity blockEntity) {
        return d(blockEntity.getBlockPos());
    }

    public boolean a(Entity entity) {
        return d(entity.blockPosition());
    }

    public boolean a(a aVar) {
        return ((aVar.a >= this.a && aVar.a <= this.d) || (aVar.d >= this.a && aVar.d <= this.d)) && ((aVar.b >= this.b && aVar.b <= this.e) || (aVar.e >= this.b && aVar.e <= this.e)) && ((aVar.c >= this.c && aVar.c <= this.f) || (aVar.f >= this.c && aVar.f <= this.f));
    }

    public boolean s() {
        return (this.a >> 4) == (this.d >> 4) && (this.c >> 4) == (this.f >> 4);
    }

    public boolean a(Level level) {
        int i = this.d >> 4;
        for (int i2 = this.a >> 4; i2 <= i; i2++) {
            int i3 = this.f >> 4;
            for (int i4 = this.c >> 4; i4 <= i3; i4++) {
                if (!level.hasChunk(i2, i4)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Direction e(BlockPos blockPos) {
        if (g(blockPos)) {
            return null;
        }
        if (blockPos.getX() == this.a) {
            return Direction.WEST;
        }
        if (blockPos.getX() == this.d) {
            return Direction.EAST;
        }
        if (blockPos.getY() == this.b) {
            return Direction.DOWN;
        }
        if (blockPos.getY() == this.e) {
            return Direction.UP;
        }
        if (blockPos.getX() == this.c) {
            return Direction.NORTH;
        }
        if (blockPos.getX() == this.f) {
            return Direction.SOUTH;
        }
        return null;
    }

    public boolean f(BlockPos blockPos) {
        return blockPos.getX() == this.a || blockPos.getX() == this.d || blockPos.getY() == this.b || blockPos.getY() == this.e || blockPos.getZ() == this.c || blockPos.getZ() == this.f;
    }

    public boolean g(BlockPos blockPos) {
        if (blockPos.getX() == this.a || blockPos.getX() == this.d) {
            return blockPos.getY() == this.b || blockPos.getY() == this.e || blockPos.getZ() == this.c || blockPos.getZ() == this.f;
        }
        if (blockPos.getY() == this.b || blockPos.getY() == this.e) {
            return blockPos.getX() == this.a || blockPos.getX() == this.d || blockPos.getZ() == this.c || blockPos.getZ() == this.f;
        }
        return (blockPos.getZ() == this.c || blockPos.getZ() == this.f) && (blockPos.getX() == this.a || blockPos.getX() == this.d || blockPos.getY() == this.b || blockPos.getY() == this.e);
    }

    public boolean h(BlockPos blockPos) {
        return (blockPos.getX() == this.a || blockPos.getX() == this.d) && (blockPos.getY() == this.b || blockPos.getY() == this.e) && (blockPos.getZ() == this.c || blockPos.getZ() == this.f);
    }

    public IntArrayTag t() {
        return new IntArrayTag(new int[]{this.a, this.b, this.c, this.d, this.e, this.f});
    }

    public ByteArrayTag u() {
        return new ByteArrayTag(new byte[]{(byte) this.a, (byte) this.b, (byte) this.c, (byte) this.d, (byte) this.e, (byte) this.f});
    }

    public long[] v() {
        long[] jArr = new long[e()];
        int i = 0;
        for (int i2 = this.b; i2 <= this.e; i2++) {
            for (int i3 = this.c; i3 <= this.f; i3++) {
                for (int i4 = this.a; i4 <= this.d; i4++) {
                    int i5 = i;
                    i++;
                    jArr[i5] = BlockPos.asLong(i4, i2, i3);
                }
            }
        }
        return jArr;
    }

    public long[] i(BlockPos blockPos) {
        a((Vec3i) blockPos);
        long[] jArr = new long[e() - 1];
        int i = 0;
        for (int i2 = this.b; i2 <= this.e; i2++) {
            for (int i3 = this.c; i3 <= this.f; i3++) {
                for (int i4 = this.a; i4 <= this.d; i4++) {
                    if (i4 != blockPos.getX() || i2 != blockPos.getY() || i3 != blockPos.getZ()) {
                        int i5 = i;
                        i++;
                        jArr[i5] = BlockPos.asLong(i4, i2, i3);
                    }
                }
            }
        }
        a(-blockPos.getX(), -blockPos.getY(), -blockPos.getZ());
        return jArr;
    }

    public long[] w() {
        long[] jArr = new long[r()];
        int i = 0;
        int i2 = (this.d - this.a) - 1;
        for (int i3 = this.b; i3 <= this.e; i3++) {
            for (int i4 = this.c; i4 <= this.f; i4++) {
                int i5 = this.a;
                while (i5 <= this.d) {
                    int i6 = i;
                    i++;
                    jArr[i6] = BlockPos.asLong(i5, i3, i4);
                    if (i4 != this.c && i4 != this.f && i3 != this.b && i3 != this.e && i5 == this.a) {
                        i5 += i2;
                    }
                    i5++;
                }
            }
        }
        return jArr;
    }

    public long[] j(BlockPos blockPos) {
        a((Vec3i) blockPos);
        long[] jArr = new long[r() - 1];
        int i = 0;
        for (int i2 = this.c; i2 <= this.f; i2++) {
            for (int i3 = this.b; i3 <= this.e; i3++) {
                for (int i4 = this.a; i4 <= this.d; i4++) {
                    if ((i4 != blockPos.getX() || i3 != blockPos.getY() || i2 != blockPos.getZ()) && (i4 == this.a || i4 == this.d || i3 == this.b || i3 == this.e || i2 == this.c || i2 == this.f)) {
                        int i5 = i;
                        i++;
                        jArr[i5] = BlockPos.asLong(i4, i3, i2);
                    }
                }
            }
        }
        a(-blockPos.getX(), -blockPos.getY(), -blockPos.getZ());
        return jArr;
    }

    @Override // java.lang.Iterable
    public Iterator<BlockPos> iterator() {
        return new Iterator<BlockPos>() { // from class: mctech.utils.math.geometry.a.1
            int a;
            int b;
            int c;
            boolean d = true;
            BlockPos.MutableBlockPos e;

            {
                this.a = a.this.a;
                this.b = a.this.b;
                this.c = a.this.c;
                this.e = new BlockPos.MutableBlockPos(this.a, this.b, this.c);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.d;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BlockPos next() {
                this.e.set(this.a, this.b, this.c);
                int i = this.a + 1;
                this.a = i;
                if (i > a.this.d) {
                    this.a = a.this.a;
                    int i2 = this.c + 1;
                    this.c = i2;
                    if (i2 > a.this.f) {
                        this.c = a.this.c;
                        int i3 = this.b + 1;
                        this.b = i3;
                        if (i3 > a.this.e) {
                            this.b = a.this.b;
                            this.d = false;
                        }
                    }
                }
                return this.e;
            }
        };
    }

    public Iterator<BlockPos> x() {
        return new Iterator<BlockPos>() { // from class: mctech.utils.math.geometry.a.2
            int a;
            int b;
            int c;
            BlockPos.MutableBlockPos d;

            {
                this.a = a.this.a;
                this.b = a.this.b;
                this.c = a.this.c;
                this.d = new BlockPos.MutableBlockPos(this.a, this.b, this.c);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return true;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BlockPos next() {
                this.d.set(this.a, this.b, this.c);
                int i = this.a + 1;
                this.a = i;
                if (i > a.this.d) {
                    this.a = a.this.a;
                    int i2 = this.c + 1;
                    this.c = i2;
                    if (i2 > a.this.f) {
                        this.c = a.this.c;
                        int i3 = this.b + 1;
                        this.b = i3;
                        if (i3 > a.this.e) {
                            this.b = a.this.b;
                        }
                    }
                }
                return this.d;
            }
        };
    }

    public Iterable<BlockPos> y() {
        return f.a(new Iterator<BlockPos>() { // from class: mctech.utils.math.geometry.a.3
            int b;
            int c;
            int d;
            int e;
            boolean a = true;
            BlockPos.MutableBlockPos f = new BlockPos.MutableBlockPos();

            {
                this.b = (a.this.d - a.this.a) - 1;
                this.c = a.this.a;
                this.d = a.this.b;
                this.e = a.this.c;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BlockPos next() {
                this.f.set(this.c, this.d, this.e);
                if (this.e != a.this.c && this.e != a.this.f && this.c == a.this.a) {
                    this.c += this.b;
                }
                int i = this.c + 1;
                this.c = i;
                if (i > a.this.d) {
                    this.c = a.this.a;
                    int i2 = this.e + 1;
                    this.e = i2;
                    if (i2 > a.this.f) {
                        this.e = a.this.c;
                        this.a = false;
                    }
                }
                return this.f;
            }
        });
    }

    public Iterable<BlockPos> z() {
        return f.a(new Iterator<BlockPos>() { // from class: mctech.utils.math.geometry.a.4
            int b;
            int c;
            int d;
            int e;
            boolean a = true;
            BlockPos.MutableBlockPos f = new BlockPos.MutableBlockPos();

            {
                this.b = (a.this.d - a.this.a) - 1;
                this.c = a.this.a;
                this.d = a.this.b;
                this.e = a.this.c;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BlockPos next() {
                this.f.set(this.c, this.d, this.e);
                if (this.e != a.this.c && this.e != a.this.f && this.d != a.this.b && this.d != a.this.e && this.c == a.this.a) {
                    this.c += this.b;
                }
                int i = this.c + 1;
                this.c = i;
                if (i > a.this.d) {
                    this.c = a.this.a;
                    int i2 = this.e + 1;
                    this.e = i2;
                    if (i2 > a.this.f) {
                        this.e = a.this.c;
                        int i3 = this.d + 1;
                        this.d = i3;
                        if (i3 > a.this.e) {
                            this.d = a.this.b;
                            this.a = false;
                        }
                    }
                }
                return this.f;
            }
        });
    }
}
