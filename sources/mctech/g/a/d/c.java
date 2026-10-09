package mctech.g.a.d;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/d/c.class */
public class c {
    public static boolean a(@Nullable Player player) {
        if (player == null) {
            return true;
        }
        return a(player.getMainHandItem()) && a(player.getOffhandItem());
    }

    public static boolean a(ItemStack itemStack) {
        return !itemStack.is(mctech.g.d.d.a.b.a);
    }
}
