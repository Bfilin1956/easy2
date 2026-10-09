package mctech.g.a.a;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/a/a.class */
public final class a extends Record {
    private final ResourceKey<Level> c;
    private final BlockPos d;
    public static Codec<a> a = RecordCodecBuilder.create(instance -> {
        return instance.group(ResourceKey.codec(Registries.DIMENSION).fieldOf("Level").forGetter((v0) -> {
            return v0.b();
        }), BlockPos.CODEC.fieldOf("Pos").forGetter((v0) -> {
            return v0.c();
        })).apply(instance, a::new);
    });
    public static StreamCodec<ByteBuf, a> b = StreamCodec.composite(ResourceKey.streamCodec(Registries.DIMENSION), (v0) -> {
        return v0.b();
    }, BlockPos.STREAM_CODEC, (v0) -> {
        return v0.c();
    }, a::new);

    public a(ResourceKey<Level> resourceKey, BlockPos blockPos) {
        this.c = resourceKey;
        this.d = blockPos;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "level;pos", "FIELD:Lmctech/g/a/a/a;->c:Lnet/minecraft/resources/ResourceKey;", "FIELD:Lmctech/g/a/a/a;->d:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "level;pos", "FIELD:Lmctech/g/a/a/a;->c:Lnet/minecraft/resources/ResourceKey;", "FIELD:Lmctech/g/a/a/a;->d:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "level;pos", "FIELD:Lmctech/g/a/a/a;->c:Lnet/minecraft/resources/ResourceKey;", "FIELD:Lmctech/g/a/a/a;->d:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public ResourceKey<Level> b() {
        return this.c;
    }

    public BlockPos c() {
        return this.d;
    }

    public a(Level level, BlockPos blockPos) {
        this((ResourceKey<Level>) level.dimension(), blockPos);
    }

    public static String a(ResourceLocation resourceLocation) {
        return resourceLocation.getNamespace().equals("minecraft") ? resourceLocation.getPath() : resourceLocation.toString();
    }

    public String a() {
        return a(this.c.location());
    }
}
