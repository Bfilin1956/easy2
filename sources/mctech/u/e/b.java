package mctech.u.e;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/e/b.class */
public interface b {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/e/b$a.class */
    public enum a {
        MAIN,
        SUB,
        OUT
    }

    ItemStack a(RandomSource randomSource);

    a a();

    static b a(int i, a aVar) {
        return new mctech.u.e.a(i, aVar);
    }

    static b a(int i, int i2, a aVar) {
        return new mctech.u.e.a(i, i2, aVar);
    }

    static b a(ItemLike itemLike, a aVar) {
        return new c(itemLike, 1, aVar);
    }

    static b a(ItemLike itemLike, int i, a aVar) {
        return new c(itemLike, i, aVar);
    }

    static b a(ItemLike itemLike, int i, int i2, a aVar) {
        return new c(itemLike, i, i2, aVar);
    }

    static b a(ItemStack itemStack, a aVar) {
        return new c(itemStack, 1, aVar);
    }

    static b a(ItemStack itemStack, int i, a aVar) {
        return new c(itemStack, i, aVar);
    }

    static b a(ItemStack itemStack, int i, int i2, a aVar) {
        return new c(itemStack, i, i2, aVar);
    }
}
