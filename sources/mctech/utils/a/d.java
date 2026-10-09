package mctech.utils.a;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a/d.class */
public class d {
    int a;

    public d() {
    }

    public d(int i) {
        this.a = i;
    }

    public void a(int i) {
        this.a |= i;
    }

    public boolean a(int i, boolean z) {
        if (d(i) == z) {
            return false;
        }
        this.a = z ? this.a | i : this.a & (i ^ (-1));
        return true;
    }

    public int a() {
        return this.a;
    }

    public void b(int i) {
        this.a ^= i;
    }

    public void c(int i) {
        this.a &= i ^ (-1);
    }

    public boolean d(int i) {
        return (this.a & i) == i;
    }

    public boolean e(int i) {
        return (this.a & i) != 0;
    }

    public boolean f(int i) {
        return (this.a & i) == 0;
    }
}
