package mctech.modules;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import javax.annotation.Nonnull;
import mctech.init.MCTechCodecs;
import mctech.items.base.l;
import mctech.modules.config.ModuleConfig;
import mctech.modules.config.ModuleConfigJsonSerializer;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/j.class */
public final class j extends Record implements ModuleConfig {
    private final l d;
    private final float e;
    private final boolean f;
    private final boolean g;
    private final float h;
    private final float i;
    public static final MapCodec<j> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(l.i.fieldOf("tier").forGetter((v0) -> {
            return v0.tier();
        }), Codec.FLOAT.fieldOf("eggDropChance").forGetter((v0) -> {
            return v0.a();
        }), Codec.BOOL.fieldOf("includeHostile").forGetter((v0) -> {
            return v0.b();
        }), Codec.BOOL.fieldOf("includePlayer").forGetter((v0) -> {
            return v0.c();
        }), Codec.FLOAT.fieldOf("questMobEggDropChance").forGetter((v0) -> {
            return v0.d();
        }), Codec.FLOAT.fieldOf("questBossEggDropChance").forGetter((v0) -> {
            return v0.e();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new j(v1, v2, v3, v4, v5, v6);
        });
    });
    public static final StreamCodec<? extends RegistryFriendlyByteBuf, j> b = StreamCodec.composite(l.j, (v0) -> {
        return v0.tier();
    }, ByteBufCodecs.FLOAT, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.c();
    }, ByteBufCodecs.FLOAT, (v0) -> {
        return v0.d();
    }, ByteBufCodecs.FLOAT, (v0) -> {
        return v0.e();
    }, (v1, v2, v3, v4, v5, v6) -> {
        return new j(v1, v2, v3, v4, v5, v6);
    });
    public static final a c = new a();

    public j(l lVar, float f, boolean z, boolean z2, float f2, float f3) {
        this.d = lVar;
        this.e = f;
        this.f = z;
        this.g = z2;
        this.h = f2;
        this.i = f3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, j.class), j.class, "tier;eggDropChance;includeHostile;includePlayer;questMobEggDropChance;questBossEggDropChance", "FIELD:Lmctech/modules/j;->d:Lmctech/items/base/l;", "FIELD:Lmctech/modules/j;->e:F", "FIELD:Lmctech/modules/j;->f:Z", "FIELD:Lmctech/modules/j;->g:Z", "FIELD:Lmctech/modules/j;->h:F", "FIELD:Lmctech/modules/j;->i:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, j.class), j.class, "tier;eggDropChance;includeHostile;includePlayer;questMobEggDropChance;questBossEggDropChance", "FIELD:Lmctech/modules/j;->d:Lmctech/items/base/l;", "FIELD:Lmctech/modules/j;->e:F", "FIELD:Lmctech/modules/j;->f:Z", "FIELD:Lmctech/modules/j;->g:Z", "FIELD:Lmctech/modules/j;->h:F", "FIELD:Lmctech/modules/j;->i:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, j.class, Object.class), j.class, "tier;eggDropChance;includeHostile;includePlayer;questMobEggDropChance;questBossEggDropChance", "FIELD:Lmctech/modules/j;->d:Lmctech/items/base/l;", "FIELD:Lmctech/modules/j;->e:F", "FIELD:Lmctech/modules/j;->f:Z", "FIELD:Lmctech/modules/j;->g:Z", "FIELD:Lmctech/modules/j;->h:F", "FIELD:Lmctech/modules/j;->i:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public float a() {
        return this.e;
    }

    public boolean b() {
        return this.f;
    }

    public boolean c() {
        return this.g;
    }

    public float d() {
        return this.h;
    }

    public float e() {
        return this.i;
    }

    @Override // mctech.modules.config.ModuleConfig
    @NotNull
    public l tier() {
        return this.d;
    }

    @Override // mctech.modules.config.ModuleConfig
    @NotNull
    public MapCodec<? extends ModuleConfig> codec() {
        return MCTechCodecs.SOUL_REAPER.get();
    }

    @Override // mctech.modules.config.ModuleConfig
    @NotNull
    public ModuleConfigJsonSerializer<?> getJsonSerializer() {
        return c;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/j$a.class */
    public static class a implements ModuleConfigJsonSerializer<j> {
        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j fromJson(@Nonnull JsonElement jsonElement) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            return new j(h.a().a(ResourceLocation.parse(asJsonObject.get("tier").getAsString())), asJsonObject.get("eggDropChance").getAsFloat(), asJsonObject.get("includeHostile").getAsBoolean(), asJsonObject.get("includePlayer").getAsBoolean(), asJsonObject.get("questMobEggDropChance").getAsFloat(), asJsonObject.get("questBossEggDropChance").getAsFloat());
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public JsonElement toJson(@Nonnull j jVar) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("tier", jVar.tier().d().toString());
            jsonObject.addProperty("eggDropChance", Float.valueOf(jVar.e));
            jsonObject.addProperty("includeHostile", Boolean.valueOf(jVar.f));
            jsonObject.addProperty("includePlayer", Boolean.valueOf(jVar.g));
            jsonObject.addProperty("questMobEggDropChance", Float.valueOf(jVar.h));
            jsonObject.addProperty("questBossEggDropChance", Float.valueOf(jVar.i));
            return jsonObject;
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public Class<j> getTypeClass() {
            return j.class;
        }
    }
}
