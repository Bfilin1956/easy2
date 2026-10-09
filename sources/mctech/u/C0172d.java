package mctech.u;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mctech.init.MCTechRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.u.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/d.class */
public class C0172d implements Recipe<C0171c> {
    private final Map<String, ItemStack> a;
    private final List<ItemStack> b;
    private final List<String> c;
    private final List<FluidStack> d;
    private final List<String> e;
    private final int f;
    private final int g;
    private final float h;
    private final ItemStack i;

    public C0172d(Map<String, ItemStack> map, List<String> list, List<ItemStack> list2, List<FluidStack> list3, List<String> list4, int i, int i2, float f, ItemStack itemStack) {
        this.a = map;
        this.b = list2;
        this.c = list;
        this.d = list3;
        this.e = list4;
        this.f = i;
        this.g = i2;
        this.h = f;
        this.i = itemStack;
    }

    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(Ingredient.of(), new Ingredient[]{Ingredient.of((ItemStack[]) l().toArray(new ItemStack[0]))});
    }

    public Map<String, ItemStack> a() {
        return this.a;
    }

    public List<String> b() {
        return this.c;
    }

    public List<ItemStack> c() {
        return this.b;
    }

    public List<FluidStack> d() {
        return this.d;
    }

    public List<String> e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public float h() {
        return this.h;
    }

    public ItemStack i() {
        return this.i;
    }

    public int j() {
        return ((String) this.c.getFirst()).length();
    }

    public int k() {
        return this.c.size();
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean matches(@NotNull C0171c c0171c, @NotNull Level level) {
        mctech.items.b.c.a aVarA;
        boolean zA = m() ? a(c0171c) : b(c0171c);
        HashMap map = new HashMap();
        mctech.items.b.c cVarA = mctech.items.b.c.a();
        List<ItemStack> list = c0171c.b().stream().filter(itemStack -> {
            return !itemStack.isEmpty();
        }).toList();
        Iterator<String> it = this.e.iterator();
        while (it.hasNext()) {
            ResourceLocation resourceLocationBySeparator = ResourceLocation.bySeparator(it.next(), ':');
            map.put(resourceLocationBySeparator.getPath(), false);
            if (cVarA.b(resourceLocationBySeparator) && (aVarA = cVarA.a(resourceLocationBySeparator)) != null) {
                Iterator<ItemStack> it2 = list.iterator();
                while (it2.hasNext()) {
                    if (aVarA.a(it2.next().getItem())) {
                        map.replace(resourceLocationBySeparator.getPath(), true);
                    }
                }
            }
        }
        boolean zAllMatch = map.values().stream().allMatch(bool -> {
            return bool.booleanValue();
        });
        if (this.d.size() > 2) {
            return false;
        }
        return zA && zAllMatch && (this.d.isEmpty() || this.d.stream().allMatch(fluidStack -> {
            for (mctech.fluid.g gVar : c0171c.c()) {
                if (!gVar.isEmpty() && FluidStack.isSameFluidSameComponents(gVar.getFluid(), fluidStack)) {
                    return true;
                }
            }
            return false;
        }));
    }

    private boolean a(@NotNull C0171c c0171c) {
        if (this.b == null) {
            return false;
        }
        List<ItemStack> listA = c0171c.a();
        ArrayList arrayList = new ArrayList(this.b);
        for (ItemStack itemStack : listA) {
            arrayList.removeIf(itemStack2 -> {
                return ItemStack.isSameItemSameComponents(itemStack2, itemStack) && itemStack.getCount() >= itemStack2.getCount();
            });
        }
        return arrayList.isEmpty();
    }

    private boolean b(@NotNull C0171c c0171c) {
        if (this.a == null || this.c == null) {
            return false;
        }
        List<ItemStack> listA = c0171c.a();
        if (listA.size() != 12) {
            return false;
        }
        int length = ((String) this.c.getFirst()).length();
        int size = this.c.size();
        for (int i = 0; i <= 3 - size; i++) {
            for (int i2 = 0; i2 <= 4 - length; i2++) {
                if (a(listA, i2, i, length, size)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(List<ItemStack> list, int i, int i2, int i3, int i4) {
        int i5 = 0;
        while (i5 < 3) {
            int i6 = 0;
            while (i6 < 4) {
                ItemStack itemStack = list.get((i5 * 4) + i6);
                if (i6 >= i && i6 < i + i3 && i5 >= i2 && i5 < i2 + i4) {
                    char cCharAt = this.c.get(i5 - i2).charAt(i6 - i);
                    if (cCharAt == ' ') {
                        if (!itemStack.isEmpty()) {
                            return false;
                        }
                    } else {
                        ItemStack itemStack2 = this.a.get(String.valueOf(cCharAt));
                        if (itemStack2 == null || !ItemStack.isSameItemSameComponents(itemStack2, itemStack) || itemStack.getCount() < itemStack2.getCount()) {
                            return false;
                        }
                    }
                } else if (!itemStack.isEmpty()) {
                    return false;
                }
                i6++;
            }
            i5++;
        }
        return true;
    }

    public List<ItemStack> l() {
        if (!m()) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = this.c.iterator();
            while (it.hasNext()) {
                for (char c : it.next().toCharArray()) {
                    if (c != ' ') {
                        arrayList.add(this.a.get(String.valueOf(c)));
                    }
                }
            }
            return arrayList;
        }
        return this.b;
    }

    public boolean m() {
        return (this.a == null || this.a.isEmpty()) && (this.c == null || this.c.isEmpty());
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ItemStack assemble(@NotNull C0171c c0171c, HolderLookup.Provider provider) {
        return this.i.copy();
    }

    public boolean canCraftInDimensions(int i, int i2) {
        return true;
    }

    @NotNull
    public ItemStack getResultItem(@NotNull HolderLookup.Provider provider) {
        return n();
    }

    public ItemStack n() {
        return this.i.copy();
    }

    @NotNull
    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer) MCTechRecipes.REGISTERED_SERIALIZERS.get(mctech.i.i.ASSEMBLY_STATION.getSerializedName()).get();
    }

    @NotNull
    public RecipeType<?> getType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get(mctech.i.i.ASSEMBLY_STATION.getSerializedName()).get();
    }
}
