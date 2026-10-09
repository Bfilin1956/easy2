package mctech.utils.math;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/d.class */
public class d {
    double a;
    double b;

    public d() {
    }

    public d(double d) {
        b(d);
    }

    public void a(double d) {
        this.b = d;
    }

    public void b(double d) {
        this.a = d;
        this.b = d;
    }

    public void c(double d) {
        if (this.a > this.b) {
            this.a -= d;
        } else if (this.a < this.b) {
            this.a += d;
        }
    }

    public double a() {
        return this.a;
    }
}
