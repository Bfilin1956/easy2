package mctech.api.items.electric;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/electric/IScanner.class */
public interface IScanner {
    int getScanRadius(ItemStack itemStack, boolean z);

    boolean hasScanEffect(ItemStack itemStack);

    int getOreValue(ItemStack itemStack, BlockState blockState);

    default boolean isOreValuable(ItemStack itemStack, BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return getOreValue(itemStack, blockState) > 0;
    }

    default boolean isOreValuable(ItemStack itemStack, BlockState blockState) {
        return getOreValue(itemStack, blockState) > 0;
    }

    default int getOreValue(ItemStack itemStack, BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return getOreValue(itemStack, blockState);
    }
}
