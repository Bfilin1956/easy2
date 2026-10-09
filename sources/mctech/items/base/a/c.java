package mctech.items.base.a;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/a/c.class */
public interface c {
    boolean a(ItemStack itemStack);

    int b(ItemStack itemStack);

    void a(ItemStack itemStack, int i);

    int c(ItemStack itemStack);

    boolean a(ItemStack itemStack, ItemStack itemStack2);

    a[] a(ItemStack itemStack, boolean z, HolderLookup.Provider provider);

    boolean a(ItemStack itemStack, int i, int i2, ItemStack itemStack2, HolderLookup.Provider provider);

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/a/c$a.class */
    public static class a {
        int a;
        ItemStack b;

        public a(int i, NonNullList<ItemStack> nonNullList) {
            this(i, (ItemStack) nonNullList.get(i));
        }

        public a(int i, ItemStack itemStack) {
            this.a = i;
            this.b = itemStack;
        }

        public int a() {
            return this.a;
        }

        public ItemStack b() {
            return this.b;
        }
    }
}
