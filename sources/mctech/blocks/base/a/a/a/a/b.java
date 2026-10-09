package mctech.blocks.base.a.a.a.a;

import mctech.api.tiles.readers.IEUStorage;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a/a/b.class */
public class b extends mctech.blocks.base.a.a.a {
    IEUStorage f;

    public b(String str, Component component, IEUStorage iEUStorage) {
        super(str, component);
        this.f = iEUStorage;
    }

    @Override // mctech.blocks.base.a.a.a
    protected int d() {
        return mctech.blocks.base.a.a.a.a(this.f.getStoredEU(), this.f.getMaxEU(), 15);
    }
}
