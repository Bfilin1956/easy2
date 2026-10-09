package mctech.m.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mctech.api.tiles.IRecipeMachine;
import mctech.m.a.g;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/e.class */
public class e<Machine extends BlockEntity & IRecipeMachine & mctech.m.a.g> extends c<Machine> implements g {
    private final Map<Integer, Set<Ingredient>> d;
    private boolean e;
    private final int f;
    private final int g;

    public e(Machine machine, int i, int i2) {
        super(machine);
        this.d = new HashMap();
        this.f = i;
        this.g = i2;
    }

    @Override // mctech.m.c.c
    protected void c() {
        this.d.clear();
        this.e = false;
    }

    private void d() {
        Level level = this.a.getLevel();
        RecipeType recipeType = this.a.getRecipeType();
        if (level == null || recipeType == null) {
            this.d.clear();
            this.e = false;
            return;
        }
        this.d.clear();
        this.b.clear();
        List allRecipesFor = level.getRecipeManager().getAllRecipesFor(recipeType);
        int i = 0;
        Iterator it = allRecipesFor.iterator();
        while (it.hasNext()) {
            int size = ((RecipeHolder) it.next()).value().getIngredients().size();
            if (size > i) {
                i = size;
            }
        }
        for (int i2 = 0; i2 < i; i2++) {
            HashSet hashSet = new HashSet();
            Iterator it2 = allRecipesFor.iterator();
            while (it2.hasNext()) {
                NonNullList ingredients = ((RecipeHolder) it2.next()).value().getIngredients();
                if (i2 < ingredients.size()) {
                    hashSet.add((Ingredient) ingredients.get(i2));
                }
            }
            this.d.put(Integer.valueOf(i2), hashSet);
        }
        this.e = true;
    }

    @Override // mctech.m.c.c
    protected Set<Ingredient> b() {
        if (!this.e) {
            d();
        }
        return this.d.getOrDefault(Integer.valueOf(this.f), Collections.emptySet());
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        if (!a(itemStack)) {
            return false;
        }
        ItemStack stackInSlot = this.a.getStackInSlot(this.g);
        return ItemStack.isSameItemSameComponents(stackInSlot, itemStack) || stackInSlot.isEmpty();
    }
}
