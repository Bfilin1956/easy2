package mctech.items.b;

import mctech.api.items.Consumables;
import mctech.init.MCTechDataComponent;
import net.minecraft.world.item.Item;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/b/a.class */
public class a extends b {
    public a(int i, int i2) {
        this(i, i2, false);
    }

    public a(int i, int i2, boolean z) {
        super(new Item.Properties().component(MCTechDataComponent.CONSUMABLE_FUEL_HEAT_SPEED, Integer.valueOf(i2)), Consumables.FUEL, i, z);
    }
}
