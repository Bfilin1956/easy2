package mctech.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import mctech.MCTech;
import mctech.modules.a;
import mctech.modules.b;
import mctech.modules.c;
import mctech.modules.config.AmplifierFloat;
import mctech.modules.config.AmplifierFloatCost;
import mctech.modules.config.AmplifierInt;
import mctech.modules.config.AmplifierIntCost;
import mctech.modules.config.EnergyCost;
import mctech.modules.config.ModuleConfig;
import mctech.modules.config.ModuleConfigJsonSerializer;
import mctech.modules.config.Multiplier;
import mctech.modules.config.MultiplierCost;
import mctech.modules.config.Tier;
import mctech.modules.d;
import mctech.modules.e;
import mctech.modules.i;
import mctech.modules.j;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryBuilder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechModules.class */
public class MCTechModules {
    private static final ResourceKey<Registry<MapCodec<? extends ModuleConfig>>> REGISTRY_KEY = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "modules"));
    public static final Registry<MapCodec<? extends ModuleConfig>> MODULES = new RegistryBuilder(REGISTRY_KEY).sync(true).maxId(15).defaultKey(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "module_empty")).create();
    private static final DeferredRegister<MapCodec<? extends ModuleConfig>> DEFERRED = DeferredRegister.create(MODULES, MCTech.MODID);
    public static final e<Multiplier> DAMAGE_ABSORB = newModule("damage_absorb", Multiplier.JSON_SERIALIZER, false);
    public static final e<Multiplier> THORNS = newModule("thorns", Multiplier.JSON_SERIALIZER, false);
    public static final e<AmplifierFloat> JUMP_BOOST = newModule("jump_boost", AmplifierFloat.JSON_SERIALIZER, false);
    public static final e<Multiplier> MOVEMENT_SPEED = newModule("movement_speed", Multiplier.JSON_SERIALIZER, false);
    public static final e<AmplifierFloatCost> HEALTH_BOOST = newModule("health_boost", AmplifierFloatCost.JSON_SERIALIZER, false);
    public static final e<AmplifierIntCost> REGENERATION = newModule("regeneration", AmplifierIntCost.JSON_SERIALIZER, true);
    public static final e<EnergyCost> ELYTRA = newModule("elytra", EnergyCost.JSON_SERIALIZER, true);
    public static final e<EnergyCost> JETPACK = newModule("jetpack", EnergyCost.JSON_SERIALIZER, true);
    public static final e<Tier> AUTO_FEEDER = newModule("auto_feeder", Tier.JSON_SERIALIZER, true);
    public static final e<EnergyCost> RADIATION_RESISTANCE = newModule("radiation_resistance", EnergyCost.JSON_SERIALIZER, true);
    public static final e<Tier> KNOCKBACK_RESISTANCE = newModule("knockback_resistance", Tier.JSON_SERIALIZER, true);
    public static final e<EnergyCost> XRAY_VISION = newModule("xray_vision", EnergyCost.JSON_SERIALIZER, true);
    public static final e<EnergyCost> CREATIVE_FLIGHT = newModule("creative_flight", EnergyCost.JSON_SERIALIZER, true);
    public static final e<EnergyCost> WATER_BREATHING = newModule("water_breathing", EnergyCost.JSON_SERIALIZER, true);
    public static final e<Tier> NIGHT_VISION = newModule("night_vision", Tier.JSON_SERIALIZER, true);
    public static final e<MultiplierCost> EFFICIENCY = newModule("efficiency", MultiplierCost.JSON_SERIALIZER, false);
    public static final e<EnergyCost> DEPTH = newModule("depth", EnergyCost.JSON_SERIALIZER, false);
    public static final e<EnergyCost> RADIUS = newModule("radius", EnergyCost.JSON_SERIALIZER, false);
    public static final e<MultiplierCost> FORTUNE = newModule("fortune", MultiplierCost.JSON_SERIALIZER, false, i -> {
        return i >= 4 ? i + 1 : i;
    });
    public static final e<Multiplier> ENERGY_SAVING = new b(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "energy_saving"), false);
    public static final e<EnergyCost> SILK_TOUCH = new i(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "silk_touch"), true);
    public static final e<EnergyCost> AUTO_MELT = newModule("auto_melt", EnergyCost.JSON_SERIALIZER, true);
    public static final e<EnergyCost> BEDROCK_ORE_DESTROYER = newModule("bedrock_ore_destroy", EnergyCost.JSON_SERIALIZER, true);
    public static final e<EnergyCost> HEAT_SAVING = newModule("heat_saving", EnergyCost.JSON_SERIALIZER, true);
    public static final e<Tier> KEEP = newModule("keep", Tier.JSON_SERIALIZER, true);
    public static final e<Multiplier> SHARPNESS = newModule("sharpness", Multiplier.JSON_SERIALIZER, true);
    public static final e<AmplifierInt> KNOCKBACK = new c();
    public static final e<AmplifierInt> FIRE_ASPECT = newModule("fire_aspect", AmplifierInt.JSON_SERIALIZER, true);
    public static final e<AmplifierInt> ICE_ASPECT = newModule("ice_aspect", AmplifierInt.JSON_SERIALIZER, true);
    public static final e<AmplifierInt> LOOTING = new d();
    public static final e<j> SOUL_REAPER = newModule("soul_reaper", j.c, true);
    public static final e<Multiplier> GENETIC_EXTRACTOR = newModule("genetic_extractor", Multiplier.JSON_SERIALIZER, true);
    public static final Supplier<MapCodec<AmplifierFloat>> AMPLIFIER_FLOAT = registry("amplifier_float", AmplifierFloat.CODEC);
    public static final Supplier<MapCodec<AmplifierFloatCost>> AMPLIFIER_FLOAT_COST = registry("amplifier_float_cost", AmplifierFloatCost.CODEC);
    public static final Supplier<MapCodec<AmplifierInt>> AMPLIFIER_INT = registry("amplifier_int", AmplifierInt.CODEC);
    public static final Supplier<MapCodec<AmplifierIntCost>> AMPLIFIER_INT_COST = registry("amplifier_int_cost", AmplifierIntCost.CODEC);
    public static final Supplier<MapCodec<EnergyCost>> ENERGY_COST = registry("energy_cost", EnergyCost.CODEC);
    public static final Supplier<MapCodec<Multiplier>> MULTIPLIER = registry("multiplier", Multiplier.CODEC);
    public static final Supplier<MapCodec<MultiplierCost>> MULTIPLIER_COST = registry("multiplier_cost", MultiplierCost.CODEC);
    public static final Supplier<MapCodec<Tier>> TIER = registry("tier", Tier.CODEC);
    public static final Codec<ModuleConfig> POLYMORPH_CODEC = MODULES.byNameCodec().dispatch((v0) -> {
        return v0.codec();
    }, Function.identity());

    @Nonnull
    private static <C extends ModuleConfig> a<C> newModule(@Nonnull String str, ModuleConfigJsonSerializer<C> moduleConfigJsonSerializer, boolean z) {
        return new a<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str), moduleConfigJsonSerializer, z);
    }

    @Nonnull
    private static <C extends ModuleConfig> a<C> newModule(@Nonnull String str, ModuleConfigJsonSerializer<C> moduleConfigJsonSerializer, boolean z, Int2IntFunction int2IntFunction) {
        return new a<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str), moduleConfigJsonSerializer, z, int2IntFunction);
    }

    public static void register(IEventBus iEventBus) {
        DEFERRED.register(iEventBus);
    }

    private static <T extends ModuleConfig> Supplier<MapCodec<T>> registry(String str, MapCodec<T> mapCodec) {
        return DEFERRED.register(str, () -> {
            return mapCodec;
        });
    }
}
