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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/MultiplierCost.class */
public final class MultiplierCost extends Record implements EnergyCostConfig {

    @Nonnull
    private final l tier;
    private final int energyCost;
    private final float multiplier;
    public static final MapCodec<MultiplierCost> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(l.i.fieldOf("tier").forGetter((v0) -> {
            return v0.tier();
        }), Codec.INT.fieldOf("energyCost").forGetter((v0) -> {
            return v0.energyCost();
        }), Codec.FLOAT.fieldOf("multiplier").forGetter((v0) -> {
            return v0.multiplier();
        })).apply(instance, (v1, v2, v3) -> {
            return new MultiplierCost(v1, v2, v3);
        });
    });
    public static final StreamCodec<? extends RegistryFriendlyByteBuf, MultiplierCost> STREAM_CODEC = StreamCodec.composite(l.j, (v0) -> {
        return v0.tier();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.energyCost();
    }, ByteBufCodecs.FLOAT, (v0) -> {
        return v0.multiplier();
    }, (v1, v2, v3) -> {
        return new MultiplierCost(v1, v2, v3);
    });
    public static final JsonSerializer JSON_SERIALIZER = new JsonSerializer();

    public MultiplierCost(@Nonnull l lVar, int i, float f) {
        this.tier = lVar;
        this.energyCost = i;
        this.multiplier = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, MultiplierCost.class), MultiplierCost.class, "tier;energyCost;multiplier", "FIELD:Lmctech/modules/config/MultiplierCost;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/MultiplierCost;->energyCost:I", "FIELD:Lmctech/modules/config/MultiplierCost;->multiplier:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, MultiplierCost.class), MultiplierCost.class, "tier;energyCost;multiplier", "FIELD:Lmctech/modules/config/MultiplierCost;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/MultiplierCost;->energyCost:I", "FIELD:Lmctech/modules/config/MultiplierCost;->multiplier:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, MultiplierCost.class, Object.class), MultiplierCost.class, "tier;energyCost;multiplier", "FIELD:Lmctech/modules/config/MultiplierCost;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/MultiplierCost;->energyCost:I", "FIELD:Lmctech/modules/config/MultiplierCost;->multiplier:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Override // mctech.modules.config.ModuleConfig
    @Nonnull
    public l tier() {
        return this.tier;
    }

    public int energyCost() {
        return this.energyCost;
    }

    public float multiplier() {
        return this.multiplier;
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
        return MCTechModules.MULTIPLIER_COST.get();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/MultiplierCost$JsonSerializer.class */
    public static class JsonSerializer implements ModuleConfigJsonSerializer<MultiplierCost> {
        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public MultiplierCost fromJson(@Nonnull JsonElement jsonElement) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            return new MultiplierCost(h.a().a(ResourceLocation.parse(asJsonObject.get("tier").getAsString())), asJsonObject.get("energyCost").getAsInt(), asJsonObject.get("multiplier").getAsFloat());
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public JsonElement toJson(@Nonnull MultiplierCost multiplierCost) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("tier", multiplierCost.tier().d().toString());
            jsonObject.addProperty("energyCost", Integer.valueOf(multiplierCost.getEnergyCost()));
            jsonObject.addProperty("multiplier", Float.valueOf(multiplierCost.multiplier()));
            return jsonObject;
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public Class<MultiplierCost> getTypeClass() {
            return MultiplierCost.class;
        }
    }
}
