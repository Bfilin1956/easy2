package mctech.m.c;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/d.class */
public class d implements g {
    private Class<?> a;

    public d(Class<?> cls) {
        this.a = cls;
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        return this.a.isInstance(itemStack.getItem());
    }
}
