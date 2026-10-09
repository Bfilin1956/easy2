package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.integration.emi.plugin.core.EMIRecipeCategory;
import mctech.u.C0181i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiFillMachineRecipe.class */
public class EmiFillMachineRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiIngredient input0;
    private final EmiIngredient input1;
    private final EmiStack output;

    public EmiFillMachineRecipe(C0181i c0181i) {
        this.id = EmiPort.getId(c0181i);
        this.input0 = EmiIngredient.of((Ingredient) c0181i.getIngredients().get(0), c0181i.c());
        this.input1 = EmiIngredient.of((Ingredient) c0181i.getIngredients().get(1));
        this.output = EmiStack.of(EmiPort.getOutput(c0181i));
    }

    public EmiRecipeCategory getCategory() {
        return EMIRecipeCategory.CANNER_FILL;
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
        widgetHolder.addFillingArrow(47, 10, 1600);
    }
}
