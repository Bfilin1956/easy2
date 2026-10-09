package mctech.utils;

import java.util.Optional;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/m.class */
public class m {
    public static int a(ResourceKey<Enchantment> resourceKey, ItemStack itemStack, Level level) {
        Optional optional = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).get(resourceKey);
        if (optional.isPresent()) {
            return EnchantmentHelper.getTagEnchantmentLevel((Holder) optional.get(), itemStack);
        }
        return 0;
    }
}
