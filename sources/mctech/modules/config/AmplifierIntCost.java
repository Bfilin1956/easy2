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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/AmplifierIntCost.class */
public final class AmplifierIntCost extends Record implements EnergyCostConfig {

    @NotNull
    private final l tier;
    private final int energyCost;
    private final int amplifier;
    public static final MapCodec<AmplifierIntCost> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(l.i.fieldOf("tier").forGetter((v0) -> {
            return v0.tier();
        }), Codec.INT.fieldOf("energyCost").forGetter((v0) -> {
            return v0.energyCost();
        }), Codec.INT.fieldOf("amplifier").forGetter((v0) -> {
            return v0.amplifier();
        })).apply(instance, (v1, v2, v3) -> {
            return new AmplifierIntCost(v1, v2, v3);
        });
    });
    public static final StreamCodec<? extends RegistryFriendlyByteBuf, AmplifierIntCost> STREAM_CODEC = StreamCodec.composite(l.j, (v0) -> {
        return v0.tier();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.energyCost();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.amplifier();
    }, (v1, v2, v3) -> {
        return new AmplifierIntCost(v1, v2, v3);
    });
    public static final JsonSerializer JSON_SERIALIZER = new JsonSerializer();

    public AmplifierIntCost(@NotNull l lVar, int i, int i2) {
        this.tier = lVar;
        this.energyCost = i;
        this.amplifier = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, AmplifierIntCost.class), AmplifierIntCost.class, "tier;energyCost;amplifier", "FIELD:Lmctech/modules/config/AmplifierIntCost;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/AmplifierIntCost;->energyCost:I", "FIELD:Lmctech/modules/config/AmplifierIntCost;->amplifier:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, AmplifierIntCost.class), AmplifierIntCost.class, "tier;energyCost;amplifier", "FIELD:Lmctech/modules/config/AmplifierIntCost;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/AmplifierIntCost;->energyCost:I", "FIELD:Lmctech/modules/config/AmplifierIntCost;->amplifier:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, AmplifierIntCost.class, Object.class), AmplifierIntCost.class, "tier;energyCost;amplifier", "FIELD:Lmctech/modules/config/AmplifierIntCost;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/AmplifierIntCost;->energyCost:I", "FIELD:Lmctech/modules/config/AmplifierIntCost;->amplifier:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Override // mctech.modules.config.ModuleConfig
    @NotNull
    public l tier() {
        return this.tier;
    }

    public int energyCost() {
        return this.energyCost;
    }

    public int amplifier() {
        return this.amplifier;
    }

    @Override // mctech.modules.config.EnergyCostConfig
    public int getEnergyCost() {
        return this.energyCost;
    }

    @Override // mctech.modules.config.ModuleConfig
    @NotNull
    public ModuleConfigJsonSerializer<?> getJsonSerializer() {
        return JSON_SERIALIZER;
    }

    @Override // mctech.modules.config.ModuleConfig
    @NotNull
    public MapCodec<? extends ModuleConfig> codec() {
        return MCTechModules.AMPLIFIER_INT_COST.get();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/AmplifierIntCost$JsonSerializer.class */
    public static class JsonSerializer implements ModuleConfigJsonSerializer<AmplifierIntCost> {
        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public AmplifierIntCost fromJson(@Nonnull JsonElement jsonElement) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            return new AmplifierIntCost(h.a().a(ResourceLocation.parse(asJsonObject.get("tier").getAsString())), asJsonObject.get("energyCost").getAsInt(), asJsonObject.get("amplifier").getAsInt());
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public JsonElement toJson(@Nonnull AmplifierIntCost amplifierIntCost) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("tier", amplifierIntCost.tier().d().toString());
            jsonObject.addProperty("energyCost", Integer.valueOf(amplifierIntCost.getEnergyCost()));
            jsonObject.addProperty("amplifier", Integer.valueOf(amplifierIntCost.amplifier()));
            return jsonObject;
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public Class<AmplifierIntCost> getTypeClass() {
            return AmplifierIntCost.class;
        }
    }
}
