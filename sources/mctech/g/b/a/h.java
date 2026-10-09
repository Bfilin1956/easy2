package mctech.g.b.a;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/h.class */
public interface h<Menu extends AbstractContainerMenu> extends CustomPacketPayload {
    int a();

    Class<Menu> b();

    default boolean a(IPayloadContext iPayloadContext) {
        AbstractContainerMenu abstractContainerMenu = iPayloadContext.player().containerMenu;
        return abstractContainerMenu.containerId == a() && b().isAssignableFrom(abstractContainerMenu.getClass());
    }

    default Menu b(IPayloadContext iPayloadContext) {
        return b().cast(iPayloadContext.player().containerMenu);
    }
}
