package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.g.d.e.h;
import mctech.init.MCTechLang;
import mctech.u.K;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiMolecularConverterRecipe.class */
public class EmiMolecularConverterRecipe implements EmiRecipe {
    private final ResourceLocation resourceLocation;
    private final EmiRecipeCategory recipeCategory;
    private final K recipe;

    public EmiMolecularConverterRecipe(EmiRecipeCategory emiRecipeCategory, K k) {
        this.resourceLocation = EmiPort.getId(k);
        this.recipeCategory = emiRecipeCategory;
        this.recipe = k;
    }

    public EmiRecipeCategory getCategory() {
        return this.recipeCategory;
    }

    @Nullable
    public ResourceLocation getId() {
        return this.resourceLocation;
    }

    public List<EmiIngredient> getInputs() {
        return List.of(EmiStack.of(this.recipe.a().b(), this.recipe.a().d()));
    }

    public List<EmiStack> getOutputs() {
        return List.of(EmiStack.of(this.recipe.b()));
    }

    public int getDisplayWidth() {
        return 82;
    }

    public int getDisplayHeight() {
        return 38;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addSlot((EmiIngredient) getInputs().getFirst(), 4, 9);
        widgetHolder.addSlot((EmiIngredient) getOutputs().getFirst(), 60, 9).recipeContext(this);
        widgetHolder.addFillingArrow(30, 9, 1600).tooltip(List.of(ClientTooltipComponent.create(h.a(MCTechLang.EMI_QUANTUM_WORKBENCH_ENERGY_CONSUME_TOOLTIP, formatRu((long) this.recipe.c(), false)).getVisualOrderText())));
    }

    public static void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }

    private static String formatRu(long j) {
        return formatRu(j, false);
    }

    private static String formatRu(long j, boolean z) {
        String strReplace;
        if (j < 1000) {
            return String.valueOf(j);
        }
        String[] strArr = {"", "т", "млн", "млрд", "трлн", "кврд", "квинт", "секст", "септ"};
        String[] strArr2 = {"", "тысяч", "миллионов", "миллиардов", "триллионов", "квадриллионов", "квинтиллионов", "секстиллионов", "септиллионов"};
        int i = 0;
        double d = j;
        while (d >= 1000.0d && i < strArr.length - 1) {
            d /= 1000.0d;
            i++;
        }
        if (i == 0) {
            strReplace = "";
        } else if (z) {
            int i2 = (int) (d % 10.0d);
            int i3 = (int) (d % 100.0d);
            if (i3 >= 11 && i3 <= 14) {
                strReplace = strArr2[i];
            } else if (i2 == 1) {
                strReplace = i == 1 ? "тысяча" : strArr2[i].replace("ов", "").replace("иллиард", "иллиард");
            } else if (i2 >= 2 && i2 <= 4) {
                strReplace = i == 1 ? "тысячи" : strArr2[i].replace("ов", "а");
            } else {
                strReplace = strArr2[i];
            }
        } else {
            strReplace = strArr[i];
        }
        return String.format("%.1f %s", Double.valueOf(d), strReplace).trim();
    }
}
