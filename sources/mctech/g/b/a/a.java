package mctech.g.b.a;

import io.netty.buffer.Unpooled;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a.class */
public class a {
    private static final a a = new a();

    public static a a() {
        return a;
    }

    public void a(i iVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            a(iVar);
        });
    }

    public void a(j jVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            Iterator<i> it = jVar.a().iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        });
    }

    private void a(i iVar) {
        Minecraft.getInstance().level.addParticle(iVar.a(), iVar.b(), iVar.c(), iVar.d(), iVar.e(), iVar.f(), iVar.g());
    }

    public void a(n nVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            Level level = iPayloadContext.player().level();
            BlockEntity blockEntity = level.getBlockEntity(nVar.a());
            if (blockEntity instanceof mctech.g.d.a.a.c) {
                mctech.g.d.a.a.c cVar = (mctech.g.d.a.a.c) blockEntity;
                RegistryFriendlyByteBuf registryFriendlyByteBuf = new RegistryFriendlyByteBuf(Unpooled.wrappedBuffer(nVar.b()), level.registryAccess());
                cVar.a(registryFriendlyByteBuf);
                registryFriendlyByteBuf.release();
            }
        });
    }

    public void a(mctech.g.b.a.a.c cVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            if (iPayloadContext.player().containerMenu.containerId == cVar.a()) {
                AbstractContainerMenu abstractContainerMenu = iPayloadContext.player().containerMenu;
                if (abstractContainerMenu instanceof mctech.g.b.b) {
                    mctech.g.b.b bVar = (mctech.g.b.b) abstractContainerMenu;
                    for (mctech.g.b.a.a.c.a aVar : cVar.b()) {
                        bVar.a(aVar.a(), aVar.b());
                    }
                }
            }
        });
    }
}
