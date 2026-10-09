package mctech.items.f.c;

import mctech.api.items.IUpgradeItem;
import mctech.api.tiles.IMachine;
import mctech.items.base.o;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f/c/a.class */
public class a extends mctech.items.f.b.a.AbstractC0023a {
    public a() {
        super(new o().a(3));
    }

    @Override // mctech.api.items.IUpgradeItem
    public IUpgradeItem.UpgradeType getType(ItemStack itemStack) {
        return IUpgradeItem.UpgradeType.ENERGY_MOD;
    }

    @Override // mctech.items.f.b.a, mctech.api.items.IUpgradeItem
    public double getEnergyStorageMultiplier(ItemStack itemStack, IMachine iMachine) {
        return 2.0d;
    }
}
