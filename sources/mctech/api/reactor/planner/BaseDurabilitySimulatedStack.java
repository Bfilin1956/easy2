package mctech.api.reactor.planner;

import net.minecraft.nbt.CompoundTag;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/reactor/planner/BaseDurabilitySimulatedStack.class */
public abstract class BaseDurabilitySimulatedStack implements SimulatedStack {
    protected int maxDamage;
    protected int damage;
    protected short id;

    public BaseDurabilitySimulatedStack(short s, int i) {
        this.id = s;
        this.maxDamage = i;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public CompoundTag save() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("damage", this.damage);
        return compoundTag;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void load(CompoundTag compoundTag) {
        this.damage = compoundTag.getInt("damage");
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void commitState() {
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void reset() {
        this.damage = 0;
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
        return i3;
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
