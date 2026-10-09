package mctech.m.g;

import mctech.api.features.IXPMachine;
import mctech.m.a.g;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/A.class */
public class A<T extends IXPMachine & mctech.m.a.g> extends B implements mctech.m.a.j {
    public A(T t, int i, int i2, int i3) {
        super(t, i, i2, i3);
    }

    @Override // mctech.m.a.j
    public int o() {
        return 10;
    }
}
