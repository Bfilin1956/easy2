package mctech.api.reactor.planner;

import java.util.List;
import mctech.api.reactor.IReactorPlannerComponent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/reactor/planner/SimulatedStack.class */
public interface SimulatedStack {
    public static final NumericTag NULL_VALUE = IntTag.valueOf(0);

    ItemStack syncStack(ItemStack itemStack);

    CompoundTag save();

    void load(CompoundTag compoundTag);

    void commitState();

    void reset();

    void simulate(ISimulatedReactor iSimulatedReactor, int i, int i2, boolean z, boolean z2);

    boolean acceptUraniumPulse(ISimulatedReactor iSimulatedReactor, int i, int i2, SimulatedStack simulatedStack, int i3, int i4, boolean z, boolean z2);

    boolean canStoreHeat(ISimulatedReactor iSimulatedReactor, int i, int i2);

    int getStoredHeat(ISimulatedReactor iSimulatedReactor, int i, int i2);

    int getMaxStoredHeat(ISimulatedReactor iSimulatedReactor, int i, int i2);

    int storeHeat(ISimulatedReactor iSimulatedReactor, int i, int i2, int i3);

    boolean canViewHeat(ISimulatedReactor iSimulatedReactor, int i, int i2);

    float getExplosionInfluence(ISimulatedReactor iSimulatedReactor);

    short getId();

    List<IReactorPlannerComponent.ReactorStat> getStats();

    IReactorPlannerComponent.ReactorType getValidType();

    IReactorPlannerComponent.ComponentType getComponentType();

    NumericTag getStat(IReactorPlannerComponent.ReactorStat reactorStat);

    default NumericTag getStat(IReactorPlannerComponent.ReactorStat reactorStat, ISimulatedReactor iSimulatedReactor, int i, int i2) {
        return getStat(reactorStat);
    }
}
