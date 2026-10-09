package mctech.m.a;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/a/g.class */
public interface g {
    int getSlotCount();

    ItemStack getStackInSlot(int i);

    void setStackInSlot(int i, ItemStack itemStack);

    int getMaxStackSize(int i);

    boolean canInsert(int i, ItemStack itemStack);

    boolean canExtract(int i, ItemStack itemStack);

    default void setStackInSlotSilent(int i, ItemStack itemStack) {
        setStackInSlot(i, itemStack);
    }

    default void markInventoryChanged() {
    }

    default void setSlotCount(int i) {
    }

    default void updateInventory(NonNullList<ItemStack> nonNullList) {
    }

    default Stream<ItemStack> T_() {
        return IntStream.range(0, getSlotCount()).mapToObj(this::getStackInSlot);
    }

    default Stream<ItemStack> U_() {
        return T_().filter(itemStack -> {
            return !itemStack.isEmpty();
        });
    }
}
