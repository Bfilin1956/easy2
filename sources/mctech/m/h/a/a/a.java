package mctech.m.h.a.a;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import mctech.m.c.g;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/h/a/a/a.class */
public class a implements mctech.m.h.a {
    mctech.m.h.a a;
    Direction b;

    public a(mctech.m.h.a aVar, Direction direction) {
        this.a = aVar;
        this.b = direction;
    }

    @Override // mctech.m.h.a
    public int a(ItemStack itemStack, Direction direction, boolean z) {
        if (itemStack.isEmpty()) {
            return 0;
        }
        return this.a.a(itemStack, this.b, z);
    }

    @Override // mctech.m.h.a
    public ItemStack a(g gVar, Direction direction, int i, boolean z) {
        return i <= 0 ? ItemStack.EMPTY : this.a.a(gVar, this.b, i, z);
    }

    @Override // mctech.m.h.a
    public int a(Direction direction) {
        return this.a.a(this.b);
    }

    @Override // mctech.m.h.a
    public Object2IntMap<ItemStack> a(Direction direction, boolean z) {
        return this.a.a(this.b, z);
    }

    @Override // mctech.m.h.a
    public mctech.m.h.a.C0029a b(Direction direction, boolean z) {
        return this.a.b(this.b, z);
    }
}
