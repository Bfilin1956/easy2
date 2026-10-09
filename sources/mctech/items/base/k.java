package mctech.items.base;

import javax.annotation.Nonnull;
import mctech.api.items.electric.ICustomElectricItem;
import mctech.api.items.electric.IElectricItemManager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.extensions.IItemExtension;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/k.class */
public interface k extends ICustomElectricItem, IItemExtension {
    @Nonnull
    l a();

    default boolean a(@Nonnull Player player, @Nonnull ItemStack itemStack) {
        return true;
    }

    default boolean isBookEnchantable(ItemStack itemStack, ItemStack itemStack2) {
        return false;
    }

    @Override // mctech.api.items.electric.ICustomElectricItem
    default IElectricItemManager getManager(ItemStack itemStack) {
        return mctech.energy.g.a();
    }
}
