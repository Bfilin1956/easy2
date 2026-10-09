package mctech.u;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import mctech.init.MCTechRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/O.class */
public class O implements Recipe<P> {
    private final List<ItemStack> a;
    private final int b;
    private final int c;
    private final double d;
    private final FluidStack e;

    public O(List<ItemStack> list, int i, int i2, double d, FluidStack fluidStack) {
        this.a = list;
        this.b = i;
        this.c = i2;
        this.d = d;
        this.e = fluidStack;
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(Ingredient.of(), new Ingredient[]{Ingredient.of((ItemStack[]) this.a.toArray(new ItemStack[0]))});
    }

    public boolean a(ItemStack itemStack) {
        Iterator<ItemStack> it = d().iterator();
        while (it.hasNext()) {
            if (mctech.utils.c.h.d(it.next(), itemStack)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(O o) {
        if (o == null) {
            return false;
        }
        List<ItemStack> listD = o.d();
        if (listD.size() != this.a.size() || !o.e().is(e().getFluid())) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (ItemStack itemStack : this.a) {
            for (int i = 0; i < listD.size(); i++) {
                if (mctech.utils.c.h.d(itemStack, listD.get(i))) {
                    hashSet.add(Integer.valueOf(i));
                    break;
                }
            }
        }
        return hashSet.size() == this.a.size();
    }

    @Nullable
    public static O a(@NotNull Level level, @NotNull mctech.blockentities.c.K k, int... iArr) {
        IntStream intStreamStream = Arrays.stream(iArr);
        Objects.requireNonNull(k);
        return a(level, (List<ItemStack>) intStreamStream.mapToObj(k::getStackInSlot).toList());
    }

    @Nullable
    public static O a(@NotNull Level level, ItemStack... itemStackArr) {
        return a(level, (List<ItemStack>) List.of((Object[]) itemStackArr));
    }

    public static boolean a(@NotNull Level level, ItemStack itemStack) {
        Iterator it = level.getRecipeManager().getAllRecipesFor((RecipeType) MCTechRecipes.REGISTERED_RECIPES.get(mctech.i.i.PLASMA_GENERATOR.getSerializedName()).get()).iterator();
        while (it.hasNext()) {
            Iterator<ItemStack> it2 = ((O) ((RecipeHolder) it.next()).value()).d().iterator();
            while (it2.hasNext()) {
                if (mctech.utils.c.h.d(it2.next(), itemStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public static O a(@NotNull Level level, List<ItemStack> list) {
        return (O) level.getRecipeManager().getRecipeFor((RecipeType) MCTechRecipes.REGISTERED_RECIPES.get(mctech.i.i.PLASMA_GENERATOR.getSerializedName()).get(), new P(list), level).map((v0) -> {
            return v0.value();
        }).orElse(null);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean matches(@NotNull P p, @NotNull Level level) {
        return p.a(this.a);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ItemStack assemble(@NotNull P p, HolderLookup.Provider provider) {
        FluidStack fluidStackCopy = e().copy();
        return new ItemStack(fluidStackCopy.getFluid().getBucket(), fluidStackCopy.getAmount());
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    @NotNull
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    public double a() {
        return this.d;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public List<ItemStack> d() {
        return this.a;
    }

    public FluidStack e() {
        return this.e;
    }

    @NotNull
    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.REGISTERED_SERIALIZERS.get(mctech.i.i.PLASMA_GENERATOR.getSerializedName()).get();
    }

    @NotNull
    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get(mctech.i.i.PLASMA_GENERATOR.getSerializedName()).get();
    }
}
