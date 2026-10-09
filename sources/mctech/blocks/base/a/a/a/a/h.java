package mctech.blocks.base.a.a.a.a;

import mctech.api.tiles.readers.ISubProgressMachine;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a/a/h.class */
public class h extends mctech.blocks.base.a.a.a {
    ISubProgressMachine f;

    public h(String str, Component component, ISubProgressMachine iSubProgressMachine) {
        super(str, component);
        this.f = iSubProgressMachine;
    }

    @Override // mctech.blocks.base.a.a.a
    protected int d() {
        return mctech.blocks.base.a.a.a.a(this.f.getSubProgress(), this.f.getMaxSubProgress(), 15);
    }
}
