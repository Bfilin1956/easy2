package mctech.components;

import mctech.init.MCTechItems;
import mctech.utils.C0200b;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/K.class */
public class K extends AbstractC0087a {
    private int b;
    private mctech.blockentities.b.a c;

    public K(mctech.utils.math.geometry.b bVar, int i, mctech.blockentities.b.a aVar) {
        super(bVar, C0200b.e, (Item) MCTechItems.STORAGE_3.get(), (Item) MCTechItems.GEN_DAY_10.get(), (Item) MCTechItems.GEN_NIGHT_10.get(), (Item) MCTechItems.UNIVERSAL_GEN_10.get(), (Item) MCTechItems.IS_GEN_NIGHT.get(), (Item) MCTechItems.TRANSFORMER.get());
        this.b = i;
        this.c = aVar;
    }

    @Override // mctech.components.AbstractC0087a
    protected boolean a() {
        return ((ItemStack) this.c.inventory.get(this.b)).isEmpty();
    }
}
