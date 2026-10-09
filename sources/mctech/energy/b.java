package mctech.energy;

import mctech.api.items.electric.IElectricItemManager;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/energy/b.class */
public class b implements IElectricItemManager {
    public static final IElectricItemManager a = new b();

    @Override // mctech.api.items.electric.IElectricItemManager
    public int charge(ItemStack itemStack, int i, int i2, boolean z, boolean z2) {
        return 0;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int discharge(ItemStack itemStack, int i, int i2, boolean z, boolean z2, boolean z3) {
        return 0;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getCharge(ItemStack itemStack) {
        return 0;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getCapacity(ItemStack itemStack) {
        return 0;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public boolean canUse(ItemStack itemStack, int i) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public boolean use(ItemStack itemStack, int i, LivingEntity livingEntity) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public void chargeFromArmor(ItemStack itemStack, LivingEntity livingEntity) {
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getTier(ItemStack itemStack) {
        return 0;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getTransferLimit(ItemStack itemStack) {
        return 0;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public Component getToolTip(ItemStack itemStack) {
        return Component.empty();
    }
}
