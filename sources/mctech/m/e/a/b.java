package mctech.m.e.a;

import mctech.m.c.g;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/a/b.class */
public class b implements a {
    private final g a;

    public b(@NotNull g gVar) {
        this.a = gVar;
    }

    @Override // mctech.m.e.a.a
    public boolean matches(int i, ItemStack itemStack) {
        return this.a.matches(itemStack);
    }
}
