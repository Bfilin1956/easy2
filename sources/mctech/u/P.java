package mctech.u;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import java.util.List;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/P.class */
public final class P extends Record implements RecipeInput {
    private final List<ItemStack> a;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, P.class), P.class, "items", "FIELD:Lmctech/u/P;->a:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, P.class), P.class, "items", "FIELD:Lmctech/u/P;->a:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, P.class, Object.class), P.class, "items", "FIELD:Lmctech/u/P;->a:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public List<ItemStack> a() {
        return this.a;
    }

    public P(List<ItemStack> list) {
        this.a = list.stream().filter(itemStack -> {
            return !itemStack.isEmpty();
        }).toList();
    }

    @NotNull
    public ItemStack getItem(int i) {
        return a().get(i);
    }

    public int size() {
        return a().size();
    }

    public boolean a(List<ItemStack> list) {
        if (size() != list.size()) {
            return false;
        }
        HashMap map = new HashMap();
        for (ItemStack itemStack : this.a) {
            map.merge(itemStack.getItem(), Integer.valueOf(itemStack.getCount()), (v0, v1) -> {
                return Integer.sum(v0, v1);
            });
        }
        for (ItemStack itemStack2 : list) {
            Item item = itemStack2.getItem();
            int count = itemStack2.getCount();
            if (!map.containsKey(item) || ((Integer) map.get(item)).intValue() < count) {
                return false;
            }
            map.put(item, Integer.valueOf(((Integer) map.get(item)).intValue() - count));
        }
        return true;
    }
}
