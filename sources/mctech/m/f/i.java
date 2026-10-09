package mctech.m.f;

import appeng.core.definitions.AEItems;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/i.class */
public class i implements mctech.m.a.g {
    protected IItemHandler a;

    public i(IItemHandler iItemHandler) {
        this.a = iItemHandler;
    }

    @Override // mctech.m.a.g
    public int getSlotCount() {
        return this.a.getSlots();
    }

    @Override // mctech.m.a.g
    public ItemStack getStackInSlot(int i) {
        return this.a.getStackInSlot(i);
    }

    @Override // mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        IItemHandlerModifiable iItemHandlerModifiable = this.a;
        if (iItemHandlerModifiable instanceof IItemHandlerModifiable) {
            iItemHandlerModifiable.setStackInSlot(i, itemStack);
        }
    }

    @Override // mctech.m.a.g
    public int getMaxStackSize(int i) {
        if (i == 0) {
            return this.a.getSlotLimit(i);
        }
        return 1;
    }

    @Override // mctech.m.a.g
    public boolean canInsert(int i, ItemStack itemStack) {
        return i == 0 && itemStack.is(AEItems.BLANK_PATTERN.holder());
    }

    @Override // mctech.m.a.g
    public boolean canExtract(int i, ItemStack itemStack) {
        return false;
    }
}
