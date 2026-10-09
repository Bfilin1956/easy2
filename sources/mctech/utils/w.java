package mctech.utils;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/w.class */
public final class w<K, V> extends Record {

    @NotNull
    private final K a;
    private final V b;

    public w(@NotNull K k, V v) {
        this.a = k;
        this.b = v;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, w.class), w.class, "key;value", "FIELD:Lmctech/utils/w;->a:Ljava/lang/Object;", "FIELD:Lmctech/utils/w;->b:Ljava/lang/Object;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, w.class), w.class, "key;value", "FIELD:Lmctech/utils/w;->a:Ljava/lang/Object;", "FIELD:Lmctech/utils/w;->b:Ljava/lang/Object;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, w.class, Object.class), w.class, "key;value", "FIELD:Lmctech/utils/w;->a:Ljava/lang/Object;", "FIELD:Lmctech/utils/w;->b:Ljava/lang/Object;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public K a() {
        return this.a;
    }

    public V b() {
        return this.b;
    }
}
