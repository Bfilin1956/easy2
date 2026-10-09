package mctech.utils.math.geometry;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/geometry/b.class */
public class b {
    public static final b a = new b(0, 0, 0, 0);
    private int b;
    private int c;
    private int d;
    private int e;

    public b(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i4;
        this.e = i3;
    }

    public boolean a(int i, int i2) {
        return this.b <= i && this.b + this.e >= i && this.c <= i2 && this.c + this.d >= i2;
    }

    public boolean a(int i) {
        return this.b <= i && this.b + this.e >= i;
    }

    public boolean b(int i) {
        return this.c <= i && this.c + this.d >= i;
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

    public int d() {
        return this.e;
    }

    public void c(int i) {
        this.b = i;
    }

    public void d(int i) {
        this.c = i;
    }

    public void e(int i) {
        this.d = i;
    }

    public void f(int i) {
        this.e = i;
    }

    public b g(int i) {
        this.b += i;
        return this;
    }

    public b h(int i) {
        this.c += i;
        return this;
    }

    public b i(int i) {
        this.d += i;
        return this;
    }

    public b j(int i) {
        this.e += i;
        return this;
    }

    public b b(int i, int i2) {
        return new b(this.b, this.c, this.e + i, this.d + i2);
    }

    public String toString() {
        return "Box2i [x=" + this.b + ", y=" + this.c + " width=" + this.e + ", height=" + this.d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * this.b) + this.c)) + this.d)) + this.e;
    }
}
