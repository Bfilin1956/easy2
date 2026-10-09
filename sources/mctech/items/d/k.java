package mctech.items.d;

import mctech.api.items.IRepairable;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/k.class */
public class k extends n implements IRepairable {
    public k() {
        super(320000, true, 53);
    }

    @Override // mctech.api.items.IRepairable
    public boolean repairDamage(ItemStack itemStack, int i) {
        if (itemStack.getDamageValue() > 0) {
            itemStack.setDamageValue(Math.max(0, itemStack.getDamageValue() - i));
            return true;
        }
        return false;
    }
}
