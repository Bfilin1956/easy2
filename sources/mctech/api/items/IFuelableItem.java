package mctech.api.items;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/IFuelableItem.class */
public interface IFuelableItem {
    ItemStack fill(ItemStack itemStack, int i);

    boolean canFuel(ItemStack itemStack);

    boolean hasFuel(ItemStack itemStack);

    int getFuel(ItemStack itemStack, int i, boolean z);
}
