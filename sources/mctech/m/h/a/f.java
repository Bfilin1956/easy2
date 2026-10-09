package mctech.m.h.a;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenCustomHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import mctech.m.c.g;
import mctech.u.D;
import mctech.utils.c.h;
import net.minecraft.core.Direction;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/h/a/f.class */
public class f extends a {
    Container a;

    public f(Container container) {
        this.a = container;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:48:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00cd A[SYNTHETIC] */
    @Override // mctech.m.h.a
    public int a(ItemStack itemStack, Direction direction, boolean z) {
        if (itemStack.isEmpty()) {
            return 0;
        }
        int iA = a(direction);
        int maxStackSize = this.a.getMaxStackSize();
        IntArrayList intArrayList = new IntArrayList(iA);
        int count = itemStack.getCount();
        int i = 0;
        for (int i2 = 0; i2 < iA; i2++) {
            if (this.a.canPlaceItem(i2, itemStack)) {
                ItemStack item = this.a.getItem(i2);
                if (item.isEmpty()) {
                    intArrayList.add(i2);
                } else if (h.d(item, itemStack)) {
                    int iMin = Math.min(item.getMaxStackSize() - item.getCount(), maxStackSize);
                    if (iMin <= 0) {
                        continue;
                    } else {
                        int iMin2 = Math.min(iMin, count - i);
                        if (!z) {
                            item.grow(iMin2);
                            this.a.setItem(i2, item);
                        }
                        i += iMin2;
                        if (i >= count) {
                            if (!z) {
                                this.a.setChanged();
                            }
                            return i;
                        }
                    }
                } else if (i >= count) {
                    if (!z) {
                        this.a.setChanged();
                    }
                    return i;
                }
            }
        }
        int size = intArrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            int iMin3 = Math.min(maxStackSize, count - i);
            if (!z) {
                this.a.setItem(intArrayList.getInt(i3), a(itemStack, iMin3));
            }
            i += iMin3;
            if (i >= count) {
                if (!z) {
                    this.a.setChanged();
                }
                return i;
            }
        }
        return i;
    }

    @Override // mctech.m.h.a
    public ItemStack a(g gVar, Direction direction, int i, boolean z) {
        if (i <= 0) {
            return ItemStack.EMPTY;
        }
        ItemStack itemStackRemoveItem = ItemStack.EMPTY;
        int iA = a(direction);
        for (int i2 = 0; i2 < iA; i2++) {
            ItemStack item = this.a.getItem(i2);
            if (!item.isEmpty() && gVar.matches(item) && (itemStackRemoveItem.isEmpty() || h.d(itemStackRemoveItem, item))) {
                int count = i - itemStackRemoveItem.getCount();
                if (z) {
                    if (itemStackRemoveItem.isEmpty()) {
                        itemStackRemoveItem = a(item, Math.min(count, item.getCount()));
                    } else {
                        itemStackRemoveItem.grow(Math.min(item.getCount(), count));
                    }
                } else if (itemStackRemoveItem.isEmpty()) {
                    itemStackRemoveItem = this.a.removeItem(i2, count);
                } else {
                    itemStackRemoveItem.grow(this.a.removeItem(i2, count).getCount());
                }
                if (itemStackRemoveItem.getCount() >= i) {
                    if (!z) {
                        this.a.setChanged();
                    }
                    return itemStackRemoveItem;
                }
            }
        }
        return itemStackRemoveItem;
    }

    @Override // mctech.m.h.a
    public int a(Direction direction) {
        return this.a.getContainerSize();
    }

    @Override // mctech.m.h.a
    public Object2IntMap<ItemStack> a(Direction direction, boolean z) {
        int containerSize = this.a.getContainerSize();
        if (containerSize <= 0) {
            return Object2IntMaps.emptyMap();
        }
        Object2IntLinkedOpenCustomHashMap object2IntLinkedOpenCustomHashMap = new Object2IntLinkedOpenCustomHashMap(D.a(z));
        for (int i = 0; i < containerSize; i++) {
            ItemStack item = this.a.getItem(i);
            if (!item.isEmpty()) {
                object2IntLinkedOpenCustomHashMap.addTo(h.a(item, 1), item.getCount());
            }
        }
        return object2IntLinkedOpenCustomHashMap;
    }

    @Override // mctech.m.h.a
    public mctech.m.h.a.C0029a b(Direction direction, boolean z) {
        mctech.m.h.a.C0029a c0029a = new mctech.m.h.a.C0029a(z);
        int containerSize = this.a.getContainerSize();
        if (containerSize > 0) {
            for (int i = 0; i < containerSize; i++) {
                c0029a.a(this.a.getItem(i), this.a.getMaxStackSize());
            }
        }
        return c0029a;
    }
}
