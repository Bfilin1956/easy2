package mctech.utils.math;

import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/a.class */
public class a {
    static final float a = 0.003921569f;
    public static final int b = -1;
    public static final int f = -16777216;
    public static final int c = a(192, 192, 192);
    public static final int d = a(128, 128, 128);
    public static final int e = a(64, 64, 64);
    public static final int g = a(255, 0, 0);
    public static final int h = a(255, 175, 175);
    public static final int i = a(255, 200, 0);
    public static final int j = a(255, 255, 0);
    public static final int k = a(0, 255, 0);
    public static final int l = a(255, 0, 255);
    public static final int m = a(0, 255, 255);
    public static final int n = a(0, 0, 255);

    public static int a(int i2, int i3, int i4) {
        return a(i2, i3, i4, 255);
    }

    public static int a(int i2, int i3, int i4, int i5) {
        return ((i5 & 255) << 24) | ((i2 & 255) << 16) | ((i3 & 255) << 8) | (i4 & 255);
    }

    public static int a(float f2, float f3, float f4) {
        return a(f2, f3, f4, 1.0f);
    }

    public static int a(float f2, float f3, float f4, float f5) {
        return a((int) (((double) (f2 * 255.0f)) + 0.5d), (int) (((double) (f3 * 255.0f)) + 0.5d), (int) (((double) (f4 * 255.0f)) + 0.5d), (int) (((double) (f5 * 255.0f)) + 0.5d));
    }

    public static float[] a(int i2) {
        return new float[]{f(i2), g(i2), h(i2)};
    }

    public static int b(int i2) {
        return (i2 >> 16) & 255;
    }

    public static int c(int i2) {
        return (i2 >> 8) & 255;
    }

    public static int d(int i2) {
        return i2 & 255;
    }

    public static int e(int i2) {
        return (i2 >> 24) & 255;
    }

    public static float f(int i2) {
        return ((i2 >> 16) & 255) * a;
    }

    public static float g(int i2) {
        return ((i2 >> 8) & 255) * a;
    }

    public static float h(int i2) {
        return (i2 & 255) * a;
    }

    public static float i(int i2) {
        return ((i2 >> 24) & 255) * a;
    }

    public static boolean j(int i2) {
        return k(i2) >= 130;
    }

    public static int k(int i2) {
        return b((i2 >> 16) & 255, (i2 >> 8) & 255, i2 & 255);
    }

    public static int b(int i2, int i3, int i4) {
        return (int) Math.sqrt((i2 * i2 * 0.241f) + (i3 * i3 * 0.691f) + (i4 * i4 * 0.068f));
    }

    public static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return ((((int) ((((i2 >> 24) & 255) * f3) + (((i3 >> 24) & 255) * f2))) & 255) << 24) | ((((int) ((((i2 >> 16) & 255) * f3) + (((i3 >> 16) & 255) * f2))) & 255) << 16) | ((((int) ((((i2 >> 8) & 255) * f3) + (((i3 >> 8) & 255) * f2))) & 255) << 8) | (((int) (((i2 & 255) * f3) + ((i3 & 255) * f2))) & 255);
    }

    public static int l(int i2) {
        return n(n(i2));
    }

    public static int m(int i2) {
        return n(n(n(i2)));
    }

    public static int n(int i2) {
        return a(i2, 0.7f);
    }

    public static int a(int i2, float f2) {
        if (Float.compare(f2, 1.0f) == 0) {
            return i2;
        }
        return (i2 & f) | ((Math.max(0, (int) (((i2 >> 16) & 255) * f2)) & 255) << 16) | ((Math.max(0, (int) (((i2 >> 8) & 255) * f2)) & 255) << 8) | (Math.max(0, (int) ((i2 & 255) * f2)) & 255);
    }

    public static int o(int i2) {
        return p(p(i2));
    }

    public static int p(int i2) {
        return b(i2, 0.7f);
    }

    public static int b(int i2, float f2) {
        if (Float.compare(f2, 1.0f) == 0) {
            return i2;
        }
        int i3 = (i2 >> 16) & 255;
        int i4 = (i2 >> 8) & 255;
        int i5 = i2 & 255;
        int i6 = (int) (1.0d / (1.0d - ((double) f2)));
        if (i3 == 0 && i4 == 0 && i5 == 0) {
            return (i2 & f) | ((i6 & 255) << 16) | ((i6 & 255) << 8) | (i6 & 255);
        }
        if (i3 > 0 && i3 < i6) {
            i3 = i6;
        }
        if (i4 > 0 && i4 < i6) {
            i4 = i6;
        }
        if (i5 > 0 && i5 < i6) {
            i5 = i6;
        }
        return (i2 & f) | (Math.min(255, (int) (i3 / f2)) << 16) | (Math.min(255, (int) (i4 / f2)) << 8) | Math.min(255, (int) (i5 / f2));
    }

    public static Style q(int i2) {
        return Style.EMPTY.withColor(TextColor.fromRgb(i2 & 16777215));
    }

    public static String r(int i2) {
        return "#" + Integer.toHexString(16777216 | (i2 & 16777215)).substring(1);
    }
}
