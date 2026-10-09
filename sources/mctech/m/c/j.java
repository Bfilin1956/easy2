package mctech.m.c;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/j.class */
public class j implements g {
    Ingredient a;
    ItemStack b;
    boolean c;

    public j(Ingredient ingredient, ItemStack itemStack, boolean z) {
        this.a = ingredient;
        this.b = itemStack;
        this.c = z;
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        return this.a.test(itemStack) && (!this.c || mctech.utils.c.h.a(this.b, itemStack, false));
    }

    public Ingredient a() {
        return this.a;
    }

    public ItemStack b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }
}
