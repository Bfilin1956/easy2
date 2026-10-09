package mctech.blocks.base.a.a.a.b;

import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a/b/b.class */
public class b extends mctech.blocks.base.a.a.a {
    mctech.blocks.base.a.b.a f;

    public b(String str, Component component, mctech.blocks.base.a.b.a aVar) {
        super(str, component);
        this.f = aVar;
    }

    @Override // mctech.blocks.base.a.a.a
    protected int d() {
        return mctech.blocks.base.a.a.a.a(this.f.getHeat(), this.f.getMaxHeat(), 15);
    }
}
