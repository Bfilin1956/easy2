package mctech.m.c.a;

import mctech.blockentities.c.C0063j;
import mctech.u.C0187o;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/a/b.class */
public class b extends a<C0063j, C0187o> {
    public b(C0063j c0063j) {
        super(c0063j);
    }

    @Override // mctech.m.c.a.a
    protected RecipeType<C0187o> b() {
        return ((C0063j) this.a).getRecipeType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.m.c.a.a
    public ItemStack a(C0187o c0187o) {
        return c0187o.b();
    }

    @Deprecated
    public void c() {
        a();
    }
}
