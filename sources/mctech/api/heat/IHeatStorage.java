package mctech.api.heat;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/heat/IHeatStorage.class */
public interface IHeatStorage {
    int heatLevel();

    int maxHeatLevel();

    int overheatLevel();

    default int explosionLevel() {
        return maxHeatLevel();
    }
}
