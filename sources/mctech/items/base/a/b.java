package mctech.items.base.a;

import java.util.Iterator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/a/b.class */
public interface b {
    boolean a(ItemStack itemStack);

    boolean b(ItemStack itemStack);

    Iterator<BlockPos> a(ItemStack itemStack, Player player, BlockPos blockPos, Direction direction);
}
