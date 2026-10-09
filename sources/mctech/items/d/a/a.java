package mctech.items.d.a;

import java.util.List;
import mctech.utils.math.geometry.Vec2i;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/a/a.class */
public class a {
    public static final List<Vec2i> a = mctech.utils.a.b.a(new Vec2i(-1, 0), new Vec2i(1, 0), new Vec2i(0, -1), new Vec2i(0, 1));
    public int b;
    public int c;
    public int d;
    public List<Vec2i> e;

    public a(int i, int i2, int i3) {
        this(i, i2, i3, a);
    }

    public a(int i, int i2, int i3, List<Vec2i> list) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = list;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public List<Vec2i> d() {
        return this.e;
    }
}
