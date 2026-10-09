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
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

/* JADX INFO: renamed from: mctech.u.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/u.class */
public class C0193u implements Recipe<RecipeInput> {
    private final FluidIngredient a;
    private final int b;
    private final int c;

    public C0193u(FluidIngredient fluidIngredient, int i, int i2) {
        this.a = fluidIngredient;
        this.b = i;
        this.c = i2;
    }

    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.create();
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    public boolean matches(RecipeInput recipeInput, Level level) {
        return this.a.test(((a) recipeInput).a());
    }

    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    public FluidIngredient a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    /* JADX INFO: renamed from: mctech.u.u$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/u$a.class */
    public static final class a extends Record implements RecipeInput {
        private final FluidStack a;

        public a(FluidStack fluidStack) {
            this.a = fluidStack;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "stack", "FIELD:Lmctech/u/u$a;->a:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "stack", "FIELD:Lmctech/u/u$a;->a:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "stack", "FIELD:Lmctech/u/u$a;->a:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public FluidStack a() {
            return this.a;
        }

        public ItemStack getItem(int i) {
            throw new IllegalArgumentException("No item for index " + i);
        }

        public int size() {
            return 0;
        }
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.FLUID_FUEL_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.FLUID_FUEL.get();
    }
}
