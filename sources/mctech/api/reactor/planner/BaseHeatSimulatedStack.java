package mctech.api.reactor.planner;

import net.minecraft.nbt.CompoundTag;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/reactor/planner/BaseHeatSimulatedStack.class */
public abstract class BaseHeatSimulatedStack implements SimulatedStack {
    protected int maxHeat;
    protected int heat;
    protected short id;
    protected Tracker heatChanges = new Tracker();

    public BaseHeatSimulatedStack(short s, int i) {
        this.id = s;
        this.maxHeat = i;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public CompoundTag save() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("heat", this.heat);
        this.heatChanges.save(compoundTag);
        return compoundTag;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void load(CompoundTag compoundTag) {
        this.heat = compoundTag.getInt("heat");
        this.heatChanges.load(compoundTag);
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void commitState() {
        this.heatChanges.commit();
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void reset() {
        this.heatChanges.reset();
        this.heat = 0;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public boolean acceptUraniumPulse(ISimulatedReactor iSimulatedReactor, int i, int i2, SimulatedStack simulatedStack, int i3, int i4, boolean z, boolean z2) {
        return false;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public boolean canStoreHeat(ISimulatedReactor iSimulatedReactor, int i, int i2) {
        return true;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public int getStoredHeat(ISimulatedReactor iSimulatedReactor, int i, int i2) {
        return this.heat;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public int getMaxStoredHeat(ISimulatedReactor iSimulatedReactor, int i, int i2) {
        return this.maxHeat;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public int storeHeat(ISimulatedReactor iSimulatedReactor, int i, int i2, int i3) {
        int i4;
        this.heatChanges.addChange(i3);
        this.heat += i3;
        if (this.heat > this.maxHeat) {
            iSimulatedReactor.markBroken(i, i2);
            i4 = (this.maxHeat - this.heat) + 1;
        } else if (this.heat < 0) {
            i4 = this.heat;
            this.heat = 0;
        } else {
            i4 = 0;
        }
        return i4;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public boolean canViewHeat(ISimulatedReactor iSimulatedReactor, int i, int i2) {
        return true;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public float getExplosionInfluence(ISimulatedReactor iSimulatedReactor) {
        return 0.0f;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public short getId() {
        return this.id;
    }
}
