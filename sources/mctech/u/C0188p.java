package mctech.u;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.u.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/p.class */
public class C0188p extends AbstractC0180h {
    private final List<ItemStack> a;
    private final List<ItemStack> b;
    private final double c;
    private final int d;

    public C0188p(List<ItemStack> list, List<ItemStack> list2, double d, int i) {
        super(Ingredient.EMPTY, ItemStack.EMPTY, 0.0d, 0, false);
        if (list.size() > 9 || list2.size() > 9) {
            throw new IllegalArgumentException("Must provide less 9 input or 9 output slots");
        }
        this.a = list;
        this.b = list2;
        this.c = d;
        this.d = i;
    }

    @Override // mctech.u.AbstractC0180h
    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonNullListCreate = NonNullList.create();
        nonNullListCreate.addAll(this.a.stream().map(itemStack -> {
            return Ingredient.of(new ItemStack[]{itemStack});
        }).toList());
        return nonNullListCreate;
    }

    @Override // mctech.u.AbstractC0180h
    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override // mctech.u.AbstractC0180h
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override // mctech.u.AbstractC0180h
    public boolean matches(RecipeInput recipeInput, Level level) {
        IntStream intStreamRange = IntStream.range(0, recipeInput.size());
        Objects.requireNonNull(recipeInput);
        return a(intStreamRange.mapToObj(recipeInput::getItem).toList(), this.a);
    }

    public boolean a(List<ItemStack> list, List<ItemStack> list2) {
        for (ItemStack itemStack : list2) {
            int count = itemStack.getCount();
            int count2 = 0;
            for (ItemStack itemStack2 : list) {
                if (ItemStack.isSameItemSameComponents(itemStack2, itemStack)) {
                    count2 += itemStack2.getCount();
                }
                if (count2 >= count) {
                    break;
                }
            }
            if (count2 < count) {
                return false;
            }
        }
        return true;
    }

    public ItemStack[] a(RecipeInput recipeInput) {
        ItemStack[] itemStackArr = new ItemStack[this.b.size()];
        for (int i = 0; i < this.b.size(); i++) {
            itemStackArr[i] = this.b.get(i).copy();
        }
        return itemStackArr;
    }

    public List<ItemStack> b() {
        return this.a;
    }

    public List<ItemStack> c() {
        return this.b;
    }

    public double d() {
        return this.c;
    }

    @Override // mctech.u.AbstractC0180h
    public int j() {
        return this.d;
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) E.n.get();
    }

    public RecipeType<?> getType() {
        return (RecipeType) E.m.get();
    }
}
