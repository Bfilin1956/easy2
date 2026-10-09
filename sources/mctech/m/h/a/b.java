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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/h/a/b.class */
public class b extends a {
    BlockEntity a;

    public b(BlockEntity blockEntity) {
        this.a = blockEntity;
    }

    private IItemHandler b(Direction direction) {
        IItemHandler iItemHandler = (IItemHandler) Capabilities.ItemHandler.BLOCK.getCapability(this.a.getLevel(), this.a.getBlockPos(), this.a.getBlockState(), this.a, direction);
        return iItemHandler == null ? mctech.m.e.c.a : iItemHandler;
    }

    @Override // mctech.m.h.a
    public int a(ItemStack itemStack, Direction direction, boolean z) {
        IItemHandler iItemHandlerB;
        int slots;
        if (itemStack.isEmpty() || (slots = (iItemHandlerB = b(direction)).getSlots()) <= 0) {
            return 0;
        }
        int count = itemStack.getCount();
        IntArrayList intArrayList = new IntArrayList(slots);
        int count2 = 0;
        for (int i = 0; i < slots; i++) {
            ItemStack stackInSlot = iItemHandlerB.getStackInSlot(i);
            if (stackInSlot.isEmpty()) {
                intArrayList.add(i);
            } else if (h.d(stackInSlot, itemStack)) {
                int i2 = count - count2;
                count2 += i2 - iItemHandlerB.insertItem(i, h.a(itemStack, i2), z).getCount();
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
            count2 += i4 - iItemHandlerB.insertItem(intArrayList.getInt(i3), h.a(itemStack, i4), z).getCount();
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
        IItemHandler iItemHandlerB = b(direction);
        ItemStack itemStackExtractItem = ItemStack.EMPTY;
        int slots = iItemHandlerB.getSlots();
        if (slots <= 0) {
            return itemStackExtractItem;
        }
        for (int i2 = 0; i2 < slots; i2++) {
            ItemStack stackInSlot = iItemHandlerB.getStackInSlot(i2);
            if (!stackInSlot.isEmpty() && gVar.matches(stackInSlot) && (itemStackExtractItem.isEmpty() || h.d(itemStackExtractItem, stackInSlot))) {
                if (itemStackExtractItem.isEmpty()) {
                    itemStackExtractItem = iItemHandlerB.extractItem(i2, i - itemStackExtractItem.getCount(), z);
                } else {
                    itemStackExtractItem.grow(iItemHandlerB.extractItem(i2, i - itemStackExtractItem.getCount(), z).getCount());
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
        return b(direction).getSlots();
    }

    @Override // mctech.m.h.a
    public Object2IntMap<ItemStack> a(Direction direction, boolean z) {
        IItemHandler iItemHandlerB = b(direction);
        int slots = iItemHandlerB.getSlots();
        if (slots <= 0) {
            return Object2IntMaps.emptyMap();
        }
        Object2IntLinkedOpenCustomHashMap object2IntLinkedOpenCustomHashMap = new Object2IntLinkedOpenCustomHashMap(D.a(z));
        for (int i = 0; i < slots; i++) {
            ItemStack stackInSlot = iItemHandlerB.getStackInSlot(i);
            if (!stackInSlot.isEmpty()) {
                object2IntLinkedOpenCustomHashMap.addTo(h.a(stackInSlot, 1), stackInSlot.getCount());
            }
        }
        return object2IntLinkedOpenCustomHashMap;
    }

    @Override // mctech.m.h.a
    public mctech.m.h.a.C0029a b(Direction direction, boolean z) {
        mctech.m.h.a.C0029a c0029a = new mctech.m.h.a.C0029a(z);
        IItemHandler iItemHandlerB = b(direction);
        int slots = iItemHandlerB.getSlots();
        if (slots > 0) {
            for (int i = 0; i < slots; i++) {
                c0029a.a(iItemHandlerB.getStackInSlot(i), iItemHandlerB.getSlotLimit(i));
            }
        }
        return c0029a;
    }
}
