package mctech.api.items;

import mctech.items.g.b.a;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/IHudDisplayable.class */
public interface IHudDisplayable {
    default float getDurabilityPercent(ItemStack itemStack) {
        if (this instanceof a) {
            a aVar = (a) this;
            int charge = aVar.getCharge(itemStack);
            int capacity = aVar.getCapacity(itemStack);
            if (capacity > 0) {
                return charge / capacity;
            }
            return 0.0f;
        }
        if (itemStack.isDamaged()) {
            return (itemStack.getMaxDamage() - itemStack.getDamageValue()) / itemStack.getMaxDamage();
        }
        return 1.0f;
    }

    default int getDurabilityBarColor(ItemStack itemStack) {
        if (this instanceof a) {
            return ((a) this).getBarColor(itemStack);
        }
        float durabilityPercent = getDurabilityPercent(itemStack);
        if (durabilityPercent > 0.66f) {
            return -16711936;
        }
        return durabilityPercent > 0.33f ? -256 : -65536;
    }

    default boolean shouldRenderInHUD(ItemStack itemStack) {
        return !itemStack.isEmpty();
    }
}
