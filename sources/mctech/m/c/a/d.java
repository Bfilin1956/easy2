package mctech.m.c.a;

import mctech.blockentities.c.C0067n;
import mctech.u.C0190r;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/a/d.class */
public class d extends a<C0067n, C0190r> {
    public d(C0067n c0067n) {
        super(c0067n);
    }

    @Override // mctech.m.c.a.a
    protected RecipeType<C0190r> b() {
        return ((C0067n) this.a).getRecipeType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.m.c.a.a
    public ItemStack a(C0190r c0190r) {
        return c0190r.e();
    }
}
