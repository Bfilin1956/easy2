package mctech.modules.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import javax.annotation.Nonnull;
import mctech.init.MCTechModules;
import mctech.items.base.l;
import mctech.modules.h;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/Multiplier.class */
public final class Multiplier extends Record implements ModuleConfig {

    @Nonnull
    private final l tier;
    private final float multiplier;
    public static final MapCodec<Multiplier> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(l.i.fieldOf("tier").forGetter((v0) -> {
            return v0.tier();
        }), Codec.FLOAT.fieldOf("multiplier").forGetter((v0) -> {
            return v0.multiplier();
        })).apply(instance, (v1, v2) -> {
            return new Multiplier(v1, v2);
        });
    });
    public static final StreamCodec<? extends RegistryFriendlyByteBuf, Multiplier> STREAM_CODEC = StreamCodec.composite(l.j, (v0) -> {
        return v0.tier();
    }, ByteBufCodecs.FLOAT, (v0) -> {
        return v0.multiplier();
    }, (v1, v2) -> {
        return new Multiplier(v1, v2);
    });
    public static final JsonSerializer JSON_SERIALIZER = new JsonSerializer();

    public Multiplier(@Nonnull l lVar, float f) {
        this.tier = lVar;
        this.multiplier = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Multiplier.class), Multiplier.class, "tier;multiplier", "FIELD:Lmctech/modules/config/Multiplier;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/Multiplier;->multiplier:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Multiplier.class), Multiplier.class, "tier;multiplier", "FIELD:Lmctech/modules/config/Multiplier;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/Multiplier;->multiplier:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Multiplier.class, Object.class), Multiplier.class, "tier;multiplier", "FIELD:Lmctech/modules/config/Multiplier;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/Multiplier;->multiplier:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public float multiplier() {
        return this.multiplier;
    }

    @Override // mctech.modules.config.ModuleConfig
    @Nonnull
    public l tier() {
        return this.tier;
    }

    @Override // mctech.modules.config.ModuleConfig
    @NotNull
    public ModuleConfigJsonSerializer<?> getJsonSerializer() {
        return JSON_SERIALIZER;
    }

    @Override // mctech.modules.config.ModuleConfig
    @NotNull
    public MapCodec<? extends ModuleConfig> codec() {
        return MCTechModules.MULTIPLIER.get();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/Multiplier$JsonSerializer.class */
    public static class JsonSerializer implements ModuleConfigJsonSerializer<Multiplier> {
        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public Multiplier fromJson(@Nonnull JsonElement jsonElement) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            return new Multiplier(h.a().a(ResourceLocation.parse(asJsonObject.get("tier").getAsString())), asJsonObject.get("multiplier").getAsFloat());
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public JsonElement toJson(@Nonnull Multiplier multiplier) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("tier", multiplier.tier().d().toString());
            jsonObject.addProperty("multiplier", Float.valueOf(multiplier.multiplier()));
            return jsonObject;
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public Class<Multiplier> getTypeClass() {
            return Multiplier.class;
        }
    }
}
