package mctech.m.c;

import java.util.Objects;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/l.class */
public final class l {
    private final ItemStack a;
    private final int b;

    public l(ItemStack itemStack) {
        this.a = itemStack.copyWithCount(1);
        this.b = Objects.hash(Integer.valueOf(BuiltInRegistries.ITEM.getId(itemStack.getItem())), itemStack.getComponents());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        return ItemStack.isSameItemSameComponents(this.a, ((l) obj).a);
    }

    public int hashCode() {
        return this.b;
    }
}
