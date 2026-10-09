package mctech.api.items;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/IRepairable.class */
public interface IRepairable extends ItemLike {
    boolean repairDamage(ItemStack itemStack, int i);
}
