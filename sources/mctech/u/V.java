package mctech.u;

import mctech.init.MCTechItems;
import mctech.init.MCTechRecipes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/V.class */
public class V extends AbstractC0180h {
    private final float a;

    public V(Ingredient ingredient, float f, ItemStack itemStack, double d, int i, boolean z) {
        super(ingredient, itemStack, d, i, z);
        this.a = f;
    }

    public float b() {
        return this.a;
    }

    @Override // mctech.u.AbstractC0180h
    public boolean matches(RecipeInput recipeInput, Level level) {
        if (recipeInput.getItem(0).isEmpty() && l().getItem() == MCTechItems.SCRAP.get()) {
            return true;
        }
        return super.matches(recipeInput, level);
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.RECYCLER_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.RECYCLER.get();
    }
}
