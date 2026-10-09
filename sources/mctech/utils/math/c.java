package mctech.utils.math;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import java.util.List;
import java.util.function.BiFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/c.class */
public class c {
    static final float a = 0.003921569f;
    public static final BiFunction<Integer, Integer, Integer> b = c::a;

    static Integer a(Integer num, Integer num2) {
        int iIntValue = num.intValue() - num2.intValue();
        if (iIntValue <= 0) {
            return null;
        }
        return Integer.valueOf(iIntValue);
    }

    public static int[] a(int i, int i2) {
        int[] iArr = new int[i2 - i];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = i3 + i;
        }
        return iArr;
    }

    public static IntList b(int i, int i2) {
        IntArrayList intArrayList = new IntArrayList(i2 - i);
        int i3 = i2 - i;
        for (int i4 = 0; i4 < i3; i4++) {
            intArrayList.add(i + i4);
        }
        return intArrayList;
    }

    public static int a(int i) {
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            i2 += i3;
        }
        return i2;
    }

    public static <T> void a(List<T> list, RandomSource randomSource) {
        for (int size = list.size(); size > 1; size--) {
            list.set(size - 1, list.set(randomSource.nextInt(size), list.get(size - 1)));
        }
    }

    public static Vec3 a(Vec3 vec3, double d) {
        return new Vec3(vec3.x / d, vec3.y / d, vec3.z / d);
    }

    public static BlockPos a(BlockPos blockPos, double d) {
        return new BlockPos((int) (((double) blockPos.getX()) / d), (int) (((double) blockPos.getY()) / d), (int) (((double) blockPos.getZ()) / d));
    }

    public static Vec3 a(Vec3 vec3, double d, double d2) {
        return new Vec3(Mth.clamp(vec3.x, d, d2), Mth.clamp(vec3.y, d, d2), Mth.clamp(vec3.z, d, d2));
    }

    public static long a(long j, long j2) {
        return (j << 32) | (j2 & 2147483647L);
    }

    public static int a(long j) {
        return (int) ((j >> 32) & 2147483647L);
    }

    public static int b(long j) {
        return (int) (j & 2147483647L);
    }

    public static int c(int i, int i2) {
        return (i << 16) | (i2 & mctech.q.c.b);
    }

    public static int b(int i) {
        return (i >> 16) & mctech.q.c.b;
    }

    public static int c(int i) {
        return i & mctech.q.c.b;
    }

    public static int d(int i) {
        return Integer.signum(i);
    }

    public static int c(long j) {
        return Long.signum(j);
    }

    public static double a(double d) {
        return ((((1.70158d + 1.0d) * d) * d) * d) - ((1.70158d * d) * d);
    }

    public static boolean a(String str) {
        if (str.isEmpty()) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'f') && (cCharAt < 'A' || cCharAt > 'F'))) {
                return false;
            }
        }
        return true;
    }

    public static String a(String str, long j) {
        return str + ": [ms=" + mctech.utils.c.c.e.format(j / 1000000) + ", qs=" + mctech.utils.c.c.e.format(j / 1000) + ", ns=" + mctech.utils.c.c.e.format(j) + "]";
    }

    public static String b(String str, long j) {
        return str + ": " + (j / 1000000) + "ms, " + str + "qs, " + (j / 1000) + "ns";
    }
}
