package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mctech.integration.emi.plugin.core.EMIRecipeCategory;
import mctech.u.C0191s;
import mctech.utils.math.a;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiEnricherMaterialRecipe.class */
public class EmiEnricherMaterialRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiIngredient input;
    private final int color;
    private final int amount;
    private final String material;

    public EmiEnricherMaterialRecipe(C0191s c0191s) {
        this.id = EmiPort.getId(c0191s);
        this.input = EmiIngredient.of(c0191s.b());
        this.material = "tooltip.enricher.material." + c0191s.d().getNamespace() + "." + c0191s.d().getPath();
        this.color = a.f + c0191s.e();
        this.amount = c0191s.c();
    }

    public EmiRecipeCategory getCategory() {
        return EMIRecipeCategory.ENRICHER_MATERIAL;
    }

    public ResourceLocation getId() {
        return this.id;
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
        return 38;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addSlot(this.input, 4, 9);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.translatable(this.material, new Object[]{Integer.valueOf(this.amount)}));
        widgetHolder.addTooltipText(arrayList, 62, 6, 6, 24);
        widgetHolder.addFillingArrow(30, 9, 1600);
    }
}
