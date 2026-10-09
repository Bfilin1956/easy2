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
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.u.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/b.class */
public class C0170b implements Recipe<a> {
    private final Ingredient a;
    private final Ingredient b;
    private final int c;
    private final int d;
    private final ItemStack e;
    private final double f;
    private final int g;

    public C0170b(Ingredient ingredient, Ingredient ingredient2, int i, int i2, ItemStack itemStack, double d, int i3) {
        this.a = ingredient;
        this.b = ingredient2;
        this.c = i;
        this.d = i2;
        this.e = itemStack;
        this.f = d;
        this.g = i3;
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonNullListCreate = NonNullList.create();
        nonNullListCreate.add(this.a);
        nonNullListCreate.add(this.b);
        return nonNullListCreate;
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean matches(a aVar, @NotNull Level level) {
        return aVar.a(this);
    }

    @NotNull
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.e;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ItemStack assemble(@NotNull a aVar, HolderLookup.Provider provider) {
        return getResultItem(provider).copy();
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

    public int d() {
        return this.d;
    }

    public double e() {
        return this.f;
    }

    public int f() {
        return this.g;
    }

    public ItemStack g() {
        return this.e;
    }

    /* JADX INFO: renamed from: mctech.u.b$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/b$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ItemStack a;
        private final ItemStack b;

        public a(ItemStack itemStack, ItemStack itemStack2) {
            this.a = itemStack;
            this.b = itemStack2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "firstItem;secondItem", "FIELD:Lmctech/u/b$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/b$a;->b:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "firstItem;secondItem", "FIELD:Lmctech/u/b$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/b$a;->b:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "firstItem;secondItem", "FIELD:Lmctech/u/b$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/b$a;->b:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack a() {
            return this.a;
        }

        public ItemStack b() {
            return this.b;
        }

        @NotNull
        public ItemStack getItem(int i) {
            switch (i) {
                case 0:
                    return this.a;
                case 1:
                    return this.b;
                default:
                    return ItemStack.EMPTY;
            }
        }

        public int size() {
            return 2;
        }

        public boolean a(C0170b c0170b) {
            return !a().isEmpty() && !b().isEmpty() && c0170b.a.test(a()) && a().getCount() >= c0170b.c && c0170b.b.test(b()) && b().getCount() >= c0170b.d;
        }
    }

    @NotNull
    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.ALLOY_SMELTER_SERIALIZER.get();
    }

    @NotNull
    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.ALLOY_SMELTER.get();
    }
}
