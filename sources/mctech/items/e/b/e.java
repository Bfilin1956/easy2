package mctech.items.e.b;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/b/e.class */
public class e extends SwordItem {
    public e(Item.Properties properties, Tier tier) {
        super(tier, properties);
    }

    public e(Tier tier) {
        this(new Item.Properties().attributes(PickaxeItem.createAttributes(tier, 3.0f, -2.4f)), tier);
    }
}
