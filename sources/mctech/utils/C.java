package mctech.utils;

import it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/C.class */
public class C {

    @NotNull
    public final ItemStack a;
    public final IntSet b = new IntLinkedOpenHashSet();
    public int c;
    public int d;

    public C(@NotNull ItemStack itemStack, int i) {
        this.a = itemStack;
        a(i, itemStack);
    }

    public boolean a(ItemStack itemStack) {
        return ItemStack.isSameItemSameComponents(this.a, itemStack);
    }

    public void a(int i, @NotNull ItemStack itemStack) {
        this.b.add(i);
        this.c += itemStack.getCount();
        if (itemStack.getCount() > this.d) {
            this.d = itemStack.getCount();
        }
    }
}
