package mctech.m.f;

import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import java.util.List;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/m.class */
public class m implements mctech.m.a.g, mctech.m.a.h {
    protected NonNullList<ItemStack> a;
    protected int b;
    protected int c = 64;

    public m(int i) {
        this.b = i;
        this.a = NonNullList.withSize(i, ItemStack.EMPTY);
    }

    public m a(int i) {
        this.c = i;
        return this;
    }

    @Override // mctech.m.a.g
    public int getSlotCount() {
        return this.b;
    }

    @Override // mctech.m.a.g
    public ItemStack getStackInSlot(int i) {
        return (ItemStack) this.a.get(i);
    }

    @Override // mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        this.a.set(i, itemStack);
    }

    @Override // mctech.m.a.g
    public int getMaxStackSize(int i) {
        return this.c;
    }

    @Override // mctech.m.a.g
    public boolean canInsert(int i, ItemStack itemStack) {
        return true;
    }

    @Override // mctech.m.a.g
    public boolean canExtract(int i, ItemStack itemStack) {
        return true;
    }

    @Override // mctech.m.a.h
    public void b(HolderLookup.Provider provider, CompoundTag compoundTag) {
        ContainerHelper.loadAllItems(compoundTag, this.a, provider);
    }

    @Override // mctech.m.a.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CompoundTag c(HolderLookup.Provider provider, CompoundTag compoundTag) {
        ContainerHelper.saveAllItems(compoundTag, this.a, provider);
        return compoundTag;
    }

    public void a(List<ItemStack> list) {
        for (int i = 0; i < this.b; i++) {
            if (!((ItemStack) this.a.get(i)).isEmpty()) {
                list.add((ItemStack) this.a.get(i));
            }
        }
    }

    public void a(mctech.m.a.g gVar) {
        int iMin = Math.min(getSlotCount(), gVar.getSlotCount());
        for (int i = 0; i < iMin; i++) {
            gVar.setStackInSlot(i, (ItemStack) this.a.get(i));
        }
    }

    public void b(mctech.m.a.g gVar) {
        a(gVar, 0, gVar.getSlotCount());
    }

    public void a(mctech.m.a.g gVar, int i, int i2) {
        int iMin = Math.min(i2, Math.min(getSlotCount(), gVar.getSlotCount()));
        for (int i3 = i; i3 < iMin; i3++) {
            this.a.set(i3, gVar.getStackInSlot(i3).copy());
        }
    }

    public void a(IItemHandler iItemHandler) {
        a(iItemHandler, 0, iItemHandler.getSlots());
    }

    public void a(IItemHandler iItemHandler, int i, int i2) {
        int iMin = Math.min(i2, Math.min(getSlotCount(), iItemHandler.getSlots()));
        for (int i3 = i; i3 < iMin; i3++) {
            this.a.set(i3, iItemHandler.getStackInSlot(i3).copy());
        }
    }

    public void c(mctech.m.a.g gVar) {
        b(gVar, 0, gVar.getSlotCount());
    }

    public void b(mctech.m.a.g gVar, int i, int i2) {
        int iMin = Math.min(i2, Math.min(getSlotCount(), gVar.getSlotCount()));
        for (int i3 = i; i3 < iMin; i3++) {
            gVar.setStackInSlot(i3, ((ItemStack) this.a.get(i3)).copy());
        }
    }

    public void a() {
        this.a.clear();
    }

    public void a(int i, int i2) {
        for (int i3 = i; i3 < i2 && i3 < this.a.size(); i3++) {
            this.a.set(i3, ItemStack.EMPTY);
        }
    }

    public Int2ObjectMap<ItemStack[]> a(mctech.m.a.g gVar, boolean z) {
        if (getSlotCount() != gVar.getSlotCount()) {
            return Int2ObjectMaps.emptyMap();
        }
        Int2ObjectLinkedOpenHashMap int2ObjectLinkedOpenHashMap = new Int2ObjectLinkedOpenHashMap();
        int slotCount = getSlotCount();
        for (int i = 0; i < slotCount; i++) {
            if (!ItemStack.matches(gVar.getStackInSlot(i), getStackInSlot(i)) || (z && mctech.utils.c.h.b(gVar.getStackInSlot(i)) > 0)) {
                int2ObjectLinkedOpenHashMap.put(i, new ItemStack[]{gVar.getStackInSlot(i).copy(), getStackInSlot(i).copy()});
            }
        }
        return int2ObjectLinkedOpenHashMap;
    }

    public void b(IItemHandler iItemHandler) {
        int iMin = Math.min(getSlotCount(), iItemHandler.getSlots());
        for (int i = 0; i < iMin; i++) {
            ItemStack stackInSlot = iItemHandler.getStackInSlot(i);
            ItemStack itemStack = (ItemStack) this.a.get(i);
            if (stackInSlot.isEmpty() && !itemStack.isEmpty()) {
                iItemHandler.insertItem(i, itemStack, false);
            } else if (!stackInSlot.isEmpty() && itemStack.isEmpty()) {
                iItemHandler.extractItem(i, stackInSlot.getCount(), false);
            } else if (!stackInSlot.isEmpty()) {
                if (mctech.utils.c.h.d(stackInSlot, itemStack)) {
                    int count = itemStack.getCount() - stackInSlot.getCount();
                    if (count < 0) {
                        iItemHandler.extractItem(i, -count, false);
                    } else if (count > 0) {
                        iItemHandler.insertItem(i, mctech.utils.c.h.a(itemStack, count), false);
                    }
                } else {
                    iItemHandler.extractItem(i, stackInSlot.getCount(), false);
                    iItemHandler.insertItem(i, itemStack, false);
                }
            }
        }
    }

    public static m d(mctech.m.a.g gVar) {
        m mVar = new m(gVar.getSlotCount());
        mVar.b(gVar);
        return mVar;
    }

    public static m c(IItemHandler iItemHandler) {
        m mVar = new m(iItemHandler.getSlots());
        int slotCount = mVar.getSlotCount();
        for (int i = 0; i < slotCount; i++) {
            mVar.setStackInSlot(i, iItemHandler.extractItem(i, 64, true));
        }
        return mVar;
    }
}
