package mctech.m.e;

import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/b.class */
public class b implements IItemHandler {
    private i a;
    private Direction b;
    private g c;

    public b(i iVar, Direction direction, g gVar) {
        this.a = iVar;
        this.b = direction;
        this.c = gVar;
    }

    public int getSlots() {
        return this.c.a();
    }

    public ItemStack getStackInSlot(int i) {
        return this.a.a().getStackInSlot(this.c.a(i));
    }

    public ItemStack insertItem(int i, ItemStack itemStack, boolean z) {
        if (itemStack.isEmpty()) {
            return ItemStack.EMPTY;
        }
        int iA = this.c.a(i);
        if (!this.a.d(this.b).c() || !this.a.a(iA, this.b).c()) {
            return itemStack;
        }
        if (!this.a.a().canInsert(iA, itemStack)) {
            return itemStack;
        }
        int iA2 = Integer.MAX_VALUE;
        if (this.a.r()) {
            if (!a(iA, itemStack)) {
                return itemStack;
            }
            iA2 = a(itemStack);
            if (iA2 <= 0) {
                return itemStack;
            }
        }
        ItemStack stackInSlot = this.a.a().getStackInSlot(iA);
        if (stackInSlot.isEmpty()) {
            int iMin = Math.min(Math.min(itemStack.getMaxStackSize(), this.a.a().getMaxStackSize(iA)), iA2);
            if (itemStack.getCount() <= iMin) {
                ItemStack itemStackCopy = itemStack.copy();
                if (!z) {
                    this.a.a().setStackInSlot(iA, itemStackCopy);
                }
                return ItemStack.EMPTY;
            }
            if (!z) {
                this.a.a().setStackInSlot(iA, itemStack.split(iMin));
            } else {
                itemStack.shrink(iMin);
            }
            return itemStack;
        }
        if (!mctech.utils.c.h.e(itemStack, stackInSlot)) {
            return itemStack;
        }
        int iMin2 = Math.min(Math.min(itemStack.getMaxStackSize(), this.a.a().getMaxStackSize(iA)) - stackInSlot.getCount(), iA2);
        if (iMin2 <= 0) {
            return itemStack;
        }
        if (iMin2 > itemStack.getCount()) {
            if (!z) {
                ItemStack itemStackCopy2 = stackInSlot.copy();
                itemStackCopy2.grow(itemStack.getCount());
                this.a.a().setStackInSlot(iA, itemStackCopy2);
            }
            return ItemStack.EMPTY;
        }
        ItemStack itemStackCopy3 = itemStack.copy();
        if (z) {
            itemStackCopy3.shrink(iMin2);
            return itemStackCopy3;
        }
        itemStackCopy3.shrink(iMin2);
        ItemStack itemStackCopy4 = stackInSlot.copy();
        itemStackCopy4.grow(iMin2);
        this.a.a().setStackInSlot(iA, itemStackCopy4);
        return itemStackCopy3;
    }

    public ItemStack extractItem(int i, int i2, boolean z) {
        ItemStack itemStackSplit;
        if (i2 <= 0) {
            return ItemStack.EMPTY;
        }
        int iA = this.c.a(i);
        if (!this.a.d(this.b).d() || !this.a.a(iA, this.b).d()) {
            return ItemStack.EMPTY;
        }
        ItemStack stackInSlot = this.a.a().getStackInSlot(iA);
        if (stackInSlot.isEmpty()) {
            return ItemStack.EMPTY;
        }
        if (!this.a.a().canExtract(iA, stackInSlot)) {
            return ItemStack.EMPTY;
        }
        mctech.m.e.a.a aVarC = this.a.c(iA);
        if (aVarC != null && !aVarC.matches(iA, stackInSlot)) {
            return ItemStack.EMPTY;
        }
        if (z) {
            itemStackSplit = stackInSlot.copy();
            itemStackSplit.setCount(Math.min(stackInSlot.getCount(), i2));
        } else {
            itemStackSplit = stackInSlot.split(i2);
            this.a.a().setStackInSlot(iA, stackInSlot);
        }
        return itemStackSplit;
    }

    public int getSlotLimit(int i) {
        return this.a.a().getMaxStackSize(this.c.a(i));
    }

    public boolean isItemValid(int i, @NotNull ItemStack itemStack) {
        int iA = this.c.a(i);
        return this.a.d(this.b).c() && this.a.a(iA, this.b).c() && this.a.a().canInsert(iA, itemStack);
    }

    protected boolean a(int i, ItemStack itemStack) {
        ItemStack stackInSlot = this.a.a().getStackInSlot(i);
        if (!stackInSlot.isEmpty() && !mctech.utils.c.h.e(stackInSlot, itemStack)) {
            return false;
        }
        int count = 0;
        boolean zQ = this.a.q();
        Item item = itemStack.getItem();
        int iA = this.c.a();
        for (int i2 = 0; i2 < iA; i2++) {
            int iA2 = this.c.a(i2);
            if (iA2 != i || zQ) {
                ItemStack stackInSlot2 = this.a.a().getStackInSlot(iA2);
                if (stackInSlot2.getItem() == item) {
                    count += stackInSlot2.getCount();
                    if (!zQ) {
                        return false;
                    }
                } else {
                    continue;
                }
            }
        }
        return !zQ || count < b(itemStack);
    }

    protected int a(ItemStack itemStack) {
        int count = 0;
        int iA = this.c.a();
        for (int i = 0; i < iA; i++) {
            ItemStack stackInSlot = this.a.a().getStackInSlot(this.c.a(i));
            if (mctech.utils.c.h.d(stackInSlot, itemStack)) {
                count += stackInSlot.getCount();
            }
        }
        return b(itemStack) - count;
    }

    private int b(ItemStack itemStack) {
        int iA = this.a.a(itemStack.getItem());
        return iA == -1 ? itemStack.getMaxStackSize() : iA;
    }
}
