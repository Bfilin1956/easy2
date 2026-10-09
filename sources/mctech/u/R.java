package mctech.u;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/R.class */
public class R implements Recipe<RecipeInput> {
    private final Ingredient a;
    private final float b;
    private final ResourceLocation c;

    public R(Ingredient ingredient, float f, ResourceLocation resourceLocation) {
        this.a = ingredient;
        this.b = f;
        this.c = resourceLocation;
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
        ResourceLocation resourceLocationB = ((a) recipeInput).b();
        if (resourceLocationB == null) {
            return this.a.test(recipeInput.getItem(0));
        }
        return resourceLocationB.equals(this.c) && this.a.test(recipeInput.getItem(0));
    }

    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    public Ingredient b() {
        return this.a;
    }

    public float c() {
        return this.b;
    }

    public ResourceLocation d() {
        return this.c;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/R$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ItemStack a;
        private final ResourceLocation b;

        public a(ItemStack itemStack, ResourceLocation resourceLocation) {
            this.a = itemStack;
            this.b = resourceLocation;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "stack;location", "FIELD:Lmctech/u/R$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/R$a;->b:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "stack;location", "FIELD:Lmctech/u/R$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/R$a;->b:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "stack;location", "FIELD:Lmctech/u/R$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/u/R$a;->b:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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
        return null;
    }

    public RecipeType<?> getType() {
        return null;
    }
}
