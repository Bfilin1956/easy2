package mctech.u;

import mctech.init.MCTechRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/Y.class */
public class Y implements Recipe<RecipeInput> {
    private final float a;
    private final ItemStack b;

    public Y(float f, ItemStack itemStack) {
        this.a = f;
        this.b = itemStack;
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.SCRAPBOX_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.SCRAP_BOX.get();
    }

    public boolean matches(RecipeInput recipeInput, Level level) {
        return true;
    }

    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return b();
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    public float a() {
        return this.a;
    }

    public ItemStack b() {
        return this.b.copy();
    }

    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return b();
    }

    public boolean c() {
        return (this.b == null || this.b.isEmpty() || this.a <= 0.0f) ? false : true;
    }
}
