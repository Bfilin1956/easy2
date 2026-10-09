package mctech.u;

import mctech.init.MCTechRecipes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

/* JADX INFO: renamed from: mctech.u.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/t.class */
public class C0192t extends AbstractC0180h {
    public C0192t(Ingredient ingredient, ItemStack itemStack, double d, int i) {
        this(ingredient, itemStack, d, 0.0f, i);
    }

    public C0192t(Ingredient ingredient, ItemStack itemStack, double d, float f, int i) {
        super(ingredient, itemStack, d, f, i, false);
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.EXTRACTOR_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.EXTRACTOR.get();
    }
}
