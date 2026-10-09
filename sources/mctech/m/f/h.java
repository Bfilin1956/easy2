package mctech.m.f;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/h.class */
public class h extends m {
    private f d;

    public h(int i, f fVar) {
        super(i);
        this.d = fVar;
    }

    @Override // mctech.m.f.m, mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        super.setStackInSlot(i, itemStack);
        if (this.d != null) {
            this.d.onNotify(this, i);
        }
    }
}
