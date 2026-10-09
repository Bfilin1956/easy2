package mctech.items.d.a;

import mctech.api.reactor.IReactor;
import mctech.api.reactor.IReactorComponent;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/a/c.class */
public class c {
    public ItemStack a;
    public int b;
    public int c;

    public c(ItemStack itemStack, int i, int i2) {
        this.a = itemStack;
        this.b = i;
        this.c = i2;
    }

    public int a(IReactorComponent iReactorComponent, IReactor iReactor, int i) {
        return iReactorComponent.storeHeat(this.a, iReactor, this.b, this.c, i);
    }

    public int a(IReactorComponent iReactorComponent, IReactor iReactor, double d) {
        return (int) ((d * ((double) iReactorComponent.getMaxStoredHeat(this.a, iReactor, this.b, this.c))) - ((double) iReactorComponent.getStoredHeat(this.a, iReactor, this.b, this.c)));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/a/c$a.class */
    public static class a extends c {
        boolean d;

        public a(ItemStack itemStack, int i, int i2, boolean z) {
            super(itemStack, i, i2);
            this.d = z;
        }

        @Override // mctech.items.d.a.c
        public int a(IReactorComponent iReactorComponent, IReactor iReactor, double d) {
            int iA = super.a(iReactorComponent, iReactor, d);
            if ((iA > 0) != this.d) {
                return iA;
            }
            return 0;
        }
    }
}
