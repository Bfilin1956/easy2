package mctech.energy;

import javax.annotation.Nonnull;
import mctech.api.items.electric.IElectricItemManager;
import mctech.items.base.k;
import mctech.modules.h;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/energy/g.class */
public class g implements IElectricItemManager {

    @Nonnull
    protected static IElectricItemManager a = new g();

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
        return mctech.items.base.b.c(itemStack);
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getCapacity(ItemStack itemStack) {
        return mctech.items.base.b.d(itemStack);
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public boolean canUse(ItemStack itemStack, int i) {
        return true;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public boolean use(ItemStack itemStack, int i, LivingEntity livingEntity) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public void chargeFromArmor(ItemStack itemStack, LivingEntity livingEntity) {
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getTier(@Nonnull ItemStack itemStack) {
        k item = itemStack.getItem();
        if (item instanceof k) {
            return h.a().a(item.a()).getElectricTier();
        }
        return 0;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getTransferLimit(@Nonnull ItemStack itemStack) {
        k item = itemStack.getItem();
        if (item instanceof k) {
            return h.a().a(item.a()).getElectricTransferLimit();
        }
        return 0;
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public Component getToolTip(ItemStack itemStack) {
        return Component.translatable("misc.mctech.eu_data", new Object[]{mctech.utils.c.c.c.format(mctech.items.base.b.c(itemStack)), mctech.utils.c.c.c.format(mctech.items.base.b.d(itemStack))}).withStyle(ChatFormatting.AQUA);
    }

    @Nonnull
    public static IElectricItemManager a() {
        return a;
    }
}
