package mctech.api.items.armor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/armor/IMetalArmor.class */
public interface IMetalArmor {
    boolean isMetalArmor(ItemStack itemStack, Player player, EquipmentSlot equipmentSlot);
}
