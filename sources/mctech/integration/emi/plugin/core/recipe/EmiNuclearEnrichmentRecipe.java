package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.stack.FluidEmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.MCTech;
import mctech.components.a.C0101n;
import mctech.integration.emi.plugin.core.EMIRecipeCategory;
import mctech.integration.emi.plugin.core.widget.TexturedBackground;
import mctech.u.L;
import mctech.utils.c.h;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiNuclearEnrichmentRecipe.class */
public class EmiNuclearEnrichmentRecipe implements EmiRecipe {
    private static final ResourceLocation BACKGROUND = MCTech.loc("textures/gui/emi/nuclear_enrichment.png");
    private final ResourceLocation id;
    private final EmiIngredient input;
    private final EmiIngredient result;
    private final int energy;

    public EmiNuclearEnrichmentRecipe(L l) {
        this.id = EmiPort.getId(l);
        this.input = FluidEmiStack.of(l.a().getFluid(), l.a().getAmount());
        this.result = FluidEmiStack.of(l.c().getFluid(), l.c().getAmount());
        this.energy = l.b();
    }

    public EmiRecipeCategory getCategory() {
        return EMIRecipeCategory.NUCLEAR_ENRICHMENT;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public int getEnergy() {
        return this.energy;
    }

    public EmiIngredient getResult() {
        return this.result;
    }

    public List<EmiIngredient> getInputs() {
        return List.of(this.input);
    }

    public List<EmiStack> getOutputs() {
        return this.result.getEmiStacks();
    }

    public int getDisplayWidth() {
        return 137;
    }

    public int getDisplayHeight() {
        return 84;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        new TexturedBackground(BACKGROUND, getDisplayWidth(), getDisplayHeight()).apply(widgetHolder);
        widgetHolder.addTank(this.input, 25, 11, 18, 60, 8000).drawBack(false);
        widgetHolder.addTexture(C0101n.a.a(), 25, 11, 18, 60, 90, 196, 18, 60, h.i, h.i);
        widgetHolder.addTank(this.result, 94, 11, 18, 60, 8000).drawBack(false);
        widgetHolder.addTexture(C0101n.a.a(), 94, 11, 18, 60, 90, 196, 18, 60, h.i, h.i);
        widgetHolder.addText(EmiPort.ordered(Component.literal(String.valueOf(this.energy))), 53, 50, -1, false);
        widgetHolder.addText(EmiPort.ordered(Component.literal("EU")), 63, 64, -1, false);
        widgetHolder.addAnimatedTexture(BACKGROUND, 44, 9, 48, 56, 0, 113, 2400, true, false, false);
    }
}
