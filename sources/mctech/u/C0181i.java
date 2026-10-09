package mctech.u;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.init.MCTechRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

/* JADX INFO: renamed from: mctech.u.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/i.class */
public class C0181i implements Recipe<RecipeInput> {
    private final Ingredient a;
    private final Ingredient b;
    private final int c;
    private final ItemStack d;
    private final double e;
    private final int f;

    public C0181i(Ingredient ingredient, Ingredient ingredient2, int i, ItemStack itemStack, double d, int i2) {
        this.a = ingredient;
        this.b = ingredient2;
        this.c = i;
        this.d = itemStack;
        this.e = d;
        this.f = i2;
    }

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonNullListCreate = NonNullList.create();
        nonNullListCreate.add(this.a);
        nonNullListCreate.add(this.b);
        return nonNullListCreate;
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    public boolean matches(RecipeInput recipeInput, Level level) {
        ItemStack item = recipeInput.getItem(0);
        ItemStack item2 = recipeInput.getItem(1);
        if (item.isEmpty() && item2.isEmpty()) {
            return false;
        }
        if (item.isEmpty() && this.b.test(item2)) {
            return true;
        }
        if (item2.isEmpty() && this.a.test(item)) {
            return true;
        }
        return item.getCount() >= this.c && this.a.test(item) && this.b.test(item2);
    }

    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.d;
    }

    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        ItemStack item = recipeInput.getItem(0);
        ItemStack item2 = recipeInput.getItem(1);
        return (item.getCount() < this.c || !this.a.test(item) || item2.getCount() < this.d.getCount() || !this.b.test(item2)) ? ItemStack.EMPTY : this.d.copy();
    }

    public Ingredient a() {
        return this.a;
    }

    public Ingredient b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public double d() {
        return this.e;
    }

    public int e() {
        return this.f;
    }

    public ItemStack f() {
        return this.d;
    }

    /* JADX INFO: renamed from: mctech.u.i$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/i$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ItemStack a;
        private final ItemStack b;

        public a(ItemStack itemStack, ItemStack itemStack2) {
            this.a = itemStack;
            this.b = itemStack2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "stack0;stack1", "FIELD:Lmctech/u/i$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/i$a;->b:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "stack0;stack1", "FIELD:Lmctech/u/i$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/i$a;->b:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "stack0;stack1", "FIELD:Lmctech/u/i$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/i$a;->b:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack a() {
            return this.a;
        }

        public ItemStack b() {
            return this.b;
        }

        public ItemStack getItem(int i) {
            switch (i) {
                case 0:
                    return a();
                case 1:
                    return b();
                default:
                    throw new IllegalArgumentException("No item for index " + i);
            }
        }

        public int size() {
            return 1;
        }
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.CANNER_FILL_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.CANNER_FILL.get();
    }
}
