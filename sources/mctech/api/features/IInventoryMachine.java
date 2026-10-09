package mctech.api.features;

import mctech.api.tiles.IMachine;
import mctech.api.util.DirectionList;
import mctech.m.a.g;
import mctech.m.c.r;
import mctech.m.e.a;
import mctech.m.e.i;
import mctech.m.e.k;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/features/IInventoryMachine.class */
public interface IInventoryMachine extends IMachine {
    g getInputInventory();

    g getOutputInventory();

    default void createInputSlots(i iVar, int... iArr) {
        createInputSlots(iVar, (mctech.m.c.g) null, iArr);
    }

    default void createInputSlots(i iVar, mctech.m.c.g gVar, int... iArr) {
        iVar.a(k.g, iArr);
        iVar.a(DirectionList.ALL, iArr);
        iVar.a(a.IMPORT, iArr);
        if (gVar != null) {
            iVar.a(gVar, iArr);
        }
    }

    default void createInputSlots(i iVar, mctech.m.e.a.a aVar, int... iArr) {
        iVar.a(k.g, iArr);
        iVar.a(DirectionList.ALL, iArr);
        iVar.a(a.IMPORT, iArr);
        if (aVar != null) {
            iVar.a(aVar, iArr);
        }
    }

    default void createOutputSlots(i iVar, int... iArr) {
        createOutputSlots(iVar, (mctech.m.c.g) null, iArr);
    }

    default void createOutputSlots(i iVar, mctech.m.c.g gVar, int... iArr) {
        iVar.a(k.e, iArr);
        iVar.a(DirectionList.ALL, iArr);
        iVar.a(a.EXPORT, iArr);
        iVar.a(r.c, iArr);
        if (gVar != null) {
            iVar.b(gVar, iArr);
        }
    }

    default void createOutputSlots(i iVar, mctech.m.e.a.a aVar, int... iArr) {
        iVar.a(k.e, iArr);
        iVar.a(DirectionList.ALL, iArr);
        iVar.a(a.EXPORT, iArr);
        iVar.a(r.c, iArr);
        if (aVar != null) {
            iVar.b(aVar, iArr);
        }
    }

    default void createUpgradeSlots(i iVar, int... iArr) {
        iVar.a(k.c, iArr);
        iVar.a(DirectionList.EMPTY, iArr);
        iVar.a(a.IMPORT, iArr);
    }
}
