package mctech.integration.emi.plugin.core.recipehandler;

import dev.emi.emi.api.recipe.EmiPlayerInventory;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.handler.EmiCraftContext;
import dev.emi.emi.api.recipe.handler.EmiRecipeHandler;
import mctech.components.ContainerComponent;
import mctech.m.a.d;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipehandler/ContainerRecipeHandler.class */
public class ContainerRecipeHandler<Holder extends d, Container extends ContainerComponent<Holder>> implements EmiRecipeHandler<Container> {
    public EmiPlayerInventory getInventory(AbstractContainerScreen<Container> abstractContainerScreen) {
        return null;
    }

    public boolean supportsRecipe(EmiRecipe emiRecipe) {
        return false;
    }

    public boolean canCraft(EmiRecipe emiRecipe, EmiCraftContext<Container> emiCraftContext) {
        return false;
    }

    public boolean craft(EmiRecipe emiRecipe, EmiCraftContext<Container> emiCraftContext) {
        return false;
    }
}
