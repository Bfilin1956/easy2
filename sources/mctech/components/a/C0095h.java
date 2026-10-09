package mctech.components.a;

import mctech.api.tiles.readers.IEUStorage;
import mctech.utils.math.geometry.Vec2i;

/* JADX INFO: renamed from: mctech.components.a.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/h.class */
public class C0095h extends C0088a {
    public C0095h(int i, int i2, IEUStorage iEUStorage, InterfaceC0102o interfaceC0102o) {
        this(i, i2, iEUStorage, interfaceC0102o, C0101n.a);
    }

    public C0095h(int i, int i2, IEUStorage iEUStorage, InterfaceC0102o interfaceC0102o, C0101n c0101n) {
        super(i, i2, C0101n.o.getX(), C0101n.o.getY(), new Vec2i(C0101n.a.q.getX() + (C0101n.o.getX() * interfaceC0102o.tierIndex()), C0101n.a.q.getY()), () -> {
            return iEUStorage.getChargeLevel() > 0.0d;
        }, c0101n.a());
    }
}
