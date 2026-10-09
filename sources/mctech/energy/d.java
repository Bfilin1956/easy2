package mctech.energy;

import mctech.api.items.electric.IElectricItem;
import mctech.api.items.electric.IElectricItemManager;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/energy/d.class */
public class d implements IElectricItemManager {
    @Override // mctech.api.items.electric.IElectricItemManager
    public int charge(ItemStack itemStack, int i, int i2, boolean z, boolean z2) {
        IElectricItem item = itemStack.getItem();
        if (i < 0 || itemStack.getCount() > 1 || item.getTier(itemStack) > i2) {
            return 0;
        }
        if (!z) {
            i = Math.min(i, item.getTransferLimit(itemStack));
        }
        int charge = item.getCharge(itemStack);
        int iMin = Math.min(i, item.getCapacity(itemStack) - charge);
        if (!z2) {
            int i3 = charge + iMin;
            if (i3 < 0) {
                i3 = 0;
            }
            item.setCharge(itemStack, i3);
            itemStack.setDamageValue(b(itemStack, i3));
        }
        return iMin;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int discharge(ItemStack itemStack, int i, int i2, boolean z, boolean z2, boolean z3) {
        if (i <= 0 || itemStack.getCount() > 1) {
            return 0;
        }
        IElectricItem item = itemStack.getItem();
        if (!(item instanceof IElectricItem)) {
            return 0;
        }
        IElectricItem iElectricItem = item;
        if (iElectricItem.getTier(itemStack) > i2) {
            return 0;
        }
        if (z2 && !iElectricItem.canProvideEnergy(itemStack)) {
            return 0;
        }
        if (!z) {
            i = Math.min(i, iElectricItem.getTransferLimit(itemStack));
        }
        int charge = iElectricItem.getCharge(itemStack);
        if (i > charge) {
            i = charge;
        }
        if (!z3) {
            int i3 = charge - i;
            if (i3 < 0) {
                i3 = 0;
            }
            iElectricItem.setCharge(itemStack, i3);
            itemStack.setDamageValue(b(itemStack, i3));
        }
        return i;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getCharge(ItemStack itemStack) {
        return discharge(itemStack, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false, true);
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public boolean canUse(ItemStack itemStack, int i) {
        return getCharge(itemStack) >= a(itemStack, i);
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public boolean use(ItemStack itemStack, int i, LivingEntity livingEntity) {
        int iA = a(itemStack, i);
        chargeFromArmor(itemStack, livingEntity);
        if (discharge(itemStack, iA, Integer.MAX_VALUE, true, false, true) == iA) {
            discharge(itemStack, iA, Integer.MAX_VALUE, true, false, false);
            chargeFromArmor(itemStack, livingEntity);
            return true;
        }
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public void chargeFromArmor(ItemStack itemStack, LivingEntity livingEntity) {
    }

    public int a(ItemStack itemStack, int i) {
        return i;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getCapacity(ItemStack itemStack) {
        return itemStack.getItem().getCapacity(itemStack);
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getTier(ItemStack itemStack) {
        return itemStack.getItem().getTier(itemStack);
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getTransferLimit(ItemStack itemStack) {
        return itemStack.getItem().getTransferLimit(itemStack);
    }

    private int b(ItemStack itemStack, int i) {
        if (itemStack.isEmpty() || itemStack.getMaxDamage() < 2) {
            return 0;
        }
        return (int) ((((double) i) / ((double) getCapacity(itemStack))) * ((double) (itemStack.getMaxDamage() - 1)));
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public Component getToolTip(ItemStack itemStack) {
        return Component.translatable("misc.mctech.eu_data", new Object[]{mctech.utils.c.c.c.format(getCharge(itemStack)), mctech.utils.c.c.c.format(getCapacity(itemStack))}).withStyle(ChatFormatting.AQUA);
    }
}
