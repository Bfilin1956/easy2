package mctech.api.recipes.ingridients.queue;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/recipes/ingridients/queue/SimpleStackOutput.class */
public class SimpleStackOutput implements IStackOutput {
    ItemStack output;
    int slot;

    public SimpleStackOutput(CompoundTag compoundTag) {
    }

    public SimpleStackOutput(ItemStack itemStack, int i) {
        this.output = itemStack;
        this.slot = i;
    }

    @Override // mctech.api.recipes.ingridients.queue.IStackOutput
    public boolean addToInventory(IInputter iInputter) {
        iInputter.addItemIntoSlot(this.slot, this.output);
        return false;
    }

    @Override // mctech.api.recipes.ingridients.queue.IStackOutput
    public ItemStack getStack() {
        return this.output;
    }

    @Override // mctech.api.recipes.ingridients.queue.IStackOutput
    public void save(CompoundTag compoundTag) {
    }
}
