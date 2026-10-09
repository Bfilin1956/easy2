package mctech.api.items.electric;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/electric/IElectricItemManager.class */
public interface IElectricItemManager {
    int charge(ItemStack itemStack, int i, int i2, boolean z, boolean z2);

    int discharge(ItemStack itemStack, int i, int i2, boolean z, boolean z2, boolean z3);

    int getCharge(ItemStack itemStack);

    int getCapacity(ItemStack itemStack);

    boolean canUse(ItemStack itemStack, int i);

    boolean use(ItemStack itemStack, int i, LivingEntity livingEntity);

    void chargeFromArmor(ItemStack itemStack, LivingEntity livingEntity);

    int getTier(ItemStack itemStack);

    int getTransferLimit(ItemStack itemStack);

    Component getToolTip(ItemStack itemStack);
}
