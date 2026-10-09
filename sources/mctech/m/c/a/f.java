package mctech.m.c.a;

import mctech.m.c.k;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/a/f.class */
public class f implements mctech.m.c.g {
    public static final mctech.m.c.g a = new f(true);
    public static final mctech.m.c.g b = new f(false);
    public static final mctech.m.c.g c = new k(a);
    public static final mctech.m.c.g d = new k(b);
    private boolean e;

    public f(boolean z) {
        this.e = z;
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        return (this.e && itemStack.getItem() == Items.LAVA_BUCKET) || itemStack.getBurnTime(RecipeType.SMELTING) > 0;
    }
}
