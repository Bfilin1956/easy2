package mctech.u;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

/* JADX INFO: renamed from: mctech.u.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/z.class */
public class C0198z extends AbstractC0179g {
    public C0198z(Ingredient ingredient, int i, ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3, double d, int i2) {
        super(ingredient, i, itemStack, itemStack2, itemStack3, d, i2);
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) E.p.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) E.o.get();
    }
}
