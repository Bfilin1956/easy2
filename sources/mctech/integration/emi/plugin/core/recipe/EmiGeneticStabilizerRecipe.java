package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.neoforge.NeoForgeEmiStack;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.init.MCTechFluids;
import mctech.init.MCTechItems;
import mctech.init.MCTechLang;
import mctech.u.C0196x;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.fluids.FluidStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiGeneticStabilizerRecipe.class */
public class EmiGeneticStabilizerRecipe implements EmiRecipe {
    private final EmiRecipeCategory recipeCategory;
    private final ResourceLocation id;
    private final EmiIngredient catalyst;
    private final EmiStack dnaSample = EmiStack.of(new ItemStack((ItemLike) MCTechItems.DNA_SAMPLE.get()));
    private final EmiStack xpCost;
    private final C0196x recipe;

    public EmiGeneticStabilizerRecipe(EmiRecipeCategory emiRecipeCategory, C0196x c0196x) {
        this.recipeCategory = emiRecipeCategory;
        this.id = EmiPort.getId(c0196x);
        this.recipe = c0196x;
        this.catalyst = EmiIngredient.of(c0196x.c());
        this.xpCost = NeoForgeEmiStack.of(new FluidStack(MCTechFluids.XP.getSource(), c0196x.d()));
    }

    public EmiRecipeCategory getCategory() {
        return this.recipeCategory;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return List.of(this.dnaSample, this.catalyst, this.xpCost);
    }

    public List<EmiStack> getOutputs() {
        return List.of(this.dnaSample);
    }

    public int getDisplayWidth() {
        return 170;
    }

    public int getDisplayHeight() {
        return 72;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addSlot(this.dnaSample, 4, 9);
        widgetHolder.addSlot(this.catalyst, 24, 9);
        widgetHolder.addSlot(this.xpCost, 44, 9);
        widgetHolder.addFillingArrow(68, 10, Math.max(1, this.recipe.j()) * 50);
        widgetHolder.addSlot(this.dnaSample, 100, 9).recipeContext(this);
        widgetHolder.addText(EmiPort.ordered(getTargetText()), 4, 34, -12566464, false);
        widgetHolder.addText(EmiPort.ordered(getSuccessText()), 4, 44, -12566464, false);
        widgetHolder.addText(EmiPort.ordered(getFailText()), 4, 54, -12566464, false);
        widgetHolder.addText(EmiPort.ordered(getCostText()), 4, 64, -12566464, false);
    }

    private Component getTargetText() {
        if (this.recipe.e() == C0196x.c.LUCK) {
            return Component.translatable("emi.mctech.genetic_stabilizer.improves_luck", new Object[]{formatDelta(this.recipe.h())});
        }
        return Component.translatable("emi.mctech.genetic_stabilizer.improves_bonus", new Object[]{formatDelta(this.recipe.h())});
    }

    private Component getSuccessText() {
        return Component.translatable("emi.mctech.genetic_stabilizer.success_chance", new Object[]{formatPercent(this.recipe.f())});
    }

    private Component getFailText() {
        if (!this.recipe.g() || this.recipe.i() <= 0.0f) {
            return MCTechLang.EMI_GENETIC_STABILIZER_FAIL_NO_CHANGE.get();
        }
        if (this.recipe.e() == C0196x.c.LUCK) {
            return Component.translatable("emi.mctech.genetic_stabilizer.fail_luck", new Object[]{formatDelta(this.recipe.i())});
        }
        return Component.translatable("emi.mctech.genetic_stabilizer.fail_bonus", new Object[]{formatDelta(this.recipe.i())});
    }

    private Component getCostText() {
        return Component.translatable("emi.mctech.genetic_stabilizer.cost", new Object[]{Integer.valueOf(this.recipe.d()), Integer.valueOf(this.recipe.k())});
    }

    private static String formatPercent(float f) {
        return String.format("%.0f", Float.valueOf(f * 100.0f));
    }

    private static String formatDelta(float f) {
        if (f == ((long) f)) {
            return String.format("%.0f", Float.valueOf(f));
        }
        return String.format("%.1f", Float.valueOf(f));
    }
}
