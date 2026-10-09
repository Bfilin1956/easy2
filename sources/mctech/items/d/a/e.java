package mctech.items.d.a;

import mctech.api.reactor.IReactor;
import mctech.items.base.o;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/a/e.class */
public abstract class e extends d {
    public e(o oVar) {
        super(oVar);
    }

    @Override // mctech.api.reactor.IReactorComponent
    public void processChamber(ItemStack itemStack, IReactor iReactor, int i, int i2, boolean z, boolean z2) {
    }

    @Override // mctech.api.reactor.IReactorComponent
    public boolean acceptUraniumPulse(ItemStack itemStack, IReactor iReactor, ItemStack itemStack2, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return false;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public boolean canStoreHeat(ItemStack itemStack, IReactor iReactor, int i, int i2) {
        return true;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public int getStoredHeat(ItemStack itemStack, IReactor iReactor, int i, int i2) {
        return getDamage(itemStack);
    }

    @Override // mctech.api.reactor.IReactorComponent
    public int getMaxStoredHeat(ItemStack itemStack, IReactor iReactor, int i, int i2) {
        return getMaxDamage(itemStack);
    }

    @Override // mctech.api.reactor.IReactorComponent
    public int storeHeat(ItemStack itemStack, IReactor iReactor, int i, int i2, int i3) {
        int maxDamage;
        int damage = getDamage(itemStack) + i3;
        if (damage > getMaxDamage(itemStack)) {
            iReactor.setStackInReactor(i, i2, ItemStack.EMPTY);
            maxDamage = (getMaxDamage(itemStack) - damage) + 1;
        } else {
            if (damage < 0) {
                maxDamage = damage;
                damage = 0;
            } else {
                maxDamage = 0;
            }
            setDamage(itemStack, damage);
        }
        return maxDamage;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public float getExplosionInfluence(ItemStack itemStack, IReactor iReactor) {
        return 0.0f;
    }

    @Override // mctech.api.reactor.IReactorComponent, mctech.api.reactor.IReactorProduct
    public boolean isValidForReactor(ItemStack itemStack, IReactor iReactor) {
        return true;
    }
}
