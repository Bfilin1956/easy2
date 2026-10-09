package mctech.api.energy.tile;

import java.util.Set;
import net.minecraft.core.Direction;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/energy/tile/IEnergyEmitter.class */
public interface IEnergyEmitter extends IEnergyTile {
    boolean canEmitEnergy(IEnergyAcceptor iEnergyAcceptor, Direction direction);

    default Set<Direction> getOutputEnergySides() {
        return Set.of((Object[]) Direction.values());
    }

    default boolean canEmitEnergy(Direction direction) {
        if (direction == null) {
            return false;
        }
        return getOutputEnergySides().contains(direction);
    }
}
