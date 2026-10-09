package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.stack.FluidEmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.integration.emi.plugin.core.EMIRecipeCategory;
import mctech.u.W;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiRefineryRecipe.class */
public class EmiRefineryRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiIngredient input;
    private final EmiIngredient fluid0;
    private final EmiIngredient fluid1;
    private final EmiStack outputItem0;
    private final EmiStack outputItem1;
    private final EmiStack outputItem2;
    private final EmiStack outputFluid;

    public EmiRefineryRecipe(W w) {
        this.id = EmiPort.getId(w);
        this.input = EmiIngredient.of((Ingredient) w.getIngredients().get(0));
        this.fluid0 = w.e().isEmpty() ? EmiStack.EMPTY : FluidEmiStack.of(w.e().getStacks()[0].getFluid(), w.f());
        this.fluid1 = w.h().isEmpty() ? EmiStack.EMPTY : FluidEmiStack.of(w.h().getStacks()[0].getFluid(), w.g());
        this.outputItem0 = EmiStack.of(w.i());
        this.outputItem1 = EmiStack.of(w.j());
        this.outputItem2 = EmiStack.of(w.k());
        this.outputFluid = FluidEmiStack.of(w.l().getFluid(), w.l().getAmount());
    }

    public EmiRecipeCategory getCategory() {
        return EMIRecipeCategory.REFINERY;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return List.of(this.input, this.fluid0, this.fluid1);
    }

    public List<EmiStack> getOutputs() {
        return List.of(this.outputItem0, this.outputItem1, this.outputItem2, this.outputFluid);
    }

    public int getDisplayWidth() {
        return 118;
    }

    public int getDisplayHeight() {
        return 66;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addFillingArrow(47, 25, 1600);
        widgetHolder.addSlot(this.input, 44, 6);
        if ((this.fluid0.getEmiStacks().getFirst() instanceof FluidEmiStack) && this.fluid0.getAmount() > 0) {
            widgetHolder.addSlot(this.fluid0, 3, 45);
        }
        if ((this.fluid1.getEmiStacks().getFirst() instanceof FluidEmiStack) && this.fluid1.getAmount() > 0) {
            widgetHolder.addSlot(this.fluid1, 23, 45);
        }
        if (this.outputFluid.getAmount() > 0) {
            widgetHolder.addSlot(this.outputFluid, 96, 45);
        }
        widgetHolder.addSlot(this.outputItem0, 75, 6);
        widgetHolder.addSlot(this.outputItem1, 75, 24);
        widgetHolder.addSlot(this.outputItem2, 75, 42);
    }
}
