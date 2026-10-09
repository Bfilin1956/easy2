package mctech.utils.math.geometry;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/geometry/d.class */
public class d {
    public static final d a = new d(-9999.0f, -9999.0f);
    public static final d b = new d();
    private float c;
    private float d;

    public d() {
        this(0.0f, 0.0f);
    }

    public d(float f) {
        this(f, f);
    }

    public d(float f, float f2) {
        this.c = f;
        this.d = f2;
    }

    public d(d dVar) {
        this(dVar.c, dVar.d);
    }

    public float a() {
        return this.c;
    }

    public float b() {
        return this.d;
    }

    public void a(float f) {
        this.c = f;
    }

    public void b(float f) {
        this.d = f;
    }

    public void a(d dVar) {
        this.c = dVar.c;
        this.d = dVar.d;
    }

    public void a(float f, float f2) {
        this.c = f;
        this.d = f2;
    }

    public d b(float f, float f2) {
        return new d(this.c + f, this.d + f2);
    }

    public d b(d dVar) {
        return b(dVar.c, dVar.d);
    }

    public d c(float f, float f2) {
        return b(-f, -f2);
    }

    public d c(d dVar) {
        return b(-dVar.c, -dVar.d);
    }

    public d c() {
        return new d((float) Math.ceil(this.c), (float) Math.ceil(this.d));
    }

    public d d() {
        return new d((float) Math.floor(this.c), (float) Math.floor(this.d));
    }

    public d e() {
        return new d(Math.round(this.c), Math.round(this.d));
    }

    public d f() {
        return new d(Math.abs(this.c), Math.abs(this.d));
    }

    public d c(float f) {
        return new d(this.c * f, this.d * f);
    }

    public d d(float f) {
        return f != 0.0f ? new d(this.c / f, this.d / f) : this;
    }

    public float d(float f, float f2) {
        return (float) Math.sqrt(e(f, f2));
    }

    public float d(d dVar) {
        return (float) Math.sqrt(e(dVar.c, dVar.d));
    }

    public float e(float f, float f2) {
        return (float) (Math.pow(this.c - f, 2.0d) + Math.pow(this.d - f2, 2.0d));
    }

    public float e(d dVar) {
        return e(dVar.c, dVar.d);
    }

    public float g() {
        return (float) Math.sqrt(h());
    }

    public float h() {
        return (this.c * this.c) + (this.d * this.d);
    }

    public d i() {
        float fG = g();
        return fG != 0.0f ? d(fG) : new d(0.0f, 0.0f);
    }

    public float f(d dVar) {
        return (this.c * dVar.c) + (this.d * dVar.d);
    }

    public d j() {
        return new d(this);
    }

    public c k() {
        return new c(this.c, this.d);
    }

    public Vec2i l() {
        return new Vec2i((int) this.c, (int) this.d);
    }

    public float[] m() {
        return new float[]{this.c, this.d};
    }

    public float[] n() {
        return new float[]{this.c, this.d};
    }

    public boolean o() {
        return this.c == -9999.0f && this.d == -9999.0f;
    }

    public boolean p() {
        return this.c == 0.0f && this.d == 0.0f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (dVar.c == this.c && dVar.d == this.d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Double.hashCode(this.c) + (Double.hashCode(this.d) * 31);
    }

    public String toString() {
        return "Vec2[x=" + this.c + ", y=" + this.d + "]";
    }
}
