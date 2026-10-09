package mctech.items.d.b;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.ISimulatedReactor;
import mctech.api.reactor.planner.SimulatedStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/b/f.class */
public class f implements SimulatedStack {
    protected short a;
    protected int b;
    protected int c;

    public f(short s, int i, int i2) {
        this.a = s;
        this.b = i;
        this.c = i2;
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
        if (this.c == 0 || this.c == 15) {
            return;
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        int iA = 0 + a(iSimulatedReactor, i, i2 - 1, (this.c & 1) != 0, objectArrayList, objectArrayList2) + a(iSimulatedReactor, i, i2 + 1, (this.c & 2) != 0, objectArrayList, objectArrayList2) + a(iSimulatedReactor, i - 1, i2, (this.c & 4) != 0, objectArrayList, objectArrayList2) + a(iSimulatedReactor, i + 1, i2, (this.c & 8) != 0, objectArrayList, objectArrayList2);
        if (objectArrayList2.isEmpty() || objectArrayList.isEmpty() || iA <= 0) {
            return;
        }
        int size = iA / objectArrayList.size();
        int iA2 = 0;
        Iterator<b> it = objectArrayList.iterator();
        while (it.hasNext()) {
            iA2 += size - it.next().a(iSimulatedReactor, size);
        }
        int size2 = iA2 / objectArrayList2.size();
        Iterator<b> it2 = objectArrayList2.iterator();
        while (it2.hasNext()) {
            iA2 -= size2 - it2.next().a(iSimulatedReactor, -size2);
        }
        if (iA2 > 0) {
            for (int i3 = 0; iA2 > 0 && i3 < 8; i3++) {
                iA2 -= 1 - objectArrayList2.get(i3 % objectArrayList2.size()).a(iSimulatedReactor, -1);
            }
        }
    }

    private int a(ISimulatedReactor iSimulatedReactor, int i, int i2, boolean z, List<b> list, List<b> list2) {
        SimulatedStack item = iSimulatedReactor.getItem(i, i2);
        if (item != null && item.canStoreHeat(iSimulatedReactor, i, i2)) {
            if (z) {
                int iMin = Math.min(item.getStoredHeat(iSimulatedReactor, i, i2), this.b);
                if (iMin > 0) {
                    list2.add(new b(item, i, i2));
                }
                return iMin;
            }
            list.add(new b(item, i, i2));
            return 0;
        }
        return 0;
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
        return mctech.utils.a.b.a(IReactorPlannerComponent.ReactorStat.PART_BALANCING);
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public IReactorPlannerComponent.ReactorType getValidType() {
        return IReactorPlannerComponent.ReactorType.UNIVERSAL;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public IReactorPlannerComponent.ComponentType getComponentType() {
        return IReactorPlannerComponent.ComponentType.HEAT_PUMP;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public NumericTag getStat(IReactorPlannerComponent.ReactorStat reactorStat) {
        return reactorStat == IReactorPlannerComponent.ReactorStat.PART_BALANCING ? IntTag.valueOf(this.b) : NULL_VALUE;
    }
}
