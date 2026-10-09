package mctech.items;

import appeng.api.stacks.AEKeyType;
import appeng.api.storage.cells.IBasicCellItem;
import appeng.items.storage.BasicStorageCell;
import appeng.items.tools.powered.PortableCellItem;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.blockentities.c.C0074u;
import mctech.init.MCTechTierConfigs;
import mctech.modules.config.BasicModularItemTierConfig;
import mctech.modules.config.ModularItemTierConfig;
import mctech.modules.config.ModularItemTierConfigJsonSerializer;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f.class */
public enum f implements mctech.items.base.l {
    DIGGER_COMPOSITE(3, 50, 0, 1, 0, "energy_crystal"),
    DIGGER_NANO(5, 500, 2, 1, C0074u.o, "lapatron_crystal"),
    DIGGER_QUANTUM(6, 3000, 3, 2, 65536, "glowtronic_crystal"),
    DIGGER_SINGULAR(7, 5000, 4, 2, 262144, "uesc"),
    DIGGER_ADMIN(8, 5250, 4, 3, 262144, null);

    private final ResourceLocation k = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, name().toLowerCase(Locale.ROOT));
    public static final MapCodec<a> f = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("energyCost").forGetter((v0) -> {
            return v0.a();
        }), Codec.INT.fieldOf("maxAECellCount").forGetter((v0) -> {
            return v0.b();
        }), Codec.INT.fieldOf("maxAECellBytes").forGetter((v0) -> {
            return v0.c();
        }), Codec.INT.fieldOf("electricTier").forGetter((v0) -> {
            return v0.getElectricTier();
        }), Codec.INT.fieldOf("electricTransferLimit").forGetter((v0) -> {
            return v0.getElectricTransferLimit();
        }), Codec.INT.fieldOf("maxModuleCount").forGetter((v0) -> {
            return v0.getMaxModuleCount();
        }), Codec.INT.fieldOf("maxBatteryCount").forGetter((v0) -> {
            return v0.getMaxBatteryCount();
        }), mctech.f.c.a(ResourceLocation.CODEC).fieldOf("validBatteryItems").forGetter((v0) -> {
            return v0.getValidBatteryItems();
        })).apply(instance, (num, num2, num3, num4, num5, num6, num7, set) -> {
            return new a(new BasicModularItemTierConfig(num4.intValue(), num5.intValue(), num6.intValue(), num7.intValue(), set), num.intValue(), num2.intValue(), num3.intValue());
        });
    });
    public static final StreamCodec<? extends RegistryFriendlyByteBuf, a> g = mctech.f.d.a(ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.c();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.c();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.getElectricTier();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.getElectricTransferLimit();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.getMaxModuleCount();
    }, ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.getMaxBatteryCount();
    }, ByteBufCodecs.collection(HashSet::new, ResourceLocation.STREAM_CODEC, Integer.MAX_VALUE), (v0) -> {
        return v0.getValidBatteryItems();
    }, (num, num2, num3, num4, num5, num6, num7, set) -> {
        return new a(new BasicModularItemTierConfig(num4.intValue(), num5.intValue(), num6.intValue(), num7.intValue(), set), num.intValue(), num2.intValue(), num3.intValue());
    });
    public static final b h = new b();

    f(int i, int i2, int i3, @Nullable int i4, int i5, String str) {
        Set setUnmodifiableSet;
        int iOrdinal = ordinal() + 1;
        HashSet hashSet = new HashSet();
        if (str != null) {
            hashSet.add(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str));
        }
        mctech.modules.h hVarA = mctech.modules.h.a();
        hashSet.addAll(hVarA.a(f.class).stream().flatMap(fVar -> {
            return hVarA.a(fVar).getValidBatteryItems().stream();
        }).toList());
        if (hashSet.isEmpty()) {
            setUnmodifiableSet = Collections.emptySet();
        } else {
            setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        hVarA.a(this, new a(new BasicModularItemTierConfig(iOrdinal, ((int) Math.pow(iOrdinal, 2.0d)) * mctech.q.c.c, i, i4, setUnmodifiableSet), i2, i3, i5));
    }

    public boolean a(@Nonnull ItemStack itemStack) {
        if ((itemStack.getItem() instanceof PortableCellItem) || (itemStack.getItem() instanceof BasicStorageCell)) {
            IBasicCellItem item = itemStack.getItem();
            a aVarF = f();
            return (item.getKeyType() == AEKeyType.items() && item.getBytes(itemStack) <= aVarF.c) || aVarF.c == -1;
        }
        return false;
    }

    @Override // mctech.items.base.l
    @Nonnull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a f() {
        return (a) mctech.modules.h.a().a(this);
    }

    @Override // mctech.items.base.l
    @Nonnull
    public ResourceLocation d() {
        return this.k;
    }

    @Override // mctech.items.base.l
    @Nonnull
    public ModularItemTierConfigJsonSerializer<?> b() {
        return h;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f$a.class */
    public static class a extends BasicModularItemTierConfig {
        private final int a;
        private final int b;
        private final int c;

        public a(@Nonnull BasicModularItemTierConfig basicModularItemTierConfig, int i, int i2, int i3) {
            super(basicModularItemTierConfig);
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        @Override // mctech.modules.config.BasicModularItemTierConfig, mctech.modules.config.ModularItemTierConfig
        @NotNull
        public ModularItemTierConfigJsonSerializer<?> getJsonSerializer() {
            return f.h;
        }

        @Override // mctech.modules.config.BasicModularItemTierConfig, mctech.modules.config.ModularItemTierConfig
        @Nonnull
        public MapCodec<? extends ModularItemTierConfig> codec() {
            return MCTechTierConfigs.DIGGER.get();
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f$b.class */
    public static class b implements ModularItemTierConfigJsonSerializer<a> {
        @Override // mctech.modules.config.ModularItemTierConfigJsonSerializer
        @Nonnull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a fromJson(@Nonnull JsonElement jsonElement) {
            BasicModularItemTierConfig basicModularItemTierConfigFromJson = BasicModularItemTierConfig.JSON_SERIALIZER.fromJson(jsonElement);
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            return new a(basicModularItemTierConfigFromJson, asJsonObject.get("energyCost").getAsInt(), asJsonObject.get("maxAECellCount").getAsInt(), asJsonObject.get("maxAECellBytes").getAsInt());
        }

        @Override // mctech.modules.config.ModularItemTierConfigJsonSerializer
        @Nonnull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public JsonElement toJson(@Nonnull a aVar) {
            JsonObject json = BasicModularItemTierConfig.JSON_SERIALIZER.toJson((BasicModularItemTierConfig) aVar);
            json.addProperty("energyCost", Integer.valueOf(aVar.a()));
            json.addProperty("maxAECellCount", Integer.valueOf(aVar.b()));
            json.addProperty("maxAECellBytes", Integer.valueOf(aVar.c()));
            return json;
        }

        @Override // mctech.modules.config.ModularItemTierConfigJsonSerializer
        @Nonnull
        public Class<a> getTypeClass() {
            return a.class;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // mctech.items.base.l
    public MachineTier e() throws MatchException {
        switch (this) {
            case DIGGER_COMPOSITE:
                return MachineTier.T4;
            case DIGGER_NANO:
                return MachineTier.T5;
            case DIGGER_QUANTUM:
                return MachineTier.T6;
            case DIGGER_SINGULAR:
                return MachineTier.T7;
            case DIGGER_ADMIN:
                return MachineTier.T8;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }
}
