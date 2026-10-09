package mctech.api.heat;

import net.minecraft.core.Direction;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/heat/IHeatAcceptor.class */
public interface IHeatAcceptor extends IHeatTile {
    boolean canAcceptHeat(IHeatEmitter iHeatEmitter, Direction direction);
}
