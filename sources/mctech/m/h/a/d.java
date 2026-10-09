package mctech.m.h.a;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenCustomHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import mctech.m.c.g;
import mctech.u.D;
import mctech.utils.c.h;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/h/a/d.class */
public class d extends a {
    IItemHandler a;

    public d(IItemHandler iItemHandler) {
        this.a = iItemHandler;
    }

    @Override // mctech.m.h.a
    public int a(ItemStack itemStack, Direction direction, boolean z) {
        int slots;
        if (itemStack.isEmpty() || (slots = this.a.getSlots()) <= 0) {
            return 0;
        }
        int count = itemStack.getCount();
        IntArrayList intArrayList = new IntArrayList(slots);
        int count2 = 0;
        for (int i = 0; i < slots; i++) {
            ItemStack stackInSlot = this.a.getStackInSlot(i);
            if (stackInSlot.isEmpty()) {
                intArrayList.add(i);
            } else if (h.d(stackInSlot, itemStack)) {
                int i2 = count - count2;
                count2 += i2 - this.a.insertItem(i, h.a(itemStack, i2), z).getCount();
                if (count2 >= count) {
                    return count2;
                }
            } else {
                continue;
            }
        }
        int size = intArrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = count - count2;
            count2 += i4 - this.a.insertItem(intArrayList.getInt(i3), h.a(itemStack, i4), z).getCount();
            if (count2 >= count) {
                return count2;
            }
        }
        return count2;
    }

    @Override // mctech.m.h.a
    public ItemStack a(g gVar, Direction direction, int i, boolean z) {
        if (i <= 0) {
            return ItemStack.EMPTY;
        }
        ItemStack itemStackExtractItem = ItemStack.EMPTY;
        int slots = this.a.getSlots();
        if (slots <= 0) {
            return itemStackExtractItem;
        }
        for (int i2 = 0; i2 < slots; i2++) {
            ItemStack stackInSlot = this.a.getStackInSlot(i2);
            if (!stackInSlot.isEmpty() && gVar.matches(stackInSlot) && (itemStackExtractItem.isEmpty() || h.d(itemStackExtractItem, stackInSlot))) {
                if (itemStackExtractItem.isEmpty()) {
                    itemStackExtractItem = this.a.extractItem(i2, i - itemStackExtractItem.getCount(), z);
                } else {
                    itemStackExtractItem.grow(this.a.extractItem(i2, i - itemStackExtractItem.getCount(), z).getCount());
                }
                if (itemStackExtractItem.getCount() >= i) {
                    return itemStackExtractItem;
                }
            }
        }
        return itemStackExtractItem;
    }

    @Override // mctech.m.h.a
    public int a(Direction direction) {
        return this.a.getSlots();
    }

    @Override // mctech.m.h.a
    public Object2IntMap<ItemStack> a(Direction direction, boolean z) {
        int slots = this.a.getSlots();
        if (slots <= 0) {
            return Object2IntMaps.emptyMap();
        }
        Object2IntLinkedOpenCustomHashMap object2IntLinkedOpenCustomHashMap = new Object2IntLinkedOpenCustomHashMap(D.a(z));
        for (int i = 0; i < slots; i++) {
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
        int slots = this.a.getSlots();
        if (slots > 0) {
            for (int i = 0; i < slots; i++) {
                c0029a.a(this.a.getStackInSlot(i), this.a.getSlotLimit(i));
            }
        }
        return c0029a;
    }
}
