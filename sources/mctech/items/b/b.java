package mctech.items.b;

import mctech.api.items.Consumables;
import mctech.init.MCTechDataComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/b/b.class */
public class b extends Item {
    public b(Item.Properties properties, Consumables consumables, int i) {
        this(properties, consumables, i, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(Item.Properties properties, Consumables consumables, int i, boolean z) {
        Item.Properties propertiesComponent;
        if (z) {
            propertiesComponent = properties.setNoRepair().stacksTo(1).component(MCTechDataComponent.CONSUMABLE_CATEGORY, consumables.getName()).component(MCTechDataComponent.CONSUMABLE_INFINITE, true).setNoRepair();
        } else {
            propertiesComponent = properties.setNoRepair().durability(i).component(MCTechDataComponent.CONSUMABLE_CATEGORY, consumables.getName()).component(MCTechDataComponent.CONSUMABLE_INFINITE, false);
        }
        super(propertiesComponent);
    }

    public boolean isEnchantable(@NotNull ItemStack itemStack) {
        return false;
    }
}
