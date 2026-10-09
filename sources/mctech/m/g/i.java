package mctech.m.g;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/i.class */
public class i extends x implements n, o {
    mctech.m.c.g a;

    public i(mctech.m.a.g gVar, int i, int i2, int i3, mctech.m.c.g gVar2) {
        super(gVar, i, i2, i3);
        this.a = gVar2;
    }

    public boolean mayPlace(ItemStack itemStack) {
        return this.a == null || this.a.matches(itemStack);
    }

    public boolean mayPickup(Player player) {
        return false;
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
        set(itemStack);
    }

    @Override // mctech.m.g.n
    public n.a ae_() {
        return n.a.FILTER;
    }
}
