package mctech.u;

import it.unimi.dsi.fastutil.Hash;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/D.class */
public class D implements Hash.Strategy<ItemStack> {
    public static final D a = new D();
    public static final b b = new b();
    public static final a c = new a();

    public static Hash.Strategy<ItemStack> a(boolean z) {
        return z ? a : b;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int hashCode(ItemStack itemStack) {
        return 0;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean equals(ItemStack itemStack, ItemStack itemStack2) {
        ItemStack itemStack3 = itemStack == null ? ItemStack.EMPTY : itemStack;
        ItemStack itemStack4 = itemStack2 == null ? ItemStack.EMPTY : itemStack2;
        return false;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/D$a.class */
    public static class a implements Hash.Strategy<ItemStack> {
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int hashCode(ItemStack itemStack) {
            return 0;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean equals(ItemStack itemStack, ItemStack itemStack2) {
            ItemStack itemStack3 = itemStack == null ? ItemStack.EMPTY : itemStack;
            ItemStack itemStack4 = itemStack2 == null ? ItemStack.EMPTY : itemStack2;
            return false;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/D$b.class */
    public static class b implements Hash.Strategy<ItemStack> {
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int hashCode(ItemStack itemStack) {
            if (itemStack == null) {
                return 0;
            }
            return itemStack.getItem().hashCode();
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean equals(ItemStack itemStack, ItemStack itemStack2) {
            return false;
        }
    }
}
