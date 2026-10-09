package mctech.u.e;

import mctech.utils.c.h;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/e/c.class */
public class c implements b {
    ItemStack a;
    int b;
    int c;
    b.a d;

    public c(ItemLike itemLike, int i, b.a aVar) {
        this(itemLike, i, i, aVar);
    }

    public c(ItemLike itemLike, int i, int i2, b.a aVar) {
        this(new ItemStack(itemLike), i, i2, aVar);
    }

    public c(ItemStack itemStack, int i, b.a aVar) {
        this(itemStack, i, i, aVar);
    }

    public c(ItemStack itemStack, int i, int i2, b.a aVar) {
        this.a = itemStack;
        this.b = i;
        this.c = i2;
        this.d = aVar;
    }

    @Override // mctech.u.e.b
    public ItemStack a(RandomSource randomSource) {
        return h.a(this.a, this.b == this.c ? this.b : this.b + randomSource.nextInt((this.c - this.b) + 1));
    }

    @Override // mctech.u.e.b
    public b.a a() {
        return this.d;
    }
}
