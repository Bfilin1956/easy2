package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.integration.emi.plugin.core.EMIPlugin;
import mctech.integration.emi.plugin.core.categories.BonusItemRecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/BonusItemEmiRecipe.class */
public class BonusItemEmiRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiIngredient input;
    private final EmiStack output;
    private final EmiStack bonusOutput;
    private final BonusItemRecipe recipe;

    public BonusItemEmiRecipe(@NotNull BonusItemRecipe bonusItemRecipe) {
        this.id = bonusItemRecipe.id();
        this.input = EmiIngredient.of(bonusItemRecipe.input());
        this.output = EmiStack.of((ItemStack) bonusItemRecipe.outputs().getFirst());
        this.bonusOutput = EmiStack.of(bonusItemRecipe.outputBonus());
        this.recipe = bonusItemRecipe;
    }

    /* JADX INFO: renamed from: getCategory, reason: merged with bridge method [inline-methods] */
    public BonusItemRecipeCategory m478getCategory() {
        return EMIPlugin.BONUS_ITEM;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return List.of(this.input);
    }

    public List<EmiStack> getOutputs() {
        return List.of(this.output, this.bonusOutput);
    }

    public int getDisplayWidth() {
        return EMIPlugin.BONUS_ITEM.getBackground().width;
    }

    public int getDisplayHeight() {
        return EMIPlugin.BONUS_ITEM.getBackground().height;
    }

    public void addWidgets(@NotNull WidgetHolder widgetHolder) {
        widgetHolder.addTexture(EMIPlugin.BONUS_ITEM.getBackground(), 0, 0);
        EMIPlugin.BONUS_ITEM.addArrow(widgetHolder, this.recipe);
        widgetHolder.addSlot(this.input, 19, 28).drawBack(false);
        widgetHolder.addSlot(this.output, 80, 16).drawBack(false).recipeContext(this);
        widgetHolder.addSlot(this.bonusOutput, 80, 44).drawBack(false);
    }
}
