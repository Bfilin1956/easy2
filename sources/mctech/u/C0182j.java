package mctech.u;

import mctech.init.MCTechRecipes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

/* JADX INFO: renamed from: mctech.u.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/j.class */
public class C0182j extends AbstractC0180h {
    public C0182j(Ingredient ingredient, ItemStack itemStack, double d, int i, boolean z) {
        super(ingredient, itemStack, d, i, z);
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.CANNER_FOOD_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.CANNER_FOOD.get();
    }
}
