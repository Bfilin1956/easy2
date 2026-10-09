package mctech.u.e;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/e/a.class */
public class a implements b {
    int a;
    int b;
    b.a c;

    public a(int i, b.a aVar) {
        this(i, i, aVar);
    }

    public a(int i, int i2, b.a aVar) {
        this.a = i;
        this.b = i2;
        this.c = aVar;
    }

    @Override // mctech.u.e.b
    public ItemStack a(RandomSource randomSource) {
        return new ItemStack(Items.EMERALD, this.a == this.b ? this.a : this.a + randomSource.nextInt((this.b - this.a) + 1));
    }

    @Override // mctech.u.e.b
    public b.a a() {
        return this.c;
    }
}
