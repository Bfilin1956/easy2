package mctech.api.items;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/IXrayUpgrade.class */
public interface IXrayUpgrade {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/IXrayUpgrade$Type.class */
    public enum Type {
        DISTANCE,
        ORE_FILTER,
        TEXTURE
    }

    void onInstall(ItemStack itemStack, ItemStack itemStack2);

    void onUninstall(ItemStack itemStack, ItemStack itemStack2);
}
