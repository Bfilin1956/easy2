package mctech.init;

import mctech.MCTech;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechStats.class */
public class MCTechStats {
    private static final DeferredRegister<ResourceLocation> STATS = DeferredRegister.create(BuiltInRegistries.CUSTOM_STAT, MCTech.MODID);
    public static final DeferredHolder<ResourceLocation, ResourceLocation> DROWNED_WITH_Q_HELMET = createStat("drown_with_q_helmet");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> CABLE_SHOCK_DAMAGE = createStat("cable_shock_damage");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> NUKES_SURVIVED = createStat("nukes_survived");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> NUKES_IGNITED = createStat("nukes_ignited");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> WITHERS_NUKED = createStat("withers_nuked");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> CHAINSAW_KILLS = createStat("chainsaws_kills");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> JETPACK_FLY_TIME = createStat("jetpack_fly_time");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> ROCKET_MODE_USED = createStat("rocket_mode_used");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> BLOCKS_DRILLED = createStat("blocks_drilled");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> BLOCKS_SAWED = createStat("blocks_sawed");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> DISTANCE_TELEPORTED = createStat("distance_teleported");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> FOAM_SPRAYED = createStat("foam_sprayed");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> FOOD_CANS_EATEN = createStat("food_cans_eaten");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> AIR_CELLS_USED = createStat("air_cells_used");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> OVERGROWTH_USED = createStat("overgrowth_used");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> REVIVED_USED = createStat("revived_used");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> ELECTRIC_ENCHANTED = createStat("electric_enchanted");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> TEXTURES_STOLEN = createStat("textures_stolen");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> LUCKY_PERSON = createStat("lucky_person");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> DRAGONS_SHOT = createStat("dragons_lasered");
    public static final DeferredHolder<ResourceLocation, ResourceLocation> PLAYERS_SHOT = createStat("laser_kills");

    public static void register(IEventBus iEventBus) {
        STATS.register(iEventBus);
    }

    public static DeferredHolder<ResourceLocation, ResourceLocation> createStat(String str) {
        return STATS.register(str, () -> {
            return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str);
        });
    }
}
