package mctech.api.blocks;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/IRarityProvider.class */
public interface IRarityProvider {
    Rarity getRarity(ItemStack itemStack);
}
