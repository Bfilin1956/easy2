package mctech.m.f;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/k.class */
public class k implements mctech.m.a.g {
    mctech.m.a.g a;
    int[] b;
    boolean c = false;

    public k(mctech.m.a.g gVar, int... iArr) {
        this.a = gVar;
        this.b = iArr;
    }

    public k a() {
        this.c = true;
        return this;
    }

    @Override // mctech.m.a.g
    public int getSlotCount() {
        return this.b.length;
    }

    @Override // mctech.m.a.g
    public ItemStack getStackInSlot(int i) {
        return this.a.getStackInSlot(this.b[i]);
    }

    @Override // mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        this.a.setStackInSlot(this.b[i], itemStack);
    }

    @Override // mctech.m.a.g
    public int getMaxStackSize(int i) {
        return this.a.getMaxStackSize(this.b[i]);
    }

    @Override // mctech.m.a.g
    public boolean canInsert(int i, ItemStack itemStack) {
        return !this.c && this.a.canInsert(this.b[i], itemStack);
    }

    @Override // mctech.m.a.g
    public boolean canExtract(int i, ItemStack itemStack) {
        return this.c || this.a.canExtract(this.b[i], itemStack);
    }
}
