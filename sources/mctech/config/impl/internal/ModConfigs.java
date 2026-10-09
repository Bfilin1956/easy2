package mctech.config.impl.internal;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Comparator;
import java.util.List;
import mctech.api.ConfigType;
import mctech.api.gui.BackgroundTexture;
import mctech.api.gui.IModConfig;
import mctech.api.gui.IModConfigs;
import mctech.config.ConfigHandler;
import mctech.config.impl.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/internal/ModConfigs.class */
public class ModConfigs implements IModConfigs {
    ModContainer container;
    List<ConfigHandler> knownConfigs = new ObjectArrayList();

    public ModConfigs(ModContainer modContainer) {
        this.container = modContainer;
    }

    public static ModConfigs of() {
        return new ModConfigs(ModLoadingContext.get().getActiveContainer());
    }

    public static ModConfigs of(ConfigHandler configHandler) {
        ModConfigs modConfigs = new ModConfigs(ModLoadingContext.get().getActiveContainer());
        modConfigs.addConfig(configHandler);
        return modConfigs;
    }

    @Override // mctech.api.gui.IModConfigs
    public String getModName() {
        return this.container.getModInfo().getDisplayName();
    }

    public void addConfig(ConfigHandler configHandler) {
        this.knownConfigs.add(configHandler);
    }

    @Override // mctech.api.gui.IModConfigs
    public List<IModConfig> getConfigInstances(ConfigType configType) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (ConfigHandler configHandler : this.knownConfigs) {
            if (configHandler.isRegistered() && configHandler.getConfigType() == configType) {
                objectArrayList.add(new ModConfig(this.container.getModId(), configHandler));
            }
        }
        objectArrayList.sort(Comparator.comparing((v0) -> {
            return v0.getConfigName();
        }, String.CASE_INSENSITIVE_ORDER));
        return objectArrayList;
    }

    @Override // mctech.api.gui.IModConfigs
    public BackgroundTexture getBackground() {
        return BackgroundTexture.DEFAULT;
    }
}
