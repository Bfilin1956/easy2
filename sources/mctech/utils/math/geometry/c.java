package mctech.utils.math.geometry;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/geometry/c.class */
public class c {
    public static final c a = new c(-9999.0d, -9999.0d);
    public static final c b = new c();
    private double c;
    private double d;

    public c() {
        this(0.0d, 0.0d);
    }

    public c(double d) {
        this(d, d);
    }

    public c(double d, double d2) {
        this.c = d;
        this.d = d2;
    }

    public c(c cVar) {
        this(cVar.c, cVar.d);
    }

    public c(Vec2i vec2i) {
        this(vec2i.getX(), vec2i.getY());
    }

    public double a() {
        return this.c;
    }

    public double b() {
        return this.d;
    }

    public void a(double d) {
        this.c = d;
    }

    public void b(double d) {
        this.d = d;
    }

    public void a(c cVar) {
        this.c = cVar.c;
        this.d = cVar.d;
    }

    public void a(double d, double d2) {
        this.c = d;
        this.d = d2;
    }

    public c b(double d, double d2) {
        return new c(this.c + d, this.d + d2);
    }

    public c b(c cVar) {
        return b(cVar.c, cVar.d);
    }

    public c c(double d, double d2) {
        return b(-d, -d2);
    }

    public c c(c cVar) {
        return b(-cVar.c, -cVar.d);
    }

    public c c() {
        return new c(Math.ceil(this.c), Math.ceil(this.d));
    }

    public c d() {
        return new c(Math.floor(this.c), Math.floor(this.d));
    }

    public c e() {
        return new c(Math.round(this.c), Math.round(this.d));
    }

    public c f() {
        return new c(Math.abs(this.c), Math.abs(this.d));
    }

    public c c(double d) {
        return new c(this.c * d, this.d * d);
    }

    public c d(double d) {
        return d != 0.0d ? new c(this.c / d, this.d / d) : this;
    }

    public double d(double d, double d2) {
        return Math.sqrt(e(d, d2));
    }

    public double d(c cVar) {
        return Math.sqrt(e(cVar.c, cVar.d));
    }

    public double e(double d, double d2) {
        return Math.pow(this.c - d, 2.0d) + Math.pow(this.d - d2, 2.0d);
    }

    public double e(c cVar) {
        return e(cVar.c, cVar.d);
    }

    public double g() {
        return Math.sqrt(h());
    }

    public double h() {
        return (this.c * this.c) + (this.d * this.d);
    }

    public c i() {
        double dG = g();
        return dG != 0.0d ? d(dG) : new c(0.0d, 0.0d);
    }

    public double f(c cVar) {
        return (this.c * cVar.c) + (this.d * cVar.d);
    }

    public c j() {
        return new c(this);
    }

    public d k() {
        return new d((float) this.c, (float) this.d);
    }

    public Vec2i l() {
        return new Vec2i((int) this.c, (int) this.d);
    }

    public float[] m() {
        return new float[]{(float) this.c, (float) this.d};
    }

    public double[] n() {
        return new double[]{this.c, this.d};
    }

    public boolean o() {
        return this.c == -9999.0d && this.d == -9999.0d;
    }

    public boolean p() {
        return this.c == 0.0d && this.d == 0.0d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.c == this.c && cVar.d == this.d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Double.hashCode(this.c) + (Double.hashCode(this.d) * 31);
    }

    public String toString() {
        double d = this.c;
        double d2 = this.d;
        return "Vec2[x=" + d + ", y=" + d + "]";
    }
}
