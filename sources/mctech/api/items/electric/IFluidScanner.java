package mctech.api.items.electric;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.FluidState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/electric/IFluidScanner.class */
public interface IFluidScanner {
    int getScanRadius(ItemStack itemStack, boolean z);

    boolean isValuableFluid(ItemStack itemStack, FluidState fluidState);

    default boolean isValuableFluid(ItemStack itemStack, FluidState fluidState, LevelReader levelReader, BlockPos blockPos) {
        return isValuableFluid(itemStack, fluidState);
    }
}
