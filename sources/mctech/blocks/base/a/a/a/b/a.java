package mctech.blocks.base.a.a.a.b;

import mctech.api.tiles.readers.IEUStorage;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a/b/a.class */
public class a extends mctech.blocks.base.a.a.a {
    IEUStorage f;
    float g;

    public a(String str, Component component, IEUStorage iEUStorage, float f) {
        super(str, component);
        this.f = iEUStorage;
        this.g = f;
    }

    @Override // mctech.blocks.base.a.a.a
    protected int d() {
        return ((float) this.f.getStoredEU()) / ((float) this.f.getMaxEU()) > this.g ? 15 : 0;
    }
}
