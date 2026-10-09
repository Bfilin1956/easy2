package mctech.api.items;

import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/IWindmillBlade.class */
public interface IWindmillBlade {
    int getEnergyPerTick(ItemStack itemStack);

    int getMaxRotorDurability(ItemStack itemStack);

    boolean isInfinite(ItemStack itemStack);

    MachineTier getRotorTier(ItemStack itemStack);

    default int getRemainingDurability(ItemStack itemStack) {
        if (isInfinite(itemStack)) {
            return -1;
        }
        return Math.max(0, getMaxRotorDurability(itemStack) - itemStack.getDamageValue());
    }

    default boolean canGenerate(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return false;
        }
        return isInfinite(itemStack) || getRemainingDurability(itemStack) > 0;
    }
}
