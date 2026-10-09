package mctech.api.tiles;

import mctech.api.tiles.readers.IEUStorage;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/IEnergyStorage.class */
public interface IEnergyStorage extends IEUStorage {
    int addEnergy(int i);

    int drawEnergy(int i);
}
