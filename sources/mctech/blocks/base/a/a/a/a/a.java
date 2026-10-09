package mctech.blocks.base.a.a.a.a;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a/a/a.class */
public class a extends mctech.blocks.base.a.a.a.a {
    mctech.m.e.e f;
    boolean g;

    public a(String str, Component component, mctech.m.e.e eVar, boolean z) {
        super(str, component);
        this.f = eVar;
        this.g = z;
    }

    @Override // mctech.blocks.base.a.a.a.a
    protected int b(Direction direction) {
        IItemHandler iItemHandlerC = this.f.getInventoryHandler().c(direction);
        if (iItemHandlerC == null || iItemHandlerC == mctech.m.e.c.a) {
            return 0;
        }
        if (this.g) {
            int i = 0;
            int slots = iItemHandlerC.getSlots();
            for (int i2 = 0; i2 < slots; i2++) {
                i += iItemHandlerC.getStackInSlot(i2).isEmpty() ? 0 : 1;
            }
            return mctech.blocks.base.a.a.a.a(i, iItemHandlerC.getSlots(), 15);
        }
        int iMin = 0;
        int count = 0;
        int slots2 = iItemHandlerC.getSlots();
        for (int i3 = 0; i3 < slots2; i3++) {
            ItemStack stackInSlot = iItemHandlerC.getStackInSlot(i3);
            if (stackInSlot.isEmpty()) {
                iMin += iItemHandlerC.getSlotLimit(i3);
            } else {
                iMin += Math.min(stackInSlot.getMaxStackSize(), iItemHandlerC.getSlotLimit(i3));
                count = stackInSlot.getCount();
            }
        }
        return mctech.blocks.base.a.a.a.a(count, iMin, 15);
    }
}
