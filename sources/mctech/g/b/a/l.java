package mctech.g.b.a;

import io.netty.buffer.Unpooled;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/l.class */
public class l {
    private static final l a = new l();

    public static l a() {
        return a;
    }

    public void a(d dVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            Level level = iPayloadContext.player().level();
            BlockEntity blockEntity = level.getBlockEntity(dVar.a());
            if (blockEntity instanceof mctech.g.d.a.a.c) {
                mctech.g.d.a.a.c cVar = (mctech.g.d.a.a.c) blockEntity;
                RegistryFriendlyByteBuf registryFriendlyByteBuf = new RegistryFriendlyByteBuf(Unpooled.wrappedBuffer(dVar.b()), level.registryAccess());
                cVar.b(registryFriendlyByteBuf);
                registryFriendlyByteBuf.release();
            }
        });
    }

    public void a(mctech.g.b.a.a.k kVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            if (iPayloadContext.player().containerMenu.containerId == kVar.a()) {
                AbstractContainerMenu abstractContainerMenu = iPayloadContext.player().containerMenu;
                if (abstractContainerMenu instanceof mctech.g.b.b) {
                    ((mctech.g.b.b) abstractContainerMenu).b(kVar.b(), kVar.c());
                }
            }
        });
    }

    public void a(w wVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            AbstractContainerMenu abstractContainerMenu = iPayloadContext.player().containerMenu;
            if (abstractContainerMenu == null || abstractContainerMenu.containerId != wVar.a() || abstractContainerMenu.slots.size() <= wVar.b()) {
                return;
            }
            Slot slot = abstractContainerMenu.getSlot(wVar.b());
            if (slot instanceof mctech.g.d.a.b.c) {
                ((mctech.g.d.a.b.c) slot).safeInsert(wVar.c());
            }
        });
    }

    public void a(v vVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            AbstractContainerMenu abstractContainerMenu = iPayloadContext.player().containerMenu;
            if (abstractContainerMenu == null || abstractContainerMenu.containerId != vVar.a() || abstractContainerMenu.slots.size() <= vVar.b()) {
                return;
            }
            Slot slot = abstractContainerMenu.getSlot(vVar.b());
            if (slot instanceof mctech.g.d.a.b.a.d) {
                ((mctech.g.d.a.b.a.d) slot).a(vVar.c());
            }
        });
    }
}
