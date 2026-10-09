package mctech.api.items.electric;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/electric/ICustomElectricItem.class */
public interface ICustomElectricItem {
    IElectricItemManager getManager(ItemStack itemStack);
}
