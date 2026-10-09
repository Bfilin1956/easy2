package mctech.items.d;

import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import java.util.function.BiPredicate;
import mctech.api.reactor.IReactor;
import mctech.api.reactor.IReactorComponent;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.SimulatedStack;
import mctech.api.util.DirectionList;
import net.minecraft.core.Direction;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/h.class */
public class h extends mctech.items.d.a.d {
    public h() {
        super(null);
    }

    @Override // mctech.api.reactor.IReactorComponent
    public void processChamber(ItemStack itemStack, IReactor iReactor, int i, int i2, boolean z, boolean z2) {
        if (z) {
            a(iReactor, i - 1, i2);
            a(iReactor, i + 1, i2);
            a(iReactor, i, i2 - 1);
            a(iReactor, i, i2 + 1);
        }
    }

    @Override // mctech.items.d.a.d, mctech.api.reactor.IReactorPlannerComponent
    public void addAffectedSlots(int i, int i2, BiPredicate<Integer, Integer> biPredicate) {
        biPredicate.test(Integer.valueOf(i), Integer.valueOf(i2));
        biPredicate.test(Integer.valueOf(i + 1), Integer.valueOf(i2));
        biPredicate.test(Integer.valueOf(i - 1), Integer.valueOf(i2));
        biPredicate.test(Integer.valueOf(i), Integer.valueOf(i2 + 1));
        biPredicate.test(Integer.valueOf(i), Integer.valueOf(i2 - 1));
    }

    @Override // mctech.api.reactor.IReactorComponent
    public boolean acceptUraniumPulse(ItemStack itemStack, IReactor iReactor, ItemStack itemStack2, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return false;
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
        return 0.0f;
    }

    private void a(IReactor iReactor, int i, int i2) {
        ItemStack stackInReactor = iReactor.getStackInReactor(i, i2);
        IReactorComponent item = stackInReactor.getItem();
        if (item instanceof IReactorComponent) {
            IReactorComponent iReactorComponent = item;
            if (iReactorComponent.canStoreHeat(stackInReactor, iReactor, i, i2)) {
                iReactorComponent.storeHeat(stackInReactor, iReactor, i, i2, -4);
            }
        }
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public SimulatedStack createSimulationComponent(ItemStack itemStack) {
        return new mctech.items.d.b.l((short) 26, 4);
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ReactorType getSupportedReactor(ItemStack itemStack) {
        return IReactorPlannerComponent.ReactorType.UNIVERSAL;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ComponentType getType(ItemStack itemStack) {
        return IReactorPlannerComponent.ComponentType.HEAT_SPREAD;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public List<IReactorPlannerComponent.ReactorStat> getStats(ItemStack itemStack) {
        ObjectList objectListI = mctech.utils.a.b.i();
        objectListI.add(IReactorPlannerComponent.ReactorStat.PART_COOLING);
        return objectListI;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public NumericTag getReactorStat(IReactorPlannerComponent.ReactorStat reactorStat, ItemStack itemStack) {
        if (reactorStat == IReactorPlannerComponent.ReactorStat.PART_COOLING) {
            return IntTag.valueOf(4);
        }
        return NULL_VALUE;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public NumericTag getReactorStat(IReactorPlannerComponent.ReactorStat reactorStat, ItemStack itemStack, IReactor iReactor, int i, int i2) {
        if (reactorStat == IReactorPlannerComponent.ReactorStat.PART_COOLING) {
            int i3 = 0;
            for (Direction direction : DirectionList.HORIZONTAL) {
                ItemStack stackInReactor = iReactor.getStackInReactor(i + direction.getStepX(), i2 + direction.getStepZ());
                IReactorComponent item = stackInReactor.getItem();
                if ((item instanceof IReactorComponent) && item.canStoreHeat(stackInReactor, iReactor, i, i2)) {
                    i3++;
                }
            }
            return IntTag.valueOf(4 * i3);
        }
        return NULL_VALUE;
    }
}
