package mctech.m.f;

import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/a.class */
public class a implements IItemHandler {
    protected final IItemHandler[] a;
    protected final int[] b;
    protected final int c;

    public a(List<IItemHandler> list) {
        this((IItemHandler[]) list.toArray(new IItemHandler[list.size()]));
    }

    public a(IItemHandler... iItemHandlerArr) {
        this.a = iItemHandlerArr;
        this.b = new int[iItemHandlerArr.length];
        int slots = 0;
        for (int i = 0; i < iItemHandlerArr.length; i++) {
            slots += iItemHandlerArr[i].getSlots();
            this.b[i] = slots;
        }
        this.c = slots;
    }

    protected int a(int i) {
        if (i < 0) {
            return -1;
        }
        for (int i2 = 0; i2 < this.b.length; i2++) {
            if (i - this.b[i2] < 0) {
                return i2;
            }
        }
        return -1;
    }

    protected IItemHandler b(int i) {
        if (i < 0 || i >= this.a.length) {
            return mctech.m.e.c.a;
        }
        return this.a[i];
    }

    protected int a(int i, int i2) {
        if (i2 <= 0 || i2 >= this.b.length) {
            return i;
        }
        return i - this.b[i2 - 1];
    }

    public int getSlots() {
        return this.c;
    }

    @Nonnull
    public ItemStack getStackInSlot(int i) {
        int iA = a(i);
        return b(iA).getStackInSlot(a(i, iA));
    }

    @Nonnull
    public ItemStack insertItem(int i, @Nonnull ItemStack itemStack, boolean z) {
        int iA = a(i);
        return b(iA).insertItem(a(i, iA), itemStack, z);
    }

    @Nonnull
    public ItemStack extractItem(int i, int i2, boolean z) {
        int iA = a(i);
        return b(iA).extractItem(a(i, iA), i2, z);
    }

    public int getSlotLimit(int i) {
        int iA = a(i);
        return b(iA).getSlotLimit(a(i, iA));
    }

    public boolean isItemValid(int i, @Nonnull ItemStack itemStack) {
        int iA = a(i);
        return b(iA).isItemValid(a(i, iA), itemStack);
    }
}
