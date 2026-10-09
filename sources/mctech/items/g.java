package mctech.items;

import java.util.function.BiPredicate;
import java.util.function.IntConsumer;
import javax.annotation.Nonnull;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.neoforge.items.ComponentItemHandler;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g.class */
public class g extends ComponentItemHandler {

    @Nonnull
    private IntConsumer a;

    @Nonnull
    private BiPredicate<Integer, ItemStack> b;

    public g(MutableDataComponentHolder mutableDataComponentHolder, DataComponentType<ItemContainerContents> dataComponentType, int i) {
        super(mutableDataComponentHolder, dataComponentType, i);
        this.a = i2 -> {
        };
        this.b = (num, itemStack) -> {
            return true;
        };
    }

    public void a(@Nonnull IntConsumer intConsumer) {
        this.a = intConsumer;
    }

    public void a(@Nonnull BiPredicate<Integer, ItemStack> biPredicate) {
        this.b = biPredicate;
    }

    @Nonnull
    public BiPredicate<Integer, ItemStack> a() {
        return this.b;
    }

    public boolean isItemValid(int i, @NotNull ItemStack itemStack) {
        return this.b.test(Integer.valueOf(i), itemStack);
    }

    protected void onContentsChanged(int i, ItemStack itemStack, ItemStack itemStack2) {
        this.a.accept(i);
    }

    public void b() {
        this.parent.set(this.component, getContents());
    }
}
