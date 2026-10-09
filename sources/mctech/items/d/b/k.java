package mctech.items.d.b;

import java.util.List;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.BaseDurabilitySimulatedStack;
import mctech.api.reactor.planner.ISimulatedReactor;
import mctech.api.reactor.planner.SimulatedStack;
import mctech.init.MCTechDataComponent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/b/k.class */
public class k extends BaseDurabilitySimulatedStack {
    protected boolean a;
    protected int b;

    public k(short s, int i, boolean z) {
        super(s, i);
        this.b = 0;
        this.a = z;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public ItemStack syncStack(ItemStack itemStack) {
        itemStack.setDamageValue(this.damage);
        if (this.b > 0) {
            itemStack.set(MCTechDataComponent.REFILLED, Integer.valueOf(this.b));
        } else {
            itemStack.remove(MCTechDataComponent.REFILLED);
        }
        return itemStack;
    }

    @Override // mctech.api.reactor.planner.BaseDurabilitySimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public void reset() {
        super.reset();
        this.b = 0;
    }

    @Override // mctech.api.reactor.planner.BaseDurabilitySimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public CompoundTag save() {
        CompoundTag compoundTagSave = super.save();
        compoundTagSave.putInt("refilled", this.b);
        return compoundTagSave;
    }

    @Override // mctech.api.reactor.planner.BaseDurabilitySimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.b = compoundTag.getInt("refilled");
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void simulate(ISimulatedReactor iSimulatedReactor, int i, int i2, boolean z, boolean z2) {
    }

    @Override // mctech.api.reactor.planner.BaseDurabilitySimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public boolean acceptUraniumPulse(ISimulatedReactor iSimulatedReactor, int i, int i2, SimulatedStack simulatedStack, int i3, int i4, boolean z, boolean z2) {
        if (this.a && this.damage >= this.maxDamage) {
            return false;
        }
        if (iSimulatedReactor.isSimulatingPulses()) {
            iSimulatedReactor.addFuelPulse();
        }
        if (iSimulatedReactor.isSteamReactor()) {
            if (z2) {
                if (this.damage >= this.maxDamage) {
                    this.damage = 0;
                    this.b++;
                    return true;
                }
                this.damage++;
                return true;
            }
            return true;
        }
        if (!z) {
            iSimulatedReactor.addOutput(1.0f);
        }
        if (z2) {
            if (this.damage >= this.maxDamage) {
                this.damage = 0;
                this.b++;
                return true;
            }
            this.damage++;
            return true;
        }
        return true;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public List<IReactorPlannerComponent.ReactorStat> getStats() {
        return mctech.utils.a.b.a(IReactorPlannerComponent.ReactorStat.MAX_COMPONENT_DURABILITY);
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public IReactorPlannerComponent.ReactorType getValidType() {
        return IReactorPlannerComponent.ReactorType.UNIVERSAL;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public IReactorPlannerComponent.ComponentType getComponentType() {
        return IReactorPlannerComponent.ComponentType.REFLECTORS;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public NumericTag getStat(IReactorPlannerComponent.ReactorStat reactorStat) {
        return reactorStat == IReactorPlannerComponent.ReactorStat.MAX_COMPONENT_DURABILITY ? IntTag.valueOf(this.maxDamage) : NULL_VALUE;
    }
}
