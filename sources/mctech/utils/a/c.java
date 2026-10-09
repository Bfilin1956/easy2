package mctech.utils.a;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a/c.class */
public class c {
    @SafeVarargs
    public static <K, V> List<V> a(Map<K, V> map, K... kArr) {
        Stream stream = Arrays.stream(kArr);
        Objects.requireNonNull(map);
        Stream streamFilter = stream.filter(map::containsKey);
        Objects.requireNonNull(map);
        return (List) streamFilter.map(map::get).collect(Collectors.toList());
    }

    @SafeVarargs
    public static <K, V> V[] a(Map<K, V> map, Class<V> cls, K... kArr) {
        List listA = a(map, kArr);
        return (V[]) listA.toArray((Object[]) Array.newInstance((Class<?>) cls, listA.size()));
    }

    @SafeVarargs
    public static <K, V> V[] a(Collection<? extends Map<K, V>> collection, Class<V> cls, K... kArr) {
        List list = collection.stream().flatMap(map -> {
            return a(map, kArr).stream();
        }).toList();
        return (V[]) list.toArray((Object[]) Array.newInstance((Class<?>) cls, list.size()));
    }

    @SafeVarargs
    public static <K, V> List<V> b(Map<K, V> map, K... kArr) {
        HashSet hashSet = new HashSet(Arrays.asList(kArr));
        return (List) map.entrySet().stream().filter(entry -> {
            return !hashSet.contains(entry.getKey());
        }).map((v0) -> {
            return v0.getValue();
        }).collect(Collectors.toList());
    }

    @SafeVarargs
    public static <K, V> V[] b(Map<K, V> map, Class<V> cls, K... kArr) {
        List listB = b(map, kArr);
        return (V[]) listB.toArray((Object[]) Array.newInstance((Class<?>) cls, listB.size()));
    }

    @SafeVarargs
    public static <K, V> V[] b(Collection<? extends Map<K, V>> collection, Class<V> cls, K... kArr) {
        List list = collection.stream().flatMap(map -> {
            return b(map, kArr).stream();
        }).toList();
        return (V[]) list.toArray((Object[]) Array.newInstance((Class<?>) cls, list.size()));
    }
}
