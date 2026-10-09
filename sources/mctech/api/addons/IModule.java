package mctech.api.addons;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/addons/IModule.class */
public interface IModule {
    boolean canLoad(Dist dist);

    default void loadConfigs() {
    }

    default void preInit(IEventBus iEventBus) {
    }

    default void postInit() {
    }
}
