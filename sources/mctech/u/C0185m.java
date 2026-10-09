package mctech.u;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

/* JADX INFO: renamed from: mctech.u.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/m.class */
public class C0185m extends AbstractC0179g {
    public C0185m(Ingredient ingredient, int i, ItemStack itemStack, ItemStack itemStack2, double d, int i2, FluidIngredient fluidIngredient, int i3) {
        super(ingredient, i, itemStack, itemStack2, d, i2, fluidIngredient, i3);
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) E.f.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) E.e.get();
    }
}
