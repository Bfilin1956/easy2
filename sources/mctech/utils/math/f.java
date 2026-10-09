package mctech.utils.math;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/f.class */
public class f {
    protected float a;
    protected float b;
    protected float c;

    public f(float f) {
        this.c = f;
    }

    public f(float f, float f2) {
        this.a = f;
        this.b = f;
        this.c = f2;
    }

    public boolean a() {
        return Math.abs(this.b - this.a) <= 0.5f;
    }

    public void a(float f) {
        this.a += (this.b - this.a) * this.c * f;
    }

    public void b(float f) {
        this.b = f;
    }

    public void c(float f) {
        this.b += f;
    }

    public void b() {
        this.a = this.b;
    }

    public float c() {
        return this.a;
    }

    public float d() {
        return this.b;
    }
}
