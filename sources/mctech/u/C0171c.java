package mctech.u;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.u.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/c.class */
public final class C0171c extends Record implements RecipeInput {
    private final List<ItemStack> a;
    private final List<ItemStack> b;
    private final mctech.fluid.g[] c;

    public C0171c(List<ItemStack> list, List<ItemStack> list2, mctech.fluid.g... gVarArr) {
        this.a = list;
        this.b = list2;
        this.c = gVarArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0171c.class), C0171c.class, "craftingMatrix;consumables;fluidTanks", "FIELD:Lmctech/u/c;->a:Ljava/util/List;", "FIELD:Lmctech/u/c;->b:Ljava/util/List;", "FIELD:Lmctech/u/c;->c:[Lmctech/fluid/g;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0171c.class), C0171c.class, "craftingMatrix;consumables;fluidTanks", "FIELD:Lmctech/u/c;->a:Ljava/util/List;", "FIELD:Lmctech/u/c;->b:Ljava/util/List;", "FIELD:Lmctech/u/c;->c:[Lmctech/fluid/g;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0171c.class, Object.class), C0171c.class, "craftingMatrix;consumables;fluidTanks", "FIELD:Lmctech/u/c;->a:Ljava/util/List;", "FIELD:Lmctech/u/c;->b:Ljava/util/List;", "FIELD:Lmctech/u/c;->c:[Lmctech/fluid/g;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public List<ItemStack> b() {
        return this.b;
    }

    public mctech.fluid.g[] c() {
        return this.c;
    }

    @NotNull
    public ItemStack getItem(int i) {
        return this.a.get(i);
    }

    public int size() {
        return a().size();
    }

    public List<ItemStack> a() {
        return this.a;
    }

    public boolean isEmpty() {
        return a().stream().allMatch((v0) -> {
            return v0.isEmpty();
        });
    }
}
