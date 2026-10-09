package mctech.api.tiles.readers;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/readers/IEUStorage.class */
public interface IEUStorage {
    int getStoredEU();

    int getMaxEU();

    int getTier();

    default long getLongStoredEU() {
        return getStoredEU();
    }

    default long getLongMaxEU() {
        return getMaxEU();
    }

    default double getChargeLevel() {
        return ((double) getStoredEU()) / ((double) getMaxEU());
    }
}
