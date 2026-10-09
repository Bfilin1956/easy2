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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/AmplifierInt.class */
public final class AmplifierInt extends Record implements ModuleConfig {
    private final l tier;
    private final int amplifier;
    public static final MapCodec<AmplifierInt> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(l.i.fieldOf("tier").forGetter((v0) -> {
            return v0.tier();
        }), Codec.INT.fieldOf("amplifier").forGetter((v0) -> {
            return v0.amplifier();
        })).apply(instance, (v1, v2) -> {
            return new AmplifierInt(v1, v2);
        });
    });
    public static final StreamCodec<? extends RegistryFriendlyByteBuf, AmplifierInt> STREAM_CODEC = StreamCodec.composite(l.j, (v0) -> {
        return v0.tier();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.amplifier();
    }, (v1, v2) -> {
        return new AmplifierInt(v1, v2);
    });
    public static final JsonSerializer JSON_SERIALIZER = new JsonSerializer();

    public AmplifierInt(l lVar, int i) {
        this.tier = lVar;
        this.amplifier = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, AmplifierInt.class), AmplifierInt.class, "tier;amplifier", "FIELD:Lmctech/modules/config/AmplifierInt;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/AmplifierInt;->amplifier:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, AmplifierInt.class), AmplifierInt.class, "tier;amplifier", "FIELD:Lmctech/modules/config/AmplifierInt;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/AmplifierInt;->amplifier:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, AmplifierInt.class, Object.class), AmplifierInt.class, "tier;amplifier", "FIELD:Lmctech/modules/config/AmplifierInt;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/AmplifierInt;->amplifier:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int amplifier() {
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
        return MCTechModules.AMPLIFIER_INT.get();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/AmplifierInt$JsonSerializer.class */
    public static class JsonSerializer implements ModuleConfigJsonSerializer<AmplifierInt> {
        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public AmplifierInt fromJson(@Nonnull JsonElement jsonElement) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            return new AmplifierInt(h.a().a(ResourceLocation.parse(asJsonObject.get("tier").getAsString())), asJsonObject.get("amplifier").getAsInt());
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public JsonElement toJson(@Nonnull AmplifierInt amplifierInt) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("tier", amplifierInt.tier().d().toString());
            jsonObject.addProperty("amplifier", Integer.valueOf(amplifierInt.amplifier()));
            return jsonObject;
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public Class<AmplifierInt> getTypeClass() {
            return AmplifierInt.class;
        }
    }
}
