package mctech.u.e;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/e/d.class */
public class d implements VillagerTrades.ItemListing {
    b[] a;
    int b;
    int c;
    float d;

    public d(b... bVarArr) {
        this(16, 5, 0.05f, bVarArr);
    }

    public d(int i, int i2, float f, b... bVarArr) {
        this.a = new b[3];
        this.b = i;
        this.c = i2;
        this.d = f;
        for (b bVar : bVarArr) {
            this.a[bVar.a().ordinal()] = bVar;
        }
    }

    public ItemStack a(b.a aVar, RandomSource randomSource) {
        return this.a[aVar.ordinal()] == null ? ItemStack.EMPTY : this.a[aVar.ordinal()].a(randomSource);
    }

    public MerchantOffer getOffer(Entity entity, RandomSource randomSource) {
        ItemStack itemStackA = a(b.a.MAIN, randomSource);
        return new MerchantOffer(new ItemCost(itemStackA.getItem(), itemStackA.getCount()), a(b.a.OUT, randomSource), this.b, this.c, this.d);
    }
}
