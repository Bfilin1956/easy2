package mctech.r.a;

import java.util.Map;
import mctech.o.i;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/r/a/a.class */
public interface a {
    void a(c cVar);

    c a();

    int[] b();

    void a(int[] iArr);

    Map<int[], Integer> c();

    void a(int[] iArr, int i);

    void a(int i);

    int d();

    void a(d dVar);

    d e();

    default int[] f() {
        if (a() == c.SINGULAR) {
            return new int[]{(b()[0] - 195) - 23, b()[1] - i.e};
        }
        return new int[]{b()[0] - 195, b()[1] - i.e};
    }
}
