package mctech.m.e;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/c.class */
public class c implements IItemHandlerModifiable {
    public static final IItemHandler a = new c();

    public boolean isItemValid(int i, ItemStack itemStack) {
        return false;
    }

    public ItemStack insertItem(int i, ItemStack itemStack, boolean z) {
        return itemStack;
    }

    public ItemStack getStackInSlot(int i) {
        return ItemStack.EMPTY;
    }

    public int getSlots() {
        return 0;
    }

    public int getSlotLimit(int i) {
        return 0;
    }

    public ItemStack extractItem(int i, int i2, boolean z) {
        return ItemStack.EMPTY;
    }

    public void setStackInSlot(int i, ItemStack itemStack) {
    }
}
