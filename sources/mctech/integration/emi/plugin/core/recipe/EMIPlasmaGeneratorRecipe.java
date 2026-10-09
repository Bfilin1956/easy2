package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.neoforge.NeoForgeEmiStack;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.stack.FluidEmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import java.util.stream.Collectors;
import mctech.components.a.C0101n;
import mctech.integration.emi.plugin.core.widget.AnimatedTextureWidgetRotatable;
import mctech.u.O;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EMIPlasmaGeneratorRecipe.class */
public class EMIPlasmaGeneratorRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiRecipeCategory category;
    private final O recipe;

    public EMIPlasmaGeneratorRecipe(EmiRecipeCategory emiRecipeCategory, O o) {
        this.category = emiRecipeCategory;
        this.id = EmiPort.getId(o);
        this.recipe = o;
    }

    public EmiRecipeCategory getCategory() {
        return this.category;
    }

    @Nullable
    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return (List) this.recipe.d().stream().map(EmiStack::of).collect(Collectors.toUnmodifiableList());
    }

    public List<EmiStack> getOutputs() {
        return List.of(FluidEmiStack.of(this.recipe.e().getFluid(), this.recipe.e().getAmount()));
    }

    public int getDisplayWidth() {
        return 118;
    }

    public int getDisplayHeight() {
        return 32;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        int size = getInputs().size();
        int displayWidth = (getDisplayWidth() / 2) - ((((((((16 * size) + (4 * size)) + 4) + 17) + 4) + 16) + 4) / 2);
        int displayHeight = (getDisplayHeight() / 2) - (16 / 2);
        List<EmiIngredient> inputs = getInputs();
        int i = 0;
        for (int i2 = 0; i2 < inputs.size(); i2++) {
            i = 4 + displayWidth + (16 * i2) + (4 * i2);
            widgetHolder.addSlot(inputs.get(i2), i, displayHeight);
        }
        int i3 = i + 16 + 4;
        widgetHolder.add(new AnimatedTextureWidgetRotatable(C0101n.a.a(), i3 + 4, (getDisplayHeight() / 2) - 7, 14, 17, 0, 179, 1600, false, false, false).rotation(-90.0f));
        widgetHolder.addSlot(NeoForgeEmiStack.of(this.recipe.e()), i3 + 4 + 17, displayHeight).recipeContext(this);
    }

    public static void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
