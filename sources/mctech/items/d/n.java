package mctech.items.d;

import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import java.util.function.Consumer;
import mctech.api.reactor.IReactor;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.SimulatedStack;
import mctech.init.MCTechDataComponent;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/n.class */
public class n extends mctech.items.d.a.d {
    private boolean a;
    private short b;

    public n(int i, boolean z, int i2) {
        super(new mctech.items.base.o().c(i));
        this.a = z;
        this.b = (short) i2;
    }

    public n(mctech.items.base.o oVar, boolean z, int i) {
        super(oVar);
        this.a = z;
        this.b = (short) i;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public void processChamber(ItemStack itemStack, IReactor iReactor, int i, int i2, boolean z, boolean z2) {
    }

    @Override // mctech.api.reactor.IReactorComponent
    public boolean acceptUraniumPulse(ItemStack itemStack, IReactor iReactor, ItemStack itemStack2, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        if (this.a && getDamage(itemStack) >= getMaxDamage(itemStack)) {
            return false;
        }
        if (!z) {
            iReactor.addOutput(1.0f);
        }
        if (z2) {
            if (getDamage(itemStack) >= getMaxDamage(itemStack)) {
                iReactor.setStackInReactor(i, i2, ItemStack.EMPTY);
                return true;
            }
            setDamage(itemStack, getDamage(itemStack) + 1);
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
        return -1.0f;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public SimulatedStack createSimulationComponent(ItemStack itemStack) {
        return new mctech.items.d.b.k(this.b, getMaxDamage(itemStack), this.a);
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public void addToolTip(ItemStack itemStack, Consumer<Component> consumer) {
        int iIntValue = ((Integer) itemStack.getOrDefault(MCTechDataComponent.REFILLED, 0)).intValue();
        if (iIntValue > 0) {
            consumer.accept(Component.translatable("gui.mctech.reactor_planner.component.refills", new Object[]{Integer.valueOf(iIntValue)}));
        }
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ReactorType getSupportedReactor(ItemStack itemStack) {
        return IReactorPlannerComponent.ReactorType.UNIVERSAL;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ComponentType getType(ItemStack itemStack) {
        return IReactorPlannerComponent.ComponentType.REFLECTORS;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public List<IReactorPlannerComponent.ReactorStat> getStats(ItemStack itemStack) {
        ObjectList objectListI = mctech.utils.a.b.i();
        objectListI.add(IReactorPlannerComponent.ReactorStat.MAX_COMPONENT_DURABILITY);
        return objectListI;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public NumericTag getReactorStat(IReactorPlannerComponent.ReactorStat reactorStat, ItemStack itemStack) {
        if (reactorStat == IReactorPlannerComponent.ReactorStat.MAX_COMPONENT_DURABILITY) {
            return IntTag.valueOf(getMaxDamage(itemStack));
        }
        return NULL_VALUE;
    }
}
