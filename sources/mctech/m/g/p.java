package mctech.m.g;

import java.util.function.BooleanSupplier;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/p.class */
public class p extends Slot {
    private BooleanSupplier a;

    public p(Container container, int i, int i2, int i3, BooleanSupplier booleanSupplier) {
        super(container, i, i2, i3);
        this.a = booleanSupplier;
    }

    public boolean mayPickup(Player player) {
        return !this.a.getAsBoolean() && super.mayPickup(player);
    }

    public boolean mayPlace(ItemStack itemStack) {
        return !this.a.getAsBoolean() && super.mayPlace(itemStack);
    }
}
