package mctech.m.c;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/s.class */
public class s implements g {
    ItemStack a;
    int b;

    public s(ItemStack itemStack, int i) {
        this.a = itemStack;
        this.b = i;
    }

    public static g a(ItemStack itemStack) {
        return new s(itemStack, 20);
    }

    public static g b(ItemStack itemStack) {
        return new s(itemStack, 12);
    }

    public static g c(ItemStack itemStack) {
        return new s(itemStack, 36);
    }

    public static g d(ItemStack itemStack) {
        return new s(itemStack, 68);
    }

    public static g e(ItemStack itemStack) {
        return new s(itemStack, 5);
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        return mctech.utils.c.h.b(this.a, itemStack, this.b);
    }
}
