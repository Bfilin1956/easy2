package mctech.utils.a;

import it.unimi.dsi.fastutil.Hash;
import it.unimi.dsi.fastutil.PriorityQueue;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenCustomHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenCustomHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayFIFOQueue;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectArrays;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenCustomHashSet;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectOpenCustomHashSet;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a/b.class */
public class b {

    /* JADX INFO: renamed from: mctech.utils.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a/b$b.class */
    public interface InterfaceC0041b {
        int a();
    }

    public static <K> List<K>[] a(int i) {
        List<K>[] listArr = new List[i];
        for (int i2 = 0; i2 < i; i2++) {
            listArr[i2] = new ObjectArrayList();
        }
        return listArr;
    }

    public static IntList[] b(int i) {
        IntList[] intListArr = new IntList[i];
        for (int i2 = 0; i2 < i; i2++) {
            intListArr[i2] = new IntArrayList();
        }
        return intListArr;
    }

    public static <T> ObjectSet<T>[] c(int i) {
        ObjectSet<T>[] objectSetArr = new ObjectSet[i];
        for (int i2 = 0; i2 < i; i2++) {
            objectSetArr[i2] = h();
        }
        return objectSetArr;
    }

    public static <K, V> Object2ObjectMap<K, V>[] a(int i, boolean z) {
        Object2ObjectMap<K, V>[] object2ObjectMapArr = new Object2ObjectMap[i];
        for (int i2 = 0; i2 < i; i2++) {
            object2ObjectMapArr[i2] = z ? new Object2ObjectLinkedOpenHashMap() : new Object2ObjectOpenHashMap();
        }
        return object2ObjectMapArr;
    }

    public static <T extends InterfaceC0041b> T[] a(T[] tArr) {
        ObjectArrays.quickSort(tArr, a.a);
        return tArr;
    }

    public static <K, V extends Supplier<K>> k<K, V> a() {
        return new k<>();
    }

    public static <K, P, V extends Function<P, K>> e<K, P, V> b() {
        return new e<>();
    }

    public static <K, P, J, V extends Function<P, K>, M extends Function<J, K>> e.a<K, P, J, V, M> c() {
        return new e.a<>();
    }

    public static <V> j<V> d() {
        return new j<>();
    }

    public static <K, V> Object2ObjectMap<K, V> e() {
        return new Object2ObjectOpenHashMap();
    }

    public static <K, V> Object2ObjectSortedMap<K, V> f() {
        return new Object2ObjectLinkedOpenHashMap();
    }

    public static <K, V> Object2ObjectSortedMap<K, V> a(K k, V v) {
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        object2ObjectLinkedOpenHashMap.put(k, v);
        return object2ObjectLinkedOpenHashMap;
    }

    public static <K, V> Object2ObjectMap<K, V> a(Hash.Strategy<K> strategy) {
        return new Object2ObjectOpenCustomHashMap(strategy);
    }

    public static <K, V> Object2ObjectSortedMap<K, V> b(Hash.Strategy<K> strategy) {
        return new Object2ObjectLinkedOpenCustomHashMap(strategy);
    }

    public static <K> ObjectSet<K> g() {
        return new ObjectOpenHashSet();
    }

    public static <K> ObjectSet<K> c(Hash.Strategy<K> strategy) {
        return new ObjectOpenCustomHashSet(strategy);
    }

    public static <K> ObjectSortedSet<K> h() {
        return new ObjectLinkedOpenHashSet();
    }

    public static <K> ObjectSortedSet<K> d(Hash.Strategy<K> strategy) {
        return new ObjectLinkedOpenCustomHashSet(strategy);
    }

    public static <K> ObjectList<K> i() {
        return new ObjectArrayList();
    }

    @SafeVarargs
    public static <K> ObjectList<K> a(K... kArr) {
        return ObjectArrayList.wrap(kArr);
    }

    public static <K, V> TreeMap<K, V> j() {
        return new TreeMap<>();
    }

    public static <T> PriorityQueue<T> k() {
        return new ObjectArrayFIFOQueue();
    }

    public static <T> List<T> a(List<T> list, List<T> list2) {
        ObjectArrayList objectArrayList = new ObjectArrayList(list);
        objectArrayList.addAll(list2);
        return objectArrayList;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a/b$a.class */
    public static class a implements Comparator<InterfaceC0041b> {
        public static final a a = new a();

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(InterfaceC0041b interfaceC0041b, InterfaceC0041b interfaceC0041b2) {
            return Integer.compare(interfaceC0041b.a(), interfaceC0041b2.a());
        }
    }
}
