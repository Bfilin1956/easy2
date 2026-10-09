package mctech.api.heat;

import net.minecraft.core.Direction;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/heat/IHeatEmitter.class */
public interface IHeatEmitter extends IHeatTile {
    boolean canEmitHeat(IHeatAcceptor iHeatAcceptor, Direction direction);
}
