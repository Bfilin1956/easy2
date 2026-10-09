package mctech.init;

import appeng.api.util.AEColor;
import mctech.MCTech;
import mctech.blockentities.c.C0074u;
import mctech.g.a.a;
import mctech.g.a.l;
import mctech.g.d.a.d.f.d;
import mctech.q.c;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechConduits.class */
public class MCTechConduits {
    public static ResourceKey<a<?, ?>> FE_ENERGY = ResourceKey.create(l.a.f, MCTech.loc("energy"));
    public static ResourceKey<a<?, ?>> FE_ENHANCED_ENERGY = ResourceKey.create(l.a.f, MCTech.loc("enhanced_energy"));
    public static ResourceKey<a<?, ?>> REDSTONE = ResourceKey.create(l.a.f, MCTech.loc("redstone"));
    public static ResourceKey<a<?, ?>> EU_ALUMINUM = ResourceKey.create(l.a.f, MCTech.loc("eu_energy/aluminum"));
    public static ResourceKey<a<?, ?>> EU_BRONZE = ResourceKey.create(l.a.f, MCTech.loc("eu_energy/bronze"));
    public static ResourceKey<a<?, ?>> EU_COMPOSITE = ResourceKey.create(l.a.f, MCTech.loc("eu_energy/composite"));
    public static ResourceKey<a<?, ?>> EU_COPPER = ResourceKey.create(l.a.f, MCTech.loc("eu_energy/copper"));
    public static ResourceKey<a<?, ?>> EU_GLASS = ResourceKey.create(l.a.f, MCTech.loc("eu_energy/glass"));
    public static ResourceKey<a<?, ?>> EU_GOLD = ResourceKey.create(l.a.f, MCTech.loc("eu_energy/gold"));
    public static ResourceKey<a<?, ?>> EU_IRON = ResourceKey.create(l.a.f, MCTech.loc("eu_energy/iron"));
    public static ResourceKey<a<?, ?>> EU_NANO = ResourceKey.create(l.a.f, MCTech.loc("eu_energy/nano"));
    public static ResourceKey<a<?, ?>> EU_NETHERITE = ResourceKey.create(l.a.f, MCTech.loc("eu_energy/netherite"));
    public static ResourceKey<a<?, ?>> EU_QUANTUM = ResourceKey.create(l.a.f, MCTech.loc("eu_energy/quantum"));
    public static ResourceKey<a<?, ?>> EU_RUBIDIUM = ResourceKey.create(l.a.f, MCTech.loc("eu_energy/rubidium"));
    public static ResourceKey<a<?, ?>> EU_SINGULARITY = ResourceKey.create(l.a.f, MCTech.loc("eu_energy/singularity"));
    public static ResourceKey<a<?, ?>> EU_TIN = ResourceKey.create(l.a.f, MCTech.loc("eu_energy/tin"));
    public static ResourceKey<a<?, ?>> FLUID_COAL = ResourceKey.create(l.a.f, MCTech.loc("fluid/coal"));
    public static ResourceKey<a<?, ?>> FLUID_REDSTONE = ResourceKey.create(l.a.f, MCTech.loc("fluid/redstone"));
    public static ResourceKey<a<?, ?>> FLUID_LAPIS = ResourceKey.create(l.a.f, MCTech.loc("fluid/lapis"));
    public static ResourceKey<a<?, ?>> FLUID_AMETHYST = ResourceKey.create(l.a.f, MCTech.loc("fluid/amethyst"));
    public static ResourceKey<a<?, ?>> FLUID_QUARTZ = ResourceKey.create(l.a.f, MCTech.loc("fluid/quartz"));
    public static ResourceKey<a<?, ?>> FLUID_LUMINITE = ResourceKey.create(l.a.f, MCTech.loc("fluid/luminite"));
    public static ResourceKey<a<?, ?>> FLUID_DIAMOND = ResourceKey.create(l.a.f, MCTech.loc("fluid/diamond"));
    public static ResourceKey<a<?, ?>> FLUID_EMERALD = ResourceKey.create(l.a.f, MCTech.loc("fluid/emerald"));
    public static ResourceKey<a<?, ?>> FLUID_RUBY = ResourceKey.create(l.a.f, MCTech.loc("fluid/ruby"));
    public static ResourceKey<a<?, ?>> FLUID_ZIRCON = ResourceKey.create(l.a.f, MCTech.loc("fluid/zircon"));
    public static ResourceKey<a<?, ?>> FLUID_SAPPHIRE = ResourceKey.create(l.a.f, MCTech.loc("fluid/sapphire"));
    public static ResourceKey<a<?, ?>> ITEM_COAL = ResourceKey.create(l.a.f, MCTech.loc("item/coal"));
    public static ResourceKey<a<?, ?>> ITEM_REDSTONE = ResourceKey.create(l.a.f, MCTech.loc("item/redstone"));
    public static ResourceKey<a<?, ?>> ITEM_LAPIS = ResourceKey.create(l.a.f, MCTech.loc("item/lapis"));
    public static ResourceKey<a<?, ?>> ITEM_AMETHYST = ResourceKey.create(l.a.f, MCTech.loc("item/amethyst"));
    public static ResourceKey<a<?, ?>> ITEM_QUARTZ = ResourceKey.create(l.a.f, MCTech.loc("item/quartz"));
    public static ResourceKey<a<?, ?>> ITEM_LUMINITE = ResourceKey.create(l.a.f, MCTech.loc("item/luminite"));
    public static ResourceKey<a<?, ?>> ITEM_DIAMOND = ResourceKey.create(l.a.f, MCTech.loc("item/diamond"));
    public static ResourceKey<a<?, ?>> ITEM_EMERALD = ResourceKey.create(l.a.f, MCTech.loc("item/emerald"));
    public static ResourceKey<a<?, ?>> ITEM_RUBY = ResourceKey.create(l.a.f, MCTech.loc("item/ruby"));
    public static ResourceKey<a<?, ?>> ITEM_ZIRCON = ResourceKey.create(l.a.f, MCTech.loc("item/zircon"));
    public static ResourceKey<a<?, ?>> ITEM_SAPPHIRE = ResourceKey.create(l.a.f, MCTech.loc("item/sapphire"));
    public static ResourceKey<a<?, ?>> ME_NORMAL = ResourceKey.create(l.a.f, MCTech.loc("me"));
    public static ResourceKey<a<?, ?>> ME_DENSE = ResourceKey.create(l.a.f, MCTech.loc("dense_me"));
    public static ResourceKey<a<?, ?>> HEAT = ResourceKey.create(l.a.f, MCTech.loc("heat"));

