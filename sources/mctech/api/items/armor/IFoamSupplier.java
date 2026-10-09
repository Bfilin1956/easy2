package mctech.api.items.armor;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/armor/IFoamSupplier.class */
public interface IFoamSupplier {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/armor/IFoamSupplier$InventoryType.class */
    public enum InventoryType {
        HOTBAR,
        OFFHAND,
        ARMOR,
        CURIO
    }

    boolean canProvideFoam(Player player, ItemStack itemStack, InventoryType inventoryType, int i);

    void useFoam(Player player, ItemStack itemStack, int i);

    int getFreeFoamSpace(ItemStack itemStack);

    void fillFoam(ItemStack itemStack, int i);
}
