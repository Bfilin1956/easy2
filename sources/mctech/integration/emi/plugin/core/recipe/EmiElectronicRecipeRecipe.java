package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.ArrayList;
import java.util.List;
import mctech.u.C0190r;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiElectronicRecipeRecipe.class */
public class EmiElectronicRecipeRecipe implements EmiRecipe {
    private final ResourceLocation resourceLocation;
    private final EmiRecipeCategory recipeCategory;
    private final C0190r recipe;

    public EmiElectronicRecipeRecipe(EmiRecipeCategory emiRecipeCategory, C0190r c0190r) {
        this.resourceLocation = EmiPort.getId(c0190r);
        this.recipeCategory = emiRecipeCategory;
        this.recipe = c0190r;
    }

    public EmiRecipeCategory getCategory() {
        return this.recipeCategory;
    }

    @Nullable
    public ResourceLocation getId() {
        return this.resourceLocation;
    }

    public List<EmiIngredient> getInputs() {
        ArrayList arrayList = new ArrayList();
        if (!this.recipe.b().a()) {
            arrayList.add(EmiIngredient.of(this.recipe.b().c()).setAmount(this.recipe.b().d()));
        }
        if (!this.recipe.c().a()) {
            arrayList.add(EmiIngredient.of(this.recipe.c().c()).setAmount(this.recipe.c().d()));
        }
        if (!this.recipe.d().a()) {
            arrayList.add(EmiIngredient.of(this.recipe.d().c()).setAmount(this.recipe.d().d()));
        }
        if (!this.recipe.e().isEmpty()) {
            arrayList.add(EmiStack.of(this.recipe.e()));
        }
        return arrayList;
    }

    public List<EmiStack> getOutputs() {
        return List.of(EmiStack.of(this.recipe.f()));
    }

    public int getDisplayWidth() {
        return Math.max(128, ((this.recipe.a().size() + (this.recipe.e().isEmpty() ? 0 : 1)) * 19) + 60);
    }

    public int getDisplayHeight() {
        return 30;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        List<EmiIngredient> inputs = getInputs();
        int size = this.recipe.a().size();
        boolean z = !this.recipe.e().isEmpty();
        for (int i = 0; i < size; i++) {
            widgetHolder.addSlot(inputs.get(i), 4 + (i * 19), 5);
        }
        if (z) {
            int i2 = 4 + (size * 19) + 10;
            widgetHolder.addSlot(inputs.get(size), i2, 5);
            widgetHolder.addFillingArrow(i2 + 22, 7, 1600);
            widgetHolder.addSlot((EmiIngredient) getOutputs().getFirst(), i2 + 45, 6).recipeContext(this);
            return;
        }
        int i3 = 4 + (size * 19) + 10;
        widgetHolder.addFillingArrow(i3, 7, 1600);
        widgetHolder.addSlot((EmiIngredient) getOutputs().getFirst(), i3 + 23, 6).recipeContext(this);
    }

    public static void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
