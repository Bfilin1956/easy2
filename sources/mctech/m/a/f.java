package mctech.m.a;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/a/f.class */
public interface f extends e {
    i a(Player player, ItemStack itemStack, Slot slot);

    default boolean a_(ItemStack itemStack) {
        return true;
    }
}
