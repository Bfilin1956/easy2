package mctech.api.energy.tile;

import java.util.List;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/energy/tile/IMultiEnergyTile.class */
public interface IMultiEnergyTile extends IEnergyTile {
    List<IEnergyTile> getTiles();
}
