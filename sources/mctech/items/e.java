package mctech.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e.class */
public class e extends Item {
    public e(Item.Properties properties) {
        super(properties);
    }

    public boolean isFoil(@NotNull ItemStack itemStack) {
        return true;
    }
}
