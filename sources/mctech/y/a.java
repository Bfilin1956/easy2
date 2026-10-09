package mctech.y;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.codecs.PrimitiveCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.network.codec.NeoForgeStreamCodecs;
import net.neoforged.neoforge.registries.DeferredHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/y/a.class */
public final class a extends Record {
    private final EnumC0053a c;
    private final ResourceLocation d;
    private final c e;
    private final int f;
    private final int g;
    private final float h;
    public static final Codec<a> a = RecordCodecBuilder.create(instance -> {
        return instance.group(EnumC0053a.c.fieldOf("targetType").forGetter((v0) -> {
            return v0.a();
        }), ResourceLocation.CODEC.fieldOf("target").forGetter((v0) -> {
            return v0.b();
        }), c.c.fieldOf("renderMode").forGetter((v0) -> {
            return v0.c();
        }), Codec.INT.fieldOf("color").forGetter((v0) -> {
            return v0.d();
        }), Codec.INT.fieldOf("alpha").forGetter((v0) -> {
            return v0.e();
        }), Codec.FLOAT.fieldOf("brightness").forGetter((v0) -> {
            return v0.f();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new a(v1, v2, v3, v4, v5, v6);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, a> b = StreamCodec.composite(NeoForgeStreamCodecs.enumCodec(EnumC0053a.class), (v0) -> {
        return v0.a();
    }, ResourceLocation.STREAM_CODEC, (v0) -> {
        return v0.b();
    }, NeoForgeStreamCodecs.enumCodec(c.class), (v0) -> {
        return v0.c();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.d();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.e();
    }, ByteBufCodecs.FLOAT, (v0) -> {
        return v0.f();
    }, (v1, v2, v3, v4, v5, v6) -> {
        return new a(v1, v2, v3, v4, v5, v6);
    });

    /* JADX INFO: renamed from: mctech.y.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/y/a$a.class */
    public enum EnumC0053a {
        BLOCK,
        TAG;

        public static Codec<EnumC0053a> c = new PrimitiveCodec<EnumC0053a>() { // from class: mctech.y.a.a.1
            public <T> DataResult<EnumC0053a> read(DynamicOps<T> dynamicOps, T t) {
                return dynamicOps.getNumberValue(t).map(number -> {
                    return EnumC0053a.values()[number.intValue()];
                });
            }

            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public <T> T write(DynamicOps<T> dynamicOps, EnumC0053a enumC0053a) {
                return (T) dynamicOps.createInt(enumC0053a.ordinal());
            }

            public String toString() {
                return "TargetType";
            }
        };
    }

    public a(EnumC0053a enumC0053a, ResourceLocation resourceLocation, c cVar, int i, int i2, float f) {
        this.c = enumC0053a;
        this.d = resourceLocation;
        this.e = cVar;
        this.f = i;
        this.g = i2;
        this.h = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "targetType;target;renderMode;color;alpha;brightness", "FIELD:Lmctech/y/a;->c:Lmctech/y/a$a;", "FIELD:Lmctech/y/a;->d:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/y/a;->e:Lmctech/y/c;", "FIELD:Lmctech/y/a;->f:I", "FIELD:Lmctech/y/a;->g:I", "FIELD:Lmctech/y/a;->h:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "targetType;target;renderMode;color;alpha;brightness", "FIELD:Lmctech/y/a;->c:Lmctech/y/a$a;", "FIELD:Lmctech/y/a;->d:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/y/a;->e:Lmctech/y/c;", "FIELD:Lmctech/y/a;->f:I", "FIELD:Lmctech/y/a;->g:I", "FIELD:Lmctech/y/a;->h:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "targetType;target;renderMode;color;alpha;brightness", "FIELD:Lmctech/y/a;->c:Lmctech/y/a$a;", "FIELD:Lmctech/y/a;->d:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/y/a;->e:Lmctech/y/c;", "FIELD:Lmctech/y/a;->f:I", "FIELD:Lmctech/y/a;->g:I", "FIELD:Lmctech/y/a;->h:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public EnumC0053a a() {
        return this.c;
    }

    public ResourceLocation b() {
        return this.d;
    }

    public c c() {
        return this.e;
    }

    public int d() {
        return this.f;
    }

    public int e() {
        return this.g;
    }

    public float f() {
        return this.h;
    }

    public a(Block block, c cVar, int i, int i2, float f) {
        this(EnumC0053a.BLOCK, BuiltInRegistries.BLOCK.getKey(block), cVar, i, i2, f);
    }

    public a(DeferredHolder<Block, ? extends Block> deferredHolder, c cVar, int i, int i2, float f) {
        this(EnumC0053a.BLOCK, deferredHolder.getId(), cVar, i, i2, f);
    }

    public a(TagKey<Block> tagKey, c cVar, int i, int i2, float f) {
        this(EnumC0053a.TAG, tagKey.location(), cVar, i, i2, f);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public boolean a(BlockState blockState) throws MatchException {
        switch (this.c) {
            case BLOCK:
                Block block = (Block) BuiltInRegistries.BLOCK.get(this.d);
                return block != null && blockState.is(block);
            case TAG:
                return blockState.is(TagKey.create(BuiltInRegistries.BLOCK.key(), this.d));
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    public static a a(Block block, int i) {
        return new a(block, c.TEXTURED, 16777215, i, 1.0f);
    }

    public static a a(TagKey<Block> tagKey, int i) {
        return new a(tagKey, c.TEXTURED, 16777215, i, 1.0f);
    }

    public static a a(DeferredHolder<Block, ? extends Block> deferredHolder, int i) {
        return new a(deferredHolder, c.TEXTURED, 16777215, i, 1.0f);
    }

    public static a a(Block block, int i, float f) {
        return new a(block, c.COLORED, i, 255, f);
    }

    public static a a(TagKey<Block> tagKey, int i, float f) {
        return new a(tagKey, c.COLORED, i, 255, f);
    }

    public static a a(DeferredHolder<Block, ? extends Block> deferredHolder, int i, float f) {
        return new a(deferredHolder, c.COLORED, i, 255, f);
    }

    public static a a(Block block, c cVar, int i, int i2, float f) {
        return new a(block, cVar, i, i2, f);
    }

    public static a a(TagKey<Block> tagKey, c cVar, int i, int i2, float f) {
        return new a(tagKey, cVar, i, i2, f);
    }

    public static a a(c cVar, a aVar) {
        return new a(aVar.a(), aVar.b(), cVar, aVar.d(), aVar.e(), aVar.f());
    }
}
