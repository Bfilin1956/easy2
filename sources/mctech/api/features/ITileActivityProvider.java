package mctech.api.features;

import mctech.api.tiles.readers.IActivityProvider;
import mctech.blockentities.q;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/features/ITileActivityProvider.class */
public interface ITileActivityProvider extends IActivityProvider {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.api.tiles.readers.IActivityProvider
    default boolean isActivated() {
        return ((q) this).isActive();
    }
}
