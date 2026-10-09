package mctech.u;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

/* JADX INFO: renamed from: mctech.u.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/k.class */
public class C0183k extends AbstractC0179g {
    public C0183k(Ingredient ingredient, int i, ItemStack itemStack, double d, int i2, FluidIngredient fluidIngredient, int i3) {
        super(ingredient, i, itemStack, d, i2, fluidIngredient, i3);
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) E.d.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) E.c.get();
    }
}
