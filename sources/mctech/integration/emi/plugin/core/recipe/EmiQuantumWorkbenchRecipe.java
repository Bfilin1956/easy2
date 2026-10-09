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
import mctech.u.Q;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiQuantumWorkbenchRecipe.class */
public class EmiQuantumWorkbenchRecipe implements EmiRecipe {
    private final ResourceLocation resourceLocation;
    private final EmiRecipeCategory recipeCategory;
    private final Q recipe;

    public EmiQuantumWorkbenchRecipe(EmiRecipeCategory emiRecipeCategory, Q q) {
        this.resourceLocation = EmiPort.getId(q);
        this.recipeCategory = emiRecipeCategory;
        this.recipe = q;
    }

    public EmiRecipeCategory getCategory() {
        return this.recipeCategory;
    }

    @Nullable
    public ResourceLocation getId() {
        return this.resourceLocation;
    }

    public List<EmiIngredient> getInputs() {
        return this.recipe.a().stream().map(EmiStack::of).map(emiStack -> {
            return emiStack;
        }).toList();
    }

    public List<EmiStack> getOutputs() {
        return List.of(EmiStack.of(this.recipe.d()));
    }

    public Q getRecipe() {
        return this.recipe;
    }

    public int getDisplayWidth() {
        return 174;
    }

    public int getDisplayHeight() {
        return 128;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        for (int i = 0; i < 7; i++) {
            for (int i2 = 0; i2 < 7; i2++) {
                if (i2 < this.recipe.b().size()) {
                    String str = this.recipe.b().get(i2);
                    if (i < str.length()) {
                        char cCharAt = str.charAt(i);
                        EmiStack emiStackOf = EmiStack.EMPTY;
                        if (this.recipe.c().containsKey(Character.valueOf(cCharAt))) {
                            emiStackOf = EmiStack.of(this.recipe.c().get(Character.valueOf(cCharAt)).b(), this.recipe.c().get(Character.valueOf(cCharAt)).d());
                        } else if (cCharAt != ' ') {
                            emiStackOf = EmiStack.of(Items.BARRIER);
                        }
                        widgetHolder.addSlot(emiStackOf, 0 + (i * 18), 0 + (i2 * 18));
                    } else {
                        widgetHolder.addSlot(0 + (i * 18), 0 + (i2 * 18));
                    }
                } else {
                    widgetHolder.addSlot(0 + (i * 18), 0 + (i2 * 18));
                }
            }
        }
        widgetHolder.addFillingArrow(128, 54, 1600).tooltip(List.of(ClientTooltipComponent.create(h.a(MCTechLang.EMI_QUANTUM_WORKBENCH_TIME_CONSUME_TOOLTIP, Float.valueOf(this.recipe.f() / 20.0f)).getVisualOrderText()), ClientTooltipComponent.create(h.a(MCTechLang.EMI_QUANTUM_WORKBENCH_ENERGY_CONSUME_TOOLTIP, Integer.valueOf(this.recipe.e())).getVisualOrderText())));
        widgetHolder.addSlot((EmiIngredient) getOutputs().getFirst(), 156, 54).recipeContext(this);
    }

    public static void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
