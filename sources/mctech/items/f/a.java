package mctech.items.f;

import mctech.api.items.IUpgradeItem;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f/a.class */
public class a extends mctech.items.f.b.a.AbstractC0023a {
    @Override // mctech.api.items.IUpgradeItem
    public IUpgradeItem.UpgradeType getType(ItemStack itemStack) {
        return IUpgradeItem.UpgradeType.COMPLEX_HANDLER_MOD;
    }

    @Override // mctech.api.items.IUpgradeItem
    public int getOutputCount() {
        return 1;
    }
}
