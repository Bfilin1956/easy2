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

/* JADX INFO: renamed from: mctech.u.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/q.class */
public class C0189q implements Recipe<RecipeInput> {
    private final Ingredient a;
    private final int b;
    private final ItemStack c;
    private final double d;
    private final int e;
    private final boolean f;

    public C0189q(Ingredient ingredient, int i, ItemStack itemStack, double d, int i2, boolean z) {
        this.a = ingredient;
        this.b = i;
        this.c = itemStack;
        this.d = d;
        this.e = i2;
        this.f = z;
    }

    public int a() {
        return this.b;
    }

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonNullListCreate = NonNullList.create();
        nonNullListCreate.add(this.a);
        return nonNullListCreate;
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    public boolean matches(RecipeInput recipeInput, Level level) {
        a aVar = (a) recipeInput;
        return aVar.c() == this.f && aVar.b() >= this.d && recipeInput.getItem(0).getCount() >= this.b && this.a.test(recipeInput.getItem(0));
    }

    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.c;
    }

    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return this.c.copy();
    }

    public Ingredient b() {
        return this.a;
    }

    public double c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public ItemStack e() {
        return this.c;
    }

    public boolean f() {
        return this.f;
    }

    /* JADX INFO: renamed from: mctech.u.q$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/q$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ItemStack a;
        private final double b;
        private final boolean c;

        public a(ItemStack itemStack, double d, boolean z) {
            this.a = itemStack;
            this.b = d;
            this.c = z;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "stack;energy;charge", "FIELD:Lmctech/u/q$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/q$a;->b:D", "FIELD:Lmctech/u/q$a;->c:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "stack;energy;charge", "FIELD:Lmctech/u/q$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/q$a;->b:D", "FIELD:Lmctech/u/q$a;->c:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "stack;energy;charge", "FIELD:Lmctech/u/q$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/q$a;->b:D", "FIELD:Lmctech/u/q$a;->c:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack a() {
            return this.a;
        }

        public double b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
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

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.ELECTROLYZER_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.ELECTROLYZER.get();
    }
}
