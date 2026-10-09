package mctech.api.items.armor;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/armor/ICustomArmor.class */
public interface ICustomArmor {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/armor/ICustomArmor$DamageType.class */
    public enum DamageType {
        MODDED,
        VANILLA,
        THORNS_SELF
    }

    AbsorptionProperties getProperties(LivingEntity livingEntity, ItemStack itemStack, DamageSource damageSource, double d, EquipmentSlot equipmentSlot);

    void damageArmor(LivingEntity livingEntity, ItemStack itemStack, DamageSource damageSource, int i, EquipmentSlot equipmentSlot, DamageType damageType);

    default boolean canBlockDamageSource(LivingEntity livingEntity, ItemStack itemStack, DamageSource damageSource, EquipmentSlot equipmentSlot) {
        return false;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/armor/ICustomArmor$AbsorptionProperties.class */
    public static class AbsorptionProperties implements Comparable<AbsorptionProperties> {
        public int priority;
        public int absorbMax;
        public double absorbRatio;
        public EquipmentSlot slot;

        public AbsorptionProperties(int i, double d, int i2) {
            this.slot = null;
            this.priority = i;
            this.absorbMax = i2;
            this.absorbRatio = d;
        }

        private AbsorptionProperties(AbsorptionProperties absorptionProperties) {
            this.slot = null;
            this.priority = absorptionProperties.priority;
            this.absorbMax = absorptionProperties.absorbMax;
            this.absorbRatio = absorptionProperties.absorbRatio;
            this.slot = absorptionProperties.slot;
        }

        private int calcMaxAbsorption() {
            return (int) (this.absorbRatio == 0.0d ? 0.0d : (((double) this.absorbMax) * 100.0d) / this.absorbRatio);
        }

        @Override // java.lang.Comparable
        public int compareTo(AbsorptionProperties absorptionProperties) {
            if (absorptionProperties.priority != this.priority) {
                return absorptionProperties.priority - this.priority;
            }
            return calcMaxAbsorption() - absorptionProperties.calcMaxAbsorption();
        }

        public String toString() {
            return String.format("%d, %d, %f, %d", Integer.valueOf(this.priority), Integer.valueOf(this.absorbMax), Double.valueOf(this.absorbRatio), Integer.valueOf(calcMaxAbsorption()));
        }

        public AbsorptionProperties copy() {
            return new AbsorptionProperties(this);
        }
    }
}
