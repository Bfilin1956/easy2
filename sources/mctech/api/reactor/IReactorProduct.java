package mctech.api.reactor;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/reactor/IReactorProduct.class */
public interface IReactorProduct {
    boolean isValidForReactor(ItemStack itemStack, IReactor iReactor);
}
