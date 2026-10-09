package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.integration.emi.plugin.core.categories.IndustrialForgeRecipeCategory;
import mctech.u.B;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/IndustrialForgeEmiRecipe.class */
public class IndustrialForgeEmiRecipe implements EmiRecipe {
    private final IndustrialForgeRecipeCategory category;
    private final ResourceLocation id;
    private final List<EmiIngredient> inputs;
    private final EmiStack output;
    private final B recipe;

    public IndustrialForgeEmiRecipe(IndustrialForgeRecipeCategory industrialForgeRecipeCategory, B b) {
        this.category = industrialForgeRecipeCategory;
        this.id = EmiPort.getId(b);
        this.output = EmiStack.of(b.b());
        this.inputs = b.a().stream().map(bVar -> {
            return EmiIngredient.of(bVar.c()).setAmount(bVar.d());
        }).toList();
        this.recipe = b;
    }

    public B getRecipe() {
        return this.recipe;
    }

    /* JADX INFO: renamed from: getCategory, reason: merged with bridge method [inline-methods] */
    public IndustrialForgeRecipeCategory m487getCategory() {
        return this.category;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return this.inputs;
    }

    public List<EmiStack> getOutputs() {
        return List.of(this.output);
    }

    public int getDisplayWidth() {
        return this.category.getBackground().width;
    }

    public int getDisplayHeight() {
        return this.category.getBackground().height;
    }

    public void addWidgets(@NotNull WidgetHolder widgetHolder) {
        widgetHolder.addTexture(this.category.getBackground(), 0, 0);
        this.category.addArrow(widgetHolder, this.recipe);
        widgetHolder.addSlot((EmiIngredient) this.inputs.getFirst(), 9, 28).drawBack(false);
        for (int i = 0; i < 6; i++) {
            widgetHolder.addSlot(this.inputs.get(i + 1), (48 + ((i % 3) * 21)) - 1, (18 + ((i / 3) * 22)) - 1).drawBack(false);
        }
        widgetHolder.addSlot(this.output, 120, 28).drawBack(false).recipeContext(this);
    }
}
