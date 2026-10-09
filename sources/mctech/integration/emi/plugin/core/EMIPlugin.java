package mctech.integration.emi.plugin.core;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import dev.emi.emi.EmiPort;
import dev.emi.emi.api.EmiApi;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiInitRegistry;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.recipe.EmiWorldInteractionRecipe;
import dev.emi.emi.api.recipe.VanillaEmiRecipeCategories;
import dev.emi.emi.api.recipe.handler.EmiRecipeHandler;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.runtime.EmiReloadLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import mctech.MCTech;
import mctech.a.b.b.d;
import mctech.api.tiles.IRecipeMachine;
import mctech.blockentities.c.C0059f;
import mctech.blockentities.c.C0060g;
import mctech.blockentities.c.C0066m;
import mctech.blockentities.c.C0078y;
import mctech.blockentities.c.R;
import mctech.blockentities.c.S;
import mctech.blockentities.c.T;
import mctech.blockentities.c.W;
import mctech.blockentities.c.af;
import mctech.blocks.base.blocks.a;
import mctech.blocks.c.C0085f;
import mctech.blocks.c.i;
import mctech.g.a.e;
import mctech.i.c;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechFluids;
import mctech.init.MCTechItems;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import mctech.integration.emi.plugin.base.EmiMachine;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import mctech.integration.emi.plugin.base.RecipeHandlerRegistry;
import mctech.integration.emi.plugin.core.categories.BonusItemRecipeCategory;
import mctech.integration.emi.plugin.core.categories.CrystalGrowthChamberCategory;
import mctech.integration.emi.plugin.core.categories.DefaultEmiCategory;
import mctech.integration.emi.plugin.core.categories.GrindingMachineCategory;
import mctech.integration.emi.plugin.core.categories.IndustrialForgeRecipeCategory;
import mctech.integration.emi.plugin.core.recipe.BonusItemEmiRecipe;
import mctech.integration.emi.plugin.core.recipe.BonusItemRecipe;
import mctech.integration.emi.plugin.core.recipe.CrystalGrowthChamberEmiRecipe;
import mctech.integration.emi.plugin.core.recipe.EMIAssemblyStationRecipe;
import mctech.integration.emi.plugin.core.recipe.EMIAtomicSmelterRecipe;
import mctech.integration.emi.plugin.core.recipe.EMICobblestoneGeneratorRecipe;
import mctech.integration.emi.plugin.core.recipe.EMIFluidGeneratorRecipe;
import mctech.integration.emi.plugin.core.recipe.EMIPlasmaGeneratorRecipe;
import mctech.integration.emi.plugin.core.recipe.EMIQuantumGeneratorRecipe;
import mctech.integration.emi.plugin.core.recipe.EMISingularityCollectorRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiAlloySmelterRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiBaseMachineRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiCrystalSynthRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiCustomRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiDustRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiElectrolyzerRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiElectronicRecipeRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiEnricherMaterialRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiEnricherRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiFillMachineRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiFoodMachineRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiFormingRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiGeneticPrinterRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiGeneticSequencerRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiGeneticStabilizerRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiGlassFurnaceRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiMassFabricatorRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiMatrixConverterRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiMetalFormerRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiMolecularConverterRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiQuantumWorkbenchRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiRareExtractorRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiRecyclerRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiRefineryRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiScrapBoxRecipe;
import mctech.integration.emi.plugin.core.recipe.EmiTransformationAssemblerRecipe;
import mctech.integration.emi.plugin.core.recipe.GrindingMachineEmiRecipe;
import mctech.integration.emi.plugin.core.recipe.GrindingMachineRecipe;
import mctech.integration.emi.plugin.core.recipe.IndustrialForgeEmiRecipe;
import mctech.integration.emi.plugin.core.recipehandler.PatternAssemblyEncoderRecipeHandler;
import mctech.integration.emi.plugin.core.recipehandler.PatternForgeEncoderRecipeHandler;
import mctech.integration.emi.plugin.core.recipehandler.PatternQuantumWorkbenchRecipeHandler;
import mctech.integration.emi.plugin.core.recipehandler.PatternTransformationAssemblerEncoderRecipeHandler;
import mctech.items.e.l;
import mctech.m.b.C0128aa;
import mctech.m.b.C0129ab;
import mctech.m.b.C0130ac;
import mctech.m.b.C0131ad;
import mctech.r.a.b;
import mctech.u.AbstractC0180h;
import mctech.u.C0181i;
import mctech.u.C0182j;
import mctech.u.C0189q;
import mctech.u.C0191s;
import mctech.u.E;
import mctech.u.G;
import mctech.u.V;
import mctech.u.X;
import mctech.u.aa;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.common.Tags;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/EMIPlugin.class */
@EmiEntrypoint
public class EMIPlugin implements EmiPlugin {
    public static final ResourceLocation TEXTURE = MCTech.loc("textures/gui/emi/advanced_mechanism_emi.png");
    public static final GrindingMachineCategory GRINDING_MACHINE = new GrindingMachineCategory();
    private static final Map<String, List<EmiRecipeCategory>> LINKED_CATEGORY = new HashMap();
    public static final BonusItemRecipeCategory BONUS_ITEM = new BonusItemRecipeCategory();
    private static Map<RecipeType<?>, EmiRecipeCategory> recipeCache;

    public static ResourceLocation synthetic(String str, String str2) {
        return EmiPort.id(MCTech.MODID, "/" + str + "/" + str2);
    }

