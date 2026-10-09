package mctech.items.d.b;

import java.util.List;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.BaseDurabilitySimulatedStack;
import mctech.api.reactor.planner.ISimulatedReactor;
import mctech.api.reactor.planner.SimulatedStack;
import mctech.init.MCTechDataComponent;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/b/i.class */
public class i extends BaseDurabilitySimulatedStack {
    protected int a;
    protected int b;

    public i(short s, int i, int i2) {
        super(s, i);
        this.a = 0;
        this.damage = i;
        this.b = i2;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public ItemStack syncStack(ItemStack itemStack) {
        itemStack.setDamageValue(this.damage);
        if (this.a > 0) {
            itemStack.set(MCTechDataComponent.BREED_ROD, Integer.valueOf(this.a));
        } else {
            itemStack.remove(MCTechDataComponent.BREED_ROD);
        }
        return itemStack;
    }

    @Override // mctech.api.reactor.planner.BaseDurabilitySimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public void reset() {
        this.damage = this.maxDamage;
        this.a = 0;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void simulate(ISimulatedReactor iSimulatedReactor, int i, int i2, boolean z, boolean z2) {
    }

    @Override // mctech.api.reactor.planner.BaseDurabilitySimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public boolean acceptUraniumPulse(ISimulatedReactor iSimulatedReactor, int i, int i2, SimulatedStack simulatedStack, int i3, int i4, boolean z, boolean z2) {
        if (iSimulatedReactor.isSimulatingPulses()) {
            iSimulatedReactor.addBreedingPulse();
        }
        if (iSimulatedReactor.isSteamReactor()) {
            if (z2) {
                int heat = (this.damage - 1) - (iSimulatedReactor.getHeat() / this.b);
                if (heat <= 0) {
                    this.damage = this.maxDamage;
                    this.a++;
                    return true;
                }
                this.damage = heat;
                return true;
            }
            return true;
        }
        int heat2 = (this.damage - 1) - (iSimulatedReactor.getHeat() / this.b);
        if (heat2 <= 0) {
            this.damage = this.maxDamage;
            this.a++;
            return true;
        }
        this.damage = heat2;
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
        return IReactorPlannerComponent.ComponentType.ISOTOPE_CELL;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public NumericTag getStat(IReactorPlannerComponent.ReactorStat reactorStat) {
        return reactorStat == IReactorPlannerComponent.ReactorStat.MAX_COMPONENT_DURABILITY ? IntTag.valueOf(this.maxDamage) : NULL_VALUE;
    }
}
