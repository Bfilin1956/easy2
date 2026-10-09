package mctech.items.d.b;

import java.util.List;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.ISimulatedReactor;
import mctech.api.reactor.planner.SimulatedStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/b/l.class */
public class l implements SimulatedStack {
    short a;
    int b;

    public l(short s, int i) {
        this.a = s;
        this.b = i;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public ItemStack syncStack(ItemStack itemStack) {
        return itemStack;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public CompoundTag save() {
        return new CompoundTag();
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void load(CompoundTag compoundTag) {
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void commitState() {
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void reset() {
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void simulate(ISimulatedReactor iSimulatedReactor, int i, int i2, boolean z, boolean z2) {
        if (z) {
            a(iSimulatedReactor, i - 1, i2);
            a(iSimulatedReactor, i + 1, i2);
            a(iSimulatedReactor, i, i2 - 1);
            a(iSimulatedReactor, i, i2 + 1);
        }
    }

    private void a(ISimulatedReactor iSimulatedReactor, int i, int i2) {
        SimulatedStack item = iSimulatedReactor.getItem(i, i2);
        if (item != null && item.canStoreHeat(iSimulatedReactor, i, i2)) {
            item.storeHeat(iSimulatedReactor, i, i2, -this.b);
        }
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public boolean acceptUraniumPulse(ISimulatedReactor iSimulatedReactor, int i, int i2, SimulatedStack simulatedStack, int i3, int i4, boolean z, boolean z2) {
        return false;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public boolean canStoreHeat(ISimulatedReactor iSimulatedReactor, int i, int i2) {
        return false;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public int getStoredHeat(ISimulatedReactor iSimulatedReactor, int i, int i2) {
        return 0;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public int getMaxStoredHeat(ISimulatedReactor iSimulatedReactor, int i, int i2) {
        return 0;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public int storeHeat(ISimulatedReactor iSimulatedReactor, int i, int i2, int i3) {
        return 0;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public boolean canViewHeat(ISimulatedReactor iSimulatedReactor, int i, int i2) {
        return false;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public float getExplosionInfluence(ISimulatedReactor iSimulatedReactor) {
        return 0.0f;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public short getId() {
        return this.a;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public List<IReactorPlannerComponent.ReactorStat> getStats() {
        return mctech.utils.a.b.a(IReactorPlannerComponent.ReactorStat.PART_COOLING);
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public IReactorPlannerComponent.ReactorType getValidType() {
        return IReactorPlannerComponent.ReactorType.UNIVERSAL;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public IReactorPlannerComponent.ComponentType getComponentType() {
        return IReactorPlannerComponent.ComponentType.HEAT_SPREAD;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public NumericTag getStat(IReactorPlannerComponent.ReactorStat reactorStat) {
        return reactorStat == IReactorPlannerComponent.ReactorStat.PART_COOLING ? IntTag.valueOf(this.b) : NULL_VALUE;
    }
}
