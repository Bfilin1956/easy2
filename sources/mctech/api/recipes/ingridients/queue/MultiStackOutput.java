package mctech.api.recipes.ingridients.queue;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/recipes/ingridients/queue/MultiStackOutput.class */
public class MultiStackOutput implements IStackOutput {
    ItemStack output;
    int[] slots;

    public MultiStackOutput(CompoundTag compoundTag) {
    }

    public MultiStackOutput(ItemStack itemStack, int... iArr) {
        this.output = itemStack;
        this.slots = iArr;
    }

    @Override // mctech.api.recipes.ingridients.queue.IStackOutput
    public boolean addToInventory(IInputter iInputter) {
        for (int i : this.slots) {
            iInputter.addItemIntoSlot(i, this.output);
        }
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
