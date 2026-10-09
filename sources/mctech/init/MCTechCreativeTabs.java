package mctech.init;

import java.util.function.Consumer;
import mctech.MCTech;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechCreativeTabs.class */
public class MCTechCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCTech.MODID);
    public static final ResourceKey<CreativeModeTab> MAIN = ResourceKey.create(Registries.CREATIVE_MODE_TAB, MCTech.loc(MCTech.MODID));
    public static final ResourceKey<CreativeModeTab> CONDUITS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, MCTech.loc("conduits"));
    public static final ResourceKey<CreativeModeTab> MACHINES = ResourceKey.create(Registries.CREATIVE_MODE_TAB, MCTech.loc("machines"));
    public static final ResourceKey<CreativeModeTab> FLUIDS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, MCTech.loc("fluids"));
    public static final ResourceKey<CreativeModeTab> MATERIALS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, MCTech.loc("materials"));
    public static final ResourceKey<CreativeModeTab> TOOLS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, MCTech.loc("tools"));
    public static final ResourceKey<CreativeModeTab> ARMOR = ResourceKey.create(Registries.CREATIVE_MODE_TAB, MCTech.loc("armor"));
    public static final ResourceKey<CreativeModeTab> WEAPONS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, MCTech.loc("weapons"));
    public static final ResourceKey<CreativeModeTab> NUCLEAR = ResourceKey.create(Registries.CREATIVE_MODE_TAB, MCTech.loc("nuclear"));
    public static final ResourceKey<CreativeModeTab> ENERGY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, MCTech.loc("energy"));
    public static final ResourceKey<CreativeModeTab> UPGRADES = ResourceKey.create(Registries.CREATIVE_MODE_TAB, MCTech.loc("upgrades"));
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = createTab(MAIN, MCTech.MODID, "MCTech", "MCTech", builder -> {
        builder.icon(() -> {
            return new ItemStack((ItemLike) MCTechBlocks.NANO_MACHINE_BLOCK.get());
        }).withTabsBefore(new ResourceKey[]{CreativeModeTabs.SPAWN_EGGS});
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MACHINES_TAB = createTab(MACHINES, "machines", "MCS Machines", "Механизмы", builder -> {
        builder.icon(() -> {
            return new ItemStack(MCTechBlocks.REGISTERED_COBBLESTONE_GENERATORS.get(MachineTier.T4));
        }).withTabsBefore(new ResourceKey[]{MAIN});
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CONDUITS_TAB = createTab(CONDUITS, "conduits", "MCS Conduits", "Трубы", builder -> {
        builder.withTabsBefore(new ResourceKey[]{MACHINES});
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FLUIDS_TAB = createTab(FLUIDS, "fluids", "MCS Fluids", "Жидкости", builder -> {
        builder.icon(() -> {
            return new ItemStack((ItemLike) MCTechFluids.CELL_WATER.get());
        }).withTabsBefore(new ResourceKey[]{CONDUITS});
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MATERIALS_TAB = createTab(MATERIALS, "materials", "MCS Materials", "Материалы", builder -> {
        builder.icon(() -> {
            return new ItemStack((ItemLike) MCTechItems.INGOT_ADVANCED_ALLOY.get());
        }).withTabsAfter(new ResourceKey[]{CONDUITS});
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TOOLS_TAB = createTab(TOOLS, "tools", "MCS Tools", "Инструменты", builder -> {
        builder.icon(() -> {
            return new ItemStack((ItemLike) MCTechItems.ELECTRIC_WRENCH.get());
        }).withTabsAfter(new ResourceKey[]{MATERIALS});
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ARMOR_TAB = createTab(ARMOR, "armor", "MCS Armor", "Броня", builder -> {
        builder.icon(() -> {
            return new ItemStack((ItemLike) MCTechItems.QUANTUM_CHEST.get());
        }).withTabsAfter(new ResourceKey[]{TOOLS});
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WEAPONS_TAB = createTab(WEAPONS, "weapons", "MCS Weapons", "Оружие", builder -> {
        builder.icon(() -> {
            return new ItemStack((ItemLike) MCTechItems.QUANTUM_SABER.get());
        }).withTabsAfter(new ResourceKey[]{ARMOR});
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> NUCLEAR_TAB = createTab(NUCLEAR, "nuclear", "MCS Nuclear", "Ядерная энергетика", builder -> {
        builder.icon(() -> {
            return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_QUAD.get());
        }).withTabsBefore(new ResourceKey[]{ARMOR});
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ENERGY_TAB = createTab(ENERGY, "energy", "MCS Energy", "Энергетика", builder -> {
        builder.icon(() -> {
            return new ItemStack((ItemLike) MCTechBlocks.RUBID_MULTISOLAR_PANEL.get());
        }).withTabsBefore(new ResourceKey[]{MAIN});
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> UPGRADES_TAB = createTab(UPGRADES, "upgrades", "MCS Upgrades", "Улучшения", builder -> {
        builder.icon(() -> {
            return new ItemStack((ItemLike) MCTechItems.OVERCLOCKER_UPGRADE.get());
        }).withTabsBefore(new ResourceKey[]{ENERGY});
    });

    private static DeferredHolder<CreativeModeTab, CreativeModeTab> createTab(ResourceKey<CreativeModeTab> resourceKey, String str, String str2, String str3, Consumer<CreativeModeTab.Builder> consumer) {
        return CREATIVE_MODE_TABS.register(str, () -> {
            CreativeModeTab.Builder builderTitle = CreativeModeTab.builder().title(MCTech.REGISTRY.addTranslation("itemGroup", resourceKey.location(), str2, str3));
            consumer.accept(builderTitle);
            return builderTitle.build();
        });
    }

    public static void register(IEventBus iEventBus) {
        CREATIVE_MODE_TABS.register(iEventBus);
    }
}
