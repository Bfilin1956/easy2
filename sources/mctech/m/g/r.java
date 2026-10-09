package mctech.m.g;

import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/r.class */
public class r extends x implements mctech.m.a.j {
    public r(mctech.m.a.g gVar, int i, int i2, int i3) {
        super(gVar, i, i2, i3);
    }

    public boolean mayPlace(@NotNull ItemStack itemStack) {
        return false;
    }

    @Override // mctech.m.g.x
    @NotNull
    public ItemStack remove(int i) {
        ItemStack item = getItem();
        if (item.isEmpty()) {
            return ItemStack.EMPTY;
        }
        return super.remove(Math.min(i, item.getMaxStackSize()));
    }
}
