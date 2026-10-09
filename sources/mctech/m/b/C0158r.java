package mctech.m.b;

import java.util.Arrays;
import mctech.api.items.Consumables;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: renamed from: mctech.m.b.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/r.class */
public class C0158r implements mctech.m.c.g {
    private final Consumables[] a;

    public C0158r() {
        this.a = null;
    }

    public C0158r(Consumables... consumablesArr) {
        this.a = consumablesArr;
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        mctech.items.b.c cVarA = mctech.items.b.c.a();
        if (this.a != null) {
            return Arrays.stream(this.a).anyMatch(consumables -> {
                return cVarA.a(itemStack, consumables.getName());
            });
        }
        return cVarA.a(itemStack);
    }
}
