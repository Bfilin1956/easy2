package mctech.u;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/S.class */
public class S implements Recipe<RecipeInput> {
    private final ItemStack a;
    private final float b;
    private final ResourceLocation c;

    public S(ItemStack itemStack, float f, ResourceLocation resourceLocation) {
        this.a = itemStack;
        this.b = f;
        this.c = resourceLocation;
    }

    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.create();
    }

    public int a() {
        return 1;
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    public boolean matches(RecipeInput recipeInput, Level level) {
        ResourceLocation resourceLocationA = ((a) recipeInput).a();
        return resourceLocationA != null && resourceLocationA.equals(this.c) && ((a) recipeInput).b >= this.b;
    }

    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.a;
    }

    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        ResourceLocation resourceLocationA = ((a) recipeInput).a();
        if (resourceLocationA == null) {
            return ItemStack.EMPTY;
        }
        return (!resourceLocationA.equals(this.c) || ((a) recipeInput).b < this.b) ? ItemStack.EMPTY : this.a.copy();
    }

    public ItemStack b() {
        return this.a;
    }

    public float c() {
        return this.b;
    }

    public ResourceLocation d() {
        return this.c;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/S$a.class */
    public static final class a extends Record implements RecipeInput {
        private final ResourceLocation a;
        private final float b;

        public a(ResourceLocation resourceLocation, float f) {
            this.a = resourceLocation;
            this.b = f;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "location;amount", "FIELD:Lmctech/u/S$a;->a:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/u/S$a;->b:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "location;amount", "FIELD:Lmctech/u/S$a;->a:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/u/S$a;->b:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "location;amount", "FIELD:Lmctech/u/S$a;->a:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/u/S$a;->b:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ResourceLocation a() {
            return this.a;
        }

        public float b() {
            return this.b;
        }

        public ItemStack getItem(int i) {
            return new ItemStack(Items.STONE);
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
