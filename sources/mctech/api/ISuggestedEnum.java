package mctech.api;

import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.lang.Enum;
import java.util.Map;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/ISuggestedEnum.class */
public interface ISuggestedEnum<T extends Enum<T>> {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/ISuggestedEnum$EnumStorage.class */
    public static class EnumStorage {
        private static final Map<Class<? extends Enum<?>>, ISuggestedEnum<?>> WRAPPERS = Object2ObjectMaps.synchronize(new Object2ObjectOpenHashMap());
    }

    String getName(T t);

    static void registerWrapper(Class<? extends Enum<?>> cls, ISuggestedEnum<?> iSuggestedEnum) {
        EnumStorage.WRAPPERS.put(cls, iSuggestedEnum);
    }

    static <T extends Enum<T>> ISuggestedEnum<T> getWrapper(T t) {
        return t instanceof ISuggestedEnum ? (ISuggestedEnum) t : (ISuggestedEnum) EnumStorage.WRAPPERS.get(t.getClass());
    }
}
