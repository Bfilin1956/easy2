package mctech.m.g;

import java.util.function.IntConsumer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/c.class */
public class c extends g {
    IntConsumer a;

    public c(mctech.m.a.g gVar, int i, int i2, int i3, mctech.m.c.g gVar2, IntConsumer intConsumer) {
        super(gVar, i, i2, i3, gVar2);
        this.a = intConsumer;
    }

    @Override // mctech.m.g.x
    public void setChanged() {
        this.a.accept(getSlotIndex());
    }
}
