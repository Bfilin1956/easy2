package mctech.api.items;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/IAutoEatable.class */
public interface IAutoEatable {
    boolean canAutoEat(ItemStack itemStack);

    int getFoodValue(ItemStack itemStack);

    ItemStack onEaten(ItemStack itemStack, Level level, Player player);
}
