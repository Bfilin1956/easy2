package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.u.C0170b;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiAlloySmelterRecipe.class */
public class EmiAlloySmelterRecipe implements EmiRecipe {
    private final EmiRecipeCategory recipeCategory;
    private final ResourceLocation id;
    private final EmiIngredient input0;
    private final EmiIngredient input1;
    private final EmiStack output;

    public EmiAlloySmelterRecipe(EmiRecipeCategory emiRecipeCategory, C0170b c0170b) {
        this.recipeCategory = emiRecipeCategory;
        this.id = EmiPort.getId(c0170b);
        this.input0 = EmiIngredient.of((Ingredient) c0170b.getIngredients().get(0), c0170b.c());
        this.input1 = EmiIngredient.of((Ingredient) c0170b.getIngredients().get(1), c0170b.d());
        this.output = EmiStack.of(EmiPort.getOutput(c0170b));
    }

    public EmiRecipeCategory getCategory() {
        return this.recipeCategory;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return List.of(this.input0, this.input1);
    }

    public List<EmiStack> getOutputs() {
        return List.of(this.output);
    }

    public int getDisplayWidth() {
        return 100;
    }

    public int getDisplayHeight() {
        return 38;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addSlot(this.input0, 4, 9);
        widgetHolder.addSlot(this.input1, 24, 9);
        widgetHolder.addSlot(this.output, 76, 9).recipeContext(this);
        widgetHolder.addFillingArrow(50, 10, 1600);
    }

    public static void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
