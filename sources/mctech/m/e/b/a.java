package mctech.m.e.b;

import it.unimi.dsi.fastutil.ints.IntList;
import mctech.m.e.g;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/b/a.class */
public class a implements g {
    private IntList a;

    public a(IntList intList) {
        this.a = intList;
    }

    @Override // mctech.m.e.g
    public int a() {
        return this.a.size();
    }

    @Override // mctech.m.e.g
    public int a(int i) {
        return this.a.getInt(i);
    }

    @Override // mctech.m.e.g
    public boolean b(int i) {
        return this.a.contains(i);
    }
}
