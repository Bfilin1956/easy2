package mctech.items.d;

import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import mctech.api.reactor.IReactor;
import mctech.api.reactor.IReactorPlannerComponent;
import mctech.api.reactor.planner.SimulatedStack;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/m.class */
public class m extends mctech.items.d.a.d {
    private int a;
    private float b;
    private short c;

    public m(int i, float f, int i2) {
        super(null);
        this.a = i;
        this.b = f;
        this.c = (short) i2;
    }

    public m(mctech.items.base.o oVar, int i, float f, int i2) {
        super(oVar);
        this.a = i;
        this.b = f;
        this.c = (short) i2;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public void processChamber(ItemStack itemStack, IReactor iReactor, int i, int i2, boolean z, boolean z2) {
        if (z) {
            iReactor.setMaxHeat(iReactor.getMaxHeat() + this.a);
            iReactor.setHeatEffectModifier(iReactor.getHeatEffectModifier() * this.b);
        }
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
        return 0;
    }

    @Override // mctech.api.reactor.IReactorComponent
    public float getExplosionInfluence(ItemStack itemStack, IReactor iReactor) {
        if (this.b >= 1.0f) {
            return 0.0f;
        }
        return this.b;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public SimulatedStack createSimulationComponent(ItemStack itemStack) {
        return new mctech.items.d.b.j(this.c, this.a, this.b);
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ReactorType getSupportedReactor(ItemStack itemStack) {
        return IReactorPlannerComponent.ReactorType.UNIVERSAL;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public IReactorPlannerComponent.ComponentType getType(ItemStack itemStack) {
        return IReactorPlannerComponent.ComponentType.PLATING;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public List<IReactorPlannerComponent.ReactorStat> getStats(ItemStack itemStack) {
        ObjectList objectListI = mctech.utils.a.b.i();
        objectListI.add(IReactorPlannerComponent.ReactorStat.MAX_HEAT_STORAGE);
        objectListI.add(IReactorPlannerComponent.ReactorStat.REACTOR_HEAT_EFFECT_MULTIPLIER);
        return objectListI;
    }

    @Override // mctech.api.reactor.IReactorPlannerComponent
    public NumericTag getReactorStat(IReactorPlannerComponent.ReactorStat reactorStat, ItemStack itemStack) {
        if (reactorStat == IReactorPlannerComponent.ReactorStat.MAX_HEAT_STORAGE) {
            return IntTag.valueOf(this.a);
        }
        if (reactorStat == IReactorPlannerComponent.ReactorStat.REACTOR_HEAT_EFFECT_MULTIPLIER) {
            return FloatTag.valueOf(this.b);
        }
        return NULL_VALUE;
    }
}
