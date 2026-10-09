package mctech.integration.emi.plugin.core;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.recipe.EmiRecipeSorting;
import dev.emi.emi.api.stack.EmiStack;
import it.unimi.dsi.fastutil.ints.IntList;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechItems;
import mctech.integration.emi.plugin.core.categories.DefaultEmiCategory;
import mctech.integration.emi.plugin.core.recipe.EmiElectrolyzerRecipe;
import mctech.r.a.b;
import mctech.r.a.c;
import mctech.r.a.d;
import net.mcskill.msregistry.core.MachineTier;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/EMIRecipeCategory.class */
public class EMIRecipeCategory {
    public static final EmiRecipeCategory ELECTROLYZER_CHARGE = new EmiRecipeCategory(EmiPort.id("mctech:electrolyzer_charge"), EmiStack.of(MCTechBlocks.ELECTROLYZER), EmiElectrolyzerRecipe::render, EmiRecipeSorting.compareOutputThenInput());
    public static final EmiRecipeCategory ELECTROLYZER_DISCHARGE = new EmiRecipeCategory(EmiPort.id("mctech:electrolyzer_discharge"), EmiStack.of(MCTechBlocks.CHARGED_ELECTROLYZER), EmiElectrolyzerRecipe::render, EmiRecipeSorting.compareOutputThenInput());
    public static final DefaultEmiCategory SAWMILL = new DefaultEmiCategory(EmiPort.id("mctech:sawmill"), EmiStack.of(MCTechBlocks.SAWMILL), EmiRecipeSorting.compareOutputThenInput());
    public static final DefaultEmiCategory RECYCLER = new DefaultEmiCategory(EmiPort.id("mctech:recycler"), EmiStack.of(MCTechBlocks.RECYCLER), EmiRecipeSorting.compareOutputThenInput());
    public static final DefaultEmiCategory ENRICHER_MATERIAL = new DefaultEmiCategory(EmiPort.id("mctech:enricher_material"), EmiStack.of(MCTechBlocks.URANIUM_ENRICHER), EmiRecipeSorting.compareOutputThenInput());
    public static final DefaultEmiCategory ENRICHER = new DefaultEmiCategory(EmiPort.id("mctech:enricher"), EmiStack.of(MCTechBlocks.URANIUM_ENRICHER), EmiRecipeSorting.compareOutputThenInput());
    public static final DefaultEmiCategory RARE_EARTH = new DefaultEmiCategory(EmiPort.id("mctech:rare_earth"), EmiStack.of(MCTechBlocks.RARE_EARTH_EXTRACTOR), EmiRecipeSorting.compareOutputThenInput());
    public static final DefaultEmiCategory SCRAP_BOX = new DefaultEmiCategory(EmiPort.id("mctech:scrap_box"), EmiStack.of(MCTechItems.SCRAPBOX), EmiRecipeSorting.compareOutputThenInput());
    public static final DefaultEmiCategory CANNER_FOOD = new DefaultEmiCategory(EmiPort.id("mctech:canner_food"), EmiStack.of(MCTechBlocks.CANNER), EmiRecipeSorting.compareOutputThenInput());
    public static final DefaultEmiCategory CANNER_FILL = new DefaultEmiCategory(EmiPort.id("mctech:canner_fill"), EmiStack.of(MCTechBlocks.CANNER), EmiRecipeSorting.compareOutputThenInput());
    public static final DefaultEmiCategory REFINERY = new DefaultEmiCategory(EmiPort.id("mctech:refinery"), EmiStack.of(MCTechBlocks.REFINERY), EmiRecipeSorting.compareOutputThenInput());
    public static final DefaultEmiCategory FLUID_FUEL = new DefaultEmiCategory(EmiPort.id("mctech:fluid_fuel"), EmiStack.of(MCTechBlocks.GEOTHERMAL_GENERATOR), EmiRecipeSorting.compareOutputThenInput());
    public static final DefaultEmiCategory NUCLEAR_ENRICHMENT = new DefaultEmiCategory(EmiPort.id("mctech:nuclear_enrichment"), EmiStack.of(MCTechBlocks.REGISTERED_NUCLEAR_REACTORS.get(MachineTier.T1)), EmiRecipeSorting.compareOutputThenInput());
    public static final DefaultEmiCategory ORE_MACERATOR = new DefaultEmiCategory(EmiPort.id("mctech:ore_macerator"), EmiStack.of(b.b(d.ORE_MACERATOR, c.NANO)), EmiRecipeSorting.compareOutputThenInput());

    private static int compareStacks(IntList intList, IntList intList2) {
        int iMin = Math.min(intList.size(), intList2.size());
        for (int i = 0; i < iMin; i++) {
            int iCompare = Integer.compare(intList.getInt(i), intList2.getInt(i));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(intList.size(), intList2.size());
    }
}
