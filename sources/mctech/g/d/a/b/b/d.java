package mctech.g.d.a.b.b;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/b/d.class */
public class d extends mctech.g.d.a.b.c<ItemStack> {
    public d(Supplier<ItemStack> supplier, Consumer<ItemStack> consumer, int i, int i2, int i3) {
        super(supplier, consumer, i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.d.a.b.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ItemStack a() {
        return ItemStack.EMPTY;
    }

    @Override // mctech.g.d.a.b.c
    @NotNull
    public ItemStack getItem() {
        return b();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // mctech.g.d.a.b.c
    public ItemStack b(ItemStack itemStack) {
        return itemStack.copyWithCount(1);
    }

    @Override // mctech.g.d.a.b.c
    public Optional<ItemStack> a(ItemStack itemStack) {
        return Optional.of(itemStack);
    }
}
