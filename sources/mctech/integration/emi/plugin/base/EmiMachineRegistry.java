package mctech.integration.emi.plugin.base;

import dev.emi.emi.api.EmiApi;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import mctech.integration.emi.plugin.core.EMIPlugin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/base/EmiMachineRegistry.class */
public class EmiMachineRegistry {
    private static final Map<String, EmiMachine<?, ?, ?, ?, ?>> REGISTERED = new HashMap();

    public static <RI extends RecipeInput, R extends Recipe<RI>, B extends Block, ER extends EmiRecipe, EC extends EmiRecipeCategory> void register(String str, EmiMachine<RI, R, B, ER, EC> emiMachine) {
        REGISTERED.put(str, emiMachine);
    }

    public static <RI extends RecipeInput, R extends Recipe<RI>, B extends Block, ER extends EmiRecipe, EC extends EmiRecipeCategory> void register(EmiMachine<RI, R, B, ER, EC> emiMachine) {
        REGISTERED.put(emiMachine.getCategoryName(), emiMachine);
    }

    public static void registerAll(EmiRegistry emiRegistry, RecipeManager recipeManager) {
        for (EmiMachine<?, ?, ?, ?, ?> emiMachine : REGISTERED.values().stream().sorted(Comparator.comparing((v0) -> {
            return v0.getCategoryName();
        })).toList()) {
            emiMachine.registerCategory(emiRegistry);
            emiMachine.registerWorkstations(emiRegistry);
            emiMachine.registerRecipes(emiRegistry, recipeManager);
            EMIPlugin.register(emiMachine.getCategoryName(), emiMachine.getOrCreateCategory());
        }
    }

    public static <RI extends RecipeInput, R extends Recipe<RI>, B extends Block, ER extends EmiRecipe, EC extends EmiRecipeCategory> EmiMachine<RI, R, B, ER, EC> get(@NotNull String str) {
        return (EmiMachine) REGISTERED.get(str);
    }

    public static <BE extends BlockEntity> void displayRecipes(@NotNull BE be) {
        BlockEntityType type = be.getType();
        if (type.builtInRegistryHolder() != null) {
            type.builtInRegistryHolder().unwrapKey().flatMap(resourceKey -> {
                return getCategory(resourceKey.location().getPath());
            }).ifPresent(EmiApi::displayRecipeCategory);
        }
    }

    public static <BE extends BlockEntity> boolean hasRecipesFor(@NotNull BE be) {
        BlockEntityType type = be.getType();
        if (type.builtInRegistryHolder() != null) {
            return type.builtInRegistryHolder().unwrapKey().flatMap(resourceKey -> {
                return getCategory(resourceKey.location().getPath());
            }).isPresent();
        }
        return false;
    }

    public static Optional<EmiRecipeCategory> getCategory(@NotNull String str) {
        EmiMachine emiMachine = get(str);
        if (emiMachine != null) {
            return Optional.ofNullable(emiMachine.getOrCreateCategory());
        }
        return Optional.empty();
    }

    public static void displayRecipes(@NotNull String str) {
        getCategory(str).ifPresent(EmiApi::displayRecipeCategory);
    }

    public static void displayRecipes(@NotNull ResourceLocation resourceLocation) {
        getCategory(resourceLocation.getPath()).ifPresent(EmiApi::displayRecipeCategory);
    }

    public static Collection<EmiMachine<?, ?, ?, ?, ?>> getAllRegistrations() {
        return REGISTERED.values();
    }
}
