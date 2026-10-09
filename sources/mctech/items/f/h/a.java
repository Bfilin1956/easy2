package mctech.items.f.h;

import mctech.api.items.IUpgradeItem;
import mctech.api.tiles.IMachine;
import mctech.q.c;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f/h/a.class */
public class a extends mctech.items.f.b.a.AbstractC0023a {
    public a() {
        this.a.add(IUpgradeItem.Functions.TICK);
    }

    @Override // mctech.api.items.IUpgradeItem
    public IUpgradeItem.UpgradeType getType(ItemStack itemStack) {
        return IUpgradeItem.UpgradeType.ADMIN_MOD;
    }

    @Override // mctech.items.f.b.a, mctech.api.items.IUpgradeItem
    public int getExtraProcessingSpeed(ItemStack itemStack, IMachine iMachine) {
        return c.b;
    }

    @Override // mctech.items.f.b.a, mctech.api.items.IUpgradeItem
    public double getProcessingTimeMultiplier(ItemStack itemStack, IMachine iMachine) {
        return 0.0d;
    }

    @Override // mctech.items.f.b.a, mctech.api.items.IUpgradeItem
    public double getEnergyDemandMultiplier(ItemStack itemStack, IMachine iMachine) {
        return 0.0d;
    }

    @Override // mctech.items.f.b.a, mctech.api.items.IUpgradeItem
    public int getExtraTier(ItemStack itemStack, IMachine iMachine) {
        return 13;
    }
}
