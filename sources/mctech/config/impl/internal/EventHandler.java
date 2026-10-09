package mctech.config.impl.internal;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import java.util.Map;
import mctech.MCTech;
import mctech.api.IConfigChangeListener;
import mctech.api.gui.IModConfigs;
import mctech.config.ConfigHandler;
import mctech.config.impl.entries.ColorEntry;
import net.minecraft.client.gui.screens.Screen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/internal/EventHandler.class */
public class EventHandler implements IConfigChangeListener {
    public static final EventHandler INSTANCE = new EventHandler();
    Map<ModContainer, ModConfigs> configs = new Object2ObjectLinkedOpenHashMap();

    @Override // mctech.api.IConfigChangeListener
    public void onConfigCreated(ConfigHandler configHandler) {
        initMinecraftDataTypes(configHandler);
        if (FMLEnvironment.dist.isDedicatedServer()) {
            return;
        }
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        if (!"minecraft".equals(modLoadingContext.getActiveNamespace())) {
            this.configs.computeIfAbsent(modLoadingContext.getActiveContainer(), ModConfigs::new).addConfig(configHandler);
        } else if (FMLEnvironment.production) {
        } else {
            throw new IllegalStateException("Mod Configs Must be created (not loaded) during a Mod Loading Phase");
        }
    }

    public void initMinecraftDataTypes(ConfigHandler configHandler) {
        configHandler.addParser('C', ColorEntry::parse);
    }

    @Override // mctech.api.IConfigChangeListener
    public void onConfigAdded(ConfigHandler configHandler) {
    }

    @Override // mctech.api.IConfigChangeListener
    public void onConfigChanged(ConfigHandler configHandler) {
    }

    @Override // mctech.api.IConfigChangeListener
    public void onConfigErrored(ConfigHandler configHandler) {
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onClientTickEvent(ClientTickEvent.Post post) {
        processEvents();
    }

    @OnlyIn(Dist.CLIENT)
    public void onConfigsLoaded() {
        loadDefaultTypes();
        this.configs.forEach((modContainer, modConfigs) -> {
        });
    }

    @OnlyIn(Dist.CLIENT)
    private void loadDefaultTypes() {
    }

    @OnlyIn(Dist.CLIENT)
    private Screen create(Screen screen, IModConfigs iModConfigs) {
        return null;
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onPlayerServerJoinEvent(ClientPlayerNetworkEvent.LoggingIn loggingIn) {
    }

    private void processEvents() {
        MCTech.FILE_WATCHER.processFileSystemEvents();
    }
}
