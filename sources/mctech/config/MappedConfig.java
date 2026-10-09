package mctech.config;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/MappedConfig.class */
public abstract class MappedConfig<K, V> implements Runnable {
    Object2ObjectMap<K, V> mapped = new Object2ObjectLinkedOpenHashMap();
    Function<Object, K> keyGenerator;
    Function<Object, V> valueGenerator;

    protected abstract void getElements(Consumer<Object> consumer);

    protected MappedConfig(Function<Object, K> function, Function<Object, V> function2) {
        this.keyGenerator = function;
        this.valueGenerator = function2;
    }

    public static <K, V, T> MappedConfig<K, V> create(ConfigHandler configHandler, ConfigEntry.ArrayConfigEntry<T> arrayConfigEntry, Function<T, K> function, Function<T, V> function2) {
        ArrayMappedConfig arrayMappedConfig = new ArrayMappedConfig(arrayConfigEntry, function, function2);
        configHandler.addLoadedListener(arrayMappedConfig);
        return arrayMappedConfig;
    }

    public static <K, V, T, E extends Collection<T>> MappedConfig<K, V> create(ConfigHandler configHandler, ConfigEntry.CollectionConfigEntry<T, E> collectionConfigEntry, Function<T, K> function, Function<T, V> function2) {
        CollectionMappedConfig collectionMappedConfig = new CollectionMappedConfig(collectionConfigEntry, function, function2);
        configHandler.addLoadedListener(collectionMappedConfig);
        return collectionMappedConfig;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return this.mapped.entrySet();
    }

    public Set<K> keySet() {
        return this.mapped.keySet();
    }

    public Collection<V> values() {
        return this.mapped.values();
    }

    public boolean contains(K k) {
        return this.mapped.containsKey(k);
    }

    public V get(K k) {
        return (V) this.mapped.get(k);
    }

    public V getOrDefault(K k, V v) {
        return (V) this.mapped.getOrDefault(k, v);
    }

    @Override // java.lang.Runnable
    public void run() {
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        getElements(obj -> {
            object2ObjectLinkedOpenHashMap.put(this.keyGenerator.apply(obj), this.valueGenerator.apply(obj));
        });
        this.mapped = object2ObjectLinkedOpenHashMap;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/MappedConfig$ArrayMappedConfig.class */
    public static class ArrayMappedConfig<K, V, T> extends MappedConfig<K, V> {
        ConfigEntry.ArrayConfigEntry<T> config;

        public ArrayMappedConfig(ConfigEntry.ArrayConfigEntry<T> arrayConfigEntry, Function<Object, K> function, Function<Object, V> function2) {
            super(function, function2);
            this.config = arrayConfigEntry;
        }

        @Override // mctech.config.MappedConfig
        protected void getElements(Consumer<Object> consumer) {
            for (Object obj : (Object[]) this.config.getValue()) {
                consumer.accept(obj);
            }
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/MappedConfig$CollectionMappedConfig.class */
    public static class CollectionMappedConfig<K, V, T, E extends Collection<T>> extends MappedConfig<K, V> {
        ConfigEntry.CollectionConfigEntry<T, E> config;

        public CollectionMappedConfig(ConfigEntry.CollectionConfigEntry<T, E> collectionConfigEntry, Function<Object, K> function, Function<Object, V> function2) {
            super(function, function2);
            this.config = collectionConfigEntry;
        }

        @Override // mctech.config.MappedConfig
        protected void getElements(Consumer<Object> consumer) {
            ((Collection) this.config.getValue()).forEach(consumer);
        }
    }
}
