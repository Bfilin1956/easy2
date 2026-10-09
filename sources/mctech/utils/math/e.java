package mctech.utils.math;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/e.class */
public class e {
    float a;
    float b;

    public e() {
    }

    public e(float f) {
        b(f);
    }

    public void a(float f) {
        this.b = f;
    }

    public void b(float f) {
        this.a = f;
        this.b = f;
    }

    public void c(float f) {
        if (this.a > this.b) {
            this.a -= f;
        } else if (this.a < this.b) {
            this.a += f;
        }
    }

    public float a() {
        return this.a;
    }
}
