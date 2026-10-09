package mctech.m.c;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.Set;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/p.class */
public class p implements g {
    Set<Item> a;
    boolean b;

    public p(Item... itemArr) {
        this((Set<Item>) new ObjectOpenHashSet(itemArr), true);
    }

    public p(boolean z, Item... itemArr) {
        this((Set<Item>) new ObjectOpenHashSet(itemArr), z);
    }

    public p(Set<Item> set, boolean z) {
        this.a = set;
        this.b = z;
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        return !itemStack.isEmpty() && this.a.contains(itemStack.getItem()) == this.b;
    }
}
