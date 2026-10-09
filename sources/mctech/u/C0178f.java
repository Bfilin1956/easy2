package mctech.u;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.u.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/f.class */
public final class C0178f extends Record implements RecipeInput {
    private final mctech.fluid.h<?> a;
    private final List<ItemStack> b;
    private final List<ItemStack> c;

    public C0178f(mctech.fluid.h<?> hVar, List<ItemStack> list, List<ItemStack> list2) {
        this.a = hVar;
        this.b = list;
        this.c = list2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0178f.class), C0178f.class, "inputTank;inputs;consumables", "FIELD:Lmctech/u/f;->a:Lmctech/fluid/h;", "FIELD:Lmctech/u/f;->b:Ljava/util/List;", "FIELD:Lmctech/u/f;->c:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0178f.class), C0178f.class, "inputTank;inputs;consumables", "FIELD:Lmctech/u/f;->a:Lmctech/fluid/h;", "FIELD:Lmctech/u/f;->b:Ljava/util/List;", "FIELD:Lmctech/u/f;->c:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0178f.class, Object.class), C0178f.class, "inputTank;inputs;consumables", "FIELD:Lmctech/u/f;->a:Lmctech/fluid/h;", "FIELD:Lmctech/u/f;->b:Ljava/util/List;", "FIELD:Lmctech/u/f;->c:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public mctech.fluid.h<?> a() {
        return this.a;
    }

    public List<ItemStack> b() {
        return this.b;
    }

    public List<ItemStack> c() {
        return this.c;
    }

    public ItemStack getItem(int i) {
        return b().get(i);
    }

    public int size() {
        return b().size();
    }

    public boolean a(@NotNull C0177e c0177e) {
        boolean z = FluidStack.isSameFluid(a().getFluid(), c0177e.b()) && a().getFluidAmount() >= c0177e.b().getAmount();
        ArrayList arrayList = new ArrayList(c0177e.a());
        for (ItemStack itemStack : b()) {
            arrayList.removeIf(itemStack2 -> {
                return ItemStack.isSameItem(itemStack2, itemStack) && itemStack.getCount() >= itemStack2.getCount();
            });
        }
        return arrayList.isEmpty() && z;
    }
}
