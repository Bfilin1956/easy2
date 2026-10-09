package mctech.g.a;

import com.google.common.base.Preconditions;
import com.mojang.serialization.MapCodec;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.Supplier;
import mctech.g.a.j;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/k.class */
public final class k<T extends j<T>> extends Record {

    @Nullable
    private final MapCodec<T> a;
    private final Supplier<T> b;

    public k(@Nullable MapCodec<T> mapCodec, Supplier<T> supplier) {
        this.a = mapCodec;
        this.b = supplier;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, k.class), k.class, "codec;factory", "FIELD:Lmctech/g/a/k;->a:Lcom/mojang/serialization/MapCodec;", "FIELD:Lmctech/g/a/k;->b:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, k.class), k.class, "codec;factory", "FIELD:Lmctech/g/a/k;->a:Lcom/mojang/serialization/MapCodec;", "FIELD:Lmctech/g/a/k;->b:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, k.class, Object.class), k.class, "codec;factory", "FIELD:Lmctech/g/a/k;->a:Lcom/mojang/serialization/MapCodec;", "FIELD:Lmctech/g/a/k;->b:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nullable
    public MapCodec<T> c() {
        return this.a;
    }

    public Supplier<T> d() {
        return this.b;
    }

    public boolean a() {
        return this.a != null;
    }

    public MapCodec<T> b() {
        Preconditions.checkState(this.a != null, String.valueOf(this) + " is not a persistent context");
        return this.a;
    }
}
