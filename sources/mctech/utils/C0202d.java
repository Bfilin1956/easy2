package mctech.utils;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: renamed from: mctech.utils.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/d.class */
public class C0202d extends mctech.m.g.x implements mctech.m.g.n {
    private mctech.m.c.g a;

    public C0202d(mctech.m.a.g gVar, int i, int i2, int i3, mctech.m.c.g gVar2) {
        super(gVar, i, i2, i3);
        this.a = gVar2;
    }

    public boolean mayPlace(ItemStack itemStack) {
        return this.a == null || this.a.matches(itemStack);
    }

    @Override // mctech.m.g.n
    public int ad_() {
        return this.index;
    }

    @Override // mctech.m.g.n
    public int b() {
        return this.x;
    }

    @Override // mctech.m.g.n
    public int c() {
        return this.y;
    }

    @Override // mctech.m.g.n
    public boolean b(ItemStack itemStack) {
        return mayPlace(itemStack);
    }

    @Override // mctech.m.g.n
    public void a(ItemStack itemStack) {
    }
}
