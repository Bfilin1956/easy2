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
import mctech.u.aa;
import mctech.utils.math.a;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiEnricherRecipe.class */
public class EmiEnricherRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiIngredient input;
    private final int color;
    private final int amount;
    private final String material;
    private final EmiStack output;

    public EmiEnricherRecipe(aa aaVar, Iterable<C0191s> iterable) {
        this.id = EmiPort.getId(aaVar);
        this.input = EmiIngredient.of(aaVar.b());
        this.material = "tooltip.enricher.material." + aaVar.c().getNamespace() + "." + aaVar.c().getPath();
        this.color = getColor(aaVar, iterable);
        this.amount = aaVar.f();
        this.output = EmiStack.of(aaVar.d());
    }

    private static int getColor(aa aaVar, Iterable<C0191s> iterable) {
        for (C0191s c0191s : iterable) {
            if (aaVar.c().equals(c0191s.d())) {
                return a.f + c0191s.e();
            }
        }
        return -1;
    }

    public EmiRecipeCategory getCategory() {
        return EMIRecipeCategory.ENRICHER;
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
        widgetHolder.addSlot(this.output, 60, 9).recipeContext(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.translatable(this.material, new Object[]{Integer.valueOf(this.amount)}));
        widgetHolder.addTooltipText(arrayList, 23, 6, 6, 24);
        widgetHolder.addFillingArrow(30, 9, 1600);
    }
}
