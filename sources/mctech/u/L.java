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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/L.class */
public class L implements Recipe<RecipeInput> {
    private final FluidStack a;
    private final FluidStack b;
    private final int c;

    public L(FluidStack fluidStack, FluidStack fluidStack2, int i) {
        this.a = fluidStack;
        this.b = fluidStack2;
        this.c = i;
    }

    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.create();
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    public boolean matches(RecipeInput recipeInput, Level level) {
        FluidStack fluidStackA = ((a) recipeInput).a();
        return this.a.getFluid().equals(fluidStackA.getFluid()) && this.a.getAmount() <= fluidStackA.getAmount();
    }

    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    public FluidStack a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public FluidStack c() {
        return this.b;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/L$a.class */
    public static final class a extends Record implements RecipeInput {
        private final FluidStack a;

        public a(FluidStack fluidStack) {
            this.a = fluidStack;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "stack", "FIELD:Lmctech/u/L$a;->a:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "stack", "FIELD:Lmctech/u/L$a;->a:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "stack", "FIELD:Lmctech/u/L$a;->a:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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
        return (RecipeSerializer) MCTechRecipes.NUCLEAR_ENRICHMENT_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.NUCLEAR_ENRICHMENT.get();
    }
}
