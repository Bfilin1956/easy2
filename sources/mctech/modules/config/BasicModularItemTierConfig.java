package mctech.modules.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nonnull;
import mctech.f.c;
import mctech.init.MCTechTierConfigs;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/BasicModularItemTierConfig.class */
public class BasicModularItemTierConfig implements ModularItemTierConfig {
    private final int electricTier;
    private final int electricTransferLimit;
    private final int maxModuleCount;
    private final int maxBatteryCount;

    @Nonnull
    private final Set<ResourceLocation> validBatteryItems;
    public static final MapCodec<BasicModularItemTierConfig> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("electricTier").forGetter((v0) -> {
            return v0.getElectricTier();
        }), Codec.INT.fieldOf("electricTransferLimit").forGetter((v0) -> {
            return v0.getElectricTransferLimit();
        }), Codec.INT.fieldOf("maxModuleCount").forGetter((v0) -> {
            return v0.getMaxModuleCount();
        }), Codec.INT.fieldOf("maxBatteryCount").forGetter((v0) -> {
            return v0.getMaxBatteryCount();
        }), c.a(ResourceLocation.CODEC).fieldOf("validBatteryItems").forGetter((v0) -> {
            return v0.getValidBatteryItems();
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new BasicModularItemTierConfig(v1, v2, v3, v4, v5);
        });
    });
    public static final StreamCodec<? extends RegistryFriendlyByteBuf, BasicModularItemTierConfig> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.getElectricTier();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.getElectricTransferLimit();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.getMaxModuleCount();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.getMaxBatteryCount();
    }, ByteBufCodecs.collection(HashSet::new, ResourceLocation.STREAM_CODEC, Integer.MAX_VALUE), (v0) -> {
        return v0.getValidBatteryItems();
    }, (v1, v2, v3, v4, v5) -> {
        return new BasicModularItemTierConfig(v1, v2, v3, v4, v5);
    });
    public static final JsonSerializer JSON_SERIALIZER = new JsonSerializer();

    public BasicModularItemTierConfig(int i, int i2, int i3, int i4, @Nonnull Set<ResourceLocation> set) {
        this.electricTier = i;
        this.electricTransferLimit = i2;
        this.maxModuleCount = i3;
        this.maxBatteryCount = i4;
        this.validBatteryItems = set;
    }

    public BasicModularItemTierConfig(@Nonnull BasicModularItemTierConfig basicModularItemTierConfig) {
        this(basicModularItemTierConfig.electricTier, basicModularItemTierConfig.electricTransferLimit, basicModularItemTierConfig.maxModuleCount, basicModularItemTierConfig.maxBatteryCount, basicModularItemTierConfig.validBatteryItems);
    }

    @Override // mctech.modules.config.ModularItemTierConfig
    public int getElectricTier() {
        return this.electricTier;
    }

    @Override // mctech.modules.config.ModularItemTierConfig
    public int getElectricTransferLimit() {
        return this.electricTransferLimit;
    }

    @Override // mctech.modules.config.ModularItemTierConfig
    public int getMaxModuleCount() {
        return this.maxModuleCount;
    }

    @Override // mctech.modules.config.ModularItemTierConfig
    public int getMaxBatteryCount() {
        return this.maxBatteryCount;
    }

    @Override // mctech.modules.config.ModularItemTierConfig
    @Nonnull
    public Set<ResourceLocation> getValidBatteryItems() {
        return this.validBatteryItems;
    }

    @Override // mctech.modules.config.ModularItemTierConfig
    @NotNull
    public ModularItemTierConfigJsonSerializer<?> getJsonSerializer() {
        return JSON_SERIALIZER;
    }

    @Override // mctech.modules.config.ModularItemTierConfig
    @NotNull
    public MapCodec<? extends ModularItemTierConfig> codec() {
        return MCTechTierConfigs.BASIC.get();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/BasicModularItemTierConfig$JsonSerializer.class */
    public static class JsonSerializer implements ModularItemTierConfigJsonSerializer<BasicModularItemTierConfig> {
        @Override // mctech.modules.config.ModularItemTierConfigJsonSerializer
        @Nonnull
        public BasicModularItemTierConfig fromJson(@Nonnull JsonElement jsonElement) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            HashSet hashSet = new HashSet();
            Iterator it = asJsonObject.get("validBatteryItems").getAsJsonArray().iterator();
            while (it.hasNext()) {
                hashSet.add(ResourceLocation.parse(((JsonElement) it.next()).getAsString()));
            }
            return new BasicModularItemTierConfig(asJsonObject.get("electricTier").getAsInt(), asJsonObject.get("electricTransferLimit").getAsInt(), asJsonObject.get("maxModuleCount").getAsInt(), asJsonObject.get("maxBatteryCount").getAsInt(), hashSet);
        }

        @Override // mctech.modules.config.ModularItemTierConfigJsonSerializer
        @Nonnull
        public JsonObject toJson(@Nonnull BasicModularItemTierConfig basicModularItemTierConfig) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("electricTier", Integer.valueOf(basicModularItemTierConfig.electricTier));
            jsonObject.addProperty("electricTransferLimit", Integer.valueOf(basicModularItemTierConfig.electricTransferLimit));
            jsonObject.addProperty("maxModuleCount", Integer.valueOf(basicModularItemTierConfig.maxModuleCount));
            jsonObject.addProperty("maxBatteryCount", Integer.valueOf(basicModularItemTierConfig.maxBatteryCount));
            JsonArray jsonArray = new JsonArray();
            Iterator<ResourceLocation> it = basicModularItemTierConfig.validBatteryItems.iterator();
            while (it.hasNext()) {
                jsonArray.add(it.next().toString());
            }
            jsonObject.add("validBatteryItems", jsonArray);
            return jsonObject;
        }

        @Override // mctech.modules.config.ModularItemTierConfigJsonSerializer
        @Nonnull
        public Class<BasicModularItemTierConfig> getTypeClass() {
            return BasicModularItemTierConfig.class;
        }
    }
}
