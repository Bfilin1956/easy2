package mctech.config;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import java.util.UUID;
import java.util.function.Supplier;
import mctech.api.buffer.IReadBuffer;
import mctech.config.ConfigEntry;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/SyncedConfig.class */
public class SyncedConfig<T extends ConfigEntry<?>> {
    Object2ObjectMap<UUID, T> mappedEntries = new Object2ObjectLinkedOpenHashMap();
    Supplier<T> creator;

    public SyncedConfig(Supplier<T> supplier, T t) {
        this.creator = supplier;
        this.mappedEntries.defaultReturnValue(t);
    }

    public boolean isPresent(UUID uuid) {
        return this.mappedEntries.containsKey(uuid);
    }

    public T get(UUID uuid) {
        return (T) this.mappedEntries.get(uuid);
    }

    public void onSync(IReadBuffer iReadBuffer, UUID uuid) {
        ((ConfigEntry) this.mappedEntries.computeIfAbsent(uuid, obj -> {
            return this.creator.get();
        })).deserializeValue(iReadBuffer);
    }
}
