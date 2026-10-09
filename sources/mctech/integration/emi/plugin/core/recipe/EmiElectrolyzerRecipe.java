package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.u.C0189q;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiElectrolyzerRecipe.class */
public class EmiElectrolyzerRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiRecipeCategory category;
    private final EmiIngredient input;
    private final EmiStack output;
    private final C0189q recipe;

    public EmiElectrolyzerRecipe(C0189q c0189q, EmiRecipeCategory emiRecipeCategory) {
        this.id = EmiPort.getId(c0189q);
        this.category = emiRecipeCategory;
        this.input = EmiIngredient.of((Ingredient) c0189q.getIngredients().get(0));
        this.output = EmiStack.of(EmiPort.getOutput(c0189q));
        this.recipe = c0189q;
    }

    public EmiRecipeCategory getCategory() {
        return this.category;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return List.of(this.input);
    }

    public List<EmiStack> getOutputs() {
        return List.of(this.output);
    }

    public int getDisplayWidth() {
        return 82;
    }

    public int getDisplayHeight() {
        return 38;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        boolean zF = this.recipe.f();
        widgetHolder.addFillingArrow(30, 10, 1600);
        if (zF) {
            widgetHolder.addSlot(this.input, 4, 10);
            widgetHolder.addSlot(this.output, 60, 10).recipeContext(this);
        } else {
            widgetHolder.addSlot(this.output, 4, 10);
            widgetHolder.addSlot(this.input, 60, 10).recipeContext(this);
        }
        widgetHolder.addText(EmiPort.ordered(Component.literal(((int) this.recipe.c()) + " EU")), 21, 30, -1, true);
    }

    public static void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
