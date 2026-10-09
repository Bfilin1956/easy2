package mctech.utils;

import net.minecraft.util.RandomSource;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/u.class */
public final class u {
    public static int a(int i, float f, RandomSource randomSource) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (randomSource.nextFloat() < f) {
                i2++;
            }
        }
        return i2;
    }
}
