package mctech.g.b.a;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/e.class */
public class e {
    private static final e a = new e();

    public void a(b bVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            if (bVar.a() == iPayloadContext.player().containerMenu.containerId) {
                AbstractContainerMenu abstractContainerMenu = iPayloadContext.player().containerMenu;
                if (abstractContainerMenu instanceof mctech.g.d.a.c.a) {
                    ((mctech.g.d.a.c.a) abstractContainerMenu).a(bVar.b());
                }
            }
        });
    }

    public void a(c cVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            if (cVar.a() == iPayloadContext.player().containerMenu.containerId) {
                AbstractContainerMenu abstractContainerMenu = iPayloadContext.player().containerMenu;
                if (abstractContainerMenu instanceof mctech.g.d.a.c.a) {
                    ((mctech.g.d.a.c.a) abstractContainerMenu).a(cVar.b());
                }
            }
        });
    }

    public static e a() {
        return a;
    }
}
