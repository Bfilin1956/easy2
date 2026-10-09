package mctech.api.reactor;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/reactor/IReactorComponent.class */
public interface IReactorComponent extends IReactorProduct {
    void processChamber(ItemStack itemStack, IReactor iReactor, int i, int i2, boolean z, boolean z2);

    boolean acceptUraniumPulse(ItemStack itemStack, IReactor iReactor, ItemStack itemStack2, int i, int i2, int i3, int i4, boolean z, boolean z2);

    boolean canStoreHeat(ItemStack itemStack, IReactor iReactor, int i, int i2);

    int getStoredHeat(ItemStack itemStack, IReactor iReactor, int i, int i2);

    int getMaxStoredHeat(ItemStack itemStack, IReactor iReactor, int i, int i2);

    int storeHeat(ItemStack itemStack, IReactor iReactor, int i, int i2, int i3);

    float getExplosionInfluence(ItemStack itemStack, IReactor iReactor);

    @Override // mctech.api.reactor.IReactorProduct
    default boolean isValidForReactor(ItemStack itemStack, IReactor iReactor) {
        return true;
    }
}