    public static void bootstrap(BootstrapContext<a<?, ?>> bootstrapContext) {
        bootstrapOtherConduits(bootstrapContext);
        bootstrapItemConduits(bootstrapContext);
        bootstrapFluidConduits(bootstrapContext);
        bootstrapEUEnergyConduits(bootstrapContext);
        bootstrapMEConduits(bootstrapContext);
    }

    private static void bootstrapMEConduits(BootstrapContext<a<?, ?>> bootstrapContext) {
        register(bootstrapContext, ME_NORMAL, new d(MCTech.loc("block/conduit/me"), MCTechLang.ME_CONDUIT, AEColor.TRANSPARENT, false));
        register(bootstrapContext, ME_DENSE, new d(MCTech.loc("block/conduit/dense_me"), MCTechLang.ME_DENSE_CONDUIT, AEColor.TRANSPARENT, true));
    }

    private static void bootstrapOtherConduits(BootstrapContext<a<?, ?>> bootstrapContext) {
        register(bootstrapContext, FE_ENERGY, new mctech.g.d.a.d.a.a(MCTech.loc("block/conduit/energy"), MCTechLang.ENERGY_CONDUIT, 1000));
        register(bootstrapContext, FE_ENHANCED_ENERGY, new mctech.g.d.a.d.a.a(MCTech.loc("block/conduit/enhanced_energy"), MCTechLang.ENHANCED_ENERGY_CONDUIT, 12000));
        register(bootstrapContext, REDSTONE, new mctech.g.d.a.d.g.a(MCTech.loc("block/conduit/redstone"), MCTech.loc("block/conduit/redstone_active"), MCTechLang.REDSTONE_CONDUIT));
        if (MCTech.isFrozen()) {
            register(bootstrapContext, HEAT, new mctech.g.d.a.d.d.a(MCTech.loc("block/conduit/heat"), MCTechLang.HEAT_CONDUIT, 1000));
        }
    }

