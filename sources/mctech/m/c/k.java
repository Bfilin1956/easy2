package mctech.m.c;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/k.class */
public class k implements g {
    private g a;

    public k(g gVar) {
        this.a = gVar;
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        return !this.a.matches(itemStack);
    }
}
