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
import mctech.u.C0197y;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.FluidStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiGlassFurnaceRecipe.class */
public class EmiGlassFurnaceRecipe implements EmiRecipe {
    private final EmiRecipeCategory recipeCategory;
    private final ResourceLocation id;
    private final EmiIngredient input0;
    private final EmiIngredient input1;
    private final EmiStack moltenGlass;
    private final EmiStack output;

    public EmiGlassFurnaceRecipe(EmiRecipeCategory emiRecipeCategory, C0197y c0197y) {
        this.recipeCategory = emiRecipeCategory;
        this.id = EmiPort.getId(c0197y);
        this.input0 = EmiIngredient.of((Ingredient) c0197y.getIngredients().get(0), c0197y.c());
        this.input1 = EmiIngredient.of((Ingredient) c0197y.getIngredients().get(1), c0197y.d());
        this.moltenGlass = NeoForgeEmiStack.of(new FluidStack(MCTechFluids.MELTED_GLASS.getSource(), c0197y.h()));
        this.output = EmiStack.of(EmiPort.getOutput(c0197y));
    }

    public EmiRecipeCategory getCategory() {
        return this.recipeCategory;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return List.of(this.input0, this.input1, this.moltenGlass);
    }

    public List<EmiStack> getOutputs() {
        return List.of(this.output);
    }

    public int getDisplayWidth() {
        return 120;
    }

    public int getDisplayHeight() {
        return 38;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addSlot(this.input0, 4, 9);
        widgetHolder.addSlot(this.input1, 24, 9);
        widgetHolder.addSlot(this.moltenGlass, 44, 9);
        widgetHolder.addSlot(this.output, 96, 9).recipeContext(this);
        widgetHolder.addFillingArrow(68, 10, 1600);
    }
}
