package mctech.items.d;

import it.unimi.dsi.fastutil.PriorityQueue;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import java.util.function.BiPredicate;
import mctech.MCTech;
import mctech.api.reactor.IReactor;
import mctech.api.reactor.IReactorComponent;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.IUsableUranium;
import mctech.api.reactor.planner.SimulatedStack;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/o.class */
public class o extends mctech.items.d.a.d implements IUsableUranium {
    mctech.items.d.a.b a;
    int b;
    short c;
    public static final mctech.items.d.a.b[] d;
    RandomSource e;

    public o(mctech.items.d.a.b bVar, int i, int i2) {
        super(new mctech.items.base.o().c(bVar.a()));
        this.e = RandomSource.create();
        this.a = bVar;
        this.b = i;
        this.c = (short) i2;
    }

    public o(mctech.items.base.o oVar, mctech.items.d.a.b bVar, int i, int i2) {
        super((oVar == null ? new mctech.items.base.o() : oVar).c(bVar.a()));
        this.e = RandomSource.create();
        this.a = bVar;
        this.b = i;
        this.c = (short) i2;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public void processChamber(ItemStack itemStack, IReactor iReactor, int i, int i2, boolean z, boolean z2) {
        if (!iReactor.isProducingEnergy()) {
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
                        iA += a(iReactor, i + iArr[0], i2 + iArr[1], itemStack, i, i2, true, z2);
                    }
                }
                int iA2 = (int) (mctech.utils.math.c.a(iA) * 4 * this.a.g());
                PriorityQueue<mctech.items.d.a.c> priorityQueueK = mctech.utils.a.b.k();
                int size2 = listF.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    int[] iArr2 = listF.get(i6);
                    a(iReactor, i + iArr2[0], i2 + iArr2[1], priorityQueueK);
                }
                while (priorityQueueK.size() > 0 && iA2 > 0) {
                    int size3 = iA2 / priorityQueueK.size();
                    int i7 = iA2 - size3;
                    mctech.items.d.a.c cVar = (mctech.items.d.a.c) priorityQueueK.dequeue();
                    iA2 = i7 + cVar.a.getItem().storeHeat(cVar.a, iReactor, cVar.b, cVar.c, size3);
                }
                if (iA2 > 0) {
                    iReactor.addHeat(iA2);
                }
            }
        } else {
            int i8 = (1 + (this.b / 2)) * iC;
            for (int i9 = 0; i9 < this.b; i9++) {
                for (int i10 = 0; i10 < i8; i10++) {
                    acceptUraniumPulse(itemStack, iReactor, itemStack, i, i2, i, i2, false, z2);
                }
                for (int i11 = 0; i11 < iC; i11++) {
                    int size4 = listE.size();
                    for (int i12 = 0; i12 < size4; i12++) {
                        int[] iArr3 = listE.get(i12);
                        a(iReactor, i + iArr3[0], i2 + iArr3[1], itemStack, i, i2, false, z2);
                    }
                }
            }
        }
        if (z2) {
            int damageValue = itemStack.getDamageValue();
            if (damageValue + 1 > itemStack.getMaxDamage()) {
                iReactor.setStackInReactor(i, i2, this.e.nextInt(3) == 0 ? this.a.a(this.b) : ItemStack.EMPTY);
            } else {
                itemStack.setDamageValue(damageValue + 1);
            }
        }
    }

    @Override // mctech.items.d.a.d, mctech.api.reactor.IReactorPlannerComponent
    public void addAffectedSlots(int i, int i2, BiPredicate<Integer, Integer> biPredicate) {
        biPredicate.test(Integer.valueOf(i), Integer.valueOf(i2));
        for (int[] iArr : this.a.f()) {
            biPredicate.test(Integer.valueOf(i + iArr[0]), Integer.valueOf(i2 + iArr[1]));
        }
        for (int[] iArr2 : this.a.e()) {
            biPredicate.test(Integer.valueOf(i + iArr2[0]), Integer.valueOf(i2 + iArr2[1]));
        }
    }

    @Override // mctech.api.reactor.IReactorComponent
    public boolean acceptUraniumPulse(ItemStack itemStack, IReactor iReactor, ItemStack itemStack2, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        if (!z) {
            iReactor.addOutput(this.a.b());
            return true;
        }
        return true;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public boolean canStoreHeat(ItemStack itemStack, IReactor iReactor, int i, int i2) {
        return false;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public int getStoredHeat(ItemStack itemStack, IReactor iReactor, int i, int i2) {
        return 0;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public int getMaxStoredHeat(ItemStack itemStack, IReactor iReactor, int i, int i2) {
        return 0;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public int storeHeat(ItemStack itemStack, IReactor iReactor, int i, int i2, int i3) {
        return i3;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public float getExplosionInfluence(ItemStack itemStack, IReactor iReactor) {
        return this.a.h() * this.b;
    }

    protected int a(IReactor iReactor, int i, int i2, ItemStack itemStack, int i3, int i4, boolean z, boolean z2) {
        ItemStack stackInReactor = iReactor.getStackInReactor(i, i2);
        if ((stackInReactor.getItem() instanceof IReactorComponent) && stackInReactor.getItem().acceptUraniumPulse(stackInReactor, iReactor, itemStack, i, i2, i3, i4, z, z2)) {
            return this.a.d();
        }
        return 0;
    }

    protected void a(IReactor iReactor, int i, int i2, PriorityQueue<mctech.items.d.a.c> priorityQueue) {
        ItemStack stackInReactor = iReactor.getStackInReactor(i, i2);
        if ((stackInReactor.getItem() instanceof IReactorComponent) && stackInReactor.getItem().canStoreHeat(stackInReactor, iReactor, i, i2)) {
            priorityQueue.enqueue(new mctech.items.d.a.c(stackInReactor, i, i2));
        }
    }

    @Override // mctech.api.reactor.IUsableUranium
    public ItemStack createDepletedUraniumRod() {
        return this.a.a(this.b);
    }

    public mctech.items.d.a.b a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public SimulatedStack createSimulationComponent(ItemStack itemStack) {
        return new mctech.items.d.b.m(this.c, getMaxDamage(itemStack), this.a, this.b);
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ReactorType getSupportedReactor(ItemStack itemStack) {
        return IReactorPlannerComponent.ReactorType.UNIVERSAL;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ComponentType getType(ItemStack itemStack) {
        return IReactorPlannerComponent.ComponentType.FUEL_ROD;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public List<IReactorPlannerComponent.ReactorStat> getStats(ItemStack itemStack) {
        ObjectList objectListI = mctech.utils.a.b.i();
        objectListI.add(IReactorPlannerComponent.ReactorStat.ROD_COUNT);
        objectListI.add(IReactorPlannerComponent.ReactorStat.MAX_COMPONENT_DURABILITY);
        objectListI.add(IReactorPlannerComponent.ReactorStat.PULSE_COUNT);
        objectListI.add(IReactorPlannerComponent.ReactorStat.HEAT_PRODUCTION);
        objectListI.add(IReactorPlannerComponent.ReactorStat.ENERGY_PRODUCTION);
        return objectListI;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public NumericTag getReactorStat(IReactorPlannerComponent.ReactorStat reactorStat, ItemStack itemStack) {
        switch (reactorStat) {
            case ROD_COUNT:
                return IntTag.valueOf(this.b);
            case MAX_COMPONENT_DURABILITY:
                return IntTag.valueOf(itemStack.getMaxDamage());
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

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public NumericTag getReactorStat(IReactorPlannerComponent.ReactorStat reactorStat, ItemStack itemStack, IReactor iReactor, int i, int i2) {
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
                            iA2 += a(iReactor, i + iArr[0], i2 + iArr[1], itemStack, i, i2, true, false);
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
                        acceptUraniumPulse(itemStack, iReactor, itemStack, i, i2, i, i2, false, false);
                    }
                    for (int i9 = 0; i9 < iC2; i9++) {
                        int size2 = listE2.size();
                        for (int i10 = 0; i10 < size2; i10++) {
                            int[] iArr2 = listE2.get(i10);
                            a(iReactor, i + iArr2[0], i2 + iArr2[1], itemStack, i, i2, false, false);
                        }
                    }
                }
                return FloatTag.valueOf((float) iReactor.getEnergyOutput());
            default:
                return super.getReactorStat(reactorStat, itemStack, iReactor, i, i2);
        }
    }

    static {
        mctech.items.d.a.b[] bVarArr = new mctech.items.d.a.b[6];
        d = bVarArr;
        bVarArr[0] = mctech.items.d.c.f.a;
        d[1] = mctech.items.d.c.e.a;
        d[2] = mctech.items.d.c.a.a;
        d[3] = mctech.items.d.c.c.a;
        d[4] = mctech.items.d.c.d.a;
        d[5] = mctech.items.d.c.b.a;
    }
}
