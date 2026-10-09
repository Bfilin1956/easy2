package mctech.m.h.a;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenCustomHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import mctech.m.a.g;
import mctech.u.D;
import mctech.utils.c.h;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/h/a/c.class */
public class c extends a {
    g a;

    public c(g gVar) {
        this.a = gVar;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x00be A[SYNTHETIC] */
    @Override // mctech.m.h.a
    public int a(ItemStack itemStack, Direction direction, boolean z) {
        if (itemStack.isEmpty()) {
            return 0;
        }
        int iA = a(direction);
        IntArrayList intArrayList = new IntArrayList(iA);
        int count = itemStack.getCount();
        int i = 0;
        for (int i2 = 0; i2 < iA; i2++) {
            if (this.a.canInsert(i2, itemStack)) {
                ItemStack stackInSlot = this.a.getStackInSlot(i2);
                if (stackInSlot.isEmpty()) {
                    intArrayList.add(i2);
                } else if (h.d(stackInSlot, itemStack)) {
                    int iMin = Math.min(stackInSlot.getMaxStackSize() - stackInSlot.getCount(), this.a.getMaxStackSize(i2));
                    if (iMin <= 0) {
                        continue;
                    } else {
                        int iMin2 = Math.min(iMin, count - i);
                        if (!z) {
                            stackInSlot.grow(iMin2);
                            this.a.setStackInSlot(i2, stackInSlot);
                        }
                        i += iMin2;
                        if (i >= count) {
                            return i;
                        }
                    }
                } else if (i >= count) {
                    return i;
                }
            }
        }
        int size = intArrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            int iMin3 = Math.min(this.a.getMaxStackSize(i3), count - i);
            if (!z) {
                this.a.setStackInSlot(intArrayList.getInt(i3), a(itemStack, iMin3));
            }
            i += iMin3;
            if (i >= count) {
                return i;
            }
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e3 A[SYNTHETIC] */
    @Override // mctech.m.h.a
    public ItemStack a(mctech.m.c.g gVar, Direction direction, int i, boolean z) {
        if (i <= 0) {
            return ItemStack.EMPTY;
        }
        ItemStack itemStackSplit = ItemStack.EMPTY;
        int iA = a(direction);
        for (int i2 = 0; i2 < iA; i2++) {
            ItemStack stackInSlot = this.a.getStackInSlot(i2);
            if (!stackInSlot.isEmpty() && gVar.matches(stackInSlot) && (itemStackSplit.isEmpty() || h.d(itemStackSplit, stackInSlot))) {
                int count = i - itemStackSplit.getCount();
                if (z) {
                    if (itemStackSplit.isEmpty()) {
                        itemStackSplit = a(stackInSlot, Math.min(count, stackInSlot.getCount()));
                    } else {
                        itemStackSplit.grow(Math.min(stackInSlot.getCount(), count));
                        if (itemStackSplit.getCount() >= i) {
                            return itemStackSplit;
                        }
                    }
                } else {
                    ItemStack stackInSlot2 = this.a.getStackInSlot(i2);
                    if (itemStackSplit.isEmpty()) {
                        itemStackSplit = stackInSlot2.split(count);
                        this.a.setStackInSlot(i2, stackInSlot2);
                    } else {
                        itemStackSplit.grow(stackInSlot2.split(count).getCount());
                        this.a.setStackInSlot(i2, stackInSlot2);
                        if (itemStackSplit.getCount() >= i) {
                            return itemStackSplit;
                        }
                    }
                }
            }
        }
        return itemStackSplit;
    }

    @Override // mctech.m.h.a
    public int a(Direction direction) {
        return this.a.getSlotCount();
    }

    @Override // mctech.m.h.a
    public Object2IntMap<ItemStack> a(Direction direction, boolean z) {
        int slotCount = this.a.getSlotCount();
        if (slotCount <= 0) {
            return Object2IntMaps.emptyMap();
        }
        Object2IntLinkedOpenCustomHashMap object2IntLinkedOpenCustomHashMap = new Object2IntLinkedOpenCustomHashMap(D.a(z));
        for (int i = 0; i < slotCount; i++) {
            ItemStack stackInSlot = this.a.getStackInSlot(i);
            if (!stackInSlot.isEmpty()) {
                object2IntLinkedOpenCustomHashMap.addTo(h.a(stackInSlot, 1), stackInSlot.getCount());
            }
        }
        return object2IntLinkedOpenCustomHashMap;
    }

    @Override // mctech.m.h.a
    public mctech.m.h.a.C0029a b(Direction direction, boolean z) {
        mctech.m.h.a.C0029a c0029a = new mctech.m.h.a.C0029a(z);
        int slotCount = this.a.getSlotCount();
        if (slotCount > 0) {
            for (int i = 0; i < slotCount; i++) {
                c0029a.a(this.a.getStackInSlot(i), this.a.getMaxStackSize(i));
            }
        }
        return c0029a;
    }
}
