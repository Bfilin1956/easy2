package mctech.g.d.a;

import com.mojang.logging.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.Util;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import org.joml.Vector2i;
import org.slf4j.Logger;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/g.class */
public class g {
    private static final Logger b = LogUtils.getLogger();
    public static Map<Integer, Vector2i> a = (Map) Util.make(() -> {
        HashMap map = new HashMap();
        map.put(1, new Vector2i(0, -1));
        map.put(2, new Vector2i(-1, 0));
        map.put(3, new Vector2i(0, 1));
        map.put(4, new Vector2i(1, 0));
        map.put(5, new Vector2i(1, -1));
        map.put(6, new Vector2i(-1, -1));
        map.put(7, new Vector2i(-1, 1));
        map.put(8, new Vector2i(1, 1));
        map.put(9, new Vector2i(0, 0));
        return map;
    });

    public static Vector2i a(int i, int i2) {
        if (i >= i2) {
            return new Vector2i();
        }
        if (i < 0) {
            return new Vector2i();
        }
        if (i2 == 1) {
            return new Vector2i();
        }
        if (i2 == 2) {
            return i == 0 ? new Vector2i(0, -1) : new Vector2i(0, 1);
        }
        if (i2 == 3) {
            switch (i) {
                case 0:
                    return new Vector2i(-1, -1);
                case 1:
                    return new Vector2i();
                case 2:
                    return new Vector2i(1, 1);
                default:
                    throw new IllegalStateException();
            }
        }
        if (i2 < 9) {
            try {
                Vector2i vector2i = a.get(Integer.valueOf(i + 1));
                if (vector2i != null) {
                    return vector2i;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return new Vector2i();
            }
        }
        return new Vector2i();
    }

    /* JADX INFO: renamed from: mctech.g.d.a.g$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/g$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Direction.Axis.values().length];

        static {
            try {
                a[Direction.Axis.X.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Direction.Axis.Y.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Direction.Axis.Z.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public static Vec3i a(Direction.Axis axis, Vector2i vector2i) throws MatchException {
        switch (AnonymousClass1.a[axis.ordinal()]) {
            case 1:
                return new Vec3i(0, vector2i.y(), vector2i.x());
            case 2:
                return new Vec3i(vector2i.x(), 0, vector2i.y());
            case 3:
                return new Vec3i(vector2i.x(), vector2i.y(), 0);
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    public static Direction.Axis a(mctech.g.a.c cVar) {
        ArrayList arrayList = new ArrayList();
        for (Direction direction : Direction.values()) {
            if (!cVar.b(direction).isEmpty()) {
                arrayList.add(direction);
            }
        }
        if (arrayList.isEmpty()) {
            return Direction.Axis.Z;
        }
        return ((Direction) arrayList.getLast()).getAxis();
    }
}
