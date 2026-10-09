package mctech.g.a.c;

import com.mojang.serialization.MapCodec;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.Supplier;
import mctech.g.a.c.c;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/c/e.class */
public final class e<T extends c> extends Record {
    private final MapCodec<T> a;
    private final StreamCodec<RegistryFriendlyByteBuf, T> b;
    private final Supplier<T> c;

    public e(MapCodec<T> mapCodec, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec, Supplier<T> supplier) {
        this.a = mapCodec;
        this.b = streamCodec;
        this.c = supplier;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, e.class), e.class, "codec;streamCodec;defaultSupplier", "FIELD:Lmctech/g/a/c/e;->a:Lcom/mojang/serialization/MapCodec;", "FIELD:Lmctech/g/a/c/e;->b:Lnet/minecraft/network/codec/StreamCodec;", "FIELD:Lmctech/g/a/c/e;->c:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, e.class), e.class, "codec;streamCodec;defaultSupplier", "FIELD:Lmctech/g/a/c/e;->a:Lcom/mojang/serialization/MapCodec;", "FIELD:Lmctech/g/a/c/e;->b:Lnet/minecraft/network/codec/StreamCodec;", "FIELD:Lmctech/g/a/c/e;->c:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, e.class, Object.class), e.class, "codec;streamCodec;defaultSupplier", "FIELD:Lmctech/g/a/c/e;->a:Lcom/mojang/serialization/MapCodec;", "FIELD:Lmctech/g/a/c/e;->b:Lnet/minecraft/network/codec/StreamCodec;", "FIELD:Lmctech/g/a/c/e;->c:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public MapCodec<T> b() {
        return this.a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, T> c() {
        return this.b;
    }

    public Supplier<T> d() {
        return this.c;
    }

    public T a() {
        return this.c.get();
    }
}
