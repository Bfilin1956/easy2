package mctech.u;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/M.class */
public class M extends AbstractC0179g {
    public M(Ingredient ingredient, int i, ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3, double d, int i2) {
        super(ingredient, i, itemStack, itemStack2, itemStack3, d, i2);
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) E.l.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) E.k.get();
    }
}
