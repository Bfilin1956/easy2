package mctech.config;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mctech.api.ConfigType;
import mctech.api.IConfigChangeListener;
import mctech.api.ILogger;
import mctech.config.utils.AutomationType;
import mctech.config.utils.MultilinePolicy;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/FileSystemWatcher.class */
public class FileSystemWatcher {
    private WatchService watchService;
    private ILogger logger;
    private Path basePath;
    private IConfigChangeListener changeListener;
    private Map<String, ConfigHandler> configsByName = new Object2ObjectLinkedOpenHashMap();
    private Set<ConfigHandler> syncedConfigs = new ObjectOpenHashSet();
    private Map<Path, ConfigHandler> configs = new Object2ObjectLinkedOpenHashMap();
    private Map<WatchKey, Path> folders = new Object2ObjectLinkedOpenHashMap();
    private Object sync = new Object();

    public FileSystemWatcher(ILogger iLogger, Path path, IConfigChangeListener iConfigChangeListener) {
        init(iLogger, path, iConfigChangeListener);
    }

    protected void init(ILogger iLogger, Path path, IConfigChangeListener iConfigChangeListener) {
        WatchService watchServiceNewWatchService;
        this.logger = iLogger;
        this.basePath = path;
        this.changeListener = iConfigChangeListener;
        try {
            watchServiceNewWatchService = FileSystems.getDefault().newWatchService();
        } catch (IOException e) {
            watchServiceNewWatchService = null;
            iLogger.error("WatchService could not be created");
            iLogger.error(e);
        }
        this.watchService = watchServiceNewWatchService;
    }

    public Path getBasePath() {
        return this.basePath;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    void onConfigCreated(ConfigHandler configHandler) {
        if (this.changeListener != null) {
            this.changeListener.onConfigCreated(configHandler);
        }
    }

    void onConfigErrored(ConfigHandler configHandler) {
        if (this.changeListener != null) {
            this.changeListener.onConfigErrored(configHandler);
        }
    }

    public ConfigHandler createConfig(Config config) {
        return createConfig(config, ConfigSettings.of());
    }

    public ConfigHandler createConfig(Config config, ConfigSettings configSettings) {
        configSettings.withAutomations(AutomationType.AUTO_LOAD, AutomationType.AUTO_RELOAD, AutomationType.AUTO_SYNC).withBaseFolder(this.basePath).withType(ConfigType.SHARED).withSubFolder("").withLogger(this.logger).withMultiline(MultilinePolicy.ALWAYS_MULTILINE);
        return new ConfigHandler(config, configSettings).setOwner(this);
    }

    public void registerSyncHandler(ConfigHandler configHandler) {
        synchronized (this.sync) {
            this.syncedConfigs.add(configHandler);
            this.configsByName.putIfAbsent(configHandler.getConfigIdentifer(), configHandler);
        }
    }

    public void registerConfigHandler(ConfigHandler configHandler) {
        synchronized (this.sync) {
            this.configsByName.putIfAbsent(configHandler.getConfigIdentifer(), configHandler);
            if (this.changeListener != null) {
                this.changeListener.onConfigAdded(configHandler);
            }
        }
    }

    public void registerReloadHandler(Path path, ConfigHandler configHandler) {
        synchronized (this.sync) {
            if (this.configs.putIfAbsent(path, configHandler) != null) {
                this.logger.warn("tried to register a config that already registered at {} path", path);
                return;
            }
            this.configsByName.putIfAbsent(configHandler.getConfigIdentifer(), configHandler);
            if (!this.folders.containsValue(path.getParent())) {
                try {
                    this.folders.put(path.getParent().register(this.watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY), path.getParent());
                } catch (IOException e) {
                    this.logger.error("could not register WatchService for directory {}", path.getParent());
                }
            }
        }
    }

    public void unregisterReloadHandler(Path path) {
        synchronized (this.sync) {
            if (this.configs.remove(path) == null) {
                return;
            }
            ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
            Iterator<Path> it = this.configs.keySet().iterator();
            while (it.hasNext()) {
                objectOpenHashSet.add(it.next().getParent());
            }
            Iterator<Map.Entry<WatchKey, Path>> it2 = this.folders.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<WatchKey, Path> next = it2.next();
                if (!objectOpenHashSet.contains(next.getValue())) {
                    next.getKey().cancel();
                    it2.remove();
                }
            }
        }
    }

    public ConfigHandler getConfig(String str) {
        return this.configsByName.get(str);
    }

    public void processFileSystemEvents() {
        if (this.watchService == null) {
            return;
        }
        while (true) {
            WatchKey watchKeyPoll = this.watchService.poll();
            if (watchKeyPoll != null) {
                Iterator<WatchEvent<?>> it = watchKeyPoll.pollEvents().iterator();
                while (it.hasNext()) {
                    ConfigHandler configHandler = this.configs.get(this.folders.get(watchKeyPoll).resolve(((Path) it.next().context()).getFileName()));
                    if (configHandler != null && configHandler.reload() && this.changeListener != null && this.syncedConfigs.contains(configHandler)) {
                        this.changeListener.onConfigChanged(configHandler);
                    }
                }
                watchKeyPoll.reset();
            } else {
                return;
            }
        }
    }

    public List<ConfigHandler> getAllConfigs() {
        return new ObjectArrayList(this.configsByName.values());
    }

    public List<ConfigHandler> getConfigsToSync() {
        return new ObjectArrayList(this.syncedConfigs);
    }
}
