package mctech.m.g;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/f.class */
public class f extends x implements n {
    private boolean a;
    private boolean b;

    public f(mctech.m.a.g gVar, int i, int i2, int i3) {
        super(gVar, i, i2, i3);
    }

    public f a(boolean z) {
        this.b = z;
        return this;
    }

    public boolean mayPlace(ItemStack itemStack) {
        return false;
    }

    public boolean mayPickup(Player player) {
        return this.b;
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
        return false;
    }

    @Override // mctech.m.g.n
    public void a(ItemStack itemStack) {
    }

    @NotNull
    public ItemStack safeTake(int i, int i2, @NotNull Player player) {
        if (this.b) {
            set(ItemStack.EMPTY);
            return ItemStack.EMPTY;
        }
        return super.safeTake(i, i2, player);
    }

    @Override // mctech.m.g.x
    @NotNull
    public ItemStack remove(int i) {
        if (this.b) {
            set(ItemStack.EMPTY);
            return ItemStack.EMPTY;
        }
        return super.remove(i);
    }

    public boolean d() {
        return this.a;
    }

    public void b(boolean z) {
        if (this.a && !z) {
            this.x += 9000;
            this.y += 9000;
        } else if (!this.a && z) {
            this.x -= 9000;
            this.y -= 9000;
        }
        this.a = z;
    }
}
