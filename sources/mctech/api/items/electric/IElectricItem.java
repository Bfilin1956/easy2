package mctech.api.items.electric;

import mctech.init.MCTechDataComponent;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/electric/IElectricItem.class */
public interface IElectricItem {
    boolean canProvideEnergy(ItemStack itemStack);

    int getCapacity(ItemStack itemStack);

    int getTier(ItemStack itemStack);

    int getTransferLimit(ItemStack itemStack);

    ElectricType getElectricType(ItemStack itemStack);

    default int getCharge(ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault((DataComponentType) MCTechDataComponent.CHARGE.get(), 0)).intValue();
    }

    default void setCharge(ItemStack itemStack, int i) {
        itemStack.set((DataComponentType) MCTechDataComponent.CHARGE.get(), Integer.valueOf(i));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/electric/IElectricItem$ElectricType.class */
    public enum ElectricType {
        ARMOR,
        LAPPACK,
        TOOL,
        WEAPON,
        BATTERY;

        public boolean isArmor() {
            return this == ARMOR;
        }

        public boolean isLappack() {
            return this == LAPPACK;
        }

        public boolean isEquip() {
            return isArmor() || isLappack();
        }

        public boolean isTool() {
            return this == TOOL;
        }

        public boolean isWeapon() {
            return this == WEAPON;
        }

        public boolean isBattery() {
            return this == BATTERY;
        }

        public boolean isHandUse() {
            return isTool() || isWeapon();
        }

        public boolean isUseable() {
            return isTool() || isWeapon() || isEquip();
        }
    }
}
