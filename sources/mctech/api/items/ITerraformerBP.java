package mctech.api.items;

import mctech.api.tiles.ITerraformer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/ITerraformerBP.class */
public interface ITerraformerBP {
    boolean canInsert(ItemStack itemStack, Player player, Level level, BlockPos blockPos);

    void onInsert(ItemStack itemStack, Player player, Level level, BlockPos blockPos);

    boolean isRandomized(ItemStack itemStack);

    int getEnergyUsage(ItemStack itemStack);

    int getRadius(ItemStack itemStack);

    boolean terraform(ItemStack itemStack, Level level, BlockPos blockPos, ITerraformer iTerraformer);
}
