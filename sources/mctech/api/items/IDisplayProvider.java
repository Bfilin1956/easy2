package mctech.api.items;

import java.util.function.Consumer;
import mctech.api.tiles.display.IDisplayInfo;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/IDisplayProvider.class */
public interface IDisplayProvider {
    void provideInfo(ItemStack itemStack, Consumer<IDisplayInfo> consumer);
}
