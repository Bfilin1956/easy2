package mctech.items.f.g;

import mctech.api.items.IUpgradeItem;
import mctech.api.tiles.IMachine;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f/g/a.class */
public class a extends mctech.items.f.b.a.AbstractC0023a {
    @Override // mctech.items.f.b.a, mctech.api.items.IUpgradeItem
    public boolean useRedstoneInvertion(ItemStack itemStack, IMachine iMachine) {
        return true;
    }

    @Override // mctech.api.items.IUpgradeItem
    public IUpgradeItem.UpgradeType getType(ItemStack itemStack) {
        return IUpgradeItem.UpgradeType.REDSTONE_MOD;
    }
}
