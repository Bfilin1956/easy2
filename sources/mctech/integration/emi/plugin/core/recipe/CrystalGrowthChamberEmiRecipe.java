package mctech.integration.emi.plugin.core.recipe;

import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.integration.emi.plugin.core.categories.CrystalGrowthChamberCategory;
import mctech.u.C0186n;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/CrystalGrowthChamberEmiRecipe.class */
public class CrystalGrowthChamberEmiRecipe implements EmiRecipe {
    private final CrystalGrowthChamberCategory category;
    private final ResourceLocation id;
    private final EmiIngredient input;
    private final C0186n recipe;

    public CrystalGrowthChamberEmiRecipe(CrystalGrowthChamberCategory crystalGrowthChamberCategory, C0186n c0186n) {
        this.category = crystalGrowthChamberCategory;
        this.id = EmiPort.getId(c0186n);
        this.input = EmiIngredient.of(c0186n.a());
        this.recipe = c0186n;
    }

    /* JADX INFO: renamed from: getCategory, reason: merged with bridge method [inline-methods] */
    public CrystalGrowthChamberCategory m479getCategory() {
        return this.category;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return List.of();
    }

    public List<EmiStack> getOutputs() {
        return List.of(EmiStack.of(AEItems.CERTUS_QUARTZ_CRYSTAL.stack(this.recipe.c())));
    }

    public List<EmiIngredient> getCatalysts() {
        EmiStack emiStackOf = EmiStack.of(AEBlocks.GROWTH_ACCELERATOR.stack());
        return List.of(this.input, emiStackOf, emiStackOf, emiStackOf, emiStackOf);
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
        EmiStack emiStackOf = EmiStack.of(AEBlocks.GROWTH_ACCELERATOR.stack());
        widgetHolder.addSlot(this.input, 62, 25).drawBack(false).catalyst(true);
        widgetHolder.addSlot(emiStackOf, 36, 13).drawBack(false).catalyst(true);
        widgetHolder.addSlot(emiStackOf, 36, 37).drawBack(false).catalyst(true);
        widgetHolder.addSlot(emiStackOf, 88, 13).drawBack(false).catalyst(true);
        widgetHolder.addSlot(emiStackOf, 88, 37).drawBack(false).catalyst(true);
        widgetHolder.addSlot(EmiStack.of(AEItems.CERTUS_QUARTZ_CRYSTAL.stack(this.recipe.c())), 62, 58).drawBack(false).recipeContext(this);
    }
}
