package mctech.energy;

import appeng.api.config.AccessRestriction;
import appeng.api.implementations.items.IAEItemPowerStorage;
import mctech.api.items.electric.IElectricItemManager;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/energy/a.class */
public class a implements IElectricItemManager {
    public static final IElectricItemManager a = new a();

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
        return getCharge(itemStack) >= i;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public boolean use(ItemStack itemStack, int i, LivingEntity livingEntity) {
        return true;
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

    public static boolean a(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return false;
        }
        IAEItemPowerStorage item = itemStack.getItem();
        if (!(item instanceof IAEItemPowerStorage)) {
            return false;
        }
        IAEItemPowerStorage iAEItemPowerStorage = item;
        return iAEItemPowerStorage.getAEMaxPower(itemStack) > 0.0d && iAEItemPowerStorage.getPowerFlow(itemStack) != AccessRestriction.READ;
    }
}
