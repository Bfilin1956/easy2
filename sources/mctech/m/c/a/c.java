package mctech.m.c.a;

import mctech.api.energy.IEnergyCrystal;
import mctech.api.items.electric.ElectricItem;
import mctech.m.c.k;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/a/c.class */
public class c implements mctech.m.c.g {
    public static final mctech.m.c.g a = new c(true, false);
    public static final mctech.m.c.g b = new k(a);
    public static final mctech.m.c.g c = new c(false, true);
    public static final mctech.m.c.g d = new c(false, false);
    public static final mctech.m.c.g e = new k(d);
    public static final mctech.m.c.g f = itemStack -> {
        return ((mctech.energy.e) ElectricItem.MANAGER).a(itemStack) != null;
    };
    public static final mctech.m.c.g g = itemStack -> {
        IEnergyCrystal item = itemStack.getItem();
        if (!(item instanceof IEnergyCrystal)) {
            return false;
        }
        IEnergyCrystal iEnergyCrystal = item;
        return iEnergyCrystal.getCharge(itemStack) < iEnergyCrystal.getEnergyCapacity();
    };
    public static final mctech.m.c.g h = itemStack -> {
        IEnergyCrystal item = itemStack.getItem();
        return (item instanceof IEnergyCrystal) && item.getCharge(itemStack) > 0;
    };
    private boolean i;
    private boolean j;
    private int k;

    public c(boolean z, boolean z2) {
        this(z, z2, Integer.MAX_VALUE);
    }

    public c(boolean z, boolean z2, int i) {
        this.i = z;
        this.j = z2;
        this.k = i;
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        if (this.i) {
            return ElectricItem.MANAGER.charge(itemStack, Integer.MAX_VALUE, this.k, true, true) > 0;
        }
        return mctech.energy.a.a(itemStack) || itemStack.is(Items.REDSTONE) || ElectricItem.MANAGER.discharge(itemStack, Integer.MAX_VALUE, this.k, true, this.j, true) > 0;
    }
}
