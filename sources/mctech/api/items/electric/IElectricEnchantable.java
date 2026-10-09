package mctech.api.items.electric;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.extensions.IItemExtension;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/electric/IElectricEnchantable.class */
public interface IElectricEnchantable extends IItemExtension {
    InteractionResult getEnchantmentCompatibility(ItemStack itemStack, Enchantment enchantment);

    default boolean isBookEnchantable(ItemStack itemStack, ItemStack itemStack2) {
        return false;
    }
}
