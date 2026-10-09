package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import java.util.Locale;
import mctech.g.d.e.h;
import mctech.i.i;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.core.EMIPlugin;
import mctech.u.I;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiTransformationAssemblerRecipe.class */
public class EmiTransformationAssemblerRecipe implements EmiRecipe {
    private final ResourceLocation resourceLocation;
    private final EmiRecipeCategory recipeCategory;
    private final I recipe;

    public EmiTransformationAssemblerRecipe(EmiRecipeCategory emiRecipeCategory, I i) {
        ResourceLocation id = EmiPort.getId(i);
        this.resourceLocation = EMIPlugin.synthetic(i.TRANSFORMATION_ASSEMBLER.getSerializedName(), id.getNamespace() + "/" + id.getPath());
        this.recipeCategory = emiRecipeCategory;
        this.recipe = i;
    }

    public I getRecipe() {
        return this.recipe;
    }

    public EmiRecipeCategory getCategory() {
        return this.recipeCategory;
    }

    @Nullable
    public ResourceLocation getId() {
        return this.resourceLocation;
    }

    public List<EmiIngredient> getInputs() {
        if (this.recipe.c().a()) {
            return List.of();
        }
        return List.of(EmiStack.of(this.recipe.c().b(), this.recipe.a()));
    }

    public List<EmiStack> getOutputs() {
        return List.of(EmiStack.of(this.recipe.d()));
    }

    public int getDisplayWidth() {
        return 80;
    }

    public int getDisplayHeight() {
        return 26;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addSlot(EmiStack.of(this.recipe.c().b()), 4, 4);
        widgetHolder.addFillingArrow((getDisplayWidth() / 2) - 12, 4, 1600).tooltip(List.of(ClientTooltipComponent.create(h.a(Component.literal("Нужно: " + formatRu(this.recipe.c().d())), new Object[0]).getVisualOrderText()), ClientTooltipComponent.create(h.a(MCTechLang.EMI_MATRIX_CONVERTER_ENERGY_CONSUME_TOOLTIP, formatRu(this.recipe.b())).getVisualOrderText())));
        widgetHolder.addSlot((EmiIngredient) getOutputs().getFirst(), getDisplayWidth() - 22, 4).recipeContext(this);
    }

    private static String formatRu(long j) {
        if (j < 1000) {
            return String.valueOf(j);
        }
        String[] strArr = {"", "т", "млн", "млрд", "трлн", "кврд", "квинт", "секст", "септ"};
        int i = 0;
        double d = j;
        while (d >= 1000.0d && i < strArr.length - 1) {
            d /= 1000.0d;
            i++;
        }
        return i == 0 ? String.valueOf(j) : String.format(Locale.ROOT, "%.1f%s", Double.valueOf(d), strArr[i]);
    }
}
