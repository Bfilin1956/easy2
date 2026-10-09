package mctech.init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import mctech.MCTech;
import mctech.api.blocks.IBlockDropProvider;
import mctech.blocks.b.d;
import mctech.blocks.b.e;
import mctech.blocks.b.f;
import mctech.blocks.base.blocks.a;
import mctech.blocks.c.A;
import mctech.blocks.c.B;
import mctech.blocks.c.C;
import mctech.blocks.c.C0080a;
import mctech.blocks.c.C0083d;
import mctech.blocks.c.C0084e;
import mctech.blocks.c.C0085f;
import mctech.blocks.c.C0086g;
import mctech.blocks.c.D;
import mctech.blocks.c.E;
import mctech.blocks.c.F;
import mctech.blocks.c.G;
import mctech.blocks.c.h;
import mctech.blocks.c.i;
import mctech.blocks.c.j;
import mctech.blocks.c.k;
import mctech.blocks.c.l;
import mctech.blocks.c.n;
import mctech.blocks.c.p;
import mctech.blocks.c.q;
import mctech.blocks.c.r;
import mctech.blocks.c.s;
import mctech.blocks.c.t;
import mctech.blocks.c.w;
import mctech.blocks.c.x;
import mctech.blocks.c.y;
import mctech.blocks.c.z;
import mctech.blocks.d.b;
import mctech.blocks.d.c;
import mctech.blocks.e.g;
import mctech.items.C0126b;
import mctech.items.m;
import mctech.items.u;
import net.mcskill.msregistry.core.MachineTier;
import net.mcskill.msregistry.datagen.DataGenContext;
import net.mcskill.msregistry.datagen.GeckoData;
import net.mcskill.msregistry.registry.holder.LBlock;
import net.mcskill.msregistry.registry.holder.LItem;
import net.mcskill.msregistry.registry.type.BlockRegistry;
import net.mcskill.msregistry.registry.type.ItemRegistry;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredBlock;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechBlocks.class */
public class MCTechBlocks {
    private static final BlockBehaviour.Properties DEFAULT_MACHINE = BlockBehaviour.Properties.of().strength(5.0f, 10.0f).requiresCorrectToolForDrops().noOcclusion().noTerrainParticles().mapColor(MapColor.METAL).sound(SoundType.METAL);
    private static final BlockBehaviour.Properties STONE_MACHINE = BlockBehaviour.Properties.of().strength(1.5f, 6.0f).requiresCorrectToolForDrops().noOcclusion().noTerrainParticles().mapColor(MapColor.STONE).sound(SoundType.STONE);
    public static final BlockSetType RUBBER_BLOCK_SET = BlockSetType.register(new BlockSetType("rubber"));
    private static final ItemRegistry ITEM_REGISTRY = MCTech.REGISTRY.itemRegistry();
    private static final BlockRegistry BLOCK_REGISTRY = MCTech.REGISTRY.blockRegistry();
    public static final HashMap<MachineTier, LBlock<i>> REGISTERED_WATER_GENERATORS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<i>> REGISTERED_LAVA_GENERATORS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<j>> REGISTERED_FLUID_TANKS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<C0085f>> REGISTERED_COBBLESTONE_GENERATORS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<A>> REGISTERED_PLASMA_GENERATORS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<a>> REGISTERED_FORMERS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<f>> REGISTERED_NUCLEAR_CHAMBERS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<e>> REGISTERED_NUCLEAR_REACTORS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<a>> REGISTERED_MASS_FABRICATORS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<a>> REGISTERED_CRYSTAL_SYNTH = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<a>> REGISTERED_METAL_FORMERS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<a>> REGISTERED_RARE_EXTRACTORS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<a>> REGISTERED_ALLOY_SMELTERS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<a>> REGISTERED_ELECTRONIC_PLANTS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<a>> REGISTERED_COMPRESSORS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<a>> REGISTERED_FURNACES = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<a>> REGISTERED_MACERATORS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<a>> REGISTERED_EXTRACTORS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<a>> REGISTERED_SINGULARITY_COLLECTORS = new HashMap<>();
    public static final HashMap<MachineTier, LBlock<mctech.blocks.f.a>> REGISTERED_CHARGE_PADS = new HashMap<>();
    public static final LBlock<B> QUANTUM_COMPOSTER;
    public static final LBlock<C0086g> FARMING_STATION;
    public static final LBlock<h> FARMING_STATION_CULTIVATOR;
    public static final LBlock<a> MATRIX_CONVERTER;
    public static final LBlock<mctech.a.a.b.a> WIRELESS_CONNECTOR_64K;
    public static final LBlock<mctech.a.a.b.a> WIRELESS_CONNECTOR_128K;
    public static final LBlock<mctech.a.a.b.a> WIRELESS_CONNECTOR_256K;
    public static final LBlock<l> GLASS_FURNACE;
    public static final LBlock<mctech.blocks.b.j> WINDMILL;
    public static final LBlock<d> QUANTUM_GENERATOR;
    public static final LBlock<mctech.blocks.d.a> MOLECULAR_CONVERTER_CORE_BLOCK;
    public static final LBlock<b> MOLECULAR_CONVERTER_FRAME_BLOCK;
    public static final LBlock<c> MOLECULAR_CONVERTER_GLASS_BLOCK;
    public static final LBlock<r> ITEM_DUPLICATOR;
    public static final LBlock<q> ITEM_DESTROYER;
    public static final LBlock<x> PATTERN_FORGE_ENCODER;
    public static final LBlock<y> PATTERN_QUANTUM_WORKBENCH_ENCODER;
    public static final LBlock<w> PATTERN_ASSEMBLY_ENCODER;
    public static final LBlock<mctech.g.d.a.a.a> CONDUIT;
    public static final LBlock<t> MOLECULAR_CONVERTER;
    public static final LBlock<C> QUANTUM_WORKBENCH;
    public static final LBlock<C0083d> ASSEMBLY_STATION;
    public static final LBlock<F> TRANSFORMATION_ASSEMBLER;
    public static final LBlock<z> PATTERN_TRANSFORMATION_ASSEMBLER_ENCODER;
    public static final LBlock<C0084e> ATOMIC_SMELTER;
    public static final LBlock<n> GRINDING_MACHINE;
    public static final LBlock<G> VENDING_MACHINE;
    public static final LBlock<D> REACTOR_PLANNER;
    public static final LBlock<mctech.blocks.e> BASE_TELEPORTER;
    public static final LBlock<mctech.blocks.e> ELEVATOR_TELEPORTER;
    public static final LBlock<mctech.blocks.e> LINKED_TELEPORTER;
    public static DeferredBlock<s> COMPOSITE_MACHINE_BLOCK;
    public static DeferredBlock<s> NANO_MACHINE_BLOCK;
    public static DeferredBlock<s> QUANTUM_MACHINE_BLOCK;
    public static DeferredBlock<s> SINGULAR_MACHINE_BLOCK;
    public static DeferredBlock<s> ADMIN_MACHINE_BLOCK;
    public static final LBlock<E> STONE_COMPRESSOR;
    public static final LBlock<E> STONE_EXTRACTOR;
    public static final LBlock<C0080a> NANO_RECYCLER;
    public static final LBlock<C0080a> QUANTUM_RECYCLER;
    public static final LBlock<C0080a> SINGULAR_RECYCLER;
    public static final LBlock<C0080a> NANO_REFINERY;
    public static final LBlock<C0080a> QUANTUM_REFINERY;
    public static final LBlock<C0080a> SINGULAR_REFINERY;
    public static final LBlock<C0080a> CRYSTAL_GROWTH_CHAMBER;
    public static final LBlock<p> INDUSTRIAL_FORGE;
    public static final LBlock<k> GENETIC_SEQUENTOR;
    public static final LBlock<k> GENETIC_STABILIZER;
    public static final LBlock<k> SYNTHETIC_PRINTER;
    public static final LBlock<k> EXPERIENCE_EXTRACTOR;
    public static final List<Block> COLORABLE;
    public static DeferredBlock<mctech.blocks.base.d> RESIN_SHEET;
    public static LBlock<mctech.blocks.e.c> AMETHYST;
    public static LBlock<mctech.blocks.e.c> DEEPSLATE_AMETHYST;
    public static LBlock<mctech.blocks.e.c> TIN_ORE;
    public static LBlock<mctech.blocks.e.c> SILVER_ORE;
    public static LBlock<mctech.blocks.e.c> URANIUM_ORE;
    public static LBlock<mctech.blocks.e.c> SILVER_ORE_NETHER;
    public static LBlock<mctech.blocks.e.c> ALUMINUM_ORE_NETHER;
    public static LBlock<mctech.blocks.e.c> DEEPSLATE_TIN_ORE;
    public static LBlock<mctech.blocks.e.c> DEEPSLATE_SILVER_ORE;
    public static LBlock<mctech.blocks.e.c> DEEPSLATE_URANIUM_ORE;
    public static LBlock<mctech.blocks.e.c> RUBIDIUM_ORE;
    public static LBlock<mctech.blocks.e.c> TITANIUM_ORE;
    public static LBlock<mctech.blocks.e.d> RAW_TIN_BLOCK;
    public static LBlock<mctech.blocks.e.d> RAW_SILVER_BLOCK;
    public static LBlock<mctech.blocks.e.d> RAW_ALUMINIUM_BLOCK;
    public static LBlock<mctech.blocks.e.d> RAW_URANIUM_BLOCK;
    public static DeferredBlock<mctech.blocks.c> DUST_IRON_BLOCK;
    public static DeferredBlock<mctech.blocks.c> DUST_GOLD_BLOCK;
    public static DeferredBlock<mctech.blocks.c> DUST_COPPER_BLOCK;
    public static DeferredBlock<mctech.blocks.c> DUST_TIN_BLOCK;
    public static DeferredBlock<mctech.blocks.c> DUST_BRONZE_BLOCK;
    public static DeferredBlock<mctech.blocks.c> DUST_SILVER_BLOCK;
    public static DeferredBlock<mctech.blocks.c> DUST_ALUMINIUM_BLOCK;
    public static LBlock<mctech.blocks.e.e> REFINED_IRON_BLOCK;
    public static LBlock<mctech.blocks.e.e> BRONZE_BLOCK;
    public static LBlock<mctech.blocks.e.e> CHARCOAL_BLOCK;
    public static LBlock<mctech.blocks.e.e> SILVER_BLOCK;
    public static LBlock<mctech.blocks.e.e> TIN_BLOCK;
    public static LBlock<mctech.blocks.e.e> URANIUM_BLOCK;
    public static LBlock<mctech.blocks.e.e> ALUMINIUM_BLOCK;
    public static DeferredBlock<mctech.blocks.base.d> SCAFFOLD_WOOD;
    public static DeferredBlock<mctech.blocks.base.d> MACHINE_BLOCK;
    public static DeferredBlock<mctech.blocks.base.d> MACHINE_BLOCK_PLATED;
    public static DeferredBlock<mctech.blocks.base.d> ADVANCED_MACHINE_BLOCK;
    public static DeferredBlock<mctech.blocks.base.d> STABILIZED_MACHINE_BLOCK;
    public static DeferredBlock<mctech.blocks.base.e> RECYCLER;
    public static DeferredBlock<mctech.blocks.base.e> SAWMILL;
    public static DeferredBlock<mctech.blocks.base.e> RARE_EARTH_EXTRACTOR;
    public static DeferredBlock<mctech.blocks.base.e> CANNER;
    public static LBlock<mctech.blocks.base.e> ELECTROLYZER;
    public static LBlock<mctech.blocks.base.e> CHARGED_ELECTROLYZER;
    public static DeferredBlock<mctech.blocks.base.e> CENTRIFUGAL_RARE_EARTH_EXTRACTOR;
    public static DeferredBlock<mctech.blocks.base.e> REFINERY;
    public static DeferredBlock<mctech.blocks.base.e> URANIUM_ENRICHER;
    public static LBlock<mctech.blocks.base.e> GENERATOR;
    public static LBlock<mctech.blocks.base.e> GEOTHERMAL_GENERATOR;
    public static DeferredBlock<mctech.blocks.base.e> SOLAR_PANEL_COMPRESSED;
    public static DeferredBlock<mctech.blocks.base.e> SLAG_GENERATOR;
    public static DeferredBlock<mctech.blocks.b.b> WATER_MILL;
    public static DeferredBlock<mctech.blocks.b.b> WATER_MILL_T2;
    public static DeferredBlock<mctech.blocks.b.b> WATER_MILL_T3;
    public static DeferredBlock<mctech.blocks.b.b> WATER_MILL_T4;
    public static DeferredBlock<mctech.blocks.base.e> THERMAL_GENERATOR;
    public static DeferredBlock<mctech.blocks.b.a> STANDARD_SOLAR_PANEL;
    public static DeferredBlock<mctech.blocks.b.a> SIMPLE_SOLAR_PANEL;
    public static DeferredBlock<mctech.blocks.b.a> ADVANCED_SOLAR_PANEL;
    public static DeferredBlock<mctech.blocks.b.a> HYBRID_SOLAR_PANEL;
    public static DeferredBlock<mctech.blocks.b.a> PROTON_SOLAR_PANEL;
    public static DeferredBlock<mctech.blocks.b.a> COMPOSITE_SOLAR_PANEL;
    public static DeferredBlock<mctech.blocks.b.a> NANO_SOLAR_PANEL;
    public static DeferredBlock<mctech.blocks.b.a> QUANT_SOLAR_PANEL;
    public static DeferredBlock<mctech.blocks.b.a> SINGULAR_SOLAR_PANEL;
    public static DeferredBlock<mctech.blocks.b.a> ADMIN_SOLAR_PANEL;
    public static DeferredBlock<mctech.blocks.b.c> COMPOSITE_MULTISOLAR_PANEL;
    public static DeferredBlock<mctech.blocks.b.c> NANO_MULTISOLAR_PANEL;
    public static DeferredBlock<mctech.blocks.b.c> QUANT_MULTISOLAR_PANEL;
    public static DeferredBlock<mctech.blocks.b.c> SINGULAR_MULTISOLAR_PANEL;
    public static DeferredBlock<mctech.blocks.b.c> RUBID_MULTISOLAR_PANEL;
    public static LBlock<mctech.blocks.b.h> THERMONUCLEAR_REACTOR;
    public static LBlock<mctech.blocks.b.i> THERMONUCLEAR_REACTOR_DUMMY;
    public static DeferredBlock<mctech.blocks.f.c> ENERGY_STORAGE_1;
    public static DeferredBlock<mctech.blocks.f.c> ENERGY_STORAGE_2;
    public static DeferredBlock<mctech.blocks.f.c> ENERGY_STORAGE_3;
    public static DeferredBlock<mctech.blocks.f.c> ENERGY_STORAGE_4;
    public static DeferredBlock<mctech.blocks.f.c> ENERGY_STORAGE_5;
    public static DeferredBlock<mctech.blocks.f.c> ENERGY_STORAGE_6;
    public static DeferredBlock<mctech.blocks.f.c> ENERGY_STORAGE_7;
    public static DeferredBlock<mctech.blocks.f.c> ENERGY_STORAGE_8;
    public static DeferredBlock<mctech.blocks.f.c> ENERGY_STORAGE_9;
    public static DeferredBlock<mctech.blocks.f.c> ENERGY_STORAGE_10;
    public static DeferredBlock<mctech.blocks.base.d> TANK;
    public static DeferredBlock<mctech.blocks.f.d> TRANSFORMER_0;
    public static DeferredBlock<mctech.blocks.f.d> TRANSFORMER_1;
    public static DeferredBlock<mctech.blocks.f.d> TRANSFORMER_2;
    public static DeferredBlock<mctech.blocks.f.d> TRANSFORMER_3;
    public static DeferredBlock<mctech.blocks.f.d> TRANSFORMER_4;
    public static DeferredBlock<mctech.blocks.f.d> TRANSFORMER_5;
    public static DeferredBlock<mctech.blocks.f.d> TRANSFORMER_6;
    public static DeferredBlock<mctech.blocks.f.d> TRANSFORMER_ADJUSTABLE_1;
    public static DeferredBlock<mctech.blocks.f.d> TRANSFORMER_7;
    public static DeferredBlock<mctech.blocks.f.d> TRANSFORMER_8;
    public static DeferredBlock<mctech.blocks.f.d> TRANSFORMER_9;
    public static DeferredBlock<mctech.blocks.f.d> TRANSFORMER_ADJUSTABLE_2;
    public static DeferredBlock<mctech.blocks.f.b> CHARGING_BENCH_1;
    public static DeferredBlock<mctech.blocks.f.b> CHARGING_BENCH_2;
    public static DeferredBlock<mctech.blocks.f.b> CHARGING_BENCH_3;
    public static DeferredBlock<mctech.blocks.f.b> CHARGING_BENCH_4;
    public static DeferredBlock<mctech.blocks.f.b> CHARGING_BENCH_5;
    public static DeferredBlock<mctech.blocks.f.b> CHARGING_BENCH_6;
    public static DeferredBlock<mctech.blocks.f.b> CHARGING_BENCH_7;
    public static DeferredBlock<mctech.blocks.f.b> CHARGING_BENCH_8;
    public static DeferredBlock<mctech.blocks.f.b> CHARGING_BENCH_9;
    public static DeferredBlock<mctech.blocks.f.b> CHARGING_BENCH_10;
    public static DeferredBlock<mctech.blocks.base.d> REDIRECTOR_SLAVE;
    public static LBlock<mctech.blocks.b> IRON_FURNACE;
    public static LBlock<mctech.blocks.b> STONE_MACERATOR;
    public static LBlock<mctech.blocks.b> STONE_CANNER;
    public static DeferredBlock<mctech.blocks.base.d> COLOSSAL_BASE;
    public static DeferredBlock<mctech.blocks.base.d> RUBBERWOOD_LOG;
    public static DeferredBlock<mctech.blocks.base.d> RUBBER_LOG_STRIPPED;
    public static DeferredBlock<mctech.blocks.base.d> RUBBERWOOD_LOG_BARKED;
    public static DeferredBlock<mctech.blocks.base.d> RUBBER_LOG_BARKED_STRIPPED;
    public static LBlock<g> RUBBER_LEAVES;
    public static LBlock<mctech.blocks.e.i> RUBBER_SAPLING;
    public static LBlock<DoorBlock> RUBBER_DOOR;
    public static LBlock<TrapDoorBlock> RUBBER_TRAPDOOR;
    public static LBlock<Block> RUBBER_PLANKS;
    public static DeferredBlock<mctech.blocks.base.d> CFOAM_WET;
    public static DeferredBlock<mctech.blocks.base.d> REINFORCED_STONE;
    public static DeferredBlock<mctech.blocks.base.d> REINFORCED_CRACKED_STONE;
    public static DeferredBlock<mctech.blocks.base.d> REINFORCED_BRICK;
    public static DeferredBlock<mctech.blocks.base.d> REINFORCED_GLASS;
    public static LBlock<mctech.blocks.b> DUST_FACTORY;
    public static LBlock<mctech.blocks.b> GREENHOUSE;
    public static LBlock<mctech.blocks.e.b> BEDROCK;
    public static LBlock<mctech.blocks.e.b> BEDROCK_AMETHYST;
    public static LBlock<mctech.blocks.e.b> BEDROCK_COAL;
    public static LBlock<mctech.blocks.e.b> BEDROCK_COPPER;
    public static LBlock<mctech.blocks.e.b> BEDROCK_DIAMOND;
    public static LBlock<mctech.blocks.e.b> BEDROCK_EMERALD;
    public static LBlock<mctech.blocks.e.b> BEDROCK_GOLD;
    public static LBlock<mctech.blocks.e.b> BEDROCK_IRON;
    public static LBlock<mctech.blocks.e.b> BEDROCK_LAPIS;
    public static LBlock<mctech.blocks.e.b> BEDROCK_REDSTONE;
    public static LBlock<mctech.blocks.e.b> BEDROCK_SILVER;
    public static LBlock<mctech.blocks.e.b> BEDROCK_TIN;
    public static LBlock<mctech.blocks.e.b> BEDROCK_URANIUM;
    public static LBlock<mctech.blocks.e.b> BEDROCK_TUNGSTEN;
    public static LBlock<mctech.blocks.e.b> BEDROCK_NETHERITE;
    public static LBlock<mctech.blocks.e.b> BEDROCK_TITANIUM;

