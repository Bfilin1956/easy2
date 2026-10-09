package mctech.m.c;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterators;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/a.class */
public class a implements g {
    ObjectList<g> a;

    public a(Iterable<g> iterable) {
        this.a = mctech.utils.a.b.i();
        ObjectIterators.pour(iterable.iterator(), this.a);
    }

    public a(g... gVarArr) {
        ObjectList<g> objectListI = mctech.utils.a.b.i();
        this.a = objectListI;
        objectListI.addAll(ObjectArrayList.wrap(gVarArr));
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (!((g) this.a.get(i)).matches(itemStack)) {
                return false;
            }
        }
        return true;
    }
}
