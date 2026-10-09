package mctech.m.c;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/q.class */
public class q implements g {
    private Item a;

    public q(ItemLike itemLike) {
        this.a = itemLike.asItem();
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        return itemStack.getItem() == this.a;
    }
}