    public void initialize(EmiInitRegistry emiInitRegistry) {
        LINKED_CATEGORY.clear();
        super.initialize(emiInitRegistry);
    }

    public void register(EmiRegistry emiRegistry) {
        emiRegistry.setDefaultComparison(MCTechBlocks.CONDUIT.asItem(), EmiPort.compareStrict());
        emiRegistry.addIngredientSerializer(e.class, new e.a());
        emiRegistry.addGenericDragDropHandler(new EMIDropHandler());
        emiRegistry.addGenericDragDropHandler(new EMIConduitFilterDropHandler());
        emiRegistry.addGenericDragDropHandler(new d());
        RecipeManager recipeManager = emiRegistry.getRecipeManager();
        emiRegistry.addRecipe(EmiWorldInteractionRecipe.builder().id(ResourceLocation.parse("mctech:world/water_cell")).leftInput(EmiIngredient.of(Ingredient.of(new ItemLike[]{MCTechFluids.CELL_EMPTY}))).rightInput(EmiIngredient.of(Tags.Fluids.WATER), false).output(EmiStack.of(MCTechFluids.CELL_WATER)).build());
        emiRegistry.addRecipe(EmiWorldInteractionRecipe.builder().id(ResourceLocation.parse("mctech:world/lava_cell")).leftInput(EmiIngredient.of(Ingredient.of(new ItemLike[]{MCTechFluids.CELL_EMPTY}))).rightInput(EmiIngredient.of(Tags.Fluids.LAVA), false).output(EmiStack.of(MCTechFluids.CELL_LAVA)).build());
        EmiMachineRegistry.register(new EmiMachine("alloy_smelter", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.REGISTERED_ALLOY_SMELTERS.get(MachineTier.T5));
        }, EmiAlloySmelterRecipe::new, (RecipeType) MCTechRecipes.ALLOY_SMELTER.get(), MCTechBlocks.REGISTERED_ALLOY_SMELTERS.values()));
        EmiMachineRegistry.register(new EmiMachine("glass_furnace", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.GLASS_FURNACE);
        }, EmiGlassFurnaceRecipe::new, (RecipeType) MCTechRecipes.GLASS_FURNACE.get(), List.of(MCTechBlocks.GLASS_FURNACE)));
        EmiMachineRegistry.register(new EmiMachine("synthetic_printer", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.SYNTHETIC_PRINTER);
        }, (emiRecipeCategory, c0195w) -> {
            if (c0195w.a()) {
                return new EmiGeneticPrinterRecipe(emiRecipeCategory, c0195w);
            }
            return null;
        }, MCTechRecipes.type("genetic_printer"), List.of(MCTechBlocks.SYNTHETIC_PRINTER)));
        EmiMachineRegistry.register(new EmiMachine("genetic_stabilizer", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.GENETIC_STABILIZER);
        }, EmiGeneticStabilizerRecipe::new, MCTechRecipes.type("genetic_stabilizer"), List.of(MCTechBlocks.GENETIC_STABILIZER)));
        EmiMachineRegistry.register(new EmiMachine("genetic_sequentor", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.GENETIC_SEQUENTOR);
        }, (emiRecipeCategory2, c0195w2) -> {
            if (c0195w2.a()) {
                return new EmiGeneticSequencerRecipe(emiRecipeCategory2, c0195w2);
            }
            return null;
        }, MCTechRecipes.type("genetic_printer"), List.of(MCTechBlocks.GENETIC_SEQUENTOR)));
        EmiMachineRegistry.register(new EmiMachine("rare_extractor", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.REGISTERED_RARE_EXTRACTORS.get(MachineTier.T5));
        }, EmiRareExtractorRecipe::new, MCTechRecipes.type("rare_extractor"), MCTechBlocks.REGISTERED_RARE_EXTRACTORS.values()));
        EmiMachineRegistry.register(new EmiMachine("metal_former", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.REGISTERED_METAL_FORMERS.get(MachineTier.T5));
        }, EmiMetalFormerRecipe::new, MCTechRecipes.type("metal_former"), MCTechBlocks.REGISTERED_METAL_FORMERS.values()));
        EmiMachineRegistry.register(new EmiMachine("crystal_synth", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.REGISTERED_CRYSTAL_SYNTH.get(MachineTier.T5));
        }, EmiCrystalSynthRecipe::new, MCTechRecipes.type("crystal_synth"), MCTechBlocks.REGISTERED_CRYSTAL_SYNTH.values()));
        EmiMachineRegistry.register(new EmiMachine("mass_fabricator", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.REGISTERED_MASS_FABRICATORS.get(MachineTier.T5));
        }, EmiMassFabricatorRecipe::new, MCTechRecipes.type("mass_fabricator"), MCTechBlocks.REGISTERED_MASS_FABRICATORS.values()));
        EmiMachineRegistry.register(new EmiMachine("forming_machine", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.REGISTERED_FORMERS.get(MachineTier.T5));
        }, EmiFormingRecipe::new, MCTechRecipes.type("forming_machine"), MCTechBlocks.REGISTERED_FORMERS.values()));
        EmiMachineRegistry.register(new EmiMachine("atomic_smelter", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.ATOMIC_SMELTER);
        }, EMIAtomicSmelterRecipe::new, MCTechRecipes.type("atomic_smelter"), List.of(MCTechBlocks.ATOMIC_SMELTER)));
        EmiMachineRegistry.register(new EmiMachine("assembly_station", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.ASSEMBLY_STATION);
        }, EMIAssemblyStationRecipe::new, MCTechRecipes.type("assembly_station"), List.of(MCTechBlocks.ASSEMBLY_STATION)));
        EmiMachineRegistry.register(new EmiMachine("cobblestone_generator", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.REGISTERED_COBBLESTONE_GENERATORS.get(MachineTier.T4));
        }, (emiRecipeCategory3, lBlock) -> {
            return new EMICobblestoneGeneratorRecipe(emiRecipeCategory3, ((C0085f) lBlock.get()).a());
        }, MCTechBlocks.REGISTERED_COBBLESTONE_GENERATORS.values()));
        EmiMachineRegistry.register(new EmiMachine("water_generator", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.REGISTERED_WATER_GENERATORS.get(MachineTier.T4));
        }, (emiRecipeCategory4, lBlock2) -> {
            return new EMIFluidGeneratorRecipe(emiRecipeCategory4, c.WATER, ((i) lBlock2.get()).a());
        }, MCTechBlocks.REGISTERED_WATER_GENERATORS.values()));
        EmiMachineRegistry.register(new EmiMachine("lava_generator", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.REGISTERED_LAVA_GENERATORS.get(MachineTier.T4));
        }, (emiRecipeCategory5, lBlock3) -> {
            return new EMIFluidGeneratorRecipe(emiRecipeCategory5, c.LAVA, ((i) lBlock3.get()).a());
        }, MCTechBlocks.REGISTERED_LAVA_GENERATORS.values()));
        EmiMachineRegistry.register(new EmiMachine("singularity_collector", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.REGISTERED_SINGULARITY_COLLECTORS.get(MachineTier.T5));
        }, (emiRecipeCategory6, lBlock4) -> {
            return new EMISingularityCollectorRecipe(emiRecipeCategory6, ((a) lBlock4.get()).a());
        }, MCTechBlocks.REGISTERED_SINGULARITY_COLLECTORS.values()));
        EmiMachineRegistry.register(new EmiMachine("quantum_generator", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.QUANTUM_GENERATOR);
        }, (emiRecipeCategory7, lBlock5) -> {
            return new EMIQuantumGeneratorRecipe(emiRecipeCategory7);
        }, List.of(MCTechBlocks.QUANTUM_GENERATOR)));
        EmiMachineRegistry.register(new EmiMachine("plasma_generator", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.REGISTERED_PLASMA_GENERATORS.get(MachineTier.T6));
        }, EMIPlasmaGeneratorRecipe::new, MCTechRecipes.type("plasma_generator"), MCTechBlocks.REGISTERED_PLASMA_GENERATORS.values()));
        EmiMachineRegistry.register(new EmiMachine("ore_macerator", (Supplier<EmiStack>) () -> {
            return EmiStack.of(b.b(mctech.r.a.d.ORE_MACERATOR, mctech.r.a.c.NANO));
        }, (emiRecipeCategory8, n) -> {
            return new EmiCustomRecipe(n, emiRecipeCategory8);
        }, (RecipeType) E.a.get(), List.of(b.b(mctech.r.a.d.ORE_MACERATOR, mctech.r.a.c.NANO), b.b(mctech.r.a.d.ORE_MACERATOR, mctech.r.a.c.QUANT), b.b(mctech.r.a.d.ORE_MACERATOR, mctech.r.a.c.SINGULAR))));
        EmiMachineRegistry.register(new EmiMachine("ore_combine", (Supplier<EmiStack>) () -> {
            return EmiStack.of(b.b(mctech.r.a.d.ORE_COMBINE, mctech.r.a.c.NANO));
        }, (emiRecipeCategory9, m) -> {
            return new EmiCustomRecipe(m, emiRecipeCategory9);
        }, (RecipeType) E.k.get(), List.of(b.b(mctech.r.a.d.ORE_COMBINE, mctech.r.a.c.NANO), b.b(mctech.r.a.d.ORE_COMBINE, mctech.r.a.c.QUANT), b.b(mctech.r.a.d.ORE_COMBINE, mctech.r.a.c.SINGULAR))));
        EmiMachineRegistry.register(new EmiMachine("ingot_foundry", (Supplier<EmiStack>) () -> {
            return EmiStack.of(b.b(mctech.r.a.d.INGOT_FOUNDRY, mctech.r.a.c.NANO));
        }, (emiRecipeCategory10, c) -> {
            return new EmiCustomRecipe(c, emiRecipeCategory10);
        }, (RecipeType) E.i.get(), List.of(b.b(mctech.r.a.d.INGOT_FOUNDRY, mctech.r.a.c.NANO), b.b(mctech.r.a.d.INGOT_FOUNDRY, mctech.r.a.c.QUANT), b.b(mctech.r.a.d.INGOT_FOUNDRY, mctech.r.a.c.SINGULAR))));
        EmiMachineRegistry.register(new EmiMachine("chemical_purification", (Supplier<EmiStack>) () -> {
            return EmiStack.of(b.b(mctech.r.a.d.CHEMICAL_PURIFICATING, mctech.r.a.c.NANO));
        }, (emiRecipeCategory11, c0183k) -> {
            return new EmiCustomRecipe(c0183k, emiRecipeCategory11);
        }, (RecipeType) E.c.get(), List.of(b.b(mctech.r.a.d.CHEMICAL_PURIFICATING, mctech.r.a.c.NANO), b.b(mctech.r.a.d.CHEMICAL_PURIFICATING, mctech.r.a.c.QUANT), b.b(mctech.r.a.d.CHEMICAL_PURIFICATING, mctech.r.a.c.SINGULAR))));
        EmiMachineRegistry.register(new EmiMachine("concentrator", (Supplier<EmiStack>) () -> {
            return EmiStack.of(b.b(mctech.r.a.d.CONCENTRATOR, mctech.r.a.c.NANO));
        }, (emiRecipeCategory12, c0185m) -> {
            return new EmiCustomRecipe(c0185m, emiRecipeCategory12);
        }, (RecipeType) E.e.get(), List.of(b.b(mctech.r.a.d.CONCENTRATOR, mctech.r.a.c.NANO), b.b(mctech.r.a.d.CONCENTRATOR, mctech.r.a.c.QUANT), b.b(mctech.r.a.d.CONCENTRATOR, mctech.r.a.c.SINGULAR))));
        EmiMachineRegistry.register(new EmiMachine("hydraulic_washer", (Supplier<EmiStack>) () -> {
            return EmiStack.of(b.b(mctech.r.a.d.HYDRAULIC_WASHER, mctech.r.a.c.NANO));
        }, (emiRecipeCategory13, a) -> {
            return new EmiCustomRecipe(a, emiRecipeCategory13);
        }, (RecipeType) E.g.get(), List.of(b.b(mctech.r.a.d.HYDRAULIC_WASHER, mctech.r.a.c.NANO), b.b(mctech.r.a.d.HYDRAULIC_WASHER, mctech.r.a.c.QUANT), b.b(mctech.r.a.d.HYDRAULIC_WASHER, mctech.r.a.c.SINGULAR))));
        EmiMachineRegistry.register(new EmiMachine("dust_factory", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.DUST_FACTORY);
        }, EmiDustRecipe::new, (RecipeType) E.m.get(), List.of(MCTechBlocks.DUST_FACTORY)));
        EmiMachineRegistry.register(new EmiMachine("greenhouse", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.GREENHOUSE);
        }, (emiRecipeCategory14, c0198z) -> {
            return new EmiCustomRecipe(c0198z, emiRecipeCategory14);
        }, (RecipeType) E.o.get(), List.of(MCTechBlocks.GREENHOUSE)));
        EmiMachineRegistry.register(new EmiMachine("crystal_growth_chamber", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.CRYSTAL_GROWTH_CHAMBER);
        }, CrystalGrowthChamberEmiRecipe::new, (EmiMachine.SyntheticRecipeCreator) null, resourceLocation -> {
            return new CrystalGrowthChamberCategory();
        }, MCTechRecipes.type("crystal_growth_chamber"), List.of(MCTechBlocks.CRYSTAL_GROWTH_CHAMBER)));
        EmiMachineRegistry.register(new EmiMachine("industrial_forge", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.INDUSTRIAL_FORGE);
        }, IndustrialForgeEmiRecipe::new, (EmiMachine.SyntheticRecipeCreator) null, resourceLocation2 -> {
            return new IndustrialForgeRecipeCategory();
        }, MCTechRecipes.type("industrial_forge"), List.of(MCTechBlocks.INDUSTRIAL_FORGE)));
        EmiMachineRegistry.register("electrolyzer", new EmiMachine("electrolyzer_charge", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.ELECTROLYZER);
        }, (emiRecipeCategory15, c0189q) -> {
            if (c0189q.f()) {
                return new EmiElectrolyzerRecipe(c0189q, emiRecipeCategory15);
            }
            return null;
        }, (RecipeType) MCTechRecipes.ELECTROLYZER.get(), List.of(MCTechBlocks.ELECTROLYZER)));
        EmiMachineRegistry.register("charged_electrolyzer", new EmiMachine("electrolyzer_discharge", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.ELECTROLYZER);
        }, (emiRecipeCategory16, c0189q2) -> {
            if (c0189q2.f()) {
                return null;
            }
            return new EmiElectrolyzerRecipe(c0189q2, emiRecipeCategory16);
        }, (RecipeType) MCTechRecipes.ELECTROLYZER.get(), List.of(MCTechBlocks.ELECTROLYZER)));
        EmiMachineRegistry.register(new EmiMachine("electronic_plant", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.REGISTERED_ELECTRONIC_PLANTS.get(MachineTier.T5));
        }, EmiElectronicRecipeRecipe::new, MCTechRecipes.type("electronic_plant"), MCTechBlocks.REGISTERED_ELECTRONIC_PLANTS.values()));
        EmiMachineRegistry.register(new EmiMachine("compressor", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.REGISTERED_COMPRESSORS.get(MachineTier.T5));
        }, (defaultEmiCategory, c0184l) -> {
            return new EmiBaseMachineRecipe(c0184l, defaultEmiCategory);
        }, (EmiMachine.SyntheticRecipeCreator) null, resourceLocation3 -> {
            return new DefaultEmiCategory(MCTech.loc("compressor"), EmiStack.of(MCTechBlocks.REGISTERED_COMPRESSORS.get(MachineTier.T5)));
        }, (RecipeType) MCTechRecipes.COMPRESSOR.get(), MCTechBlocks.REGISTERED_COMPRESSORS.values()).addWorkstation(MCTechBlocks.STONE_COMPRESSOR));
        EmiMachineRegistry.register(new EmiMachine(VanillaEmiRecipeCategories.SMELTING, MCTechBlocks.REGISTERED_FURNACES.values()));
        EmiMachineRegistry.register(new EmiMachine("macerator", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.REGISTERED_MACERATORS.get(MachineTier.T5));
        }, (defaultEmiCategory2, g) -> {
            return new EmiBaseMachineRecipe(g, defaultEmiCategory2);
        }, (EmiMachine.SyntheticRecipeCreator) null, resourceLocation4 -> {
            return new DefaultEmiCategory(MCTech.loc("macerator"), EmiStack.of(MCTechBlocks.REGISTERED_MACERATORS.get(MachineTier.T5)));
        }, (RecipeType) MCTechRecipes.MACERATOR.get(), MCTechBlocks.REGISTERED_MACERATORS.values()).addWorkstation(MCTechBlocks.STONE_MACERATOR));
        EmiMachineRegistry.register(new EmiMachine("extractor", (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.REGISTERED_EXTRACTORS.get(MachineTier.T5));
        }, (defaultEmiCategory3, c0192t) -> {
            return new EmiBaseMachineRecipe(c0192t, defaultEmiCategory3);
        }, (EmiMachine.SyntheticRecipeCreator) null, resourceLocation5 -> {
            return new DefaultEmiCategory(MCTech.loc("extractor"), EmiStack.of(MCTechBlocks.REGISTERED_EXTRACTORS.get(MachineTier.T5)));
        }, (RecipeType) MCTechRecipes.EXTRACTOR.get(), MCTechBlocks.REGISTERED_EXTRACTORS.values()).addWorkstation(MCTechBlocks.STONE_EXTRACTOR));
        EmiMachineRegistry.register(new EmiMachine(mctech.i.i.QUANTUM_WORKBENCH.getSerializedName(), (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.QUANTUM_WORKBENCH);
        }, EmiQuantumWorkbenchRecipe::new, MCTechRecipes.type(mctech.i.i.QUANTUM_WORKBENCH.getSerializedName()), List.of(MCTechBlocks.QUANTUM_WORKBENCH)));
        EmiMachineRegistry.register(new EmiMachine(mctech.i.i.MOLECULAR_CONVERTER.getSerializedName(), (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.MOLECULAR_CONVERTER);
        }, EmiMolecularConverterRecipe::new, MCTechRecipes.type(mctech.i.i.MOLECULAR_CONVERTER.getSerializedName()), List.of(MCTechBlocks.MOLECULAR_CONVERTER)));
        EmiMachineRegistry.register(new EmiMachine(mctech.i.i.MATRIX_CONVERTER.getSerializedName(), (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.MATRIX_CONVERTER);
        }, EmiMatrixConverterRecipe::new, MCTechRecipes.type(mctech.i.i.MATRIX_CONVERTER.getSerializedName()), List.of(MCTechBlocks.MATRIX_CONVERTER)));
        EmiMachineRegistry.register(new EmiMachine(mctech.i.i.TRANSFORMATION_ASSEMBLER.getSerializedName(), (Supplier<EmiStack>) () -> {
            return EmiStack.of(MCTechBlocks.TRANSFORMATION_ASSEMBLER);
        }, EmiTransformationAssemblerRecipe::new, MCTechRecipes.type(mctech.i.i.MATRIX_CONVERTER.getSerializedName()), List.of(MCTechBlocks.TRANSFORMATION_ASSEMBLER)).addWorkstation(MCTechBlocks.PATTERN_TRANSFORMATION_ASSEMBLER_ENCODER));
        RecipeHandlerRegistry.register(C0129ab.class, (EmiRecipeHandler) new PatternForgeEncoderRecipeHandler());
        RecipeHandlerRegistry.register(C0128aa.class, (EmiRecipeHandler) new PatternAssemblyEncoderRecipeHandler());
        RecipeHandlerRegistry.register(C0130ac.class, (EmiRecipeHandler) new PatternQuantumWorkbenchRecipeHandler());
        RecipeHandlerRegistry.register(C0131ad.class, (EmiRecipeHandler) new PatternTransformationAssemblerEncoderRecipeHandler());
        EmiMachineRegistry.registerAll(emiRegistry, recipeManager);
        emiRegistry.addCategory(EMIRecipeCategory.SAWMILL);
        emiRegistry.addCategory(EMIRecipeCategory.ENRICHER_MATERIAL);
        emiRegistry.addCategory(EMIRecipeCategory.ENRICHER);
        emiRegistry.addCategory(EMIRecipeCategory.REFINERY);
        emiRegistry.addCategory(EMIRecipeCategory.CANNER_FOOD);
        emiRegistry.addCategory(EMIRecipeCategory.CANNER_FILL);
        emiRegistry.addCategory(EMIRecipeCategory.SCRAP_BOX);
        emiRegistry.addCategory(GRINDING_MACHINE);
        emiRegistry.addCategory(BONUS_ITEM);
        emiRegistry.addCategory(EMIRecipeCategory.RECYCLER);
        emiRegistry.addWorkstation(VanillaEmiRecipeCategories.SMELTING, EmiStack.of(MCTechBlocks.IRON_FURNACE));
        emiRegistry.addWorkstation(EMIRecipeCategory.ELECTROLYZER_CHARGE, EmiStack.of(MCTechBlocks.ELECTROLYZER));
        emiRegistry.addWorkstation(EMIRecipeCategory.ELECTROLYZER_DISCHARGE, EmiStack.of(MCTechBlocks.CHARGED_ELECTROLYZER));
        emiRegistry.addWorkstation(EMIRecipeCategory.SAWMILL, EmiStack.of(MCTechBlocks.SAWMILL));
        emiRegistry.addWorkstation(EMIRecipeCategory.ENRICHER_MATERIAL, EmiStack.of(MCTechBlocks.URANIUM_ENRICHER));
        emiRegistry.addWorkstation(EMIRecipeCategory.ENRICHER, EmiStack.of(MCTechBlocks.URANIUM_ENRICHER));
        emiRegistry.addWorkstation(EMIRecipeCategory.CANNER_FOOD, EmiStack.of(MCTechBlocks.STONE_CANNER));
        emiRegistry.addWorkstation(EMIRecipeCategory.CANNER_FILL, EmiStack.of(MCTechBlocks.STONE_CANNER));
        emiRegistry.addWorkstation(EMIRecipeCategory.CANNER_FILL, EmiStack.of(MCTechBlocks.CANNER));
        emiRegistry.addWorkstation(EMIRecipeCategory.CANNER_FOOD, EmiStack.of(MCTechBlocks.STONE_CANNER));
        emiRegistry.addWorkstation(EMIRecipeCategory.REFINERY, EmiStack.of(MCTechBlocks.REFINERY));
        emiRegistry.addWorkstation(EMIRecipeCategory.SCRAP_BOX, EmiStack.of(MCTechItems.SCRAPBOX));
        emiRegistry.addWorkstation(EMIRecipeCategory.REFINERY, EmiStack.of(MCTechBlocks.NANO_REFINERY));
        emiRegistry.addWorkstation(EMIRecipeCategory.REFINERY, EmiStack.of(MCTechBlocks.QUANTUM_REFINERY));
        emiRegistry.addWorkstation(EMIRecipeCategory.REFINERY, EmiStack.of(MCTechBlocks.SINGULAR_REFINERY));
        emiRegistry.addWorkstation(GRINDING_MACHINE, EmiStack.of(MCTechBlocks.GRINDING_MACHINE));
        emiRegistry.addWorkstation(EMIRecipeCategory.RECYCLER, EmiStack.of(MCTechBlocks.RECYCLER));
        emiRegistry.addWorkstation(EMIRecipeCategory.RECYCLER, EmiStack.of(MCTechBlocks.NANO_RECYCLER));
        emiRegistry.addWorkstation(EMIRecipeCategory.RECYCLER, EmiStack.of(MCTechBlocks.QUANTUM_RECYCLER));
        emiRegistry.addWorkstation(EMIRecipeCategory.RECYCLER, EmiStack.of(MCTechBlocks.SINGULAR_RECYCLER));
        register((BlockEntityType<?>) MCTechTiles.getBlockEntity(C0078y.class), VanillaEmiRecipeCategories.SMELTING);
        register((BlockEntityType<?>) MCTechTiles.getBlockEntity(C0066m.class), EMIRecipeCategory.ELECTROLYZER_CHARGE);
        register((BlockEntityType<?>) MCTechTiles.getBlockEntity(C0066m.class), EMIRecipeCategory.ELECTROLYZER_DISCHARGE);
        register((BlockEntityType<?>) MCTechTiles.getBlockEntity(C0060g.class), EMIRecipeCategory.ELECTROLYZER_DISCHARGE);
        register((BlockEntityType<?>) MCTechTiles.getBlockEntity(C0060g.class), EMIRecipeCategory.ELECTROLYZER_CHARGE);
        register((BlockEntityType<?>) MCTechTiles.getBlockEntity(T.class), EMIRecipeCategory.SAWMILL);
        register((BlockEntityType<?>) MCTechTiles.getBlockEntity(af.class), EMIRecipeCategory.ENRICHER);
        register((BlockEntityType<?>) MCTechTiles.getBlockEntity(af.class), EMIRecipeCategory.ENRICHER_MATERIAL);
        register((BlockEntityType<?>) MCTechTiles.getBlockEntity(W.class), EMIRecipeCategory.CANNER_FOOD);
        register((BlockEntityType<?>) MCTechTiles.getBlockEntity(C0059f.class), EMIRecipeCategory.CANNER_FILL);
        register((BlockEntityType<?>) MCTechTiles.getBlockEntity(S.class), EMIRecipeCategory.REFINERY);
        register((BlockEntityType<?>) MCTechTiles.getBlockEntity(R.class), EMIRecipeCategory.RECYCLER);
        for (C0189q c0189q3 : getRecipes(emiRegistry, (RecipeType) MCTechRecipes.ELECTROLYZER.get())) {
            if (c0189q3.f()) {
                addRecipe(emiRegistry, () -> {
                    return new EmiElectrolyzerRecipe(c0189q3, EMIRecipeCategory.ELECTROLYZER_CHARGE);
                }, c0189q3);
            } else {
                addRecipe(emiRegistry, () -> {
                    return new EmiElectrolyzerRecipe(c0189q3, EMIRecipeCategory.ELECTROLYZER_DISCHARGE);
                }, c0189q3);
            }
        }
        for (X x : getRecipes(emiRegistry, (RecipeType) MCTechRecipes.SAWMILL.get())) {
            addRecipe(emiRegistry, () -> {
                return new EmiBaseMachineRecipe(x, EMIRecipeCategory.SAWMILL);
            }, x);
        }
        for (C0191s c0191s : getRecipes(emiRegistry, (RecipeType) MCTechRecipes.ENRICHER_MATERIAL.get())) {
            addRecipe(emiRegistry, () -> {
                return new EmiEnricherMaterialRecipe(c0191s);
            }, c0191s);
        }
        for (aa aaVar : getRecipes(emiRegistry, (RecipeType) MCTechRecipes.URANIUM_ENRICHER.get())) {
            addRecipe(emiRegistry, () -> {
                return new EmiEnricherRecipe(aaVar, getRecipes(emiRegistry, (RecipeType) MCTechRecipes.ENRICHER_MATERIAL.get()));
            }, aaVar);
        }
        for (Item item : BuiltInRegistries.ITEM) {
            boolean z = false;
            ItemStack itemStack = new ItemStack(item);
            AbstractC0180h.a aVar = new AbstractC0180h.a(itemStack, true);
            for (RecipeHolder recipeHolder : emiRegistry.getRecipeManager().getAllRecipesFor((RecipeType) MCTechRecipes.CANNER_FOOD.get())) {
                if (((C0182j) recipeHolder.value()).matches(aVar, null)) {
                    addRecipe(emiRegistry, () -> {
                        return new EmiFoodMachineRecipe(itemStack, ((C0182j) recipeHolder.value()).l(), EMIRecipeCategory.CANNER_FOOD);
                    }, null);
                    addRecipe(emiRegistry, () -> {
                        return new EmiFoodMachineRecipe(itemStack, ((C0182j) recipeHolder.value()).l(), EMIRecipeCategory.CANNER_FILL);
                    }, null);
                    z = true;
                    break;
                }
            }
            if (!z) {
                int iMax = itemStack.has(DataComponents.FOOD) ? Math.max(1, Mth.ceil(((double) itemStack.getFoodProperties((LivingEntity) null).nutrition()) / 2.0d)) : item == Items.CAKE ? 6 : 0;
                if (iMax > 0) {
                    addRecipe(emiRegistry, () -> {
                        return new EmiFoodMachineRecipe(itemStack, new ItemStack((ItemLike) MCTechItems.TIN_CAN_FILLED.get(), iMax), EMIRecipeCategory.CANNER_FOOD);
                    }, null);
                    addRecipe(emiRegistry, () -> {
                        return new EmiFoodMachineRecipe(itemStack, new ItemStack((ItemLike) MCTechItems.TIN_CAN_FILLED.get(), iMax), EMIRecipeCategory.CANNER_FILL);
                    }, null);
                }
            }
        }
        for (mctech.u.W w : getRecipes(emiRegistry, (RecipeType) MCTechRecipes.REFINERY.get())) {
            addRecipe(emiRegistry, () -> {
                return new EmiRefineryRecipe(w);
            }, w);
        }
        for (C0181i c0181i : getRecipes(emiRegistry, (RecipeType) MCTechRecipes.CANNER_FILL.get())) {
            addRecipe(emiRegistry, () -> {
                return new EmiFillMachineRecipe(c0181i);
            }, c0181i);
        }
        IntStream.range(1, 13).mapToObj(mctech.items.e.d::a).filter((v0) -> {
            return Objects.nonNull(v0);
        }).flatMap(dVar -> {
            return l.b().stream().map(lVar -> {
                return new GrindingMachineRecipe(dVar, lVar);
            });
        }).forEach(grindingMachineRecipe -> {
            emiRegistry.addRecipe(new GrindingMachineEmiRecipe(grindingMachineRecipe));
        });
        Iterator<BonusItemRecipe> it = genAllBonusRecipes(recipeManager).iterator();
        while (it.hasNext()) {
            emiRegistry.addRecipe(new BonusItemEmiRecipe(it.next()));
        }
        ArrayList arrayList = new ArrayList();
        V v = null;
        for (V v2 : getRecipes(emiRegistry, (RecipeType) MCTechRecipes.RECYCLER.get())) {
            if (v2.l().getItem() != MCTechItems.SCRAP.get() || v2.l().getCount() > 1) {
                arrayList.add(v2.h());
                addRecipe(emiRegistry, () -> {
                    return new EmiRecyclerRecipe(v2, EMIRecipeCategory.RECYCLER);
                }, v2);
            } else {
                v = v2;
            }
        }
        if (v != null) {
            recyclerRecipe(emiRegistry, arrayList, v);
        }
        addRecipe(emiRegistry, () -> {
            return new EmiScrapBoxRecipe(getRecipes(emiRegistry, (RecipeType) MCTechRecipes.SCRAP_BOX.get()));
        }, v);
    }

    public static void register(String str, EmiRecipeCategory emiRecipeCategory) {
        LINKED_CATEGORY.computeIfAbsent(str, str2 -> {
            return new ArrayList();
        }).add(emiRecipeCategory);
    }

    public static void register(BlockEntityType<?> blockEntityType, EmiRecipeCategory emiRecipeCategory) {
        LINKED_CATEGORY.computeIfAbsent(BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(blockEntityType).toString(), str -> {
            return new ArrayList();
        }).add(emiRecipeCategory);
    }

    public static void register(BlockEntity blockEntity, EmiRecipeCategory emiRecipeCategory) {
        register((BlockEntityType<?>) blockEntity.getType(), emiRecipeCategory);
    }

    public static boolean openLinkedCategory(BlockEntity blockEntity, int i) {
        List<EmiRecipeCategory> categories = LINKED_CATEGORY.get(BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(blockEntity.getType()).toString());
        if (categories == null) {
            categories = getCategories(blockEntity);
        }
        if (i < 0 || categories == null || i >= categories.size()) {
            return false;
        }
        EmiApi.displayRecipeCategory(categories.get(i));
        return true;
    }

    private static List<EmiRecipeCategory> getCategories(BlockEntity blockEntity) {
        ResourceLocation key = BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(blockEntity.getType());
        if (key == null) {
            return Collections.emptyList();
        }
        String path = key.getPath();
        Optional<String> optionalFindFirst = LINKED_CATEGORY.keySet().stream().filter(str -> {
            return str.startsWith(path) || str.endsWith(path) || str.equalsIgnoreCase(path) || path.endsWith(str) || path.startsWith(str);
        }).findFirst();
        Map<String, List<EmiRecipeCategory>> map = LINKED_CATEGORY;
        Objects.requireNonNull(map);
        return (List) optionalFindFirst.map((v1) -> {
            return r1.get(v1);
        }).orElse(Collections.emptyList());
    }

    public static boolean hasLinkedCategory(BlockEntity blockEntity) {
        String path = BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(blockEntity.getType()).getPath();
        return LINKED_CATEGORY.keySet().stream().anyMatch(str -> {
            return str.startsWith(path) || str.endsWith(path) || str.equalsIgnoreCase(path) || path.endsWith(str) || path.startsWith(str);
        }) || LINKED_CATEGORY.get(BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(blockEntity.getType()).toString()) != null;
    }

    private static <C extends RecipeInput, T extends Recipe<C>> Iterable<T> getRecipes(EmiRegistry emiRegistry, RecipeType<T> recipeType) {
        Stream map = emiRegistry.getRecipeManager().getAllRecipesFor(recipeType).stream().map(recipeHolder -> {
            return recipeHolder.value();
        });
        Objects.requireNonNull(map);
        return map::iterator;
    }

    private static void recyclerRecipe(EmiRegistry emiRegistry, List<Ingredient> list, V v) {
        addRecipe(emiRegistry, () -> {
            return new EmiRecyclerRecipe(v, EMIRecipeCategory.RECYCLER, list);
        }, v);
    }

    private static void addRecipe(EmiRegistry emiRegistry, Supplier<EmiRecipe> supplier, Recipe<?> recipe) {
        try {
            emiRegistry.addRecipe(supplier.get());
        } catch (Throwable th) {
        }
    }

    private static List<BonusItemRecipe> genAllBonusRecipes(RecipeManager recipeManager) {
        return (List) recipeManager.getAllRecipesFor(MCTechRecipes.type("macerator_bonus_item")).stream().map((v0) -> {
            return v0.value();
        }).flatMap(f -> {
            ItemStack[] items = f.a().getItems();
            return items.length == 0 ? Stream.empty() : recipeManager.getAllRecipesFor((RecipeType) MCTechRecipes.MACERATOR.get()).stream().filter(recipeHolder -> {
                G g = (G) recipeHolder.value();
                for (ItemStack itemStack : items) {
                    if (g.h().test(itemStack)) {
                        return true;
                    }
                }
                return false;
            }).map(recipeHolder2 -> {
                return new BonusItemRecipe(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "/generated/" + recipeHolder2.id().getNamespace() + "/" + recipeHolder2.id().getPath()), ((G) recipeHolder2.value()).h(), ImmutableList.of(((G) recipeHolder2.value()).l().copy()), f.b(), f.c());
            });
        }).collect(Collectors.toList());
    }

    private static void addRecipeSafe(EmiRegistry emiRegistry, Supplier<EmiRecipe> supplier, Recipe<?> recipe) {
        try {
            emiRegistry.addRecipe(supplier.get());
        } catch (Throwable th) {
            EmiReloadLog.warn("Exception thrown when parsing vanilla recipe " + String.valueOf(EmiPort.getId(recipe)));
        }
    }

    private static <C extends RecipeInput, T extends Recipe<C>> Iterable<T> getRecipes(EmiRegistry emiRegistry, Supplier<RecipeType<T>> supplier) {
        Stream map = emiRegistry.getRecipeManager().getAllRecipesFor(supplier.get()).stream().map((v0) -> {
            return v0.value();
        });
        Objects.requireNonNull(map);
        return map::iterator;
    }

    public static <T> void showTypes(T t) {
        EmiRecipeCategory emiRecipeCategory;
        if (recipeCache == null) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            builder.put(RecipeType.SMELTING, VanillaEmiRecipeCategories.SMELTING);
            builder.put((RecipeType) MCTechRecipes.RECYCLER.get(), EMIRecipeCategory.RECYCLER);
            builder.put((RecipeType) MCTechRecipes.REFINERY.get(), EMIRecipeCategory.REFINERY);
            builder.put(RecipeType.BLASTING, VanillaEmiRecipeCategories.BLASTING);
            builder.put(RecipeType.SMOKING, VanillaEmiRecipeCategories.SMOKING);
            recipeCache = builder.build();
        }
        if ((t instanceof IRecipeMachine) && (emiRecipeCategory = recipeCache.get(((IRecipeMachine) t).getRecipeType())) != null) {
            EmiApi.displayRecipeCategory(emiRecipeCategory);
        }
    }
}
