package mctech.items.d;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import java.util.function.BiPredicate;
import mctech.api.reactor.IReactor;
import mctech.api.reactor.IReactorComponent;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.SimulatedStack;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/f.class */
public class f extends mctech.items.d.a.e {
    private mctech.items.d.a.a a;

    public f(mctech.items.d.a.a aVar) {
        super(new mctech.items.base.o().c(aVar.c()));
        this.a = aVar;
    }

    public f(mctech.items.base.o oVar, mctech.items.d.a.a aVar) {
        super((oVar == null ? new mctech.items.base.o() : oVar).c(aVar.c()));
        this.a = aVar;
    }

    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        list.add(Component.literal("Теплоемкость: " + this.a.d));
        list.add(Component.literal("Теплообмен:"));
        list.add(Component.literal("  компонентный: " + this.a.b));
        list.add(Component.literal("  реакторный: " + this.a.c));
        list.add(Component.empty());
    }

    @Override // mctech.items.d.a.e, mctech.api.reactor.IReactorComponent
    public void processChamber(ItemStack itemStack, IReactor iReactor, int i, int i2, boolean z, boolean z2) {
        int iA = this.a.a();
        int iB = this.a.b();
        int iA2 = 0;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        double storedHeat = ((double) getStoredHeat(itemStack, iReactor, i, i2)) / ((double) getMaxStoredHeat(itemStack, iReactor, i, i2));
        int i3 = 1;
        if (iB > 0) {
            i3 = 1 + 1;
            storedHeat += ((double) iReactor.getHeat()) / ((double) iReactor.getMaxHeat());
        }
        if (iA > 0) {
            List<Vec2i> listD = this.a.d();
            int size = listD.size();
            for (int i4 = 0; i4 < size; i4++) {
                Vec2i vec2i = listD.get(i4);
                storedHeat += a(iReactor, i + vec2i.getX(), i2 + vec2i.getY(), (List<mctech.items.d.a.c>) objectArrayList);
            }
        }
        double size2 = storedHeat / ((double) (i3 + objectArrayList.size()));
        if (iA > 0) {
            for (mctech.items.d.a.c cVar : objectArrayList) {
                IReactorComponent iReactorComponent = (IReactorComponent) cVar.a.getItem();
                int iClamp = Mth.clamp(cVar.a(iReactorComponent, iReactor, size2), -iA, iA);
                iA2 = (iA2 - iClamp) + cVar.a(iReactorComponent, iReactor, iClamp);
            }
        }
        if (iB > 0) {
            int iClamp2 = Mth.clamp((int) ((size2 * ((double) iReactor.getMaxHeat())) - ((double) iReactor.getHeat())), -iB, iB);
            iA2 -= iClamp2;
            iReactor.setHeat(iReactor.getHeat() + iClamp2);
        }
        storeHeat(itemStack, iReactor, i, i2, iA2);
    }

    private double a(IReactor iReactor, int i, int i2, List<mctech.items.d.a.c> list) {
        ItemStack stackInReactor = iReactor.getStackInReactor(i, i2);
        IReactorComponent item = stackInReactor.getItem();
        if (item instanceof IReactorComponent) {
            IReactorComponent iReactorComponent = item;
            if (iReactorComponent.canStoreHeat(stackInReactor, iReactor, i, i2)) {
                list.add(new mctech.items.d.a.c(stackInReactor, i, i2));
                double maxStoredHeat = iReactorComponent.getMaxStoredHeat(stackInReactor, iReactor, i, i2);
                if (maxStoredHeat <= 0.0d) {
                    return 0.0d;
                }
                return ((double) iReactorComponent.getStoredHeat(stackInReactor, iReactor, i, i2)) / maxStoredHeat;
            }
            return 0.0d;
        }
        return 0.0d;
    }

    @Override // mctech.items.d.a.d, mctech.api.reactor.IReactorPlannerComponent
    public void addAffectedSlots(int i, int i2, BiPredicate<Integer, Integer> biPredicate) {
        biPredicate.test(Integer.valueOf(i), Integer.valueOf(i2));
        if (this.a.a() > 0) {
            biPredicate.test(Integer.valueOf(i + 1), Integer.valueOf(i2));
            biPredicate.test(Integer.valueOf(i - 1), Integer.valueOf(i2));
            biPredicate.test(Integer.valueOf(i), Integer.valueOf(i2 + 1));
            biPredicate.test(Integer.valueOf(i), Integer.valueOf(i2 - 1));
        }
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public SimulatedStack createSimulationComponent(ItemStack itemStack) {
        return new mctech.items.d.b.d(this.a);
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ReactorType getSupportedReactor(ItemStack itemStack) {
        return IReactorPlannerComponent.ReactorType.UNIVERSAL;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ComponentType getType(ItemStack itemStack) {
        return IReactorPlannerComponent.ComponentType.HEAT_EXCHANGER;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public List<IReactorPlannerComponent.ReactorStat> getStats(ItemStack itemStack) {
        ObjectList objectListI = mctech.utils.a.b.i();
        objectListI.add(IReactorPlannerComponent.ReactorStat.REACTOR_BALANCING);
        objectListI.add(IReactorPlannerComponent.ReactorStat.PART_BALANCING);
        return objectListI;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public NumericTag getReactorStat(IReactorPlannerComponent.ReactorStat reactorStat, ItemStack itemStack) {
        if (reactorStat == IReactorPlannerComponent.ReactorStat.REACTOR_BALANCING) {
            return IntTag.valueOf(this.a.b());
        }
        if (reactorStat == IReactorPlannerComponent.ReactorStat.PART_BALANCING) {
            return IntTag.valueOf(this.a.a());
        }
        return NULL_VALUE;
    }
}
