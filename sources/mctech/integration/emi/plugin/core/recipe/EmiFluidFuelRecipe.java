package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.stack.FluidEmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.Collections;
import java.util.List;
import mctech.integration.emi.plugin.core.EMIRecipeCategory;
import mctech.u.C0193u;
import mctech.utils.math.a;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiFluidFuelRecipe.class */
public class EmiFluidFuelRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiIngredient input;
    private final int energy;
    private final int time;

    public EmiFluidFuelRecipe(C0193u c0193u) {
        this.id = EmiPort.getId(c0193u);
        this.input = FluidEmiStack.of(c0193u.a().getStacks()[0].getFluid(), 1000L);
        this.energy = c0193u.b();
        this.time = c0193u.c();
    }

    public EmiRecipeCategory getCategory() {
        return EMIRecipeCategory.FLUID_FUEL;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public int getEnergy() {
        return this.energy;
    }

    public int getTime() {
        return this.time;
    }

    public List<EmiIngredient> getInputs() {
        return List.of(this.input);
    }

    public List<EmiStack> getOutputs() {
        return Collections.emptyList();
    }

    public int getDisplayWidth() {
        return 82;
    }

    public int getDisplayHeight() {
        return 44;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addSlot(this.input, 4, 13).recipeContext(this);
        widgetHolder.addText(EmiPort.ordered(Component.literal("Горение")), 25, 2, a.f, false);
        widgetHolder.addText(EmiPort.ordered(Component.literal(String.valueOf(this.time / 20.0f).replace(".0", "") + " сек.")), 25, 12, a.f, false);
        widgetHolder.addText(EmiPort.ordered(Component.literal("Выработка")), 25, 24, a.f, false);
        widgetHolder.addText(EmiPort.ordered(Component.literal(String.valueOf(this.energy) + " EU")), 25, 34, a.f, false);
    }
}
