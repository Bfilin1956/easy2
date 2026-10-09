package mctech.api;

import mctech.config.ConfigHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/IConfigChangeListener.class */
public interface IConfigChangeListener {
    void onConfigCreated(ConfigHandler configHandler);

    void onConfigAdded(ConfigHandler configHandler);

    void onConfigChanged(ConfigHandler configHandler);

    void onConfigErrored(ConfigHandler configHandler);
}
