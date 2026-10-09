package mctech.u;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.init.MCTechRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/aa.class */
public class aa implements Recipe<RecipeInput> {
    private final Ingredient a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final ItemStack f;
    private final ResourceLocation g;

    public aa(Ingredient ingredient, int i, ResourceLocation resourceLocation, int i2, int i3, int i4, ItemStack itemStack) {
        this.a = ingredient;
        this.b = i;
        this.g = resourceLocation;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = itemStack;
    }

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonNullListCreate = NonNullList.create();
        nonNullListCreate.add(this.a);
        return nonNullListCreate;
    }

    public int a() {
        return this.b;
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    public boolean matches(RecipeInput recipeInput, Level level) {
        ResourceLocation resourceLocationB = ((a) recipeInput).b();
        if (resourceLocationB == null) {
            return recipeInput.getItem(0).getCount() >= this.b && this.a.test(recipeInput.getItem(0));
        }
        return resourceLocationB.equals(this.g) && recipeInput.getItem(0).getCount() >= this.b && this.a.test(recipeInput.getItem(0));
    }

    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        ResourceLocation resourceLocationB = ((a) recipeInput).b();
        if (resourceLocationB == null) {
            return ItemStack.EMPTY;
        }
        return (resourceLocationB.equals(this.g) && recipeInput.getItem(0).getCount() >= this.b && this.a.test(recipeInput.getItem(0))) ? this.f.copy() : ItemStack.EMPTY;
    }

    public Ingredient b() {
        return this.a;
    }

    public ResourceLocation c() {
        return this.g;
    }

    public ItemStack d() {
        return this.f;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.e;
    }

    public int g() {
        return this.d;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/aa$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ItemStack a;
        private final ResourceLocation b;

        public a(ItemStack itemStack, ResourceLocation resourceLocation) {
            this.a = itemStack;
            this.b = resourceLocation;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "stack;location", "FIELD:Lmctech/u/aa$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/aa$a;->b:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "stack;location", "FIELD:Lmctech/u/aa$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/aa$a;->b:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "stack;location", "FIELD:Lmctech/u/aa$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/aa$a;->b:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack a() {
            return this.a;
        }

        public ResourceLocation b() {
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

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.URANIUM_ENRICHER_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.URANIUM_ENRICHER.get();
    }
}
