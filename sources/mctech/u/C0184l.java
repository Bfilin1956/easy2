package mctech.u;

import mctech.init.MCTechRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

/* JADX INFO: renamed from: mctech.u.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/l.class */
public class C0184l extends AbstractC0180h {
    private final int a;

    public C0184l(Ingredient ingredient, int i, ItemStack itemStack, double d, int i2) {
        this(ingredient, i, itemStack, d, 0.0f, i2);
    }

    public C0184l(Ingredient ingredient, int i, ItemStack itemStack, double d, float f, int i2) {
        super(ingredient, itemStack, d, f, i2, false);
        this.a = i;
    }

    @Override // mctech.u.AbstractC0180h
    public int a() {
        return this.a;
    }

    @Override // mctech.u.AbstractC0180h
    public boolean matches(RecipeInput recipeInput, Level level) {
        return recipeInput.getItem(0).getCount() >= this.a && super.matches(recipeInput, level);
    }

    @Override // mctech.u.AbstractC0180h
    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return recipeInput.getItem(0).getCount() >= this.a ? super.assemble(recipeInput, provider) : ItemStack.EMPTY;
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.COMPRESSOR_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.COMPRESSOR.get();
    }
}