    private static void bootstrapEUEnergyConduits(BootstrapContext<a<?, ?>> bootstrapContext) {
        register(bootstrapContext, EU_TIN, new mctech.g.d.a.d.b.a(MCTech.loc("block/conduit/eu_energy/tin"), MCTechLang.EU_ENERGY_CONDUIT_TIN, 6, 5));
        register(bootstrapContext, EU_COPPER, new mctech.g.d.a.d.b.a(MCTech.loc("block/conduit/eu_energy/copper"), MCTechLang.EU_ENERGY_CONDUIT_COPPER, 33, 32));
        register(bootstrapContext, EU_GOLD, new mctech.g.d.a.d.b.a(MCTech.loc("block/conduit/eu_energy/gold"), MCTechLang.EU_ENERGY_CONDUIT_GOLD, 129, 128));
        register(bootstrapContext, EU_IRON, new mctech.g.d.a.d.b.a(MCTech.loc("block/conduit/eu_energy/iron"), MCTechLang.EU_ENERGY_CONDUIT_IRON, 129, 128));
        register(bootstrapContext, EU_BRONZE, new mctech.g.d.a.d.b.a(MCTech.loc("block/conduit/eu_energy/bronze"), MCTechLang.EU_ENERGY_CONDUIT_BRONZE, 129, 128));
        register(bootstrapContext, EU_ALUMINUM, new mctech.g.d.a.d.b.a(MCTech.loc("block/conduit/eu_energy/aluminum"), MCTechLang.EU_ENERGY_CONDUIT_ALUMINUM, 129, 128));
        register(bootstrapContext, EU_GLASS, new mctech.g.d.a.d.b.a(MCTech.loc("block/conduit/eu_energy/glass"), MCTechLang.EU_ENERGY_CONDUIT_GLASS, 513, c.c));
        register(bootstrapContext, EU_NETHERITE, new mctech.g.d.a.d.b.a(MCTech.loc("block/conduit/eu_energy/netherite"), MCTechLang.EU_ENERGY_CONDUIT_NETHERITE, 2049, 2048));
        register(bootstrapContext, EU_COMPOSITE, new mctech.g.d.a.d.b.a(MCTech.loc("block/conduit/eu_energy/composite"), MCTechLang.EU_ENERGY_CONDUIT_COMPOSITE, 4097, 4096));
        register(bootstrapContext, EU_NANO, new mctech.g.d.a.d.b.a(MCTech.loc("block/conduit/eu_energy/nano"), MCTechLang.EU_ENERGY_CONDUIT_NANO, 8193, c.a));
        register(bootstrapContext, EU_QUANTUM, new mctech.g.d.a.d.b.a(MCTech.loc("block/conduit/eu_energy/quantum"), MCTechLang.EU_ENERGY_CONDUIT_QUANTUM, 16385, C0074u.o));
        register(bootstrapContext, EU_SINGULARITY, new mctech.g.d.a.d.b.a(MCTech.loc("block/conduit/eu_energy/singularity"), MCTechLang.EU_ENERGY_CONDUIT_SINGULARITY, 32769, 32768));
        register(bootstrapContext, EU_RUBIDIUM, new mctech.g.d.a.d.b.a(MCTech.loc("block/conduit/eu_energy/rubidium"), MCTechLang.EU_ENERGY_CONDUIT_RUBIDIUM, 131072, 131072));
    }

    private static void bootstrapFluidConduits(BootstrapContext<a<?, ?>> bootstrapContext) {
        register(bootstrapContext, FLUID_COAL, new mctech.g.d.a.d.c.a(MCTech.loc("block/conduit/fluid/coal"), MCTechLang.FLUID_CONDUIT_COAL, 200, false, false));
        register(bootstrapContext, FLUID_REDSTONE, new mctech.g.d.a.d.c.a(MCTech.loc("block/conduit/fluid/redstone"), MCTechLang.FLUID_CONDUIT_REDSTONE, 400, false, false));
        register(bootstrapContext, FLUID_LAPIS, new mctech.g.d.a.d.c.a(MCTech.loc("block/conduit/fluid/lapis"), MCTechLang.FLUID_CONDUIT_LAPIS, 800, false, false));
        register(bootstrapContext, FLUID_AMETHYST, new mctech.g.d.a.d.c.a(MCTech.loc("block/conduit/fluid/amethyst"), MCTechLang.FLUID_CONDUIT_AMETHYST, 1600, false, false));
        register(bootstrapContext, FLUID_QUARTZ, new mctech.g.d.a.d.c.a(MCTech.loc("block/conduit/fluid/quartz"), MCTechLang.FLUID_CONDUIT_QUARTZ, 3200, false, false));
        register(bootstrapContext, FLUID_LUMINITE, new mctech.g.d.a.d.c.a(MCTech.loc("block/conduit/fluid/luminite"), MCTechLang.FLUID_CONDUIT_LUMINITE, 6400, true, true));
        register(bootstrapContext, FLUID_DIAMOND, new mctech.g.d.a.d.c.a(MCTech.loc("block/conduit/fluid/diamond"), MCTechLang.FLUID_CONDUIT_DIAMOND, 12800, true, true));
        register(bootstrapContext, FLUID_EMERALD, new mctech.g.d.a.d.c.a(MCTech.loc("block/conduit/fluid/emerald"), MCTechLang.FLUID_CONDUIT_EMERALD, 25600, true, true));
        register(bootstrapContext, FLUID_RUBY, new mctech.g.d.a.d.c.a(MCTech.loc("block/conduit/fluid/ruby"), MCTechLang.FLUID_CONDUIT_RUBY, 51200, true, true));
        register(bootstrapContext, FLUID_ZIRCON, new mctech.g.d.a.d.c.a(MCTech.loc("block/conduit/fluid/zircon"), MCTechLang.FLUID_CONDUIT_ZIRCON, 102400, true, true));
        register(bootstrapContext, FLUID_SAPPHIRE, new mctech.g.d.a.d.c.a(MCTech.loc("block/conduit/fluid/sapphire"), MCTechLang.FLUID_CONDUIT_SAPPHIRE, 204800, true, true));
    }

