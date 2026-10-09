package mctech.m.h.a.a;

import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenCustomHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.List;
import mctech.m.c.g;
import mctech.m.c.s;
import mctech.u.D;
import mctech.utils.c.h;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/h/a/a/b.class */
public class b extends mctech.m.h.a.a {
    List<mctech.m.h.a> a;

    public b(mctech.m.h.a... aVarArr) {
        this.a = ObjectArrayList.wrap(aVarArr);
    }

    public b(List<mctech.m.h.a> list) {
        this.a = list;
    }

    @Override // mctech.m.h.a
    public int a(ItemStack itemStack, Direction direction, boolean z) {
        if (itemStack.isEmpty()) {
            return 0;
        }
        int iA = 0;
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            iA += this.a.get(i).a(h.a(itemStack, itemStack.getCount() - iA), direction, z);
            if (iA >= itemStack.getCount()) {
                return iA;
            }
        }
        return iA;
    }

    @Override // mctech.m.h.a
    public ItemStack a(g gVar, Direction direction, int i, boolean z) {
        if (i <= 0) {
            return ItemStack.EMPTY;
        }
        ItemStack itemStackA = ItemStack.EMPTY;
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (itemStackA.isEmpty()) {
                itemStackA = this.a.get(i2).a(gVar, direction, i, z);
                if (!itemStackA.isEmpty()) {
                    gVar = s.a(itemStackA);
                }
            } else {
                if (itemStackA.getCount() >= i) {
                    break;
                }
                itemStackA.grow(this.a.get(i2).a(gVar, direction, i - itemStackA.getCount(), z).getCount());
            }
        }
        return itemStackA;
    }

    @Override // mctech.m.h.a
    public int a(Direction direction) {
        int iA = 0;
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            iA += this.a.get(i).a(direction);
        }
        return iA;
    }

    @Override // mctech.m.h.a
    public Object2IntMap<ItemStack> a(Direction direction, boolean z) {
        Object2IntLinkedOpenCustomHashMap object2IntLinkedOpenCustomHashMap = new Object2IntLinkedOpenCustomHashMap(D.a(z));
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ObjectIterator it = Object2IntMaps.fastIterable(this.a.get(i).a(direction, z)).iterator();
            while (it.hasNext()) {
                Object2IntMap.Entry entry = (Object2IntMap.Entry) it.next();
                object2IntLinkedOpenCustomHashMap.addTo((ItemStack) entry.getKey(), entry.getIntValue());
            }
        }
        return object2IntLinkedOpenCustomHashMap;
    }

    @Override // mctech.m.h.a
    public mctech.m.h.a.C0029a b(Direction direction, boolean z) {
        mctech.m.h.a.C0029a c0029a = new mctech.m.h.a.C0029a(z);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            c0029a.a(this.a.get(i).b(direction, z));
        }
        return c0029a;
    }
}
