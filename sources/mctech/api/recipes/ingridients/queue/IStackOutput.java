package mctech.api.recipes.ingridients.queue;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/recipes/ingridients/queue/IStackOutput.class */
public interface IStackOutput {
    boolean addToInventory(IInputter iInputter);

    ItemStack getStack();

    void save(CompoundTag compoundTag);
}
