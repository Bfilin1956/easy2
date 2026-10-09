package mctech.components;

import mctech.init.MCTechItems;
import mctech.utils.C0200b;
import net.minecraft.world.item.Item;

/* JADX INFO: renamed from: mctech.components.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/m.class */
public class C0119m extends AbstractC0087a {
    private mctech.blockentities.b.a b;

    public C0119m(mctech.utils.math.geometry.b bVar, mctech.blockentities.b.a aVar) {
        super(bVar, C0200b.f, (Item) MCTechItems.STORAGE_3.get());
        this.b = aVar;
    }

    private boolean d() {
        return this.b.getMaxEnergyOutput() > this.b.t;
    }

    @Override // mctech.components.AbstractC0087a
    protected boolean a() {
        return d();
    }
}
