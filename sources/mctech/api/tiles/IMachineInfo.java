package mctech.api.tiles;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/IMachineInfo.class */
public interface IMachineInfo {
    int getStoredEU();

    int getMaxEU();

    default long getStoredLongEU() {
        return getStoredEU();
    }

    default long getMaxLongEU() {
        return getMaxEU();
    }

    default int getMaxInput() {
        return 0;
    }

    default int getMaxEnergyOutput() {
        return 0;
    }

    default int getEnergyPerTick() {
        return -1;
    }

    default int getOperationTime() {
        return -1;
    }
}
