package mctech.api.gui;

import java.util.List;
import mctech.api.ConfigType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/IModConfigs.class */
public interface IModConfigs {
    String getModName();

    List<IModConfig> getConfigInstances(ConfigType configType);

    BackgroundTexture getBackground();
}
