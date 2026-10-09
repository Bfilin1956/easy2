package mctech.energy;

import mctech.api.items.electric.IElectricItemManager;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/energy/f.class */
public class f implements IElectricItemManager {
    public static final IElectricItemManager a = new f();

    @Override // mctech.api.items.electric.IElectricItemManager
    public int charge(ItemStack itemStack, int i, int i2, boolean z, boolean z2) {
        mctech.items.g.c.a item = itemStack.getItem();
        if (item instanceof mctech.items.g.c.a) {
            return item.a(itemStack, i, z, z2);
        }
        return 0;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int discharge(ItemStack itemStack, int i, int i2, boolean z, boolean z2, boolean z3) {
        mctech.items.g.c.a item = itemStack.getItem();
        if (item instanceof mctech.items.g.c.a) {
            return item.b(itemStack, i, z2, z3);
        }
        return 0;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getCharge(ItemStack itemStack) {
        mctech.items.g.c.a item = itemStack.getItem();
        if (item instanceof mctech.items.g.c.a) {
            return item.a(itemStack);
        }
        return 0;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getCapacity(ItemStack itemStack) {
        mctech.items.g.c.a item = itemStack.getItem();
        if (item instanceof mctech.items.g.c.a) {
            return item.b(itemStack);
        }
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
        mctech.items.g.c.a item = itemStack.getItem();
        if (item instanceof mctech.items.g.c.a) {
            return item.a();
        }
        return 0;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public Component getToolTip(ItemStack itemStack) {
        return Component.translatable("misc.mctech.eu_data", new Object[]{mctech.utils.c.c.c.format(getCharge(itemStack)), mctech.utils.c.c.c.format(getCapacity(itemStack))}).withStyle(ChatFormatting.AQUA);
    }
}
