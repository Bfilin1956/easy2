package mctech.energy;

import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.ICustomElectricItem;
import mctech.api.items.electric.IDamagelessElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.api.items.electric.IElectricItemManager;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/energy/e.class */
public class e implements IElectricItemManager {
    public static IElectricItemManager a;

    public static void a() {
        ElectricItem.MANAGER = new e();
        ElectricItem.DIRECT_MANAGER = new d();
        a = new c();
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int charge(ItemStack itemStack, int i, int i2, boolean z, boolean z2) {
        IElectricItemManager iElectricItemManagerA = a(itemStack);
        if (iElectricItemManagerA == null) {
            return 0;
        }
        return iElectricItemManagerA.charge(itemStack, i, i2, z, z2);
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int discharge(ItemStack itemStack, int i, int i2, boolean z, boolean z2, boolean z3) {
        IElectricItemManager iElectricItemManagerA = a(itemStack);
        if (iElectricItemManagerA == null) {
            return 0;
        }
        return iElectricItemManagerA.discharge(itemStack, i, i2, z, z2, z3);
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getCharge(ItemStack itemStack) {
        IElectricItemManager iElectricItemManagerA = a(itemStack);
        if (iElectricItemManagerA == null) {
            return 0;
        }
        return iElectricItemManagerA.getCharge(itemStack);
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public boolean canUse(ItemStack itemStack, int i) {
        IElectricItemManager iElectricItemManagerA = a(itemStack);
        return iElectricItemManagerA != null && iElectricItemManagerA.canUse(itemStack, i);
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public boolean use(ItemStack itemStack, int i, LivingEntity livingEntity) {
        if ((livingEntity instanceof Player) && ((Player) livingEntity).isCreative()) {
            return true;
        }
        IElectricItemManager iElectricItemManagerA = a(itemStack);
        return iElectricItemManagerA != null && iElectricItemManagerA.use(itemStack, i, livingEntity);
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public void chargeFromArmor(ItemStack itemStack, LivingEntity livingEntity) {
        IElectricItemManager iElectricItemManagerA = a(itemStack);
        if (iElectricItemManagerA == null) {
            return;
        }
        iElectricItemManagerA.chargeFromArmor(itemStack, livingEntity);
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getCapacity(ItemStack itemStack) {
        IElectricItemManager iElectricItemManagerA = a(itemStack);
        if (iElectricItemManagerA == null) {
            return 0;
        }
        return iElectricItemManagerA.getCapacity(itemStack);
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getTier(ItemStack itemStack) {
        IElectricItemManager iElectricItemManagerA = a(itemStack);
        if (iElectricItemManagerA == null) {
            return 0;
        }
        return iElectricItemManagerA.getTier(itemStack);
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public int getTransferLimit(ItemStack itemStack) {
        IElectricItemManager iElectricItemManagerA = a(itemStack);
        if (iElectricItemManagerA == null) {
            return 0;
        }
        return iElectricItemManagerA.getTransferLimit(itemStack);
    }

    public IElectricItemManager a(ItemStack itemStack) {
        ICustomElectricItem item = itemStack.getItem();
        if (item == Items.AIR) {
            return null;
        }
        if (item instanceof IDamagelessElectricItem) {
            return a;
        }
        if (item instanceof IElectricItem) {
            return ElectricItem.DIRECT_MANAGER;
        }
        if (item instanceof ICustomElectricItem) {
            return item.getManager(itemStack);
        }
        return ElectricItem.getBackupManager(item);
    }

    @Override // mctech.api.items.electric.IElectricItemManager
    public Component getToolTip(ItemStack itemStack) {
        IElectricItemManager iElectricItemManagerA = a(itemStack);
        if (iElectricItemManagerA == null) {
            return null;
        }
        return iElectricItemManagerA.getToolTip(itemStack);
    }
}
