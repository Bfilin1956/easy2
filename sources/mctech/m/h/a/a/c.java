package mctech.m.h.a.a;

import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenCustomHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import mctech.m.a.g;
import mctech.u.D;
import mctech.utils.c.h;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/h/a/a/c.class */
public class c extends mctech.m.h.a.a {
    g a;

    public c(g gVar) {
        this.a = gVar;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x00a8 A[SYNTHETIC] */
    @Override // mctech.m.h.a
    public int a(ItemStack itemStack, Direction direction, boolean z) {
        if (itemStack.isEmpty()) {
            return 0;
        }
        int iA = a(direction);
        int count = itemStack.getCount();
        int i = 0;
        for (int i2 = 0; i2 < iA; i2++) {
            if (this.a.canInsert(i2, itemStack)) {
                ItemStack stackInSlot = this.a.getStackInSlot(i2);
                if (stackInSlot.isEmpty()) {
                    continue;
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
        return i;
    }

    @Override // mctech.m.h.a
    public ItemStack a(mctech.m.c.g gVar, Direction direction, int i, boolean z) {
        return ItemStack.EMPTY;
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
                ItemStack stackInSlot = this.a.getStackInSlot(i);
                if (!stackInSlot.isEmpty()) {
                    c0029a.a(stackInSlot, this.a.getMaxStackSize(i));
                }
            }
        }
        return c0029a;
    }
}
