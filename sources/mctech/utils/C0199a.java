package mctech.utils;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;

/* JADX INFO: renamed from: mctech.utils.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a.class */
public class C0199a {
    public static AABB a(AABB aabb, Direction direction) {
        double d = aabb.minX;
        double d2 = aabb.minY;
        double d3 = aabb.minZ;
        double d4 = aabb.maxX;
        double d5 = aabb.maxY;
        double d6 = aabb.maxZ;
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 1:
                return aabb;
            case 2:
                return new AABB(1.0d - d4, d2, 1.0d - d6, 1.0d - d, d5, 1.0d - d3);
            case 3:
                return new AABB(1.0d - d6, d2, d, 1.0d - d3, d5, d4);
            case 4:
                return new AABB(d3, d2, 1.0d - d4, d6, d5, 1.0d - d);
            default:
                throw new IllegalStateException("Unexpected value: " + String.valueOf(direction));
        }
    }

    /* JADX INFO: renamed from: mctech.utils.a$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a$1.class */
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
                a[Direction.EAST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[Direction.WEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }
}
