package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.u.N;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EMIOreMaceratorRecipe.class */
public class EMIOreMaceratorRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiRecipeCategory category;
    private final N recipe;

    public EMIOreMaceratorRecipe(EmiRecipeCategory emiRecipeCategory, N n) {
        this.category = emiRecipeCategory;
        this.id = EmiPort.getId(n);
        this.recipe = n;
    }

    public EmiRecipeCategory getCategory() {
        return this.category;
    }

    @Nullable
    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiStack> getOutputs() {
        return List.of(EmiStack.of(this.recipe.b()), EmiStack.of(this.recipe.c()));
    }

    public int getDisplayWidth() {
        return 82;
    }

    public int getDisplayHeight() {
        return 62;
    }

    public List<EmiIngredient> getInputs() {
        return List.of(EmiIngredient.of((Ingredient) this.recipe.getIngredients().getFirst(), this.recipe.a()));
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addSlot((EmiIngredient) getInputs().getFirst(), 4, 12);
        widgetHolder.addSlot((EmiIngredient) getOutputs().getFirst(), 60, 2).recipeContext(this);
        widgetHolder.addSlot((EmiIngredient) getOutputs().getLast(), 60, 22).recipeContext(this);
        widgetHolder.addFillingArrow(29, 13, 1600);
    }

    public static void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
