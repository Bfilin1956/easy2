package mctech.init;

import appeng.api.crafting.PatternDetailsHelper;
import appeng.api.util.AEColor;
import appeng.core.definitions.AEItems;
import appeng.items.parts.ColoredPartItem;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import mctech.MCTech;
import mctech.a.a.c.a;
import mctech.api.items.Consumables;
import mctech.blockentities.c.C0074u;
import mctech.g.d.b.c;
import mctech.g.d.c.f;
import mctech.items.A;
import mctech.items.B;
import mctech.items.EnumC0125a;
import mctech.items.base.j;
import mctech.items.base.p;
import mctech.items.base.q;
import mctech.items.d.b;
import mctech.items.d.l;
import mctech.items.d.n;
import mctech.items.d.o;
import mctech.items.e.a.e;
import mctech.items.e.a.g;
import mctech.items.e.a.h;
import mctech.items.e.a.i;
import mctech.items.e.k;
import mctech.items.e.m;
import mctech.items.g.a.a.d;
import mctech.items.v;
import mctech.items.z;
import mctech.modules.config.AmplifierFloat;
import mctech.modules.config.AmplifierFloatCost;
import mctech.modules.config.AmplifierInt;
import mctech.modules.config.AmplifierIntCost;
import mctech.modules.config.EnergyCost;
import mctech.modules.config.ModuleConfig;
import mctech.modules.config.Multiplier;
import mctech.modules.config.MultiplierCost;
import mctech.modules.config.Tier;
import net.mcskill.msregistry.core.MachineTier;
import net.mcskill.msregistry.datagen.GeckoData;
import net.mcskill.msregistry.registry.holder.LItem;
import net.mcskill.msregistry.registry.type.ItemRegistry;
import net.mcskill.msregistry.utils.lang.RussianForm;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechItems.class */
public class MCTechItems {
    private static final ItemRegistry ITEM_REGISTRY = MCTech.REGISTRY.itemRegistry();
    public static HashMap<AEColor, LItem<ColoredPartItem<a>>> ENHANCED_CABLE_TIER_PARTS = new HashMap<>();
    public static HashMap<b, LItem<Item>> BURNT_FUEL_PELLETS = new HashMap<>();
    public static final LItem<Item> C_COIN;
    public static final LItem<Item> SAWDUST;
    public static final LItem<c> CONDUIT_PROBE;
    public static final LItem<B> YETA_WRENCH;
    public static final DeferredItem<mctech.g.d.a.b.b.b> BASIC_ITEM_FILTER;
    public static final DeferredItem<mctech.g.d.a.b.b.b> BIG_ITEM_FILTER;
    public static final DeferredItem<mctech.g.d.a.b.b.b> ADVANCED_ITEM_FILTER;
    public static final DeferredItem<mctech.g.d.a.b.b.b> BIG_ADVANCED_ITEM_FILTER;
    public static final DeferredItem<mctech.g.d.a.b.a.b> BASIC_FLUID_FILTER;
    public static final DeferredItem<mctech.g.d.a.b.b.a.b> LIMITED_ITEM_FILTER;
    public static final DeferredItem<Item> REDSTONE_FILTER_BASE;
    public static final DeferredItem<f> NOT_FILTER;
    public static final DeferredItem<f> OR_FILTER;
    public static final DeferredItem<f> AND_FILTER;
    public static final DeferredItem<f> NOR_FILTER;
    public static final DeferredItem<f> NAND_FILTER;
    public static final DeferredItem<f> XOR_FILTER;
    public static final DeferredItem<f> XNOR_FILTER;
    public static final DeferredItem<f> TLATCH_FILTER;
    public static final DeferredItem<f> COUNT_FILTER;
    public static final DeferredItem<f> SENSOR_FILTER;
    public static final DeferredItem<f> TIMER_FILTER;
    public static final LItem<mctech.items.f.j.a> AMETHYST_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COAL_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COPPER_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> DIAMOND_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> EMERALD_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> GOLD_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> IRON_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> LAPIS_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> REDSTONE_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> RUBIDIUM_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> TIN_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> TITANIUM_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> URANIUM_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> TUNGSTEN_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COLORED_AMETHYST_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COLORED_COAL_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COLORED_COPPER_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COLORED_DIAMOND_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COLORED_EMERALD_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COLORED_GOLD_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COLORED_IRON_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COLORED_LAPIS_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COLORED_REDSTONE_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COLORED_RUBIDIUM_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COLORED_TIN_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COLORED_TITANIUM_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COLORED_URANIUM_ORE_SCANNER;
    public static final LItem<mctech.items.f.j.a> COLORED_TUNGSTEN_ORE_SCANNER;
    public static final LItem<d> XRAY_GOGGLES;
    public static final LItem<mctech.items.g.a.a.a> ADVANCED_XRAY_GOGGLES;
    public static final LItem<Item> ASSEMBLY_STATION_PATTERN;
    public static final LItem<Item> INDUSTRIAL_FORGE_PATTERN;
    public static final LItem<Item> QUANTUM_WORKBENCH_PATTERN;
    public static final LItem<Item> TRANSFORMATION_ASSEMBLER_PATTERN;
    public static final LItem<j> RAW_AMETHYST;
    public static final LItem<j> RAW_ALUMINIUM;
    public static final LItem<j> RAW_TIN;
    public static final LItem<j> RAW_RUBIDIUM;
    public static final LItem<j> RAW_TITANIUM;
    public static final LItem<j> RAW_SILVER;
    public static final LItem<j> DUST_IRON;
    public static final LItem<j> DUST_TIN;
    public static final LItem<j> DUST_COPPER;
    public static final LItem<j> DUST_SILVER;
    public static final LItem<j> DUST_GOLD;
    public static final LItem<j> DUST_BRONZE;
    public static final LItem<j> DUST_ALUMINIUM;
    public static final LItem<j> DUST_CHARCOAL;
    public static final LItem<j> DUST_COAL;
    public static final LItem<j> DUST_CLAY;
    public static final LItem<j> DUST_NETHERRACK;
    public static final LItem<j> DUST_OBSIDIAN;
    public static final LItem<j> DUST_RARE_EARTH;
    public static final LItem<j> DUST_DIAMOND;
    public static final LItem<j> INGOT_TIN;
    public static final LItem<j> INGOT_SILVER;
    public static final LItem<j> INGOT_REFINED_IRON;
    public static final LItem<j> INGOT_BRONZE;
    public static final LItem<j> INGOT_POLISHED_GOLD;
    public static final LItem<j> INGOT_ALUMINIUM;
    public static final LItem<j> INGOT_ADVANCED_ALLOY;
    public static final LItem<j> INGOT_URANIUM;
    public static final LItem<j> INGOT_URANIUM_ENRICHED_BLAZE;
    public static final LItem<j> INGOT_URANIUM_ENRICHED_CHARCOAL;
    public static final LItem<j> INGOT_URANIUM_ENRICHED_ENDERPEARL;
    public static final LItem<j> INGOT_URANIUM_ENRICHED_NETHERSTAR;
    public static final LItem<j> INGOT_URANIUM_ENRICHED_REDSTONE;
    public static final LItem<j> ORE_IRIDIUM;
    public static final LItem<j> ORE_URANIUM_DROP;
    public static final LItem<j> SCRAP;
    public static final LItem<j> SCRAP_METAL;
    public static final LItem<j> UUMATTER;
    public static final LItem<j> CARBON_FIBER;
    public static final LItem<j> CARBON_MESH;
    public static final LItem<j> PULSATING_QUARTZ;
    public static final LItem<j> RARE_EARTH_CHUNK;
    public static final LItem<j> DEAD_MAGNET;
    public static final LItem<j> MAGNET;
    public static final LItem<j> SCRAP_METAL_CHUNK;
    public static final LItem<j> PLANT_BALL;
    public static final LItem<j> RUBBER;
    public static final LItem<j> CIRCUIT;
    public static final LItem<j> ADVANCED_CIRCUIT;
    public static final LItem<Item> TIN_CAN;
    public static final LItem<Item> TIN_CAN_FILLED;
    public static final LItem<j> UPGRADE_BASE;
    public static final LItem<mctech.items.f.i.a> OVERCLOCKER_UPGRADE;
    public static final LItem<mctech.items.f.i.a> UPGRADE_COMPOSITE_OVERCLOCKER;
    public static final LItem<mctech.items.f.i.a> UPGRADE_NANO_OVERCLOCKER;
    public static final LItem<mctech.items.f.i.a> UPGRADE_QUANTUM_OVERCLOCKER;
    public static final LItem<mctech.items.f.i.a> UPGRADE_SINGULAR_OVERCLOCKER;
    public static final LItem<mctech.items.f.i.a> UPGRADE_ADMIN_OVERCLOCKER;
    public static final LItem<mctech.items.f.c.c> TRANSFORMER_UPGRADE;
    public static final LItem<mctech.items.f.c.b> ENERGY_STORAGE_UPGRADE;
    public static final LItem<mctech.items.f.c.a> ENERGY_STORAGE_MULTIPLIER_UPGRADE;
    public static final LItem<mctech.items.f.g.a> REDSTONE_INVERTER_UPGRADE;
    public static final LItem<mctech.items.f.a.a> MUTE_UPGRADE;
    public static final LItem<mctech.items.f.h.a> CREATIVE_UPGRADE;
    public static final LItem<mctech.items.f.i.b> SAWBLADE_EFFICIENT_UPGRADE;
    public static final LItem<mctech.items.f.i.b> SAWBLADE_DURABLE_UPGRADE;
    public static final LItem<mctech.items.f.c> WIDE_BAND_PAD_UPGRADE;
    public static final LItem<mctech.items.f.c> BASIC_FIELD_PAD_UPGRADE;
    public static final LItem<mctech.items.f.c> FIELD_PAD_UPGRADE;
    public static final LItem<mctech.items.f.c> ADVANCED_FIELD_PAD_UPGRADE;
    public static final LItem<mctech.items.f.a> COMPLEX_HANDLER_UPDATE;
    public static final LItem<mctech.items.f.b> UPGRADE_SLOT_1;
    public static final LItem<mctech.items.f.b> UPGRADE_SLOT_2;
    public static final LItem<mctech.items.f.b> UPGRADE_SLOT_3;
    public static final LItem<mctech.items.f.b> UPGRADE_SLOT_4;
    public static final LItem<mctech.items.f.d.b> UPGRADE_FARMING_RADIUS_T1;
    public static final LItem<mctech.items.f.d.b> UPGRADE_FARMING_RADIUS_T2;
    public static final LItem<mctech.items.f.d.b> UPGRADE_FARMING_RADIUS_T3;
    public static final LItem<mctech.items.f.d.a> UPGRADE_FARMING_FERTILIZER_T1;
    public static final LItem<mctech.items.f.d.a> UPGRADE_FARMING_FERTILIZER_T2;
    public static final LItem<mctech.items.f.d.a> UPGRADE_FARMING_FERTILIZER_T3;
    public static final LItem<mctech.items.f.e.b> LIQUID_COOLANT_UPGRADE;
    public static final LItem<mctech.items.f.e.a> ENRICHMENT_UPGRADE;
    public static final LItem<mctech.items.misc.d> STICKY_RESIN;
    public static final LItem<k> TREETAP;
    public static final LItem<m> WRENCH;
    public static final LItem<mctech.items.e.a.f> ELECTRIC_WRENCH;
    public static final LItem<mctech.items.e.a.f.a> PRECISION_WRENCH;
    public static final LItem<h> DESTROYER;
    public static final LItem<g> ADVANCED_DESTROYER;
    public static final LItem<mctech.items.e.a.c> CHAINSAW;
    public static final LItem<mctech.items.e.a.c> ADVANCED_CHAINSAW;
    public static final LItem<mctech.items.g.a.b> HAZMAT_HELMET;
    public static final LItem<mctech.items.g.a.b> HAZMAT_CHEST;
    public static final LItem<mctech.items.g.a.b> HAZMAT_LEGGINGS;
    public static final LItem<mctech.items.g.a.b> HAZMAT_BOOTS;
    public static final LItem<mctech.items.g.a.a.c> NIGHT_VISION_HELMET;
    public static final LItem<mctech.items.g.c.b> JETPACK;
    public static final LItem<mctech.items.g.c.b> ADVANCED_JETPACK;
    public static final LItem<mctech.items.g.c.b> GRAVITATION_JETPACK;
    public static final LItem<mctech.items.g.c.b> ROCKET_GRAVITATION_JETPACK;
    public static LItem<Item> FOOD_STORAGE_MODULE;
    public static final LItem<i> OBSCURATOR;
    public static final LItem<e> ELECTRIC_TREETAP;
    public static final LItem<mctech.items.e.a.b> ADVANCED_TREETAP;
    public static final LItem<mctech.items.e.a.d> ELECTRIC_HOE;
    public static final LItem<mctech.items.e.a.a> ADVANCED_HOE;
    public static final LItem<mctech.items.e.e> EU_READER;
    public static final LItem<mctech.items.e.f> FREQUENCY_TRANSMITTER;
    public static final LItem<mctech.items.misc.a> RE_BATTERY;
    public static final LItem<z> WINDMILL_ROTOR_T1;
    public static final LItem<z> WINDMILL_ROTOR_T2;
    public static final LItem<z> WINDMILL_ROTOR_T3;
    public static final LItem<z> WINDMILL_ROTOR_T4;
    public static final LItem<z> WINDMILL_ROTOR_T5;
    public static final LItem<z> WINDMILL_ROTOR_T6;
    public static final LItem<z> WINDMILL_ROTOR_T7;
    public static final LItem<z> WINDMILL_ROTOR_T8;
    public static final LItem<mctech.items.c.b> GENETIC_MATERIAL;
    public static final LItem<j> EMPTY_VIAL;
    public static final LItem<mctech.items.c.a> DNA_SAMPLE;
    public static final LItem<mctech.items.base.h> ENERGY_CRYSTAL;
    public static final LItem<mctech.items.base.h> ADVANCED_ENERGY_CRYSTAL;
    public static final LItem<mctech.items.base.h> COMPOSITE_ENERGY_CRYSTAL;
    public static final LItem<mctech.items.base.h> NANO_ENERGY_CRYSTAL;
    public static final LItem<mctech.items.base.h> QUANTUM_ENERGY_CRYSTAL;
    public static final LItem<mctech.items.base.h> SINGULARITY_ENERGY_CRYSTAL;
    public static final LItem<mctech.items.base.h> RUBIDIUM_ENERGY_CRYSTAL;
    public static final LItem<mctech.items.g.a.a.b> ENERGY_LAPPACK;
    public static final LItem<mctech.items.g.a.a.b> ADVANCED_ENERGY_LAPPACK;
    public static final LItem<mctech.items.g.a.a.b> COMPOSITE_ENERGY_LAPPACK;
    public static final LItem<mctech.items.g.a.a.b> NANO_ENERGY_LAPPACK;
    public static final LItem<mctech.items.g.a.a.b> QUANTUM_ENERGY_LAPPACK;
    public static final LItem<mctech.items.g.a.a.b> SINGULARITY_ENERGY_LAPPACK;
    public static final LItem<mctech.items.g.a.a.b> RUBIDIUM_ENERGY_LAPPACK;
    public static final LItem<Item> FLUID_DISPLAY;
    public static final LItem<Item> TAG_ITEM;
    public static final LItem<Item> TAG_BLOCK;
    public static final LItem<mctech.items.d.c> CONDENSATOR;
    public static final LItem<mctech.items.d.c> CONDENSATOR_LAP;
    public static final LItem<mctech.items.d.a> FUEL_PELLET_T1;
    public static final LItem<mctech.items.d.a> FUEL_PELLET_T2;
    public static final LItem<mctech.items.d.a> FUEL_PELLET_T3;
    public static final LItem<mctech.items.d.a> FUEL_PELLET_T4;
    public static final LItem<mctech.items.d.a> FUEL_PELLET_T5;
    public static final LItem<mctech.items.d.m> PLATING;
    public static final LItem<mctech.items.d.m> PLATING_HEAT_CAPACITY;
    public static final LItem<mctech.items.d.m> PLATING_CONTAINMENT;
    public static final LItem<n> REFLECTOR;
    public static final LItem<n> REFLECTOR_THICK;
    public static final LItem<mctech.items.d.k> REFLECTOR_IRIDIUM;
    public static final LItem<j> URANIUM_ROD_NEAR_DEPLETED;
    public static final LItem<j> URANIUM_ROD_NEAR_DEPLETED_REDSTONE;
    public static final LItem<j> URANIUM_ROD_NEAR_DEPLETED_BLAZE;
    public static final LItem<j> URANIUM_ROD_NEAR_DEPLETED_ENDER_PEARL;
    public static final LItem<j> URANIUM_ROD_NEAR_DEPLETED_NETHER_STAR;
    public static final LItem<j> URANIUM_ROD_NEAR_DEPLETED_CHARCOAL;
    public static final LItem<j> URANIUM_ROD_RE_ENRICHED;
    public static final LItem<j> URANIUM_ROD_RE_ENRICHED_REDSTONE;
    public static final LItem<j> URANIUM_ROD_RE_ENRICHED_BLAZE;
    public static final LItem<j> URANIUM_ROD_RE_ENRICHED_ENDER_PEARL;
    public static final LItem<j> URANIUM_ROD_RE_ENRICHED_NETHER_STAR;
    public static final LItem<j> URANIUM_ROD_RE_ENRICHED_CHARCOAL;
    public static final LItem<o> URANIUM_ROD_SINGLE;
    public static final LItem<o> URANIUM_ROD_REDSTONE_SINGLE;
    public static final LItem<o> URANIUM_ROD_BLAZE_SINGLE;
    public static final LItem<o> URANIUM_ROD_ENDER_PEARL_SINGLE;
    public static final LItem<o> URANIUM_ROD_NETHER_STAR_SINGLE;
    public static final LItem<o> URANIUM_ROD_CHARCOAL_SINGLE;
    public static final LItem<o> URANIUM_ROD_DUAL;
    public static final LItem<o> URANIUM_ROD_REDSTONE_DUAL;
    public static final LItem<o> URANIUM_ROD_BLAZE_DUAL;
    public static final LItem<o> URANIUM_ROD_ENDER_PEARL_DUAL;
    public static final LItem<o> URANIUM_ROD_NETHER_STAR_DUAL;
    public static final LItem<o> URANIUM_ROD_CHARCOAL_DUAL;
    public static final LItem<o> URANIUM_ROD_QUAD;
    public static final LItem<o> URANIUM_ROD_REDSTONE_QUAD;
    public static final LItem<o> URANIUM_ROD_BLAZE_QUAD;
    public static final LItem<o> URANIUM_ROD_ENDER_PEARL_QUAD;
    public static final LItem<o> URANIUM_ROD_NETHER_STAR_QUAD;
    public static final LItem<o> URANIUM_ROD_CHARCOAL_QUAD;
    public static final LItem<l> URANIUM_ROD_ISOTOPIC;
    public static final LItem<l> URANIUM_ROD_ISOTOPIC_REDSTONE;
    public static final LItem<l> URANIUM_ROD_ISOTOPIC_BLAZE;
    public static final LItem<l> URANIUM_ROD_ISOTOPIC_ENDER_PEARL;
    public static final LItem<l> URANIUM_ROD_ISOTOPIC_NETHER_STAR;
    public static final LItem<l> URANIUM_ROD_ISOTOPIC_CHARCOAL;
    public static final LItem<mctech.items.b.a> URANIUM_FUEL;
    public static final LItem<mctech.items.b.a> COMBINED_URANIUM_FUEL;
    public static final LItem<mctech.items.b.a> ISOTOPIC_FUEL;
    public static final LItem<mctech.items.b.a> COMPOSITE_FUEL;
    public static final LItem<mctech.items.b.a> NANO_FUEL;
    public static final LItem<mctech.items.b.a> QUANTUM_FUEL;
    public static final LItem<mctech.items.b.a> SINGULARITY_FUEL;
    public static final LItem<mctech.items.b.a> RUBIDIUM_FUEL;
    public static final LItem<mctech.items.b.b> BASIC_CATALYST;
    public static final LItem<mctech.items.b.b> ISOTOPIC_CATALYST;
    public static final LItem<mctech.items.b.b> COMPOSITE_CATALYST;
    public static final LItem<mctech.items.b.b> NANO_CATALYST;
    public static final LItem<mctech.items.b.b> QUANTUM_CATALYST;
    public static final LItem<mctech.items.b.b> SINGULARITY_CATALYST;
    public static final LItem<mctech.items.b.b> RUBIDIUM_CATALYST;
    public static final LItem<mctech.items.misc.c> SCRAPBOX;
    public static final LItem<mctech.items.base.m> GEN_DAY_1;
    public static final LItem<mctech.items.base.m> GEN_DAY_2;
    public static final LItem<mctech.items.base.m> GEN_DAY_3;
    public static final LItem<mctech.items.base.m> GEN_DAY_4;
    public static final LItem<mctech.items.base.m> GEN_DAY_5;
    public static final LItem<mctech.items.base.m> GEN_DAY_6;
    public static final LItem<mctech.items.base.m> GEN_DAY_7;
    public static final LItem<mctech.items.base.m> GEN_DAY_8;
    public static final LItem<mctech.items.base.m> GEN_DAY_9;
    public static final LItem<mctech.items.base.m> GEN_DAY_10;
    public static final LItem<mctech.items.base.m> GEN_NIGHT_1;
    public static final LItem<mctech.items.base.m> GEN_NIGHT_2;
    public static final LItem<mctech.items.base.m> GEN_NIGHT_3;
    public static final LItem<mctech.items.base.m> GEN_NIGHT_4;
    public static final LItem<mctech.items.base.m> GEN_NIGHT_5;
    public static final LItem<mctech.items.base.m> GEN_NIGHT_6;
    public static final LItem<mctech.items.base.m> GEN_NIGHT_7;
    public static final LItem<mctech.items.base.m> GEN_NIGHT_8;
    public static final LItem<mctech.items.base.m> GEN_NIGHT_9;
    public static final LItem<mctech.items.base.m> GEN_NIGHT_10;
    public static final LItem<mctech.items.base.m> UNIVERSAL_GEN_1;
    public static final LItem<mctech.items.base.m> UNIVERSAL_GEN_2;
    public static final LItem<mctech.items.base.m> UNIVERSAL_GEN_3;
    public static final LItem<mctech.items.base.m> UNIVERSAL_GEN_4;
    public static final LItem<mctech.items.base.m> UNIVERSAL_GEN_5;
    public static final LItem<mctech.items.base.m> UNIVERSAL_GEN_6;
    public static final LItem<mctech.items.base.m> UNIVERSAL_GEN_7;
    public static final LItem<mctech.items.base.m> UNIVERSAL_GEN_8;
    public static final LItem<mctech.items.base.m> UNIVERSAL_GEN_9;
    public static final LItem<mctech.items.base.m> UNIVERSAL_GEN_10;
    public static final LItem<mctech.items.base.m> IS_GEN_NIGHT;
    public static final LItem<mctech.items.base.m> STORAGE_1;
    public static final LItem<mctech.items.base.m> STORAGE_2;
    public static final LItem<mctech.items.base.m> STORAGE_3;
    public static final LItem<mctech.items.base.m> TRANSFORMER;
    public static final LItem<mctech.items.base.m> AE_ENERGY;
    public static final LItem<mctech.items.f.f.b> UPGRADE_MASS_FABRICATOR_FORTUNE_1;
    public static final LItem<mctech.items.f.f.b> UPGRADE_MASS_FABRICATOR_FORTUNE_2;
    public static final LItem<mctech.items.f.f.b> UPGRADE_MASS_FABRICATOR_FORTUNE_3;
    public static final LItem<mctech.items.f.f.b> UPGRADE_MASS_FABRICATOR_FORTUNE_4;
    public static final LItem<mctech.items.f.f.c> UPGRADE_SCRAP_GENERATION;
    public static final LItem<mctech.items.f.f.c> UPGRADE_SCRAPBOX_GENERATION;
    public static final LItem<mctech.items.f.f.a> UPGRADE_DENSE_MATTER_1;
    public static final LItem<mctech.items.f.f.a> UPGRADE_DENSE_MATTER_2;
    public static final LItem<mctech.items.e.b.a> BRONZE_AXE;
    public static final LItem<mctech.items.e.b.b> BRONZE_HOE;
    public static final LItem<mctech.items.e.b.c> BRONZE_PICKAXE;
    public static final LItem<mctech.items.e.b.d> BRONZE_SHOVEL;
    public static final LItem<mctech.items.e.b.e> BRONZE_SWORD;
    public static final LItem<mctech.items.e.d.a> TIN_AXE;
    public static final LItem<mctech.items.e.d.b> TIN_HOE;
    public static final LItem<mctech.items.e.d.c> TIN_PICKAXE;
    public static final LItem<mctech.items.e.d.d> TIN_SHOVEL;
    public static final LItem<mctech.items.e.d.e> TIN_SWORD;
    public static final LItem<mctech.items.e.c.a> ENHANCED_QUANTUM_AXE;
    public static final LItem<mctech.items.e.c.b> ENHANCED_QUANTUM_PICKAXE;
    public static final LItem<mctech.items.e.c.c> ENHANCED_QUANTUM_SHOVEL;
    public static final LItem<mctech.items.e.c.d> ENHANCED_QUANTUM_STAFF;
    public static final LItem<mctech.items.e.c.f> ENHANCED_QUANTUM_SWORD;
    public static final LItem<mctech.items.e.c.g> ENHANCED_QUANTUM_TRIDENT;
    public static final LItem<mctech.items.g.a.c> ENHANCED_QUANTUM_HELMET;
    public static final LItem<mctech.items.g.a.c> ENHANCED_QUANTUM_CHESTPLATE;
    public static final LItem<mctech.items.g.a.c> ENHANCED_QUANTUM_LEGGINGS;
    public static final LItem<mctech.items.g.a.c> ENHANCED_QUANTUM_BOOTS;
    public static final LItem<mctech.items.g.a.a> BRONZE_HELMET;
    public static final LItem<mctech.items.g.a.a> BRONZE_CHEST;
    public static final LItem<mctech.items.g.a.a> BRONZE_LEGGINGS;
    public static final LItem<mctech.items.g.a.a> BRONZE_BOOTS;
    public static final LItem<mctech.items.g.c.a> DEBUG_JETPACK;
    public static final LItem<mctech.items.e.i> SCHEME_INSTALLER;
    public static final LItem<mctech.items.e.c> COMPOSITE_PICKAXE;
    public static final LItem<mctech.items.e.c> NANO_PICKAXE;
    public static final LItem<mctech.items.e.c> QUANTUM_PICKAXE;
    public static final LItem<mctech.items.e.c> SINGULAR_PICKAXE;
    public static final LItem<mctech.items.e.c> ADMIN_PICKAXE;
    public static final LItem<mctech.items.e.a> COMPOSITE_HELMET;
    public static final LItem<mctech.items.e.b> COMPOSITE_CHEST;
    public static final LItem<mctech.items.e.a> COMPOSITE_LEGS;
    public static final LItem<mctech.items.e.a> COMPOSITE_BOOT;
    public static final LItem<mctech.items.e.a> NANO_HELMET;
    public static final LItem<mctech.items.e.b> NANO_CHEST;
    public static final LItem<mctech.items.e.a> NANO_LEGS;
    public static final LItem<mctech.items.e.a> NANO_BOOT;
    public static final LItem<mctech.items.e.a> QUANTUM_HELMET;
    public static final LItem<mctech.items.e.b> QUANTUM_CHEST;
    public static final LItem<mctech.items.e.a> QUANTUM_LEGS;
    public static final LItem<mctech.items.e.a> QUANTUM_BOOT;
    public static final LItem<mctech.items.e.a> SINGULAR_HELMET;
    public static final LItem<mctech.items.e.b> SINGULAR_CHEST;
    public static final LItem<mctech.items.e.a> SINGULAR_LEGS;
    public static final LItem<mctech.items.e.a> SINGULAR_BOOT;
    public static final LItem<mctech.items.e.a> ADMIN_HELMET;
    public static final LItem<mctech.items.e.b> ADMIN_CHEST;
    public static final LItem<mctech.items.e.a> ADMIN_LEGS;
    public static final LItem<mctech.items.e.a> ADMIN_BOOT;
    public static final LItem<j> COMPOSITE_CIRCUIT;
    public static final LItem<j> NANO_CIRCUIT;
    public static final LItem<j> QUANTUM_CIRCUIT;
    public static final LItem<j> SINGULAR_CIRCUIT;
    public static final LItem<j> ADMIN_CIRCUIT;
    public static final LItem<j> UU_MATTER_2;
    public static final LItem<j> UU_MATTER_3;
    public static final LItem<j> ANTI_UU_MATTER;
    public static final LItem<j> ANTI_UU_MATTER_2;
    public static final LItem<j> ANTI_UU_MATTER_3;
    public static final LItem<j> ADMIN_SCRAP;
    public static final LItem<j> ADMIN_SCRAP_BOX;
    public static final LItem<j> SIGN_SCRAP;
    public static final LItem<j> SIGN_SCRAP_BOX;
    public static final LItem<j> QUANT_SCRAP;
    public static final LItem<j> QUANT_SCRAP_BOX;
    public static final LItem<j> NANO_SCRAP;
    public static final LItem<j> NANO_SCRAP_BOX;
    public static final LItem<j> COMP_SCRAP;
    public static final LItem<j> COMP_SCRAP_BOX;
    public static final LItem<j> IRIDIUM_INGOT;
    public static final LItem<j> TITANIUM_PLATE;
    public static final LItem<j> LAPIS_PLATE;
    public static final LItem<mctech.items.e.h> COMPOSITE_SABER;
    public static final LItem<mctech.items.e.h> NANO_SABER;
    public static final LItem<mctech.items.e.h> QUANTUM_SABER;
    public static final LItem<mctech.items.e.h> SINGULAR_SABER;
    public static final LItem<mctech.items.e.h> ADMIN_SABER;
    public static final LItem<mctech.items.e.l> WHETSTONE_OF_LEGEND;
    public static final LItem<mctech.items.e.l> WHETSTONE_OF_MASTERY;
    public static final LItem<mctech.items.e.l> WHETSTONE_OF_SHARPNESS;
    public static LItem<mctech.items.base.d> MODULE_SILK_TOUCH;
    public static LItem<mctech.items.base.d> MODULE_BEDROCK_ORE_DESTROY;
    public static final LItem<mctech.items.d.j> VENT_HEAT;
    public static final LItem<mctech.items.d.j> VENT_HEAT_CORE;
    public static final LItem<mctech.items.d.j> VENT_HEAT_OVERCLOCKED;
    public static final LItem<mctech.items.d.j> VENT_HEAT_OVERCLOCKED_T2;
    public static final LItem<mctech.items.d.j> VENT_HEAT_OVERCLOCKED_T3;
    public static final LItem<mctech.items.d.j> VENT_HEAT_ADVANCED;
    public static final LItem<mctech.items.d.j> VENT_ELECTRIC;
    public static final LItem<mctech.items.d.j> VENT_ELECTRIC_CORE;
    public static final LItem<mctech.items.d.j> VENT_ELECTRIC_OVERCLOCKED;
    public static final LItem<mctech.items.d.j> VENT_ELECTRIC_OVERCLOCKED_T2;
    public static final LItem<mctech.items.d.j> VENT_ELECTRIC_OVERCLOCKED_T3;
    public static final LItem<mctech.items.d.j> VENT_ELECTRIC_ADVANCED;
    public static final LItem<mctech.items.d.j> VENT_ELECTRIC_ADVANCED_T2;
    public static final LItem<mctech.items.d.j> VENT_ELECTRIC_ADVANCED_T3;
    public static final LItem<mctech.items.d.f> HEAT_EXCHANGER;
    public static final LItem<mctech.items.d.f> HEAT_EXCHANGER_CORE;
    public static final LItem<mctech.items.d.f> HEAT_EXCHANGER_SPREAD;
    public static final LItem<mctech.items.d.f> HEAT_EXCHANGER_ADVANCED;
    public static final LItem<mctech.items.d.f> HEAT_EXCHANGER_ADVANCED_T2;
    public static final LItem<mctech.items.d.f> HEAT_EXCHANGER_ADVANCED_T3;
    public static final LItem<mctech.items.d.e> HEAT_BALANCER;
    public static final LItem<mctech.items.d.e> HEAT_BALANCER_CORE;
    public static final LItem<mctech.items.d.e> HEAT_BALANCER_SPREAD;
    public static final LItem<mctech.items.d.e> HEAT_BALANCER_ADVANCED;
    public static final LItem<mctech.items.d.e> HEAT_BALANCER_ADVANCED_T2;
    public static final LItem<mctech.items.d.e> HEAT_BALANCER_ADVANCED_T3;
    public static final LItem<mctech.items.d.i> COOLANT_CELL_10K;
    public static final LItem<mctech.items.d.i> COOLANT_CELL_30K;
    public static final LItem<mctech.items.d.i> COOLANT_CELL_60K;
    public static final LItem<mctech.items.d.g> HEAT_PACK;
    public static final LItem<mctech.items.d.h> HEAT_SPREADER;
    public static final LItem<mctech.a.b> INFINITE_COBBLESTONE_CELL;
    public static final LItem<mctech.a.b> INFINITE_COPPER_INGOT_CELL;
    public static final LItem<mctech.a.b> INFINITE_REDSTONE_CELL;
    public static final LItem<mctech.a.b> INFINITE_LAPIS_CELL;
    public static final LItem<mctech.a.b> INFINITE_MATTER_CELL;
    public static final LItem<mctech.a.b> INFINITE_GOLD_INGOT_CELL;
    public static final LItem<mctech.a.b> INFINITE_IRON_INGOT_CELL;
    public static final LItem<mctech.a.b> INFINITE_DIAMOND_CELL;
    public static final LItem<mctech.a.b> INFINITE_COAL_CELL;
    public static final LItem<mctech.a.b> INFINITE_CERTUS_QUARTZ_CELL;
    public static final LItem<mctech.a.b> INFINITE_OAK_LOG_CELL;
    public static final LItem<mctech.a.b> INFINITE_GLOWSTONE_CELL;
    public static final LItem<mctech.a.b> INFINITE_NETHER_QUARTZ_CELL;
    public static final LItem<mctech.a.b> INFINITE_RUBBER_CELL;
    public static final LItem<mctech.a.b> INFINITE_LAVA_CELL;
    public static final LItem<mctech.a.b> INFINITE_WATER_CELL;
    public static final LItem<mctech.a.b> INFINITE_GLASS_CELL;
    public static final LItem<mctech.a.b> INFINITE_URANIUM_CELL;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechItems$ModulesItemFactory.class */
    public interface ModulesItemFactory<I extends Item, C extends ModuleConfig> {
        @Nonnull
        I createItemModule(@Nonnull mctech.modules.e<C> eVar, int i);
    }

