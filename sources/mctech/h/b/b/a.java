package mctech.h.b.b;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/b/b/a.class */
public class a<V> extends d {
    private final String c;
    private JsonElement d;
    private final b<V> e;
    private final Consumer<V> f;

    private a(Class<?> cls, String str, b<V> bVar) {
        this(cls, str, bVar, null);
    }

    private a(Class<?> cls, String str, b<V> bVar, Consumer<V> consumer) {
        super(cls);
        this.c = str;
        this.e = bVar;
        this.f = consumer;
    }

    public void a(V v) {
        if (this.f != null && v != null) {
            this.f.accept(v);
        }
    }

    @Override // mctech.h.b.b.d
    public final void a(mctech.h.b.a aVar) {
        JsonObject jsonObjectC = aVar.c(this.a.a());
        if (jsonObjectC == null || !jsonObjectC.has(this.c)) {
            return;
        }
        JsonElement jsonElement = jsonObjectC.get(this.c);
        if (this.d == null || !this.d.equals(jsonElement)) {
            this.d = jsonElement;
        }
        if (this.d != null) {
            a(this.e.map(this.d));
        }
    }

    public static <K, V> a<Map<K, V>> a(Class<?> cls, String str, Consumer<Map<K, V>> consumer) {
        return new a<>(cls, str, jsonElement -> {
            return (Map) mctech.h.b.a.a.fromJson(jsonElement, Map.class);
        }, consumer);
    }

    public static <V> a<V> b(final Class<?> cls, final String str, Consumer<V> consumer) {
        return new a<>(cls, str, new b<V>() { // from class: mctech.h.b.b.a.1
            private Field c;

            @Override // mctech.h.b.b.b
            public V map(JsonElement jsonElement) {
                if (this.c == null) {
                    Stream streamPeek = Arrays.stream(cls.getDeclaredFields()).filter(field -> {
                        return Modifier.isStatic(field.getModifiers());
                    }).filter(field2 -> {
                        return field2.isAnnotationPresent(mctech.h.b.a.a.class);
                    }).peek(field3 -> {
                        field3.setAccessible(true);
                    });
                    String str2 = str;
                    this.c = (Field) streamPeek.filter(field4 -> {
                        SerializedName annotation = field4.getAnnotation(SerializedName.class);
                        return str2.equals(annotation != null ? annotation.value() : ((mctech.h.b.a.a) field4.getAnnotation(mctech.h.b.a.a.class)).a());
                    }).findFirst().orElse(null);
                }
                if (this.c == null) {
                    return null;
                }
                return (V) mctech.h.b.a.a.fromJson(jsonElement, this.c.getType());
            }
        }, consumer);
    }
}
