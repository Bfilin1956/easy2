package mctech.integration.emi.plugin.core.categories;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiRenderable;
import dev.emi.emi.api.stack.EmiStack;
import java.util.Comparator;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/categories/DefaultEmiCategory.class */
public class DefaultEmiCategory extends EmiRecipeCategory {
    public DefaultEmiCategory(ResourceLocation resourceLocation, EmiRenderable emiRenderable) {
        super(resourceLocation, emiRenderable);
    }

    public DefaultEmiCategory(ResourceLocation resourceLocation, EmiRenderable emiRenderable, Comparator<EmiRecipe> comparator) {
        super(resourceLocation, emiRenderable, EmiStack.EMPTY, comparator);
    }

    public void renderSimplified(GuiGraphics guiGraphics, int i, int i2, float f) {
        render(guiGraphics, i, i2, f);
    }
}
