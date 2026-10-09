package mctech.api.items.readers;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/readers/IWrenchTool.class */
public interface IWrenchTool {
    double getActualLoss(ItemStack itemStack, double d);

    default boolean shouldRenderOverlay(ItemStack itemStack) {
        return true;
    }
}
