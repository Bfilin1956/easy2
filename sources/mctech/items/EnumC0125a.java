package mctech.items;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.modules.config.BasicModularItemTierConfig;
import mctech.modules.config.ModularItemTierConfig;
import mctech.modules.config.ModularItemTierConfigJsonSerializer;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.items.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/a.class */
public enum EnumC0125a implements mctech.items.base.l {
    ARMOR_COMPOSITE(2, 1, new String[]{"energy_crystal", "lapatron_crystal", "glowtronic_crystal"}, new String[]{"jetpack"}, new String[]{"batpack", "lappack", "quantum_pack"}),
    ARMOR_NANO(5, 1, new String[]{"uesc"}, new String[]{"advanced_jetpack"}, new String[]{"nano_energy_lappack"}),
    ARMOR_QUANTUM(7, 2, new String[]{"pesd"}, new String[]{"gravitation_jetpack"}, new String[]{"quantum_energy_lappack"}),
    ARMOR_SINGULAR(9, 2, new String[]{"quantum_accumulator"}, new String[]{"rocket_gravitation_jetpack"}, new String[]{"singularity_energy_lappack"}),
    ARMOR_ADMIN(12, 3, new String[]{"quantum_accumulator_big"}, new String[0], new String[]{"rubidium_energy_lappack"});


    @Nonnull
    private final ResourceLocation h = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, name().toLowerCase(Locale.ROOT));
    private final List<ResourceLocation> k;
    public static final MapCodec<C0021a> f;
    public static final b g;

    static {
        ArrayList arrayList = new ArrayList();
        for (EnumC0125a enumC0125a : values()) {
            enumC0125a.k.addAll(arrayList);
            arrayList.addAll(enumC0125a.k);
        }
        f = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(Codec.INT.fieldOf("flyEnergyCost").forGetter((v0) -> {
                return v0.a();
            }), Codec.INT.fieldOf("damageEnergyCost").forGetter((v0) -> {
                return v0.b();
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
            })).apply(instance, (num, num2, num3, num4, num5, num6, set) -> {
                return new C0021a(new BasicModularItemTierConfig(num3.intValue(), num4.intValue(), num5.intValue(), num6.intValue(), set), num.intValue(), num2.intValue());
            });
        });
        g = new b();
    }

    EnumC0125a(@Nullable int i, @Nullable int i2, @Nullable String[] strArr, String[] strArr2, String[] strArr3) {
        Set setUnmodifiableSet;
        int iOrdinal = ordinal() + 1;
        HashSet hashSet = new HashSet();
        if (strArr != null) {
            for (String str : strArr) {
                hashSet.add(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str));
            }
        }
        mctech.modules.h hVarA = mctech.modules.h.a();
        hashSet.addAll(hVarA.a(EnumC0125a.class).stream().flatMap(enumC0125a -> {
            return hVarA.a(enumC0125a).getValidBatteryItems().stream();
        }).toList());
        if (hashSet.isEmpty()) {
            setUnmodifiableSet = Collections.emptySet();
        } else {
            setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        this.k = new ArrayList();
        if (strArr3 != null) {
            for (String str2 : strArr3) {
                this.k.add(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str2));
            }
        }
        hVarA.a(this, new C0021a(new BasicModularItemTierConfig(iOrdinal, ((int) Math.pow(iOrdinal, 2.0d)) * mctech.q.c.c, i + 1, i2, setUnmodifiableSet), 100, mctech.blockentities.b.k.i));
    }

    @Override // mctech.items.base.l
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0021a f() {
        return (C0021a) mctech.modules.h.a().a(this);
    }

    @Override // mctech.items.base.l
    @NotNull
    public ModularItemTierConfigJsonSerializer<?> b() {
        return g;
    }

    public boolean a(ItemStack itemStack) {
        return this.k.contains(BuiltInRegistries.ITEM.getKey(itemStack.getItem()));
    }

    public List<ResourceLocation> c() {
        return this.k;
    }

    @Override // mctech.items.base.l
    @NotNull
    public ResourceLocation d() {
        return this.h;
    }

    public boolean a(@NotNull mctech.modules.e<?> eVar) {
        mctech.items.base.l lVarTier = mctech.modules.h.a().a(eVar).tier();
        return (lVarTier instanceof EnumC0125a) && compareTo((EnumC0125a) lVarTier) >= 0;
    }

    /* JADX INFO: renamed from: mctech.items.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/a$a.class */
    public static class C0021a extends BasicModularItemTierConfig {
        private final int a;
        private final int b;

        public C0021a(@NotNull BasicModularItemTierConfig basicModularItemTierConfig, int i, int i2) {
            super(new BasicModularItemTierConfig(basicModularItemTierConfig.getElectricTier(), basicModularItemTierConfig.getElectricTransferLimit(), Mth.clamp(basicModularItemTierConfig.getMaxModuleCount(), 0, 12), Mth.clamp(basicModularItemTierConfig.getMaxBatteryCount(), 0, 3), basicModularItemTierConfig.getValidBatteryItems()));
            this.a = i;
            this.b = i2;
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return 1;
        }

        @Override // mctech.modules.config.BasicModularItemTierConfig, mctech.modules.config.ModularItemTierConfig
        @NotNull
        public MapCodec<? extends ModularItemTierConfig> codec() {
            return EnumC0125a.f;
        }

        @Override // mctech.modules.config.BasicModularItemTierConfig, mctech.modules.config.ModularItemTierConfig
        @NotNull
        public ModularItemTierConfigJsonSerializer<?> getJsonSerializer() {
            return EnumC0125a.g;
        }
    }

    /* JADX INFO: renamed from: mctech.items.a$b */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/a$b.class */
    public static class b implements ModularItemTierConfigJsonSerializer<C0021a> {
        @Override // mctech.modules.config.ModularItemTierConfigJsonSerializer
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0021a fromJson(@NotNull JsonElement jsonElement) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            return new C0021a(BasicModularItemTierConfig.JSON_SERIALIZER.fromJson(jsonElement), asJsonObject.get("flyEnergyCost").getAsInt(), asJsonObject.get("damageEnergyCost").getAsInt());
        }

        @Override // mctech.modules.config.ModularItemTierConfigJsonSerializer
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public JsonElement toJson(@NotNull C0021a c0021a) {
            JsonObject json = BasicModularItemTierConfig.JSON_SERIALIZER.toJson((BasicModularItemTierConfig) c0021a);
            json.addProperty("flyEnergyCost", Integer.valueOf(c0021a.a()));
            json.addProperty("damageEnergyCost", Integer.valueOf(c0021a.b()));
            return json;
        }

        @Override // mctech.modules.config.ModularItemTierConfigJsonSerializer
        @NotNull
        public Class<C0021a> getTypeClass() {
            return C0021a.class;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // mctech.items.base.l
    public MachineTier e() throws MatchException {
        switch (this) {
            case ARMOR_COMPOSITE:
                return MachineTier.T4;
            case ARMOR_NANO:
                return MachineTier.T5;
            case ARMOR_QUANTUM:
                return MachineTier.T6;
            case ARMOR_SINGULAR:
                return MachineTier.T7;
            case ARMOR_ADMIN:
                return MachineTier.T8;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }
}
