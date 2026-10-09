package mctech.u;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import mctech.init.MCTechRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.u.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/e.class */
public final class C0177e extends Record implements Recipe<C0178f> {
    private final List<ItemStack> a;
    private final FluidStack b;
    private final List<String> c;
    private final FluidStack d;

    public C0177e(List<ItemStack> list, FluidStack fluidStack, List<String> list2, FluidStack fluidStack2) {
        this.a = list;
        this.b = fluidStack;
        this.c = list2;
        this.d = fluidStack2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0177e.class), C0177e.class, "ingredients;fluidIngredient;consumables;fluidResult", "FIELD:Lmctech/u/e;->a:Ljava/util/List;", "FIELD:Lmctech/u/e;->b:Lnet/neoforged/neoforge/fluids/FluidStack;", "FIELD:Lmctech/u/e;->c:Ljava/util/List;", "FIELD:Lmctech/u/e;->d:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0177e.class), C0177e.class, "ingredients;fluidIngredient;consumables;fluidResult", "FIELD:Lmctech/u/e;->a:Ljava/util/List;", "FIELD:Lmctech/u/e;->b:Lnet/neoforged/neoforge/fluids/FluidStack;", "FIELD:Lmctech/u/e;->c:Ljava/util/List;", "FIELD:Lmctech/u/e;->d:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0177e.class, Object.class), C0177e.class, "ingredients;fluidIngredient;consumables;fluidResult", "FIELD:Lmctech/u/e;->a:Ljava/util/List;", "FIELD:Lmctech/u/e;->b:Lnet/neoforged/neoforge/fluids/FluidStack;", "FIELD:Lmctech/u/e;->c:Ljava/util/List;", "FIELD:Lmctech/u/e;->d:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public List<ItemStack> a() {
        return this.a;
    }

    public FluidStack b() {
        return this.b;
    }

    public List<String> c() {
        return this.c;
    }

    public FluidStack d() {
        return this.d;
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(Ingredient.of(), new Ingredient[]{Ingredient.of((ItemStack[]) this.a.toArray(new ItemStack[0]))});
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean matches(@NotNull C0178f c0178f, @NotNull Level level) {
        return c0178f.a(this);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ItemStack assemble(@NotNull C0178f c0178f, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    @NotNull
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @NotNull
    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.REGISTERED_SERIALIZERS.get(mctech.i.i.ATOMIC_SMELTER.getSerializedName()).get();
    }

    @NotNull
    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get(mctech.i.i.ATOMIC_SMELTER.getSerializedName()).get();
    }
}
