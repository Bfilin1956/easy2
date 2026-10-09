package mctech.m.f;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/n.class */
public class n implements IItemHandler {
    IItemHandler a;
    Direction b;
    NonNullList<ItemStack> c;
    int[] d;

    public n(IItemHandler iItemHandler, Direction direction) {
        this.a = iItemHandler;
        this.c = NonNullList.withSize(iItemHandler.getSlots(), ItemStack.EMPTY);
        this.d = new int[this.c.size()];
        for (int i = 0; i < this.c.size(); i++) {
            ItemStack itemStackCopy = iItemHandler.getStackInSlot(i).copy();
            this.d[i] = itemStackCopy.getCount();
            this.c.set(i, itemStackCopy);
        }
    }

    public static IItemHandler a(IItemHandler iItemHandler, Direction direction, Object2IntMap<ItemStack> object2IntMap) {
        if (iItemHandler == null) {
            return null;
        }
        return new n(iItemHandler, direction).a(object2IntMap);
    }

    public IItemHandler a(Object2IntMap<ItemStack> object2IntMap) {
        mctech.m.h.a.d dVar = new mctech.m.h.a.d(this);
        ObjectIterator it = Object2IntMaps.fastIterable(object2IntMap).iterator();
        while (it.hasNext()) {
            Object2IntMap.Entry entry = (Object2IntMap.Entry) it.next();
            ItemStack itemStack = (ItemStack) entry.getKey();
            if (!itemStack.isEmpty()) {
                dVar.a(mctech.utils.c.h.a(itemStack, entry.getIntValue()), this.b, false);
            }
        }
        return this;
    }

    public int getSlots() {
        return this.c.size();
    }

    public ItemStack getStackInSlot(int i) {
        return (ItemStack) this.c.get(i);
    }

    public ItemStack insertItem(int i, ItemStack itemStack, boolean z) {
        if (itemStack.isEmpty()) {
            return ItemStack.EMPTY;
        }
        if (!isItemValid(i, itemStack)) {
            return itemStack;
        }
        int slotLimit = getSlotLimit(i);
        int iMin = Math.min((slotLimit - this.a.insertItem(i, mctech.utils.c.h.a(itemStack, slotLimit), true).getCount()) - (((ItemStack) this.c.get(i)).getCount() - this.d[i]), itemStack.getCount());
        if (iMin <= 0) {
            return itemStack;
        }
        return a(i, mctech.utils.c.h.a(itemStack, Math.max(iMin, itemStack.getCount())), false);
    }

    public ItemStack a(int i, ItemStack itemStack, boolean z) {
        ItemStack itemStack2 = (ItemStack) this.c.get(i);
        int slotLimit = getSlotLimit(i);
        if (!itemStack2.isEmpty()) {
            if (!mctech.utils.c.h.e(itemStack, itemStack2)) {
                return itemStack;
            }
            slotLimit -= itemStack2.getCount();
        }
        if (slotLimit <= 0) {
            return itemStack;
        }
        boolean z2 = itemStack.getCount() > slotLimit;
        if (!z) {
            if (itemStack2.isEmpty()) {
                this.c.set(i, z2 ? mctech.utils.c.h.a(itemStack, slotLimit) : itemStack);
            } else {
                itemStack2.grow(z2 ? slotLimit : itemStack.getCount());
            }
        }
        return z2 ? mctech.utils.c.h.a(itemStack, itemStack.getCount() - slotLimit) : ItemStack.EMPTY;
    }

    public ItemStack extractItem(int i, int i2, boolean z) {
        if (i2 == 0 || i < 0 || i >= this.c.size()) {
            return ItemStack.EMPTY;
        }
        ItemStack itemStack = (ItemStack) this.c.get(i);
        if (itemStack.isEmpty()) {
            return ItemStack.EMPTY;
        }
        int iMin = Math.min(i2, itemStack.getMaxStackSize());
        if (itemStack.getCount() > iMin) {
            if (!z) {
                this.c.set(i, mctech.utils.c.h.a(itemStack, itemStack.getCount() - iMin));
            }
            return mctech.utils.c.h.a(itemStack, iMin);
        }
        if (!z) {
            this.c.set(i, ItemStack.EMPTY);
            return itemStack;
        }
        return itemStack.copy();
    }

    protected int a(int i, ItemStack itemStack) {
        return getSlotLimit(i);
    }

    public int getSlotLimit(int i) {
        return this.a.getSlotLimit(i);
    }

    public boolean isItemValid(int i, ItemStack itemStack) {
        return this.a.isItemValid(i, itemStack);
    }
}
