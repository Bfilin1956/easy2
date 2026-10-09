package mctech.api.items;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/IBoxableItem.class */
public interface IBoxableItem {
    boolean canStoreIntoBox(ItemStack itemStack);
}
