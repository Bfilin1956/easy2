package mctech.blocks.base.a.a.a.a;

import mctech.api.tiles.readers.IFuelStorage;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a/a/d.class */
public class d extends mctech.blocks.base.a.a.a {
    IFuelStorage f;

    public d(String str, Component component, IFuelStorage iFuelStorage) {
        super(str, component);
        this.f = iFuelStorage;
    }

    @Override // mctech.blocks.base.a.a.a
    protected int d() {
        return mctech.blocks.base.a.a.a.a(this.f.getFuel(), this.f.getMaxFuel(), 15);
    }
}
