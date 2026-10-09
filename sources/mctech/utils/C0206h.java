package mctech.utils;

import net.minecraft.world.inventory.Slot;

/* JADX INFO: renamed from: mctech.utils.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/h.class */
public class C0206h {
    public static final mctech.m.c.g a = itemStack -> {
        return itemStack.getItem() instanceof mctech.items.base.m;
    };

    public static Slot a(mctech.m.a.g gVar, int i, int i2, int i3) {
        return new C0202d(gVar, i, i2, i3, mctech.m.c.a.c.a);
    }
}
