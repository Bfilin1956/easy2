package mctech.items.d.c;

import java.util.List;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/c/g.class */
public abstract class g implements mctech.items.d.a.b {
    private List<int[]> a = mctech.utils.a.b.i();

    public g() {
        a(-1, 0);
        a(1, 0);
        a(0, -1);
        a(0, 1);
    }

    public void a(int... iArr) {
        this.a.add(iArr);
    }

    @Override // mctech.items.d.a.b
    public List<int[]> e() {
        return this.a;
    }

    @Override // mctech.items.d.a.b
    public List<int[]> f() {
        return this.a;
    }

    @Override // mctech.items.d.a.b
    public ItemStack n() {
        return a(1);
    }
}
