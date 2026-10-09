package mctech.api.items.armor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/armor/IEquipListener.class */
public interface IEquipListener {
    void onEquipped(@NotNull Player player, @NotNull ItemStack itemStack, @NotNull EquipmentSlot equipmentSlot);

    void onUnequipped(@NotNull Player player, @NotNull ItemStack itemStack, @NotNull EquipmentSlot equipmentSlot);
}
