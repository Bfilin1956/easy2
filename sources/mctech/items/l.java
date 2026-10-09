package mctech.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/l.class */
public class l extends Item {
    private final boolean a;

    public l(Item.Properties properties, boolean z) {
        super(properties);
        this.a = z;
    }

    public boolean isFoil(@NotNull ItemStack itemStack) {
        return this.a;
    }
}
