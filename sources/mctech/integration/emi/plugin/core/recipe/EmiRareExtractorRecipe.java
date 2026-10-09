package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.Arrays;
import java.util.List;
import mctech.u.T;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiRareExtractorRecipe.class */
public class EmiRareExtractorRecipe implements EmiRecipe {
    private final ResourceLocation resourceLocation;
    private final EmiRecipeCategory recipeCategory;
    private final T recipe;

    public EmiRareExtractorRecipe(EmiRecipeCategory emiRecipeCategory, T t) {
        this.resourceLocation = EmiPort.getId(t);
        this.recipeCategory = emiRecipeCategory;
        this.recipe = t;
    }

    public EmiRecipeCategory getCategory() {
        return this.recipeCategory;
    }

    @Nullable
    public ResourceLocation getId() {
        return this.resourceLocation;
    }

    public List<EmiIngredient> getInputs() {
        return Arrays.stream(this.recipe.a().c().getItems()).map(itemStack -> {
            return EmiStack.of(itemStack.copyWithCount(this.recipe.a().d()));
        }).map(emiStack -> {
            return emiStack;
        }).toList();
    }

    public List<EmiStack> getOutputs() {
        return List.of(EmiStack.of(this.recipe.b()));
    }

    public int getDisplayWidth() {
        return 120;
    }

    public int getDisplayHeight() {
        return 32;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addSlot((EmiIngredient) getInputs().getFirst(), 15, 8);
        widgetHolder.addFillingArrow(48, 8, 1600);
        widgetHolder.addSlot((EmiIngredient) getOutputs().getFirst(), 88, 8).recipeContext(this);
    }

    public static void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
