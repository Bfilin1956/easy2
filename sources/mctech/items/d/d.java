package mctech.items.d;

import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import mctech.api.reactor.IReactor;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.SimulatedStack;
import mctech.init.MCTechFluids;
import net.minecraft.nbt.NumericTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/d.class */
public class d extends mctech.items.d.a.d {
    public d() {
        super(new mctech.items.base.o().b().c(2500));
    }

    @Override // mctech.api.reactor.IReactorComponent
    public void processChamber(ItemStack itemStack, IReactor iReactor, int i, int i2, boolean z, boolean z2) {
    }

    @Override // mctech.api.reactor.IReactorComponent
    public boolean acceptUraniumPulse(ItemStack itemStack, IReactor iReactor, ItemStack itemStack2, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int damage = (getDamage(itemStack) - 1) - (iReactor.getHeat() / 1000);
        if (damage <= 0) {
            iReactor.setStackInReactor(i, i2, MCTechFluids.FUEL.getCell().toStack());
            return true;
        }
        setDamage(itemStack, damage);
        return true;
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
        return 0.0f;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public SimulatedStack createSimulationComponent(ItemStack itemStack) {
        return new mctech.items.d.b.i((short) 52, getMaxDamage(itemStack), 1000);
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ReactorType getSupportedReactor(ItemStack itemStack) {
        return IReactorPlannerComponent.ReactorType.ELECTRIC;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ComponentType getType(ItemStack itemStack) {
        return IReactorPlannerComponent.ComponentType.ISOTOPE_CELL;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public List<IReactorPlannerComponent.ReactorStat> getStats(ItemStack itemStack) {
        ObjectList objectListI = mctech.utils.a.b.i();
        objectListI.add(IReactorPlannerComponent.ReactorStat.MAX_COMPONENT_DURABILITY);
        return objectListI;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public NumericTag getReactorStat(IReactorPlannerComponent.ReactorStat reactorStat, ItemStack itemStack) {
        if (reactorStat == IReactorPlannerComponent.ReactorStat.MAX_COMPONENT_DURABILITY) {
            return reactorStat.createStat(Integer.valueOf(getMaxDamage(itemStack)));
        }
        return NULL_VALUE;
    }
}
