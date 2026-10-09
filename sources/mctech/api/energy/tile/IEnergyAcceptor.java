package mctech.api.energy.tile;

import net.minecraft.core.Direction;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/energy/tile/IEnergyAcceptor.class */
public interface IEnergyAcceptor extends IEnergyTile {
    boolean canAcceptEnergy(IEnergyEmitter iEnergyEmitter, Direction direction);

    default boolean canAcceptEnergy(Direction direction) {
        return canAcceptEnergy(null, direction);
    }
}
