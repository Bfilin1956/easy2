package mctech.items.e.d;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/d/d.class */
public class d extends ShovelItem {
    public d(Item.Properties properties, Tier tier) {
        super(tier, properties);
    }

    public d(Tier tier) {
        this(new Item.Properties().attributes(PickaxeItem.createAttributes(tier, 1.5f, -3.0f)), tier);
    }
}
