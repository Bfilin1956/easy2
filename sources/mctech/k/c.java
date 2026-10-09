package mctech.k;

import java.util.Optional;
import mctech.init.MCTechRecipes;
import mctech.u.C0195w;
import mctech.u.C0196x;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/k/c.class */
public final class c {
    private c() {
    }

    public static RecipeType<C0195w> a() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get("genetic_printer").get();
    }

    public static RecipeType<C0196x> b() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get("genetic_stabilizer").get();
    }

    public static Optional<C0195w> a(@Nullable Level level, @Nullable ResourceLocation resourceLocation) {
        if (level == null || resourceLocation == null) {
            return Optional.empty();
        }
        return level.getRecipeManager().getAllRecipesFor(a()).stream().map((v0) -> {
            return v0.value();
        }).filter((v0) -> {
            return v0.a();
        }).filter(c0195w -> {
            return resourceLocation.equals(c0195w.b());
        }).findFirst();
    }

    public static Optional<C0195w> a(@Nullable Level level, ItemStack itemStack) {
        return a(level, b.a(itemStack));
    }

    public static boolean b(@Nullable Level level, @Nullable ResourceLocation resourceLocation) {
        return a(level, resourceLocation).isPresent();
    }

    public static Optional<C0196x> b(@Nullable Level level, ItemStack itemStack) {
        if (level == null || itemStack.isEmpty()) {
            return Optional.empty();
        }
        return level.getRecipeManager().getRecipeFor(b(), new C0196x.a(itemStack), level).map((v0) -> {
            return v0.value();
        }).filter((v0) -> {
            return v0.a();
        });
    }
}
