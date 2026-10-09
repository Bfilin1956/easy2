package mctech.init;

import mctech.MCTech;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechSounds.class */
public class MCTechSounds {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, MCTech.MODID);
    public static final DeferredHolder<SoundEvent, SoundEvent> INTERRUPTION = register(MCTech.loc("sounds/machines/base/interruption.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> MACERATOR = register(MCTech.loc("sounds/machines/base/macerator_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> IRON_FURNACE = register(MCTech.loc("sounds/machines/base/iron_furnace_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> ELECTRIC_FURNACE = register(MCTech.loc("sounds/machines/base/electric_furnace_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> EXTRACTOR = register(MCTech.loc("sounds/machines/base/extractor_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> RECYCLER = register(MCTech.loc("sounds/machines/base/recycler_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> COMPRESSOR = register(MCTech.loc("sounds/machines/base/compressor_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> MASS_FABRICATOR = register(MCTech.loc("sounds/machines/mass_fab/massfab_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> MASS_FABRICATOR_ALT = register(MCTech.loc("sounds/machines/mass_fab/massfab_solo_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> LIQUID_GENERATOR = register(MCTech.loc("sounds/machines/liquid_generator/processing.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> PUMP = register(MCTech.loc("sounds/machines/base/pump_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> TELEPORT = register(MCTech.loc("sounds/machines/teleport.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> ELECTROLYZER = register(MCTech.loc("sounds/machines/electrolyzer_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> MAGNETIZER = register(MCTech.loc("sounds/machines/magnetizer_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> MINER = register(MCTech.loc("sounds/machines/miner_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> GENERATOR = register(MCTech.loc("sounds/generators/generator_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> GEOTHERMAL = register(MCTech.loc("sounds/generators/geothermal_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> WATERMILL = register(MCTech.loc("sounds/generators/watermill_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> REACTOR = register(MCTech.loc("sounds/generators/reactor/nuclear_reactor_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> REACTOR_LOW = register(MCTech.loc("sounds/generators/reactor/geiger_low.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> REACTOR_MEDIUM = register(MCTech.loc("sounds/generators/reactor/geiger_med.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> REACTOR_HIGH = register(MCTech.loc("sounds/generators/reactor/geiger_high.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> WINDMILL = register(MCTech.loc("sounds/generators/windmill_operating.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> TOOL_TREE_TAP = register(MCTech.loc("sounds/tools/treetap.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> TOOL_WRENCH = register(MCTech.loc("sounds/tools/wrench.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> TOOL_SCANNER = register(MCTech.loc("sounds/tools/scanner.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> TOOL_PAINTER = register(MCTech.loc("sounds/tools/painter.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> TOOL_CUTTER = register(MCTech.loc("sounds/tools/cutter.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> TOOL_CHAINSAW_IDLE = register(MCTech.loc("sounds/tools/chainsaw/chainsaw_idle.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> TOOL_CHAINSAW_STOP = register(MCTech.loc("sounds/tools/chainsaw/chainsaw_stop.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> TOOL_CHAINSAW_USE = register(MCTech.loc("sounds/tools/chainsaw/chainsaw_use_one.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> TOOL_CHAINSAW_USE_ALT = register(MCTech.loc("sounds/tools/chainsaw/chainsaw_use_two.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> TOOL_DRILL_IDLE = register(MCTech.loc("sounds/tools/drill/drill_use_loop.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> TOOL_DRILL_SOFT = register(MCTech.loc("sounds/tools/drill/drill_soft.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> TOOL_DRILL_HARD = register(MCTech.loc("sounds/tools/drill/drill_hard.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> TOOL_JETPACK_START = register(MCTech.loc("sounds/tools/jetpack/jetpack_fire.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> TOOL_JETPACK_IDLE = register(MCTech.loc("sounds/tools/jetpack/jetpack_loop.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> ATOMIC_SMELTER_OVERHEAT = register(MCTech.loc("sounds/machines/atomic_smelter/overheat.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> MISC_POP = register(MCTech.loc("sounds/misc/pop.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> BATTERY = register(MCTech.loc("sounds/tools/battery.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> DESTROYER_MODE_SWITCH = register(MCTech.loc("sounds/tools/destroyer/mode_switch.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> DESTROYER_SECONDARY_ACTION = register(MCTech.loc("sounds/tools/destroyer/right_action.ogg"));
    public static final DeferredHolder<SoundEvent, SoundEvent> DESTROYER_SECONDARY_ACTION_ALT = register(MCTech.loc("sounds/tools/destroyer/right_action_variant.ogg"));

    private static DeferredHolder<SoundEvent, SoundEvent> register(String str, ResourceLocation resourceLocation) {
        return REGISTRY.register(str, () -> {
            return SoundEvent.createVariableRangeEvent(resourceLocation);
        });
    }

    public static DeferredHolder<SoundEvent, SoundEvent> register(ResourceLocation resourceLocation) {
        String strSubstring = resourceLocation.getPath().substring(resourceLocation.getPath().lastIndexOf(47) + 1);
        return register(strSubstring.substring(0, strSubstring.indexOf(".")), resourceLocation);
    }

    public static void register(IEventBus iEventBus) {
        REGISTRY.register(iEventBus);
    }
}
