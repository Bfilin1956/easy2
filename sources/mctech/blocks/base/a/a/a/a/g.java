package mctech.blocks.base.a.a.a.a;

import mctech.api.tiles.readers.ISpeedMachine;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a/a/g.class */
public class g extends mctech.blocks.base.a.a.a {
    ISpeedMachine f;

    public g(String str, Component component, ISpeedMachine iSpeedMachine) {
        super(str, component);
        this.f = iSpeedMachine;
    }

    @Override // mctech.blocks.base.a.a.a
    protected int d() {
        return mctech.blocks.base.a.a.a.a(this.f.getSpeed(), this.f.getMaxSpeed(), 15);
    }
}
