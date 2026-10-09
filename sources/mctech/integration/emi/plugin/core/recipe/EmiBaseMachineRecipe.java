package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.u.AbstractC0180h;
import mctech.u.C0184l;
import mctech.u.G;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiBaseMachineRecipe.class */
public class EmiBaseMachineRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiRecipeCategory category;
    private final EmiIngredient input;
    private final EmiStack output;
    private final AbstractC0180h recipe;

    public EmiBaseMachineRecipe(AbstractC0180h abstractC0180h, EmiRecipeCategory emiRecipeCategory) {
        this.id = EmiPort.getId(abstractC0180h);
        this.category = emiRecipeCategory;
        if (abstractC0180h instanceof C0184l) {
            this.input = EmiIngredient.of((Ingredient) abstractC0180h.getIngredients().getFirst(), ((C0184l) abstractC0180h).a());
        } else {
            this.input = EmiIngredient.of((Ingredient) abstractC0180h.getIngredients().getFirst());
        }
        this.output = EmiStack.of(EmiPort.getOutput(abstractC0180h));
        this.recipe = abstractC0180h;
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
        widgetHolder.addSlot(this.input, 4, 9);
        widgetHolder.addSlot(this.output, 60, 9).recipeContext(this);
        widgetHolder.addFillingArrow(30, 9, 1600);
        if (this.recipe instanceof G) {
            widgetHolder.addText(EmiPort.ordered(Component.literal("Каменный")), 16, 29, -11184811, false);
        }
    }

    public static void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
