package mctech.items.d;

import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import mctech.api.reactor.IReactor;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.SimulatedStack;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/j.class */
public class j extends mctech.items.d.a.e {
    private a a;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/j$b.class */
    public enum b {
        HEAT,
        ELECTRIC
    }

    public j(a aVar) {
        super(new mctech.items.base.o().c(aVar.d));
        this.a = aVar;
    }

    public j(String str, mctech.items.base.o oVar, a aVar) {
        super((oVar == null ? new mctech.items.base.o() : oVar).c(aVar.d));
        this.a = aVar;
    }

    public a a() {
        return this.a;
    }

    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        list.add(Component.literal("Максимальная температура: " + this.a.d));
        list.add(Component.literal("Охлаждение:"));
        list.add(Component.literal("  компонентное: " + this.a.b));
        list.add(Component.literal("  реакторное: " + this.a.c));
        list.add(Component.empty());
    }

    @Override // mctech.items.d.a.e, mctech.api.reactor.IReactorComponent
    public void processChamber(ItemStack itemStack, IReactor iReactor, int i, int i2, boolean z, boolean z2) {
        a(itemStack, iReactor, i, i2, z, z2);
    }

    private void a(ItemStack itemStack, IReactor iReactor, int i, int i2, boolean z, boolean z2) {
        if (z) {
            boolean zIsProducingEnergy = iReactor.isProducingEnergy();
            boolean z3 = this.a.a() == b.ELECTRIC;
            int iD = (!z3 || zIsProducingEnergy) ? this.a.d() : this.a.d() / 2;
            int iC = this.a.c();
            if (iD > 0) {
                int heat = iReactor.getHeat();
                int i3 = heat;
                if (i3 > iD) {
                    i3 = iD;
                }
                int i4 = heat - i3;
                if (storeHeat(itemStack, iReactor, i, i2, i3) > 0) {
                    return;
                } else {
                    iReactor.setHeat(i4);
                }
            }
            if (z3) {
                if (zIsProducingEnergy) {
                    iReactor.addOutput(-(iC * 0.005f));
                }
                storeHeat(itemStack, iReactor, i, i2, zIsProducingEnergy ? -this.a.c() : -(this.a.c() / 2));
                return;
            }
            storeHeat(itemStack, iReactor, i, i2, -iC);
        }
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public SimulatedStack createSimulationComponent(ItemStack itemStack) {
        return new mctech.items.d.b.h(this.a);
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ComponentType getType(ItemStack itemStack) {
        return IReactorPlannerComponent.ComponentType.HEAT_VENT;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public NumericTag getReactorStat(IReactorPlannerComponent.ReactorStat reactorStat, ItemStack itemStack) {
        if (this.a == null) {
            return NULL_VALUE;
        }
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

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public NumericTag getReactorStat(IReactorPlannerComponent.ReactorStat reactorStat, ItemStack itemStack, IReactor iReactor, int i, int i2) {
        return super.getReactorStat(reactorStat, itemStack, iReactor, i, i2);
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ReactorType getSupportedReactor(ItemStack itemStack) {
        if (this.a != null && this.a.a() == b.ELECTRIC) {
            return IReactorPlannerComponent.ReactorType.ELECTRIC;
        }
        return IReactorPlannerComponent.ReactorType.UNIVERSAL;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public List<IReactorPlannerComponent.ReactorStat> getStats(ItemStack itemStack) {
        ObjectList objectListI = mctech.utils.a.b.i();
        if (this.a != null) {
            objectListI.add(IReactorPlannerComponent.ReactorStat.SELF_COOLING);
            objectListI.add(IReactorPlannerComponent.ReactorStat.REACTOR_COOLING);
            if (this.a.a() == b.ELECTRIC) {
                objectListI.add(IReactorPlannerComponent.ReactorStat.ENERGY_USAGE);
            }
        }
        return objectListI;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/j$a.class */
    public static class a {
        b a;
        int b;
        int c;
        int d;

        public a(b bVar, int i, int i2, int i3) {
            this.a = bVar;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }

        public b a() {
            return this.a;
        }

        public int b() {
            return this.d;
        }

        public int c() {
            return this.b;
        }

        public int d() {
            return this.c;
        }
    }
}
