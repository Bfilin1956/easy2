package mctech.m.g;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/l.class */
public class l extends x implements n {
    private boolean a;

    public l(mctech.m.a.g gVar, int i, int i2, int i3) {
        super(gVar, i, i2, i3);
    }

    public boolean mayPlace(@NotNull ItemStack itemStack) {
        return !this.a;
    }

    public boolean mayPickup(Player player) {
        return !this.a;
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

    public boolean e() {
        return this.a;
    }

    public l a(boolean z) {
        if (this.a && !z) {
            this.x += 9000;
            this.y += 9000;
        } else if (!this.a && z) {
            this.x -= 9000;
            this.y -= 9000;
        }
        this.a = z;
        return this;
    }
}
