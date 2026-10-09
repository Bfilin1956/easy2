package mctech.g.a;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import mctech.g.a.a;
import net.minecraft.core.Registry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.capabilities.BlockCapability;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/m.class */
public interface m<T extends mctech.g.a.a<T, ?>> {
    public static final Codec<m<?>> a;
    public static final StreamCodec<RegistryFriendlyByteBuf, m<?>> b;

    MapCodec<T> a();

    Set<BlockCapability<?, ?>> b();

    static {
        Registry<m<?>> registry = l.a;
        Objects.requireNonNull(registry);
        a = Codec.lazyInitialized(registry::byNameCodec);
        b = StreamCodec.recursive(streamCodec -> {
            return ByteBufCodecs.registry(l.a.c);
        });
    }

    static <T extends mctech.g.a.a<T, ?>> m<T> a(MapCodec<T> mapCodec) {
        return b(mapCodec).a();
    }

    static <T extends mctech.g.a.a<T, ?>> a<T> b(MapCodec<T> mapCodec) {
        return new a<>(mapCodec);
    }

    static <T extends mctech.g.a.a<T, ?>> m<T> a(BiFunction<ResourceLocation, Component, T> biFunction) {
        return b(biFunction).a();
    }

    static <T extends mctech.g.a.a<T, ?>> a<T> b(BiFunction<ResourceLocation, Component, T> biFunction) {
        return new a<>(RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(ResourceLocation.CODEC.fieldOf("texture").forGetter((v0) -> {
                return v0.a();
            }), ComponentSerialization.CODEC.fieldOf("description").forGetter((v0) -> {
                return v0.b();
            })).apply(instance, biFunction);
        }));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/m$a.class */
    public static class a<T extends mctech.g.a.a<T, ?>> {
        private final MapCodec<T> a;
        private final Set<BlockCapability<?, ?>> b = new HashSet();

        private a(MapCodec<T> mapCodec) {
            this.a = mapCodec;
        }

        public <U> a<T> a(BlockCapability<U, ?> blockCapability) {
            this.b.add(blockCapability);
            return this;
        }

        public m<T> a() {
            return new C0007a(this.a, this.b);
        }

        /* JADX INFO: renamed from: mctech.g.a.m$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/m$a$a.class */
        static final class C0007a<T extends mctech.g.a.a<T, ?>> extends Record implements m<T> {
            private final MapCodec<T> c;
            private final Set<BlockCapability<?, ?>> d;

            C0007a(MapCodec<T> mapCodec, Set<BlockCapability<?, ?>> set) {
                this.c = mapCodec;
                this.d = set;
            }

            @Override // java.lang.Record
            public final String toString() {
                return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0007a.class), C0007a.class, "codec;exposedCapabilities", "FIELD:Lmctech/g/a/m$a$a;->c:Lcom/mojang/serialization/MapCodec;", "FIELD:Lmctech/g/a/m$a$a;->d:Ljava/util/Set;").dynamicInvoker().invoke(this) /* invoke-custom */;
            }

            @Override // java.lang.Record
            public final int hashCode() {
                return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0007a.class), C0007a.class, "codec;exposedCapabilities", "FIELD:Lmctech/g/a/m$a$a;->c:Lcom/mojang/serialization/MapCodec;", "FIELD:Lmctech/g/a/m$a$a;->d:Ljava/util/Set;").dynamicInvoker().invoke(this) /* invoke-custom */;
            }

            @Override // java.lang.Record
            public final boolean equals(Object obj) {
                return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0007a.class, Object.class), C0007a.class, "codec;exposedCapabilities", "FIELD:Lmctech/g/a/m$a$a;->c:Lcom/mojang/serialization/MapCodec;", "FIELD:Lmctech/g/a/m$a$a;->d:Ljava/util/Set;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
            }

            @Override // mctech.g.a.m
            public MapCodec<T> a() {
                return this.c;
            }

            @Override // mctech.g.a.m
            public Set<BlockCapability<?, ?>> b() {
                return this.d;
            }
        }
    }
}
