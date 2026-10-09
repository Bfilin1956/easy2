package mctech.items.f.c;

import mctech.api.items.IUpgradeItem;
import mctech.api.tiles.IMachine;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f/c/b.class */
public class b extends mctech.items.f.b.a.AbstractC0023a {
    @Override // mctech.items.f.b.a, mctech.api.items.IUpgradeItem
    public int getExtraEnergyStorage(ItemStack itemStack, IMachine iMachine) {
        return 10000;
    }

    @Override // mctech.api.items.IUpgradeItem
    public IUpgradeItem.UpgradeType getType(ItemStack itemStack) {
        return IUpgradeItem.UpgradeType.ENERGY_MOD;
    }
}
