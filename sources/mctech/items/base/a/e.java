package mctech.items.base.a;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/a/e.class */
public interface e {
    boolean a(ItemStack itemStack);

    DeferredHolder<SoundEvent, SoundEvent> b(ItemStack itemStack);
}
