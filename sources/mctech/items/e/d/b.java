package mctech.items.e.d;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/d/b.class */
public class b extends HoeItem {
    public b(Item.Properties properties, Tier tier) {
        super(tier, properties);
    }

    public b(Tier tier) {
        this(new Item.Properties().attributes(PickaxeItem.createAttributes(tier, tier.getAttackDamageBonus(), -1.0f)), tier);
    }
}
