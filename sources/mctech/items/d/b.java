package mctech.items.d;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/b.class */
public enum b {
    T1(mctech.q.c.c, 120),
    T2(1024, 150),
    T3(4096, 200),
    T4(mctech.q.c.a, 240),
    T5(32768, 480);

    private static final int f = 1200;
    private final int g;
    private final int h;

    b(int i2, int i3) {
        this.g = i2;
        this.h = i3 * f;
    }

    public int a() {
        return this.g;
    }

    public int b() {
        return this.h;
    }

    public int c() {
        return ordinal() + 1;
    }
}
