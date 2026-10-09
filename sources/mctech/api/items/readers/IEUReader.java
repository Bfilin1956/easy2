package mctech.api.items.readers;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/readers/IEUReader.class */
public interface IEUReader {
    boolean isEUReader(ItemStack itemStack);

    static boolean isEUReaderImpl(ItemStack itemStack) {
        return (itemStack.getItem() instanceof IEUReader) && itemStack.getItem().isEUReader(itemStack);
    }
}
