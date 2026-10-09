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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/EnergyCost.class */
public final class EnergyCost extends Record implements EnergyCostConfig {
    private final l tier;
    private final int energyCost;
    public static final MapCodec<EnergyCost> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(l.i.fieldOf("tier").forGetter((v0) -> {
            return v0.tier();
        }), Codec.INT.fieldOf("energyCost").forGetter((v0) -> {
            return v0.energyCost();
        })).apply(instance, (v1, v2) -> {
            return new EnergyCost(v1, v2);
        });
    });
    public static final StreamCodec<? extends RegistryFriendlyByteBuf, EnergyCost> STREAM_CODEC = StreamCodec.composite(l.j, (v0) -> {
        return v0.tier();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.energyCost();
    }, (v1, v2) -> {
        return new EnergyCost(v1, v2);
    });
    public static final JsonSerializer JSON_SERIALIZER = new JsonSerializer();

    public EnergyCost(l lVar, int i) {
        this.tier = lVar;
        this.energyCost = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, EnergyCost.class), EnergyCost.class, "tier;energyCost", "FIELD:Lmctech/modules/config/EnergyCost;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/EnergyCost;->energyCost:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, EnergyCost.class), EnergyCost.class, "tier;energyCost", "FIELD:Lmctech/modules/config/EnergyCost;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/EnergyCost;->energyCost:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, EnergyCost.class, Object.class), EnergyCost.class, "tier;energyCost", "FIELD:Lmctech/modules/config/EnergyCost;->tier:Lmctech/items/base/l;", "FIELD:Lmctech/modules/config/EnergyCost;->energyCost:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int energyCost() {
        return this.energyCost;
    }

    @Override // mctech.modules.config.EnergyCostConfig
    public int getEnergyCost() {
        return this.energyCost;
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
        return MCTechModules.ENERGY_COST.get();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/EnergyCost$JsonSerializer.class */
    public static class JsonSerializer implements ModuleConfigJsonSerializer<EnergyCost> {
        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public EnergyCost fromJson(@Nonnull JsonElement jsonElement) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            return new EnergyCost(h.a().a(ResourceLocation.parse(asJsonObject.get("tier").getAsString())), t.a(asJsonObject, "energyCost", 0));
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public JsonElement toJson(@Nonnull EnergyCost energyCost) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("tier", energyCost.tier().d().toString());
            jsonObject.addProperty("energyCost", Integer.valueOf(energyCost.getEnergyCost()));
            return jsonObject;
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public Class<EnergyCost> getTypeClass() {
            return EnergyCost.class;
        }
    }
}
