package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.init.MCTechFluids;
import mctech.integration.emi.plugin.core.EMIPlugin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/GrindingMachineEmiRecipe.class */
public class GrindingMachineEmiRecipe implements EmiRecipe {
    private final GrindingMachineRecipe recipe;

    public GrindingMachineEmiRecipe(GrindingMachineRecipe grindingMachineRecipe) {
        this.recipe = grindingMachineRecipe;
    }

    public EmiRecipeCategory getCategory() {
        return EMIPlugin.GRINDING_MACHINE;
    }

    @Nullable
    public ResourceLocation getId() {
        return this.recipe.getId();
    }

    public List<EmiIngredient> getInputs() {
        return List.of(EmiIngredient.of(Ingredient.of(new ItemLike[]{MCTechFluids.CELL_ELECTROLYZED_WATER})));
    }

    public List<EmiIngredient> getCatalysts() {
        return List.of(EmiIngredient.of(Ingredient.of(new ItemLike[]{this.recipe.getBlade()})), EmiIngredient.of(Ingredient.of(new ItemLike[]{this.recipe.getWhetstone()})));
    }

    public List<EmiStack> getOutputs() {
        return List.of(EmiStack.of(this.recipe.getNextLevelBlade()));
    }

    public int getDisplayWidth() {
        return EMIPlugin.GRINDING_MACHINE.getBackground().width;
    }

    public int getDisplayHeight() {
        return EMIPlugin.GRINDING_MACHINE.getBackground().height;
    }

    public void addWidgets(@NotNull WidgetHolder widgetHolder) {
        widgetHolder.addTexture(EMIPlugin.GRINDING_MACHINE.getBackground(), 0, 0);
        EMIPlugin.GRINDING_MACHINE.addArrow(widgetHolder, this.recipe);
        widgetHolder.addSlot(EmiIngredient.of(Ingredient.of(new ItemLike[]{this.recipe.getBlade()})), 10, 28).drawBack(false).catalyst(true);
        widgetHolder.addSlot(EmiIngredient.of(Ingredient.of(new ItemLike[]{this.recipe.getWhetstone()})), 50, 28).drawBack(false).catalyst(true);
        widgetHolder.addSlot(EmiIngredient.of(Ingredient.of(new ItemLike[]{MCTechFluids.CELL_ELECTROLYZED_WATER})), 74, 28).drawBack(false);
        widgetHolder.addSlot(EmiStack.of(this.recipe.getNextLevelBlade()), 107, 28).drawBack(false).recipeContext(this);
    }
}
