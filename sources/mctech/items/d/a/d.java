package mctech.items.d.a;

import java.util.function.BiPredicate;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.items.base.i;
import mctech.items.base.o;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/a/d.class */
public abstract class d extends i implements IReactorPlannerComponent {
    public d(o oVar) {
        super((oVar == null ? new o() : oVar).d().a(1).a(Rarity.UNCOMMON));
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public void addAffectedSlots(int i, int i2, BiPredicate<Integer, Integer> biPredicate) {
        biPredicate.test(Integer.valueOf(i), Integer.valueOf(i2));
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public void provideComponents(NonNullList<ItemStack> nonNullList) {
        nonNullList.add(new ItemStack(this));
    }

    public boolean isEnchantable(ItemStack itemStack) {
        return false;
    }
}
