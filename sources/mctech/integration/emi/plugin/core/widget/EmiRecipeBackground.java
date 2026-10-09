package mctech.integration.emi.plugin.core.widget;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.runtime.EmiDrawContext;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/widget/EmiRecipeBackground.class */
public interface EmiRecipeBackground {
    void renderRecipeBackground(EmiRecipe emiRecipe, EmiDrawContext emiDrawContext, int i, int i2);

    default void draw(ResourceLocation resourceLocation, EmiRecipe emiRecipe, EmiDrawContext emiDrawContext, int i, int i2) {
        emiDrawContext.push();
        emiDrawContext.matrices().translate(i + 4, i2 + 4, 0.0f);
        new TexturedBackground(resourceLocation, emiRecipe.getDisplayWidth(), emiRecipe.getDisplayHeight()).render(emiDrawContext.raw(), i, i2, 0.0f);
        emiDrawContext.pop();
    }
}
