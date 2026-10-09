package mctech.r.a;

import mctech.components.a.InterfaceC0102o;
import mctech.m.b.aI;
import net.mcskill.msregistry.core.MachineTier;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/r/a/c.class */
public enum c {
    NANO("nano", new int[]{69, 26}, 3, 24, 13, new int[]{208, 219}, new int[]{192, 20}, 86, new int[]{58, 116}, new int[]{101, 121}, new int[]{69, 46}, new int[]{69, 69}, 3),
    QUANT("quant", new int[]{45, 26}, 5, 24, 19, new int[]{208, aI.f}, new int[]{192, 20}, 86, new int[]{58, 116}, new int[]{101, 121}, new int[]{45, 46}, new int[]{45, 69}, 5),
    SINGULAR("singular", new int[]{24, 26}, 9, 23, 31, new int[]{254, 219}, new int[]{238, 20}, 151, new int[]{52, 116}, new int[]{44, 114}, new int[]{24, 46}, new int[]{24, 69}, 9);

    private final String d;
    private final int[] e;
    private final int f;
    private final int g;
    private final int h;
    private final int[] i;
    private final int[] j;
    private final int k;
    private final int[] l;
    private final int[] m;
    private final int[] n;
    private final int[] o;
    private final int p;

    c(String str, int[] iArr, int i, int i2, int i3, int[] iArr2, int[] iArr3, int i4, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7, int i5) {
        this.d = str;
        this.e = iArr;
        this.g = i2;
        this.f = i;
        this.h = i3;
        this.i = iArr2;
        this.j = iArr3;
        this.k = i4;
        this.l = iArr4;
        this.m = iArr5;
        this.n = iArr6;
        this.o = iArr7;
        this.p = i5;
    }

    public MachineTier a() {
        return MachineTier.values()[b().tierIndex()];
    }

    public InterfaceC0102o b() {
        return () -> {
            return ordinal() + 4;
        };
    }

    public String c() {
        return this.d;
    }

    public int[] d() {
        return this.e;
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public int[] h() {
        return this.i;
    }

    public int[] i() {
        return this.j;
    }

    public int j() {
        return this.k;
    }

    public int[] k() {
        return this.l;
    }

    public int[] l() {
        return this.m;
    }

    public int[] m() {
        return this.n;
    }

    public int[] n() {
        return this.o;
    }

    public int o() {
        return this.p;
    }
}
