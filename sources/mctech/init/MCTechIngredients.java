package mctech.init;

import mctech.MCTech;
import mctech.u.c.a;
import mctech.u.c.e;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.crafting.IngredientType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechIngredients.class */
public class MCTechIngredients {
    private static final DeferredRegister<IngredientType<?>> INGREDIENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.INGREDIENT_TYPES, MCTech.MODID);
    public static final DeferredHolder<IngredientType<?>, IngredientType<a>> CONDUIT_INGREDIENT_TYPE = INGREDIENT_TYPES.register("conduit", () -> {
        return new IngredientType(a.a);
    });
    public static final DeferredHolder<IngredientType<?>, IngredientType<e>> RESOURCE_INGREDIENT = INGREDIENT_TYPES.register("resource_ingredient", () -> {
        return new IngredientType(e.a, e.b);
    });

    public static void register(IEventBus iEventBus) {
        INGREDIENT_TYPES.register(iEventBus);
    }
}