    static {
        registerModules();
        registerEnhancedCable(64, "Enhanced cable T1", "улучшенный кабель T1");
        registerEnhancedCable(128, "Enhanced cable T2", "улучшенный кабель T2");
        registerEnhancedCable(mctech.utils.c.h.i, "Enhanced cable T3", "улучшенный кабель T3");
        for (b bVar : b.values()) {
            BURNT_FUEL_PELLETS.put(bVar, registerFuelPellet(bVar));
        }
        C_COIN = ITEM_REGISTRY.registerItem("c_coin", Item::new).condition(MCTech::isFrozen).setModelProvider((lItemModelProvider, dataGenContext) -> {
            lItemModelProvider.basicItem((Item) dataGenContext.get());
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("C-Coin", "Скоин");
        SAWDUST = ITEM_REGISTRY.register("sawdust", () -> {
            return new Item(new Item.Properties());
        }).setTranslation("Saw dust", "Опилки").setModelProvider((lItemModelProvider2, dataGenContext2) -> {
            lItemModelProvider2.basicItem((Item) dataGenContext2.get(), MCTech.loc(String.format("item/misc/%s", dataGenContext2.getName())));
        }).setTab(MCTechCreativeTabs.MATERIALS);
        CONDUIT_PROBE = ITEM_REGISTRY.registerItem("conduit_probe", c::new, new Item.Properties().stacksTo(1)).setModelProvider((lItemModelProvider3, dataGenContext3) -> {
            lItemModelProvider3.getBuilder(dataGenContext3.getId().getPath()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", MCTech.loc("item/conduit_probe_probe")).override().predicate(c.a, 1.0f).model(lItemModelProvider3.basicItem(MCTech.loc("conduit_probe_copy")));
        }).setTab(MCTechCreativeTabs.CONDUITS).setTranslation("Conduit probe", "Инструмент для труб");
        YETA_WRENCH = ITEM_REGISTRY.registerItem("yeta_wrench", B::new, new Item.Properties().stacksTo(1)).defaultModel().setTab(MCTechCreativeTabs.CONDUITS).setTranslation("Conduit wrench", "Ключ настройки труб").addItemTags(new TagKey[]{mctech.g.d.d.a.b.b, mctech.g.d.d.a.b.a});
        BASIC_ITEM_FILTER = ITEM_REGISTRY.registerItem("basic_item_filter", properties -> {
            return new mctech.g.d.a.b.b.b(properties, mctech.g.d.a.b.b.b.a.BASIC);
        }).defaultModel().setTranslation("Item filter", "Предметный фильтр").setTab(MCTechCreativeTabs.CONDUITS);
        BIG_ITEM_FILTER = ITEM_REGISTRY.registerItem("big_item_filter", properties2 -> {
            return new mctech.g.d.a.b.b.b(properties2, mctech.g.d.a.b.b.b.a.BIG);
        }).defaultModel().setTranslation("Big item filter", "Увел. предметный фильтр").setTab(MCTechCreativeTabs.CONDUITS);
        ADVANCED_ITEM_FILTER = ITEM_REGISTRY.registerItem("advanced_item_filter", properties3 -> {
            return new mctech.g.d.a.b.b.b(properties3, mctech.g.d.a.b.b.b.a.ADVANCED);
        }).defaultModel().setTranslation("Advanced item filter", "Улучш. предметный фильтр").setTab(MCTechCreativeTabs.CONDUITS);
        BIG_ADVANCED_ITEM_FILTER = ITEM_REGISTRY.registerItem("big_advanced_item_filter", properties4 -> {
            return new mctech.g.d.a.b.b.b(properties4, mctech.g.d.a.b.b.b.a.BIG_ADVANCED);
        }).defaultModel().setTranslation("Big advanced item filter", "Мета предметный фильтр").setTab(MCTechCreativeTabs.CONDUITS);
        BASIC_FLUID_FILTER = ITEM_REGISTRY.registerItem("basic_fluid_filter", properties5 -> {
            return new mctech.g.d.a.b.a.b(properties5, mctech.g.d.a.b.a.b.a.BASIC);
        }).defaultModel().setTranslation("Fluid filter", "Жидкостный фильтр").setTab(MCTechCreativeTabs.CONDUITS);
        LIMITED_ITEM_FILTER = ITEM_REGISTRY.registerItem("limited_item_filter", mctech.g.d.a.b.b.a.b::new).defaultModel().setTranslation("Limited item filter", "Ограниченный предметный фильтр").setTab(MCTechCreativeTabs.CONDUITS);
        REDSTONE_FILTER_BASE = ITEM_REGISTRY.registerItem("redstone_filter_base").setTranslation("Redstone filter", "Редстоун-фильтр").defaultModel().setTab(MCTechCreativeTabs.CONDUITS);
        NOT_FILTER = ITEM_REGISTRY.registerItem("redstone_not_filter", properties6 -> {
            return new f(properties6, f.a.a);
        }).setTranslation("Redstone NOT filter", "Редстоун-фильтр (НЕ)").defaultModel().setTab(MCTechCreativeTabs.CONDUITS);
        OR_FILTER = ITEM_REGISTRY.registerItem("redstone_or_filter", properties7 -> {
            return new f(properties7, f.a.b);
        }).setTranslation("Redstone OR filter", "Редстоун-фильтр (ИЛИ)").defaultModel().setTab(MCTechCreativeTabs.CONDUITS);
        AND_FILTER = ITEM_REGISTRY.registerItem("redstone_and_filter", properties8 -> {
            return new f(properties8, f.a.c);
        }).defaultModel().setTranslation("Redstone AND filter", "Редстоун-фильтр (И)").setTab(MCTechCreativeTabs.CONDUITS);
        NOR_FILTER = ITEM_REGISTRY.registerItem("redstone_nor_filter", properties9 -> {
            return new f(properties9, f.a.d);
        }).defaultModel().setTranslation("Redstone NOR filter", "Редстоун-фильтр (ИЛИ-НЕ)").setTab(MCTechCreativeTabs.CONDUITS);
        NAND_FILTER = ITEM_REGISTRY.registerItem("redstone_nand_filter", properties10 -> {
            return new f(properties10, f.a.e);
        }).defaultModel().setTranslation("Redstone NAND filter", "Редстоун-фильтр (И-НЕ)").setTab(MCTechCreativeTabs.CONDUITS);
        XOR_FILTER = ITEM_REGISTRY.registerItem("redstone_xor_filter", properties11 -> {
            return new f(properties11, f.a.f);
        }).defaultModel().setTranslation("Redstone XOR filter", "Редстоун-фильтр (исключающее ИЛИ)").setTab(MCTechCreativeTabs.CONDUITS);
        XNOR_FILTER = ITEM_REGISTRY.registerItem("redstone_xnor_filter", properties12 -> {
            return new f(properties12, f.a.g);
        }).defaultModel().setTranslation("Redstone XNOR filter", "Редстоун-фильтр (исключающее НЕ-ИЛИ)").setTab(MCTechCreativeTabs.CONDUITS);
        TLATCH_FILTER = ITEM_REGISTRY.registerItem("redstone_toggle_filter", properties13 -> {
            return new f(properties13, f.a.h);
        }).defaultModel().setTranslation("Redstone TLATCH filter", "Редстоун-фильтр (TLATCH)").setTab(MCTechCreativeTabs.CONDUITS);
        COUNT_FILTER = ITEM_REGISTRY.registerItem("redstone_counting_filter", properties14 -> {
            return new f(properties14, f.a.i);
        }).defaultModel().setTranslation("Redstone COUNT filter", "Редстоун-фильтр (Счётчик)").setTab(MCTechCreativeTabs.CONDUITS);
        SENSOR_FILTER = ITEM_REGISTRY.registerItem("redstone_sensor_filter", properties15 -> {
            return new f(properties15, f.a.j);
        }).defaultModel().setTranslation("Redstone SENSOR filter", "Редстоун-фильтр (Сенсор)").setTab(MCTechCreativeTabs.CONDUITS);
        TIMER_FILTER = ITEM_REGISTRY.registerItem("redstone_timer_filter", properties16 -> {
            return new f(properties16, f.a.k);
        }).defaultModel().setTranslation("Redstone TIMER filter", "Редстоун-фильтр (Таймер)").setTab(MCTechCreativeTabs.CONDUITS);
        AMETHYST_ORE_SCANNER = registerScanner("amethyst", "аметистовой", MCTechTags.Ores.AMETHYST);
        COAL_ORE_SCANNER = registerScanner("coal", "угольной", (TagKey<Block>) BlockTags.COAL_ORES);
        COPPER_ORE_SCANNER = registerScanner("copper", "медной", (TagKey<Block>) BlockTags.COPPER_ORES);
        DIAMOND_ORE_SCANNER = registerScanner("diamond", "алмазной", (TagKey<Block>) BlockTags.DIAMOND_ORES);
        EMERALD_ORE_SCANNER = registerScanner("emerald", "изумрудной", (TagKey<Block>) BlockTags.EMERALD_ORES);
        GOLD_ORE_SCANNER = registerScanner("gold", "золотой", (TagKey<Block>) BlockTags.GOLD_ORES);
        IRON_ORE_SCANNER = registerScanner("iron", "железной", (TagKey<Block>) BlockTags.IRON_ORES);
        LAPIS_ORE_SCANNER = registerScanner("lapis", "лазуритовой", (TagKey<Block>) BlockTags.LAPIS_ORES);
        REDSTONE_ORE_SCANNER = registerScanner("redstone", "редстоун", (TagKey<Block>) BlockTags.REDSTONE_ORES);
        RUBIDIUM_ORE_SCANNER = registerScanner("rubidium", "рубидиевой", MCTechTags.Ores.RUBIDIUM);
        TIN_ORE_SCANNER = registerScanner("tin", "оловянной", MCTechTags.Ores.TIN);
        TITANIUM_ORE_SCANNER = registerScanner("titanium", "титановой", MCTechTags.Ores.TITANIUM);
        URANIUM_ORE_SCANNER = registerScanner("uranium", "урановой", MCTechTags.Ores.URANIUM);
        TUNGSTEN_ORE_SCANNER = registerScanner("tungsten", "вольфрамовой", MCTechTags.Ores.TUNGSTEN);
        COLORED_AMETHYST_ORE_SCANNER = registerColoredScanner("amethyst", "аметистовой", MCTechTags.Ores.AMETHYST);
        COLORED_COAL_ORE_SCANNER = registerColoredScanner("coal", "угольной", (TagKey<Block>) BlockTags.COAL_ORES);
        COLORED_COPPER_ORE_SCANNER = registerColoredScanner("copper", "медной", (TagKey<Block>) BlockTags.COPPER_ORES);
        COLORED_DIAMOND_ORE_SCANNER = registerColoredScanner("diamond", "алмазной", (TagKey<Block>) BlockTags.DIAMOND_ORES);
        COLORED_EMERALD_ORE_SCANNER = registerColoredScanner("emerald", "изумрудной", (TagKey<Block>) BlockTags.EMERALD_ORES);
        COLORED_GOLD_ORE_SCANNER = registerColoredScanner("gold", "золотой", (TagKey<Block>) BlockTags.GOLD_ORES);
        COLORED_IRON_ORE_SCANNER = registerColoredScanner("iron", "железной", (TagKey<Block>) BlockTags.IRON_ORES);
        COLORED_LAPIS_ORE_SCANNER = registerColoredScanner("lapis", "лазуритовой", (TagKey<Block>) BlockTags.LAPIS_ORES);
        COLORED_REDSTONE_ORE_SCANNER = registerColoredScanner("redstone", "редстоун", (TagKey<Block>) BlockTags.REDSTONE_ORES);
        COLORED_RUBIDIUM_ORE_SCANNER = registerColoredScanner("rubidium", "рубидиевой", MCTechTags.Ores.RUBIDIUM);
        COLORED_TIN_ORE_SCANNER = registerColoredScanner("tin", "оловянной", MCTechTags.Ores.TIN);
        COLORED_TITANIUM_ORE_SCANNER = registerColoredScanner("titanium", "титановой", MCTechTags.Ores.TITANIUM);
        COLORED_URANIUM_ORE_SCANNER = registerColoredScanner("uranium", "урановой", MCTechTags.Ores.URANIUM);
        COLORED_TUNGSTEN_ORE_SCANNER = registerColoredScanner("tungsten", "вольфрамовой", MCTechTags.Ores.TUNGSTEN);
        XRAY_GOGGLES = ITEM_REGISTRY.register("xray_goggles", () -> {
            return new d(new Item.Properties(), 512000, 32);
        }).setTranslation("X-ray goggles", "X-ray очки").setModelProvider((lItemModelProvider4, dataGenContext4) -> {
            GeckoData.item(lItemModelProvider4, dataGenContext4).transforms().transform(ItemDisplayContext.GUI).rotation(-145.0f, 45.0f, 180.0f).translation(0.0f, -22.75f, 0.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.GROUND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -23.5f, 0.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.HEAD).rotation(0.0f, 180.0f, 0.0f).translation(-7.75f, -5.5f, -9.75f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -25.75f, -3.5f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -13.75f, -2.0f).scale(0.55f, 0.55f, 0.55f).end().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -13.75f, -2.0f).scale(0.55f, 0.55f, 0.55f).end().transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(-149.0f, 93.0f, 145.0f).translation(5.0f, -13.0f, -4.25f).scale(0.55f, 0.55f, 0.55f).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(-149.0f, 93.0f, 145.0f).translation(5.0f, -13.0f, -4.25f).scale(0.55f, 0.55f, 0.55f).end().end();
        }).setTab(MCTechCreativeTabs.ARMOR);
        ADVANCED_XRAY_GOGGLES = ITEM_REGISTRY.register("advanced_xray_goggles", () -> {
            return new mctech.items.g.a.a.a(new Item.Properties(), 1024000, 64);
        }).setTranslation("Advanced X-ray goggles", "Улучшенные X-ray очки").setModelProvider((lItemModelProvider5, dataGenContext5) -> {
            GeckoData.item(lItemModelProvider5, dataGenContext5).transforms().transform(ItemDisplayContext.GUI).rotation(-145.0f, 45.0f, 180.0f).translation(0.0f, -22.75f, 0.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.GROUND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -23.5f, 0.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.HEAD).rotation(0.0f, 180.0f, 0.0f).translation(-7.75f, -5.5f, -9.75f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -25.75f, -3.5f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -13.75f, -2.0f).scale(0.55f, 0.55f, 0.55f).end().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -13.75f, -2.0f).scale(0.55f, 0.55f, 0.55f).end().transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(-149.0f, 93.0f, 145.0f).translation(5.0f, -13.0f, -4.25f).scale(0.55f, 0.55f, 0.55f).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(-149.0f, 93.0f, 145.0f).translation(5.0f, -13.0f, -4.25f).scale(0.55f, 0.55f, 0.55f).end().end();
        }).setTab(MCTechCreativeTabs.ARMOR);
        ASSEMBLY_STATION_PATTERN = ITEM_REGISTRY.registerItem("assembly_station_pattern", properties17 -> {
            return PatternDetailsHelper.encodedPatternItemBuilder((aEItemKey, level) -> {
                return new mctech.a.b.b.c(aEItemKey, (DataComponentType) MCTechDataComponent.ENCODED_ASSEMBLY_STATION_PATTERN.get(), level);
            }).invalidPatternTooltip(mctech.a.b.b.c::a).build();
        }).setModelProvider((lItemModelProvider6, dataGenContext6) -> {
            lItemModelProvider6.basicItem((Item) dataGenContext6.get(), MCTech.loc(String.format("item/%s", dataGenContext6.getName())));
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Assembly station pattern", "Шаблон сборочной станции");
        INDUSTRIAL_FORGE_PATTERN = ITEM_REGISTRY.registerItem("industrial_forge_pattern", properties18 -> {
            return PatternDetailsHelper.encodedPatternItemBuilder((aEItemKey, level) -> {
                return new mctech.a.b.b.c(aEItemKey, (DataComponentType) MCTechDataComponent.ENCODED_INDUSTRIAL_FORGE_PATTERN.get(), level);
            }).invalidPatternTooltip(mctech.a.b.b.c::a).build();
        }).setModelProvider((lItemModelProvider7, dataGenContext7) -> {
            lItemModelProvider7.basicItem((Item) dataGenContext7.get(), MCTech.loc(String.format("item/%s", dataGenContext7.getName())));
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Industrial forge pattern", "Шаблон промышленной кузни");
        QUANTUM_WORKBENCH_PATTERN = ITEM_REGISTRY.registerItem("quantum_workbench_pattern", properties19 -> {
            return PatternDetailsHelper.encodedPatternItemBuilder((aEItemKey, level) -> {
                return new mctech.a.b.b.c(aEItemKey, (DataComponentType) MCTechDataComponent.ENCODED_QUANTUM_WORKBENCH_PATTERN.get(), level);
            }).invalidPatternTooltip(mctech.a.b.b.c::a).build();
        }).setModelProvider((lItemModelProvider8, dataGenContext8) -> {
            lItemModelProvider8.basicItem((Item) dataGenContext8.get(), MCTech.loc(String.format("item/%s", dataGenContext8.getName())));
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Quantum workbench pattern", "Шаблон квантового сборщика");
        TRANSFORMATION_ASSEMBLER_PATTERN = ITEM_REGISTRY.registerItem("transformation_assembler_pattern", properties20 -> {
            return PatternDetailsHelper.encodedPatternItemBuilder((aEItemKey, level) -> {
                return new mctech.a.b.d.k(aEItemKey, (DataComponentType) MCTechDataComponent.ENCODED_TRANSFORMATION_ASSEMBLER_PATTERN.get(), level);
            }).invalidPatternTooltip(mctech.a.b.b.c::a).build();
        }).setModelProvider((lItemModelProvider9, dataGenContext9) -> {
            lItemModelProvider9.basicItem((Item) dataGenContext9.get(), MCTech.loc(String.format("item/%s", dataGenContext9.getName())));
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Transformation assembler pattern", "Шаблон преобразовательного сборщика");
        RAW_AMETHYST = rawMaterialItem("raw_amethyst", j::new, "Raw amethyst", "Рудный аметист", Set.of());
        RAW_ALUMINIUM = rawMaterialItem("raw_aluminium", j::new, "Raw aluminium", "Рудный алюминий", Set.of(MCTechTags.RAW_ALUMINIUM));
        RAW_TIN = rawMaterialItem("raw_tin", j::new, "Raw tin", "Рудное олово", Set.of(MCTechTags.RAW_TIN));
        RAW_RUBIDIUM = rawMaterialItem("raw_rubidium", j::new, "Raw rubidium", "Рудный рубидиум", Set.of(MCTechTags.RAW_RUBIDIUM));
        RAW_TITANIUM = rawMaterialItem("raw_titanium", j::new, "Raw titanium", "Рудный титан", Set.of(MCTechTags.RAW_TITANIUM));
        RAW_SILVER = rawMaterialItem("raw_silver", j::new, "Raw silver", "Рудное серебро", Set.of(MCTechTags.RAW_SILVER));
        DUST_IRON = materialItem("dust_iron", j::new);
        DUST_TIN = materialItem("dust_tin", j::new);
        DUST_COPPER = materialItem("dust_copper", j::new);
        DUST_SILVER = materialItem("dust_silver", j::new);
        DUST_GOLD = materialItem("dust_gold", j::new);
        DUST_BRONZE = materialItem("dust_bronze", j::new);
        DUST_ALUMINIUM = materialItem("dust_aluminium", j::new);
        DUST_CHARCOAL = materialItem("dust_charcoal", j::new);
        DUST_COAL = materialItem("dust_coal", j::new);
        DUST_CLAY = materialItem("dust_clay", j::new);
        DUST_NETHERRACK = materialItem("dust_netherrack", j::new);
        DUST_OBSIDIAN = materialItem("dust_obsidian", j::new);
        DUST_RARE_EARTH = materialItem("dust_rare_earth", j::new);
        DUST_DIAMOND = materialItem("dust_diamond", j::new);
        INGOT_TIN = materialItem("ingot_tin", j::new).addItemTags(new TagKey[]{MCTechTags.Nuggets.TIN});
        INGOT_SILVER = materialItem("ingot_silver", j::new).addItemTags(new TagKey[]{MCTechTags.Nuggets.SILVER});
        INGOT_REFINED_IRON = materialItem("ingot_refined_iron", j::new).addItemTags(new TagKey[]{MCTechTags.Nuggets.REFINED_IRON});
        INGOT_BRONZE = materialItem("ingot_bronze", j::new);
        INGOT_POLISHED_GOLD = materialItem("ingot_polished_gold", j::new).addItemTags(new TagKey[]{MCTechTags.Nuggets.POLISHED_GOLD});
        INGOT_ALUMINIUM = materialItem("ingot_aluminium", j::new).addItemTags(new TagKey[]{MCTechTags.Nuggets.ALUMINIUM});
        INGOT_ADVANCED_ALLOY = materialItem("ingot_advanced_alloy", j::new).addItemTags(new TagKey[]{MCTechTags.Nuggets.ADVANCED_ALLOY});
        INGOT_URANIUM = materialItem("ingot_uranium", j::new).addItemTags(new TagKey[]{MCTechTags.Nuggets.URANIUM});
        INGOT_URANIUM_ENRICHED_BLAZE = materialItem("ingot_uranium_enriched_blaze", j::new);
        INGOT_URANIUM_ENRICHED_CHARCOAL = materialItem("ingot_uranium_enriched_charcoal", j::new);
        INGOT_URANIUM_ENRICHED_ENDERPEARL = materialItem("ingot_uranium_enriched_enderpearl", j::new);
        INGOT_URANIUM_ENRICHED_NETHERSTAR = materialItem("ingot_uranium_enriched_netherstar", () -> {
            return new j(new mctech.items.base.o().a(true));
        });
        INGOT_URANIUM_ENRICHED_REDSTONE = materialItem("ingot_uranium_enriched_redstone", j::new);
        ORE_IRIDIUM = materialItem("ore_iridium", j::new);
        ORE_URANIUM_DROP = materialItem("ore_uranium", j::new);
        SCRAP = materialItem("scrap", j::new);
        SCRAP_METAL = materialItem("scrap_metal", j::new);
        UUMATTER = materialItem("uumatter", j::new);
        CARBON_FIBER = materialItem("carbon_fiber", j::new);
        CARBON_MESH = materialItem("carbon_mesh", j::new);
        PULSATING_QUARTZ = materialItem("pulsating_quartz", j::new);
        RARE_EARTH_CHUNK = materialItem("rare_earth_chunk", j::new);
        DEAD_MAGNET = materialItem("dead_magnet", j::new);
        MAGNET = materialItem("magnet", j::new);
        SCRAP_METAL_CHUNK = materialItem("scrap_metal_chunk", j::new);
        PLANT_BALL = materialItem("plant_ball", j::new);
        RUBBER = materialItem("rubber", j::new);
        CIRCUIT = materialItem("circuit", j::new);
        ADVANCED_CIRCUIT = materialItem("advanced_circuit", j::new);
        TIN_CAN = registerItem("tin_can", j::new, MCTechCreativeTabs.MATERIALS);
        TIN_CAN_FILLED = registerItem("filled_tin_can", mctech.items.misc.g::new, MCTechCreativeTabs.MATERIALS);
        UPGRADE_BASE = registerItem("upgrade_base", j::new, MCTechCreativeTabs.UPGRADES);
        OVERCLOCKER_UPGRADE = registerItem("upgrade_overclocker", () -> {
            return new mctech.items.f.i.a(MachineTier.T2, 1.4290000200271606d, 2.0d);
        }, MCTechCreativeTabs.UPGRADES);
        UPGRADE_COMPOSITE_OVERCLOCKER = registerItem("upgrade_composite_overclocker", () -> {
            return new mctech.items.f.i.a(MachineTier.T4, 1.5379999876022339d, 1.7999999523162842d);
        }, MCTechCreativeTabs.UPGRADES);
        UPGRADE_NANO_OVERCLOCKER = registerItem("upgrade_nano_overclocker", () -> {
            return new mctech.items.f.i.a(MachineTier.T5, 1.6670000553131104d, 1.5d);
        }, MCTechCreativeTabs.UPGRADES);
        UPGRADE_QUANTUM_OVERCLOCKER = registerItem("upgrade_quantum_overclocker", () -> {
            return new mctech.items.f.i.a(MachineTier.T6, 2.0d, 1.399999976158142d);
        }, MCTechCreativeTabs.UPGRADES);
        UPGRADE_SINGULAR_OVERCLOCKER = registerItem("upgrade_singular_overclocker", () -> {
            return new mctech.items.f.i.a(MachineTier.T7, 2.5d, 1.2000000476837158d);
        }, MCTechCreativeTabs.UPGRADES);
        UPGRADE_ADMIN_OVERCLOCKER = registerItem("upgrade_admin_overclocker", () -> {
            return new mctech.items.f.i.a(MachineTier.T8, 5.0d, 1.100000023841858d);
        }, MCTechCreativeTabs.UPGRADES);
        TRANSFORMER_UPGRADE = registerItem("upgrade_transformer", mctech.items.f.c.c::new, MCTechCreativeTabs.UPGRADES);
        ENERGY_STORAGE_UPGRADE = registerItem("upgrade_energy_storage", mctech.items.f.c.b::new, MCTechCreativeTabs.UPGRADES);
        ENERGY_STORAGE_MULTIPLIER_UPGRADE = registerItem("upgrade_energy_storage_multiplier", mctech.items.f.c.a::new, MCTechCreativeTabs.UPGRADES);
        REDSTONE_INVERTER_UPGRADE = registerItem("upgrade_redstone_inverter", mctech.items.f.g.a::new, MCTechCreativeTabs.UPGRADES);
        MUTE_UPGRADE = registerItem("upgrade_mute", mctech.items.f.a.a::new, MCTechCreativeTabs.UPGRADES);
        CREATIVE_UPGRADE = registerItem("upgrade_creative", mctech.items.f.h.a::new, MCTechCreativeTabs.UPGRADES);
        SAWBLADE_EFFICIENT_UPGRADE = registerItem("upgrade_efficient_sawblade", () -> {
            return new mctech.items.f.i.b(1000, 4, 1, 2);
        }, MCTechCreativeTabs.UPGRADES);
        SAWBLADE_DURABLE_UPGRADE = registerItem("upgrade_durable_sawblade", () -> {
            return new mctech.items.f.i.b(10000, 2, 2, 4);
        }, MCTechCreativeTabs.UPGRADES);
        WIDE_BAND_PAD_UPGRADE = registerItem("wide_band_booster_pad_upgrade", () -> {
            return new mctech.items.f.c(mctech.blockentities.c.b.WIDE_BAND);
        }, MCTechCreativeTabs.UPGRADES);
        BASIC_FIELD_PAD_UPGRADE = registerItem("basic_field_expansion_pad_upgrade", () -> {
            return new mctech.items.f.c(mctech.blockentities.c.b.FIELD_MK1);
        }, MCTechCreativeTabs.UPGRADES);
        FIELD_PAD_UPGRADE = registerItem("field_expansion_pad_upgrade", () -> {
            return new mctech.items.f.c(mctech.blockentities.c.b.FIELD_MK2);
        }, MCTechCreativeTabs.UPGRADES);
        ADVANCED_FIELD_PAD_UPGRADE = registerItem("advanced_field_expansion_pad_upgrade", () -> {
            return new mctech.items.f.c(mctech.blockentities.c.b.FIELD_MK3);
        }, MCTechCreativeTabs.UPGRADES);
        COMPLEX_HANDLER_UPDATE = registerItem("upgrade_complex_handler", mctech.items.f.a::new, MCTechCreativeTabs.UPGRADES);
        UPGRADE_SLOT_1 = ITEM_REGISTRY.registerItem("upgrade_slot_1", properties21 -> {
            return new mctech.items.f.b(1);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Slot upgrade T1", "Улучшение: Производительность Т1").setModelProvider((lItemModelProvider10, dataGenContext10) -> {
            lItemModelProvider10.basicItem((Item) dataGenContext10.get(), lItemModelProvider10.modLoc(String.format("item/upgrades/machines/%s", dataGenContext10.getName())));
        });
        UPGRADE_SLOT_2 = ITEM_REGISTRY.registerItem("upgrade_slot_2", properties22 -> {
            return new mctech.items.f.b(2);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Slot upgrade T2", "Улучшение: Производительность Т2").setModelProvider((lItemModelProvider11, dataGenContext11) -> {
            lItemModelProvider11.basicItem((Item) dataGenContext11.get(), lItemModelProvider11.modLoc(String.format("item/upgrades/machines/%s", dataGenContext11.getName())));
        });
        UPGRADE_SLOT_3 = ITEM_REGISTRY.registerItem("upgrade_slot_3", properties23 -> {
            return new mctech.items.f.b(3);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Slot upgrade T3", "Улучшение: Производительность Т3").setModelProvider((lItemModelProvider12, dataGenContext12) -> {
            lItemModelProvider12.basicItem((Item) dataGenContext12.get(), lItemModelProvider12.modLoc(String.format("item/upgrades/machines/%s", dataGenContext12.getName())));
        });
        UPGRADE_SLOT_4 = ITEM_REGISTRY.registerItem("upgrade_slot_4", properties24 -> {
            return new mctech.items.f.b(4);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Slot upgrade T4", "Улучшение: Производительность Т4").setModelProvider((lItemModelProvider13, dataGenContext13) -> {
            lItemModelProvider13.basicItem((Item) dataGenContext13.get(), lItemModelProvider13.modLoc(String.format("item/upgrades/machines/%s", dataGenContext13.getName())));
        });
        UPGRADE_FARMING_RADIUS_T1 = ITEM_REGISTRY.registerItem("upgrade_farming_radius_t1", properties25 -> {
            return new mctech.items.f.d.b(3);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Area expansion module T1", "Модуль расширения области Т1").setModelProvider((lItemModelProvider14, dataGenContext14) -> {
            lItemModelProvider14.basicItem((Item) dataGenContext14.get(), lItemModelProvider14.modLoc(String.format("item/upgrades/machines/%s", dataGenContext14.getName())));
        });
        UPGRADE_FARMING_RADIUS_T2 = ITEM_REGISTRY.registerItem("upgrade_farming_radius_t2", properties26 -> {
            return new mctech.items.f.d.b(4);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Area expansion module T2", "Модуль расширения области Т2").setModelProvider((lItemModelProvider15, dataGenContext15) -> {
            lItemModelProvider15.basicItem((Item) dataGenContext15.get(), lItemModelProvider15.modLoc(String.format("item/upgrades/machines/%s", dataGenContext15.getName())));
        });
        UPGRADE_FARMING_RADIUS_T3 = ITEM_REGISTRY.registerItem("upgrade_farming_radius_t3", properties27 -> {
            return new mctech.items.f.d.b(5);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Area expansion module T3", "Модуль расширения области Т3").setModelProvider((lItemModelProvider16, dataGenContext16) -> {
            lItemModelProvider16.basicItem((Item) dataGenContext16.get(), lItemModelProvider16.modLoc(String.format("item/upgrades/machines/%s", dataGenContext16.getName())));
        });
        UPGRADE_FARMING_FERTILIZER_T1 = ITEM_REGISTRY.registerItem("upgrade_farming_fertilizer_t1", properties28 -> {
            return new mctech.items.f.d.a(1);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Fertilizer module T1", "Модуль удобрения Т1").setModelProvider((lItemModelProvider17, dataGenContext17) -> {
            lItemModelProvider17.basicItem((Item) dataGenContext17.get(), lItemModelProvider17.modLoc(String.format("item/upgrades/machines/%s", dataGenContext17.getName())));
        });
        UPGRADE_FARMING_FERTILIZER_T2 = ITEM_REGISTRY.registerItem("upgrade_farming_fertilizer_t2", properties29 -> {
            return new mctech.items.f.d.a(2);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Fertilizer module T2", "Модуль удобрения Т2").setModelProvider((lItemModelProvider18, dataGenContext18) -> {
            lItemModelProvider18.basicItem((Item) dataGenContext18.get(), lItemModelProvider18.modLoc(String.format("item/upgrades/machines/%s", dataGenContext18.getName())));
        });
        UPGRADE_FARMING_FERTILIZER_T3 = ITEM_REGISTRY.registerItem("upgrade_farming_fertilizer_t3", properties30 -> {
            return new mctech.items.f.d.a(3);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Fertilizer module T3", "Модуль удобрения Т3").setModelProvider((lItemModelProvider19, dataGenContext19) -> {
            lItemModelProvider19.basicItem((Item) dataGenContext19.get(), lItemModelProvider19.modLoc(String.format("item/upgrades/machines/%s", dataGenContext19.getName())));
        });
        LIQUID_COOLANT_UPGRADE = ITEM_REGISTRY.register("upgrade_liquid_coolant", mctech.items.f.e.b::new).setTranslation("Liquid Coolant Upgrade", "Улучшение: Жидкостное охлаждение").setModelProvider((lItemModelProvider20, dataGenContext20) -> {
            lItemModelProvider20.basicItem((Item) dataGenContext20.get(), MCTech.loc(String.format("item/upgrades/machines/%s", dataGenContext20.getName())));
        }).setTab(MCTechCreativeTabs.UPGRADES);
        ENRICHMENT_UPGRADE = ITEM_REGISTRY.register("upgrade_enrichment", mctech.items.f.e.a::new).setTranslation("Enrichment Upgrade", "Улучшение: Обогатитель").setModelProvider((lItemModelProvider21, dataGenContext21) -> {
            lItemModelProvider21.basicItem((Item) dataGenContext21.get(), MCTech.loc(String.format("item/upgrades/machines/%s", dataGenContext21.getName())));
        }).setTab(MCTechCreativeTabs.UPGRADES);
        STICKY_RESIN = registerItem("sticky_resin", mctech.items.misc.d::new, MCTechCreativeTabs.MATERIALS).defaultModel();
        TREETAP = registerItem("tree_tap", k::new, MCTechCreativeTabs.TOOLS);
        WRENCH = registerItem("wrench", m::new, MCTechCreativeTabs.TOOLS).addItemTags(new TagKey[]{MCTechTags.Tools.WRENCH});
        ELECTRIC_WRENCH = registerItem("electric_wrench", mctech.items.e.a.f::new, MCTechCreativeTabs.TOOLS).addItemTags(new TagKey[]{MCTechTags.Tools.WRENCH});
        PRECISION_WRENCH = registerItem("precision_wrench", mctech.items.e.a.f.a::new, MCTechCreativeTabs.TOOLS).addItemTags(new TagKey[]{MCTechTags.Tools.WRENCH});
        DESTROYER = ITEM_REGISTRY.register("destroyer", () -> {
            return new h(new Item.Properties(), mctech.h.a.e.a.get("destroyer"));
        }).setTranslation("Destroyer", "Крушитель").addItemTags(new TagKey[]{MCTechTags.Tools.BLOCK_WG_INTERACT}).setModelProvider((lItemModelProvider22, dataGenContext22) -> {
            GeckoData.item(lItemModelProvider22, dataGenContext22).transforms().transform(ItemDisplayContext.GUI).rotation(-90.0f, 45.0f, 90.0f).translation(2.0f, -1.0f, 0.0f).scale(0.55f, 0.55f, 0.55f).end().transform(ItemDisplayContext.GROUND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, 5.0f, 0.0f).scale(0.43f, 0.43f, 0.43f).end().transform(ItemDisplayContext.HEAD).rotation(0.0f, 180.0f, 0.0f).translation(-7.75f, -5.5f, -9.75f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.FIXED).rotation(-90.0f, -180.0f, 90.0f).translation(-2.5f, 0.0f, 0.75f).scale(0.55f, 0.55f, 0.55f).end().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(0.0f, -180.0f, 0.0f).translation(1.5f, -3.5f, -7.75f).scale(0.55f, 0.55f, 0.55f).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(0.0f, -180.0f, 0.0f).translation(-1.25f, -3.5f, -7.75f).scale(0.55f, 0.55f, 0.55f).end().transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0.0f, 180.0f, 0.0f).translation(3.0f, -4.75f, -8.5f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0.0f, -180.0f, 0.0f).translation(3.0f, -4.75f, -8.5f).scale(1.0f, 1.0f, 1.0f).end().end();
        }).addItemTags(new TagKey[]{MCTechTags.Tools.TOOLS}).setTab(MCTechCreativeTabs.TOOLS);
        ADVANCED_DESTROYER = ITEM_REGISTRY.register("advanced_destroyer", () -> {
            return new g(new Item.Properties(), mctech.h.a.e.a.get("advanced_destroyer"));
        }).setTranslation("Advanced Destroyer", "Улучшенный крушитель").addItemTags(new TagKey[]{MCTechTags.Tools.TOOLS, MCTechTags.Tools.BLOCK_WG_INTERACT}).setModelProvider((lItemModelProvider23, dataGenContext23) -> {
            GeckoData.item(lItemModelProvider23, dataGenContext23).transforms().transform(ItemDisplayContext.GUI).rotation(-90.0f, 45.0f, 90.0f).translation(2.0f, -1.0f, 0.0f).scale(0.55f, 0.55f, 0.55f).end().transform(ItemDisplayContext.GROUND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, 5.0f, 0.0f).scale(0.43f, 0.43f, 0.43f).end().transform(ItemDisplayContext.HEAD).rotation(0.0f, 180.0f, 0.0f).translation(-7.75f, -5.5f, -9.75f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.FIXED).rotation(-90.0f, -180.0f, 90.0f).translation(-2.5f, 0.0f, 0.75f).scale(0.55f, 0.55f, 0.55f).end().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(0.0f, -180.0f, 0.0f).translation(1.5f, -3.5f, -7.75f).scale(0.55f, 0.55f, 0.55f).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(0.0f, -180.0f, 0.0f).translation(-1.25f, -3.5f, -7.75f).scale(0.55f, 0.55f, 0.55f).end().transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0.0f, 180.0f, 0.0f).translation(3.0f, -4.75f, -8.5f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0.0f, -180.0f, 0.0f).translation(3.0f, -4.75f, -8.5f).scale(1.0f, 1.0f, 1.0f).end().end();
        }).setTab(MCTechCreativeTabs.TOOLS);
        CHAINSAW = ITEM_REGISTRY.register("chainsaw", () -> {
            return new mctech.items.e.a.c(new Item.Properties(), mctech.h.a.e.b.get("chainsaw"));
        }).setTranslation("Chainsaw", "Электро-пила").setModelProvider((lItemModelProvider24, dataGenContext24) -> {
            GeckoData.item(lItemModelProvider24, dataGenContext24).transforms().transform(ItemDisplayContext.GUI).rotation(90.0f, -45.0f, 90.0f).translation(0.0f, -3.0f, 0.0f).scale(0.8f, 0.8f, 0.8f).end().transform(ItemDisplayContext.GROUND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, 0.0f, 0.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.HEAD).rotation(0.0f, 0.0f, 0.0f).translation(-10.5f, -5.25f, 0.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.FIXED).rotation(0.0f, 90.0f, 0.0f).translation(3.0f, -2.5f, 0.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(90.0f, 0.0f, 0.0f).translation(0.0f, 1.75f, -7.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(90.0f, 0.0f, 0.0f).translation(0.0f, 1.75f, -7.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(30.0f, 0.0f, 0.0f).translation(2.5f, -1.25f, -5.5f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(30.0f, 0.0f, 0.0f).translation(2.5f, -1.25f, -5.5f).scale(1.0f, 1.0f, 1.0f).end().end();
        }).addItemTags(new TagKey[]{MCTechTags.Tools.TOOLS, MCTechTags.Tools.BLOCK_WG_INTERACT}).setTab(MCTechCreativeTabs.TOOLS);
        ADVANCED_CHAINSAW = ITEM_REGISTRY.register("advanced_chainsaw", () -> {
            return new mctech.items.e.a.c(new Item.Properties(), mctech.h.a.e.b.get("advanced_chainsaw"));
        }).setTranslation("Advanced Chainsaw", "Улучшенная электро-пила").setModelProvider((lItemModelProvider25, dataGenContext25) -> {
            GeckoData.item(lItemModelProvider25, dataGenContext25).transforms().transform(ItemDisplayContext.GUI).rotation(90.0f, -45.0f, 90.0f).translation(0.0f, -3.0f, 0.0f).scale(0.8f, 0.8f, 0.8f).end().transform(ItemDisplayContext.GROUND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, 0.0f, 0.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.HEAD).rotation(0.0f, 0.0f, 0.0f).translation(-10.5f, -5.25f, 0.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.FIXED).rotation(0.0f, 90.0f, 0.0f).translation(3.0f, -2.5f, 0.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(90.0f, 0.0f, 0.0f).translation(0.0f, 1.75f, -7.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(90.0f, 0.0f, 0.0f).translation(0.0f, 1.75f, -7.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(30.0f, 0.0f, 0.0f).translation(2.5f, -1.25f, -5.5f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(30.0f, 0.0f, 0.0f).translation(2.5f, -1.25f, -5.5f).scale(1.0f, 1.0f, 1.0f).end().end();
        }).addItemTags(new TagKey[]{MCTechTags.Tools.TOOLS, MCTechTags.Tools.BLOCK_WG_INTERACT}).setTab(MCTechCreativeTabs.TOOLS);
        HAZMAT_HELMET = registerItem("armor_hazmat_helmet", () -> {
            return new mctech.items.g.a.b(ArmorItem.Type.HELMET);
        }, MCTechCreativeTabs.ARMOR);
        HAZMAT_CHEST = registerItem("armor_hazmat_chest", () -> {
            return new mctech.items.g.a.b(ArmorItem.Type.CHESTPLATE);
        }, MCTechCreativeTabs.ARMOR);
        HAZMAT_LEGGINGS = registerItem("armor_hazmat_leggings", () -> {
            return new mctech.items.g.a.b(ArmorItem.Type.LEGGINGS);
        }, MCTechCreativeTabs.ARMOR);
        HAZMAT_BOOTS = registerItem("armor_hazmat_boots", () -> {
            return new mctech.items.g.a.b(ArmorItem.Type.BOOTS);
        }, MCTechCreativeTabs.ARMOR);
        NIGHT_VISION_HELMET = registerItem("nightvision_goggles", mctech.items.g.a.a.c::new, MCTechCreativeTabs.ARMOR);
        JETPACK = registerItem("jetpack", () -> {
            return new mctech.items.g.c.b(1, 2500000, 1, 6250, mctech.items.g.b.h.a.NONE, false);
        }, MCTechCreativeTabs.ARMOR);
        ADVANCED_JETPACK = registerItem("advanced_jetpack", () -> {
            return new mctech.items.g.c.b(2, 6000000, 2, 15000, mctech.items.g.b.h.a.BASIC, false);
        }, MCTechCreativeTabs.ARMOR);
        GRAVITATION_JETPACK = registerItem("gravitation_jetpack", () -> {
            return new mctech.items.g.c.b(3, 13500000, 3, 33750, mctech.items.g.b.h.a.ADV, false);
        }, MCTechCreativeTabs.ARMOR);
        ROCKET_GRAVITATION_JETPACK = registerItem("rocket_gravitation_jetpack", () -> {
            return new mctech.items.g.c.b(4, 35000000, 4, 87500, mctech.items.g.b.h.a.ADV, true);
        }, MCTechCreativeTabs.ARMOR);
        OBSCURATOR = registerItem("obscurator", i::new, MCTechCreativeTabs.TOOLS);
        ELECTRIC_TREETAP = registerItem("electric_tree_tap", e::new, MCTechCreativeTabs.TOOLS);
        ADVANCED_TREETAP = registerItem("advanced_tree_tap", mctech.items.e.a.b::new, MCTechCreativeTabs.TOOLS);
        ELECTRIC_HOE = registerItem("electric_hoe", mctech.items.e.a.d::new, MCTechCreativeTabs.TOOLS);
        ADVANCED_HOE = registerItem("advanced_hoe", mctech.items.e.a.a::new, MCTechCreativeTabs.TOOLS);
        EU_READER = registerItem("eu_reader", mctech.items.e.e::new, MCTechCreativeTabs.TOOLS);
        FREQUENCY_TRANSMITTER = ITEM_REGISTRY.registerItem("frequency_transmitter", properties31 -> {
            return new mctech.items.e.f();
        }).setTranslation("Frequency transmitter", "Частотный передатчик").addItemTags(new TagKey[]{MCTechTags.Tools.BLOCK_WG_INTERACT}).setModelProvider((lItemModelProvider26, dataGenContext26) -> {
            lItemModelProvider26.basicItem((Item) dataGenContext26.get(), MCTech.loc(String.format("item/tools/%s", dataGenContext26.getName())));
        }).setTab(MCTechCreativeTabs.TOOLS);
        RE_BATTERY = registerItem("re_battery", () -> {
            return new mctech.items.misc.a(10000, 100, 1, true, true);
        }, MCTechCreativeTabs.ENERGY);
        WINDMILL_ROTOR_T1 = registerWindmillRotor(A.T1);
        WINDMILL_ROTOR_T2 = registerWindmillRotor(A.T2);
        WINDMILL_ROTOR_T3 = registerWindmillRotor(A.T3);
        WINDMILL_ROTOR_T4 = registerWindmillRotor(A.T4);
        WINDMILL_ROTOR_T5 = registerWindmillRotor(A.T5);
        WINDMILL_ROTOR_T6 = registerWindmillRotor(A.T6);
        WINDMILL_ROTOR_T7 = registerWindmillRotor(A.T7);
        WINDMILL_ROTOR_T8 = registerWindmillRotor(A.T8);
        GENETIC_MATERIAL = ITEM_REGISTRY.register("genetic_material", mctech.items.c.b::new).setTab(MCTechCreativeTabs.MATERIALS).setTranslation("Genetic material", "Генетический материал").setModelProvider((lItemModelProvider27, dataGenContext27) -> {
            lItemModelProvider27.basicItem((Item) dataGenContext27.get(), MCTech.loc(String.format("item/%s", dataGenContext27.getName())));
        });
        EMPTY_VIAL = ITEM_REGISTRY.register("empty_vial", () -> {
            return new j(new mctech.items.base.o());
        }).setTab(MCTechCreativeTabs.MATERIALS).setTranslation("Empty vial", "Пустая пробирка").setModelProvider((lItemModelProvider28, dataGenContext28) -> {
            lItemModelProvider28.basicItem((Item) dataGenContext28.get(), MCTech.loc(String.format("item/%s", dataGenContext28.getName())));
        });
        DNA_SAMPLE = ITEM_REGISTRY.register("dna_sample", mctech.items.c.a::new).setTab(MCTechCreativeTabs.MATERIALS).setTranslation("DNA Sample", "Образец ДНК").setModelProvider((lItemModelProvider29, dataGenContext29) -> {
            lItemModelProvider29.basicItem((Item) dataGenContext29.get(), MCTech.loc(String.format("item/%s", dataGenContext29.getName())));
        });
        ENERGY_CRYSTAL = registerItem("energy_crystal", () -> {
            return new mctech.items.base.h(mctech.h.a.b.a.get(MachineTier.T2));
        }, MCTechCreativeTabs.ENERGY);
        ADVANCED_ENERGY_CRYSTAL = registerItem("advanced_energy_crystal", () -> {
            return new mctech.items.base.h(mctech.h.a.b.a.get(MachineTier.T3));
        }, MCTechCreativeTabs.ENERGY);
        COMPOSITE_ENERGY_CRYSTAL = registerItem("composite_energy_crystal", () -> {
            return new mctech.items.base.h(mctech.h.a.b.a.get(MachineTier.T4));
        }, MCTechCreativeTabs.ENERGY);
        NANO_ENERGY_CRYSTAL = registerItem("nano_energy_crystal", () -> {
            return new mctech.items.base.h(mctech.h.a.b.a.get(MachineTier.T5));
        }, MCTechCreativeTabs.ENERGY);
        QUANTUM_ENERGY_CRYSTAL = registerItem("quantum_energy_crystal", () -> {
            return new mctech.items.base.h(mctech.h.a.b.a.get(MachineTier.T6));
        }, MCTechCreativeTabs.ENERGY);
        SINGULARITY_ENERGY_CRYSTAL = registerItem("singularity_energy_crystal", () -> {
            return new mctech.items.base.h(mctech.h.a.b.a.get(MachineTier.T7));
        }, MCTechCreativeTabs.ENERGY);
        RUBIDIUM_ENERGY_CRYSTAL = registerItem("rubidium_energy_crystal", () -> {
            return new mctech.items.base.h(mctech.h.a.b.a.get(MachineTier.T8));
        }, MCTechCreativeTabs.ENERGY);
        ENERGY_LAPPACK = registerItem("energy_lappack", () -> {
            return new mctech.items.g.a.a.b(mctech.h.a.b.b.get(MachineTier.T2), 1, 1);
        }, MCTechCreativeTabs.ARMOR);
        ADVANCED_ENERGY_LAPPACK = registerItem("advanced_energy_lappack", () -> {
            return new mctech.items.g.a.a.b(Rarity.UNCOMMON, mctech.h.a.b.b.get(MachineTier.T3), 2, 2);
        }, MCTechCreativeTabs.ARMOR);
        COMPOSITE_ENERGY_LAPPACK = registerItem("composite_energy_lappack", () -> {
            return new mctech.items.g.a.a.b(Rarity.UNCOMMON, mctech.h.a.b.b.get(MachineTier.T4), 3, 3);
        }, MCTechCreativeTabs.ARMOR);
        NANO_ENERGY_LAPPACK = registerItem("nano_energy_lappack", () -> {
            return new mctech.items.g.a.a.b(Rarity.RARE, mctech.h.a.b.b.get(MachineTier.T5), 3, 4);
        }, MCTechCreativeTabs.ARMOR);
        QUANTUM_ENERGY_LAPPACK = registerItem("quantum_energy_lappack", () -> {
            return new mctech.items.g.a.a.b(Rarity.RARE, mctech.h.a.b.b.get(MachineTier.T6), 3, 5);
        }, MCTechCreativeTabs.ARMOR);
        SINGULARITY_ENERGY_LAPPACK = registerItem("singularity_energy_lappack", () -> {
            return new mctech.items.g.a.a.b(Rarity.EPIC, mctech.h.a.b.b.get(MachineTier.T7), 3, 6);
        }, MCTechCreativeTabs.ARMOR);
        RUBIDIUM_ENERGY_LAPPACK = registerItem("rubidium_energy_lappack", () -> {
            return new mctech.items.g.a.a.b(Rarity.EPIC, mctech.h.a.b.b.get(MachineTier.T8), 3, 7);
        }, MCTechCreativeTabs.ARMOR);
        FLUID_DISPLAY = registerItemHidden("fluid_display", mctech.items.misc.b::new);
        TAG_ITEM = registerItemHidden("tag_item", mctech.items.misc.f::new);
        TAG_BLOCK = registerItemHidden("tag_block", mctech.items.misc.e::new);
        CONDENSATOR = registerItem("condensator", () -> {
            return new mctech.items.d.c(20000, 15);
        }, MCTechCreativeTabs.NUCLEAR);
        CONDENSATOR_LAP = registerItem("condensator_lap", () -> {
            return new mctech.items.d.c(C0074u.e, 16);
        }, MCTechCreativeTabs.NUCLEAR);
        FUEL_PELLET_T1 = registerItem("fuel_pellet_t1", () -> {
            return new mctech.items.d.a(b.T1);
        }, MCTechCreativeTabs.NUCLEAR);
        FUEL_PELLET_T2 = registerItem("fuel_pellet_t2", () -> {
            return new mctech.items.d.a(b.T2);
        }, MCTechCreativeTabs.NUCLEAR);
        FUEL_PELLET_T3 = registerItem("fuel_pellet_t3", () -> {
            return new mctech.items.d.a(b.T3);
        }, MCTechCreativeTabs.NUCLEAR);
        FUEL_PELLET_T4 = registerItem("fuel_pellet_t4", () -> {
            return new mctech.items.d.a(b.T4);
        }, MCTechCreativeTabs.NUCLEAR);
        FUEL_PELLET_T5 = registerItem("fuel_pellet_t5", () -> {
            return new mctech.items.d.a(b.T5);
        }, MCTechCreativeTabs.NUCLEAR);
        PLATING = registerItem("plating", () -> {
            return new mctech.items.d.m(1000, 0.95f, 31);
        }, MCTechCreativeTabs.NUCLEAR);
        PLATING_HEAT_CAPACITY = registerItem("plating_heat_capacity", () -> {
            return new mctech.items.d.m(mctech.blockentities.b.k.i, 0.99f, 33);
        }, MCTechCreativeTabs.NUCLEAR);
        PLATING_CONTAINMENT = registerItem("plating_containment", () -> {
            return new mctech.items.d.m(500, 0.9f, 32);
        }, MCTechCreativeTabs.NUCLEAR);
        REFLECTOR = registerItem("reflector", () -> {
            return new n(10000, false, 34);
        }, MCTechCreativeTabs.NUCLEAR);
        REFLECTOR_THICK = registerItem("reflector_thick", () -> {
            return new n(40000, false, 35);
        }, MCTechCreativeTabs.NUCLEAR);
        REFLECTOR_IRIDIUM = registerItem("reflector_iridium", mctech.items.d.k::new, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_NEAR_DEPLETED = registerItem("uranium_rod_near_depleted", j::new, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_NEAR_DEPLETED_REDSTONE = registerItem("uranium_rod_near_depleted_redstone", j::new, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_NEAR_DEPLETED_BLAZE = registerItem("uranium_rod_near_depleted_blaze", j::new, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_NEAR_DEPLETED_ENDER_PEARL = registerItem("uranium_rod_near_depleted_ender_pearl", j::new, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_NEAR_DEPLETED_NETHER_STAR = registerItem("uranium_rod_near_depleted_nether_star", j::new, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_NEAR_DEPLETED_CHARCOAL = registerItem("uranium_rod_near_depleted_charcoal", j::new, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_RE_ENRICHED = registerItem("uranium_rod_re_enriched", j::new, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_RE_ENRICHED_REDSTONE = registerItem("uranium_rod_re_enriched_redstone", j::new, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_RE_ENRICHED_BLAZE = registerItem("uranium_rod_re_enriched_blaze", j::new, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_RE_ENRICHED_ENDER_PEARL = registerItem("uranium_rod_re_enriched_ender_pearl", j::new, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_RE_ENRICHED_NETHER_STAR = registerItem("uranium_rod_re_enriched_nether_star", j::new, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_RE_ENRICHED_CHARCOAL = registerItem("uranium_rod_re_enriched_charcoal", j::new, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_SINGLE = registerItem("uranium_rod_single", () -> {
            return new o(mctech.items.d.c.f.a, 1, 0);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_REDSTONE_SINGLE = registerItem("uranium_rod_redstone_single", () -> {
            return new o(mctech.items.d.c.e.a, 1, 3);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_BLAZE_SINGLE = registerItem("uranium_rod_blaze_single", () -> {
            return new o(mctech.items.d.c.a.a, 1, 6);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_ENDER_PEARL_SINGLE = registerItem("uranium_rod_ender_pearl_single", () -> {
            return new o(mctech.items.d.c.c.a, 1, 9);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_NETHER_STAR_SINGLE = registerItem("uranium_rod_nether_star_single", () -> {
            return new o(mctech.items.d.c.d.a, 1, 37);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_CHARCOAL_SINGLE = registerItem("uranium_rod_charcoal_single", () -> {
            return new o(mctech.items.d.c.b.a, 1, 40);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_DUAL = registerItem("uranium_rod_dual", () -> {
            return new o(mctech.items.d.c.f.a, 2, 1);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_REDSTONE_DUAL = registerItem("uranium_rod_redstone_dual", () -> {
            return new o(mctech.items.d.c.e.a, 2, 4);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_BLAZE_DUAL = registerItem("uranium_rod_blaze_dual", () -> {
            return new o(mctech.items.d.c.a.a, 2, 7);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_ENDER_PEARL_DUAL = registerItem("uranium_rod_ender_pearl_dual", () -> {
            return new o(mctech.items.d.c.c.a, 2, 10);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_NETHER_STAR_DUAL = registerItem("uranium_rod_nether_star_dual", () -> {
            return new o(mctech.items.d.c.d.a, 2, 38);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_CHARCOAL_DUAL = registerItem("uranium_rod_charcoal_dual", () -> {
            return new o(mctech.items.d.c.b.a, 2, 41);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_QUAD = registerItem("uranium_rod_quad", () -> {
            return new o(mctech.items.d.c.f.a, 4, 2);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_REDSTONE_QUAD = registerItem("uranium_rod_redstone_quad", () -> {
            return new o(mctech.items.d.c.e.a, 4, 5);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_BLAZE_QUAD = registerItem("uranium_rod_blaze_quad", () -> {
            return new o(mctech.items.d.c.a.a, 4, 8);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_ENDER_PEARL_QUAD = registerItem("uranium_rod_ender_pearl_quad", () -> {
            return new o(mctech.items.d.c.c.a, 4, 11);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_NETHER_STAR_QUAD = registerItem("uranium_rod_nether_star_quad", () -> {
            return new o(mctech.items.d.c.d.a, 4, 39);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_CHARCOAL_QUAD = registerItem("uranium_rod_charcoal_quad", () -> {
            return new o(mctech.items.d.c.b.a, 4, 42);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_ISOTOPIC = registerItem("uranium_rod_isotopic", () -> {
            return new l(mctech.items.d.c.f.a, 36);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_ISOTOPIC_REDSTONE = registerItem("uranium_rod_isotopic_redstone", () -> {
            return new l(mctech.items.d.c.e.a, 43);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_ISOTOPIC_BLAZE = registerItem("uranium_rod_isotopic_blaze", () -> {
            return new l(mctech.items.d.c.a.a, 44);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_ISOTOPIC_ENDER_PEARL = registerItem("uranium_rod_isotopic_ender_pearl", () -> {
            return new l(mctech.items.d.c.c.a, 45);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_ISOTOPIC_NETHER_STAR = registerItem("uranium_rod_isotopic_nether_star", () -> {
            return new l(mctech.items.d.c.d.a, 46);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_ROD_ISOTOPIC_CHARCOAL = registerItem("uranium_rod_isotopic_charcoal", () -> {
            return new l(mctech.items.d.c.b.a, 47);
        }, MCTechCreativeTabs.NUCLEAR);
        URANIUM_FUEL = registerConsumable("uranium", Consumables.FUEL, () -> {
            return new mctech.items.b.a(10, 800);
        }).setTranslation("Uranium fuel", "Урановый стержень");
        COMBINED_URANIUM_FUEL = registerConsumable("combined_uranium", Consumables.FUEL, () -> {
            return new mctech.items.b.a(20, 700);
        }).setTranslation("Combined uranium fuel", "Объединенный урановый стержень");
        ISOTOPIC_FUEL = registerConsumable("isotopic", Consumables.FUEL, () -> {
            return new mctech.items.b.a(40, 600);
        }).setTranslation("Isotopic fuel", "Изотопное топливо");
        COMPOSITE_FUEL = registerConsumable("composite", Consumables.FUEL, () -> {
            return new mctech.items.b.a(80, 500);
        }).setTranslation("Composite fuel", "Композитное топливо");
        NANO_FUEL = registerConsumable("nano", Consumables.FUEL, () -> {
            return new mctech.items.b.a(100, 400);
        }).setTranslation("Nano fuel", "Нано топливо");
        QUANTUM_FUEL = registerConsumable("quantum", Consumables.FUEL, () -> {
            return new mctech.items.b.a(150, 300);
        }).setTranslation("Quantum fuel", "Квантовое топливо");
        SINGULARITY_FUEL = registerConsumable("singularity", Consumables.FUEL, () -> {
            return new mctech.items.b.a(200, 20);
        }).setTranslation("Meta fuel", "Мета топливо");
        RUBIDIUM_FUEL = registerConsumable("rubidium", Consumables.FUEL, () -> {
            return new mctech.items.b.a(0, 20, true);
        }).setTranslation("Omega fuel", "Омега топливо");
        BASIC_CATALYST = registerConsumable("basic", Consumables.CATALYST, () -> {
            return new mctech.items.b.b(new Item.Properties(), Consumables.CATALYST, 5000);
        }).setTranslation("Basic stabilizer", "Базовый стабилизатор");
        ISOTOPIC_CATALYST = registerConsumable("isotopic", Consumables.CATALYST, () -> {
            return new mctech.items.b.b(new Item.Properties(), Consumables.CATALYST, 10000);
        }).setTranslation("Isotopic stabilizer", "Изотопный стабилизатор");
        COMPOSITE_CATALYST = registerConsumable("composite", Consumables.CATALYST, () -> {
            return new mctech.items.b.b(new Item.Properties(), Consumables.CATALYST, 15000);
        }).setTranslation("Composite stabilizer", "Композитный стабилизатор");
        NANO_CATALYST = registerConsumable("nano", Consumables.CATALYST, () -> {
            return new mctech.items.b.b(new Item.Properties(), Consumables.CATALYST, 20000);
        }).setTranslation("Nano stabilizer", "Нано стабилизатор");
        QUANTUM_CATALYST = registerConsumable("quantum", Consumables.CATALYST, () -> {
            return new mctech.items.b.b(new Item.Properties(), Consumables.CATALYST, 25000);
        }).setTranslation("Quantum", "Квантовый стабилизатор");
        SINGULARITY_CATALYST = registerConsumable("singularity", Consumables.CATALYST, () -> {
            return new mctech.items.b.b(new Item.Properties(), Consumables.CATALYST, 50000);
        }).setTranslation("Meta stabilizer", "Мета стабилизатор");
        RUBIDIUM_CATALYST = registerConsumable("rubidium", Consumables.CATALYST, () -> {
            return new mctech.items.b.b(new Item.Properties(), Consumables.CATALYST, 0, true);
        }).setTranslation("Omega stabilizer", "Омега стабилизатор");
        SCRAPBOX = registerItem("scrap_box", mctech.items.misc.c::new, MCTechCreativeTabs.MATERIALS);
        GEN_DAY_1 = registerItem("gen_day_1", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.DAY).a(Float.valueOf(1.1f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_DAY_2 = registerItem("gen_day_2", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.DAY).a(Float.valueOf(1.2f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_DAY_3 = registerItem("gen_day_3", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.DAY).a(Float.valueOf(1.3f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_DAY_4 = registerItem("gen_day_4", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.DAY).a(Float.valueOf(1.4f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_DAY_5 = registerItem("gen_day_5", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.DAY).a(Float.valueOf(1.5f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_DAY_6 = registerItem("gen_day_6", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.DAY).a(Float.valueOf(1.6f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_DAY_7 = registerItem("gen_day_7", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.DAY).a(Float.valueOf(1.7f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_DAY_8 = registerItem("gen_day_8", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.DAY).a(Float.valueOf(1.8f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_DAY_9 = registerItem("gen_day_9", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.DAY).a(Float.valueOf(1.9f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_DAY_10 = registerItem("gen_day_10", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.DAY).a(Float.valueOf(2.0f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_NIGHT_1 = registerItem("gen_night_1", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.NIGHT).a(Float.valueOf(1.1f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_NIGHT_2 = registerItem("gen_night_2", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.NIGHT).a(Float.valueOf(1.2f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_NIGHT_3 = registerItem("gen_night_3", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.NIGHT).a(Float.valueOf(1.3f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_NIGHT_4 = registerItem("gen_night_4", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.NIGHT).a(Float.valueOf(1.4f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_NIGHT_5 = registerItem("gen_night_5", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.NIGHT).a(Float.valueOf(1.5f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_NIGHT_6 = registerItem("gen_night_6", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.NIGHT).a(Float.valueOf(1.6f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_NIGHT_7 = registerItem("gen_night_7", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.NIGHT).a(Float.valueOf(1.7f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_NIGHT_8 = registerItem("gen_night_8", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.NIGHT).a(Float.valueOf(1.8f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_NIGHT_9 = registerItem("gen_night_9", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.NIGHT).a(Float.valueOf(1.9f)).a();
        }, MCTechCreativeTabs.ENERGY);
        GEN_NIGHT_10 = registerItem("gen_night_10", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.NIGHT).a(Float.valueOf(2.0f)).a();
        }, MCTechCreativeTabs.ENERGY);
        UNIVERSAL_GEN_1 = registerItem("universal_gen_1", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.UNIVERSAL_GEN).a(Float.valueOf(1.1f)).a();
        }, MCTechCreativeTabs.ENERGY);
        UNIVERSAL_GEN_2 = registerItem("universal_gen_2", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.UNIVERSAL_GEN).a(Float.valueOf(1.2f)).a();
        }, MCTechCreativeTabs.ENERGY);
        UNIVERSAL_GEN_3 = registerItem("universal_gen_3", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.UNIVERSAL_GEN).a(Float.valueOf(1.3f)).a();
        }, MCTechCreativeTabs.ENERGY);
        UNIVERSAL_GEN_4 = registerItem("universal_gen_4", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.UNIVERSAL_GEN).a(Float.valueOf(1.4f)).a();
        }, MCTechCreativeTabs.ENERGY);
        UNIVERSAL_GEN_5 = registerItem("universal_gen_5", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.UNIVERSAL_GEN).a(Float.valueOf(1.5f)).a();
        }, MCTechCreativeTabs.ENERGY);
        UNIVERSAL_GEN_6 = registerItem("universal_gen_6", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.UNIVERSAL_GEN).a(Float.valueOf(1.6f)).a();
        }, MCTechCreativeTabs.ENERGY);
        UNIVERSAL_GEN_7 = registerItem("universal_gen_7", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.UNIVERSAL_GEN).a(Float.valueOf(1.7f)).a();
        }, MCTechCreativeTabs.ENERGY);
        UNIVERSAL_GEN_8 = registerItem("universal_gen_8", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.UNIVERSAL_GEN).a(Float.valueOf(1.8f)).a();
        }, MCTechCreativeTabs.ENERGY);
        UNIVERSAL_GEN_9 = registerItem("universal_gen_9", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.UNIVERSAL_GEN).a(Float.valueOf(1.9f)).a();
        }, MCTechCreativeTabs.ENERGY);
        UNIVERSAL_GEN_10 = registerItem("universal_gen_10", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.UNIVERSAL_GEN).a(Float.valueOf(2.0f)).a();
        }, MCTechCreativeTabs.ENERGY);
        IS_GEN_NIGHT = registerItem("gen_night", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.ISNIGHT).a();
        }, MCTechCreativeTabs.ENERGY);
        STORAGE_1 = registerItem("storage_1", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.STORAGE).a(10).a();
        }, MCTechCreativeTabs.ENERGY);
        STORAGE_2 = registerItem("storage_2", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.STORAGE).a(100).a();
        }, MCTechCreativeTabs.ENERGY);
        STORAGE_3 = registerItem("storage_3", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.STORAGE).a(1000).a();
        }, MCTechCreativeTabs.ENERGY);
        TRANSFORMER = registerItem("transformer", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.TRANSFORMATOR).a();
        }, MCTechCreativeTabs.ENERGY);
        AE_ENERGY = registerItem("ae", () -> {
            return mctech.items.base.m.a(mctech.items.base.m.b.AE_CONVERTER).a();
        }, MCTechCreativeTabs.ENERGY);
        UPGRADE_MASS_FABRICATOR_FORTUNE_1 = ITEM_REGISTRY.registerItem("upgrade_mass_fabricator_fortune_1", properties32 -> {
            return new mctech.items.f.f.b(0.1f);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Fortune upgrade T1", "Улучшение: Удача производства Т1").setModelProvider((lItemModelProvider30, dataGenContext30) -> {
            lItemModelProvider30.basicItem((Item) dataGenContext30.get(), lItemModelProvider30.modLoc(String.format("item/upgrades/machines/%s", dataGenContext30.getName())));
        });
        UPGRADE_MASS_FABRICATOR_FORTUNE_2 = ITEM_REGISTRY.registerItem("upgrade_mass_fabricator_fortune_2", properties33 -> {
            return new mctech.items.f.f.b(0.3f);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Fortune upgrade T2", "Улучшение: Удача производства Т2").setModelProvider((lItemModelProvider31, dataGenContext31) -> {
            lItemModelProvider31.basicItem((Item) dataGenContext31.get(), lItemModelProvider31.modLoc(String.format("item/upgrades/machines/%s", dataGenContext31.getName())));
        });
        UPGRADE_MASS_FABRICATOR_FORTUNE_3 = ITEM_REGISTRY.registerItem("upgrade_mass_fabricator_fortune_3", properties34 -> {
            return new mctech.items.f.f.b(0.5f);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Fortune upgrade T3", "Улучшение: Удача производства Т3").setModelProvider((lItemModelProvider32, dataGenContext32) -> {
            lItemModelProvider32.basicItem((Item) dataGenContext32.get(), lItemModelProvider32.modLoc(String.format("item/upgrades/machines/%s", dataGenContext32.getName())));
        });
        UPGRADE_MASS_FABRICATOR_FORTUNE_4 = ITEM_REGISTRY.registerItem("upgrade_mass_fabricator_fortune_4", properties35 -> {
            return new mctech.items.f.f.b(0.7f);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Fortune upgrade T4", "Улучшение: Удача производства Т4").setModelProvider((lItemModelProvider33, dataGenContext33) -> {
            lItemModelProvider33.basicItem((Item) dataGenContext33.get(), lItemModelProvider33.modLoc(String.format("item/upgrades/machines/%s", dataGenContext33.getName())));
        });
        UPGRADE_SCRAP_GENERATION = ITEM_REGISTRY.registerItem("upgrade_scrap_generation", properties36 -> {
            return new mctech.items.f.f.c(true, false);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Scrap generation", "Улучшение: Генератор утильсырья").setModelProvider((lItemModelProvider34, dataGenContext34) -> {
            lItemModelProvider34.basicItem((Item) dataGenContext34.get(), lItemModelProvider34.modLoc(String.format("item/upgrades/machines/%s", dataGenContext34.getName())));
        });
        UPGRADE_SCRAPBOX_GENERATION = ITEM_REGISTRY.registerItem("upgrade_scrapbox_generation", properties37 -> {
            return new mctech.items.f.f.c(false, true);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Scrapbox generation", "Улучшение: Генератор коробок с утильсырьем").setModelProvider((lItemModelProvider35, dataGenContext35) -> {
            lItemModelProvider35.basicItem((Item) dataGenContext35.get(), lItemModelProvider35.modLoc(String.format("item/upgrades/machines/%s", dataGenContext35.getName())));
        });
        UPGRADE_DENSE_MATTER_1 = ITEM_REGISTRY.registerItem("upgrade_dense_matter_1", properties38 -> {
            return new mctech.items.f.f.a(1);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Dense matter T1", "Улучшение: Генератор плотной материи Т1").setModelProvider((lItemModelProvider36, dataGenContext36) -> {
            lItemModelProvider36.basicItem((Item) dataGenContext36.get(), lItemModelProvider36.modLoc(String.format("item/upgrades/machines/%s", dataGenContext36.getName())));
        });
        UPGRADE_DENSE_MATTER_2 = ITEM_REGISTRY.registerItem("upgrade_dense_matter_2", properties39 -> {
            return new mctech.items.f.f.a(2);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.UPGRADES).setTranslation("Dense matter T2", "Улучшение: Генератор плотной материи Т2").setModelProvider((lItemModelProvider37, dataGenContext37) -> {
            lItemModelProvider37.basicItem((Item) dataGenContext37.get(), lItemModelProvider37.modLoc(String.format("item/upgrades/machines/%s", dataGenContext37.getName())));
        });
        BRONZE_AXE = ITEM_REGISTRY.registerItem("bronze_axe", properties40 -> {
            return new mctech.items.e.b.a(p.a);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.TOOLS).addItemTags(new TagKey[]{ItemTags.AXES}).setTranslation("Bronze axe", "Бронзовый топор").setModelProvider((lItemModelProvider38, dataGenContext38) -> {
            lItemModelProvider38.basicItem((Item) dataGenContext38.get(), lItemModelProvider38.modLoc(String.format("item/tools/bronze/%s", dataGenContext38.getName())));
        });
        BRONZE_HOE = ITEM_REGISTRY.registerItem("bronze_hoe", properties41 -> {
            return new mctech.items.e.b.b(p.a);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.TOOLS).addItemTags(new TagKey[]{ItemTags.HOES}).setTranslation("Bronze hoe", "Бронзовая мотыга").setModelProvider((lItemModelProvider39, dataGenContext39) -> {
            lItemModelProvider39.basicItem((Item) dataGenContext39.get(), lItemModelProvider39.modLoc(String.format("item/tools/bronze/%s", dataGenContext39.getName())));
        });
        BRONZE_PICKAXE = ITEM_REGISTRY.registerItem("bronze_pickaxe", properties42 -> {
            return new mctech.items.e.b.c(p.a);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.TOOLS).addItemTags(new TagKey[]{ItemTags.PICKAXES}).setTranslation("Bronze pickaxe", "Бронзовая кирка").setModelProvider((lItemModelProvider40, dataGenContext40) -> {
            lItemModelProvider40.basicItem((Item) dataGenContext40.get(), lItemModelProvider40.modLoc(String.format("item/tools/bronze/%s", dataGenContext40.getName())));
        });
        BRONZE_SHOVEL = ITEM_REGISTRY.registerItem("bronze_shovel", properties43 -> {
            return new mctech.items.e.b.d(p.a);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.TOOLS).addItemTags(new TagKey[]{ItemTags.SHOVELS}).setTranslation("Bronze shovel", "Бронзовая лопата").setModelProvider((lItemModelProvider41, dataGenContext41) -> {
            lItemModelProvider41.basicItem((Item) dataGenContext41.get(), lItemModelProvider41.modLoc(String.format("item/tools/bronze/%s", dataGenContext41.getName())));
        });
        BRONZE_SWORD = ITEM_REGISTRY.registerItem("bronze_sword", properties44 -> {
            return new mctech.items.e.b.e(p.a);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.TOOLS).addItemTags(new TagKey[]{ItemTags.SWORDS}).setTranslation("Bronze sword", "Бронзовый меч").setModelProvider((lItemModelProvider42, dataGenContext42) -> {
            lItemModelProvider42.basicItem((Item) dataGenContext42.get(), lItemModelProvider42.modLoc(String.format("item/tools/bronze/%s", dataGenContext42.getName())));
        });
        TIN_AXE = ITEM_REGISTRY.registerItem("tin_axe", properties45 -> {
            return new mctech.items.e.d.a(p.b);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.TOOLS).addItemTags(new TagKey[]{ItemTags.AXES}).setTranslation("Tin axe", "Оловянный топор").setModelProvider((lItemModelProvider43, dataGenContext43) -> {
            lItemModelProvider43.basicItem((Item) dataGenContext43.get(), lItemModelProvider43.modLoc(String.format("item/tools/tin/%s", dataGenContext43.getName())));
        });
        TIN_HOE = ITEM_REGISTRY.registerItem("tin_hoe", properties46 -> {
            return new mctech.items.e.d.b(p.b);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.TOOLS).addItemTags(new TagKey[]{ItemTags.HOES}).setTranslation("Tin hoe", "Оловянная мотыга").setModelProvider((lItemModelProvider44, dataGenContext44) -> {
            lItemModelProvider44.basicItem((Item) dataGenContext44.get(), lItemModelProvider44.modLoc(String.format("item/tools/tin/%s", dataGenContext44.getName())));
        });
        TIN_PICKAXE = ITEM_REGISTRY.registerItem("tin_pickaxe", properties47 -> {
            return new mctech.items.e.d.c(p.b);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.TOOLS).addItemTags(new TagKey[]{ItemTags.PICKAXES}).setTranslation("Tin pickaxe", "Оловянная кирка").setModelProvider((lItemModelProvider45, dataGenContext45) -> {
            lItemModelProvider45.basicItem((Item) dataGenContext45.get(), lItemModelProvider45.modLoc(String.format("item/tools/tin/%s", dataGenContext45.getName())));
        });
        TIN_SHOVEL = ITEM_REGISTRY.registerItem("tin_shovel", properties48 -> {
            return new mctech.items.e.d.d(p.b);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.TOOLS).addItemTags(new TagKey[]{ItemTags.SHOVELS}).setTranslation("Tin shovel", "Оловянная лопата").setModelProvider((lItemModelProvider46, dataGenContext46) -> {
            lItemModelProvider46.basicItem((Item) dataGenContext46.get(), lItemModelProvider46.modLoc(String.format("item/tools/tin/%s", dataGenContext46.getName())));
        });
        TIN_SWORD = ITEM_REGISTRY.registerItem("tin_sword", properties49 -> {
            return new mctech.items.e.d.e(p.b);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.TOOLS).addItemTags(new TagKey[]{ItemTags.SWORDS}).setTranslation("Tin sword", "Оловянный меч").setModelProvider((lItemModelProvider47, dataGenContext47) -> {
            lItemModelProvider47.basicItem((Item) dataGenContext47.get(), lItemModelProvider47.modLoc(String.format("item/tools/tin/%s", dataGenContext47.getName())));
        });
        ENHANCED_QUANTUM_AXE = ITEM_REGISTRY.register("enhanced_singular_axe", () -> {
            return new mctech.items.e.c.a(new Item.Properties());
        }).setTranslation("Singular axe", "Сингулярный топор").addItemTags(new TagKey[]{ItemTags.AXES}).setTab(MCTechCreativeTabs.TOOLS);
        ENHANCED_QUANTUM_PICKAXE = ITEM_REGISTRY.register("enhanced_singular_pickaxe", () -> {
            return new mctech.items.e.c.b(new Item.Properties());
        }).setTranslation("Singular pickaxe", "Сингулярная кирка").addItemTags(new TagKey[]{ItemTags.PICKAXES}).setTab(MCTechCreativeTabs.TOOLS);
        ENHANCED_QUANTUM_SHOVEL = ITEM_REGISTRY.register("enhanced_singular_shovel", () -> {
            return new mctech.items.e.c.c(new Item.Properties());
        }).setTranslation("Singular shovel", "Сингулярная лопата").addItemTags(new TagKey[]{ItemTags.SHOVELS}).setTab(MCTechCreativeTabs.TOOLS);
        ENHANCED_QUANTUM_STAFF = ITEM_REGISTRY.register("enhanced_singular_staff", () -> {
            return new mctech.items.e.c.d(new Item.Properties());
        }).setTranslation("Singular staff", "Сингулярный посох").setModelProvider((lItemModelProvider48, dataGenContext48) -> {
            GeckoData.item(lItemModelProvider48, dataGenContext48).transforms().transform(ItemDisplayContext.GUI).rotation(-90.0f, 45.0f, 90.0f).translation(0.5f, -0.5f, 0.0f).scale(0.4f, 0.4f, 0.4f).end().transform(ItemDisplayContext.GROUND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, 0.0f, 0.0f).scale(0.3f, 0.3f, 0.3f).end().transform(ItemDisplayContext.HEAD).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, 0.0f, 0.0f).scale(4.0f, 4.0f, 4.0f).end().transform(ItemDisplayContext.FIXED).rotation(0.0f, 90.0f, 0.0f).translation(3.0f, -2.5f, 0.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).translation(0.0f, 1.25f, 1.0f).rotation(0.0f, 0.0f, 0.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).translation(0.0f, 1.25f, 1.0f).rotation(0.0f, 0.0f, 0.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(-43.02f, 11.0f, -6.78f).translation(2.25f, 2.75f, -1.0f).scale(0.9f, 0.9f, 0.9f).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(-43.02f, 11.0f, -6.78f).translation(2.25f, 2.75f, -1.0f).scale(0.9f, 0.9f, 0.9f).end().transform(ItemDisplayContext.GROUND).rotation(-45.0f, 0.0f, 0.0f).translation(0.0f, 3.0f, 0.0f).scale(0.7f, 0.7f, 0.7f).end().transform(ItemDisplayContext.FIXED).rotation(90.0f, -135.0f, 90.0f).translation(0.0f, 0.0f, 0.5f).scale(0.4f, 0.4f, 0.4f).end().end();
        }).setTab(MCTechCreativeTabs.TOOLS);
        ENHANCED_QUANTUM_SWORD = ITEM_REGISTRY.register("enhanced_singular_sword", () -> {
            return new mctech.items.e.c.f(new Item.Properties());
        }).setTranslation("Singular sword", "Сингулярный меч").addItemTags(new TagKey[]{ItemTags.SWORDS}).setTab(MCTechCreativeTabs.WEAPONS);
        ENHANCED_QUANTUM_TRIDENT = ITEM_REGISTRY.register("enhanced_singular_trident", () -> {
            return new mctech.items.e.c.g(new Item.Properties());
        }).setTranslation("Singular trident", "Сингулярное копье").setTab(MCTechCreativeTabs.TOOLS);
        ENHANCED_QUANTUM_HELMET = ITEM_REGISTRY.registerItem("enhanced_singular_helmet", properties50 -> {
            return new mctech.items.g.a.c(ArmorItem.Type.HELMET, properties50);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.ARMOR).addItemTags(new TagKey[]{ItemTags.HEAD_ARMOR}).setTranslation("Singular helmet", "Сингулярный шлем").setModelProvider((lItemModelProvider49, dataGenContext49) -> {
            lItemModelProvider49.basicItem((Item) dataGenContext49.get(), lItemModelProvider49.modLoc("item/armor/singular/helmet_item"));
        });
        ENHANCED_QUANTUM_CHESTPLATE = ITEM_REGISTRY.registerItem("enhanced_singular_chestplate", properties51 -> {
            return new mctech.items.g.a.c(ArmorItem.Type.CHESTPLATE, properties51);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.ARMOR).addItemTags(new TagKey[]{ItemTags.CHEST_ARMOR}).setTranslation("Singular chestplate", "Сингулярный нагрудник").setModelProvider((lItemModelProvider50, dataGenContext50) -> {
            lItemModelProvider50.basicItem((Item) dataGenContext50.get(), lItemModelProvider50.modLoc("item/armor/singular/chestplate_item"));
        });
        ENHANCED_QUANTUM_LEGGINGS = ITEM_REGISTRY.registerItem("enhanced_singular_leggings", properties52 -> {
            return new mctech.items.g.a.c(ArmorItem.Type.LEGGINGS, properties52);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.ARMOR).addItemTags(new TagKey[]{ItemTags.LEG_ARMOR}).setTranslation("Singular leggings", "Сингулярные поножи").setModelProvider((lItemModelProvider51, dataGenContext51) -> {
            lItemModelProvider51.basicItem((Item) dataGenContext51.get(), lItemModelProvider51.modLoc("item/armor/singular/leggings_item"));
        });
        ENHANCED_QUANTUM_BOOTS = ITEM_REGISTRY.registerItem("enhanced_singular_boots", properties53 -> {
            return new mctech.items.g.a.c(ArmorItem.Type.BOOTS, properties53);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.ARMOR).addItemTags(new TagKey[]{ItemTags.FOOT_ARMOR}).setTranslation("Singular boots", "Сингулярные ботинки").setModelProvider((lItemModelProvider52, dataGenContext52) -> {
            lItemModelProvider52.basicItem((Item) dataGenContext52.get(), lItemModelProvider52.modLoc("item/armor/singular/boots_item"));
        });
        BRONZE_HELMET = ITEM_REGISTRY.registerItem("bronze_helmet", properties54 -> {
            return new mctech.items.g.a.a(ArmorItem.Type.HELMET);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.ARMOR).addItemTags(new TagKey[]{ItemTags.HEAD_ARMOR}).setTranslation("Bronze helmet", "Бронзовый шлем").setModelProvider((lItemModelProvider53, dataGenContext53) -> {
            lItemModelProvider53.basicItem((Item) dataGenContext53.get(), lItemModelProvider53.modLoc("item/armor/bronze/item_helmet"));
        });
        BRONZE_CHEST = ITEM_REGISTRY.registerItem("bronze_chest", properties55 -> {
            return new mctech.items.g.a.a(ArmorItem.Type.CHESTPLATE);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.ARMOR).addItemTags(new TagKey[]{ItemTags.CHEST_ARMOR}).setTranslation("Bronze chestplate", "Бронзовый нагрудник").setModelProvider((lItemModelProvider54, dataGenContext54) -> {
            lItemModelProvider54.basicItem((Item) dataGenContext54.get(), lItemModelProvider54.modLoc("item/armor/bronze/item_chestplate"));
        });
        BRONZE_LEGGINGS = ITEM_REGISTRY.registerItem("bronze_leggings", properties56 -> {
            return new mctech.items.g.a.a(ArmorItem.Type.LEGGINGS);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.ARMOR).addItemTags(new TagKey[]{ItemTags.LEG_ARMOR}).setTranslation("Bronze leggings", "Бронзовые поножи").setModelProvider((lItemModelProvider55, dataGenContext55) -> {
            lItemModelProvider55.basicItem((Item) dataGenContext55.get(), lItemModelProvider55.modLoc("item/armor/bronze/item_leggings"));
        });
        BRONZE_BOOTS = ITEM_REGISTRY.registerItem("bronze_boots", properties57 -> {
            return new mctech.items.g.a.a(ArmorItem.Type.BOOTS);
        }, new Item.Properties()).setTab(MCTechCreativeTabs.ARMOR).addItemTags(new TagKey[]{ItemTags.FOOT_ARMOR}).setTranslation("Bronze boots", "Бронзовые ботинки").setModelProvider((lItemModelProvider56, dataGenContext56) -> {
            lItemModelProvider56.basicItem((Item) dataGenContext56.get(), lItemModelProvider56.modLoc("item/armor/bronze/item_boots"));
        });
        DEBUG_JETPACK = ITEM_REGISTRY.registerItem("debug_jetpack", properties58 -> {
            return new mctech.items.g.c.a(1000000);
        }).setTab(MCTechCreativeTabs.ARMOR).setTranslation("Debug Jetpack", "Debug Jetpack");
        SCHEME_INSTALLER = ITEM_REGISTRY.registerItem("scheme_installer", properties59 -> {
            return new mctech.items.e.i();
        }).defaultModel().setTranslation("Scheme Installer", "Установщик схем").setTab(MCTechCreativeTabs.TOOLS).setModelProvider((lItemModelProvider57, dataGenContext57) -> {
            lItemModelProvider57.basicItem((Item) dataGenContext57.get(), MCTech.loc("item/tools/scheme_installer"));
        });
        COMPOSITE_PICKAXE = ITEM_REGISTRY.register("composite_pickaxe", () -> {
            return new mctech.items.e.c(mctech.items.f.DIGGER_COMPOSITE);
        }).setTab(MCTechCreativeTabs.TOOLS).setTranslation(String.format("%s pickaxe", MachineTier.T4.engTranslation()), String.format("%s кирка", MachineTier.T4.ruForm(RussianForm.FEMININE_NOMINATIVE)));
        NANO_PICKAXE = ITEM_REGISTRY.register("nano_pickaxe", () -> {
            return new mctech.items.e.c(mctech.items.f.DIGGER_NANO);
        }).setTab(MCTechCreativeTabs.TOOLS).setTranslation(String.format("%s pickaxe", MachineTier.T5.engTranslation()), String.format("%s кирка", MachineTier.T5.ruForm(RussianForm.FEMININE_NOMINATIVE)));
        QUANTUM_PICKAXE = ITEM_REGISTRY.register("quantum_pickaxe", () -> {
            return new mctech.items.e.c(mctech.items.f.DIGGER_QUANTUM);
        }).setTab(MCTechCreativeTabs.TOOLS).setTranslation(String.format("%s pickaxe", MachineTier.T6.engTranslation()), String.format("%s кирка", MachineTier.T6.ruForm(RussianForm.FEMININE_NOMINATIVE)));
        SINGULAR_PICKAXE = ITEM_REGISTRY.register("singular_pickaxe", () -> {
            return new mctech.items.e.c(mctech.items.f.DIGGER_SINGULAR);
        }).setTab(MCTechCreativeTabs.TOOLS).setTranslation(String.format("%s pickaxe", MachineTier.T7.engTranslation()), String.format("%s кирка", MachineTier.T7.ruForm(RussianForm.FEMININE_NOMINATIVE)));
        ADMIN_PICKAXE = ITEM_REGISTRY.register("admin_pickaxe", () -> {
            return new mctech.items.e.c(mctech.items.f.DIGGER_ADMIN);
        }).setTab(MCTechCreativeTabs.TOOLS).setTranslation(String.format("%s pickaxe", MachineTier.T8.engTranslation()), String.format("%s кирка", MachineTier.T8.ruForm(RussianForm.FEMININE_NOMINATIVE)));
        COMPOSITE_HELMET = newArmor(EnumC0125a.ARMOR_COMPOSITE, ArmorItem.Type.HELMET);
        COMPOSITE_CHEST = newArmor(EnumC0125a.ARMOR_COMPOSITE);
        COMPOSITE_LEGS = newArmor(EnumC0125a.ARMOR_COMPOSITE, ArmorItem.Type.LEGGINGS);
        COMPOSITE_BOOT = newArmor(EnumC0125a.ARMOR_COMPOSITE, ArmorItem.Type.BOOTS);
        NANO_HELMET = newArmor(EnumC0125a.ARMOR_NANO, ArmorItem.Type.HELMET);
        NANO_CHEST = newArmor(EnumC0125a.ARMOR_NANO);
        NANO_LEGS = newArmor(EnumC0125a.ARMOR_NANO, ArmorItem.Type.LEGGINGS);
        NANO_BOOT = newArmor(EnumC0125a.ARMOR_NANO, ArmorItem.Type.BOOTS);
        QUANTUM_HELMET = newArmor(EnumC0125a.ARMOR_QUANTUM, ArmorItem.Type.HELMET);
        QUANTUM_CHEST = newArmor(EnumC0125a.ARMOR_QUANTUM);
        QUANTUM_LEGS = newArmor(EnumC0125a.ARMOR_QUANTUM, ArmorItem.Type.LEGGINGS);
        QUANTUM_BOOT = newArmor(EnumC0125a.ARMOR_QUANTUM, ArmorItem.Type.BOOTS);
        SINGULAR_HELMET = newArmor(EnumC0125a.ARMOR_SINGULAR, ArmorItem.Type.HELMET);
        SINGULAR_CHEST = newArmor(EnumC0125a.ARMOR_SINGULAR);
        SINGULAR_LEGS = newArmor(EnumC0125a.ARMOR_SINGULAR, ArmorItem.Type.LEGGINGS);
        SINGULAR_BOOT = newArmor(EnumC0125a.ARMOR_SINGULAR, ArmorItem.Type.BOOTS);
        ADMIN_HELMET = newArmor(EnumC0125a.ARMOR_ADMIN, ArmorItem.Type.HELMET);
        ADMIN_CHEST = newArmor(EnumC0125a.ARMOR_ADMIN);
        ADMIN_LEGS = newArmor(EnumC0125a.ARMOR_ADMIN, ArmorItem.Type.LEGGINGS);
        ADMIN_BOOT = newArmor(EnumC0125a.ARMOR_ADMIN, ArmorItem.Type.BOOTS);
        COMPOSITE_CIRCUIT = registerSimple("composite_circuit", MCTechCreativeTabs.MATERIALS).setTranslation(String.format("%s circuit", MachineTier.T4.engTranslation()), String.format("%s микросхема", MachineTier.T4.ruForm(RussianForm.FEMININE_NOMINATIVE)));
        NANO_CIRCUIT = registerSimple("nano_circuit", MCTechCreativeTabs.MATERIALS).setTranslation(String.format("%s circuit", MachineTier.T5.engTranslation()), String.format("%s микросхема", MachineTier.T5.ruForm(RussianForm.FEMININE_NOMINATIVE)));
        QUANTUM_CIRCUIT = registerSimple("quantum_circuit", MCTechCreativeTabs.MATERIALS).setTranslation(String.format("%s circuit", MachineTier.T6.engTranslation()), String.format("%s микросхема", MachineTier.T6.ruForm(RussianForm.FEMININE_NOMINATIVE)));
        SINGULAR_CIRCUIT = registerSimple("singular_circuit", MCTechCreativeTabs.MATERIALS).setTranslation(String.format("%s circuit", MachineTier.T7.engTranslation()), String.format("%s микросхема", MachineTier.T7.ruForm(RussianForm.FEMININE_NOMINATIVE)));
        ADMIN_CIRCUIT = registerSimple("admin_circuit", MCTechCreativeTabs.MATERIALS).setTranslation(String.format("%s circuit", MachineTier.T8.engTranslation()), String.format("%s микросхема", MachineTier.T8.ruForm(RussianForm.FEMININE_NOMINATIVE)));
        UU_MATTER_2 = registerSimple("uumatter2", MCTechCreativeTabs.MATERIALS);
        UU_MATTER_3 = registerSimple("uumatter3", MCTechCreativeTabs.MATERIALS);
        ANTI_UU_MATTER = registerSimple("anti_uumatter", MCTechCreativeTabs.MATERIALS);
        ANTI_UU_MATTER_2 = registerSimple("anti_uumatter2", MCTechCreativeTabs.MATERIALS);
        ANTI_UU_MATTER_3 = registerSimple("anti_uumatter3", MCTechCreativeTabs.MATERIALS);
        ADMIN_SCRAP = registerSimple("admin_scrap", MCTechCreativeTabs.MATERIALS);
        ADMIN_SCRAP_BOX = registerSimple("admin_scrapbox", MCTechCreativeTabs.MATERIALS);
        SIGN_SCRAP = registerSimple("sing_scrap", MCTechCreativeTabs.MATERIALS);
        SIGN_SCRAP_BOX = registerSimple("sing_scrapbox", MCTechCreativeTabs.MATERIALS);
        QUANT_SCRAP = registerSimple("quant_scrap", MCTechCreativeTabs.MATERIALS);
        QUANT_SCRAP_BOX = registerSimple("quant_scrapbox", MCTechCreativeTabs.MATERIALS);
        NANO_SCRAP = registerSimple("nano_scrap", MCTechCreativeTabs.MATERIALS);
        NANO_SCRAP_BOX = registerSimple("nano_scrapbox", MCTechCreativeTabs.MATERIALS);
        COMP_SCRAP = registerSimple("comp_scrap", MCTechCreativeTabs.MATERIALS);
        COMP_SCRAP_BOX = registerSimple("comp_scrapbox", MCTechCreativeTabs.MATERIALS);
        IRIDIUM_INGOT = registerSimple("iridium_ingot", MCTechCreativeTabs.MATERIALS);
        TITANIUM_PLATE = registerSimple("titanium_plate", MCTechCreativeTabs.MATERIALS);
        LAPIS_PLATE = registerSimple("lapis_plate", MCTechCreativeTabs.MATERIALS);
        COMPOSITE_SABER = ITEM_REGISTRY.register("composite_saber", () -> {
            return new mctech.items.e.h(v.SABER_COMPOSITE);
        }).setTab(MCTechCreativeTabs.WEAPONS).setTranslation(String.format("%s saber", MachineTier.T4.engTranslation()), String.format("%s рукоятка", MachineTier.T4.ruForm(RussianForm.FEMININE_NOMINATIVE)));
        NANO_SABER = ITEM_REGISTRY.register("nano_saber", () -> {
            return new mctech.items.e.h(v.SABER_NANO);
        }).setTab(MCTechCreativeTabs.WEAPONS).setTranslation(String.format("%s saber", MachineTier.T5.engTranslation()), String.format("%s рукоятка", MachineTier.T5.ruForm(RussianForm.FEMININE_NOMINATIVE)));
        QUANTUM_SABER = ITEM_REGISTRY.register("quantum_saber", () -> {
            return new mctech.items.e.h(v.SABER_QUANTUM);
        }).setTab(MCTechCreativeTabs.WEAPONS).setTranslation(String.format("%s saber", MachineTier.T6.engTranslation()), String.format("%s рукоятка", MachineTier.T6.ruForm(RussianForm.FEMININE_NOMINATIVE)));
        SINGULAR_SABER = ITEM_REGISTRY.register("singular_saber", () -> {
            return new mctech.items.e.h(v.SABER_SINGULAR);
        }).setTab(MCTechCreativeTabs.WEAPONS).setTranslation(String.format("%s saber", MachineTier.T7.engTranslation()), String.format("%s рукоятка", MachineTier.T7.ruForm(RussianForm.FEMININE_NOMINATIVE)));
        ADMIN_SABER = ITEM_REGISTRY.register("admin_saber", () -> {
            return new mctech.items.e.h(v.SABER_ADMIN);
        }).setTab(MCTechCreativeTabs.WEAPONS).setTranslation(String.format("%s saber", MachineTier.T8.engTranslation()), String.format("%s рукоятка", MachineTier.T8.ruForm(RussianForm.FEMININE_NOMINATIVE)));
        WHETSTONE_OF_LEGEND = ITEM_REGISTRY.register("whetstone_of_legend", () -> {
            return new mctech.items.e.l(q.WHETSTONE_OF_LEGEND);
        }).setTab(MCTechCreativeTabs.WEAPONS);
        WHETSTONE_OF_MASTERY = ITEM_REGISTRY.register("whetstone_of_mastery", () -> {
            return new mctech.items.e.l(q.WHETSTONE_OF_MASTERY);
        }).setTab(MCTechCreativeTabs.WEAPONS);
        WHETSTONE_OF_SHARPNESS = ITEM_REGISTRY.register("whetstone_of_sharpness", () -> {
            return new mctech.items.e.l(q.WHETSTONE_OF_SHARPNESS);
        }).setTab(MCTechCreativeTabs.WEAPONS);
        VENT_HEAT = ITEM_REGISTRY.register("heat_vent", () -> {
            return new mctech.items.d.j(new mctech.items.d.j.a(mctech.items.d.j.b.HEAT, 6, 0, 1000));
        }).setTranslation("Heat Vent", "Теплоотвод").setModelProvider((lItemModelProvider58, dataGenContext58) -> {
            lItemModelProvider58.basicItem((Item) dataGenContext58.get(), MCTech.loc("item/reactor/vents/heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        VENT_HEAT_CORE = ITEM_REGISTRY.register("heat_vent_core", () -> {
            return new mctech.items.d.j(new mctech.items.d.j.a(mctech.items.d.j.b.HEAT, 5, 5, 1000));
        }).setTranslation("Heat Vent Core", "Реакторный теплоотвод").setModelProvider((lItemModelProvider59, dataGenContext59) -> {
            lItemModelProvider59.basicItem((Item) dataGenContext59.get(), MCTech.loc("item/reactor/vents/core_heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        VENT_HEAT_OVERCLOCKED = ITEM_REGISTRY.register("heat_vent_overclocked", () -> {
            return new mctech.items.d.j(new mctech.items.d.j.a(mctech.items.d.j.b.HEAT, 20, 36, 1000));
        }).setTranslation("Heat Vent Overclocked", "Разогнанный теплоотвод").setModelProvider((lItemModelProvider60, dataGenContext60) -> {
            lItemModelProvider60.basicItem((Item) dataGenContext60.get(), MCTech.loc("item/reactor/vents/overclocked_heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        VENT_HEAT_OVERCLOCKED_T2 = ITEM_REGISTRY.register("heat_vent_overclocked_t2", () -> {
            return new mctech.items.d.j(new mctech.items.d.j.a(mctech.items.d.j.b.HEAT, 26, 42, 1000));
        }).setTranslation("Heat Vent Overclocked T2", "Нано теплоотвод").setModelProvider((lItemModelProvider61, dataGenContext61) -> {
            lItemModelProvider61.basicItem((Item) dataGenContext61.get(), MCTech.loc("item/reactor/vents/nano_heat_sink"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        VENT_HEAT_OVERCLOCKED_T3 = ITEM_REGISTRY.register("heat_vent_overclocked_t3", () -> {
            return new mctech.items.d.j(new mctech.items.d.j.a(mctech.items.d.j.b.HEAT, 32, 48, 1000));
        }).setTranslation("Heat Vent Overclocked T3", "Квантовый теплоотвод").setModelProvider((lItemModelProvider62, dataGenContext62) -> {
            lItemModelProvider62.basicItem((Item) dataGenContext62.get(), MCTech.loc("item/reactor/vents/quant_heat_sink"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        VENT_HEAT_ADVANCED = ITEM_REGISTRY.register("heat_vent_advanced", () -> {
            return new mctech.items.d.j(new mctech.items.d.j.a(mctech.items.d.j.b.HEAT, 12, 0, 1000));
        }).setTranslation("Electric Vent Advanced", "Улучшенный теплоотвод").setModelProvider((lItemModelProvider63, dataGenContext63) -> {
            lItemModelProvider63.basicItem((Item) dataGenContext63.get(), MCTech.loc("item/reactor/vents/advanced_heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        VENT_ELECTRIC = ITEM_REGISTRY.register("electric_vent", () -> {
            return new mctech.items.d.j(new mctech.items.d.j.a(mctech.items.d.j.b.ELECTRIC, 12, 0, 10000));
        }).setTranslation("Electric Vent", "Электрический теплоотвод").setModelProvider((lItemModelProvider64, dataGenContext64) -> {
            lItemModelProvider64.basicItem((Item) dataGenContext64.get(), MCTech.loc("item/reactor/vents/electric"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        VENT_ELECTRIC_CORE = ITEM_REGISTRY.register("electric_vent_core", () -> {
            return new mctech.items.d.j(new mctech.items.d.j.a(mctech.items.d.j.b.ELECTRIC, 10, 10, 10000));
        }).setTranslation("Electric Vent Core", "Электрический реакторный теплоотвод").setModelProvider((lItemModelProvider65, dataGenContext65) -> {
            lItemModelProvider65.basicItem((Item) dataGenContext65.get(), MCTech.loc("item/reactor/vents/core_electric"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        VENT_ELECTRIC_OVERCLOCKED = ITEM_REGISTRY.register("electric_vent_overclocked", () -> {
            return new mctech.items.d.j(new mctech.items.d.j.a(mctech.items.d.j.b.ELECTRIC, 40, 72, 10000));
        }).setTranslation("Electric Vent Overclocked ", "Разогнанный электрический теплоотвод").setModelProvider((lItemModelProvider66, dataGenContext66) -> {
            lItemModelProvider66.basicItem((Item) dataGenContext66.get(), MCTech.loc("item/reactor/vents/overclocked_electric"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        VENT_ELECTRIC_OVERCLOCKED_T2 = ITEM_REGISTRY.register("electric_vent_overclocked_t2", () -> {
            return new mctech.items.d.j(new mctech.items.d.j.a(mctech.items.d.j.b.ELECTRIC, 46, 78, 10000));
        }).setTranslation("Electric Vent Overclocked T2", "Разогнанный электрический теплоотвод Т2").setModelProvider((lItemModelProvider67, dataGenContext67) -> {
            lItemModelProvider67.basicItem((Item) dataGenContext67.get(), MCTech.loc("item/reactor/vents/overclocked_electric_t2"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        VENT_ELECTRIC_OVERCLOCKED_T3 = ITEM_REGISTRY.register("electric_vent_overclocked_t3", () -> {
            return new mctech.items.d.j(new mctech.items.d.j.a(mctech.items.d.j.b.ELECTRIC, 52, 84, 10000));
        }).setTranslation("Electric Vent Overclocked T3", "Разогнанный электрический теплоотвод Т3").setModelProvider((lItemModelProvider68, dataGenContext68) -> {
            lItemModelProvider68.basicItem((Item) dataGenContext68.get(), MCTech.loc("item/reactor/vents/overclocked_electric_t3"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        VENT_ELECTRIC_ADVANCED = ITEM_REGISTRY.register("electric_vent_advanced", () -> {
            return new mctech.items.d.j(new mctech.items.d.j.a(mctech.items.d.j.b.ELECTRIC, 24, 0, 10000));
        }).setTranslation("Electric Vent Advanced", "Продвинутый электрический теплоотвод").setModelProvider((lItemModelProvider69, dataGenContext69) -> {
            lItemModelProvider69.basicItem((Item) dataGenContext69.get(), MCTech.loc("item/reactor/vents/advanced_electric"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        VENT_ELECTRIC_ADVANCED_T2 = ITEM_REGISTRY.register("electric_vent_advanced_t2", () -> {
            return new mctech.items.d.j(new mctech.items.d.j.a(mctech.items.d.j.b.ELECTRIC, 30, 0, 10000));
        }).setTranslation("Electric Vent Advanced T2", "Продвинутый электрический теплоотвод Т2").setModelProvider((lItemModelProvider70, dataGenContext70) -> {
            lItemModelProvider70.basicItem((Item) dataGenContext70.get(), MCTech.loc("item/reactor/vents/advanced_electric_t2"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        VENT_ELECTRIC_ADVANCED_T3 = ITEM_REGISTRY.register("electric_vent_advanced_t3", () -> {
            return new mctech.items.d.j(new mctech.items.d.j.a(mctech.items.d.j.b.ELECTRIC, 36, 0, 10000));
        }).setTranslation("Electric Vent Advanced T3", "Продвинутый электрический теплоотвод Т3").setModelProvider((lItemModelProvider71, dataGenContext71) -> {
            lItemModelProvider71.basicItem((Item) dataGenContext71.get(), MCTech.loc("item/reactor/vents/advanced_electric_t3"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        HEAT_EXCHANGER = ITEM_REGISTRY.register("heat_exchanger", () -> {
            return new mctech.items.d.f(new mctech.items.d.a.a(12, 4, 2500));
        }).setTranslation("Heat Exchanger", "Теплообменник").setModelProvider((lItemModelProvider72, dataGenContext72) -> {
            lItemModelProvider72.basicItem((Item) dataGenContext72.get(), MCTech.loc("item/reactor/exchanger/heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        HEAT_EXCHANGER_CORE = ITEM_REGISTRY.register("heat_exchanger_core", () -> {
            return new mctech.items.d.f(new mctech.items.d.a.a(0, 72, 5000));
        }).setTranslation("Heat Exchanger Core", "Реакторный теплообменник").setModelProvider((lItemModelProvider73, dataGenContext73) -> {
            lItemModelProvider73.basicItem((Item) dataGenContext73.get(), MCTech.loc("item/reactor/exchanger/core_heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        HEAT_EXCHANGER_SPREAD = ITEM_REGISTRY.register("heat_exchanger_spread", () -> {
            return new mctech.items.d.f(new mctech.items.d.a.a(36, 0, 5000));
        }).setTranslation("Heat Exchanger Spread", "Компонентный теплообменник").setModelProvider((lItemModelProvider74, dataGenContext74) -> {
            lItemModelProvider74.basicItem((Item) dataGenContext74.get(), MCTech.loc("item/reactor/exchanger/component_heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        HEAT_EXCHANGER_ADVANCED = ITEM_REGISTRY.register("heat_exchanger_advanced", () -> {
            return new mctech.items.d.f(new mctech.items.d.a.a(24, 8, 10000));
        }).setTranslation("Heat Exchanger Advanced", "Улучшенный теплообменник").setModelProvider((lItemModelProvider75, dataGenContext75) -> {
            lItemModelProvider75.basicItem((Item) dataGenContext75.get(), MCTech.loc("item/reactor/exchanger/advanced_heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        HEAT_EXCHANGER_ADVANCED_T2 = ITEM_REGISTRY.register("heat_exchanger_advanced_t2", () -> {
            return new mctech.items.d.f(new mctech.items.d.a.a(30, 8, 10000));
        }).setTranslation("Heat Exchanger Advanced T2", "Нано теплообменник").setModelProvider((lItemModelProvider76, dataGenContext76) -> {
            lItemModelProvider76.basicItem((Item) dataGenContext76.get(), MCTech.loc("item/reactor/exchanger/nano_heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        HEAT_EXCHANGER_ADVANCED_T3 = ITEM_REGISTRY.register("heat_exchanger_advanced_t3", () -> {
            return new mctech.items.d.f(new mctech.items.d.a.a(36, 8, 10000));
        }).setTranslation("Heat Exchanger Advanced T3", "Квантовый теплообменник").setModelProvider((lItemModelProvider77, dataGenContext77) -> {
            lItemModelProvider77.basicItem((Item) dataGenContext77.get(), MCTech.loc("item/reactor/exchanger/quant_heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        HEAT_BALANCER = ITEM_REGISTRY.register("heat_balancer", () -> {
            return new mctech.items.d.e(new mctech.items.d.a.a(18, 12, 2500));
        }).setTranslation("Heat Balancer", "Балансировщик тепла").setModelProvider((lItemModelProvider78, dataGenContext78) -> {
            lItemModelProvider78.basicItem((Item) dataGenContext78.get(), MCTech.loc("item/reactor/balancer/heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        HEAT_BALANCER_CORE = ITEM_REGISTRY.register("heat_balancer_core", () -> {
            return new mctech.items.d.e(new mctech.items.d.a.a(0, 108, 5000));
        }).setTranslation("Heat Balancer Core", "Реакторный балансировщик тепла").setModelProvider((lItemModelProvider79, dataGenContext79) -> {
            lItemModelProvider79.basicItem((Item) dataGenContext79.get(), MCTech.loc("item/reactor/balancer/core_heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        HEAT_BALANCER_SPREAD = ITEM_REGISTRY.register("heat_balancer_spread", () -> {
            return new mctech.items.d.e(new mctech.items.d.a.a(54, 0, 5000));
        }).setTranslation("Heat Balancer Spread", "Компонентный балансировщик тепла").setModelProvider((lItemModelProvider80, dataGenContext80) -> {
            lItemModelProvider80.basicItem((Item) dataGenContext80.get(), MCTech.loc("item/reactor/balancer/component_heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        HEAT_BALANCER_ADVANCED = ITEM_REGISTRY.register("heat_balancer_advanced", () -> {
            return new mctech.items.d.e(new mctech.items.d.a.a(36, 24, 10000));
        }).setTranslation("Heat Balancer Advanced", "Улучшенный балансировщик тепла").setModelProvider((lItemModelProvider81, dataGenContext81) -> {
            lItemModelProvider81.basicItem((Item) dataGenContext81.get(), MCTech.loc("item/reactor/balancer/advanced_heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        HEAT_BALANCER_ADVANCED_T2 = ITEM_REGISTRY.register("heat_balancer_advanced_t2", () -> {
            return new mctech.items.d.e(new mctech.items.d.a.a(42, 24, 10000));
        }).setTranslation("Heat Balancer Advanced T2", "Нано балансировщик тепла").setModelProvider((lItemModelProvider82, dataGenContext82) -> {
            lItemModelProvider82.basicItem((Item) dataGenContext82.get(), MCTech.loc("item/reactor/balancer/nano_heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        HEAT_BALANCER_ADVANCED_T3 = ITEM_REGISTRY.register("heat_balancer_advanced_t3", () -> {
            return new mctech.items.d.e(new mctech.items.d.a.a(48, 24, 10000));
        }).setTranslation("Heat Balancer Advanced T3", "Квантовый балансировщик тепла").setModelProvider((lItemModelProvider83, dataGenContext83) -> {
            lItemModelProvider83.basicItem((Item) dataGenContext83.get(), MCTech.loc("item/reactor/balancer/quant_heat"));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
        COOLANT_CELL_10K = registerItem("heat_storage_single", () -> {
            return new mctech.items.d.i(10000, 12);
        }, MCTechCreativeTabs.NUCLEAR).setModelProvider((lItemModelProvider84, dataGenContext84) -> {
            lItemModelProvider84.basicItem((Item) dataGenContext84.get(), MCTech.loc("item/reactor/cells/heat_storage"));
        });
        COOLANT_CELL_30K = registerItem("heat_storage_triple", () -> {
            return new mctech.items.d.i(30000, 13);
        }, MCTechCreativeTabs.NUCLEAR);
        COOLANT_CELL_60K = registerItem("heat_storage_six", () -> {
            return new mctech.items.d.i(60000, 14);
        }, MCTechCreativeTabs.NUCLEAR);
        HEAT_PACK = registerItem("heat_pack", mctech.items.d.g::new, MCTechCreativeTabs.NUCLEAR);
        HEAT_SPREADER = registerItem("heat_spreader", mctech.items.d.h::new, MCTechCreativeTabs.NUCLEAR);
        INFINITE_COBBLESTONE_CELL = ITEM_REGISTRY.register("infinite_cell_cobblestone", () -> {
            return mctech.a.b.a(Items.COBBLESTONE);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite cobblestone cell", "Бесконечная ячейка булыжника").setModelProvider((lItemModelProvider85, dataGenContext85) -> {
            lItemModelProvider85.basicItem((Item) dataGenContext85.get(), lItemModelProvider85.modLoc("item/aecells/cobblestone"));
        });
        INFINITE_COPPER_INGOT_CELL = ITEM_REGISTRY.register("infinite_cell_copper_ingot", () -> {
            return mctech.a.b.a(Items.COPPER_INGOT);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite copper ingots cell", "Бесконечная ячейка медных слитков").setModelProvider((lItemModelProvider86, dataGenContext86) -> {
            lItemModelProvider86.basicItem((Item) dataGenContext86.get(), lItemModelProvider86.modLoc("item/aecells/copper"));
        });
        INFINITE_REDSTONE_CELL = ITEM_REGISTRY.register("infinite_cell_redstone", () -> {
            return mctech.a.b.a(Items.REDSTONE);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite redstone cell", "Бесконечная ячейка редстоуна").setModelProvider((lItemModelProvider87, dataGenContext87) -> {
            lItemModelProvider87.basicItem((Item) dataGenContext87.get(), lItemModelProvider87.modLoc("item/aecells/redstone"));
        });
        INFINITE_LAPIS_CELL = ITEM_REGISTRY.register("infinite_cell_lapis", () -> {
            return mctech.a.b.a(Items.LAPIS_LAZULI);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite lapis cell", "Бесконечная ячейка лазурита").setModelProvider((lItemModelProvider88, dataGenContext88) -> {
            lItemModelProvider88.basicItem((Item) dataGenContext88.get(), lItemModelProvider88.modLoc("item/aecells/lapis"));
        });
        INFINITE_MATTER_CELL = ITEM_REGISTRY.register("infinite_cell_matter", () -> {
            return mctech.a.b.b((Supplier<? extends Item>) UUMATTER);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite matter cell", "Бесконечная ячейка материи").setModelProvider((lItemModelProvider89, dataGenContext89) -> {
            lItemModelProvider89.basicItem((Item) dataGenContext89.get(), lItemModelProvider89.modLoc("item/aecells/matter"));
        });
        INFINITE_GOLD_INGOT_CELL = ITEM_REGISTRY.register("infinite_cell_gold_ingot", () -> {
            return mctech.a.b.a(Items.GOLD_INGOT);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite gold ingots cell", "Бесконечная ячейка золотых слитков").setModelProvider((lItemModelProvider90, dataGenContext90) -> {
            lItemModelProvider90.basicItem((Item) dataGenContext90.get(), lItemModelProvider90.modLoc("item/aecells/gold"));
        });
        INFINITE_IRON_INGOT_CELL = ITEM_REGISTRY.register("infinite_cell_iron_ingot", () -> {
            return mctech.a.b.a(Items.IRON_INGOT);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite iron ingots cell", "Бесконечная ячейка железных слитков").setModelProvider((lItemModelProvider91, dataGenContext91) -> {
            lItemModelProvider91.basicItem((Item) dataGenContext91.get(), lItemModelProvider91.modLoc("item/aecells/iron"));
        });
        INFINITE_DIAMOND_CELL = ITEM_REGISTRY.register("infinite_cell_diamond", () -> {
            return mctech.a.b.a(Items.DIAMOND);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite diamonds cell", "Бесконечная ячейка алмазов").setModelProvider((lItemModelProvider92, dataGenContext92) -> {
            lItemModelProvider92.basicItem((Item) dataGenContext92.get(), lItemModelProvider92.modLoc("item/aecells/diamond"));
        });
        INFINITE_COAL_CELL = ITEM_REGISTRY.register("infinite_cell_coal", () -> {
            return mctech.a.b.a(Items.COAL);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite coal cell", "Бесконечная ячейка угля").setModelProvider((lItemModelProvider93, dataGenContext93) -> {
            lItemModelProvider93.basicItem((Item) dataGenContext93.get(), lItemModelProvider93.modLoc("item/aecells/coal"));
        });
        INFINITE_CERTUS_QUARTZ_CELL = ITEM_REGISTRY.register("infinite_cell_certus_quartz", () -> {
            return mctech.a.b.b((Supplier<? extends Item>) AEItems.CERTUS_QUARTZ_CRYSTAL);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite certuz quartz cell", "Бесконечная ячейка кристалов истинного кварца").setModelProvider((lItemModelProvider94, dataGenContext94) -> {
            lItemModelProvider94.basicItem((Item) dataGenContext94.get(), lItemModelProvider94.modLoc("item/aecells/true_quartz"));
        });
        INFINITE_OAK_LOG_CELL = ITEM_REGISTRY.register("infinite_cell_oak_log", () -> {
            return mctech.a.b.a(Items.OAK_LOG);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite oak log cell", "Бесконечная ячейка дубового бревна").setModelProvider((lItemModelProvider95, dataGenContext95) -> {
            lItemModelProvider95.basicItem((Item) dataGenContext95.get(), lItemModelProvider95.modLoc("item/aecells/oakwood"));
        });
        INFINITE_GLOWSTONE_CELL = ITEM_REGISTRY.register("infinite_cell_glowstone", () -> {
            return mctech.a.b.a(Items.GLOWSTONE);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite glowstone cell", "Бесконечная ячейка светокамня").setModelProvider((lItemModelProvider96, dataGenContext96) -> {
            lItemModelProvider96.basicItem((Item) dataGenContext96.get(), lItemModelProvider96.modLoc("item/aecells/glowstone"));
        });
        INFINITE_NETHER_QUARTZ_CELL = ITEM_REGISTRY.register("infinite_cell_quartz", () -> {
            return mctech.a.b.a(Items.QUARTZ);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite quartz cell", "Бесконечная ячейка кварца").setModelProvider((lItemModelProvider97, dataGenContext97) -> {
            lItemModelProvider97.basicItem((Item) dataGenContext97.get(), lItemModelProvider97.modLoc("item/aecells/quartz"));
        });
        INFINITE_RUBBER_CELL = ITEM_REGISTRY.register("infinite_cell_rubber", () -> {
            return mctech.a.b.b((Supplier<? extends Item>) RUBBER);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite rubber cell", "Бесконечная ячейка резины").setModelProvider((lItemModelProvider98, dataGenContext98) -> {
            lItemModelProvider98.basicItem((Item) dataGenContext98.get(), lItemModelProvider98.modLoc("item/aecells/rubber"));
        });
        INFINITE_LAVA_CELL = ITEM_REGISTRY.register("infinite_cell_lava", () -> {
            return mctech.a.b.a((Fluid) Fluids.LAVA);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite lava cell", "Бесконечная ячейка лавы").setModelProvider((lItemModelProvider99, dataGenContext99) -> {
            lItemModelProvider99.basicItem((Item) dataGenContext99.get(), lItemModelProvider99.modLoc("item/aecells/lava"));
        });
        INFINITE_WATER_CELL = ITEM_REGISTRY.register("infinite_cell_water", () -> {
            return mctech.a.b.a((Fluid) Fluids.WATER);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite water cell", "Бесконечная ячейка воды").setModelProvider((lItemModelProvider100, dataGenContext100) -> {
            lItemModelProvider100.basicItem((Item) dataGenContext100.get(), lItemModelProvider100.modLoc("item/aecells/water"));
        });
        INFINITE_GLASS_CELL = ITEM_REGISTRY.register("infinite_cell_glass", () -> {
            return mctech.a.b.a(Items.GLASS);
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite glass cell", "Бесконечная ячейка стекла").setModelProvider((lItemModelProvider101, dataGenContext101) -> {
            lItemModelProvider101.basicItem((Item) dataGenContext101.get(), lItemModelProvider101.modLoc("item/aecells/glass"));
        });
        INFINITE_URANIUM_CELL = ITEM_REGISTRY.register("infinite_cell_uranium", () -> {
            return mctech.a.b.a(ResourceLocation.fromNamespaceAndPath("kubejs", "uranium_ingot"));
        }).setTab(MCTechCreativeTabs.MAIN).setTranslation("Infinite uranium cell", "Бесконечная ячейка урана").setModelProvider((lItemModelProvider102, dataGenContext102) -> {
            lItemModelProvider102.basicItem((Item) dataGenContext102.get(), lItemModelProvider102.modLoc("item/aecells/uranium"));
        });
    }

    private static LItem<Item> registerFuelPellet(b bVar) {
        return ITEM_REGISTRY.registerItem("burnt_fuel_pellet_t" + bVar.c(), Item::new).setTranslation("Burnt fuel pellet T" + bVar.c(), "Сгоревшая паллета T" + bVar.c()).setModelProvider((lItemModelProvider, dataGenContext) -> {
            lItemModelProvider.basicItem((Item) dataGenContext.get(), MCTech.loc(String.format("item/burnt_fuel_pellet/%s", dataGenContext.getName())));
        }).setTab(MCTechCreativeTabs.NUCLEAR);
    }

    @SafeVarargs
    private static <C extends ModuleConfig> void registerModule(mctech.modules.e<C> eVar, ModulesItemFactory<mctech.items.base.d, C> modulesItemFactory, ResourceKey<CreativeModeTab> resourceKey, C... cArr) {
        for (int i = 0; i < cArr.length; i++) {
            int i2 = i + 1;
            mctech.modules.h.a().a(eVar, cArr[i], i2, ITEM_REGISTRY.register("module_" + eVar.a().getPath() + "_" + i2, () -> {
                return (mctech.items.base.d) modulesItemFactory.createItemModule(eVar, i2);
            }).setTab(resourceKey).getId());
        }
    }

    @SafeVarargs
    private static <C extends ModuleConfig> void registerModule(mctech.modules.e<C> eVar, ResourceKey<CreativeModeTab> resourceKey, C... cArr) {
        registerModule(eVar, (eVar2, i) -> {
            return new mctech.items.base.d(eVar2, i, new Item.Properties());
        }, resourceKey, cArr);
    }

    private static <I extends Item, C extends ModuleConfig> LItem<I> registerModule(mctech.modules.e<C> eVar, String str, ModulesItemFactory<I, C> modulesItemFactory, ResourceKey<CreativeModeTab> resourceKey, C c) {
        int iC = mctech.modules.h.a().c((mctech.modules.e<?>) eVar) + 1;
        LItem<I> tab = ITEM_REGISTRY.register(str, () -> {
            return modulesItemFactory.createItemModule(eVar, iC);
        }).setTab(resourceKey);
        mctech.modules.h.a().a(eVar, c, iC, tab.getId());
        return tab;
    }

    private static <I extends Item, C extends ModuleConfig> LItem<I> registerModule(mctech.modules.e<C> eVar, ModulesItemFactory<I, C> modulesItemFactory, ResourceKey<CreativeModeTab> resourceKey, C c) {
        return registerModule(eVar, "module_" + eVar.a().getPath(), modulesItemFactory, resourceKey, c);
    }

    private static <C extends ModuleConfig> LItem<mctech.items.base.d> registerModule(mctech.modules.e<C> eVar, String str, ResourceKey<CreativeModeTab> resourceKey, C c) {
        int iC = mctech.modules.h.a().c((mctech.modules.e<?>) eVar) + 1;
        LItem<mctech.items.base.d> tab = ITEM_REGISTRY.register(str, () -> {
            return new mctech.items.base.d(eVar, iC, new Item.Properties());
        }).setTab(resourceKey);
        mctech.modules.h.a().a(eVar, c, iC, tab.getId());
        return tab;
    }

    private static <C extends ModuleConfig> LItem<mctech.items.base.d> registerModule(mctech.modules.e<C> eVar, ResourceKey<CreativeModeTab> resourceKey, C c) {
        return registerModule(eVar, (eVar2, i) -> {
            return new mctech.items.base.d(eVar2, i, new Item.Properties());
        }, resourceKey, c);
    }

    private static void registerModules() {
        registerModule(MCTechModules.EFFICIENCY, MCTechCreativeTabs.TOOLS, new MultiplierCost(mctech.items.f.DIGGER_COMPOSITE, 15, 1.3f), new MultiplierCost(mctech.items.f.DIGGER_COMPOSITE, 120, 1.7f), new MultiplierCost(mctech.items.f.DIGGER_NANO, 200, 2.0f), new MultiplierCost(mctech.items.f.DIGGER_QUANTUM, 400, 2.5f), new MultiplierCost(mctech.items.f.DIGGER_QUANTUM, 750, 2.9f), new MultiplierCost(mctech.items.f.DIGGER_SINGULAR, 1000, 3.5f), new MultiplierCost(mctech.items.f.DIGGER_ADMIN, i.b, 0.0f));
        registerModule(MCTechModules.DEPTH, MCTechCreativeTabs.TOOLS, new EnergyCost(mctech.items.f.DIGGER_COMPOSITE, 300), new EnergyCost(mctech.items.f.DIGGER_NANO, 600), new EnergyCost(mctech.items.f.DIGGER_QUANTUM, 1000), new EnergyCost(mctech.items.f.DIGGER_SINGULAR, mctech.blockentities.b.k.i), new EnergyCost(mctech.items.f.DIGGER_SINGULAR, 5000));
        registerModule(MCTechModules.RADIUS, MCTechCreativeTabs.TOOLS, new EnergyCost(mctech.items.f.DIGGER_COMPOSITE, 500), new EnergyCost(mctech.items.f.DIGGER_NANO, 1000), new EnergyCost(mctech.items.f.DIGGER_QUANTUM, 2500), new EnergyCost(mctech.items.f.DIGGER_SINGULAR, 3500), new EnergyCost(mctech.items.f.DIGGER_ADMIN, 5000));
        registerModule(MCTechModules.FORTUNE, MCTechCreativeTabs.TOOLS, new MultiplierCost(mctech.items.f.DIGGER_COMPOSITE, 100, 2.0f), new MultiplierCost(mctech.items.f.DIGGER_NANO, 300, 3.0f), new MultiplierCost(mctech.items.f.DIGGER_NANO, 500, 4.0f), new MultiplierCost(mctech.items.f.DIGGER_QUANTUM, 1000, 6.0f));
        registerModule(MCTechModules.ENERGY_SAVING, MCTechCreativeTabs.TOOLS, new Multiplier(mctech.items.f.DIGGER_NANO, 0.15f), new Multiplier(mctech.items.f.DIGGER_QUANTUM, 0.25f), new Multiplier(mctech.items.f.DIGGER_SINGULAR, 0.4f));
        MODULE_SILK_TOUCH = registerModule(MCTechModules.SILK_TOUCH, MCTechCreativeTabs.TOOLS, new EnergyCost(mctech.items.f.DIGGER_QUANTUM, 500));
        registerModule(MCTechModules.AUTO_MELT, MCTechCreativeTabs.TOOLS, new EnergyCost(mctech.items.f.DIGGER_COMPOSITE, 100));
        MODULE_BEDROCK_ORE_DESTROY = registerModule(MCTechModules.BEDROCK_ORE_DESTROYER, MCTechCreativeTabs.TOOLS, new EnergyCost(mctech.items.f.DIGGER_COMPOSITE, 100)).setTranslation("Module: Bedrock ore destroyer", "Модуль: Разрушение бедроковой руды");
        registerModule(MCTechModules.KEEP, MCTechCreativeTabs.TOOLS, new Tier(mctech.items.f.DIGGER_COMPOSITE)).setTranslation("Save module", "Модуль: Сохранение");
        mctech.modules.h.a().a(MCTechModules.ELYTRA, new EnergyCost(EnumC0125a.ARMOR_QUANTUM, 150), 1);
        mctech.modules.h.a().a(MCTechModules.JETPACK, new EnergyCost(EnumC0125a.ARMOR_NANO, 100), 1);
        if (MCTech.isFrozen()) {
            registerModule(MCTechModules.HEAT_SAVING, MCTechCreativeTabs.ARMOR, new EnergyCost(EnumC0125a.ARMOR_COMPOSITE, 150)).setTranslation("Heat save module", "Модуль брони: сохранение тепла");
        }
        registerModule(MCTechModules.DAMAGE_ABSORB, MCTechCreativeTabs.ARMOR, new Multiplier(EnumC0125a.ARMOR_COMPOSITE, 0.05f), new Multiplier(EnumC0125a.ARMOR_NANO, 0.1f), new Multiplier(EnumC0125a.ARMOR_QUANTUM, 0.15f), new Multiplier(EnumC0125a.ARMOR_SINGULAR, 0.2f), new Multiplier(EnumC0125a.ARMOR_ADMIN, 0.3f));
        registerModule(MCTechModules.THORNS, MCTechCreativeTabs.ARMOR, new Multiplier(EnumC0125a.ARMOR_COMPOSITE, 0.05f), new Multiplier(EnumC0125a.ARMOR_QUANTUM, 0.1f), new Multiplier(EnumC0125a.ARMOR_SINGULAR, 0.15f));
        registerModule(MCTechModules.JUMP_BOOST, MCTechCreativeTabs.ARMOR, new AmplifierFloat(EnumC0125a.ARMOR_NANO, 1.0f), new AmplifierFloat(EnumC0125a.ARMOR_QUANTUM, 2.0f), new AmplifierFloat(EnumC0125a.ARMOR_SINGULAR, 3.0f));
        registerModule(MCTechModules.MOVEMENT_SPEED, MCTechCreativeTabs.ARMOR, new Multiplier(EnumC0125a.ARMOR_NANO, 1.3f), new Multiplier(EnumC0125a.ARMOR_QUANTUM, 1.5f), new Multiplier(EnumC0125a.ARMOR_SINGULAR, 1.6f));
        registerModule(MCTechModules.HEALTH_BOOST, MCTechCreativeTabs.ARMOR, new AmplifierFloatCost(EnumC0125a.ARMOR_NANO, 5000, 10.0f), new AmplifierFloatCost(EnumC0125a.ARMOR_QUANTUM, 5000, 20.0f), new AmplifierFloatCost(EnumC0125a.ARMOR_ADMIN, 5000, 40.0f));
        registerModule(MCTechModules.REGENERATION, MCTechCreativeTabs.ARMOR, new AmplifierIntCost(EnumC0125a.ARMOR_QUANTUM, 1000, 0), new AmplifierIntCost(EnumC0125a.ARMOR_ADMIN, mctech.blockentities.b.k.i, 1), new AmplifierIntCost(EnumC0125a.ARMOR_ADMIN, 4000, 2));
        registerModule(MCTechModules.AUTO_FEEDER, MCTechCreativeTabs.ARMOR, new Tier(EnumC0125a.ARMOR_NANO));
        registerModule(MCTechModules.RADIATION_RESISTANCE, MCTechCreativeTabs.ARMOR, new EnergyCost(EnumC0125a.ARMOR_QUANTUM, 500));
        registerModule(MCTechModules.XRAY_VISION, MCTechCreativeTabs.ARMOR, new EnergyCost(EnumC0125a.ARMOR_QUANTUM, 20000));
        registerModule(MCTechModules.KNOCKBACK_RESISTANCE, MCTechCreativeTabs.ARMOR, new Tier(EnumC0125a.ARMOR_SINGULAR));
        registerModule(MCTechModules.CREATIVE_FLIGHT, MCTechCreativeTabs.ARMOR, new EnergyCost(EnumC0125a.ARMOR_SINGULAR, 200));
        registerModule(MCTechModules.WATER_BREATHING, MCTechCreativeTabs.ARMOR, new EnergyCost(EnumC0125a.ARMOR_COMPOSITE, 100));
        registerModule(MCTechModules.NIGHT_VISION, MCTechCreativeTabs.ARMOR, new Tier(EnumC0125a.ARMOR_QUANTUM));
        for (int i = 1; i <= 13; i++) {
            int i2 = i;
            ITEM_REGISTRY.register("blade_" + i, () -> {
                return new mctech.items.e.d(i2);
            }).setTab(MCTechCreativeTabs.WEAPONS);
        }
        registerModule(MCTechModules.SHARPNESS, MCTechCreativeTabs.WEAPONS, new Multiplier(v.SABER_COMPOSITE, 1.2f), new Multiplier(v.SABER_COMPOSITE, 1.4f), new Multiplier(v.SABER_COMPOSITE, 1.6f), new Multiplier(v.SABER_COMPOSITE, 1.8f), new Multiplier(v.SABER_COMPOSITE, 2.0f));
        registerModule(MCTechModules.KNOCKBACK, MCTechCreativeTabs.WEAPONS, new AmplifierInt(v.SABER_COMPOSITE, 1), new AmplifierInt(v.SABER_COMPOSITE, 2), new AmplifierInt(v.SABER_COMPOSITE, 3));
        registerModule(MCTechModules.FIRE_ASPECT, MCTechCreativeTabs.WEAPONS, new AmplifierInt(v.SABER_COMPOSITE, 2), new AmplifierInt(v.SABER_COMPOSITE, 4), new AmplifierInt(v.SABER_COMPOSITE, 6), new AmplifierInt(v.SABER_COMPOSITE, 12));
        registerModule(MCTechModules.ICE_ASPECT, MCTechCreativeTabs.WEAPONS, new AmplifierInt(v.SABER_COMPOSITE, 2), new AmplifierInt(v.SABER_COMPOSITE, 4), new AmplifierInt(v.SABER_COMPOSITE, 6), new AmplifierInt(v.SABER_COMPOSITE, 12));
        registerModule(MCTechModules.LOOTING, MCTechCreativeTabs.WEAPONS, new AmplifierInt(v.SABER_COMPOSITE, 1), new AmplifierInt(v.SABER_COMPOSITE, 2), new AmplifierInt(v.SABER_COMPOSITE, 3), new AmplifierInt(v.SABER_COMPOSITE, 4), new AmplifierInt(v.SABER_COMPOSITE, 5));
        registerModule(MCTechModules.SOUL_REAPER, MCTechCreativeTabs.WEAPONS, new mctech.modules.j(v.SABER_COMPOSITE, 0.02f, false, false, 0.0f, 0.0f), new mctech.modules.j(v.SABER_COMPOSITE, 0.05f, true, false, 0.0f, 0.0f), new mctech.modules.j(v.SABER_COMPOSITE, 0.08f, true, true, 0.0f, 0.0f), new mctech.modules.j(v.SABER_COMPOSITE, 0.08f, true, true, 0.03f, 0.0f), new mctech.modules.j(v.SABER_COMPOSITE, 0.08f, true, true, 0.03f, 0.01f));
        registerModule(MCTechModules.GENETIC_EXTRACTOR, "module_genetic_extractor", MCTechCreativeTabs.WEAPONS, new Multiplier(v.SABER_COMPOSITE, mctech.k.a.b())).setTranslation("Module: Genetic extractor", "Модуль: Генетический экстрактор");
    }

    @Deprecated(since = "Direct use MSRegistry registration!!!", forRemoval = true)
    private static LItem<j> registerSimple(String str, ResourceKey<CreativeModeTab> resourceKey) {
        return registerItem(str, () -> {
            return new j(new mctech.items.base.o());
        }, resourceKey);
    }

    @Nonnull
    private static LItem<mctech.items.e.b> newArmor(@Nonnull EnumC0125a enumC0125a) {
        return ITEM_REGISTRY.register(enumC0125a.name().toLowerCase(Locale.ROOT).substring(6) + "_chest", () -> {
            return new mctech.items.e.b(enumC0125a);
        }).setTab(MCTechCreativeTabs.ARMOR).setTranslation(String.format("%s chestplate", enumC0125a.e().engTranslation()), String.format("%s нагрудник", enumC0125a.e().ruForm(RussianForm.MASCULINE_NOMINATIVE)));
    }

    /* JADX INFO: renamed from: mctech.init.MCTechItems$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechItems$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$world$item$ArmorItem$Type = new int[ArmorItem.Type.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$world$item$ArmorItem$Type[ArmorItem.Type.HELMET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$world$item$ArmorItem$Type[ArmorItem.Type.LEGGINGS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$world$item$ArmorItem$Type[ArmorItem.Type.BOOTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Nonnull
    private static LItem<mctech.items.e.a> newArmor(@Nonnull EnumC0125a enumC0125a, @Nonnull ArmorItem.Type type) {
        String str;
        String str2;
        String str3;
        String strRuForm;
        switch (AnonymousClass1.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[type.ordinal()]) {
            case 1:
                str = "helmet";
                break;
            case 2:
                str = "legs";
                break;
            case 3:
                str = "boot";
                break;
            default:
                throw new UnsupportedOperationException();
        }
        String str4 = str;
        switch (AnonymousClass1.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[type.ordinal()]) {
            case 1:
                str2 = "helmet";
                break;
            case 2:
                str2 = "leggings";
                break;
            case 3:
                str2 = "boots";
                break;
            default:
                str2 = "Unknown";
                break;
        }
        String str5 = str2;
        switch (AnonymousClass1.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[type.ordinal()]) {
            case 1:
                str3 = "шлем";
                break;
            case 2:
                str3 = "поножи";
                break;
            case 3:
                str3 = "ботинки";
                break;
            default:
                str3 = "Unknown";
                break;
        }
        String str6 = str3;
        switch (AnonymousClass1.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[type.ordinal()]) {
            case 2:
            case 3:
                strRuForm = enumC0125a.e().ruForm(RussianForm.PLURAL_NOMINATIVE);
                break;
            default:
                strRuForm = enumC0125a.e().ruForm(RussianForm.MASCULINE_NOMINATIVE);
                break;
        }
        return ITEM_REGISTRY.register(enumC0125a.name().toLowerCase(Locale.ROOT).substring(6) + "_" + str4, () -> {
            return new mctech.items.e.a(enumC0125a, type);
        }).setTranslation(String.format("%s %s", enumC0125a.e().engTranslation(), str5), String.format("%s %s", strRuForm, str6)).setTab(MCTechCreativeTabs.ARMOR);
    }

    @Deprecated(since = "Direct use MSRegistry registration!!!", forRemoval = true)
    public static <T extends Item> LItem<T> dumbItem(String str, Function<Item.Properties, T> function) {
        return ITEM_REGISTRY.registerItem(str, function);
    }

    @Deprecated(since = "Direct use MSRegistry registration!!!", forRemoval = true)
    public static <T extends Item> LItem<T> registerConsumable(String str, String str2, com.google.common.base.Supplier<T> supplier) {
        return registerItem(String.format("consumable_%s_%s", str, str2), supplier, MCTechCreativeTabs.NUCLEAR);
    }

    @Deprecated(since = "Direct use MSRegistry registration!!!", forRemoval = true)
    public static <T extends Item> LItem<T> registerConsumable(String str, Consumables consumables, com.google.common.base.Supplier<T> supplier) {
        return registerConsumable(str, consumables.getName(), supplier);
    }

    public static void register(IEventBus iEventBus) {
        ITEM_REGISTRY.register(iEventBus);
    }

    @Deprecated(since = "Direct use MSRegistry registration!!!", forRemoval = true)
    public static <T extends Block & mctech.blocks.base.a> LItem<mctech.items.base.g> registerBlockItem(String str, DeferredBlock<T> deferredBlock, ResourceKey<CreativeModeTab> resourceKey) {
        return ITEM_REGISTRY.register(str, () -> {
            return ((Block) deferredBlock.get()).createItem();
        }).setTab(resourceKey);
    }

    @Deprecated(since = "Direct use MSRegistry registration!!!", forRemoval = true)
    public static <T extends Item> LItem<T> materialItem(String str, com.google.common.base.Supplier<T> supplier) {
        return registerItem(str, supplier, MCTechCreativeTabs.MATERIALS);
    }

    @Deprecated(since = "Direct use MSRegistry registration!!!", forRemoval = true)
    public static <T extends Item> LItem<T> registerItemHidden(String str, com.google.common.base.Supplier<T> supplier) {
        return ITEM_REGISTRY.register(str, supplier);
    }

    @Deprecated(since = "Direct use MSRegistry registration!!!", forRemoval = true)
    public static <T extends Item> LItem<T> registerItem(String str, com.google.common.base.Supplier<T> supplier, ResourceKey<CreativeModeTab> resourceKey) {
        return ITEM_REGISTRY.register(str, supplier).setTab(resourceKey);
    }

    private static LItem<z> registerWindmillRotor(A a) {
        return ITEM_REGISTRY.registerItem(a.g(), properties -> {
            Item.Properties propertiesStacksTo = properties.stacksTo(1);
            if (!a.d()) {
                propertiesStacksTo = propertiesStacksTo.durability(a.c());
            }
            return new z(propertiesStacksTo, a);
        }).setTranslation(a.e(), a.f()).setModelProvider((lItemModelProvider, dataGenContext) -> {
            GeckoData.item(lItemModelProvider, dataGenContext).transforms().transform(ItemDisplayContext.GUI).rotation(0.0f, -90.0f, 0.0f).translation(0.0f, -1.75f, 0.0f).scale(0.18f, 0.18f, 0.18f).end().transform(ItemDisplayContext.GROUND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, 2.0f, 0.0f).scale(0.1f, 0.1f, 0.1f).end().transform(ItemDisplayContext.HEAD).rotation(0.0f, 90.0f, 0.0f).translation(0.0f, 0.0f, 0.0f).scale(1.0f, 1.0f, 1.0f).end().transform(ItemDisplayContext.FIXED).rotation(180.0f, 90.0f, 180.0f).translation(0.0f, -2.25f, 0.0f).scale(0.2f, 0.2f, 0.2f).end().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(0.0f, 0.0f, 90.0f).translation(0.0f, 0.5f, 1.0f).scale(0.1f, 0.1f, 0.1f).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(0.0f, 0.0f, 90.0f).translation(0.0f, 0.5f, 1.0f).scale(0.1f, 0.1f, 0.1f).end().transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(-180.0f, 0.0f, -155.0f).translation(1.13f, 3.2f, 1.13f).scale(0.1f, 0.1f, 0.1f).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(-180.0f, 0.0f, -155.0f).translation(1.13f, 3.2f, 1.13f).scale(0.1f, 0.1f, 0.1f).end().end();
        }).setTab(MCTechCreativeTabs.ENERGY);
    }

    public static <T extends Item> LItem<T> rawMaterialItem(String str, com.google.common.base.Supplier<T> supplier, String str2, String str3, Set<TagKey<Item>> set) {
        return ITEM_REGISTRY.registerItem(str, properties -> {
            return (Item) supplier.get();
        }).setTranslation(str2, str3).setModelProvider((lItemModelProvider, dataGenContext) -> {
            lItemModelProvider.basicItem((Item) dataGenContext.get(), MCTech.loc(String.format("item/raw/%s", dataGenContext.getName())));
        }).addItemTags((TagKey[]) set.toArray(new TagKey[0])).setTab(MCTechCreativeTabs.MATERIALS);
    }

    private static LItem<mctech.items.f.j.a> registerScanner(String str, String str2, TagKey<Block> tagKey) {
        return ITEM_REGISTRY.registerItem(String.format("xray_%s_scanner", str), properties -> {
            return new mctech.items.f.j.a(properties, mctech.y.a.a((TagKey<Block>) tagKey, 230652, 0.6f));
        }, new Item.Properties()).setTranslation(String.format("Simple %s ore scanner", str), String.format("Простой сканер %s руды", str2)).setModelProvider((lItemModelProvider, dataGenContext) -> {
            lItemModelProvider.basicItem((Item) dataGenContext.get(), MCTech.loc(String.format("item/upgrades/xray/%s", dataGenContext.getName())));
        }).setTab(MCTechCreativeTabs.UPGRADES);
    }

    private static LItem<mctech.items.f.j.a> registerScanner(String str, String str2, ResourceLocation resourceLocation) {
        return ITEM_REGISTRY.registerItem(String.format("xray_%s_scanner", str), properties -> {
            return new mctech.items.f.j.a(properties, new mctech.y.a(mctech.y.a.EnumC0053a.BLOCK, resourceLocation, mctech.y.c.COLORED, 230652, 255, 0.6f));
        }, new Item.Properties()).setTranslation(String.format("Simple %s ore scanner", str), String.format("Простой сканер %s руды", str2)).setModelProvider((lItemModelProvider, dataGenContext) -> {
            lItemModelProvider.basicItem((Item) dataGenContext.get(), MCTech.loc(String.format("item/upgrades/xray/%s", dataGenContext.getName())));
        }).setTab(MCTechCreativeTabs.UPGRADES);
    }

    private static LItem<mctech.items.f.j.a> registerColoredScanner(String str, String str2, TagKey<Block> tagKey) {
        return ITEM_REGISTRY.registerItem(String.format("xray_%s_color_scanner", str), properties -> {
            return new mctech.items.f.j.a(properties, mctech.y.a.a((TagKey<Block>) tagKey, 170));
        }, new Item.Properties()).setTranslation(String.format("Advanced %s ore scanner", str), String.format("Улучшенный сканер %s руды", str2)).setModelProvider((lItemModelProvider, dataGenContext) -> {
            lItemModelProvider.basicItem((Item) dataGenContext.get(), MCTech.loc(String.format("item/upgrades/xray/%s", dataGenContext.getName())));
        }).setTab(MCTechCreativeTabs.UPGRADES);
    }

    private static LItem<mctech.items.f.j.a> registerColoredScanner(String str, String str2, ResourceLocation resourceLocation) {
        return ITEM_REGISTRY.registerItem(String.format("xray_%s_color_scanner", str), properties -> {
            return new mctech.items.f.j.a(properties, new mctech.y.a(mctech.y.a.EnumC0053a.BLOCK, resourceLocation, mctech.y.c.TEXTURED, 0, 170, 0.0f));
        }, new Item.Properties()).setTranslation(String.format("Advanced %s ore scanner", str), String.format("Улучшенный сканер %s руды", str2)).setModelProvider((lItemModelProvider, dataGenContext) -> {
            lItemModelProvider.basicItem((Item) dataGenContext.get(), MCTech.loc(String.format("item/upgrades/xray/%s", dataGenContext.getName())));
        }).setTab(MCTechCreativeTabs.UPGRADES);
    }

    private static void registerEnhancedCable(int i, String str, String str2) {
        Map mapOfEntries = Map.ofEntries(Map.entry(AEColor.WHITE, "Белый"), Map.entry(AEColor.LIGHT_GRAY, "Светло-серый"), Map.entry(AEColor.GRAY, "Серый"), Map.entry(AEColor.BLACK, "Чёрный"), Map.entry(AEColor.LIME, "Лаймовый"), Map.entry(AEColor.YELLOW, "Жёлтый"), Map.entry(AEColor.ORANGE, "Оранжевый"), Map.entry(AEColor.BROWN, "Коричневый"), Map.entry(AEColor.RED, "Красный"), Map.entry(AEColor.PINK, "Розовый"), Map.entry(AEColor.MAGENTA, "Пурпурный"), Map.entry(AEColor.PURPLE, "Фиолетовый"), Map.entry(AEColor.BLUE, "Синий"), Map.entry(AEColor.LIGHT_BLUE, "Голубой"), Map.entry(AEColor.CYAN, "Бирюзовый"), Map.entry(AEColor.GREEN, "Зеленый"), Map.entry(AEColor.TRANSPARENT, "Прозрачный"));
        for (AEColor aEColor : AEColor.values()) {
            ENHANCED_CABLE_TIER_PARTS.put(aEColor, ITEM_REGISTRY.registerItem(String.format("enhanced_cable_%sk_%s", Integer.valueOf(i), aEColor.registryPrefix), properties -> {
                return new ColoredPartItem(properties, a.class, coloredPartItem -> {
                    return new a(coloredPartItem, i);
                }, aEColor);
            }, new Item.Properties()).setTab(MCTechCreativeTabs.MAIN).setTranslation(String.format("%s %s", aEColor.englishName, str), String.format("%s %s", mapOfEntries.get(aEColor), str2)).setModelProvider((lItemModelProvider, dataGenContext) -> {
                lItemModelProvider.getBuilder(dataGenContext.getId().toString()).parent(new ModelFile.UncheckedModelFile("ae2:item/part_base")).texture("base", MCTech.loc(String.format("part/cable/enhanced_cable/%s", aEColor.name().toLowerCase(Locale.ROOT)))).element().from(5.0f, 5.0f, 2.0f).to(11.0f, 11.0f, 14.0f).face(Direction.DOWN).texture("#base").uvs(5.0f, 11.0f, 11.0f, 16.0f).end().face(Direction.UP).texture("#base").uvs(5.0f, 0.0f, 11.0f, 5.0f).end().face(Direction.NORTH).texture("#base").uvs(5.0f, 5.0f, 11.0f, 11.0f).end().face(Direction.SOUTH).texture("#base").uvs(11.0f, 5.0f, 5.0f, 11.0f).end().face(Direction.WEST).texture("#base").uvs(5.0f, 5.0f, 0.0f, 11.0f).end().face(Direction.EAST).texture("#base").uvs(0.0f, 5.0f, 5.0f, 11.0f).end().end();
            }));
        }
    }
}
