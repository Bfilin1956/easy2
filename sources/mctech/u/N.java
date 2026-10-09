package mctech.u;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/N.class */
public class N extends AbstractC0179g {
    public N(Ingredient ingredient, int i, ItemStack itemStack, ItemStack itemStack2, double d, int i2) {
        super(ingredient, i, itemStack, itemStack2, d, i2);
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) E.b.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) E.a.get();
    }
}
