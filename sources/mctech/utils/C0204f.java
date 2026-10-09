package mctech.utils;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: renamed from: mctech.utils.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/f.class */
public class C0204f extends mctech.m.g.g implements mctech.m.a.j {
    private mctech.blockentities.b.a a;

    public C0204f(mctech.blockentities.b.a aVar, int i, int i2, int i3, mctech.m.c.g gVar) {
        super(aVar, i, i2, i3, gVar);
        this.a = aVar;
    }

    @Override // mctech.m.g.g
    public boolean mayPlace(ItemStack itemStack) {
        if (!(itemStack.getItem() instanceof mctech.items.base.m)) {
            return false;
        }
        for (int i = 0; i < this.a.i; i++) {
            Item item = ((ItemStack) this.a.inventory.get(i)).getItem();
            if ((item instanceof mctech.items.base.m) && ((mctech.items.base.m) item).a() == ((mctech.items.base.m) itemStack.getItem()).a()) {
                return false;
            }
        }
        return super.mayPlace(itemStack);
    }

    @Override // mctech.m.g.g, mctech.m.g.n
    public boolean b(ItemStack itemStack) {
        return super.b(itemStack);
    }

    @Override // mctech.m.a.j
    public int o() {
        return 10;
    }
}
