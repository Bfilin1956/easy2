package mctech.g.d.e;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/e/a.class */
public final class a {
    public static boolean a(Level level, Player player, ItemStack itemStack, BlockPos blockPos) {
        BlockState blockState = level.getBlockState(blockPos);
        boolean zOnDestroyedByPlayer = blockState.onDestroyedByPlayer(level, blockPos, player, true, level.getFluidState(blockPos));
        if (zOnDestroyedByPlayer) {
            blockState.getBlock().destroy(level, blockPos, blockState);
            blockState.getBlock().playerDestroy(level, player, blockPos, blockState, (BlockEntity) null, itemStack);
        }
        return zOnDestroyedByPlayer;
    }
}
