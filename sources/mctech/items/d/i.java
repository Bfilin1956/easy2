package mctech.items.d;

import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.SimulatedStack;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/i.class */
public class i extends mctech.items.d.a.e {
    private short a;

    public i(int i, int i2) {
        super(new mctech.items.base.o().c(i));
        this.a = (short) i2;
    }

    public i(mctech.items.base.o oVar, short s) {
        super(oVar);
        this.a = s;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public SimulatedStack createSimulationComponent(ItemStack itemStack) {
        return new mctech.items.d.b.g(this.a, getMaxDamage(itemStack));
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ReactorType getSupportedReactor(ItemStack itemStack) {
        return IReactorPlannerComponent.ReactorType.UNIVERSAL;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ComponentType getType(ItemStack itemStack) {
        return IReactorPlannerComponent.ComponentType.COOLANT_CELL;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public List<IReactorPlannerComponent.ReactorStat> getStats(ItemStack itemStack) {
        ObjectList objectListI = mctech.utils.a.b.i();
        objectListI.add(IReactorPlannerComponent.ReactorStat.HEAT_STORAGE);
        return objectListI;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public NumericTag getReactorStat(IReactorPlannerComponent.ReactorStat reactorStat, ItemStack itemStack) {
        if (reactorStat == IReactorPlannerComponent.ReactorStat.HEAT_STORAGE) {
            return IntTag.valueOf(getMaxDamage(itemStack));
        }
        return NULL_VALUE;
    }
}
