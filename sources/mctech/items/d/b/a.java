package mctech.items.d.b;

import java.util.List;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.BaseHeatSimulatedStack;
import mctech.api.reactor.planner.ISimulatedReactor;
import mctech.init.MCTechDataComponent;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/b/a.class */
public class a extends BaseHeatSimulatedStack {
    protected int a;

    public a(short s, int i) {
        super(s, i);
        this.a = 0;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public ItemStack syncStack(ItemStack itemStack) {
        itemStack.setDamageValue(this.heat);
        if (this.heatChanges.getCount() > 0) {
            itemStack.set(MCTechDataComponent.RESET, Integer.valueOf(this.a));
            itemStack.set(MCTechDataComponent.TOTAL, Integer.valueOf(this.heatChanges.getTotal()));
            itemStack.set(MCTechDataComponent.AVERAGE, Float.valueOf(this.heatChanges.getAverage()));
        } else {
            itemStack.remove(MCTechDataComponent.RESET);
            itemStack.remove(MCTechDataComponent.TOTAL);
            itemStack.remove(MCTechDataComponent.AVERAGE);
        }
        return itemStack;
    }

    @Override // mctech.api.reactor.planner.BaseHeatSimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public void reset() {
        super.reset();
        this.a = 0;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void simulate(ISimulatedReactor iSimulatedReactor, int i, int i2, boolean z, boolean z2) {
    }

    @Override // mctech.api.reactor.planner.BaseHeatSimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public boolean canViewHeat(ISimulatedReactor iSimulatedReactor, int i, int i2) {
        return false;
    }

    @Override // mctech.api.reactor.planner.BaseHeatSimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public int getStoredHeat(ISimulatedReactor iSimulatedReactor, int i, int i2) {
        return 0;
    }

    @Override // mctech.api.reactor.planner.BaseHeatSimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public int storeHeat(ISimulatedReactor iSimulatedReactor, int i, int i2, int i3) {
        int iMin = Math.min(this.maxHeat - (this.heat + 1), i3);
        if (iMin < i3) {
            this.a++;
            this.heat = 0;
            iMin = Math.min(this.maxHeat - (this.heat + 1), i3);
        }
        this.heat += iMin;
        this.heatChanges.addChange(iMin);
        return i3 - iMin;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public List<IReactorPlannerComponent.ReactorStat> getStats() {
        return mctech.utils.a.b.a(IReactorPlannerComponent.ReactorStat.HEAT_STORAGE);
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public IReactorPlannerComponent.ReactorType getValidType() {
        return IReactorPlannerComponent.ReactorType.UNIVERSAL;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public IReactorPlannerComponent.ComponentType getComponentType() {
        return IReactorPlannerComponent.ComponentType.CONDENSATOR;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public NumericTag getStat(IReactorPlannerComponent.ReactorStat reactorStat) {
        return reactorStat == IReactorPlannerComponent.ReactorStat.HEAT_STORAGE ? IntTag.valueOf(this.maxHeat) : NULL_VALUE;
    }
}
