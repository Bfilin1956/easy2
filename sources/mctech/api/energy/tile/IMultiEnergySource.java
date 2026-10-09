package mctech.api.energy.tile;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/energy/tile/IMultiEnergySource.class */
public interface IMultiEnergySource extends IEnergySource {
    boolean hasMultiplePackets();

    int getPacketCount();
}
