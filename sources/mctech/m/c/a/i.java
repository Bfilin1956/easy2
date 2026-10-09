package mctech.m.c.a;

import mctech.blockentities.c.C0074u;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/a/i.class */
public class i implements mctech.m.c.g {
    ItemStack a;
    int b;
    int c;
    boolean d;

    public i(ItemStack itemStack, int i, int i2) {
        this.a = itemStack;
        this.b = i;
        this.c = i2;
        this.d = !itemStack.isDamageableItem() || (i & mctech.utils.c.h.i) == 0;
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        if (!mctech.utils.c.h.b(this.a, itemStack, this.b)) {
            return false;
        }
        if (this.d) {
            return true;
        }
        switch (this.c) {
            case 0:
                return this.a.getDamageValue() == itemStack.getDamageValue();
            case 1:
                return ((double) itemStack.getDamageValue()) / ((double) itemStack.getMaxDamage()) < 0.01d;
            case 2:
                return ((double) itemStack.getDamageValue()) / ((double) itemStack.getMaxDamage()) > 0.01d;
            case 3:
                return ((double) itemStack.getDamageValue()) / ((double) itemStack.getMaxDamage()) < 0.25d;
            case 4:
                return ((double) itemStack.getDamageValue()) / ((double) itemStack.getMaxDamage()) > 0.25d;
            case 5:
                return ((double) itemStack.getDamageValue()) / ((double) itemStack.getMaxDamage()) < 0.5d;
            case 6:
                return ((double) itemStack.getDamageValue()) / ((double) itemStack.getMaxDamage()) > 0.5d;
            case 7:
                return ((double) itemStack.getDamageValue()) / ((double) itemStack.getMaxDamage()) < 0.75d;
            case 8:
                return ((double) itemStack.getDamageValue()) / ((double) itemStack.getMaxDamage()) > 0.75d;
            case 9:
                return ((double) itemStack.getDamageValue()) / ((double) itemStack.getMaxDamage()) < 0.9d;
            case C0074u.j /* 10 */:
                return ((double) itemStack.getDamageValue()) / ((double) itemStack.getMaxDamage()) > 0.9d;
            default:
                return true;
        }
    }
}
