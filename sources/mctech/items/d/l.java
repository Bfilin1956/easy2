package mctech.items.d;

import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import java.util.function.Consumer;
import mctech.api.reactor.IReactor;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.SimulatedStack;
import mctech.init.MCTechDataComponent;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/l.class */
public class l extends mctech.items.d.a.d {
    private mctech.items.d.a.b a;
    private short b;

    public l(mctech.items.d.a.b bVar, int i) {
        super(new mctech.items.base.o().c(bVar.a()));
        this.a = bVar;
        this.b = (short) i;
    }

    public l(mctech.items.base.o oVar, mctech.items.d.a.b bVar, short s) {
        super((oVar == null ? new mctech.items.base.o() : oVar).c(bVar.a()));
        this.a = bVar;
        this.b = s;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public void processChamber(ItemStack itemStack, IReactor iReactor, int i, int i2, boolean z, boolean z2) {
    }

    @Override // mctech.api.reactor.IReactorComponent
    public boolean acceptUraniumPulse(ItemStack itemStack, IReactor iReactor, ItemStack itemStack2, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int damage = (getDamage(itemStack) - 1) - (iReactor.getHeat() / 3000);
        if (damage <= 0) {
            iReactor.setStackInReactor(i, i2, this.a.o());
            return true;
        }
        setDamage(itemStack, damage);
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
        return 0.0f;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public SimulatedStack createSimulationComponent(ItemStack itemStack) {
        return new mctech.items.d.b.i(this.b, getMaxDamage(itemStack), 3000);
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public void addToolTip(ItemStack itemStack, Consumer<Component> consumer) {
        int iIntValue = ((Integer) itemStack.getOrDefault(MCTechDataComponent.BREED_ROD, 0)).intValue();
        if (iIntValue > 0) {
            consumer.accept(c("gui.mctech.reactor_planner.component.breed", Integer.valueOf(iIntValue)));
        }
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ReactorType getSupportedReactor(ItemStack itemStack) {
        return IReactorPlannerComponent.ReactorType.ELECTRIC;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ComponentType getType(ItemStack itemStack) {
        return IReactorPlannerComponent.ComponentType.ISOTOPE_CELL;
    }

    @Override // mctech.items.d.a.d, mctech.api.reactor.IReactorPlannerComponent
    public void provideComponents(NonNullList<ItemStack> nonNullList) {
        ItemStack itemStack = new ItemStack(this);
        itemStack.setDamageValue(itemStack.getMaxDamage());
        nonNullList.add(itemStack);
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
            return IntTag.valueOf(itemStack.getMaxDamage());
        }
        return NULL_VALUE;
    }
}
