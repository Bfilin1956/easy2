package mctech.g.d.a.d.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mctech.g.a.i;
import net.mcskill.msweather.api.heat.IHeatStorage;
import net.mcskill.msweather.init.MSCapabilities;
import net.minecraft.server.level.ServerLevel;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/d/c.class */
public class c implements mctech.g.a.k.a<a> {
    public static final c a = new c();
    private final List<IHeatStorage> b = new ArrayList();
    private final List<IHeatStorage> c = new ArrayList();

    @Override // mctech.g.a.k.a
    public void a(ServerLevel serverLevel, a aVar, i iVar) {
        int maxHeatStored;
        int iMin;
        int iExtractHeat;
        int iReceiveHeat;
        Collection<mctech.g.a.c.a> collectionF = iVar.f();
        if (collectionF.isEmpty()) {
            return;
        }
        this.b.clear();
        this.c.clear();
        Iterator<mctech.g.a.c.a> it = collectionF.iterator();
        while (it.hasNext()) {
            IHeatStorage iHeatStorage = (IHeatStorage) it.next().a(MSCapabilities.HeatStorage.BLOCK);
            if (iHeatStorage != null) {
                if (iHeatStorage.canExtract()) {
                    this.b.add(iHeatStorage);
                }
                if (iHeatStorage.canReceive()) {
                    this.c.add(iHeatStorage);
                }
            }
        }
        this.b.sort((iHeatStorage2, iHeatStorage3) -> {
            return Integer.compare(iHeatStorage3.getHeatStored(), iHeatStorage2.getHeatStored());
        });
        this.c.sort((iHeatStorage4, iHeatStorage5) -> {
            return Integer.compare(iHeatStorage5.getMaxHeatStored() - iHeatStorage5.getHeatStored(), iHeatStorage4.getMaxHeatStored() - iHeatStorage4.getHeatStored());
        });
        for (IHeatStorage iHeatStorage6 : this.b) {
            if (iHeatStorage6.canExtract()) {
                int heatStored = iHeatStorage6.getHeatStored();
                if (heatStored > 0) {
                    for (IHeatStorage iHeatStorage7 : this.c) {
                        if (iHeatStorage7.canReceive() && (maxHeatStored = iHeatStorage7.getMaxHeatStored() - iHeatStorage7.getHeatStored()) > 0 && (iMin = Math.min(aVar.o(), Math.min(maxHeatStored, heatStored))) > 0 && (iExtractHeat = iHeatStorage6.extractHeat(iMin, true)) > 0 && (iReceiveHeat = iHeatStorage7.receiveHeat(iExtractHeat, true)) > 0) {
                            if (iReceiveHeat == iExtractHeat) {
                                if (iHeatStorage6.extractHeat(iReceiveHeat, false) > 0) {
                                    iHeatStorage7.receiveHeat(iReceiveHeat, false);
                                    heatStored -= iReceiveHeat;
                                }
                            } else {
                                int iExtractHeat2 = iHeatStorage6.extractHeat(iReceiveHeat, false);
                                if (iExtractHeat2 > 0) {
                                    iHeatStorage7.receiveHeat(iExtractHeat2, false);
                                    heatStored -= iExtractHeat2;
                                }
                            }
                            if (heatStored <= 0) {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
