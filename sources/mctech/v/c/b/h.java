package mctech.v.c.b;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/b/h.class */
public interface h extends c {
    @Override // mctech.v.c.b.c
    default boolean a(ItemStack itemStack) {
        return true;
    }

    @Override // mctech.v.c.b.c
    default ResourceLocation b(ItemStack itemStack) {
        return ResourceLocation.parse("minecraft:models/item/handheld");
    }
}
