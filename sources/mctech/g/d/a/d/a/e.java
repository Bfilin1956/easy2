package mctech.g.d.a.d.a;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.Pair;
import java.util.ArrayList;
import java.util.List;
import mctech.g.a.i;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/a/e.class */
public class e implements mctech.g.a.k.a<a> {
    public static final e a = new e();

    @Override // mctech.g.a.k.a
    public void a(ServerLevel serverLevel, a aVar, i iVar) {
        c cVar;
        int iReceiveEnergy;
        List<mctech.g.a.c.a> listH = iVar.h();
        if (listH.isEmpty() || (cVar = (c) iVar.b(c.c)) == null || cVar.b() <= 0) {
            return;
        }
        int iK = ((b) ((mctech.g.a.c.a) listH.getFirst()).a(b.f)).k();
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        for (mctech.g.a.c.a aVar2 : listH) {
            int iK2 = ((b) aVar2.a(b.f)).k();
            if (iK2 != iK) {
                cVar.a(cVar.b() - a(arrayListNewArrayList, cVar.b()));
                if (cVar.b() <= 0) {
                    return;
                }
                arrayListNewArrayList.clear();
                iK = iK2;
            }
            IEnergyStorage iEnergyStorage = (IEnergyStorage) aVar2.a(Capabilities.EnergyStorage.BLOCK);
            if (iEnergyStorage != null && iEnergyStorage.canReceive() && (iReceiveEnergy = iEnergyStorage.receiveEnergy(Integer.MAX_VALUE, true)) > 0) {
                arrayListNewArrayList.add(Pair.of(iEnergyStorage, Integer.valueOf(iReceiveEnergy)));
            }
        }
        if (!arrayListNewArrayList.isEmpty() && cVar.b() > 0) {
            cVar.a(cVar.b() - a(arrayListNewArrayList, cVar.b()));
        }
    }

    private long a(List<Pair<IEnergyStorage, Integer>> list, long j) {
        int iReceiveEnergy;
        list.sort((pair, pair2) -> {
            return Integer.compare(((Integer) pair2.right()).intValue(), ((Integer) pair.right()).intValue());
        });
        long j2 = j;
        int size = list.size();
        for (Pair<IEnergyStorage, Integer> pair3 : list) {
            if (j2 < size) {
                iReceiveEnergy = ((IEnergyStorage) pair3.left()).receiveEnergy((int) j2, false);
            } else {
                iReceiveEnergy = ((IEnergyStorage) pair3.left()).receiveEnergy((int) Math.min(j2 / ((long) size), 2147483647L), false);
            }
            size--;
            j2 -= (long) iReceiveEnergy;
            if (j2 <= 0) {
                break;
            }
        }
        return j - j2;
    }
}
