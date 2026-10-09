package mctech.api.reactor;

import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.text.DecimalFormat;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import mctech.api.reactor.planner.SimulatedStack;
import mctech.utils.a.b;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.NumericTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/reactor/IReactorPlannerComponent.class */
public interface IReactorPlannerComponent extends IReactorComponent {
    public static final DecimalFormat FORMAT = new DecimalFormat("###,###.##");
    public static final NumericTag NULL_VALUE = IntTag.valueOf(0);

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/reactor/IReactorPlannerComponent$ReactorType.class */
    public enum ReactorType {
        ELECTRIC,
        UNIVERSAL
    }

    void provideComponents(NonNullList<ItemStack> nonNullList);

    void addAffectedSlots(int i, int i2, BiPredicate<Integer, Integer> biPredicate);

    SimulatedStack createSimulationComponent(ItemStack itemStack);

    ReactorType getSupportedReactor(ItemStack itemStack);

    ComponentType getType(ItemStack itemStack);

    List<ReactorStat> getStats(ItemStack itemStack);

    NumericTag getReactorStat(ReactorStat reactorStat, ItemStack itemStack);

    default ItemStack applyStackSize(ItemStack itemStack, int i) {
        itemStack.setCount(Mth.clamp(i, 0, itemStack.getMaxStackSize()));
        return itemStack;
    }

    default int getStackSize(ItemStack itemStack) {
        return itemStack.getCount();
    }

    default void addToolTip(ItemStack itemStack, Consumer<Component> consumer) {
    }

    default NumericTag getReactorStat(ReactorStat reactorStat, ItemStack itemStack, IReactor iReactor, int i, int i2) {
        return getReactorStat(reactorStat, itemStack);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/reactor/IReactorPlannerComponent$ComponentType.class */
    public static class ComponentType {
        static final List<ComponentType> TYPES = ObjectLists.synchronize(b.i());
        public static final ComponentType FUEL_ROD = new ComponentType("gui.mctech.reactor_planner.component.fuel_rod");
        public static final ComponentType COOLANT_CELL = new ComponentType("gui.mctech.reactor_planner.component.coolant_cell");
        public static final ComponentType CONDENSATOR = new ComponentType("gui.mctech.reactor_planner.component.condensator");
        public static final ComponentType HEAT_PACK = new ComponentType("gui.mctech.reactor_planner.component.heat_pack");
        public static final ComponentType HEAT_VENT = new ComponentType("gui.mctech.reactor_planner.component.heat_vent");
        public static final ComponentType HEAT_SPREAD = new ComponentType("gui.mctech.reactor_planner.component.heat_spread");
        public static final ComponentType HEAT_EXCHANGER = new ComponentType("gui.mctech.reactor_planner.component.heat_exchanger");
        public static final ComponentType HEAT_PUMP = new ComponentType("gui.mctech.reactor_planner.component.heat_pump");
        public static final ComponentType PLATING = new ComponentType("gui.mctech.reactor_planner.component.plating");
        public static final ComponentType REFLECTORS = new ComponentType("gui.mctech.reactor_planner.component.reflectors");
        public static final ComponentType ISOTOPE_CELL = new ComponentType("gui.mctech.reactor_planner.component.isotope_cell");
        public static final ComponentType UNDEFINED = new ComponentType("gui.mctech.reactor_planner.component.undefined");
        int index = TYPES.size();
        Component name;

        public ComponentType(String str) {
            this.name = Component.translatable(str);
            TYPES.add(this);
        }

        public Component getName() {
            return this.name;
        }

        public int getIndex() {
            return this.index;
        }

        public static int size() {
            return TYPES.size();
        }

        public static ComponentType byID(int i) {
            return TYPES.get(i % TYPES.size());
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/reactor/IReactorPlannerComponent$ReactorStat.class */
    public enum ReactorStat {
        HEAT_PRODUCTION(false, "gui.mctech.reactor_planner.stat.heat_production"),
        ENERGY_PRODUCTION(true, "gui.mctech.reactor_planner.stat.energy_production"),
        ROD_COUNT(false, "gui.mctech.reactor_planner.stat.rod_count"),
        PULSE_COUNT(false, "gui.mctech.reactor_planner.stat.pulse_count"),
        SELF_COOLING(false, "gui.mctech.reactor_planner.stat.self_cooling"),
        REACTOR_COOLING(false, "gui.mctech.reactor_planner.stat.reactor_cooling"),
        PART_COOLING(false, "gui.mctech.reactor_planner.stat.part_cooling"),
        PART_BALANCING(false, "gui.mctech.reactor_planner.stat.part_balance"),
        REACTOR_BALANCING(false, "gui.mctech.reactor_planner.stat.reactor_balance"),
        HEAT_STORAGE(false, "gui.mctech.reactor_planner.stat.heat_storage"),
        MAX_HEAT_STORAGE(false, "gui.mctech.reactor_planner.stat.max_heat_storage"),
        REACTOR_HEAT_EFFECT_MODIFIER(true, "gui.mctech.reactor_planner.stat.reactor_hem"),
        REACTOR_HEAT_EFFECT_MULTIPLIER(true, "gui.mctech.reactor_planner.stat.reactor_hem_mul"),
        MAX_COMPONENT_DURABILITY(false, "gui.mctech.reactor_planner.stat.max_durability"),
        RECHARGEABLE(false, "gui.mctech.reactor_planner.stat.rechargeable"),
        ENERGY_USAGE(true, "gui.mctech.reactor_planner.stat.energy_usage"),
        WATER_CONSUMPTION(true, "gui.mctech.reactor_planner.stat.water_consumption"),
        WATER_STORAGE(true, "gui.mctech.reactor_planner.stat.water_storage");

        boolean isFloat;
        String name;

        ReactorStat(boolean z, String str) {
            this.isFloat = z;
            this.name = str;
        }

        public NumericTag createStat(Number number) {
            if (this.isFloat) {
                return FloatTag.valueOf(number.floatValue());
            }
            return IntTag.valueOf(number.intValue());
        }

        public boolean isFloat() {
            return this.isFloat;
        }

        public Component getName(NumericTag numericTag) {
            String str = this.name;
            Object[] objArr = new Object[1];
            objArr[0] = this.isFloat ? IReactorPlannerComponent.FORMAT.format(numericTag.getAsDouble()) : IReactorPlannerComponent.FORMAT.format(numericTag.getAsLong());
            return Component.translatable(str, objArr);
        }
    }
}
