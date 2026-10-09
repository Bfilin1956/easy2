package mctech.items.d.b;

import it.unimi.dsi.fastutil.PriorityQueue;
import java.util.List;
import mctech.MCTech;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.BaseDurabilitySimulatedStack;
import mctech.api.reactor.planner.ISimulatedReactor;
import mctech.api.reactor.planner.SimulatedStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/b/m.class */
public class m extends BaseDurabilitySimulatedStack {
    protected mctech.items.d.a.b a;
    protected int b;
    protected int c;

    public m(short s, int i, mctech.items.d.a.b bVar, int i2) {
        super(s, i);
        this.a = bVar;
        this.b = i2;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public ItemStack syncStack(ItemStack itemStack) {
        itemStack.setDamageValue(this.damage);
        return itemStack;
    }

    @Override // mctech.api.reactor.planner.BaseDurabilitySimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public void reset() {
        super.reset();
        this.c = 0;
    }

    @Override // mctech.api.reactor.planner.BaseDurabilitySimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public CompoundTag save() {
        CompoundTag compoundTagSave = super.save();
        compoundTagSave.putInt("refilled", this.c);
        return compoundTagSave;
    }

    @Override // mctech.api.reactor.planner.BaseDurabilitySimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.c = compoundTag.getInt("refilled");
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public void simulate(ISimulatedReactor iSimulatedReactor, int i, int i2, boolean z, boolean z2) {
        if (!iSimulatedReactor.isProducingEnergy()) {
            return;
        }
        int iC = this.a.c();
        List<int[]> listE = this.a.e();
        if (z) {
            List<int[]> listF = this.a.f();
            for (int i3 = 0; i3 < this.b; i3++) {
                int iA = (1 + (this.b / 2)) * iC;
                for (int i4 = 0; i4 < iC; i4++) {
                    int size = listE.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        int[] iArr = listE.get(i5);
                        iA += a(iSimulatedReactor, i + iArr[0], i2 + iArr[1], this, i, i2, true, z2);
                    }
                }
                int iA2 = (int) (mctech.utils.math.c.a(iA) * 4 * this.a.g());
                PriorityQueue<b> priorityQueueK = mctech.utils.a.b.k();
                int size2 = listF.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    int[] iArr2 = listF.get(i6);
                    a(iSimulatedReactor, i + iArr2[0], i2 + iArr2[1], priorityQueueK);
                }
                while (priorityQueueK.size() > 0 && iA2 > 0) {
                    int size3 = iA2 / priorityQueueK.size();
                    iA2 = (iA2 - size3) + ((b) priorityQueueK.dequeue()).a(iSimulatedReactor, size3);
                }
                if (iA2 > 0) {
                    iSimulatedReactor.addHeat(iA2);
                }
            }
        } else {
            int i7 = (1 + (this.b / 2)) * iC;
            for (int i8 = 0; i8 < this.b; i8++) {
                for (int i9 = 0; i9 < i7; i9++) {
                    acceptUraniumPulse(iSimulatedReactor, i, i2, this, i, i2, false, z2);
                }
                for (int i10 = 0; i10 < iC; i10++) {
                    int size4 = listE.size();
                    for (int i11 = 0; i11 < size4; i11++) {
                        int[] iArr3 = listE.get(i11);
                        a(iSimulatedReactor, i + iArr3[0], i2 + iArr3[1], this, i, i2, false, z2);
                    }
                }
            }
        }
        if (z2) {
            if (this.damage + 1 >= this.maxDamage) {
                this.c++;
                this.damage = 0;
            } else {
                this.damage++;
            }
        }
    }

    @Override // mctech.api.reactor.planner.BaseDurabilitySimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public boolean acceptUraniumPulse(ISimulatedReactor iSimulatedReactor, int i, int i2, SimulatedStack simulatedStack, int i3, int i4, boolean z, boolean z2) {
        if (iSimulatedReactor.isSimulatingPulses()) {
            iSimulatedReactor.addFuelPulse();
        }
        if (!z) {
            iSimulatedReactor.addOutput(this.a.b());
            return true;
        }
        return true;
    }

    @Override // mctech.api.reactor.planner.BaseDurabilitySimulatedStack, mctech.api.reactor.planner.SimulatedStack
    public float getExplosionInfluence(ISimulatedReactor iSimulatedReactor) {
        return this.a.h() * this.b;
    }

    protected int a(ISimulatedReactor iSimulatedReactor, int i, int i2, SimulatedStack simulatedStack, int i3, int i4, boolean z, boolean z2) {
        SimulatedStack item = iSimulatedReactor.getItem(i, i2);
        if (item == null || !item.acceptUraniumPulse(iSimulatedReactor, i, i2, simulatedStack, i3, i4, z, z2)) {
            return 0;
        }
        return this.a.d();
    }

    protected void a(ISimulatedReactor iSimulatedReactor, int i, int i2, PriorityQueue<b> priorityQueue) {
        SimulatedStack item = iSimulatedReactor.getItem(i, i2);
        if (item != null && item.canStoreHeat(iSimulatedReactor, i, i2)) {
            priorityQueue.enqueue(new b(item, i, i2));
        }
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public List<IReactorPlannerComponent.ReactorStat> getStats() {
        return mctech.utils.a.b.a(IReactorPlannerComponent.ReactorStat.ROD_COUNT, IReactorPlannerComponent.ReactorStat.MAX_COMPONENT_DURABILITY, IReactorPlannerComponent.ReactorStat.PULSE_COUNT, IReactorPlannerComponent.ReactorStat.HEAT_PRODUCTION, IReactorPlannerComponent.ReactorStat.ENERGY_PRODUCTION);
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public IReactorPlannerComponent.ReactorType getValidType() {
        return IReactorPlannerComponent.ReactorType.UNIVERSAL;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public IReactorPlannerComponent.ComponentType getComponentType() {
        return IReactorPlannerComponent.ComponentType.FUEL_ROD;
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public NumericTag getStat(IReactorPlannerComponent.ReactorStat reactorStat) {
        switch (reactorStat) {
            case ROD_COUNT:
                return IntTag.valueOf(this.b);
            case MAX_COMPONENT_DURABILITY:
                return IntTag.valueOf(this.maxDamage);
            case PULSE_COUNT:
                return IntTag.valueOf((1 + (this.b / 2)) * this.a.c() * this.b);
            case HEAT_PRODUCTION:
                return IntTag.valueOf(((int) (mctech.utils.math.c.a((1 + (this.b / 2)) * this.a.c()) * 4 * this.a.g())) * this.b);
            case ENERGY_PRODUCTION:
                return FloatTag.valueOf((1 + (this.b / 2)) * this.a.c() * this.a.b() * this.b * MCTech.CONFIG.reactorOutput.get());
            default:
                return NULL_VALUE;
        }
    }

    @Override // mctech.api.reactor.planner.SimulatedStack
    public NumericTag getStat(IReactorPlannerComponent.ReactorStat reactorStat, ISimulatedReactor iSimulatedReactor, int i, int i2) {
        switch (reactorStat) {
            case HEAT_PRODUCTION:
                int iC = this.a.c();
                List<int[]> listE = this.a.e();
                int iA = 0;
                for (int i3 = 0; i3 < this.b; i3++) {
                    int iA2 = (1 + (this.b / 2)) * iC;
                    for (int i4 = 0; i4 < iC; i4++) {
                        int size = listE.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            int[] iArr = listE.get(i5);
                            iA2 += a(iSimulatedReactor, i + iArr[0], i2 + iArr[1], this, i, i2, true, false);
                        }
                    }
                    iA += (int) (mctech.utils.math.c.a(iA2) * 4 * this.a.g());
                }
                return IntTag.valueOf(iA);
            case ENERGY_PRODUCTION:
                int iC2 = this.a.c();
                List<int[]> listE2 = this.a.e();
                int i6 = (1 + (this.b / 2)) * iC2;
                for (int i7 = 0; i7 < this.b; i7++) {
                    for (int i8 = 0; i8 < i6; i8++) {
                        acceptUraniumPulse(iSimulatedReactor, i, i2, this, i, i2, false, false);
                    }
                    for (int i9 = 0; i9 < iC2; i9++) {
                        int size2 = listE2.size();
                        for (int i10 = 0; i10 < size2; i10++) {
                            int[] iArr2 = listE2.get(i10);
                            a(iSimulatedReactor, i + iArr2[0], i2 + iArr2[1], this, i, i2, false, false);
                        }
                    }
                }
                return FloatTag.valueOf(iSimulatedReactor.getEnergyOutput());
            default:
                return super.getStat(reactorStat, iSimulatedReactor, i, i2);
        }
    }
}
