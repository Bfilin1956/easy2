package mctech.api.items.armor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/armor/IEnergyShieldArmor.class */
public interface IEnergyShieldArmor {
    boolean addsShieldEffect(EquipmentSlot equipmentSlot, LivingEntity livingEntity, ItemStack itemStack);

    boolean isEffectAlwaysOn(EquipmentSlot equipmentSlot, LivingEntity livingEntity, ItemStack itemStack);

    static boolean addsEnergyShieldEffect(LivingEntity livingEntity) {
        if (livingEntity == null) {
            return false;
        }
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            if (equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                ItemStack itemBySlot = livingEntity.getItemBySlot(equipmentSlot);
                if ((itemBySlot.getItem() instanceof IEnergyShieldArmor) && itemBySlot.getItem().addsShieldEffect(equipmentSlot, livingEntity, itemBySlot)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean shouldAlwaysShowEffect(LivingEntity livingEntity) {
        if (livingEntity == null) {
            return false;
        }
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            if (equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                ItemStack itemBySlot = livingEntity.getItemBySlot(equipmentSlot);
                if ((itemBySlot.getItem() instanceof IEnergyShieldArmor) && itemBySlot.getItem().addsShieldEffect(equipmentSlot, livingEntity, itemBySlot)) {
                    IEnergyShieldArmor item = itemBySlot.getItem();
                    if (item.addsShieldEffect(equipmentSlot, livingEntity, itemBySlot) && item.isEffectAlwaysOn(equipmentSlot, livingEntity, itemBySlot)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
