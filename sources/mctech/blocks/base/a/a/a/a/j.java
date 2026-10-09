package mctech.blocks.base.a.a.a.a;

import mctech.api.tiles.readers.IAirSpeed;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a/a/j.class */
public class j extends mctech.blocks.base.a.a.a {
    IAirSpeed f;

    public j(String str, Component component, IAirSpeed iAirSpeed) {
        super(str, component);
        this.f = iAirSpeed;
    }

    @Override // mctech.blocks.base.a.a.a
    protected int d() {
        return mctech.blocks.base.a.a.a.a(this.f.getCurrentSpeed(), this.f.getMaxSpeed(), 15);
    }
}
