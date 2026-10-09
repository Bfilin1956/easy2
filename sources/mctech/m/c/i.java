package mctech.m.c;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/i.class */
public class i implements g {
    Ingredient a;

    public i(Ingredient ingredient) {
        this.a = ingredient;
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        return this.a.test(itemStack);
    }
}
