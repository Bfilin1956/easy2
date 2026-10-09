package mctech.m.f;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/c.class */
public class c implements mctech.m.a.g {
    protected IItemHandler a;

    public c(IItemHandler iItemHandler) {
        this.a = iItemHandler;
    }

    public void a() {
        for (int i = 0; i < this.a.getSlots(); i++) {
            setStackInSlot(i, ItemStack.EMPTY);
        }
    }

    public IItemHandler b() {
        return this.a;
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
            IItemHandlerModifiable iItemHandlerModifiable2 = iItemHandlerModifiable;
            if (mctech.a.b.b.e.a.matches(itemStack)) {
                iItemHandlerModifiable2.setStackInSlot(i, itemStack);
            }
        }
    }

    @Override // mctech.m.a.g
    public int getMaxStackSize(int i) {
        return this.a.getSlotLimit(i);
    }

    @Override // mctech.m.a.g
    public boolean canInsert(int i, ItemStack itemStack) {
        return false;
    }

    @Override // mctech.m.a.g
    public boolean canExtract(int i, ItemStack itemStack) {
        return false;
    }
}
