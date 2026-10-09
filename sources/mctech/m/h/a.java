package mctech.m.h;

import it.unimi.dsi.fastutil.objects.AbstractObject2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenCustomHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import it.unimi.dsi.fastutil.objects.Object2LongLinkedOpenCustomHashMap;
import it.unimi.dsi.fastutil.objects.Object2LongMap;
import it.unimi.dsi.fastutil.objects.Object2LongMaps;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Iterator;
import mctech.m.c.g;
import mctech.u.D;
import mctech.utils.a.f;
import mctech.utils.c.h;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/h/a.class */
public interface a {
    int a(ItemStack itemStack, Direction direction, boolean z);

    ItemStack a(g gVar, Direction direction, int i, boolean z);

    int a(Direction direction);

    Object2IntMap<ItemStack> a(Direction direction, boolean z);

    C0029a b(Direction direction, boolean z);

    /* JADX INFO: renamed from: mctech.m.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/h/a$a.class */
    public static class C0029a {
        Object2IntLinkedOpenCustomHashMap<ItemStack> a;
        Object2LongLinkedOpenCustomHashMap<ItemStack> b;

        public C0029a(boolean z) {
            this.a = new Object2IntLinkedOpenCustomHashMap<>(D.a(z));
            this.b = new Object2LongLinkedOpenCustomHashMap<>(D.a(z));
        }

        public Object2IntLinkedOpenCustomHashMap<ItemStack> a() {
            return this.a;
        }

        public Object2LongLinkedOpenCustomHashMap<ItemStack> b() {
            return this.b;
        }

        public int a(ItemStack itemStack) {
            return (int) (this.b.getOrDefault(itemStack, 2147483647L) - ((long) this.a.getInt(itemStack)));
        }

        public long c() {
            return this.b.getLong(ItemStack.EMPTY);
        }

        public Iterable<Object2IntMap.Entry<ItemStack>> d() {
            return f.a(new Iterator<Object2IntMap.Entry<ItemStack>>() { // from class: mctech.m.h.a.a.1
                ObjectIterator<Object2IntMap.Entry<ItemStack>> a;

                {
                    this.a = Object2IntMaps.fastIterator(C0029a.this.a);
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.a.hasNext();
                }

                @Override // java.util.Iterator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Object2IntMap.Entry<ItemStack> next() {
                    Object2IntMap.Entry entry = (Object2IntMap.Entry) this.a.next();
                    ItemStack itemStack = (ItemStack) entry.getKey();
                    return new AbstractObject2IntMap.BasicEntry(itemStack, (int) Math.min(C0029a.this.b.getLong(itemStack), entry.getIntValue()));
                }
            });
        }

        public void a(C0029a c0029a) {
            ObjectIterator it = Object2IntMaps.fastIterable(c0029a.a()).iterator();
            while (it.hasNext()) {
                Object2IntMap.Entry entry = (Object2IntMap.Entry) it.next();
                this.a.addTo((ItemStack) entry.getKey(), entry.getIntValue());
            }
            ObjectIterator it2 = Object2LongMaps.fastIterable(c0029a.b()).iterator();
            while (it2.hasNext()) {
                Object2LongMap.Entry entry2 = (Object2LongMap.Entry) it2.next();
                this.b.addTo((ItemStack) entry2.getKey(), entry2.getLongValue());
            }
        }

        public void a(ItemStack itemStack, int i) {
            if (itemStack.isEmpty()) {
                this.b.put(ItemStack.EMPTY, i);
                return;
            }
            ItemStack itemStackA = h.a(itemStack, 1);
            this.a.addTo(itemStackA, itemStack.getCount());
            this.b.addTo(itemStackA, i);
        }
    }
}
