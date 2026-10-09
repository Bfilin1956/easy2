package mctech.m.g;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/n.class */
public interface n {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/n$a.class */
    public enum a {
        FILTER,
        NORMAL
    }

    int ad_();

    int b();

    int c();

    boolean b(ItemStack itemStack);

    void a(ItemStack itemStack);

    default a ae_() {
        return a.NORMAL;
    }
}
