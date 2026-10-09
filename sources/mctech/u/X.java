package mctech.u;

import mctech.init.MCTechRecipes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/X.class */
public class X extends AbstractC0180h {
    public X(Ingredient ingredient, ItemStack itemStack, double d, int i, boolean z) {
        this(ingredient, itemStack, d, 0.0f, i, z);
    }

    public X(Ingredient ingredient, ItemStack itemStack, double d, float f, int i, boolean z) {
        super(ingredient, itemStack, d, f, i, z);
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.SAWMILL_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.SAWMILL.get();
    }
}
