package mctech.items.g.b;

import mctech.api.items.armor.IArmorModule;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/b/c.class */
public interface c extends IArmorModule {
    @Override // mctech.api.items.armor.IArmorModule
    default boolean canInstallInArmor(ItemStack itemStack, ItemStack itemStack2, EquipmentSlot equipmentSlot) {
        return true;
    }

    @Override // mctech.api.items.armor.IArmorModule
    default void onInstall(ItemStack itemStack, ItemStack itemStack2, IArmorModule.IArmorModuleHolder iArmorModuleHolder) {
    }

    @Override // mctech.api.items.armor.IArmorModule
    default void onUninstall(ItemStack itemStack, ItemStack itemStack2, IArmorModule.IArmorModuleHolder iArmorModuleHolder) {
    }

    @Override // mctech.api.items.armor.IArmorModule
    default void transferToArmor(ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3) {
    }

    @Override // mctech.api.items.armor.IArmorModule
    default void onTick(ItemStack itemStack, ItemStack itemStack2, Level level, Player player) {
    }

    @Override // mctech.api.items.armor.IArmorModule
    default void onEquipped(ItemStack itemStack, ItemStack itemStack2, Player player) {
    }

    @Override // mctech.api.items.armor.IArmorModule
    default void onUnequipped(ItemStack itemStack, ItemStack itemStack2, Player player) {
    }

    @Override // mctech.api.items.armor.IArmorModule
    default void provideCapabilities(ItemStack itemStack, ItemStack itemStack2) {
    }
}
