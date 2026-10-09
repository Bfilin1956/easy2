package mctech.q;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/b.class */
public final class b {
    private static final ConcurrentHashMap<Class<?>, List<String>> a = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Class<?>, List<String>> b = new ConcurrentHashMap<>();

    private b() {
    }

    public static List<String> a(Class<?> cls) {
        return a.computeIfAbsent(cls, cls2 -> {
            return Collections.synchronizedList(new ArrayList());
        });
    }

    public static List<String> b(Class<?> cls) {
        return b.computeIfAbsent(cls, cls2 -> {
            return Collections.synchronizedList(new ArrayList());
        });
    }
}
