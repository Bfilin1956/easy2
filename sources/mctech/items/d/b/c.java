package mctech.items.d.b;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.BaseHeatSimulatedStack;
import mctech.api.reactor.planner.ISimulatedReactor;
import mctech.api.reactor.planner.SimulatedStack;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/b/c.class */
public class c extends BaseHeatSimulatedStack {
    mctech.items.d.a.a a;

    public c(mctech.items.d.a.a aVar) {
        super((short) 0, aVar.c());
        this.a = aVar;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public ItemStack syncStack(ItemStack itemStack) {
        itemStack.setDamageValue(this.heat);
        return itemStack;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void simulate(ISimulatedReactor iSimulatedReactor, int i, int i2, boolean z, boolean z2) {
        int iA = this.a.a();
        int iB = this.a.b();
        int iA2 = 0;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        double dA = ((double) this.heat) / ((double) this.maxHeat);
        int i3 = 1;
        boolean z3 = false;
        if (iB > 0) {
            double heat = ((double) iSimulatedReactor.getHeat()) / ((double) iSimulatedReactor.getMaxHeat());
            if (heat <= 0.25d || heat >= 0.75d) {
                i3 = 1 + 1;
                dA += heat;
                z3 = true;
            }
        }
        if (iA > 0) {
            List<Vec2i> listD = this.a.d();
            int size = listD.size();
            for (int i4 = 0; i4 < size; i4++) {
                Vec2i vec2i = listD.get(i4);
                dA += a(iSimulatedReactor, i + vec2i.getX(), i2 + vec2i.getY(), objectArrayList);
            }
        }
        double size2 = dA / ((double) (i3 + objectArrayList.size()));
        if (iA > 0) {
            for (b.a aVar : objectArrayList) {
                int iClamp = Mth.clamp(aVar.a(iSimulatedReactor, size2), -iA, iA);
                iA2 = (iA2 - iClamp) + aVar.a(iSimulatedReactor, iClamp);
            }
        }
        if (z3) {
            int iClamp2 = Mth.clamp(((int) (size2 * ((double) iSimulatedReactor.getMaxHeat()))) - iSimulatedReactor.getHeat(), -iB, iB);
            iA2 -= iClamp2;
            iSimulatedReactor.setHeat(iSimulatedReactor.getHeat() + iClamp2);
        }
        storeHeat(iSimulatedReactor, i, i2, iA2);
    }

    private double a(ISimulatedReactor iSimulatedReactor, int i, int i2, List<b.a> list) {
        SimulatedStack item = iSimulatedReactor.getItem(i, i2);
        if (item == null || !item.canStoreHeat(iSimulatedReactor, i, i2)) {
            return 0.0d;
        }
        double maxStoredHeat = item.getMaxStoredHeat(iSimulatedReactor, i, i2);
        if (maxStoredHeat <= 0.0d) {
            return 0.0d;
        }
        double storedHeat = ((double) item.getStoredHeat(iSimulatedReactor, i, i2)) / maxStoredHeat;
        if (storedHeat > 0.25d && storedHeat < 0.75d) {
            return 0.0d;
        }
        list.add(new b.a(item, i, i2, storedHeat > 0.5d));
        return storedHeat;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public List<IReactorPlannerComponent.ReactorStat> getStats() {
        return mctech.utils.a.b.a(IReactorPlannerComponent.ReactorStat.REACTOR_BALANCING, IReactorPlannerComponent.ReactorStat.PART_BALANCING);
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public IReactorPlannerComponent.ReactorType getValidType() {
        return IReactorPlannerComponent.ReactorType.UNIVERSAL;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public IReactorPlannerComponent.ComponentType getComponentType() {
        return IReactorPlannerComponent.ComponentType.HEAT_EXCHANGER;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public NumericTag getStat(IReactorPlannerComponent.ReactorStat reactorStat) {
        if (reactorStat == IReactorPlannerComponent.ReactorStat.REACTOR_BALANCING) {
            return IntTag.valueOf(this.a.b());
        }
        if (reactorStat == IReactorPlannerComponent.ReactorStat.PART_BALANCING) {
            return IntTag.valueOf(this.a.a());
        }
        return NULL_VALUE;
    }
}
