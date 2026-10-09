package mctech.api.items;

import java.util.List;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/ITagBlock.class */
public interface ITagBlock {
    boolean matches(ItemStack itemStack, Block block);

    List<Block> getBlocks(ItemStack itemStack);
}
