package mctech.items.d.b;

import java.util.List;
import java.util.Objects;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.BaseHeatSimulatedStack;
import mctech.api.reactor.planner.ISimulatedReactor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/b/h.class */
public class h extends BaseHeatSimulatedStack {
    protected mctech.items.d.j.a a;
    protected double b;
    protected double c;

    public h(mctech.items.d.j.a aVar) {
        super((short) 0, aVar.b());
        this.b = 0.0d;
        this.c = 0.0d;
        this.a = aVar;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public ItemStack syncStack(ItemStack itemStack) {
        itemStack.setDamageValue(this.heat);
        return itemStack;
    }

    @Override // mctech.api.reactor.planner.BaseHeatSimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public void reset() {
        super.reset();
        this.c = 0.0d;
        this.b = 0.0d;
    }

    @Override // mctech.api.reactor.planner.BaseHeatSimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public CompoundTag save() {
        CompoundTag compoundTagSave = super.save();
        compoundTagSave.putDouble("water", this.b);
        compoundTagSave.putDouble("heatStorage", this.c);
        return compoundTagSave;
    }

    @Override // mctech.api.reactor.planner.BaseHeatSimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.b = compoundTag.getDouble("water");
        this.c = compoundTag.getDouble("heatStorage");
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void simulate(ISimulatedReactor iSimulatedReactor, int i, int i2, boolean z, boolean z2) {
        a(iSimulatedReactor, i, i2, z, z2);
    }

    private void a(ISimulatedReactor iSimulatedReactor, int i, int i2, boolean z, boolean z2) {
        if (z) {
            boolean zIsProducingEnergy = iSimulatedReactor.isProducingEnergy();
            boolean z3 = this.a.a() == mctech.items.d.j.b.ELECTRIC;
            int iD = (!z3 || zIsProducingEnergy) ? this.a.d() : this.a.d() / 2;
            int iC = this.a.c();
            if (iD > 0) {
                int heat = iSimulatedReactor.getHeat();
                int i3 = heat;
                if (i3 > iD) {
                    i3 = iD;
                }
                int i4 = heat - i3;
                if (storeHeat(iSimulatedReactor, i, i2, i3) > 0) {
                    return;
                } else {
                    iSimulatedReactor.setHeat(i4);
                }
            }
            if (z3) {
                if (zIsProducingEnergy) {
                    iSimulatedReactor.addOutput(-(iC * 0.005f));
                }
                storeHeat(iSimulatedReactor, i, i2, zIsProducingEnergy ? -this.a.c() : -(this.a.c() / 2));
                return;
            }
            storeHeat(iSimulatedReactor, i, i2, -iC);
        }
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public List<IReactorPlannerComponent.ReactorStat> getStats() {
        return Objects.requireNonNull(this.a.a()) == mctech.items.d.j.b.ELECTRIC ? mctech.utils.a.b.a(IReactorPlannerComponent.ReactorStat.SELF_COOLING, IReactorPlannerComponent.ReactorStat.REACTOR_COOLING, IReactorPlannerComponent.ReactorStat.ENERGY_USAGE) : mctech.utils.a.b.a(IReactorPlannerComponent.ReactorStat.SELF_COOLING, IReactorPlannerComponent.ReactorStat.REACTOR_COOLING);
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public IReactorPlannerComponent.ReactorType getValidType() {
        if (this.a.a() == mctech.items.d.j.b.ELECTRIC) {
            return IReactorPlannerComponent.ReactorType.ELECTRIC;
        }
        return IReactorPlannerComponent.ReactorType.UNIVERSAL;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public IReactorPlannerComponent.ComponentType getComponentType() {
        return IReactorPlannerComponent.ComponentType.HEAT_VENT;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public NumericTag getStat(IReactorPlannerComponent.ReactorStat reactorStat) {
        switch (reactorStat) {
            case SELF_COOLING:
                return IntTag.valueOf(this.a.c());
            case REACTOR_COOLING:
                return IntTag.valueOf(this.a.d());
            case ENERGY_USAGE:
                return FloatTag.valueOf(this.a.c() * 0.005f);
            case WATER_CONSUMPTION:
                return FloatTag.valueOf(this.a.c() / 40.0f);
            case WATER_STORAGE:
                return FloatTag.valueOf(this.a.c());
            default:
                return NULL_VALUE;
        }
    }
}
