package mctech.init;

import java.util.Objects;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.g.d.c.n;
import mctech.o.a;
import mctech.o.b;
import mctech.o.c;
import mctech.o.d;
import mctech.o.e;
import mctech.o.h;
import mctech.o.i;
import net.mcskill.msregistry.registry.type.MenuRegistry;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechMenus.class */
public class MCTechMenus {
    private static final MenuRegistry MENU_REGISTRY = MCTech.REGISTRY.menuRegistry();
    public static final DeferredHolder<MenuType<?>, MenuType<b>> DIGGER_EQUIPMENT_MENU = MENU_REGISTRY.register("digger_menu", () -> {
        return IMenuTypeExtension.create(d.a(b::new));
    });
    public static final Supplier<MenuType<a>> ARMOR_EQUIPMENT_MENU = MENU_REGISTRY.register("equipment_menu", () -> {
        return IMenuTypeExtension.create(c.a(a::new));
    });
    public static final Supplier<MenuType<i>> SINGULAR_ARMOR_MENU = MENU_REGISTRY.register("singular_armor_menu", () -> {
        return IMenuTypeExtension.create(i.e());
    });
    public static final Supplier<MenuType<h>> SABER_EQUIPMENT_MENU = MENU_REGISTRY.register("saber_menu", () -> {
        return IMenuTypeExtension.create(e.a(h::new));
    });
    public static final DeferredHolder<MenuType<?>, MenuType<mctech.g.d.a.b.b.c>> BASIC_ITEM_FILTER;
    public static final DeferredHolder<MenuType<?>, MenuType<mctech.g.d.a.b.b.c>> ADVANCED_ITEM_FILTER;
    public static final DeferredHolder<MenuType<?>, MenuType<mctech.g.d.a.b.b.c>> BIG_ITEM_FILTER;
    public static final DeferredHolder<MenuType<?>, MenuType<mctech.g.d.a.b.b.c>> BIG_ADVANCED_ITEM_FILTER;
    public static final DeferredHolder<MenuType<?>, MenuType<mctech.g.d.a.b.a.c>> BASIC_FLUID_FILTER;
    public static final DeferredHolder<MenuType<?>, MenuType<mctech.g.d.a.b.b.a.c>> LIMITED_ITEM_FILTER;
    public static final DeferredHolder<MenuType<?>, MenuType<mctech.g.d.a.c.a>> CONDUIT_MENU;
    public static final DeferredHolder<MenuType<?>, MenuType<mctech.g.d.c.e>> REDSTONE_DOUBLE_CHANNEL_FILTER;
    public static final DeferredHolder<MenuType<?>, MenuType<n>> REDSTONE_TIMER_FILTER;
    public static final DeferredHolder<MenuType<?>, MenuType<mctech.g.d.c.d>> REDSTONE_COUNT_FILTER;

    static {
        mctech.g.d.a.b.b.b.a aVar = mctech.g.d.a.b.b.b.a.BASIC;
        Objects.requireNonNull(aVar);
        BASIC_ITEM_FILTER = register("basic_item_filter", aVar::a);
        mctech.g.d.a.b.b.b.a aVar2 = mctech.g.d.a.b.b.b.a.ADVANCED;
        Objects.requireNonNull(aVar2);
        ADVANCED_ITEM_FILTER = register("advanced_item_filter", aVar2::a);
        mctech.g.d.a.b.b.b.a aVar3 = mctech.g.d.a.b.b.b.a.BIG;
        Objects.requireNonNull(aVar3);
        BIG_ITEM_FILTER = register("big_item_filter", aVar3::a);
        mctech.g.d.a.b.b.b.a aVar4 = mctech.g.d.a.b.b.b.a.BIG_ADVANCED;
        Objects.requireNonNull(aVar4);
        BIG_ADVANCED_ITEM_FILTER = register("big_advanced_item_filter", aVar4::a);
        mctech.g.d.a.b.a.b.a aVar5 = mctech.g.d.a.b.a.b.a.BASIC;
        Objects.requireNonNull(aVar5);
        BASIC_FLUID_FILTER = register("basic_fluid_filter", aVar5::a);
        LIMITED_ITEM_FILTER = register("limited_item_filter", mctech.g.d.a.b.b.a.b::a);
        CONDUIT_MENU = register("conduit", mctech.g.d.a.c.a::new);
        REDSTONE_DOUBLE_CHANNEL_FILTER = register("redstone_and_filter", mctech.g.d.c.e::a);
        REDSTONE_TIMER_FILTER = register("redstone_timer_filter", n::a);
        REDSTONE_COUNT_FILTER = register("redstone_count_filter", mctech.g.d.c.d::a);
    }

    private static <M extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<M>> register(String str, MenuType.MenuSupplier<M> menuSupplier) {
        return MENU_REGISTRY.register(str, () -> {
            return new MenuType(menuSupplier, FeatureFlags.DEFAULT_FLAGS);
        });
    }

    private static <M extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<M>> register(String str, MenuType.MenuSupplier<M> menuSupplier, FeatureFlagSet featureFlagSet) {
        return MENU_REGISTRY.register(str, () -> {
            return new MenuType(menuSupplier, featureFlagSet);
        });
    }

    private static <M extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<M>> register(String str, IContainerFactory<M> iContainerFactory) {
        return MENU_REGISTRY.register(str, () -> {
            return new MenuType(iContainerFactory, FeatureFlags.DEFAULT_FLAGS);
        });
    }

    private static <M extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<M>> register(String str, IContainerFactory<M> iContainerFactory, FeatureFlagSet featureFlagSet) {
        return MENU_REGISTRY.register(str, () -> {
            return new MenuType(iContainerFactory, featureFlagSet);
        });
    }

    public static void register(IEventBus iEventBus) {
        MENU_REGISTRY.register(iEventBus);
    }
}
