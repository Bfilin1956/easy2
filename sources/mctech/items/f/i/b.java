package mctech.items.f.i;

import mctech.api.items.IUpgradeItem;
import mctech.api.tiles.IMachine;
import mctech.items.base.o;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f/i/b.class */
public class b extends mctech.items.f.b.a.AbstractC0023a {
    protected int b;
    protected int c;
    protected int d;

    public b(int i, int i2, int i3, int i4) {
        super(new o().a(1).c(i));
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.a.add(IUpgradeItem.Functions.RECIPE);
    }

    @Override // mctech.api.items.IUpgradeItem
    public IUpgradeItem.UpgradeType getType(ItemStack itemStack) {
        return IUpgradeItem.UpgradeType.SAWMILL_MOD;
    }

    @Override // mctech.items.f.b.a, mctech.api.items.IUpgradeItem
    public int getExtraEnergyDemand(ItemStack itemStack, IMachine iMachine) {
        return this.c;
    }

    @Override // mctech.items.f.b.a, mctech.api.items.IUpgradeItem
    public int getExtraProcessingSpeed(ItemStack itemStack, IMachine iMachine) {
        return this.d;
    }
}
