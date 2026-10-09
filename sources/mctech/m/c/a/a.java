package mctech.m.c.a;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mctech.m.c.l;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/a/a.class */
public abstract class a<Machine extends BlockEntity, R extends Recipe<? extends RecipeInput>> implements mctech.m.c.g, mctech.m.c.h {
    protected final Machine a;
    private Set<l> b;
    private boolean c;

    protected abstract RecipeType<R> b();

    protected abstract ItemStack a(R r);

    protected a(Machine machine) {
        this.a = machine;
    }

    @Override // mctech.m.c.h
    public void a() {
        this.b = null;
        this.c = false;
    }

    private void c() {
        Level level = this.a.getLevel();
        RecipeType<R> recipeTypeB = b();
        if (level == null || recipeTypeB == null) {
            this.b = Set.of();
            this.c = false;
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator it = level.getRecipeManager().getAllRecipesFor(recipeTypeB).iterator();
        while (it.hasNext()) {
            ItemStack itemStackA = a(((RecipeHolder) it.next()).value());
            if (!itemStackA.isEmpty()) {
                hashSet.add(new l(itemStackA));
            }
        }
        this.b = hashSet;
        this.c = true;
    }

    private void d() {
        if (!this.c) {
            c();
        }
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return false;
        }
        d();
        return this.b != null && this.b.contains(new l(itemStack));
    }
}
