package mctech.g.b.a;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/k.class */
public final class k<T> {
    private final b<T> h;
    private final Supplier<T> i;
    private final Consumer<T> j;
    private int k;
    public static final a<String> a = new a<>(Codec.STRING, ByteBufCodecs.STRING_UTF8.cast());
    public static final a<Boolean> b = new a<>(Codec.BOOL, ByteBufCodecs.BOOL.cast());
    public static final a<Integer> c = new a<>(Codec.INT, ByteBufCodecs.INT.cast());
    public static final a<Long> d = new a<>(Codec.LONG, ByteBufCodecs.VAR_LONG.cast());
    public static final a<Float> e = new a<>(Codec.FLOAT, ByteBufCodecs.FLOAT.cast());
    public static final a<ResourceLocation> f = new a<>(ResourceLocation.CODEC, ResourceLocation.STREAM_CODEC.cast());
    public static final a<FluidStack> g = new a<>(FluidStack.OPTIONAL_CODEC, FluidStack.OPTIONAL_STREAM_CODEC, fluidStack -> {
        return Integer.valueOf((fluidStack.hashCode() * 31) + fluidStack.getAmount());
    });

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/k$b.class */
    public interface b<T> {
        int a(T t);

        Tag a(HolderLookup.Provider provider, T t);

        T a(HolderLookup.Provider provider, Tag tag, Supplier<T> supplier);

        void a(RegistryFriendlyByteBuf registryFriendlyByteBuf, T t);

        T a(RegistryFriendlyByteBuf registryFriendlyByteBuf, Supplier<T> supplier);
    }

    public k(b<T> bVar, Supplier<T> supplier, Consumer<T> consumer) {
        this.h = bVar;
        this.i = supplier;
        this.j = consumer;
    }

    @Nullable
    public Tag a(HolderLookup.Provider provider, boolean z) {
        if (a() && !z) {
            return null;
        }
        T t = this.i.get();
        this.k = this.h.a(t);
        return this.h.a(provider, t);
    }

    public void a(HolderLookup.Provider provider, Tag tag) {
        this.j.accept(this.h.a(provider, tag, this.i));
    }

    public void a(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        T t = this.i.get();
        this.k = this.h.a(t);
        this.h.a(registryFriendlyByteBuf, t);
    }

    public void a(RegistryFriendlyByteBuf registryFriendlyByteBuf, T t) {
        this.h.a(registryFriendlyByteBuf, t);
    }

    public void b(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.j.accept(this.h.a(registryFriendlyByteBuf, (Supplier) this.i));
    }

    public boolean a() {
        return this.k != this.h.a(this.i.get());
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/k$a.class */
    public static final class a<T> extends Record implements b<T> {
        private final Codec<T> a;
        private final StreamCodec<RegistryFriendlyByteBuf, T> b;
        private final Function<T, Integer> c;

        public a(Codec<T> codec, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec, Function<T, Integer> function) {
            this.a = codec;
            this.b = streamCodec;
            this.c = function;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "codec;streamCodec;hashFunction", "FIELD:Lmctech/g/b/a/k$a;->a:Lcom/mojang/serialization/Codec;", "FIELD:Lmctech/g/b/a/k$a;->b:Lnet/minecraft/network/codec/StreamCodec;", "FIELD:Lmctech/g/b/a/k$a;->c:Ljava/util/function/Function;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "codec;streamCodec;hashFunction", "FIELD:Lmctech/g/b/a/k$a;->a:Lcom/mojang/serialization/Codec;", "FIELD:Lmctech/g/b/a/k$a;->b:Lnet/minecraft/network/codec/StreamCodec;", "FIELD:Lmctech/g/b/a/k$a;->c:Ljava/util/function/Function;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "codec;streamCodec;hashFunction", "FIELD:Lmctech/g/b/a/k$a;->a:Lcom/mojang/serialization/Codec;", "FIELD:Lmctech/g/b/a/k$a;->b:Lnet/minecraft/network/codec/StreamCodec;", "FIELD:Lmctech/g/b/a/k$a;->c:Ljava/util/function/Function;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public Codec<T> a() {
            return this.a;
        }

        public StreamCodec<RegistryFriendlyByteBuf, T> b() {
            return this.b;
        }

        public Function<T, Integer> c() {
            return this.c;
        }

        public a(Codec<T> codec, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec) {
            this(codec, streamCodec, (v0) -> {
                return v0.hashCode();
            });
        }

        public k<T> a(Supplier<T> supplier, Consumer<T> consumer) {
            return new k<>(this, supplier, consumer);
        }

        public static <T> a<Set<T>> a(Codec<T> codec, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec) {
            return new a<>(codec.listOf().xmap((v0) -> {
                return ImmutableSet.copyOf(v0);
            }, (v0) -> {
                return ImmutableList.copyOf(v0);
            }), streamCodec.apply(ByteBufCodecs.list()).map((v0) -> {
                return ImmutableSet.copyOf(v0);
            }, (v0) -> {
                return ImmutableList.copyOf(v0);
            }));
        }

        public static <T> a<List<T>> b(Codec<T> codec, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec) {
            return new a<>(codec.listOf(), streamCodec.apply(ByteBufCodecs.list()));
        }

        public static <T, U> a<Map<T, U>> a(Codec<T> codec, Codec<U> codec2, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec, StreamCodec<RegistryFriendlyByteBuf, U> streamCodec2) {
            return new a<>(Codec.unboundedMap(codec, codec2), ByteBufCodecs.map(HashMap::new, streamCodec, streamCodec2));
        }

        @Override // mctech.g.b.a.k.b
        public int a(T t) {
            return this.c.apply(t).intValue();
        }

        @Override // mctech.g.b.a.k.b
        public Tag a(HolderLookup.Provider provider, T t) {
            return (Tag) this.a.encodeStart(provider.createSerializationContext(NbtOps.INSTANCE), t).getOrThrow();
        }

        @Override // mctech.g.b.a.k.b
        public T a(HolderLookup.Provider provider, Tag tag, Supplier<T> supplier) {
            return (T) this.a.parse(provider.createSerializationContext(NbtOps.INSTANCE), tag).getOrThrow();
        }

        @Override // mctech.g.b.a.k.b
        public void a(RegistryFriendlyByteBuf registryFriendlyByteBuf, T t) {
            this.b.encode(registryFriendlyByteBuf, t);
        }

        @Override // mctech.g.b.a.k.b
        public T a(RegistryFriendlyByteBuf registryFriendlyByteBuf, Supplier<T> supplier) {
            return (T) this.b.decode(registryFriendlyByteBuf);
        }
    }
}
