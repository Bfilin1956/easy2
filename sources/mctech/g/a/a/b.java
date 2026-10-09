package mctech.g.a.a;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Optional;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.LivingEntity;
import org.slf4j.Logger;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/a/b.class */
public final class b extends Record {
    private final CompoundTag f;
    private final float g;
    public static final String a = "id";
    public static final String b = "Health";
    public static Codec<b> c = RecordCodecBuilder.create(instance -> {
        return instance.group(CompoundTag.CODEC.fieldOf("entityTag").forGetter((v0) -> {
            return v0.e();
        }), Codec.FLOAT.fieldOf("maxHealth").forGetter((v0) -> {
            return v0.f();
        })).apply(instance, (v1, v2) -> {
            return new b(v1, v2);
        });
    });
    public static StreamCodec<ByteBuf, b> d = StreamCodec.composite(ByteBufCodecs.COMPOUND_TAG, (v0) -> {
        return v0.c();
    }, ByteBufCodecs.FLOAT, (v0) -> {
        return v0.f();
    }, (v1, v2) -> {
        return new b(v1, v2);
    });
    public static final b e = new b(new CompoundTag(), 0.0f);
    private static final Logger h = LogUtils.getLogger();

    public b(CompoundTag compoundTag, float f) {
        this.f = compoundTag;
        this.g = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "entityTag;maxHealth", "FIELD:Lmctech/g/a/a/b;->f:Lnet/minecraft/nbt/CompoundTag;", "FIELD:Lmctech/g/a/a/b;->g:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "entityTag;maxHealth", "FIELD:Lmctech/g/a/a/b;->f:Lnet/minecraft/nbt/CompoundTag;", "FIELD:Lmctech/g/a/a/b;->g:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "entityTag;maxHealth", "FIELD:Lmctech/g/a/a/b;->f:Lnet/minecraft/nbt/CompoundTag;", "FIELD:Lmctech/g/a/a/b;->g:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public CompoundTag e() {
        return this.f;
    }

    public float f() {
        return this.g;
    }

    public static b a(LivingEntity livingEntity) {
        return new b(livingEntity.serializeNBT(livingEntity.level().registryAccess()), livingEntity.getMaxHealth());
    }

    public static b a(ResourceLocation resourceLocation) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString(a, resourceLocation.toString());
        return new b(compoundTag, 0.0f);
    }

    public boolean a() {
        return b().isPresent();
    }

    public Optional<ResourceLocation> b() {
        if (this.f.contains(a)) {
            return Optional.of(ResourceLocation.parse(this.f.getString(a)));
        }
        return Optional.empty();
    }

    public CompoundTag c() {
        return this.f;
    }

    public Optional<Tuple<Float, Float>> d() {
        if (this.g > 0.0f) {
            CompoundTag compoundTag = this.f;
            if (compoundTag.contains(b)) {
                return Optional.of(new Tuple(Float.valueOf(compoundTag.getFloat(b)), Float.valueOf(this.g)));
            }
        }
        return Optional.empty();
    }

    public Tag a(HolderLookup.Provider provider) {
        if (!a()) {
            throw new IllegalStateException("Cannot encode empty StoredEntityData");
        }
        return (Tag) c.encodeStart(provider.createSerializationContext(NbtOps.INSTANCE), this).getOrThrow();
    }

    public Tag b(HolderLookup.Provider provider) {
        return a() ? a(provider) : new CompoundTag();
    }

    public static Optional<b> a(HolderLookup.Provider provider, Tag tag) {
        return c.parse(provider.createSerializationContext(NbtOps.INSTANCE), tag).resultOrPartial(str -> {
            h.error("Tried to load invalid StoredEntityData: '{}'", str);
        });
    }

    public static b a(HolderLookup.Provider provider, CompoundTag compoundTag) {
        return compoundTag.isEmpty() ? e : a(provider, (Tag) compoundTag).orElse(e);
    }
}
