package mctech.m.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mctech.api.tiles.IRecipeMachine;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/m.class */
public class m<Machine extends BlockEntity & IRecipeMachine> implements g, h {
    private static final int a = 512;
    private final Machine b;
    private Set<Ingredient> c = Collections.emptySet();
    private final Map<l, Boolean> d = new HashMap();
    private boolean e;

    public m(Machine machine) {
        this.b = machine;
    }

    @Override // mctech.m.c.h
    public void a() {
        this.c = Collections.emptySet();
        this.d.clear();
        this.e = false;
    }

    private void b() {
        Level level = this.b.getLevel();
        RecipeType recipeType = this.b.getRecipeType();
        if (level == null || recipeType == null) {
            this.c = Collections.emptySet();
            this.e = false;
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator it = level.getRecipeManager().getAllRecipesFor(recipeType).iterator();
        while (it.hasNext()) {
            hashSet.addAll(((RecipeHolder) it.next()).value().getIngredients());
        }
        this.c = hashSet;
        this.d.clear();
        this.e = true;
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return false;
        }
        if (!this.e) {
            b();
        }
        if (this.c.isEmpty()) {
            return false;
        }
        l lVar = new l(itemStack);
        Boolean bool = this.d.get(lVar);
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        Iterator<Ingredient> it = this.c.iterator();
        while (it.hasNext()) {
            if (it.next().test(itemStack)) {
                z = true;
                break;
            }
        }
        if (this.d.size() >= 512) {
            this.d.clear();
        }
        this.d.put(lVar, Boolean.valueOf(z));
        return z;
    }
}
