package mctech.items.e.d;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/d/c.class */
public class c extends PickaxeItem {
    public c(Item.Properties properties, Tier tier) {
        super(tier, properties);
    }

    public c(Tier tier) {
        this(new Item.Properties().attributes(PickaxeItem.createAttributes(tier, 1.0f, -2.8f)), tier);
    }
}
