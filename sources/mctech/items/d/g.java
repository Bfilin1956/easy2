package mctech.items.d;

import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import mctech.api.reactor.IReactor;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.SimulatedStack;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/g.class */
public class g extends mctech.items.d.a.d {
    public g() {
        super(new mctech.items.base.o().b().a(64));
    }

    @Override // mctech.api.reactor.IReactorComponent
    public void processChamber(ItemStack itemStack, IReactor iReactor, int i, int i2, boolean z, boolean z2) {
        if (iReactor.getHeat() >= 1000 * itemStack.getCount()) {
            return;
        }
        iReactor.addHeat(itemStack.getCount());
    }

    @Override // mctech.api.reactor.IReactorComponent
    public boolean acceptUraniumPulse(ItemStack itemStack, IReactor iReactor, ItemStack itemStack2, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return false;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public boolean canStoreHeat(ItemStack itemStack, IReactor iReactor, int i, int i2) {
        return false;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public int getStoredHeat(ItemStack itemStack, IReactor iReactor, int i, int i2) {
        return 0;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public int getMaxStoredHeat(ItemStack itemStack, IReactor iReactor, int i, int i2) {
        return 0;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public int storeHeat(ItemStack itemStack, IReactor iReactor, int i, int i2, int i3) {
        return 0;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public float getExplosionInfluence(ItemStack itemStack, IReactor iReactor) {
        return itemStack.getCount() / 10.0f;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public SimulatedStack createSimulationComponent(ItemStack itemStack) {
        return new mctech.items.d.b.e((short) 17, itemStack.getCount());
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ReactorType getSupportedReactor(ItemStack itemStack) {
        return IReactorPlannerComponent.ReactorType.ELECTRIC;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ComponentType getType(ItemStack itemStack) {
        return IReactorPlannerComponent.ComponentType.HEAT_PACK;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public List<IReactorPlannerComponent.ReactorStat> getStats(ItemStack itemStack) {
        ObjectList objectListI = mctech.utils.a.b.i();
        objectListI.add(IReactorPlannerComponent.ReactorStat.HEAT_PRODUCTION);
        return objectListI;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public NumericTag getReactorStat(IReactorPlannerComponent.ReactorStat reactorStat, ItemStack itemStack) {
        if (reactorStat == IReactorPlannerComponent.ReactorStat.HEAT_PRODUCTION) {
            return IntTag.valueOf(itemStack.getCount());
        }
        return NULL_VALUE;
    }
}
