package mctech.blocks.base.a.a.a.b;

import mctech.api.tiles.IEnergyStorage;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a/b/c.class */
public class c extends mctech.blocks.base.a.a.a {
    mctech.blocks.base.a.b.b f;
    a g;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a/b/c$a.class */
    public enum a {
        HAS_MINECART,
        HAS_TRANSFER,
        MINECART_ENERGY
    }

    public c(String str, Component component, mctech.blocks.base.a.b.b bVar, a aVar) {
        super(str, component);
        this.f = bVar;
        this.g = aVar;
    }

    @Override // mctech.blocks.base.a.a.a
    protected int d() {
        switch (this.g) {
            case HAS_MINECART:
                return this.f.a() ? 15 : 0;
            case HAS_TRANSFER:
                return this.f.b() > 0 ? 15 : 0;
            case MINECART_ENERGY:
                return e();
            default:
                return 0;
        }
    }

    private int e() {
        IEnergyStorage iEnergyStorageC = this.f.c();
        if (iEnergyStorageC == null) {
            return 0;
        }
        return mctech.blocks.base.a.a.a.a(iEnergyStorageC.getStoredEU(), iEnergyStorageC.getMaxEU(), 15);
    }
}
