package mctech.api.items.electric;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/electric/IMiningDrill.class */
public interface IMiningDrill {
    boolean canMineBlock(ItemStack itemStack, BlockState blockState, LevelReader levelReader, BlockPos blockPos);

    boolean canDrillBeUsed(ItemStack itemStack);

    void onDrillUsed(ItemStack itemStack);

    default int getMiningBoost(ItemStack itemStack, BlockState blockState) {
        return 0;
    }

    default int getExtraEnergyCost(ItemStack itemStack) {
        return 0;
    }
}