    private static void bootstrapItemConduits(BootstrapContext<a<?, ?>> bootstrapContext) {
        register(bootstrapContext, ITEM_COAL, new mctech.g.d.a.d.e.a(MCTech.loc("block/conduit/item/coal"), MCTechLang.ITEM_CONDUIT_COAL, 2, 20, 1));
        register(bootstrapContext, ITEM_REDSTONE, new mctech.g.d.a.d.e.a(MCTech.loc("block/conduit/item/redstone"), MCTechLang.ITEM_CONDUIT_REDSTONE, 4, 20, 1));
        register(bootstrapContext, ITEM_LAPIS, new mctech.g.d.a.d.e.a(MCTech.loc("block/conduit/item/lapis"), MCTechLang.ITEM_CONDUIT_LAPIS, 8, 20, 1));
        register(bootstrapContext, ITEM_AMETHYST, new mctech.g.d.a.d.e.a(MCTech.loc("block/conduit/item/amethyst"), MCTechLang.ITEM_CONDUIT_AMETHYST, 16, 20, 1));
        register(bootstrapContext, ITEM_QUARTZ, new mctech.g.d.a.d.e.a(MCTech.loc("block/conduit/item/quartz"), MCTechLang.ITEM_CONDUIT_QUARTZ, 32, 20, 1));
        register(bootstrapContext, ITEM_LUMINITE, new mctech.g.d.a.d.e.a(MCTech.loc("block/conduit/item/luminite"), MCTechLang.ITEM_CONDUIT_LUMINITE, 64, 20, 1));
        register(bootstrapContext, ITEM_DIAMOND, new mctech.g.d.a.d.e.a(MCTech.loc("block/conduit/item/diamond"), MCTechLang.ITEM_CONDUIT_DIAMOND, 64, 10, 1));
        register(bootstrapContext, ITEM_EMERALD, new mctech.g.d.a.d.e.a(MCTech.loc("block/conduit/item/emerald"), MCTechLang.ITEM_CONDUIT_EMERALD, 64, 5, 1));
        register(bootstrapContext, ITEM_RUBY, new mctech.g.d.a.d.e.a(MCTech.loc("block/conduit/item/ruby"), MCTechLang.ITEM_CONDUIT_RUBY, 64, 5, 2));
        register(bootstrapContext, ITEM_ZIRCON, new mctech.g.d.a.d.e.a(MCTech.loc("block/conduit/item/zircon"), MCTechLang.ITEM_CONDUIT_ZIRCON, 64, 5, 4));
        register(bootstrapContext, ITEM_SAPPHIRE, new mctech.g.d.a.d.e.a(MCTech.loc("block/conduit/item/sapphire"), MCTechLang.ITEM_CONDUIT_SAPPHIRE, 64, 5, 8));
    }

    public static void register(IEventBus iEventBus) {
    }

    private static void register(BootstrapContext<a<?, ?>> bootstrapContext, ResourceKey<a<?, ?>> resourceKey, a<?, ?> aVar) {
        bootstrapContext.register(resourceKey, aVar);
    }
}
