package mctech.m.e.b;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import mctech.blockentities.m;
import mctech.m.e.g;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/b/b.class */
public class b implements g {
    m a;

    public b(m mVar) {
        this.a = mVar;
    }

    @Override // mctech.m.e.g
    public int a() {
        return 6 * this.a.getWidth();
    }

    @Override // mctech.m.e.g
    public int a(int i) {
        return this.a.f()[i];
    }

    @Override // mctech.m.e.g
    public boolean b(int i) {
        return new IntOpenHashSet(this.a.f()).contains(i);
    }
}
