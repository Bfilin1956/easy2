package mctech.g.d.a.b.b.a;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/b/a/d.class */
public class d extends mctech.g.d.a.b.b.d {
    public d(Supplier<ItemStack> supplier, Consumer<ItemStack> consumer, int i, int i2, int i3) {
        super(supplier, consumer, i, i2, i3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // mctech.g.d.a.b.b.d, mctech.g.d.a.b.c
    public ItemStack b(ItemStack itemStack) {
        return itemStack.copy();
    }
}
