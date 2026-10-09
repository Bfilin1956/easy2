package mctech.g.d.a.d.g;

import java.util.Iterator;
import mctech.g.a.i;
import mctech.init.MCTechBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/g/d.class */
public class d implements mctech.g.a.k.a<a> {
    public static final d a = new d();

    @Override // mctech.g.a.k.a
    public void a(ServerLevel serverLevel, a aVar, i iVar) {
        int signal;
        c cVar = (c) iVar.c(c.b);
        boolean zC = cVar.c();
        cVar.d();
        for (DyeColor dyeColor : iVar.g()) {
            for (mctech.g.a.c.a aVar2 : iVar.b(dyeColor)) {
                mctech.g.a.e.d dVar = (mctech.g.a.e.d) aVar2.c().getStackInSlot(0).getCapability(mctech.g.a.d.e);
                if (dVar != null) {
                    signal = dVar.a(serverLevel, aVar2.a(), aVar2.e());
                } else {
                    signal = serverLevel.getSignal(aVar2.a(), aVar2.e());
                }
                if (signal > 0) {
                    cVar.a(dyeColor, signal);
                }
            }
            if (cVar.b() || cVar.b(dyeColor) != cVar.c(dyeColor)) {
                for (mctech.g.a.c.a aVar3 : iVar.a(dyeColor)) {
                    serverLevel.updateNeighborsAt(aVar3.d().a(), (Block) MCTechBlocks.CONDUIT.get());
                    if (((b) aVar3.a(b.f)).i()) {
                        serverLevel.updateNeighborsAt(aVar3.a(), (Block) MCTechBlocks.CONDUIT.get());
                    }
                }
            }
        }
        if (cVar.b() || cVar.c() != zC) {
            Iterator<? extends mctech.g.a.h.a> it = iVar.d().iterator();
            while (it.hasNext()) {
                it.next().d();
            }
        }
    }
}
