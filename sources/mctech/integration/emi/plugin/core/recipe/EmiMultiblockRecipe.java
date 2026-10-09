package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.p.a.d;
import mctech.p.c.b;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiMultiblockRecipe.class */
public class EmiMultiblockRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiRecipeCategory category;
    private final b multiblockWidget;

    public EmiMultiblockRecipe(EmiRecipeCategory emiRecipeCategory, d dVar) {
        this.category = emiRecipeCategory;
        this.id = dVar.a().withSuffix("_synthetic");
        this.multiblockWidget = new b(10, 10, 100, 100, dVar);
    }

    public EmiRecipeCategory getCategory() {
        return this.category;
    }

    @Nullable
    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return List.of();
    }

    public List<EmiStack> getOutputs() {
        return List.of();
    }

    public int getDisplayWidth() {
        return 120;
    }

    public int getDisplayHeight() {
        return 120;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.add(this.multiblockWidget);
    }
}
