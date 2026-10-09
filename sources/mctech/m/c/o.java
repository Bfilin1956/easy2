package mctech.m.c;

import java.util.Set;
import java.util.stream.Collectors;
import mctech.api.tiles.IRecipeMachine;
import mctech.m.a.g;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/o.class */
public class o<Machine extends BlockEntity & IRecipeMachine & mctech.m.a.g> implements h, mctech.m.e.a.a {
    private final Machine a;
    private Set<Ingredient> b;

    public o(Machine machine) {
        this.a = machine;
    }

    @Override // mctech.m.c.h
    public void a() {
        if (this.b != null) {
            this.b.clear();
        }
    }

    private void b() {
        Level level = this.a.getLevel();
        RecipeType recipeType = this.a.getRecipeType();
        if (level == null || recipeType == null) {
            return;
        }
        this.b = (Set) level.getRecipeManager().getAllRecipesFor(recipeType).stream().flatMap(recipeHolder -> {
            return recipeHolder.value().getIngredients().stream();
        }).collect(Collectors.toSet());
    }

    @Override // mctech.m.e.a.a
    public boolean matches(int i, ItemStack itemStack) {
        if (this.b == null || this.b.isEmpty()) {
            b();
        }
        return this.b.stream().anyMatch(ingredient -> {
            return ingredient.test(itemStack);
        }) && (ItemStack.isSameItemSameComponents(this.a.getStackInSlot(i), itemStack) || this.a.getStackInSlot(i).isEmpty() || i == -1);
    }
}
