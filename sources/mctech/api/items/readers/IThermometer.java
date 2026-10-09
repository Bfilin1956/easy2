package mctech.api.items.readers;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/readers/IThermometer.class */
public interface IThermometer {
    boolean isThermometer(ItemStack itemStack);

    static boolean isThermometerImpl(ItemStack itemStack) {
        IThermometer item = itemStack.getItem();
        return (item instanceof IThermometer) && item.isThermometer(itemStack);
    }
}
