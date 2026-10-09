package mctech.api.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/ICutterItem.class */
public interface ICutterItem {
    void cutInsulation(Player player, ItemStack itemStack, Level level, BlockPos blockPos);
}
