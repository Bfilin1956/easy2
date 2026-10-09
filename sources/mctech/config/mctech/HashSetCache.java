package mctech.config.mctech;

import java.util.Set;
import mctech.config.ConfigEntry;
import mctech.config.ConfigHandler;
import mctech.utils.a.b;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/mctech/HashSetCache.class */
public class HashSetCache<T> {
    public final ConfigEntry<? extends T[]> configEntry;
    private final Set<T> cache = b.g();

    private HashSetCache(ConfigEntry<? extends T[]> configEntry, ConfigHandler configHandler) {
        this.configEntry = configEntry;
        configHandler.addLoadedListener(this::reload);
    }

    private void reload() {
        this.cache.clear();
        for (T t : this.configEntry.getValue()) {
            this.cache.add(t);
        }
    }

    public boolean contains(T t) {
        return this.cache.contains(t);
    }

    public static <T> HashSetCache<T> create(ConfigEntry<? extends T[]> configEntry, ConfigHandler configHandler) {
        return new HashSetCache<>(configEntry, configHandler);
    }
}