    static {
        registerFluidTanks(MachineTier.T1, MachineTier.T4, MachineTier.T5, MachineTier.T6, MachineTier.T7);
        for (mctech.i.c cVar : mctech.i.c.values()) {
            registerFluidGenerators(cVar, MachineTier.T1, MachineTier.T2, MachineTier.T3, MachineTier.T4, MachineTier.T5);
        }
        registerCobblestoneGenerators(MachineTier.T1, MachineTier.T2, MachineTier.T3, MachineTier.T4, MachineTier.T5);
        registerPlasmaGenerators(MachineTier.T4, MachineTier.T6, MachineTier.T8);
        registerFormers(MachineTier.T2, MachineTier.T3, MachineTier.T4, MachineTier.T5);
        registerMassFabricators(MachineTier.T5, MachineTier.T6, MachineTier.T7);
        registerSingularityCollectors(MachineTier.T3, MachineTier.T4, MachineTier.T5, MachineTier.T6, MachineTier.T7);
        registerNuclearChambers(MachineTier.T1, MachineTier.T2, MachineTier.T3);
        registerNuclearReactors(MachineTier.T1, MachineTier.T2, MachineTier.T3);
        registerCrystalSynths(MachineTier.T2, MachineTier.T3, MachineTier.T4, MachineTier.T5, MachineTier.T6, MachineTier.T7);
        registerMetalFormers(MachineTier.T2, MachineTier.T3, MachineTier.T4, MachineTier.T5, MachineTier.T6, MachineTier.T7);
        registerRareExtractors(MachineTier.T2, MachineTier.T3, MachineTier.T4, MachineTier.T5, MachineTier.T6, MachineTier.T7);
        registerAlloySmelters(MachineTier.T2, MachineTier.T3, MachineTier.T4, MachineTier.T5, MachineTier.T6, MachineTier.T7);
        registerElectronicPlants(MachineTier.T2, MachineTier.T3, MachineTier.T4, MachineTier.T5, MachineTier.T6, MachineTier.T7);
        registerCompressors(MachineTier.T2, MachineTier.T3, MachineTier.T4, MachineTier.T5, MachineTier.T6, MachineTier.T7);
        registerFurnaces(MachineTier.T2, MachineTier.T3, MachineTier.T4, MachineTier.T5, MachineTier.T6, MachineTier.T7);
        registerMacerators(MachineTier.T2, MachineTier.T3, MachineTier.T4, MachineTier.T5, MachineTier.T6, MachineTier.T7);
        registerExtractors(MachineTier.T2, MachineTier.T3, MachineTier.T4, MachineTier.T5, MachineTier.T6, MachineTier.T7);
        registerChargePads(MachineTier.T1, MachineTier.T2, MachineTier.T3, MachineTier.T4, MachineTier.T5, MachineTier.T6, MachineTier.T7, MachineTier.T8, MachineTier.T9, MachineTier.T10);
        addBlocks();
        QUANTUM_COMPOSTER = BLOCK_REGISTRY.registerBlock("quantum_composter", B::new, DEFAULT_MACHINE).condition(MCTech::isFrozen).setTranslation("Quantum composter", "Квантовая компостница").setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            ResourceLocation resourceLocationWithDefaultNamespace = ResourceLocation.withDefaultNamespace("block/powder_snow");
            int i = 1;
            while (i <= 8) {
                blockStateProvider.models().withExistingParent(i == 8 ? "quantum_composter_ready" : "quantum_composter_level" + i, blockStateProvider.modLoc("block/quantum_composter")).texture("particle", resourceLocationWithDefaultNamespace).texture("content", resourceLocationWithDefaultNamespace).element().from(2.0f, 2.0f, 2.0f).to(14.0f, i == 8 ? 16 : 2 + (2 * i), 14.0f).face(Direction.UP).texture("#content").end().end();
                i++;
            }
            MultiPartBlockStateBuilder multipartBuilder = blockStateProvider.getMultipartBuilder((Block) dataGenContext.get());
            ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(blockStateProvider.models().getExistingFile(blockStateProvider.modLoc("block/quantum_composter"))).addModel()).end();
            int i2 = 1;
            while (i2 <= 8) {
                ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(new ModelFile.UncheckedModelFile(blockStateProvider.modLoc(i2 == 8 ? "block/quantum_composter_ready" : "block/quantum_composter_level" + i2))).addModel()).condition(B.f, new Integer[]{Integer.valueOf(i2)}).end();
                i2++;
            }
        }).addBlockTags(new TagKey[]{BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, b -> {
            return new BlockItem(b, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                lItemModelProvider.simpleBlockItem(((BlockItem) dataGenContext2.get()).getBlock());
            });
        });
        FARMING_STATION = BLOCK_REGISTRY.registerBlock("farming_station", C0086g::new, DEFAULT_MACHINE).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setBlockStateProvider((blockStateProvider2, dataGenContext2) -> {
            GeckoData.block(blockStateProvider2, dataGenContext2, blockStateProvider2.modLoc(String.format("block/%s/%s", dataGenContext2.getName(), dataGenContext2.getName())));
        }).setTranslation("Farming station", "Ферма деревьев").addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, c0086g -> {
            return new mctech.items.base.a(c0086g, new Item.Properties());
        }, lItem2 -> {
            lItem2.setTab(MCTechCreativeTabs.MACHINES).setModelProvider(GeckoData.blockItem("farming_station"));
        });
        FARMING_STATION_CULTIVATOR = BLOCK_REGISTRY.registerBlock("farming_station_cultivator", h::new, DEFAULT_MACHINE).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setBlockStateProvider((blockStateProvider3, dataGenContext3) -> {
            GeckoData.block(blockStateProvider3, dataGenContext3, blockStateProvider3.modLoc(String.format("block/%s/%s", dataGenContext3.getName(), dataGenContext3.getName())));
        }).setTranslation("Farming station cultivator", "Лесозаготовитель").addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, hVar -> {
            return new mctech.items.base.a(hVar, new Item.Properties());
        }, lItem3 -> {
            lItem3.setTab(MCTechCreativeTabs.MACHINES).setModelProvider(GeckoData.blockItem("farming_station_cultivator"));
        });
        MATRIX_CONVERTER = BLOCK_REGISTRY.registerBlock("matrix_converter", properties -> {
            return new a(properties, MachineTier.T6).a(MCTechTiles.MATRIX_CONVERTER);
        }, DEFAULT_MACHINE).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setBlockStateProvider((blockStateProvider4, dataGenContext4) -> {
            MCTechModels.createAllSidedActiveInactive(blockStateProvider4, dataGenContext4, "matrix_converter");
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).setTranslation("Matrix converter", "Матричный преобразователь").createBlockItem(ITEM_REGISTRY, aVar -> {
            return new mctech.items.base.c(aVar, new Item.Properties());
        }, lItem4 -> {
            lItem4.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext5) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext5, String.format("active_%s", "matrix_converter"));
            });
        });
        WIRELESS_CONNECTOR_64K = registerWirelessConnector(64, MachineTier.T1);
        WIRELESS_CONNECTOR_128K = registerWirelessConnector(128, MachineTier.T2);
        WIRELESS_CONNECTOR_256K = registerWirelessConnector(mctech.utils.c.h.i, MachineTier.T3);
        GLASS_FURNACE = BLOCK_REGISTRY.registerBlock("glass_furnace", l::new, DEFAULT_MACHINE).setTranslation("Glass furnace", "Завод стекла").setBlockStateProvider((blockStateProvider5, dataGenContext5) -> {
            blockStateProvider5.simpleBlock((Block) dataGenContext5.get(), blockStateProvider5.models().getBuilder(dataGenContext5.getName()).parent(new ModelFile.UncheckedModelFile("builtin/entity")).texture("particle", blockStateProvider5.modLoc(String.format("block/%s/%s", dataGenContext5.getName(), dataGenContext5.getName()))).transforms().transform(ItemDisplayContext.GUI).rotation(30.0f, -135.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.20833f, 0.20833f, 0.20833f).end().transform(ItemDisplayContext.GROUND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, 3.0f, 0.0f).scale(0.25f, 0.25f, 0.25f).end().transform(ItemDisplayContext.FIXED).rotation(0.0f, -180.0f, 0.0f).scale(0.16667f, 0.16667f, 0.16667f).end().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75.0f, 45.0f, 0.0f).translation(0.0f, 2.5f, 0.0f).scale(0.125f, 0.125f, 0.125f).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(75.0f, 45.0f, 0.0f).translation(0.0f, 2.5f, 0.0f).scale(0.125f, 0.125f, 0.125f).end().transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0.0f, -45.0f, 0.0f).scale(0.13333f, 0.13333f, 0.13333f).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0.0f, -45.0f, 0.0f).scale(0.13333f, 0.13333f, 0.13333f).end().transform(ItemDisplayContext.HEAD).rotation(-180.0f, 88.5f, -180.0f).translation(0.0f, -44.0f, -0.25f).scale(1.0f, 1.0f, 1.0f).end().end());
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, lVar -> {
            return new mctech.items.base.a(lVar, new Item.Properties());
        }, lItem5 -> {
            lItem5.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext6) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc("glass_furnace")).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, -180.0f, 0.0f).scale(0.16667f, 0.16667f, 0.16667f).end().end();
            });
        });
        WINDMILL = BLOCK_REGISTRY.registerBlock("windmill", mctech.blocks.b.j::new, DEFAULT_MACHINE).setTranslation("Windmill", "Ветрогенератор").setBlockStateProvider((blockStateProvider6, dataGenContext6) -> {
            blockStateProvider6.simpleBlock((Block) dataGenContext6.get(), blockStateProvider6.models().getBuilder(dataGenContext6.getName()).parent(new ModelFile.UncheckedModelFile("builtin/entity")).texture("particle", blockStateProvider6.modLoc(String.format("block/%s/%s", dataGenContext6.getName(), dataGenContext6.getName()))).transforms().transform(ItemDisplayContext.GUI).rotation(33.0f, -130.0f, 0.0f).translation(0.0f, -5.5f, 0.0f).scale(0.1f, 0.1f, 0.1f).end().transform(ItemDisplayContext.GROUND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, 0.0f, 0.0f).scale(0.05f, 0.05f, 0.05f).end().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -8.75f, 0.0f).scale(0.12f, 0.12f, 0.12f).end().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(0.0f, -161.0f, 0.0f).translation(-0.25f, 1.0f, 0.0f).scale(0.08f, 0.08f, 0.08f).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(-179.84f, -180.0f, -178.0f).translation(-0.5f, 0.75f, 0.0f).scale(0.08f, 0.08f, 0.08f).end().transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0.0f, 165.0f, 5.0f).translation(0.5f, -0.25f, -0.5f).scale(0.1f, 0.1f, 0.1f).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0.0f, 0.0f, 0.0f).translation(2.0f, 0.25f, -0.5f).scale(0.1f, 0.1f, 0.1f).end().transform(ItemDisplayContext.HEAD).translation(0.0f, -45.5f, 0.0f).scale(2.0f, 2.0f, 2.0f).end().end());
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, jVar -> {
            return new mctech.items.y(jVar, new Item.Properties());
        }, lItem6 -> {
            lItem6.setTab(MCTechCreativeTabs.ENERGY).setModelProvider((lItemModelProvider, dataGenContext7) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc("windmill")).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        QUANTUM_GENERATOR = BLOCK_REGISTRY.registerBlock(mctech.i.i.QUANTUM_GENERATOR.getSerializedName(), d::new, DEFAULT_MACHINE).setTranslation("Quantum generator", "Квантовый генератор").setBlockStateProvider((blockStateProvider7, dataGenContext7) -> {
            GeckoData.block(blockStateProvider7, dataGenContext7, blockStateProvider7.modLoc(String.format("block/%s/%s", dataGenContext7.getName(), dataGenContext7.getName())));
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, dVar -> {
            return new mctech.items.base.a(dVar, new Item.Properties());
        }, lItem7 -> {
            lItem7.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext8) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc(mctech.i.i.QUANTUM_GENERATOR.getSerializedName())).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        MOLECULAR_CONVERTER_CORE_BLOCK = BLOCK_REGISTRY.registerBlock("molecular_converter_core", mctech.blocks.d.a::new, DEFAULT_MACHINE).setTranslation("Molecular converter core", "Ядро молекулярного преобразователя").setBlockStateProvider((blockStateProvider8, dataGenContext8) -> {
            blockStateProvider8.getVariantBuilder((Block) dataGenContext8.get()).forAllStates(blockState -> {
                return ConfiguredModel.builder().modelFile(blockStateProvider8.models().cubeAll(BuiltInRegistries.BLOCK.getKey((Block) dataGenContext8.get()).getPath(), MCTech.loc("block/molecular_converter/core"))).build();
            });
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, aVar2 -> {
            return new m(aVar2, new Item.Properties());
        }, lItem8 -> {
            lItem8.setTab(MCTechCreativeTabs.MAIN).setModelProvider((lItemModelProvider, dataGenContext9) -> {
                lItemModelProvider.basicBlock((Item) dataGenContext9.get());
            });
        });
        MOLECULAR_CONVERTER_FRAME_BLOCK = BLOCK_REGISTRY.registerBlock("molecular_converter_frame", b::new, DEFAULT_MACHINE).setTranslation("Molecular converter frame", "Каркас молекулярного преобразователя").setBlockStateProvider((blockStateProvider9, dataGenContext9) -> {
            blockStateProvider9.getVariantBuilder((Block) dataGenContext9.get()).forAllStates(blockState -> {
                return ConfiguredModel.builder().modelFile(blockStateProvider9.models().cubeAll(BuiltInRegistries.BLOCK.getKey((Block) dataGenContext9.get()).getPath(), MCTech.loc("block/molecular_converter/frame"))).build();
            });
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, bVar -> {
            return new BlockItem(bVar, new Item.Properties());
        }, lItem9 -> {
            lItem9.setTab(MCTechCreativeTabs.MAIN).setModelProvider((lItemModelProvider, dataGenContext10) -> {
                lItemModelProvider.basicBlock((Item) dataGenContext10.get());
            });
        });
        MOLECULAR_CONVERTER_GLASS_BLOCK = BLOCK_REGISTRY.registerBlock("molecular_converter_glass", c::new, DEFAULT_MACHINE).setTranslation("Molecular converter glass", "Камера молекулярного преобразователя").setBlockStateProvider((blockStateProvider10, dataGenContext10) -> {
            blockStateProvider10.getVariantBuilder((Block) dataGenContext10.get()).forAllStates(blockState -> {
                return ConfiguredModel.builder().modelFile(blockStateProvider10.models().cubeAll(BuiltInRegistries.BLOCK.getKey((Block) dataGenContext10.get()).getPath(), MCTech.loc("block/molecular_converter/glass")).renderType("translucent")).build();
            });
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, cVar2 -> {
            return new BlockItem(cVar2, new Item.Properties());
        }, lItem10 -> {
            lItem10.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext11) -> {
                lItemModelProvider.basicBlock((Item) dataGenContext11.get());
            });
        });
        ITEM_DUPLICATOR = BLOCK_REGISTRY.registerBlock("item_duplicator", r::new, DEFAULT_MACHINE).setTranslation("Item duplicator", "Дубликатор предметов").setBlockStateProvider((blockStateProvider11, dataGenContext11) -> {
            GeckoData.block(blockStateProvider11, dataGenContext11, blockStateProvider11.modLoc(String.format("block/%s/%s", dataGenContext11.getName(), dataGenContext11.getName())));
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, rVar -> {
            return new mctech.items.k(rVar, new Item.Properties());
        }, lItem11 -> {
            lItem11.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext12) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc("item_duplicator")).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        ITEM_DESTROYER = BLOCK_REGISTRY.registerBlock("item_destroyer", q::new, DEFAULT_MACHINE).setTranslation("Item destroyer", "Уничтожитель предметов").setBlockStateProvider((blockStateProvider12, dataGenContext12) -> {
            GeckoData.block(blockStateProvider12, dataGenContext12, blockStateProvider12.modLoc(String.format("block/%s/%s", dataGenContext12.getName(), dataGenContext12.getName())));
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, qVar -> {
            return new mctech.items.j(qVar, new Item.Properties());
        }, lItem12 -> {
            lItem12.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext13) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc("item_destroyer")).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        PATTERN_FORGE_ENCODER = BLOCK_REGISTRY.registerBlock("pattern_forge_encoder", x::new, DEFAULT_MACHINE).setTranslation("Industrial forge pattern encoder", "Кодировщик шаблонов промышленной кузни").setBlockStateProvider((blockStateProvider13, dataGenContext13) -> {
            GeckoData.block(blockStateProvider13, dataGenContext13, blockStateProvider13.modLoc(String.format("block/%s/%s", dataGenContext13.getName(), dataGenContext13.getName())));
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, xVar -> {
            return new mctech.items.q(xVar, new Item.Properties());
        }, lItem13 -> {
            lItem13.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext14) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc("pattern_forge_encoder")).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        PATTERN_QUANTUM_WORKBENCH_ENCODER = BLOCK_REGISTRY.registerBlock("pattern_quantum_workbench_encoder", y::new, DEFAULT_MACHINE).setTranslation("Quantum workbench pattern encoder", "Кодировщик шаблонов квантового сборщика").setBlockStateProvider((blockStateProvider14, dataGenContext14) -> {
            GeckoData.block(blockStateProvider14, dataGenContext14, blockStateProvider14.modLoc(String.format("block/%s/%s", dataGenContext14.getName(), dataGenContext14.getName())));
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, yVar -> {
            return new mctech.items.r(yVar, new Item.Properties());
        }, lItem14 -> {
            lItem14.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext15) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc("pattern_quantum_workbench_encoder")).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        PATTERN_ASSEMBLY_ENCODER = BLOCK_REGISTRY.registerBlock("pattern_assembly_encoder", w::new, DEFAULT_MACHINE).setTranslation("Assembly pattern encoder", "Кодировщик шаблонов сборочной станции").setBlockStateProvider((blockStateProvider15, dataGenContext15) -> {
            GeckoData.block(blockStateProvider15, dataGenContext15, blockStateProvider15.modLoc(String.format("block/%s/%s", dataGenContext15.getName(), dataGenContext15.getName())));
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, wVar -> {
            return new mctech.items.p(wVar, new Item.Properties());
        }, lItem15 -> {
            lItem15.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext16) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc("pattern_assembly_encoder")).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        CONDUIT = BLOCK_REGISTRY.registerBlock("conduit", mctech.g.d.a.a.a::new, BlockBehaviour.Properties.of().strength(1.5f, 10.0f).noLootTable().noOcclusion().dynamicShape().mapColor(MapColor.STONE)).setTranslation("Conduit Bundle", "Блок труб").setBlockStateProvider(mctech.g.e.a::a).addBlockTags(new TagKey[]{BlockTags.MINEABLE_WITH_PICKAXE, mctech.g.d.d.a.C0016a.b}).createBlockItem(ITEM_REGISTRY, aVar3 -> {
            return new mctech.g.d.b.b(aVar3, new Item.Properties());
        }, lItem16 -> {
            lItem16.setTranslation("<MISSING> Conduit", "<ОШИБКА>").setModelProvider((lItemModelProvider, dataGenContext16) -> {
            }).addItemTags(new TagKey[]{mctech.g.d.d.a.b.a});
        });
        MOLECULAR_CONVERTER = BLOCK_REGISTRY.registerBlock(mctech.i.i.MOLECULAR_CONVERTER.getSerializedName(), t::new, DEFAULT_MACHINE).setTranslation("Molecular converter", "Молекулярный преобразователь").setBlockStateProvider((blockStateProvider16, dataGenContext16) -> {
            blockStateProvider16.simpleBlock((Block) dataGenContext16.get(), blockStateProvider16.models().getBuilder(dataGenContext16.getName()).parent(new ModelFile.UncheckedModelFile("builtin/entity")).transforms().transform(ItemDisplayContext.GUI).rotation(30.0f, 225.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.35f, 0.35f, 0.35f).end().transform(ItemDisplayContext.GROUND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, 3.0f, 0.0f).scale(0.25f, 0.25f, 0.25f).end().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, 0.0f, 0.0f).scale(0.25f, 0.25f, 0.25f).end().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75.0f, 45.0f, 0.0f).translation(0.0f, 2.5f, 0.0f).scale(0.375f, 0.375f, 0.375f).end().transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0.0f, 135.0f, 0.0f).translation(-2.5f, -2.5f, 0.0f).scale(0.2f, 0.2f, 0.2f).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0.0f, 225.0f, 0.0f).translation(2.5f, 0.0f, 0.0f).scale(0.2f, 0.2f, 0.2f).end().end());
        }).addBlockTags(Set.of(BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)).createBlockItem(ITEM_REGISTRY, tVar -> {
            return new mctech.items.n(tVar, new Item.Properties());
        }, lItem17 -> {
            lItem17.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext17) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc(mctech.i.i.MOLECULAR_CONVERTER.getSerializedName())).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.25f, 0.25f, 0.25f).end().end();
            });
        });
        QUANTUM_WORKBENCH = BLOCK_REGISTRY.registerBlock(mctech.i.i.QUANTUM_WORKBENCH.getSerializedName(), C::new, DEFAULT_MACHINE).setTranslation("Quantum workbench", "Квантовый сборщик").setBlockStateProvider((blockStateProvider17, dataGenContext17) -> {
            GeckoData.block(blockStateProvider17, dataGenContext17, blockStateProvider17.modLoc(String.format("block/%s/%s", dataGenContext17.getName(), dataGenContext17.getName())));
        }).setLootTable((v0, v1) -> {
            v0.dropSelf(v1);
        }).addBlockTags(Set.of(BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)).createBlockItem(ITEM_REGISTRY, c -> {
            return new u(c, new Item.Properties());
        }, lItem18 -> {
            lItem18.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext18) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc(mctech.i.i.QUANTUM_WORKBENCH.getSerializedName())).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        ASSEMBLY_STATION = BLOCK_REGISTRY.registerBlock(mctech.i.i.ASSEMBLY_STATION.getSerializedName(), C0083d::new, DEFAULT_MACHINE).setTranslation("Assembly station", "Сборочная станция").setBlockStateProvider((blockStateProvider18, dataGenContext18) -> {
            GeckoData.block(blockStateProvider18, dataGenContext18, blockStateProvider18.modLoc(String.format("block/%s/%s", dataGenContext18.getName(), dataGenContext18.getName())));
        }).addBlockTags(Set.of(BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)).createBlockItem(ITEM_REGISTRY, c0083d -> {
            return new C0126b(c0083d, new Item.Properties());
        }, lItem19 -> {
            lItem19.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext19) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc(mctech.i.i.ASSEMBLY_STATION.getSerializedName())).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        TRANSFORMATION_ASSEMBLER = BLOCK_REGISTRY.registerBlock(mctech.i.i.TRANSFORMATION_ASSEMBLER.getSerializedName(), F::new, DEFAULT_MACHINE).setTranslation("Transformation assembler", "Преобразовательный сборщик").setBlockStateProvider((blockStateProvider19, dataGenContext19) -> {
            GeckoData.block(blockStateProvider19, dataGenContext19, blockStateProvider19.modLoc(String.format("block/%s/%s", dataGenContext19.getName(), dataGenContext19.getName())));
        }).addBlockTags(Set.of(BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)).createBlockItem(ITEM_REGISTRY, f -> {
            return new mctech.items.w(f, new Item.Properties());
        }, lItem20 -> {
            lItem20.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext20) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc(mctech.i.i.TRANSFORMATION_ASSEMBLER.getSerializedName())).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        PATTERN_TRANSFORMATION_ASSEMBLER_ENCODER = BLOCK_REGISTRY.registerBlock("pattern_transformation_assembler_encoder", z::new, DEFAULT_MACHINE).setTranslation("Transformation assembler pattern encoder", "Кодировщик шаблонов преобразовательного сборщика").setBlockStateProvider((blockStateProvider20, dataGenContext20) -> {
            GeckoData.block(blockStateProvider20, dataGenContext20, blockStateProvider20.modLoc(String.format("block/%s/%s", dataGenContext20.getName(), dataGenContext20.getName())));
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, zVar -> {
            return new mctech.items.s(zVar, new Item.Properties());
        }, lItem21 -> {
            lItem21.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext21) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc("pattern_transformation_assembler_encoder")).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        ATOMIC_SMELTER = BLOCK_REGISTRY.registerBlock(mctech.i.i.ATOMIC_SMELTER.getSerializedName(), C0084e::new, DEFAULT_MACHINE).setTranslation("Atomic smelter", "Атомная плавильня").setBlockStateProvider((blockStateProvider21, dataGenContext21) -> {
            GeckoData.block(blockStateProvider21, dataGenContext21, blockStateProvider21.modLoc(String.format("block/%s/%s", dataGenContext21.getName(), dataGenContext21.getName())));
        }).addBlockTags(Set.of(BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)).createBlockItem(ITEM_REGISTRY, c0084e -> {
            return new mctech.items.c(c0084e, new Item.Properties());
        }, lItem22 -> {
            lItem22.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext22) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc(mctech.i.i.ATOMIC_SMELTER.getSerializedName())).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        GRINDING_MACHINE = BLOCK_REGISTRY.register("grinding_machine", resourceLocation -> {
            return new n();
        }).setBlockStateProvider((blockStateProvider22, dataGenContext22) -> {
            blockStateProvider22.simpleBlock((Block) dataGenContext22.get(), blockStateProvider22.models().getBuilder(dataGenContext22.getName()).parent(new ModelFile.UncheckedModelFile("builtin/entity")).texture("particle", blockStateProvider22.modLoc(String.format("block/%s_particle", dataGenContext22.getName()))).transforms().transform(ItemDisplayContext.GUI).rotation(30.0f, 225.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.625f, 0.625f, 0.625f).end().transform(ItemDisplayContext.GROUND).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, 3.0f, 0.0f).scale(0.25f, 0.25f, 0.25f).end().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, 0.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75.0f, 45.0f, 0.0f).translation(0.0f, 2.5f, 0.0f).scale(0.375f, 0.375f, 0.375f).end().transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0.0f, 135.0f, 0.0f).translation(0.0f, -2.5f, 0.0f).scale(0.4f, 0.4f, 0.4f).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0.0f, 225.0f, 0.0f).translation(0.0f, 0.0f, 0.0f).scale(0.4f, 0.4f, 0.4f).end().end());
        }).setTranslation("Grinding machine", "Точильный станок T4").createBlockItem(ITEM_REGISTRY, nVar -> {
            return new mctech.items.e.g();
        }, lItem23 -> {
            lItem23.setModelProvider((lItemModelProvider, dataGenContext23) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc("grinding_machine")).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            }).setTab(MCTechCreativeTabs.MACHINES);
        });
        VENDING_MACHINE = BLOCK_REGISTRY.registerBlock("vending_machine", G::new, DEFAULT_MACHINE).setTranslation("Vending machine", "Торговый автомат").setBlockStateProvider(new BiConsumer<BlockStateProvider, DataGenContext<Block, G>>() { // from class: mctech.init.MCTechBlocks.1
            @Override // java.util.function.BiConsumer
            public void accept(BlockStateProvider blockStateProvider23, DataGenContext<Block, G> dataGenContext23) {
                createModels(blockStateProvider23, "buy");
                createModels(blockStateProvider23, "sale");
                createModels(blockStateProvider23, "trade");
                MultiPartBlockStateBuilder multipartBuilder = blockStateProvider23.getMultipartBuilder((Block) dataGenContext23.get());
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    int yRot = ((int) direction.toYRot()) + 180;
                    ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(blockStateProvider23.models().getExistingFile(blockStateProvider23.modLoc("block/vending_machine_buy_working"))).rotationY(yRot).addModel()).condition(G.FACING, new Direction[]{direction}).condition(G.f, new Integer[]{0}).condition(G.d, new Boolean[]{false}).condition(G.e, new Boolean[]{false}).end();
                    ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(blockStateProvider23.models().getExistingFile(blockStateProvider23.modLoc("block/vending_machine_sale_working"))).rotationY(yRot).addModel()).condition(G.FACING, new Direction[]{direction}).condition(G.f, new Integer[]{2}).condition(G.d, new Boolean[]{false}).condition(G.e, new Boolean[]{false}).end();
                    ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(blockStateProvider23.models().getExistingFile(blockStateProvider23.modLoc("block/vending_machine_trade_working"))).rotationY(yRot).addModel()).condition(G.FACING, new Direction[]{direction}).condition(G.f, new Integer[]{1}).condition(G.d, new Boolean[]{false}).condition(G.e, new Boolean[]{false}).end();
                    ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(blockStateProvider23.models().getExistingFile(blockStateProvider23.modLoc("block/vending_machine_buy_busy"))).rotationY(yRot).addModel()).condition(G.FACING, new Direction[]{direction}).condition(G.f, new Integer[]{0}).condition(G.d, new Boolean[]{true}).end();
                    ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(blockStateProvider23.models().getExistingFile(blockStateProvider23.modLoc("block/vending_machine_sale_busy"))).rotationY(yRot).addModel()).condition(G.FACING, new Direction[]{direction}).condition(G.f, new Integer[]{2}).condition(G.d, new Boolean[]{true}).end();
                    ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(blockStateProvider23.models().getExistingFile(blockStateProvider23.modLoc("block/vending_machine_trade_busy"))).rotationY(yRot).addModel()).condition(G.FACING, new Direction[]{direction}).condition(G.f, new Integer[]{1}).condition(G.d, new Boolean[]{true}).end();
                    ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(blockStateProvider23.models().getExistingFile(blockStateProvider23.modLoc("block/vending_machine_buy_notworking"))).rotationY(yRot).addModel()).condition(G.FACING, new Direction[]{direction}).condition(G.f, new Integer[]{0}).condition(G.e, new Boolean[]{true}).end();
                    ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(blockStateProvider23.models().getExistingFile(blockStateProvider23.modLoc("block/vending_machine_sale_notworking"))).rotationY(yRot).addModel()).condition(G.FACING, new Direction[]{direction}).condition(G.f, new Integer[]{2}).condition(G.e, new Boolean[]{true}).end();
                    ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(blockStateProvider23.models().getExistingFile(blockStateProvider23.modLoc("block/vending_machine_trade_notworking"))).rotationY(yRot).addModel()).condition(G.FACING, new Direction[]{direction}).condition(G.f, new Integer[]{1}).condition(G.e, new Boolean[]{true}).end();
                }
            }

            private static void createModels(BlockStateProvider blockStateProvider23, String str) {
                blockStateProvider23.models().withExistingParent(String.format("vending_machine_%s_busy", str), blockStateProvider23.modLoc("block/vending_machine")).texture("view_texture", blockStateProvider23.modLoc(String.format("block/vending_machine/vending_machine_%s_busy", str))).texture("particle", blockStateProvider23.modLoc(String.format("block/vending_machine/vending_machine_%s_busy", str)));
                blockStateProvider23.models().withExistingParent(String.format("vending_machine_%s_notworking", str), blockStateProvider23.modLoc("block/vending_machine")).texture("view_texture", blockStateProvider23.modLoc(String.format("block/vending_machine/vending_machine_%s_notworking", str))).texture("particle", blockStateProvider23.modLoc(String.format("block/vending_machine/vending_machine_%s_notworking", str)));
                blockStateProvider23.models().withExistingParent(String.format("vending_machine_%s_working", str), blockStateProvider23.modLoc("block/vending_machine")).texture("view_texture", blockStateProvider23.modLoc(String.format("block/vending_machine/vending_machine_%s_working", str))).texture("particle", blockStateProvider23.modLoc(String.format("block/vending_machine/vending_machine_%s_working", str)));
            }
        }).addBlockTags(Set.of(BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)).createBlockItem(ITEM_REGISTRY, g -> {
            return new mctech.items.x(g, new Item.Properties());
        }, lItem24 -> {
            lItem24.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext23) -> {
                lItemModelProvider.basicBlock((Item) dataGenContext23.get());
            });
        });
        REACTOR_PLANNER = BLOCK_REGISTRY.registerBlock("reactor_planner", D::new, DEFAULT_MACHINE).setTranslation("Reactor planner", "Планировщик реактора").setBlockStateProvider((blockStateProvider23, dataGenContext23) -> {
            blockStateProvider23.getVariantBuilder((Block) dataGenContext23.get()).forAllStates(blockState -> {
                return ConfiguredModel.builder().modelFile(blockStateProvider23.models().cube("reactor_planner", ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/reactor_planner/%s", Direction.DOWN.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/reactor_planner/%s", Direction.UP.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/reactor_planner/%s", Direction.NORTH.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/reactor_planner/%s", Direction.SOUTH.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/reactor_planner/%s", Direction.EAST.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/reactor_planner/%s", Direction.WEST.getName()))).texture("particle", ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/reactor_planner/%s", Direction.NORTH.getName())))).rotationY(((int) blockState.getValue(MCTechProperties.ALL_FACINGS).toYRot()) % 360).build();
            });
        }).setLootTable((v0, v1) -> {
            v0.dropSelf(v1);
        }).createBlockItem(ITEM_REGISTRY, (v0) -> {
            return v0.createItem();
        }, lItem25 -> {
            lItem25.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext24) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc("reactor_planner")).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        BASE_TELEPORTER = BLOCK_REGISTRY.registerBlock("base_teleporter", properties2 -> {
            return new mctech.blocks.e(properties2).a(MCTechTiles.BASE_TELEPORTER);
        }, DEFAULT_MACHINE).setTranslation("Base teleporter", "Телепорт").setBlockStateProvider((blockStateProvider24, dataGenContext24) -> {
            MCTechModels.createAllSidedActiveInactive(blockStateProvider24, dataGenContext24, "machine/t3/base_teleporter");
        }).createBlockItem(ITEM_REGISTRY, eVar -> {
            return new BlockItem(eVar, new Item.Properties());
        }, lItem26 -> {
            lItem26.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext25) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext25, "active_base_teleporter");
            });
        });
        ELEVATOR_TELEPORTER = BLOCK_REGISTRY.registerBlock("elevator_teleporter", properties3 -> {
            return new mctech.blocks.e(properties3).a(MCTechTiles.ELEVATOR_TELEPORTER).a(true);
        }, DEFAULT_MACHINE).setTranslation("Elevator teleporter", "Телепорт-лифт").setBlockStateProvider((blockStateProvider25, dataGenContext25) -> {
            GeckoData.block(blockStateProvider25, dataGenContext25, blockStateProvider25.modLoc(String.format("block/%s/%s", dataGenContext25.getName(), dataGenContext25.getName())));
        }).createBlockItem(ITEM_REGISTRY, eVar2 -> {
            return new mctech.items.base.a(eVar2, new Item.Properties());
        }, lItem27 -> {
            lItem27.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext26) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc(dataGenContext26.getName())).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        LINKED_TELEPORTER = BLOCK_REGISTRY.registerBlock("linked_teleporter", properties4 -> {
            return new mctech.blocks.e(properties4).a(MCTechTiles.LINKED_TELEPORTER).a(true);
        }, DEFAULT_MACHINE).setTranslation("Linked teleporter", "Связываемый телепорт").setBlockStateProvider((blockStateProvider26, dataGenContext26) -> {
            GeckoData.block(blockStateProvider26, dataGenContext26, blockStateProvider26.modLoc(String.format("block/%s/%s", dataGenContext26.getName(), dataGenContext26.getName())));
        }).createBlockItem(ITEM_REGISTRY, eVar3 -> {
            return new mctech.items.base.a(eVar3, new Item.Properties());
        }, lItem28 -> {
            lItem28.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext27) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc(dataGenContext27.getName())).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        STONE_COMPRESSOR = register("stone_compressor", () -> {
            return new E("stone_compressor", MCTechTiles.STONE_COMPRESSOR);
        }, MCTechCreativeTabs.MACHINES).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE});
        STONE_EXTRACTOR = register("stone_extractor", () -> {
            return new E("stone_extractor", MCTechTiles.STONE_EXTRACTOR);
        }, MCTechCreativeTabs.MACHINES).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE});
        NANO_RECYCLER = register("nano_recycler", () -> {
            return new C0080a("nano_recycler", MCTechTiles.ADVANCED_RECYCLER, mctech.i.a.NANO);
        }, MCTechCreativeTabs.MACHINES);
        QUANTUM_RECYCLER = register("quantum_recycler", () -> {
            return new C0080a("quantum_recycler", MCTechTiles.ADVANCED_RECYCLER, mctech.i.a.QUANTUM);
        }, MCTechCreativeTabs.MACHINES);
        SINGULAR_RECYCLER = register("singular_recycler", () -> {
            return new C0080a("singular_recycler", MCTechTiles.ADVANCED_RECYCLER, mctech.i.a.SINGULAR);
        }, MCTechCreativeTabs.MACHINES);
        NANO_REFINERY = register("nano_refinery", () -> {
            return new C0080a("nano_refinery", MCTechTiles.ADVANCED_REFINERY, mctech.i.a.NANO);
        }, MCTechCreativeTabs.MACHINES);
        QUANTUM_REFINERY = register("quantum_refinery", () -> {
            return new C0080a("quantum_refinery", MCTechTiles.ADVANCED_REFINERY, mctech.i.a.QUANTUM);
        }, MCTechCreativeTabs.MACHINES);
        SINGULAR_REFINERY = register("singular_refinery", () -> {
            return new C0080a("singular_refinery", MCTechTiles.ADVANCED_REFINERY, mctech.i.a.SINGULAR);
        }, MCTechCreativeTabs.MACHINES);
        CRYSTAL_GROWTH_CHAMBER = register("crystal_growth_chamber", () -> {
            return new C0080a("crystal_growth_chamber", MCTechTiles.CRYSTAL_GROWTH_CHAMBER, mctech.i.a.COMPOSITE);
        }, MCTechCreativeTabs.MACHINES);
        INDUSTRIAL_FORGE = register("industrial_forge", p::new, MCTechCreativeTabs.MACHINES);
        GENETIC_SEQUENTOR = BLOCK_REGISTRY.register("genetic_sequentor", () -> {
            return new k("genetic_sequentor", MCTechTiles.GENETIC_SEQUENTOR);
        }).setTranslation("Genetic Sequencer", "Генетический секвенатор").setBlockStateProvider((blockStateProvider27, dataGenContext27) -> {
            GeckoData.block(blockStateProvider27, dataGenContext27, blockStateProvider27.modLoc(String.format("block/%s/%s", dataGenContext27.getName(), dataGenContext27.getName())));
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, kVar -> {
            return new mctech.items.base.a(kVar, new Item.Properties());
        }, lItem29 -> {
            lItem29.setTab(MCTechCreativeTabs.MACHINES).setModelProvider(GeckoData.blockItem("genetic_sequentor"));
        });
        GENETIC_STABILIZER = BLOCK_REGISTRY.register("genetic_stabilizer", () -> {
            return new k("genetic_stabilizer", MCTechTiles.GENETIC_STABILIZER);
        }).setTranslation("Genetic Stabilizer", "Генетический стабилизатор").setBlockStateProvider((blockStateProvider28, dataGenContext28) -> {
            GeckoData.block(blockStateProvider28, dataGenContext28, blockStateProvider28.modLoc(String.format("block/%s/%s", dataGenContext28.getName(), dataGenContext28.getName())));
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, kVar2 -> {
            return new mctech.items.base.a(kVar2, new Item.Properties());
        }, lItem30 -> {
            lItem30.setTab(MCTechCreativeTabs.MACHINES).setModelProvider(GeckoData.blockItem("genetic_stabilizer"));
        });
        SYNTHETIC_PRINTER = BLOCK_REGISTRY.register("synthetic_printer", () -> {
            return new k("synthetic_printer", MCTechTiles.SYNTHETIC_PRINTER);
        }).setTranslation("Synthetic Printer", "Синтетический принтер").setBlockStateProvider((blockStateProvider29, dataGenContext29) -> {
            GeckoData.block(blockStateProvider29, dataGenContext29, blockStateProvider29.modLoc(String.format("block/%s/%s", dataGenContext29.getName(), dataGenContext29.getName())));
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, kVar3 -> {
            return new mctech.items.base.a(kVar3, new Item.Properties());
        }, lItem31 -> {
            lItem31.setTab(MCTechCreativeTabs.MACHINES).setModelProvider(GeckoData.blockItem("synthetic_printer"));
        });
        EXPERIENCE_EXTRACTOR = BLOCK_REGISTRY.register("experience_extractor", () -> {
            return new k("experience_extractor", MCTechTiles.EXPERIENCE_EXTRACTOR);
        }).setTranslation("Experience Extractor", "Экстрактор опыта").setBlockStateProvider((blockStateProvider30, dataGenContext30) -> {
            GeckoData.block(blockStateProvider30, dataGenContext30, blockStateProvider30.modLoc(String.format("block/%s/%s", dataGenContext30.getName(), dataGenContext30.getName())));
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, kVar4 -> {
            return new mctech.items.base.a(kVar4, new Item.Properties());
        }, lItem32 -> {
            lItem32.setTab(MCTechCreativeTabs.MACHINES).setModelProvider(GeckoData.blockItem("experience_extractor"));
        });
        COLORABLE = mctech.utils.a.b.i();
        BEDROCK = createBedrockOre("bedrock", 3.0f, "Bedrock", "Коренная порода").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE});
        BEDROCK_AMETHYST = createBedrockOre("amethyst", 3.0f, "Bedrock amethyst", "Коренной аметист").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, MCTechTags.Ores.AMETHYST, MCTechTags.ORES});
        BEDROCK_COAL = createBedrockOre("coal", 3.0f, "Bedrock coal ore", "Коренная угольная руда").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, BlockTags.COAL_ORES});
        BEDROCK_COPPER = createBedrockOre("copper", 3.0f, "Bedrock copper ore", "Коренная медная руда").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, BlockTags.COPPER_ORES});
        BEDROCK_DIAMOND = createBedrockOre("diamond", 3.0f, "Bedrock diamond ore", "Коренная алмазная руда").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, BlockTags.DIAMOND_ORES});
        BEDROCK_EMERALD = createBedrockOre("emerald", 3.0f, "Bedrock emerald ore", "Коренная изумрудная руда").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, BlockTags.EMERALD_ORES});
        BEDROCK_GOLD = createBedrockOre("gold", 3.0f, "Bedrock gold ore", "Коренная золотая руда").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, BlockTags.GOLD_ORES});
        BEDROCK_IRON = createBedrockOre("iron", 3.0f, "Bedrock iron ore", "Коренная железная руда").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, BlockTags.IRON_ORES});
        BEDROCK_LAPIS = createBedrockOre("lapis", 3.0f, "Bedrock lapis ore", "Коренная лазуритовая руда").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, BlockTags.LAPIS_ORES});
        BEDROCK_REDSTONE = createBedrockOre("redstone", 3.0f, "Bedrock redstone ore", "Коренная редстоун руда").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, BlockTags.REDSTONE_ORES});
        BEDROCK_SILVER = createBedrockOre("silver", 3.0f, "Bedrock silver ore", "Коренная серебряная руда").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, MCTechTags.Ores.SILVER, MCTechTags.ORES});
        BEDROCK_TIN = createBedrockOre("tin", 3.0f, "Bedrock tin ore", "Коренная оловянная руда").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, MCTechTags.Ores.TIN, MCTechTags.ORES});
        BEDROCK_URANIUM = createBedrockOre("uranium", 3.0f, "Bedrock uranium ore", "Коренная урановая руда").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, MCTechTags.Ores.URANIUM, MCTechTags.ORES});
        BEDROCK_TUNGSTEN = createBedrockOre("tungsten", 3.0f, "Bedrock tungsten ore", "Коренная вольфрамовая руда").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, MCTechTags.Ores.TUNGSTEN});
        BEDROCK_NETHERITE = createBedrockOre("netherite", 3.0f, "Bedrock netherite ore", "Коренная незеритовая руда").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, MCTechTags.Ores.NETHERITE, MCTechTags.ORES});
        BEDROCK_TITANIUM = createBedrockOre("titanium", 3.0f, "Bedrock titanium ore", "Коренная титановая руда").addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, MCTechTags.Ores.TITANIUM});
    }

    public static void register(IEventBus iEventBus) {
        BLOCK_REGISTRY.register(iEventBus);
        ITEM_REGISTRY.register(iEventBus);
    }

    private static LBlock<mctech.a.a.b.a> registerWirelessConnector(int i, MachineTier machineTier) {
        return BLOCK_REGISTRY.registerBlock(String.format("wireless_connector_%sk", Integer.valueOf(i)), properties -> {
            return new mctech.a.a.b.a(properties, i);
        }, DEFAULT_MACHINE).setLootTable((v0, v1) -> {
            v0.dropSelf(v1);
        }).setTranslation(String.format("Wireless connector T%s", machineTier.asIntegerString()), String.format("Беспроводной соединитель T%s", machineTier.asIntegerString())).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            MCTechModels.createWirelessConnector(blockStateProvider, dataGenContext, machineTier);
        }).addBlockTags(Set.of(BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)).createBlockItem(ITEM_REGISTRY, aVar -> {
            return new BlockItem(aVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MAIN).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                lItemModelProvider.withExistingParent(dataGenContext2.getId().getPath(), MCTech.loc(String.format("block/wireless_connect_fluix_t%s", machineTier.asIntegerString())));
            });
        });
    }

    @Deprecated(forRemoval = true, since = "Use MSRegistry for registering blocks")
    private static <T extends Block & mctech.blocks.base.a> LBlock<T> register(String str, Supplier<T> supplier, ResourceKey<CreativeModeTab> resourceKey) {
        return register(str, supplier, true, resourceKey);
    }

    @Deprecated(forRemoval = true, since = "Use MSRegistry for registering blocks")
    private static <T extends Block & mctech.blocks.base.a> LBlock<T> register(String str, Supplier<T> supplier, boolean z, ResourceKey<CreativeModeTab> resourceKey) {
        LBlock<T> blockStateProvider = BLOCK_REGISTRY.register(str, supplier).setBlockStateProvider((BiConsumer) null);
        if (z) {
            MCTechItems.registerBlockItem(String.format("%s_item", str), blockStateProvider, resourceKey);
        }
        return blockStateProvider;
    }

    @Deprecated(forRemoval = true, since = "Use MSRegistry for registering blocks")
    public static <T extends Block> DeferredBlock<T> registerBlock(String str, Supplier<T> supplier, ResourceKey<CreativeModeTab> resourceKey) {
        return registerBlock(str, supplier, false, resourceKey);
    }

    @Deprecated(forRemoval = true, since = "Use MSRegistry for registering blocks")
    public static <T extends Block & mctech.blocks.base.a> LBlock<T> registerItemBlock(String str, Supplier<T> supplier, ResourceKey<CreativeModeTab> resourceKey) {
        return registerBlock(str, supplier, true, resourceKey);
    }

    @Deprecated(forRemoval = true, since = "Use MSRegistry for registering blocks")
    private static <T extends Block, A extends Block & mctech.blocks.base.a> LBlock<T> registerBlock(String str, Supplier<T> supplier, boolean z, ResourceKey<CreativeModeTab> resourceKey) {
        LBlock<T> lBlockRemoveModelProvider = BLOCK_REGISTRY.register(str, supplier).removeModelProvider();
        if (z) {
            MCTechItems.registerBlockItem(str, lBlockRemoveModelProvider, resourceKey);
        }
        return lBlockRemoveModelProvider;
    }

    public static <B extends Block> List<LBlock<B>> toList(HashMap<MachineTier, LBlock<B>> map, MachineTier... machineTierArr) {
        Stream<MachineTier> streamFilter = map.keySet().stream().filter(machineTier -> {
            return Arrays.stream(machineTierArr).anyMatch(machineTier -> {
                return machineTier == machineTier;
            });
        });
        Objects.requireNonNull(map);
        return streamFilter.map((v1) -> {
            return r1.get(v1);
        }).toList();
    }

    public static <B extends Block> LBlock<B>[] toArray(HashMap<MachineTier, LBlock<B>> map, MachineTier... machineTierArr) {
        List list = toList(map, machineTierArr);
        LBlock<B>[] lBlockArr = new LBlock[list.size()];
        for (int i = 0; i < list.size(); i++) {
            lBlockArr[i] = (LBlock) list.get(i);
        }
        return lBlockArr;
    }

    public static <B extends Block> LBlock<B>[] toArray(Set<HashMap<MachineTier, LBlock<B>>> set, MachineTier... machineTierArr) {
        ArrayList arrayList = new ArrayList();
        Iterator<HashMap<MachineTier, LBlock<B>>> it = set.iterator();
        while (it.hasNext()) {
            arrayList.addAll(toList(it.next(), machineTierArr));
        }
        LBlock<B>[] lBlockArr = new LBlock[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            lBlockArr[i] = (LBlock) arrayList.get(i);
        }
        return lBlockArr;
    }

    public static void addBlocks() {
        addGenerators();
        addMachines();
        addStorage();
        addResourceBlocks();
        addConstructionBlocks();
    }

    private static <I extends Item> LBlock<mctech.blocks.e.c> registerOre(String str, float f, boolean z, String str2, String str3, LItem<I> lItem) {
        return BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new mctech.blocks.e.c(f, 5.0f, z);
        }, BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            blockStateProvider.getVariantBuilder((Block) dataGenContext.get()).forAllStates(blockState -> {
                return ConfiguredModel.builder().modelFile(blockStateProvider.models().cubeAll(dataGenContext.getName(), blockStateProvider.modLoc(String.format("block/ore/%s", dataGenContext.getName()))).texture("particle", blockStateProvider.modLoc(String.format("block/ore/%s", dataGenContext.getName())))).build();
            });
        }).setTranslation(str2, str3).addBlockTags(new TagKey[]{BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL, Tags.Blocks.ORES}).setLootTable((lBlockLootProvider, cVar) -> {
            lBlockLootProvider.add(cVar, lBlockLootProvider.createOreDrop(cVar, (Item) lItem.get()));
        }).createBlockItem(ITEM_REGISTRY, (v1) -> {
            return new mctech.items.base.g(v1);
        }, lItem2 -> {
            lItem2.setTranslation(str2, str3).setTab(MCTechCreativeTabs.MAIN).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                lItemModelProvider.basicBlock((Item) dataGenContext2.get());
            });
        });
    }

    private static LBlock<mctech.blocks.e.d> registerRawOreBlock(String str, float f, String str2, String str3, TagKey... tagKeyArr) {
        return registerSimpleBlock(str, "raw", properties -> {
            return new mctech.blocks.e.d(f, 5.0f);
        }, BlockBehaviour.Properties.of(), str2, str3, MCTechCreativeTabs.MAIN, (TagKey[]) Arrays.stream(tagKeyArr).filter(tagKey -> {
            return tagKey.isFor(BuiltInRegistries.ITEM.key());
        }).map(tagKey2 -> {
            return tagKey2;
        }).toList().toArray(new TagKey[0])).addBlockTags(new TagKey[]{BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL}).addBlockTags((TagKey[]) Arrays.stream(tagKeyArr).filter(tagKey3 -> {
            return tagKey3.isFor(BuiltInRegistries.BLOCK.key());
        }).map(tagKey4 -> {
            return tagKey4;
        }).toList().toArray(new TagKey[0]));
    }

    private static LBlock<mctech.blocks.c> registerDustBlock(String str, String str2, String str3) {
        return registerSimpleBlock(str, "dust", mctech.blocks.c::new, BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.SAND), str2, str3, MCTechCreativeTabs.MAIN, new TagKey[0]).addBlockTags(new TagKey[]{BlockTags.MINEABLE_WITH_SHOVEL, BlockTags.NEEDS_STONE_TOOL});
    }

    private static LBlock<mctech.blocks.e.e> registerResourceBlock(String str, mctech.blocks.e.e.a aVar, String str2, String str3, TagKey... tagKeyArr) {
        return registerSimpleBlock(str, "storage", properties -> {
            return new mctech.blocks.e.e(aVar);
        }, BlockBehaviour.Properties.of().requiresCorrectToolForDrops(), str2, str3, MCTechCreativeTabs.MAIN, (TagKey[]) Arrays.stream(tagKeyArr).filter(tagKey -> {
            return tagKey.isFor(BuiltInRegistries.ITEM.key());
        }).map(tagKey2 -> {
            return tagKey2;
        }).toList().toArray(new TagKey[0])).addBlockTags((TagKey[]) Arrays.stream(tagKeyArr).filter(tagKey3 -> {
            return tagKey3.isFor(BuiltInRegistries.BLOCK.key());
        }).map(tagKey4 -> {
            return tagKey4;
        }).toList().toArray(new TagKey[0]));
    }

    private static <B extends Block> LBlock<B> registerMachineBlock(String str, Supplier<B> supplier, String str2, String str3, TagKey... tagKeyArr) {
        return registerSimpleBlock(str, "machine_block", properties -> {
            return (Block) supplier.get();
        }, BlockBehaviour.Properties.of(), str2, str3, MCTechCreativeTabs.MAIN, new TagKey[0]).addBlockTags(new TagKey[]{BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL});
    }

    private static <B extends Block> LBlock<B> registerReinforcedBlock(String str, Supplier<B> supplier, String str2, String str3, TagKey... tagKeyArr) {
        return registerSimpleBlock(str, "reinforced", properties -> {
            return (Block) supplier.get();
        }, BlockBehaviour.Properties.of(), str2, str3, MCTechCreativeTabs.MAIN, (TagKey[]) Arrays.stream(tagKeyArr).filter(tagKey -> {
            return tagKey.isFor(BuiltInRegistries.ITEM.key());
        }).map(tagKey2 -> {
            return tagKey2;
        }).toList().toArray(new TagKey[0])).addBlockTags(new TagKey[]{BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL}).addBlockTags((TagKey[]) Arrays.stream(tagKeyArr).filter(tagKey3 -> {
            return tagKey3.isFor(BuiltInRegistries.BLOCK.key());
        }).map(tagKey4 -> {
            return tagKey4;
        }).toList().toArray(new TagKey[0]));
    }

    private static <B extends Block> LBlock<B> registerSimpleBlock(String str, String str2, Function<BlockBehaviour.Properties, B> function, BlockBehaviour.Properties properties, String str3, String str4, ResourceKey<CreativeModeTab> resourceKey, TagKey<Item>... tagKeyArr) {
        return BLOCK_REGISTRY.registerBlock(str, function, properties).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            blockStateProvider.getVariantBuilder((Block) dataGenContext.get()).forAllStates(blockState -> {
                return ConfiguredModel.builder().modelFile(blockStateProvider.models().cubeAll(dataGenContext.getName(), blockStateProvider.modLoc(String.format("block/%s/%s", str2, dataGenContext.getName()))).texture("particle", blockStateProvider.modLoc(String.format("block/%s/%s", str2, dataGenContext.getName())))).build();
            });
        }).setLootTable((v0, v1) -> {
            v0.dropSelf(v1);
        }).setTranslation(str3, str4).createBlockItem(ITEM_REGISTRY, mctech.items.base.g::new, lItem -> {
            lItem.setTranslation(str3, str4).addItemTags(tagKeyArr).setTab(resourceKey).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                lItemModelProvider.basicBlock((Item) dataGenContext2.get());
            });
        });
    }

    private static <B extends Block> LBlock<B> registerWoodenLog(String str, boolean z, boolean z2, String str2, String str3) {
        return BLOCK_REGISTRY.registerBlock(str, properties -> {
            return z2 ? new mctech.blocks.e.f(z) : new mctech.blocks.e.h(z);
        }, BlockBehaviour.Properties.of()).setLootTable((v0, v1) -> {
            v0.dropSelf(v1);
        }).addBlockTags(new TagKey[]{BlockTags.MINEABLE_WITH_AXE, BlockTags.LOGS, BlockTags.LOGS_THAT_BURN}).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            int i;
            if (!z2) {
                String str4 = z ? "stripped" : "normal";
                ResourceLocation resourceLocationLoc = MCTech.loc(String.format("block/%s/log_%s_side_normal", str, str4));
                ResourceLocation resourceLocationLoc2 = MCTech.loc(String.format("block/%s/log_%s_top", str, str4));
                ResourceLocation resourceLocationLoc3 = MCTech.loc(String.format("block/%s/log_%s_side_full", str, str4));
                ResourceLocation resourceLocationLoc4 = MCTech.loc(String.format("block/%s/log_%s_side_empty", str, str4));
                ModelBuilder modelBuilderCubeColumn = blockStateProvider.models().cubeColumn(str, resourceLocationLoc, resourceLocationLoc2);
                ModelBuilder modelBuilderCubeColumnHorizontal = blockStateProvider.models().cubeColumnHorizontal(str + "_horizontal", resourceLocationLoc, resourceLocationLoc2);
                ModelBuilder modelBuilderCube = blockStateProvider.models().cube(str + "_full", resourceLocationLoc2, resourceLocationLoc2, resourceLocationLoc3, resourceLocationLoc, resourceLocationLoc, resourceLocationLoc);
                ModelBuilder modelBuilderCube2 = blockStateProvider.models().cube(str + "_empty", resourceLocationLoc2, resourceLocationLoc2, resourceLocationLoc4, resourceLocationLoc, resourceLocationLoc, resourceLocationLoc);
                MultiPartBlockStateBuilder multipartBuilder = blockStateProvider.getMultipartBuilder((Block) dataGenContext.get());
                ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(modelBuilderCubeColumnHorizontal).rotationX(90).addModel()).condition(mctech.blocks.e.h.d, new Boolean[]{false}).condition(BlockStateProperties.AXIS, new Direction.Axis[]{Direction.Axis.Z}).end();
                ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(modelBuilderCubeColumn).addModel()).condition(mctech.blocks.e.h.d, new Boolean[]{false}).condition(BlockStateProperties.AXIS, new Direction.Axis[]{Direction.Axis.Y}).end();
                ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(modelBuilderCubeColumnHorizontal).rotationX(90).rotationY(90).addModel()).condition(mctech.blocks.e.h.d, new Boolean[]{false}).condition(BlockStateProperties.AXIS, new Direction.Axis[]{Direction.Axis.X}).end();
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    switch (AnonymousClass2.$SwitchMap$net$minecraft$core$Direction[direction.ordinal()]) {
                        case 1:
                            i = 90;
                            break;
                        case 2:
                            i = 180;
                            break;
                        case 3:
                            i = 270;
                            break;
                        default:
                            i = 0;
                            break;
                    }
                    int i2 = i;
                    ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(modelBuilderCube).rotationY(i2).addModel()).condition(mctech.blocks.e.h.a, new Direction[]{direction}).condition(mctech.blocks.e.h.d, new Boolean[]{true}).condition(mctech.blocks.e.h.e, new Boolean[]{true}).end();
                    ((MultiPartBlockStateBuilder.PartBuilder) multipartBuilder.part().modelFile(modelBuilderCube2).rotationY(i2).addModel()).condition(mctech.blocks.e.h.a, new Direction[]{direction}).condition(mctech.blocks.e.h.d, new Boolean[]{true}).condition(mctech.blocks.e.h.e, new Boolean[]{false}).end();
                }
                return;
            }
            blockStateProvider.getVariantBuilder((Block) dataGenContext.get()).forAllStates(blockState -> {
                ConfiguredModel.Builder builder = ConfiguredModel.builder();
                BlockModelProvider blockModelProviderModels = blockStateProvider.models();
                Object[] objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = z ? "barked_stripped" : "barked";
                return builder.modelFile(blockModelProviderModels.cubeAll(str, MCTech.loc(String.format("block/%s/log_%s_side_normal", objArr)))).build();
            });
        }).setTranslation(str2, str3).addBlockTags(new TagKey[]{BlockTags.LOGS, BlockTags.LOGS_THAT_BURN}).createBlockItem(ITEM_REGISTRY, mctech.items.base.g::new, lItem -> {
            lItem.setTranslation(str2, str3).setTab(MCTechCreativeTabs.MATERIALS).addItemTags(new TagKey[]{ItemTags.LOGS}).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                lItemModelProvider.basicBlock((Item) dataGenContext2.get());
            });
        });
    }

    /* JADX INFO: renamed from: mctech.init.MCTechBlocks$2, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechBlocks$2.class */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$core$Direction = new int[Direction.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.EAST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.SOUTH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.WEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static LBlock<mctech.blocks.e.b> createBedrockOre(String str, float f, String str2, String str3) {
        return BLOCK_REGISTRY.registerBlock(String.format("bedrock_%s_ore", str), mctech.blocks.e.b::new, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(f, 1200.0f).sound(SoundType.STONE)).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            blockStateProvider.getVariantBuilder((Block) dataGenContext.get()).forAllStates(blockState -> {
                return ConfiguredModel.builder().modelFile(blockStateProvider.models().cubeBottomTop(dataGenContext.getName(), blockStateProvider.modLoc(String.format("block/ore/%s/%s_ore_side", str, str)), blockStateProvider.modLoc(String.format("block/ore/%s/%s_ore_down", str, str)), blockStateProvider.modLoc(String.format("block/ore/%s/%s_ore_up", str, str))).texture("particle", blockStateProvider.modLoc(String.format("block/ore/%s/%s_ore_side", str, str)))).build();
            });
        }).setLootTable((v0, v1) -> {
            v0.dropSelf(v1);
        }).setTranslation(str2, str3).addBlockTags(new TagKey[]{MCTechTags.BEDROCK_ORE, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, (v1) -> {
            return new mctech.items.base.g(v1);
        }, lItem -> {
            lItem.setTranslation(str2, str3).setTab(MCTechCreativeTabs.MAIN).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                lItemModelProvider.basicBlock((Item) dataGenContext2.get());
            });
        });
    }

    static void addResourceBlocks() {
        AMETHYST = registerOre("amethyst_ore", 3.0f, false, "Amethyst ore", "Аметистовая руда", MCTechItems.RAW_AMETHYST).addBlockTags(new TagKey[]{MCTechTags.Ores.AMETHYST, Tags.Blocks.ORES});
        DEEPSLATE_AMETHYST = registerOre("deepslate_amethyst_ore", 3.0f, true, "Deepslate amethyst ore", "Глубинная аметистовая руда", MCTechItems.RAW_AMETHYST).addBlockTags(new TagKey[]{MCTechTags.Ores.AMETHYST, Tags.Blocks.ORES});
        TIN_ORE = registerOre("tin_ore", 3.0f, false, "Tin ore", "Оловянная руда", MCTechItems.RAW_TIN).addBlockTags(new TagKey[]{MCTechTags.Ores.TIN, Tags.Blocks.ORES});
        DEEPSLATE_TIN_ORE = registerOre("deepslate_tin_ore", 3.0f, true, "Deepslate tin ore", "Глубинная оловянная руда", MCTechItems.RAW_TIN).addBlockTags(new TagKey[]{MCTechTags.Ores.TIN, Tags.Blocks.ORES});
        SILVER_ORE = registerOre("silver_ore", 4.0f, false, "Silver ore", "Серебряная руда", MCTechItems.RAW_SILVER).addBlockTags(new TagKey[]{MCTechTags.Ores.SILVER, Tags.Blocks.ORES});
        SILVER_ORE_NETHER = registerOre("silver_ore_nether", 4.0f, false, "Silver ore", "Серебряная руда", MCTechItems.RAW_SILVER).addBlockTags(new TagKey[]{MCTechTags.Ores.SILVER, Tags.Blocks.ORES});
        DEEPSLATE_SILVER_ORE = registerOre("deepslate_silver_ore", 4.0f, true, "Deepslate silver ore", "Глубинная серебряная руда", MCTechItems.RAW_SILVER).addBlockTags(new TagKey[]{MCTechTags.Ores.SILVER, Tags.Blocks.ORES});
        ALUMINUM_ORE_NETHER = registerOre("aluminium_ore_nether", 4.0f, false, "Aluminium ore", "Алюминиевая руда", MCTechItems.RAW_ALUMINIUM).addBlockTags(new TagKey[]{MCTechTags.Ores.ALUMINUM, Tags.Blocks.ORES});
        URANIUM_ORE = registerOre("uranium_ore", 6.0f, false, "Uranium ore", "Урановая руда", MCTechItems.ORE_URANIUM_DROP).addBlockTags(new TagKey[]{MCTechTags.Ores.URANIUM, Tags.Blocks.ORES});
        DEEPSLATE_URANIUM_ORE = registerOre("deepslate_uranium_ore", 6.0f, true, "Deepslate uranium ore", "Глубинная урановая руда", MCTechItems.ORE_URANIUM_DROP).addBlockTags(new TagKey[]{MCTechTags.Ores.URANIUM, Tags.Blocks.ORES});
        RUBIDIUM_ORE = registerOre("rubidium_ore", 3.0f, false, "Rubidium ore", "Рубидиевая руда", MCTechItems.RAW_RUBIDIUM).addBlockTags(new TagKey[]{MCTechTags.Ores.RUBIDIUM, Tags.Blocks.ORES});
        TITANIUM_ORE = registerOre("titanium_ore", 3.0f, false, "Titanium ore", "Титановая руда", MCTechItems.RAW_TITANIUM).addBlockTags(new TagKey[]{MCTechTags.Ores.TITANIUM, Tags.Blocks.ORES});
        RAW_TIN_BLOCK = registerRawOreBlock("raw_tin_block", 3.0f, "Raw tin block", "Блок рудного олова", MCTechTags.ORE_TIN_BLOCK, MCTechTags.ORE_TIN);
        RAW_SILVER_BLOCK = registerRawOreBlock("raw_silver_block", 4.0f, "Raw silver block", "Блок рудного серебра", MCTechTags.ORE_SILVER_BLOCK, MCTechTags.ORE_SILVER);
        RAW_ALUMINIUM_BLOCK = registerRawOreBlock("raw_aluminium_block", 4.0f, "Raw aluminium block", "Блок рудного алюминия", MCTechTags.ORE_ALUMINIUM_BLOCK, MCTechTags.ORE_ALUMINIUM);
        RAW_URANIUM_BLOCK = registerRawOreBlock("raw_uranium_block", 4.0f, "Raw uranium block", "Блок рудного урана", MCTechTags.ORE_URANIUM_BLOCK, MCTechTags.ORE_URANIUM);
        DUST_IRON_BLOCK = registerDustBlock("iron_dust_block", "Block of iron dust", "Блок железной пыли");
        DUST_GOLD_BLOCK = registerDustBlock("gold_dust_block", "Block of gold dust", "Блок золотой пыли");
        DUST_COPPER_BLOCK = registerDustBlock("copper_dust_block", "Block of copper dust", "Блок медной пыли");
        DUST_TIN_BLOCK = registerDustBlock("tin_dust_block", "Block of tin dust", "Блок оловянной пыли");
        DUST_BRONZE_BLOCK = registerDustBlock("bronze_dust_block", "Block of bronze dust", "Блок бронзовой пыли");
        DUST_SILVER_BLOCK = registerDustBlock("silver_dust_block", "Block of silver dust", "Блок серебряной пыли");
        DUST_ALUMINIUM_BLOCK = registerDustBlock("aluminium_dust_block", "Block of aluminium dust", "Блок алюминиевой пыли");
        BRONZE_BLOCK = registerResourceBlock("bronze_block", mctech.blocks.e.e.a.c, "Bronze block", "Бронзовый блок", MCTechTags.STORAGE_BRONZE_BLOCK, MCTechTags.STORAGE_BRONZE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
        TIN_BLOCK = registerResourceBlock("tin_block", mctech.blocks.e.e.a.b, "Tin block", "Оловянный блок", MCTechTags.STORAGE_TIN_BLOCK, MCTechTags.STORAGE_TIN, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
        CHARCOAL_BLOCK = registerResourceBlock("charcoal_block", mctech.blocks.e.e.a.a, "Charcoal block", "Блок древесного угля", BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
        SILVER_BLOCK = registerResourceBlock("silver_block", mctech.blocks.e.e.a.c, "Silver block", "Серебряный блок", MCTechTags.STORAGE_SILVER_BLOCK, MCTechTags.STORAGE_SILVER, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
        URANIUM_BLOCK = registerResourceBlock("uranium_block", mctech.blocks.e.e.a.c, "Uranium block", "Урановый блок", MCTechTags.STORAGE_URANIUM_BLOCK, MCTechTags.STORAGE_URANIUM, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
        ALUMINIUM_BLOCK = registerResourceBlock("aluminium_block", mctech.blocks.e.e.a.c, "Aluminium block", "Алюминиевый блок", MCTechTags.STORAGE_ALUMINIUM_BLOCK, MCTechTags.STORAGE_ALUMINIUM, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
        REFINED_IRON_BLOCK = registerResourceBlock("refined_iron_block", mctech.blocks.e.e.a.c, "Refined iron block", "Блок закаленного железа", MCTechTags.STORAGE_REFINED_BLOCK, MCTechTags.STORAGE_REFINED_IRON, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
        RUBBERWOOD_LOG = registerWoodenLog("rubber_wood", false, false, "Rubber wood", "Древесина гевеи");
        RUBBER_LOG_STRIPPED = registerWoodenLog("rubber_wood_stripped", true, false, "Stripped rubber wood", "Обтесанная древесина гевеи");
        RUBBERWOOD_LOG_BARKED = registerWoodenLog("rubber_wood_barked", false, true, "Barked rubber wood", "Бревно гевеи");
        RUBBER_LOG_BARKED_STRIPPED = registerWoodenLog("rubber_wood_barked_stripped", true, true, "Stripped rubber wood", "Обтесанное бревно гевеи");
        RUBBER_PLANKS = BLOCK_REGISTRY.registerBlock("rubber_planks", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)).setLootTable((v0, v1) -> {
            v0.dropSelf(v1);
        }).addBlockTags(new TagKey[]{BlockTags.PLANKS, BlockTags.MINEABLE_WITH_AXE}).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            blockStateProvider.getVariantBuilder((Block) dataGenContext.get()).forAllStates(blockState -> {
                return ConfiguredModel.builder().modelFile(blockStateProvider.models().cubeAll(dataGenContext.getName(), blockStateProvider.modLoc(String.format("block/rubber/%s", dataGenContext.getName())))).build();
            });
        }).setTranslation("Rubber planks", "Доски гевеи").createBlockItem(ITEM_REGISTRY, mctech.items.base.g::new, lItem -> {
            lItem.setTranslation("Rubber planks", "Доски гевеи").setTab(MCTechCreativeTabs.MATERIALS).addItemTags(new TagKey[]{ItemTags.PLANKS}).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                lItemModelProvider.basicBlock((Item) dataGenContext2.get());
            });
        });
        RUBBER_DOOR = BLOCK_REGISTRY.registerBlock("rubber_door", properties -> {
            return new DoorBlock(RUBBER_BLOCK_SET, properties);
        }, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_DOOR)).setLootTable((v0, v1) -> {
            v0.createDoor(v1);
        }).addBlockTags(new TagKey[]{BlockTags.WOODEN_DOORS, BlockTags.DOORS, BlockTags.MINEABLE_WITH_AXE}).setBlockStateProvider((blockStateProvider2, dataGenContext2) -> {
            blockStateProvider2.doorBlock((DoorBlock) dataGenContext2.get(), blockStateProvider2.modLoc("block/rubber/rubber_door_bottom"), blockStateProvider2.modLoc("block/rubber/rubber_door_top"));
        }).setTranslation("Rubber door", "Дверь из гевеи").createBlockItem(ITEM_REGISTRY, (v1) -> {
            return new mctech.items.base.g(v1);
        }, lItem2 -> {
            lItem2.setTranslation("Rubber door", "Дверь из гевеи").setTab(MCTechCreativeTabs.MATERIALS).addItemTags(new TagKey[]{ItemTags.WOODEN_DOORS}).setModelProvider((lItemModelProvider, dataGenContext3) -> {
                lItemModelProvider.basicItem((Item) dataGenContext3.get(), MCTech.loc(String.format("item/rubber/%s", dataGenContext3.getName())));
            });
        });
        RUBBER_TRAPDOOR = BLOCK_REGISTRY.registerBlock("rubber_trapdoor", properties2 -> {
            return new TrapDoorBlock(RUBBER_BLOCK_SET, properties2);
        }, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_TRAPDOOR)).setLootTable((v0, v1) -> {
            v0.createDoor(v1);
        }).addBlockTags(new TagKey[]{BlockTags.WOODEN_TRAPDOORS, BlockTags.TRAPDOORS, BlockTags.MINEABLE_WITH_AXE}).setBlockStateProvider((blockStateProvider3, dataGenContext3) -> {
            blockStateProvider3.trapdoorBlock((TrapDoorBlock) dataGenContext3.get(), blockStateProvider3.modLoc("block/rubber/rubber_trapdoor"), true);
        }).setTranslation("Rubber trapdoor", "Люк из гевеи").createBlockItem(ITEM_REGISTRY, (v1) -> {
            return new mctech.items.base.g(v1);
        }, lItem3 -> {
            lItem3.setTranslation("Rubber trapdoor", "Люк из гевеи").setTab(MCTechCreativeTabs.MATERIALS).addItemTags(new TagKey[]{ItemTags.TRAPDOORS}).setModelProvider((lItemModelProvider, dataGenContext4) -> {
                lItemModelProvider.withExistingParent(dataGenContext4.getName(), lItemModelProvider.modLoc(String.format("block/%s_bottom", dataGenContext4.getName()))).renderType("cutout");
            });
        });
        RUBBER_LEAVES = BLOCK_REGISTRY.registerBlock("rubber_leaves", properties3 -> {
            return new g();
        }, BlockBehaviour.Properties.of()).setLootTable((lBlockLootProvider, gVar) -> {
            lBlockLootProvider.add(gVar, lBlockLootProvider.createLeavesDrops(gVar, (Block) RUBBER_SAPLING.get(), new float[]{0.05f, 0.0625f, 0.083333336f, 0.1f}));
        }).addBlockTags(new TagKey[]{BlockTags.LEAVES}).setBlockStateProvider((blockStateProvider4, dataGenContext4) -> {
            blockStateProvider4.getVariantBuilder((Block) dataGenContext4.get()).forAllStates(blockState -> {
                return ConfiguredModel.builder().modelFile(blockStateProvider4.models().withExistingParent(dataGenContext4.getName(), blockStateProvider4.mcLoc("block/birch_leaves"))).build();
            });
        }).setTranslation("Rubber leaves", "Листья гевеи").createBlockItem(ITEM_REGISTRY, (v1) -> {
            return new mctech.items.base.g(v1);
        }, lItem4 -> {
            lItem4.setTranslation("Rubber leaves", "Листья гевеи").setTab(MCTechCreativeTabs.MATERIALS).addItemTags(new TagKey[]{ItemTags.LEAVES}).setModelProvider((lItemModelProvider, dataGenContext5) -> {
                lItemModelProvider.basicBlock((Item) dataGenContext5.get());
            });
        });
        RUBBER_SAPLING = BLOCK_REGISTRY.registerBlock("rubber_sapling", properties4 -> {
            return new mctech.blocks.e.i();
        }, BlockBehaviour.Properties.of()).setLootTable((v0, v1) -> {
            v0.dropSelf(v1);
        }).addBlockTags(new TagKey[]{BlockTags.SAPLINGS}).setBlockStateProvider((blockStateProvider5, dataGenContext5) -> {
            blockStateProvider5.getVariantBuilder((Block) dataGenContext5.get()).forAllStates(blockState -> {
                return ConfiguredModel.builder().modelFile(blockStateProvider5.models().cross(dataGenContext5.getName(), MCTech.loc("block/rubber/rubber_sapling")).renderType("cutout")).build();
            });
        }).setTranslation("Rubber sapling", "Саженец гевеи").createBlockItem(ITEM_REGISTRY, (v1) -> {
            return new mctech.items.a.c(v1);
        }, lItem5 -> {
            lItem5.setTranslation("Rubber sapling", "Саженец гевеи").setTab(MCTechCreativeTabs.MATERIALS).addItemTags(new TagKey[]{ItemTags.SAPLINGS}).setModelProvider((lItemModelProvider, dataGenContext6) -> {
                lItemModelProvider.basicItem((Item) dataGenContext6.get(), MCTech.loc("item/rubber/rubber_sapling"));
            });
        });
    }

    static void addConstructionBlocks() {
        MACHINE_BLOCK = registerMachineBlock("machine_block", s::new, "Machine block", "Машинный корпус", new TagKey[0]);
        MACHINE_BLOCK_PLATED = registerMachineBlock("machine_block_plated", s::new, "Plated machine block", "Обшитый машинный корпус", new TagKey[0]);
        ADVANCED_MACHINE_BLOCK = registerMachineBlock("advanced_machine_block", s::new, "Advanced machine block", "Продвинутый машинный корпус", new TagKey[0]);
        STABILIZED_MACHINE_BLOCK = registerMachineBlock("stabilized_machine_block", s::new, "Stabilized machine block", "Стабилизированный машинный корпус", new TagKey[0]);
        COMPOSITE_MACHINE_BLOCK = registerMachineBlock("composite_machine_block", s::new, "Composite machine block", "Композитный машинный корпус", new TagKey[0]);
        NANO_MACHINE_BLOCK = registerMachineBlock("nano_machine_block", s::new, "Nano machine block", "Нано машинный корпус", new TagKey[0]);
        QUANTUM_MACHINE_BLOCK = registerMachineBlock("quantum_machine_block", s::new, "Quantum machine block", "Квантовый машинный корпус", new TagKey[0]);
        SINGULAR_MACHINE_BLOCK = registerMachineBlock("singular_machine_block", s::new, "Singular machine block", "Мета машинный корпус", new TagKey[0]);
        ADMIN_MACHINE_BLOCK = registerMachineBlock("admin_machine_block", s::new, "Admin machine block", "Омега машинный корпус", new TagKey[0]);
        REINFORCED_STONE = registerReinforcedBlock("reinforced_stone", mctech.blocks.d::a, "Reinforced stone", "Усиленный камень", new TagKey[0]);
        REINFORCED_CRACKED_STONE = registerReinforcedBlock("reinforced_cracked_stone", mctech.blocks.d::a, "Cracked reinforced stone", "Потресканный усиленный камень", new TagKey[0]);
        REINFORCED_BRICK = registerReinforcedBlock("reinforced_brick", mctech.blocks.d::a, "Reinforced bricks", "Усиленный кирпич", new TagKey[0]);
        REINFORCED_GLASS = registerReinforcedBlock("reinforced_glass", mctech.blocks.d::c, "Reinforced glass", "Усиленное стекло", new TagKey[0]);
    }

    static void addGenerators() {
        GENERATOR = registerItemBlock("generator", () -> {
            return new mctech.blocks.b.b().setDropProvider(IBlockDropProvider.SELF_OR_GENERATOR);
        }, MCTechCreativeTabs.ENERGY);
        GEOTHERMAL_GENERATOR = registerItemBlock("geothermal_generator", () -> {
            return new mctech.blocks.b.b().setDropProvider(IBlockDropProvider.SELF_OR_GENERATOR);
        }, MCTechCreativeTabs.ENERGY);
        SLAG_GENERATOR = registerItemBlock("slag_generator", () -> {
            return new mctech.blocks.b.b().setDropProvider(IBlockDropProvider.SELF_OR_GENERATOR);
        }, MCTechCreativeTabs.ENERGY);
        WATER_MILL = registerItemBlock("water_mill", mctech.blocks.b.b::new, MCTechCreativeTabs.ENERGY);
        WATER_MILL_T2 = registerItemBlock("water_mill_t2", mctech.blocks.b.b::new, MCTechCreativeTabs.ENERGY);
        WATER_MILL_T3 = registerItemBlock("water_mill_t3", mctech.blocks.b.b::new, MCTechCreativeTabs.ENERGY);
        WATER_MILL_T4 = registerItemBlock("water_mill_t4", mctech.blocks.b.b::new, MCTechCreativeTabs.ENERGY);
        THERMAL_GENERATOR = registerItemBlock("thermal_generator", () -> {
            return new mctech.blocks.b.g(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(5.0f, 25.0f).requiresCorrectToolForDrops()).setDropProvider(IBlockDropProvider.SELF_OR_GENERATOR);
        }, MCTechCreativeTabs.ENERGY);
        STANDARD_SOLAR_PANEL = registerItemBlock("standard_solar_panel", mctech.blocks.b.a::new, MCTechCreativeTabs.ENERGY);
        SIMPLE_SOLAR_PANEL = registerItemBlock("simple_solar_panel", mctech.blocks.b.a::new, MCTechCreativeTabs.ENERGY);
        ADVANCED_SOLAR_PANEL = registerItemBlock("advanced_solar_panel", mctech.blocks.b.a::new, MCTechCreativeTabs.ENERGY);
        HYBRID_SOLAR_PANEL = registerItemBlock("hybrid_solar_panel", mctech.blocks.b.a::new, MCTechCreativeTabs.ENERGY);
        PROTON_SOLAR_PANEL = registerItemBlock("proton_solar_panel", mctech.blocks.b.a::new, MCTechCreativeTabs.ENERGY);
        COMPOSITE_SOLAR_PANEL = registerItemBlock("composite_solar_panel", mctech.blocks.b.a::new, MCTechCreativeTabs.ENERGY);
        NANO_SOLAR_PANEL = registerItemBlock("nano_solar_panel", mctech.blocks.b.a::new, MCTechCreativeTabs.ENERGY);
        QUANT_SOLAR_PANEL = registerItemBlock("quant_solar_panel", mctech.blocks.b.a::new, MCTechCreativeTabs.ENERGY);
        SINGULAR_SOLAR_PANEL = registerItemBlock("singular_solar_panel", mctech.blocks.b.a::new, MCTechCreativeTabs.ENERGY);
        ADMIN_SOLAR_PANEL = registerItemBlock("admin_solar_panel", mctech.blocks.b.a::new, MCTechCreativeTabs.ENERGY);
        COMPOSITE_MULTISOLAR_PANEL = registerItemBlock("composite_multisolar_panel", mctech.blocks.b.c::new, MCTechCreativeTabs.ENERGY);
        NANO_MULTISOLAR_PANEL = registerItemBlock("nano_multisolar_panel", mctech.blocks.b.c::new, MCTechCreativeTabs.ENERGY);
        QUANT_MULTISOLAR_PANEL = registerItemBlock("quant_multisolar_panel", mctech.blocks.b.c::new, MCTechCreativeTabs.ENERGY);
        SINGULAR_MULTISOLAR_PANEL = registerItemBlock("singular_multisolar_panel", mctech.blocks.b.c::new, MCTechCreativeTabs.ENERGY);
        RUBID_MULTISOLAR_PANEL = registerItemBlock("rubid_multisolar_panel", mctech.blocks.b.c::new, MCTechCreativeTabs.ENERGY);
        THERMONUCLEAR_REACTOR = BLOCK_REGISTRY.registerBlock("thermonuclear_reactor", mctech.blocks.b.h::new, DEFAULT_MACHINE).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation("Thermonuclear reactor", "Термоядерный реактор").setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            GeckoData.block(blockStateProvider, dataGenContext, blockStateProvider.modLoc(String.format("block/%s/%s", dataGenContext.getName(), dataGenContext.getName())));
        }).createBlockItem(ITEM_REGISTRY, hVar -> {
            return new mctech.items.base.a(hVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.ENERGY).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc("thermonuclear_reactor")).transforms().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).scale(0.2f, 0.2f, 0.2f).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).scale(0.2f, 0.2f, 0.2f).end().transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).scale(0.2f, 0.2f, 0.2f).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).scale(0.2f, 0.2f, 0.2f).end().transform(ItemDisplayContext.GROUND).scale(0.2f, 0.2f, 0.2f).end().transform(ItemDisplayContext.GUI).rotation(58.0f, -9.0f, 23.0f).translation(1.0f, -1.0f, 0.0f).scale(0.3f, 0.3f, 0.3f).end().transform(ItemDisplayContext.HEAD).translation(0.0f, -6.5f, 0.0f).end().transform(ItemDisplayContext.FIXED).rotation(90.0f, 0.0f, 0.0f).scale(0.2f, 0.2f, 0.2f).end().end();
            });
        });
        THERMONUCLEAR_REACTOR_DUMMY = BLOCK_REGISTRY.registerBlock("thermonuclear_reactor_dummy", properties -> {
            return new mctech.blocks.b.i();
        }, DEFAULT_MACHINE);
    }

    static void addMachines() {
        IRON_FURNACE = registerItemBlock("iron_furnace", mctech.blocks.b::new, MCTechCreativeTabs.MACHINES);
        STONE_MACERATOR = registerItemBlock("stone_macerator", mctech.blocks.b::new, MCTechCreativeTabs.MACHINES).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE});
        STONE_CANNER = registerItemBlock("stone_canner", mctech.blocks.b::new, MCTechCreativeTabs.MACHINES);
        RECYCLER = registerItemBlock("recycler", () -> {
            return new mctech.blocks.b().setDropProvider(IBlockDropProvider.SELF_OR_MACHINE);
        }, MCTechCreativeTabs.MACHINES);
        SAWMILL = registerItemBlock("sawmill", () -> {
            return new mctech.blocks.b().setDropProvider(IBlockDropProvider.SELF_OR_MACHINE);
        }, MCTechCreativeTabs.MACHINES);
        RARE_EARTH_EXTRACTOR = registerItemBlock("rare_earth_extractor", () -> {
            return new mctech.blocks.b().setDropProvider(IBlockDropProvider.SELF_OR_MACHINE);
        }, MCTechCreativeTabs.MACHINES);
        CANNER = registerItemBlock("canner", () -> {
            return new mctech.blocks.b().setDropProvider(IBlockDropProvider.SELF_OR_MACHINE);
        }, MCTechCreativeTabs.MACHINES);
        ELECTROLYZER = registerItemBlock("electrolyzer", () -> {
            return new mctech.blocks.b().setDropProvider(IBlockDropProvider.SELF_OR_MACHINE);
        }, MCTechCreativeTabs.MACHINES);
        CHARGED_ELECTROLYZER = registerItemBlock("charged_electrolyzer", () -> {
            return new mctech.blocks.b().setDropProvider(IBlockDropProvider.SELF_OR_ADV_MACHINE);
        }, MCTechCreativeTabs.MACHINES);
        CENTRIFUGAL_RARE_EARTH_EXTRACTOR = registerItemBlock("centrifugal_rare_earth_extractor", () -> {
            return new mctech.blocks.b().setDropProvider(IBlockDropProvider.SELF_OR_ADV_MACHINE);
        }, MCTechCreativeTabs.MACHINES);
        REFINERY = registerItemBlock("refinery", () -> {
            return new mctech.blocks.b().setDropProvider(IBlockDropProvider.SELF_OR_ADV_MACHINE);
        }, MCTechCreativeTabs.MACHINES);
        URANIUM_ENRICHER = registerItemBlock("uranium_enricher", () -> {
            return new mctech.blocks.b().setDropProvider(IBlockDropProvider.SELF_OR_ADV_MACHINE);
        }, MCTechCreativeTabs.MACHINES);
        DUST_FACTORY = registerItemBlock("dust_factory", mctech.blocks.b::new, MCTechCreativeTabs.MACHINES);
        GREENHOUSE = registerItemBlock("greenhouse", mctech.blocks.c.m::new, MCTechCreativeTabs.MACHINES);
    }

    static void addStorage() {
        ENERGY_STORAGE_1 = registerItemBlock("energy_storage_1", () -> {
            return new mctech.blocks.f.c(IBlockDropProvider.SELF);
        }, MCTechCreativeTabs.ENERGY);
        ENERGY_STORAGE_2 = registerItemBlock("energy_storage_2", () -> {
            return new mctech.blocks.f.c(IBlockDropProvider.SELF_OR_MACHINE);
        }, MCTechCreativeTabs.ENERGY);
        ENERGY_STORAGE_3 = registerItemBlock("energy_storage_3", () -> {
            return new mctech.blocks.f.c(IBlockDropProvider.SELF_OR_ADV_MACHINE);
        }, MCTechCreativeTabs.ENERGY);
        ENERGY_STORAGE_4 = registerItemBlock("energy_storage_4", () -> {
            return new mctech.blocks.f.c(IBlockDropProvider.SELF_OR_ADV_MACHINE);
        }, MCTechCreativeTabs.ENERGY);
        ENERGY_STORAGE_5 = registerItemBlock("energy_storage_5", () -> {
            return new mctech.blocks.f.c(IBlockDropProvider.SELF_OR_ADV_MACHINE);
        }, MCTechCreativeTabs.ENERGY);
        ENERGY_STORAGE_6 = registerItemBlock("energy_storage_6", () -> {
            return new mctech.blocks.f.c(IBlockDropProvider.SELF_OR_ADV_MACHINE);
        }, MCTechCreativeTabs.ENERGY);
        ENERGY_STORAGE_7 = registerItemBlock("energy_storage_7", () -> {
            return new mctech.blocks.f.c(IBlockDropProvider.SELF_OR_ADV_MACHINE);
        }, MCTechCreativeTabs.ENERGY);
        ENERGY_STORAGE_8 = registerItemBlock("energy_storage_8", () -> {
            return new mctech.blocks.f.c(IBlockDropProvider.SELF_OR_ADV_MACHINE);
        }, MCTechCreativeTabs.ENERGY);
        ENERGY_STORAGE_9 = registerItemBlock("energy_storage_9", () -> {
            return new mctech.blocks.f.c(IBlockDropProvider.SELF_OR_ADV_MACHINE);
        }, MCTechCreativeTabs.ENERGY);
        ENERGY_STORAGE_10 = registerItemBlock("energy_storage_10", () -> {
            return new mctech.blocks.f.c(IBlockDropProvider.SELF_OR_ADV_MACHINE);
        }, MCTechCreativeTabs.ENERGY);
        TRANSFORMER_0 = registerItemBlock("transformer_0", () -> {
            return new mctech.blocks.f.d(IBlockDropProvider.SELF);
        }, MCTechCreativeTabs.ENERGY);
        TRANSFORMER_1 = registerItemBlock("transformer_1", () -> {
            return new mctech.blocks.f.d(IBlockDropProvider.SELF);
        }, MCTechCreativeTabs.ENERGY);
        TRANSFORMER_2 = registerItemBlock("transformer_2", () -> {
            return new mctech.blocks.f.d(IBlockDropProvider.SELF_OR_MACHINE);
        }, MCTechCreativeTabs.ENERGY);
        TRANSFORMER_3 = registerItemBlock("transformer_3", () -> {
            return new mctech.blocks.f.d(IBlockDropProvider.SELF_OR_MACHINE);
        }, MCTechCreativeTabs.ENERGY);
        TRANSFORMER_4 = registerItemBlock("transformer_4", () -> {
            return new mctech.blocks.f.d(IBlockDropProvider.SELF_OR_TRANSFORMER_2);
        }, MCTechCreativeTabs.ENERGY);
        TRANSFORMER_5 = registerItemBlock("transformer_5", () -> {
            return new mctech.blocks.f.d(IBlockDropProvider.SELF_OR_TRANSFORMER_3);
        }, MCTechCreativeTabs.ENERGY);
        TRANSFORMER_6 = registerItemBlock("transformer_6", () -> {
            return new mctech.blocks.f.d(IBlockDropProvider.SELF_OR_TRANSFORMER_5);
        }, MCTechCreativeTabs.ENERGY);
        TRANSFORMER_ADJUSTABLE_1 = registerItemBlock("transformer_adjustable_1", () -> {
            return new mctech.blocks.f.d(IBlockDropProvider.SELF_OR_TRANSFORMER_5);
        }, MCTechCreativeTabs.ENERGY);
        TRANSFORMER_7 = registerItemBlock("transformer_7", () -> {
            return new mctech.blocks.f.d(IBlockDropProvider.SELF_OR_TRANSFORMER_6);
        }, MCTechCreativeTabs.ENERGY);
        TRANSFORMER_8 = registerItemBlock("transformer_8", () -> {
            return new mctech.blocks.f.d(IBlockDropProvider.SELF_OR_TRANSFORMER_7);
        }, MCTechCreativeTabs.ENERGY);
        TRANSFORMER_9 = registerItemBlock("transformer_9", () -> {
            return new mctech.blocks.f.d(IBlockDropProvider.SELF_OR_TRANSFORMER_8);
        }, MCTechCreativeTabs.ENERGY);
        TRANSFORMER_ADJUSTABLE_2 = registerItemBlock("transformer_adjustable_2", () -> {
            return new mctech.blocks.f.d(IBlockDropProvider.SELF_OR_TRANSFORMER_8);
        }, MCTechCreativeTabs.ENERGY);
        CHARGING_BENCH_1 = registerItemBlock("charging_bench_1", mctech.blocks.f.b::new, MCTechCreativeTabs.ENERGY);
        CHARGING_BENCH_2 = registerItemBlock("charging_bench_2", mctech.blocks.f.b::new, MCTechCreativeTabs.ENERGY);
        CHARGING_BENCH_3 = registerItemBlock("charging_bench_3", mctech.blocks.f.b::new, MCTechCreativeTabs.ENERGY);
        CHARGING_BENCH_4 = registerItemBlock("charging_bench_4", mctech.blocks.f.b::new, MCTechCreativeTabs.ENERGY);
        CHARGING_BENCH_5 = registerItemBlock("charging_bench_5", mctech.blocks.f.b::new, MCTechCreativeTabs.ENERGY);
        CHARGING_BENCH_6 = registerItemBlock("charging_bench_6", mctech.blocks.f.b::new, MCTechCreativeTabs.ENERGY);
        CHARGING_BENCH_7 = registerItemBlock("charging_bench_7", mctech.blocks.f.b::new, MCTechCreativeTabs.ENERGY);
        CHARGING_BENCH_8 = registerItemBlock("charging_bench_8", mctech.blocks.f.b::new, MCTechCreativeTabs.ENERGY);
        CHARGING_BENCH_9 = registerItemBlock("charging_bench_9", mctech.blocks.f.b::new, MCTechCreativeTabs.ENERGY);
        CHARGING_BENCH_10 = registerItemBlock("charging_bench_10", mctech.blocks.f.b::new, MCTechCreativeTabs.ENERGY);
    }

    public static void registerChargePads(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerChargePad(machineTier);
        }
    }

    private static void registerChargePad(MachineTier machineTier) {
        String str = "chargepad_" + machineTier.asIntegerString();
        REGISTERED_CHARGE_PADS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, mctech.blocks.f.a::new, mctech.blocks.f.a.e).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            blockStateProvider.simpleBlock((Block) dataGenContext.get(), blockStateProvider.models().getBuilder(dataGenContext.getName()).parent(new ModelFile.UncheckedModelFile("builtin/entity")).texture("particle", blockStateProvider.modLoc(String.format("block/charge_plate/charge_plate_t%s_off", machineTier.asIntegerString()))).transforms().transform(ItemDisplayContext.GUI).rotation(30.0f, 225.0f, 0.0f).scale(0.625f, 0.625f, 0.625f).end().transform(ItemDisplayContext.GROUND).translation(0.0f, 3.0f, 0.0f).scale(0.25f, 0.25f, 0.25f).end().transform(ItemDisplayContext.FIXED).scale(0.5f, 0.5f, 0.5f).end().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75.0f, 45.0f, 0.0f).translation(0.0f, 2.5f, 0.0f).scale(0.375f, 0.375f, 0.375f).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(75.0f, 45.0f, 0.0f).translation(0.0f, 2.5f, 0.0f).scale(0.375f, 0.375f, 0.375f).end().transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0.0f, 45.0f, 0.0f).scale(0.4f, 0.4f, 0.4f).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0.0f, 45.0f, 0.0f).scale(0.4f, 0.4f, 0.4f).end().transform(ItemDisplayContext.HEAD).rotation(-180.0f, 88.5f, -180.0f).translation(0.0f, -44.0f, -0.25f).scale(1.0f, 1.0f, 1.0f).end().end());
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation(String.format("Charge pad T%s", machineTier.asIntegerString()), String.format("Зарядная плита T%s", machineTier.asIntegerString())).createBlockItem(ITEM_REGISTRY, (v0) -> {
            return v0.createItem();
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.ENERGY).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext2, str);
            });
        }));
    }

    public static void registerFluidGenerators(mctech.i.c cVar, MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerFluidGenerator(cVar, machineTier);
        }
    }

    public static void registerCobblestoneGenerators(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerCobblestoneGenerator(machineTier);
        }
    }

    public static void registerPlasmaGenerators(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerPlasmaGenerator(machineTier);
        }
    }

    public static void registerFormers(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerFormer(machineTier);
        }
    }

    public static void registerMassFabricators(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerMassFabricator(machineTier);
        }
    }

    public static void registerSingularityCollectors(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerSingularityCollector(machineTier);
        }
    }

    public static void registerCrystalSynths(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerCrystalSynth(machineTier);
        }
    }

    public static void registerMetalFormers(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerMetalFormer(machineTier);
        }
    }

    public static void registerRareExtractors(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerRareExtractor(machineTier);
        }
        REGISTERED_RARE_EXTRACTORS.put(MachineTier.T1, BLOCK_REGISTRY.registerBlock("stone_rare_extractor", properties -> {
            return new a(properties, MachineTier.T1).a(MCTechTiles.STONE_RARE_EXTRACTOR);
        }, DEFAULT_MACHINE).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            MCTechModels.createAllSidedActiveInactive(blockStateProvider, dataGenContext, "rare_extractor/t1");
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation("Rare extractor T1", "Редкоземельный экстрактор T1").createBlockItem(ITEM_REGISTRY, aVar -> {
            return new mctech.items.base.c(aVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext2, "active_stone_rare_extractor");
            });
        }));
    }

    public static void registerAlloySmelters(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerAlloySmelter(machineTier);
        }
        REGISTERED_ALLOY_SMELTERS.put(MachineTier.T1, BLOCK_REGISTRY.registerBlock("stone_alloy_smelter", properties -> {
            return new a(properties, MachineTier.T1).a(MCTechTiles.STONE_ALLOY_SMELTER);
        }, DEFAULT_MACHINE).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            ResourceLocation resourceLocationModLoc = blockStateProvider.modLoc("block/stone_alloy_smelter/side");
            ResourceLocation resourceLocationModLoc2 = blockStateProvider.modLoc("block/stone_alloy_smelter/down");
            ResourceLocation resourceLocationModLoc3 = blockStateProvider.modLoc("block/stone_alloy_smelter/up");
            blockStateProvider.getVariantBuilder((Block) dataGenContext.get()).forAllStatesExcept(blockState -> {
                String str = ((Boolean) blockState.getValue(MCTechProperties.ACTIVE)).booleanValue() ? "active" : "inactive";
                return ConfiguredModel.builder().modelFile(blockStateProvider.models().orientableWithBottom(String.format("%s_stone_alloy_smelter", str), resourceLocationModLoc, blockStateProvider.modLoc("block/stone_alloy_smelter/front_" + str), resourceLocationModLoc2, resourceLocationModLoc3)).rotationY((((int) blockState.getValue(MCTechProperties.ALL_FACINGS).toYRot()) - 180) % 360).build();
            }, new Property[]{MachineTier.PROPERTY});
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation("Alloy smelter T1", "Завод сплавов T1").createBlockItem(ITEM_REGISTRY, aVar -> {
            return new mctech.items.base.c(aVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext2, "active_stone_alloy_smelter");
            });
        }));
    }

    public static void registerElectronicPlants(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerElectronicPlant(machineTier);
        }
    }

    public static void registerCompressors(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerCompressor(machineTier);
        }
    }

    public static void registerFurnaces(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerFurnace(machineTier);
        }
    }

    public static void registerMacerators(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerMacerator(machineTier);
        }
    }

    public static void registerExtractors(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerExtractor(machineTier);
        }
    }

    public static void registerExtractor(MachineTier machineTier) {
        String str = String.format("%s_extractor", machineTier.name);
        REGISTERED_EXTRACTORS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new a(properties, machineTier).a(MCTechTiles.EXTRACTOR);
        }, DEFAULT_MACHINE).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            MCTechModels.createAllSidedActiveInactive(blockStateProvider, dataGenContext, String.format("extractor/%s", machineTier.getSerializedName()));
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation(String.format("Extractor T%s", machineTier.asIntegerString()), String.format("Экстрактор T%s", machineTier.asIntegerString())).createBlockItem(ITEM_REGISTRY, aVar -> {
            return new mctech.items.base.c(aVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext2, String.format("active_%s", str));
            });
        }));
    }

    public static void registerMacerator(MachineTier machineTier) {
        String str = String.format("%s_macerator", machineTier.name);
        REGISTERED_MACERATORS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new a(properties, machineTier).a(MCTechTiles.MACERATOR);
        }, DEFAULT_MACHINE).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            MCTechModels.createAllSidedActiveInactive(blockStateProvider, dataGenContext, String.format("macerator/%s", machineTier.getSerializedName()));
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation(String.format("Macerator T%s", machineTier.asIntegerString()), String.format("Дробитель T%s", machineTier.asIntegerString())).createBlockItem(ITEM_REGISTRY, aVar -> {
            return new mctech.items.base.c(aVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext2, String.format("active_%s", str));
            });
        }));
    }

    public static void registerFurnace(MachineTier machineTier) {
        String str = String.format("%s_furnace", machineTier.name);
        REGISTERED_FURNACES.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new a(properties, machineTier).a(MCTechTiles.FURNACE);
        }, DEFAULT_MACHINE).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            MCTechModels.createAllSidedActiveInactive(blockStateProvider, dataGenContext, String.format("furnace/%s", machineTier.getSerializedName()));
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation(String.format("Furnace T%s", machineTier.asIntegerString()), String.format("Электропечь T%s", machineTier.asIntegerString())).createBlockItem(ITEM_REGISTRY, aVar -> {
            return new mctech.items.base.c(aVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext2, String.format("active_%s", str));
            });
        }));
    }

    public static void registerCompressor(MachineTier machineTier) {
        String str = String.format("%s_compressor", machineTier.name);
        REGISTERED_COMPRESSORS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new a(properties, machineTier).a(MCTechTiles.COMPRESSOR);
        }, DEFAULT_MACHINE).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            MCTechModels.createAllSidedActiveInactive(blockStateProvider, dataGenContext, String.format("compressor/%s", machineTier.getSerializedName()));
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation(String.format("Compressor T%s", machineTier.asIntegerString()), String.format("Компрессор T%s", machineTier.asIntegerString())).createBlockItem(ITEM_REGISTRY, aVar -> {
            return new mctech.items.base.c(aVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext2, String.format("active_%s", str));
            });
        }));
    }

    public static void registerFluidTanks(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerFluidTank(machineTier);
        }
    }

    public static void registerNuclearChambers(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerNuclearChamber(machineTier);
        }
    }

    public static void registerNuclearReactors(MachineTier... machineTierArr) {
        for (MachineTier machineTier : machineTierArr) {
            registerNuclearReactor(machineTier);
        }
    }

    public static void registerCobblestoneGenerator(MachineTier machineTier) {
        String str = String.format("%s_cobblestone_generator", machineTier.name);
        REGISTERED_COBBLESTONE_GENERATORS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new C0085f(machineTier, properties);
        }, DEFAULT_MACHINE).setTranslation(String.format("Cobblestone generator T%s", machineTier.asIntegerString()), String.format("Генератор булыжника T%s", machineTier.asIntegerString())).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            GeckoData.block(blockStateProvider, dataGenContext, blockStateProvider.modLoc(String.format("block/%s/%s", dataGenContext.getName(), dataGenContext.getName())));
        }).addBlockTags(machineTier == MachineTier.T1 ? Set.of(BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE) : Set.of()).createBlockItem(ITEM_REGISTRY, c0085f -> {
            return new mctech.items.d(c0085f, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc(str)).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        }));
    }

    public static void registerPlasmaGenerator(MachineTier machineTier) {
        String str = String.format("%s_%s", machineTier.name, mctech.i.i.PLASMA_GENERATOR.getSerializedName());
        REGISTERED_PLASMA_GENERATORS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new A(machineTier, properties);
        }, DEFAULT_MACHINE).setTranslation(String.format("Plasma generator T%s", machineTier.asIntegerString()), String.format("Генератор плазмы T%s", machineTier.asIntegerString())).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            GeckoData.block(blockStateProvider, dataGenContext, blockStateProvider.modLoc(String.format("block/%s/%s", dataGenContext.getName(), dataGenContext.getName())));
        }).addBlockTags(machineTier == MachineTier.T1 ? Set.of(BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE) : Set.of()).createBlockItem(ITEM_REGISTRY, a -> {
            return new mctech.items.t(a, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc(str)).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        }));
    }

    public static void registerFormer(MachineTier machineTier) {
        String str = String.format("%s_former", machineTier.name);
        REGISTERED_FORMERS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new a(properties, machineTier).a(MCTechTiles.FORMING_MACHINE);
        }, DEFAULT_MACHINE).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation(String.format("Former T%s", machineTier.asIntegerString()), String.format("Формовочная машина T%s", machineTier.asIntegerString())).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            MCTechModels.createAllSidedActiveInactive(blockStateProvider, dataGenContext, String.format("former/%s", machineTier.getSerializedName()));
        }).createBlockItem(ITEM_REGISTRY, aVar -> {
            return new mctech.items.base.c(aVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext2, String.format("active_%s", str));
            });
        }));
    }

    public static void registerMassFabricator(MachineTier machineTier) {
        String str = String.format("%s_mass_fabricator", machineTier.name);
        REGISTERED_MASS_FABRICATORS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new a(properties, machineTier).a(MCTechTiles.MASS_FABRICATOR);
        }, DEFAULT_MACHINE).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            MCTechModels.createAllSidedActiveInactive(blockStateProvider, dataGenContext, String.format("mass_fabricator/%s", machineTier.getSerializedName()));
        }).setTranslation(String.format("Mass fabricator T%s", machineTier.asIntegerString()), String.format("Генератор материи T%s", machineTier.asIntegerString())).createBlockItem(ITEM_REGISTRY, aVar -> {
            return new mctech.items.base.c(aVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext2, String.format("active_%s", str));
            });
        }));
    }

    public static void registerSingularityCollector(MachineTier machineTier) {
        String str = String.format("%s_singularity_collector", machineTier.name);
        REGISTERED_SINGULARITY_COLLECTORS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new a(properties, machineTier).a(MCTechTiles.SINGULARITY_COLLECTOR);
        }, DEFAULT_MACHINE).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            MCTechModels.createAllSidedActiveInactive(blockStateProvider, dataGenContext, String.format("singularity_collector/%s", machineTier.getSerializedName()));
        }).addBlockTags(Set.of(BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)).setTranslation(String.format("Singularity collector T%s", machineTier.asIntegerString()), String.format("Сборщик Сингулярности T%s", machineTier.asIntegerString())).createBlockItem(ITEM_REGISTRY, aVar -> {
            return new mctech.items.base.c(aVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext2, String.format("active_%s", str));
            });
        }));
    }

    public static void registerCrystalSynth(MachineTier machineTier) {
        String str = String.format("%s_crystal_synth", machineTier.name);
        REGISTERED_CRYSTAL_SYNTH.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new a(properties, machineTier).a(MCTechTiles.CRYSTAL_SYNTH);
        }, DEFAULT_MACHINE).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            MCTechModels.createAllSidedActiveInactive(blockStateProvider, dataGenContext, String.format("crystal_synth/%s", machineTier.getSerializedName()));
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation(String.format("Crystal synth T%s", machineTier.asIntegerString()), String.format("Камера кристаллического синтеза T%s", machineTier.asIntegerString())).createBlockItem(ITEM_REGISTRY, aVar -> {
            return new mctech.items.base.c(aVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext2, String.format("active_%s", str));
            });
        }));
    }

    public static void registerMetalFormer(MachineTier machineTier) {
        String str = String.format("%s_metal_former", machineTier.name);
        REGISTERED_METAL_FORMERS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new a(properties, machineTier).a(MCTechTiles.METAL_FORMER);
        }, DEFAULT_MACHINE).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            MCTechModels.createAllSidedActiveInactive(blockStateProvider, dataGenContext, String.format("metal_former/%s", machineTier.getSerializedName()));
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation(String.format("Metal former T%s", machineTier.asIntegerString()), String.format("Металлоформовочный станок T%s", machineTier.asIntegerString())).createBlockItem(ITEM_REGISTRY, aVar -> {
            return new mctech.items.base.c(aVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext2, String.format("active_%s", str));
            });
        }));
    }

    public static void registerRareExtractor(MachineTier machineTier) {
        String str = String.format("%s_rare_extractor", machineTier.name);
        REGISTERED_RARE_EXTRACTORS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new a(properties, machineTier).a(MCTechTiles.RARE_EXTRACTOR);
        }, DEFAULT_MACHINE).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            MCTechModels.createAllSidedActiveInactive(blockStateProvider, dataGenContext, String.format("rare_extractor/%s", machineTier.getSerializedName()));
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation(String.format("Rare extractor T%s", machineTier.asIntegerString()), String.format("Редкоземельный экстрактор T%s", machineTier.asIntegerString())).createBlockItem(ITEM_REGISTRY, aVar -> {
            return new mctech.items.base.c(aVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext2, String.format("active_%s", str));
            });
        }));
    }

    public static void registerAlloySmelter(MachineTier machineTier) {
        String str = String.format("%s_alloy_smelter", machineTier.name);
        REGISTERED_ALLOY_SMELTERS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new a(properties, machineTier).a(MCTechTiles.ALLOY_SMELTER);
        }, DEFAULT_MACHINE).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            MCTechModels.createAllSidedActiveInactive(blockStateProvider, dataGenContext, String.format("machine/custom/alloy_smelter/%s", machineTier.getSerializedName()));
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation(String.format("Alloy smelter T%s", machineTier.asIntegerString()), String.format("Завод сплавов T%s", machineTier.asIntegerString())).createBlockItem(ITEM_REGISTRY, aVar -> {
            return new mctech.items.base.c(aVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext2, String.format("active_%s", str));
            });
        }));
    }

    public static void registerElectronicPlant(MachineTier machineTier) {
        String str = String.format("%s_electronic_plant", machineTier.name);
        REGISTERED_ELECTRONIC_PLANTS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new a(properties, machineTier).a(MCTechTiles.ELECTRONIC_PLANT);
        }, DEFAULT_MACHINE).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            MCTechModels.createAllSidedActiveInactive(blockStateProvider, dataGenContext, String.format("electronic_plant/%s", machineTier.getSerializedName()));
        }).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation(String.format("Electronic plant T%s", machineTier.asIntegerString()), String.format("Электронный завод T%s", machineTier.asIntegerString())).createBlockItem(ITEM_REGISTRY, aVar -> {
            return new mctech.items.base.c(aVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                MCTechModels.createBlockItem(lItemModelProvider, dataGenContext2, String.format("active_%s", str));
            });
        }));
    }

    public static void registerNuclearChamber(MachineTier machineTier) {
        String str = "nuclear_chamber_t" + machineTier.asIntegerString();
        REGISTERED_NUCLEAR_CHAMBERS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new f(properties, machineTier);
        }, DEFAULT_MACHINE).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation(String.format("Reactor chamber T%s", machineTier.asIntegerString()), String.format("Реакторная камера T%s", machineTier.asIntegerString())).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            ResourceLocation resourceLocationFromNamespaceAndPath = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/electric/generator/reactor_chamber/%s/side", "t" + machineTier.asIntegerString()));
            ResourceLocation resourceLocationFromNamespaceAndPath2 = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/electric/generator/reactor_chamber/%s/down", "t" + machineTier.asIntegerString()));
            ResourceLocation resourceLocationFromNamespaceAndPath3 = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/electric/generator/reactor_chamber/%s/up", "t" + machineTier.asIntegerString()));
            blockStateProvider.getVariantBuilder((Block) dataGenContext.get()).forAllStatesExcept(blockState -> {
                return ConfiguredModel.builder().modelFile(blockStateProvider.models().orientableWithBottom(BuiltInRegistries.BLOCK.getKey((Block) dataGenContext.get()).getPath(), resourceLocationFromNamespaceAndPath, resourceLocationFromNamespaceAndPath, resourceLocationFromNamespaceAndPath2, resourceLocationFromNamespaceAndPath3)).build();
            }, new Property[]{MachineTier.PROPERTY});
        }).createBlockItem(ITEM_REGISTRY, (v0) -> {
            return v0.createItem();
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.ENERGY).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc(str)).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        }));
    }

    public static void registerNuclearReactor(MachineTier machineTier) {
        String str = String.format("nuclear_reactor_t%s", machineTier.asIntegerString());
        REGISTERED_NUCLEAR_REACTORS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new e(properties, machineTier);
        }, DEFAULT_MACHINE).setLootTable((v0, v1) -> {
            MCTechLootModifiers.defaultLootTable(v0, v1);
        }).setTranslation(String.format("Nuclear reactor T%s", machineTier.asIntegerString()), String.format("Ядерный реактор T%s", machineTier.asIntegerString())).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            e eVar = (e) dataGenContext.get();
            String str2 = "electric/generator/nuclear_reactor/t" + machineTier.asIntegerString();
            ResourceLocation key = BuiltInRegistries.BLOCK.getKey(eVar);
            blockStateProvider.getVariantBuilder(eVar).forAllStatesExcept(blockState -> {
                String str3 = ((Boolean) blockState.getValue(MCTechProperties.ACTIVE)).booleanValue() ? "active" : "inactive";
                return ConfiguredModel.builder().modelFile(blockStateProvider.models().cube(String.format("%s_%s", str3, key.getPath()), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", str2, str3, Direction.DOWN.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", str2, str3, Direction.UP.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", str2, str3, Direction.NORTH.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", str2, str3, Direction.SOUTH.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", str2, str3, Direction.EAST.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", str2, str3, Direction.WEST.getName()))).texture("particle", ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", str2, str3, Direction.SOUTH.getName())))).rotationY(((int) blockState.getValue(MCTechProperties.ALL_FACINGS).toYRot()) % 360).build();
            }, new Property[]{MachineTier.PROPERTY});
        }).createBlockItem(ITEM_REGISTRY, lItem -> {
            lItem.setTab(MCTechCreativeTabs.ENERGY).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                ResourceLocation resourceLocationModLoc = lItemModelProvider.modLoc(str);
                lItemModelProvider.getBuilder(resourceLocationModLoc.toString()).parent(new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(resourceLocationModLoc.getNamespace(), "block/inactive_" + resourceLocationModLoc.getPath()))).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        }));
    }

    public static void registerFluidGenerator(mctech.i.c cVar, MachineTier machineTier) {
        String str = String.format("%s_%s_generator", machineTier.name, cVar.getSerializedName());
        LBlock<i> lBlockCreateBlockItem = BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new i(machineTier, cVar, properties);
        }, machineTier == MachineTier.T1 ? STONE_MACHINE : DEFAULT_MACHINE).setTranslation(String.format("%s generator %s", cVar.c(), machineTier.asIntegerString()), String.format("Генератор %s T%s", cVar.d(), machineTier.asIntegerString())).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            GeckoData.block(blockStateProvider, dataGenContext, blockStateProvider.modLoc(String.format("block/%s/%s", dataGenContext.getName(), dataGenContext.getName())));
        }).addBlockTags(machineTier == MachineTier.T1 ? Set.of(BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE) : Set.of()).createBlockItem(ITEM_REGISTRY, iVar -> {
            return new mctech.items.h(iVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc(str)).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        });
        if (cVar == mctech.i.c.WATER) {
            REGISTERED_WATER_GENERATORS.put(machineTier, lBlockCreateBlockItem);
        } else if (cVar == mctech.i.c.LAVA) {
            REGISTERED_LAVA_GENERATORS.put(machineTier, lBlockCreateBlockItem);
        }
    }

    public static void registerFluidTank(MachineTier machineTier) {
        String str = String.format("%s_%s", machineTier.name, mctech.i.i.FLUID_TANK.getSerializedName());
        REGISTERED_FLUID_TANKS.put(machineTier, BLOCK_REGISTRY.registerBlock(str, properties -> {
            return new j(machineTier, properties);
        }, DEFAULT_MACHINE).setTranslation(String.format("Fluid tank T%s", machineTier.asIntegerString()), String.format("Бак T%s", machineTier.asIntegerString())).setBlockStateProvider((blockStateProvider, dataGenContext) -> {
            GeckoData.block(blockStateProvider, dataGenContext, blockStateProvider.modLoc(String.format("block/%s/%s", dataGenContext.getName(), dataGenContext.getName())));
        }).addBlockTags(new TagKey[]{BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE}).createBlockItem(ITEM_REGISTRY, jVar -> {
            return new mctech.items.i(jVar, new Item.Properties());
        }, lItem -> {
            lItem.setTab(MCTechCreativeTabs.MACHINES).setModelProvider((lItemModelProvider, dataGenContext2) -> {
                lItemModelProvider.basicBlock(lItemModelProvider.modLoc(str)).transforms().transform(ItemDisplayContext.FIXED).rotation(0.0f, 0.0f, 0.0f).translation(0.0f, -4.0f, 0.0f).scale(0.5f, 0.5f, 0.5f).end().end();
            });
        }));
    }
}
