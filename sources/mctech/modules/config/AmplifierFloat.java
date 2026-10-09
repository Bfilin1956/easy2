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
import mctech.utils.t;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/AmplifierFloat.class */
public final class AmplifierFloat extends Record implements ModuleConfig {
    private final l tier;
    private final float amplifier;
    public static final MapCodec<AmplifierFloat> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(l.i.fieldOf("tier").forGetter((v0) -> {
            return v0.tier();
        }), Codec.FLOAT.fieldOf("amplifier").forGetter((v0) -> {
            return v0.amplifier();
        })).apply(instance, (v1, v2) -> {
            return new AmplifierFloat(v1, v2);
        });
    });
    public static final StreamCodec<? extends RegistryFriendlyByteBuf, AmplifierFloat> STREAM_CODEC = StreamCodec.composite(l.j, (v0) -> {
        return v0.tier();
    }, ByteBufCodecs.FLOAT, (v0) -> {
        return v0.amplifier();
    }, (v1, v2) -> {
        return new AmplifierFloat(v1, v2);
    });
    public static final JsonSerializer JSON_SERIALIZER = new JsonSerializer();

    public AmplifierFloat(l lVar, float f) {
        this.tier = lVar;
        this.amplifier = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, AmplifierFloat.class), AmplifierFloat.class, "tier;amplifier", "FIELD:Lmctech/modules/config/AmplifierFloat;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/AmplifierFloat;->amplifier:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, AmplifierFloat.class), AmplifierFloat.class, "tier;amplifier", "FIELD:Lmctech/modules/config/AmplifierFloat;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/AmplifierFloat;->amplifier:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, AmplifierFloat.class, Object.class), AmplifierFloat.class, "tier;amplifier", "FIELD:Lmctech/modules/config/AmplifierFloat;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/AmplifierFloat;->amplifier:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public float amplifier() {
        return this.amplifier;
    }

    @Override // mctech.modules.config.ModuleConfig
    @NotNull
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
        return MCTechModules.AMPLIFIER_FLOAT.get();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/AmplifierFloat$JsonSerializer.class */
    public static class JsonSerializer implements ModuleConfigJsonSerializer<AmplifierFloat> {
        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public AmplifierFloat fromJson(@Nonnull JsonElement jsonElement) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            return new AmplifierFloat(h.a().a(ResourceLocation.parse(asJsonObject.get("tier").getAsString())), t.a(asJsonObject, "amplifier", 0.0f));
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public JsonElement toJson(@Nonnull AmplifierFloat amplifierFloat) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("tier", amplifierFloat.tier().d().toString());
            jsonObject.addProperty("amplifier", Float.valueOf(amplifierFloat.amplifier()));
            return jsonObject;
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public Class<AmplifierFloat> getTypeClass() {
            return AmplifierFloat.class;
        }
    }
}
