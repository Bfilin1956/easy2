package mctech.integration.emi.plugin.base;

import dev.emi.emi.api.recipe.handler.EmiRecipeHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.world.inventory.AbstractContainerMenu;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/base/RecipeHandlerRegistry.class */
public class RecipeHandlerRegistry {
    private static final Map<String, EmiRecipeHandler<?>> HANDLERS = new HashMap();

    public static <C extends AbstractContainerMenu> void register(Class<C> cls, EmiRecipeHandler<C> emiRecipeHandler) {
        HANDLERS.put(cls.getSimpleName(), emiRecipeHandler);
    }

    public static <C extends AbstractContainerMenu> void register(String str, EmiRecipeHandler<C> emiRecipeHandler) {
        HANDLERS.put(str, emiRecipeHandler);
    }

    public static <C extends AbstractContainerMenu> Optional<EmiRecipeHandler<C>> getHandler(Class<C> cls) {
        return Optional.ofNullable(HANDLERS.get(cls.getSimpleName()));
    }

    public static <C extends AbstractContainerMenu> Optional<EmiRecipeHandler<C>> getHandler(String str) {
        return Optional.ofNullable(HANDLERS.get(str));
    }

    public static void clear() {
        HANDLERS.clear();
    }
}
