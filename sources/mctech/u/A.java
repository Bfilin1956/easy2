package mctech.u;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/A.class */
public class A extends AbstractC0179g {
    public A(Ingredient ingredient, int i, ItemStack itemStack, double d, int i2, FluidIngredient fluidIngredient, int i3, FluidStack fluidStack) {
        super(ingredient, i, itemStack, d, i2, fluidIngredient, i3, fluidStack);
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) E.h.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) E.g.get();
    }
}
