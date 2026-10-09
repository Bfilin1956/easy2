package mctech.api.energy.tile;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/energy/tile/IEnergySource.class */
public interface IEnergySource extends IEnergyEmitter {
    int getSourceTier();

    int getMaxEnergyOutput();

    int getProvidedEnergy();

    default void onPacketFailed() {
    }
}
