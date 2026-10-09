package mctech.m.f;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/g.class */
public class g implements mctech.m.a.g {
    mctech.m.a.g a;

    public g(mctech.m.a.g gVar) {
        this.a = gVar;
    }

    @Override // mctech.m.a.g
    public int getSlotCount() {
        return this.a.getSlotCount();
    }

    @Override // mctech.m.a.g
    public ItemStack getStackInSlot(int i) {
        return this.a.getStackInSlot(i);
    }

    @Override // mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        this.a.setStackInSlot(i, itemStack);
    }

    @Override // mctech.m.a.g
    public int getMaxStackSize(int i) {
        return this.a.getMaxStackSize(i);
    }

    @Override // mctech.m.a.g
    public boolean canInsert(int i, ItemStack itemStack) {
        return this.a.canInsert(i, itemStack);
    }

    @Override // mctech.m.a.g
    public boolean canExtract(int i, ItemStack itemStack) {
        return this.a.canExtract(i, itemStack);
    }
}
