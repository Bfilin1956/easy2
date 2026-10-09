package mctech.items.d;

import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import mctech.api.items.IRepairable;
import mctech.api.reactor.IReactor;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.SimulatedStack;
import mctech.init.MCTechDataComponent;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/c.class */
public class c extends mctech.items.d.a.d implements IRepairable {
    private short a;

    public c(int i, int i2) {
        super(new mctech.items.base.o().c(i));
        this.a = (short) i2;
    }

    public c(@Nullable mctech.items.base.o oVar, short s) {
        super(oVar);
        this.a = s;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public void processChamber(ItemStack itemStack, IReactor iReactor, int i, int i2, boolean z, boolean z2) {
    }

    @Override // mctech.api.reactor.IReactorComponent
    public boolean acceptUraniumPulse(ItemStack itemStack, IReactor iReactor, ItemStack itemStack2, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return false;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public boolean canStoreHeat(ItemStack itemStack, IReactor iReactor, int i, int i2) {
        return getDamage(itemStack) + 1 < getMaxDamage(itemStack);
    }

    @Override // mctech.api.reactor.IReactorComponent
    public int getStoredHeat(ItemStack itemStack, IReactor iReactor, int i, int i2) {
        return 0;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public int getMaxStoredHeat(ItemStack itemStack, IReactor iReactor, int i, int i2) {
        return getMaxDamage(itemStack);
    }

    @Override // mctech.api.reactor.IReactorComponent
    public int storeHeat(ItemStack itemStack, IReactor iReactor, int i, int i2, int i3) {
        int maxDamage = getMaxDamage(itemStack) - (getDamage(itemStack) + 1);
        if (maxDamage > i3) {
            maxDamage = i3;
        }
        setDamage(itemStack, getDamage(itemStack) + maxDamage);
        return i3 - maxDamage;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public float getExplosionInfluence(ItemStack itemStack, IReactor iReactor) {
        return 0.0f;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public SimulatedStack createSimulationComponent(ItemStack itemStack) {
        return new mctech.items.d.b.a(this.a, getMaxDamage(itemStack));
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public void addToolTip(ItemStack itemStack, Consumer<Component> consumer) {
        if (itemStack.has(MCTechDataComponent.TOTAL)) {
            consumer.accept(Component.translatable("gui.mctech.reactor_planner.component.condensator.total", new Object[]{itemStack.getOrDefault(MCTechDataComponent.TOTAL, 0)}));
            consumer.accept(Component.translatable("gui.mctech.reactor_planner.component.condensator.average", new Object[]{itemStack.getOrDefault(MCTechDataComponent.RESET, 0)}));
            consumer.accept(Component.translatable("gui.mctech.reactor_planner.component.condensator.reset", new Object[]{itemStack.getOrDefault(MCTechDataComponent.AVERAGE, Float.valueOf(0.0f))}));
        }
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ReactorType getSupportedReactor(ItemStack itemStack) {
        return IReactorPlannerComponent.ReactorType.UNIVERSAL;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ComponentType getType(ItemStack itemStack) {
        return IReactorPlannerComponent.ComponentType.CONDENSATOR;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public List<IReactorPlannerComponent.ReactorStat> getStats(ItemStack itemStack) {
        ObjectList objectListI = mctech.utils.a.b.i();
        objectListI.add(IReactorPlannerComponent.ReactorStat.HEAT_STORAGE);
        return objectListI;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public NumericTag getReactorStat(IReactorPlannerComponent.ReactorStat reactorStat, ItemStack itemStack) {
        if (reactorStat == IReactorPlannerComponent.ReactorStat.HEAT_STORAGE) {
            return IntTag.valueOf(getMaxDamage(itemStack));
        }
        return NULL_VALUE;
    }

    @Override // mctech.api.items.IRepairable
    public boolean repairDamage(ItemStack itemStack, int i) {
        if (itemStack.getDamageValue() > 0) {
            itemStack.setDamageValue(Math.max(0, itemStack.getDamageValue() - i));
            return true;
        }
        return false;
    }
}
