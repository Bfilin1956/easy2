package mctech.g.b.a;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/f.class */
public class f {
    private static final f a = new f();

    public void a(y yVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            if (yVar.a() != iPayloadContext.player().containerMenu.containerId || iPayloadContext.player().isSpectator()) {
                return;
            }
            AbstractContainerMenu abstractContainerMenu = iPayloadContext.player().containerMenu;
            if (abstractContainerMenu instanceof mctech.g.d.a.c.a) {
                ((mctech.g.d.a.c.a) abstractContainerMenu).a(yVar);
            }
        });
    }

    public static f a() {
        return a;
    }
}
