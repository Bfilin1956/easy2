package mctech.m.f;

import javax.annotation.Nonnull;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/e.class */
public class e implements IItemHandler {
    mctech.m.a.g a;

    public e(mctech.m.a.g gVar) {
        this.a = gVar;
    }

    public int getSlots() {
        return this.a.getSlotCount();
    }

    public ItemStack getStackInSlot(int i) {
        return this.a.getStackInSlot(i);
    }

    @Nonnull
    public ItemStack insertItem(int i, @Nonnull ItemStack itemStack, boolean z) {
        if (itemStack.isEmpty()) {
            return ItemStack.EMPTY;
        }
        if (!isItemValid(i, itemStack)) {
            return itemStack;
        }
        ItemStack stackInSlot = this.a.getStackInSlot(i);
        if (stackInSlot.isEmpty()) {
            int maxStackSize = this.a.getMaxStackSize(i);
            if (itemStack.getCount() <= maxStackSize) {
                if (!z) {
                    this.a.setStackInSlot(i, itemStack.copy());
                }
                return ItemStack.EMPTY;
            }
            if (!z) {
                this.a.setStackInSlot(i, itemStack.split(maxStackSize));
            } else {
                itemStack.shrink(maxStackSize);
            }
            return itemStack;
        }
        if (!mctech.utils.c.h.e(itemStack, stackInSlot)) {
            return itemStack;
        }
        int maxStackSize2 = this.a.getMaxStackSize(i) - stackInSlot.getCount();
        if (maxStackSize2 <= 0) {
            return itemStack;
        }
        if (maxStackSize2 > itemStack.getCount()) {
            if (!z) {
                ItemStack itemStackCopy = stackInSlot.copy();
                itemStackCopy.grow(itemStack.getCount());
                this.a.setStackInSlot(i, itemStackCopy);
            }
            return ItemStack.EMPTY;
        }
        ItemStack itemStackCopy2 = itemStack.copy();
        itemStackCopy2.shrink(maxStackSize2);
        if (z) {
            return itemStackCopy2;
        }
        ItemStack itemStackCopy3 = stackInSlot.copy();
        itemStackCopy3.grow(maxStackSize2);
        this.a.setStackInSlot(i, itemStackCopy3);
        return itemStackCopy2;
    }

    @Nonnull
    public ItemStack extractItem(int i, int i2, boolean z) {
        ItemStack itemStackSplit;
        if (i2 == 0) {
            return ItemStack.EMPTY;
        }
        ItemStack stackInSlot = this.a.getStackInSlot(i);
        if (stackInSlot.isEmpty()) {
            return ItemStack.EMPTY;
        }
        if (!this.a.canExtract(i, stackInSlot)) {
            return ItemStack.EMPTY;
        }
        if (z) {
            itemStackSplit = stackInSlot.copy();
            itemStackSplit.setCount(Math.min(stackInSlot.getCount(), i2));
        } else {
            itemStackSplit = stackInSlot.split(i2);
            this.a.setStackInSlot(i, stackInSlot);
        }
        return itemStackSplit;
    }

    public int getSlotLimit(int i) {
        return this.a.getMaxStackSize(i);
    }

    public boolean isItemValid(int i, ItemStack itemStack) {
        return this.a.canInsert(i, itemStack);
    }
}
