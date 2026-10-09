package mctech.g.f;

import com.mojang.serialization.MapCodec;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.Supplier;
import mctech.g.f.a;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/f/d.class */
@Deprecated(since = "8.0.0")
public final class d<T extends a<T>> extends Record {
    private final MapCodec<T> a;
    private final StreamCodec<RegistryFriendlyByteBuf, T> b;
    private final Supplier<T> c;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, d.class), d.class, "codec;streamCodec;factory", "FIELD:Lmctech/g/f/d;->a:Lcom/mojang/serialization/MapCodec;", "FIELD:Lmctech/g/f/d;->b:Lnet/minecraft/network/codec/StreamCodec;", "FIELD:Lmctech/g/f/d;->c:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, d.class), d.class, "codec;streamCodec;factory", "FIELD:Lmctech/g/f/d;->a:Lcom/mojang/serialization/MapCodec;", "FIELD:Lmctech/g/f/d;->b:Lnet/minecraft/network/codec/StreamCodec;", "FIELD:Lmctech/g/f/d;->c:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, d.class, Object.class), d.class, "codec;streamCodec;factory", "FIELD:Lmctech/g/f/d;->a:Lcom/mojang/serialization/MapCodec;", "FIELD:Lmctech/g/f/d;->b:Lnet/minecraft/network/codec/StreamCodec;", "FIELD:Lmctech/g/f/d;->c:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public MapCodec<T> a() {
        return this.a;
    }

    public StreamCodec<RegistryFriendlyByteBuf, T> b() {
        return this.b;
    }

    public Supplier<T> c() {
        return this.c;
    }

    public d(MapCodec<T> mapCodec, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec, Supplier<T> supplier) {
        this.a = mapCodec;
        this.b = streamCodec;
        this.c = supplier;
    }
}
