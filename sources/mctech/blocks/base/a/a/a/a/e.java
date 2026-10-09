package mctech.blocks.base.a.a.a.a;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a/a/e.class */
public class e extends mctech.blocks.base.a.a.a {
    mctech.m.a.g f;
    boolean g;

    public e(String str, Component component, mctech.m.a.g gVar, boolean z) {
        super(str, component);
        this.f = gVar;
        this.g = z;
    }

    @Override // mctech.blocks.base.a.a.a
    protected int d() {
        if (this.g) {
            int i = 0;
            int slotCount = this.f.getSlotCount();
            for (int i2 = 0; i2 < slotCount; i2++) {
                i += this.f.getStackInSlot(i2).isEmpty() ? 0 : 1;
            }
            return mctech.blocks.base.a.a.a.a(i, this.f.getSlotCount(), 15);
        }
        int iMin = 0;
        int count = 0;
        int slotCount2 = this.f.getSlotCount();
        for (int i3 = 0; i3 < slotCount2; i3++) {
            ItemStack stackInSlot = this.f.getStackInSlot(i3);
            if (stackInSlot.isEmpty()) {
                iMin += this.f.getMaxStackSize(i3);
            } else {
                iMin += Math.min(stackInSlot.getMaxStackSize(), this.f.getMaxStackSize(i3));
                count = stackInSlot.getCount();
            }
        }
        return mctech.blocks.base.a.a.a.a(count, iMin, 15);
    }
}
