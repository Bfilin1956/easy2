package mctech.u;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Collections;
import java.util.List;
import mctech.api.recipes.IExperienceRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;

/* JADX INFO: renamed from: mctech.u.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/h.class */
public abstract class AbstractC0180h implements IExperienceRecipe, Recipe<RecipeInput> {
    private final Ingredient a;
    private final ItemStack b;
    private final double c;
    private final float d;
    private final int e;
    private final boolean f;

    public AbstractC0180h(Ingredient ingredient, ItemStack itemStack, double d, int i, boolean z) {
        this(ingredient, itemStack, d, 0.0f, i, z);
    }

    public AbstractC0180h(Ingredient ingredient, ItemStack itemStack, double d, float f, int i, boolean z) {
        this.a = ingredient;
        this.b = itemStack;
        this.c = d;
        this.d = f;
        this.e = i;
        this.f = z;
    }

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonNullListCreate = NonNullList.create();
        nonNullListCreate.add(this.a);
        return nonNullListCreate;
    }

    public int a() {
        return 1;
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    public boolean matches(RecipeInput recipeInput, Level level) {
        if (((a) recipeInput).b()) {
            return this.f && this.a.test(recipeInput.getItem(0));
        }
        return this.a.test(recipeInput.getItem(0));
    }

    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.b;
    }

    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return this.b.copy();
    }

    public List<ItemStack> a(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return Collections.singletonList(this.b.copy());
    }

    public Ingredient h() {
        return this.a;
    }

    public double i() {
        return this.c;
    }

    public int j() {
        return this.e;
    }

    public boolean k() {
        return this.f;
    }

    public ItemStack l() {
        return this.b;
    }

    @Override // mctech.api.recipes.IExperienceRecipe
    public float getExperience() {
        return this.d;
    }

    /* JADX INFO: renamed from: mctech.u.h$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/h$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ItemStack a;
        private final boolean b;

        public a(ItemStack itemStack, boolean z) {
            this.a = itemStack;
            this.b = z;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "stack;stone", "FIELD:Lmctech/u/h$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/h$a;->b:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "stack;stone", "FIELD:Lmctech/u/h$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/h$a;->b:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "stack;stone", "FIELD:Lmctech/u/h$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/h$a;->b:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }

        public ItemStack getItem(int i) {
            if (i != 0) {
                throw new IllegalArgumentException("No item for index " + i);
            }
            return a();
        }

        public int size() {
            return 1;
        }
    }
}
