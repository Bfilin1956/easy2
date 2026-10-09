package mctech.items.e.b;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/b/a.class */
public class a extends AxeItem {
    public a(Item.Properties properties, Tier tier) {
        super(tier, properties);
    }

    public a(Tier tier) {
        this(new Item.Properties().attributes(PickaxeItem.createAttributes(tier, 6.0f, -3.1f)), tier);
    }
}
