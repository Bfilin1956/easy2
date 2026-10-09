package mctech.mixin.client.emi;

import dev.emi.emi.api.EmiApi;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.handler.EmiRecipeHandler;
import dev.emi.emi.registry.EmiRecipeFiller;
import java.util.ArrayList;
import java.util.List;
import mctech.components.ContainerComponent;
import mctech.integration.emi.plugin.base.RecipeHandlerRegistry;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/emi/RecipeFillerMixin.class */
@Mixin({EmiRecipeFiller.class})
public class RecipeFillerMixin {
    @Inject(method = {"isSupported"}, at = {@At("HEAD")}, remap = false, cancellable = true)
    private static void isSupported(EmiRecipe emiRecipe, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        AbstractContainerScreen handledScreen = EmiApi.getHandledScreen();
        if (handledScreen != null) {
            AbstractContainerMenu menu = handledScreen.getMenu();
            if (menu instanceof ContainerComponent) {
                callbackInfoReturnable.setReturnValue((Boolean) RecipeHandlerRegistry.getHandler(((ContainerComponent) menu).getClass().getSimpleName()).map(emiRecipeHandler -> {
                    return Boolean.valueOf(emiRecipeHandler.supportsRecipe(emiRecipe));
                }).orElse(false));
            }
        }
    }

    @Inject(method = {"getAllHandlers"}, at = {@At("HEAD")}, remap = false, cancellable = true)
    private static <Container extends AbstractContainerMenu> void getAllHandlers(AbstractContainerScreen<Container> abstractContainerScreen, CallbackInfoReturnable<List<EmiRecipeHandler<Container>>> callbackInfoReturnable) {
        if (abstractContainerScreen != null) {
            AbstractContainerMenu menu = abstractContainerScreen.getMenu();
            if (menu instanceof ContainerComponent) {
                ContainerComponent containerComponent = (ContainerComponent) menu;
                ArrayList arrayList = new ArrayList();
                RecipeHandlerRegistry.getHandler(containerComponent.getClass().getSimpleName()).ifPresent(emiRecipeHandler -> {
                    arrayList.add(emiRecipeHandler);
                });
                if (!arrayList.isEmpty()) {
                    callbackInfoReturnable.setReturnValue(arrayList);
                }
            }
        }
    }
}
