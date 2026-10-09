package mctech.m.e;

import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/h.class */
public class h implements IItemHandler {
    private final i a;
    private final IntList b;

    public h(i iVar) {
        this.a = iVar;
        this.b = iVar.h();
    }

    public int getSlots() {
        return this.b.size();
    }

    @NotNull
    public ItemStack getStackInSlot(int i) {
        return this.a.a().getStackInSlot(this.b.getInt(i));
    }

    @NotNull
    public ItemStack insertItem(int i, ItemStack itemStack, boolean z) {
        return itemStack;
    }

    @NotNull
    public ItemStack extractItem(int i, int i2, boolean z) {
        return ItemStack.EMPTY;
    }

    public int getSlotLimit(int i) {
        return 64;
    }

    public boolean isItemValid(int i, @NotNull ItemStack itemStack) {
        return false;
    }
}
