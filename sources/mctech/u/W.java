package mctech.u;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
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
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/W.class */
public class W implements Recipe<RecipeInput> {
    private final Ingredient a;
    private final FluidIngredient b;
    private final FluidIngredient c;
    private final int d;
    private final int e;
    private final ItemStack f;
    private final ItemStack g;
    private final ItemStack h;
    private final FluidStack i;
    private final double j;
    private final int k;

    public W(Ingredient ingredient, FluidIngredient fluidIngredient, int i, FluidIngredient fluidIngredient2, int i2, ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3, FluidStack fluidStack, double d, int i3) {
        this.a = ingredient;
        this.b = fluidIngredient;
        this.c = fluidIngredient2;
        this.d = i;
        this.e = i2;
        this.f = itemStack;
        this.g = itemStack2;
        this.h = itemStack3;
        this.i = fluidStack;
        this.j = d;
        this.k = i3;
    }

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonNullListCreate = NonNullList.create();
        nonNullListCreate.add(this.a);
        return nonNullListCreate;
    }

    public NonNullList<FluidIngredient> a() {
        NonNullList<FluidIngredient> nonNullListCreate = NonNullList.create();
        nonNullListCreate.add(this.b);
        nonNullListCreate.add(this.c);
        return nonNullListCreate;
    }

    public NonNullList<Integer> b() {
        NonNullList<Integer> nonNullListCreate = NonNullList.create();
        nonNullListCreate.add(Integer.valueOf(this.d));
        nonNullListCreate.add(Integer.valueOf(this.e));
        return nonNullListCreate;
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    public boolean matches(RecipeInput recipeInput, Level level) {
        if (!(recipeInput instanceof b)) {
            return false;
        }
        b bVar = (b) recipeInput;
        if (this.a.test(bVar.a())) {
            return (this.b.test(bVar.a(0)) && this.c.test(bVar.a(1))) || (this.b.test(bVar.a(1)) && this.c.test(bVar.a(0)));
        }
        return false;
    }

    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    public a a(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return new a(this.f.copy(), this.g.copy(), this.h.copy(), this.i.copy());
    }

    public List<Predicate<? extends MutableDataComponentHolder>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.a);
        arrayList.add(this.b);
        arrayList.add(this.c);
        return arrayList;
    }

    public Ingredient d() {
        return this.a;
    }

    public FluidIngredient e() {
        return this.b;
    }

    public int f() {
        return this.d;
    }

    public int g() {
        return this.e;
    }

    public FluidIngredient h() {
        return this.c;
    }

    public ItemStack i() {
        return this.f;
    }

    public ItemStack j() {
        return this.g;
    }

    public ItemStack k() {
        return this.h;
    }

    public FluidStack l() {
        return this.i;
    }

    public double m() {
        return this.j;
    }

    public int n() {
        return this.k;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/W$b.class */
    public static final class b extends Record implements RecipeInput {
        private final ItemStack a;
        private final FluidStack b;
        private final FluidStack c;

        public b(ItemStack itemStack, FluidStack fluidStack, FluidStack fluidStack2) {
            this.a = itemStack;
            this.b = fluidStack;
            this.c = fluidStack2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "catalyst;fluid0;fluid1", "FIELD:Lmctech/u/W$b;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/W$b;->b:Lnet/neoforged/neoforge/fluids/FluidStack;", "FIELD:Lmctech/u/W$b;->c:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "catalyst;fluid0;fluid1", "FIELD:Lmctech/u/W$b;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/W$b;->b:Lnet/neoforged/neoforge/fluids/FluidStack;", "FIELD:Lmctech/u/W$b;->c:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "catalyst;fluid0;fluid1", "FIELD:Lmctech/u/W$b;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/W$b;->b:Lnet/neoforged/neoforge/fluids/FluidStack;", "FIELD:Lmctech/u/W$b;->c:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack a() {
            return this.a;
        }

        public FluidStack b() {
            return this.b;
        }

        public FluidStack c() {
            return this.c;
        }

        public ItemStack getItem(int i) {
            if (i == 0) {
                return a();
            }
            throw new IllegalArgumentException("No item for index " + i);
        }

        public FluidStack a(int i) {
            switch (i) {
                case 0:
                    return this.b;
                case 1:
                    return this.c;
                default:
                    throw new IllegalArgumentException("No fluid for index " + i);
            }
        }

        public int size() {
            return 1;
        }
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.REFINERY_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.REFINERY.get();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/W$a.class */
    public static final class a extends Record {
        private final ItemStack a;
        private final ItemStack b;
        private final ItemStack c;
        private final FluidStack d;

        public a(ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3, FluidStack fluidStack) {
            this.a = itemStack;
            this.b = itemStack2;
            this.c = itemStack3;
            this.d = fluidStack;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "itemStack0;itemStack1;itemStack2;fluidStack", "FIELD:Lmctech/u/W$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/W$a;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/W$a;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/W$a;->d:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "itemStack0;itemStack1;itemStack2;fluidStack", "FIELD:Lmctech/u/W$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/W$a;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/W$a;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/W$a;->d:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "itemStack0;itemStack1;itemStack2;fluidStack", "FIELD:Lmctech/u/W$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/W$a;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/W$a;->c:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/W$a;->d:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack a() {
            return this.a;
        }

        public ItemStack b() {
            return this.b;
        }

        public ItemStack c() {
            return this.c;
        }

        public FluidStack d() {
            return this.d;
        }
    }
}
