package mctech.m.c.a;

import mctech.blockentities.c.D;
import mctech.u.J;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/a/h.class */
public class h extends a<D, J> {
    public h(D d) {
        super(d);
    }

    @Override // mctech.m.c.a.a
    protected RecipeType<J> b() {
        return ((D) this.a).getRecipeType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.m.c.a.a
    public ItemStack a(J j) {
        return j.b();
    }
}
