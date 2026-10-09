package mctech;

import appeng.api.storage.StorageCells;
import appeng.api.upgrades.Upgrades;
import appeng.core.definitions.AEItems;
import gripe._90.megacells.definition.MEGAItems;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import mctech.api.blocks.IWrenchable;
import mctech.api.blocks.PainterHelper;
import mctech.config.FileSystemWatcher;
import mctech.config.impl.internal.ConfigLogger;
import mctech.config.impl.internal.EventHandler;
import mctech.config.mctech.MCTechConfig;
import mctech.g.a.l;
import mctech.init.MCTechAttachments;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechCapabilities;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechConduitTypes;
import mctech.init.MCTechConduits;
import mctech.init.MCTechCreativeTabs;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechDebugWorld;
import mctech.init.MCTechFluids;
import mctech.init.MCTechFuels;
import mctech.init.MCTechIngredients;
import mctech.init.MCTechItems;
import mctech.init.MCTechLang;
import mctech.init.MCTechLootModifiers;
import mctech.init.MCTechLootTableFunctions;
import mctech.init.MCTechMaterials;
import mctech.init.MCTechMenus;
import mctech.init.MCTechMobEffects;
import mctech.init.MCTechModels;
import mctech.init.MCTechModules;
import mctech.init.MCTechMultiblocks;
import mctech.init.MCTechParticles;
import mctech.init.MCTechPotions;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechSounds;
import mctech.init.MCTechStats;
import mctech.init.MCTechTags;
import mctech.init.MCTechTierConfigs;
import mctech.init.MCTechTiles;
import mctech.init.TickScheduler;
import mctech.init.datagen.MCTechBlockModelProvider;
import mctech.init.datagen.WorldPresetProvider;
import mctech.init.datagen.am.BlockModelProvider;
import mctech.init.datagen.am.ItemModelProvider;
import mctech.u.E;
import net.mcskill.msregistry.datagen.data.SimpleDataProvider;
import net.mcskill.msregistry.registry.LRegistry;
import net.mcskill.msregistry.registry.holder.LRecipe;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;
import net.neoforged.neoforge.registries.ModifyRegistriesEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/MCTech.class */
@Mod(MCTech.MODID)
public class MCTech {
    public static MCTech INSTANCE;
    public static final int API_VERSION = 2;
    public static MCTechConfig CONFIG;
    private static boolean isAE;
    private IEventBus bus;
    private mctech.x.b.b clientRenderer = new mctech.x.b.b();
    public static final mctech.c.b AUDIO = new mctech.c.c();
    public static final ExecutorService OFF_THREAD_WORKER = new ThreadPoolExecutor(0, Math.max(2, Runtime.getRuntime().availableProcessors() / 2), 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new mctech.utils.b.a("MCTech Offthread Tasks "));
    public static Logger LOGGER = LogManager.getLogger("MCTech");
    public static final h PLATFORM = new i();
    public static final mctech.q.d NETWORKING = new mctech.q.d();
    public static final mctech.s.b KEYBOARD = new mctech.s.c();
    public static final TickScheduler TICK_HANDLER = new TickScheduler();
    public static final FileSystemWatcher FILE_WATCHER = new FileSystemWatcher(new ConfigLogger(LOGGER), FMLPaths.CONFIGDIR.get(), EventHandler.INSTANCE);
    public static final mctech.utils.d.c PLUGINS = new mctech.utils.d.c();
    public static final mctech.utils.c.d MOD_CACHE = new mctech.utils.c.d();
    public static mctech.m.a.a CURIO_PLUGIN = new mctech.m.a.a.C0025a();
    public static mctech.utils.d.a JEI_PLUGIN = new mctech.utils.d.a.C0044a();
    public static final String MODID = "mctech";
    public static final LRegistry REGISTRY = new LRegistry(MODID);

    static {
        REGISTRY.addProvider((packOutput, existingFileHelper, completableFuture) -> {
            return new BlockModelProvider(packOutput, existingFileHelper);
        });
        REGISTRY.addProvider((packOutput2, existingFileHelper2, completableFuture2) -> {
            return new MCTechBlockModelProvider(packOutput2, existingFileHelper2);
        });
        REGISTRY.addProvider((packOutput3, existingFileHelper3, completableFuture3) -> {
            return new ItemModelProvider(packOutput3, existingFileHelper3);
        });
        MCTechTiles.loadTiles();
    }

    public MCTech(IEventBus iEventBus, ModContainer modContainer) {
        mctech.h.b.a.a().b(mctech.h.a.b.class);
        mctech.h.b.a.a().b(mctech.h.a.c.class);
        mctech.h.b.a.a().b(mctech.h.a.e.class);
        mctech.h.b.a.a().b(mctech.h.a.a.class);
        mctech.h.b.a.a().b(mctech.h.a.d.class);
        mctech.h.b.a.a().c();
        this.bus = iEventBus;
        NeoForgeMod.enableMilkFluid();
        CONFIG = new MCTechConfig();
        INSTANCE = this;
        REGISTRY.register(this.bus);
        this.bus.addListener(this::postInit);
        if (FMLEnvironment.dist.isClient()) {
            this.bus.addListener(this::onClientInit);
            this.bus.addListener(this::onClientLoaded);
        }
        this.bus.addListener(this::registerContent);
        NeoForge.EVENT_BUS.register(EventHandler.INSTANCE);
        NeoForge.EVENT_BUS.register(mctech.j.d.a);
        NeoForge.EVENT_BUS.addListener(this::onServerStartingEvent);
        NeoForge.EVENT_BUS.register(mctech.j.c.a);
        NeoForge.EVENT_BUS.register(MCTechFuels.INSTANCE);
        NeoForge.EVENT_BUS.register(mctech.j.a.a);
        mctech.energy.e.a();
        PainterHelper.init();
        PLATFORM.a();
        KEYBOARD.b();
        NETWORKING.a();
        AUDIO.a();
        PLUGINS.a(2, CONFIG.getConfig().add("plugins"));
        CONFIG.save();
        PLUGINS.a(iModule -> {
            iModule.preInit(this.bus);
        });
        MCTechLang.register();
        MCTechTierConfigs.register(this.bus);
        MCTechConduits.register(this.bus);
        MCTechConduitTypes.register(this.bus);
        MCTechIngredients.register(this.bus);
        MCTechMenus.register(this.bus);
        MCTechBlocks.register(this.bus);
        MCTechLootTableFunctions.register(this.bus);
        MCTechItems.register(this.bus);
        MCTechCodecs.register(this.bus);
        MCTechMobEffects.register(this.bus);
        MCTechModules.register(this.bus);
        MCTechTiles.register(this.bus);
        MCTechMultiblocks.init();
        MCTechFluids.register(this.bus);
        MCTechPotions.register(this.bus);
        MCTechAttachments.register(this.bus);
        MCTechDataComponent.register(this.bus);
        MCTechMaterials.register(this.bus);
        MCTechStats.register(this.bus);
        mctech.j.h.a(this.bus);
        MCTechCreativeTabs.register(this.bus);
        MCTechLootModifiers.register(this.bus);
        MCTechRecipes.register(this.bus);
        E.a();
        MCTechSounds.register(this.bus);
        MCTechParticles.register(this.bus);
        MCTechDebugWorld.register(this.bus);
        this.bus.addListener(this::onCommonSetup);
        new c(this.bus);
        new d(this.bus);
        new e(this.bus);
        new f(this.bus);
        new g(this.bus);
        this.bus.addListener(this::onRegisterRegistries);
        this.bus.addListener(registerCapabilitiesEvent -> {
            registerCapabilitiesEvent.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType) MCTechTiles.GRINDING_MACHINE.get(), (v0, v1) -> {
                return v0.getItemHandler(v1);
            });
        });
        NeoForge.EVENT_BUS.addListener(mctech.items.e.h::a);
        MCTechModels.init(this.bus);
        this.bus.addListener(MCTechCapabilities::registerCapabilities);
    }

    private void onCommonSetup(@Nonnull FMLCommonSetupEvent fMLCommonSetupEvent) {
        mctech.modules.h.a().a(MCTechModules.SILK_TOUCH, MCTechModules.FORTUNE);
        mctech.modules.h.a().a(MCTechModules.JETPACK, MCTechModules.CREATIVE_FLIGHT, MCTechModules.ELYTRA);
        StorageCells.addCellHandler(new mctech.a.b.a());
    }

    public void onRegisterRegistries(NewRegistryEvent newRegistryEvent) {
        newRegistryEvent.register(MCTechModules.MODULES);
        newRegistryEvent.register(MCTechTierConfigs.CONFIGS);
    }

    public IEventBus getBus() {
        return this.bus;
    }

    public static ResourceLocation loc(String str) {
        return ResourceLocation.fromNamespaceAndPath(MODID, str);
    }

    public void registerContent(RegisterEvent registerEvent) {
        isAE = ModList.get().isLoaded("ae2");
        if (registerEvent.getRegistryKey().equals(Registries.FEATURE)) {
            mctech.j.h.a();
        }
        if (registerEvent.getRegistryKey().equals(Registries.MENU)) {
            registerEvent.register(Registries.MENU, registerHelper -> {
                registerHelper.register(loc("wireless_connector_ex"), mctech.a.a.e.a.a);
            });
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void onClientInit(RegisterParticleProvidersEvent registerParticleProvidersEvent) {
        PLATFORM.c();
        registerParticleProvidersEvent.registerSpecial((ParticleType) MCTechParticles.DAMAGE_PARTICLE.get(), new mctech.v.g.b.a());
        registerParticleProvidersEvent.registerSpriteSet((ParticleType) MCTechParticles.SPARK_PARTICLE.get(), mctech.v.g.e.a::new);
    }

    @OnlyIn(Dist.CLIENT)
    public void onClientLoaded(FMLClientSetupEvent fMLClientSetupEvent) {
        EventHandler.INSTANCE.onConfigsLoaded();
        CONFIG.loadSuggestions();
        mctech.g.c.a.b.a.a();
        fMLClientSetupEvent.enqueueWork(() -> {
            mctech.j.e.a((Item) MCTechItems.RE_BATTERY.get());
        });
    }

    public void postInit(FMLCommonSetupEvent fMLCommonSetupEvent) {
        LOGGER.info("CommonSetup");
        IWrenchable.WrenchRegistry.INSTANCE.init();
        PLATFORM.b();
        MCTechTags.initTags();
        registerWirelessConnectorUpgrades();
        PLUGINS.a((v0) -> {
            v0.postInit();
        });
    }

    private void registerWirelessConnectorUpgrades() {
        Upgrades.add(AEItems.ENERGY_CARD, (ItemLike) MCTechBlocks.WIRELESS_CONNECTOR_64K.get(), 4);
        Upgrades.add(AEItems.ENERGY_CARD, (ItemLike) MCTechBlocks.WIRELESS_CONNECTOR_128K.get(), 4);
        Upgrades.add(AEItems.ENERGY_CARD, (ItemLike) MCTechBlocks.WIRELESS_CONNECTOR_256K.get(), 4);
        if (!ModList.get().isLoaded("megacells")) {
            return;
        }
        Upgrades.add(MEGAItems.GREATER_ENERGY_CARD, (ItemLike) MCTechBlocks.WIRELESS_CONNECTOR_64K.get(), 4);
        Upgrades.add(MEGAItems.GREATER_ENERGY_CARD, (ItemLike) MCTechBlocks.WIRELESS_CONNECTOR_128K.get(), 4);
        Upgrades.add(MEGAItems.GREATER_ENERGY_CARD, (ItemLike) MCTechBlocks.WIRELESS_CONNECTOR_256K.get(), 4);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/MCTech$a.class */
    @EventBusSubscriber(modid = MCTech.MODID)
    public static class a {
        @SubscribeEvent
        public static void a(ModifyRegistriesEvent modifyRegistriesEvent) {
            BuiltInRegistries.BLOCK.addCallback(registry -> {
                MCTechDebugWorld.MCTechDebugLevelSource.updateBlocks();
            });
        }

        @SubscribeEvent
        public static void a(NewRegistryEvent newRegistryEvent) {
            MCTech.LOGGER.info("Registering conduit registry");
            newRegistryEvent.register(l.a);
            newRegistryEvent.register(l.b);
            newRegistryEvent.register(l.d);
            newRegistryEvent.register(l.e);
            newRegistryEvent.register(l.c);
        }

        @SubscribeEvent
        private static void a(DataPackRegistryEvent.NewRegistry newRegistry) {
            MCTech.LOGGER.info("Registering conduit datapack registry");
            newRegistry.dataPackRegistry(l.a.f, mctech.g.a.a.a, mctech.g.a.a.a);
        }

        @SubscribeEvent
        public static void a(GatherDataEvent gatherDataEvent) {
            DataGenerator generator = gatherDataEvent.getGenerator();
            DataGenerator.PackGenerator vanillaPack = generator.getVanillaPack(true);
            CompletableFuture lookupProvider = gatherDataEvent.getLookupProvider();
            PackOutput packOutput = generator.getPackOutput();
            ExistingFileHelper existingFileHelper = gatherDataEvent.getExistingFileHelper();
            DatapackBuiltinEntriesProvider datapackBuiltinEntriesProviderAddProvider = vanillaPack.addProvider(packOutput2 -> {
                return new DatapackBuiltinEntriesProvider(packOutput2, lookupProvider, a(), Set.of("minecraft", MCTech.MODID));
            });
            generator.addProvider(gatherDataEvent.includeServer(), new WorldPresetProvider(packOutput, datapackBuiltinEntriesProviderAddProvider.getRegistryProvider(), existingFileHelper));
            generator.addProvider(gatherDataEvent.includeServer(), new mctech.b.a(packOutput, existingFileHelper));
            generator.addProvider(gatherDataEvent.includeServer(), new RecipeProvider(packOutput, datapackBuiltinEntriesProviderAddProvider.getRegistryProvider()) { // from class: mctech.MCTech.a.1
                protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
                    LRecipe.ShapedBuilder.of(MCTech.MODID, "armor").result(new ItemStack((ItemLike) MCTechItems.BRONZE_HELMET.get()), 1).pattern("BBB").pattern("B B").define('B', (ItemLike) MCTechItems.INGOT_BRONZE.get()).save(recipeOutput);
                    LRecipe.ShapedBuilder.of(MCTech.MODID, "armor").result(new ItemStack((ItemLike) MCTechItems.BRONZE_CHEST.get()), 1).pattern("B B").pattern("BBB").pattern("BBB").define('B', (ItemLike) MCTechItems.INGOT_BRONZE.get()).save(recipeOutput);
                    LRecipe.ShapedBuilder.of(MCTech.MODID, "armor").result(new ItemStack((ItemLike) MCTechItems.BRONZE_LEGGINGS.get()), 1).pattern("BBB").pattern("B B").pattern("B B").define('B', (ItemLike) MCTechItems.INGOT_BRONZE.get()).save(recipeOutput);
                    LRecipe.ShapedBuilder.of(MCTech.MODID, "armor").result(new ItemStack((ItemLike) MCTechItems.BRONZE_BOOTS.get()), 1).pattern("   ").pattern("B B").pattern("B B").define('B', (ItemLike) MCTechItems.INGOT_BRONZE.get()).save(recipeOutput);
                    LRecipe.ShapedBuilder.of(MCTech.MODID, "tools").result(new ItemStack((ItemLike) MCTechItems.BRONZE_AXE.get()), 1).pattern("BB ").pattern("BI ").pattern(" I ").define('B', (ItemLike) MCTechItems.INGOT_BRONZE.get()).define('I', Items.STICK).save(recipeOutput);
                    LRecipe.ShapedBuilder.of(MCTech.MODID, "tools").result(new ItemStack((ItemLike) MCTechItems.BRONZE_HOE.get()), 1).pattern("BB ").pattern(" I ").pattern(" I ").define('B', (ItemLike) MCTechItems.INGOT_BRONZE.get()).define('I', Items.STICK).save(recipeOutput);
                    LRecipe.ShapedBuilder.of(MCTech.MODID, "tools").result(new ItemStack((ItemLike) MCTechItems.BRONZE_PICKAXE.get()), 1).pattern("BBB").pattern(" I ").pattern(" I ").define('B', (ItemLike) MCTechItems.INGOT_BRONZE.get()).define('I', Items.STICK).save(recipeOutput);
                    LRecipe.ShapedBuilder.of(MCTech.MODID, "tools").result(new ItemStack((ItemLike) MCTechItems.BRONZE_SHOVEL.get()), 1).pattern(" B ").pattern(" I ").pattern(" I ").define('B', (ItemLike) MCTechItems.INGOT_BRONZE.get()).define('I', Items.STICK).save(recipeOutput);
                    LRecipe.ShapedBuilder.of(MCTech.MODID, "tools").result(new ItemStack((ItemLike) MCTechItems.BRONZE_SWORD.get()), 1).pattern(" B ").pattern(" B ").pattern(" I ").define('B', (ItemLike) MCTechItems.INGOT_BRONZE.get()).define('I', Items.STICK).save(recipeOutput);
                    LRecipe.ShapedBuilder.of(MCTech.MODID, "tools").result(new ItemStack((ItemLike) MCTechItems.TIN_AXE.get()), 1).pattern("BB ").pattern("BI ").pattern(" I ").define('B', (ItemLike) MCTechItems.INGOT_TIN.get()).define('I', Items.STICK).save(recipeOutput);
                    LRecipe.ShapedBuilder.of(MCTech.MODID, "tools").result(new ItemStack((ItemLike) MCTechItems.TIN_HOE.get()), 1).pattern("BB ").pattern(" I ").pattern(" I ").define('B', (ItemLike) MCTechItems.INGOT_TIN.get()).define('I', Items.STICK).save(recipeOutput);
                    LRecipe.ShapedBuilder.of(MCTech.MODID, "tools").result(new ItemStack((ItemLike) MCTechItems.TIN_PICKAXE.get()), 1).pattern("BBB").pattern(" I ").pattern(" I ").define('B', (ItemLike) MCTechItems.INGOT_TIN.get()).define('I', Items.STICK).save(recipeOutput);
                    LRecipe.ShapedBuilder.of(MCTech.MODID, "tools").result(new ItemStack((ItemLike) MCTechItems.TIN_SHOVEL.get()), 1).pattern(" B ").pattern(" I ").pattern(" I ").define('B', (ItemLike) MCTechItems.INGOT_TIN.get()).define('I', Items.STICK).save(recipeOutput);
                    LRecipe.ShapedBuilder.of(MCTech.MODID, "tools").result(new ItemStack((ItemLike) MCTechItems.TIN_SWORD.get()), 1).pattern(" B ").pattern(" B ").pattern(" I ").define('B', (ItemLike) MCTechItems.INGOT_TIN.get()).define('I', Items.STICK).save(recipeOutput);
                }
            });
            SimpleDataProvider simpleDataProvider = new SimpleDataProvider("conduits");
            simpleDataProvider.addSubProvider(gatherDataEvent.includeServer(), new mctech.g.e.b(packOutput, lookupProvider, existingFileHelper));
            simpleDataProvider.addSubProvider(gatherDataEvent.includeServer(), new mctech.g.e.d(packOutput, datapackBuiltinEntriesProviderAddProvider.getRegistryProvider()));
            generator.addProvider(true, simpleDataProvider);
        }

        private static RegistrySetBuilder a() {
            return new RegistrySetBuilder().add(l.a.f, MCTechConduits::bootstrap).add(Registries.DIMENSION_TYPE, MCTechDebugWorld::bootstrapDimensionTypes).add(Registries.LEVEL_STEM, MCTechDebugWorld::bootstrapLevelStem).add(Registries.WORLD_PRESET, MCTechDebugWorld::bootstrapWorldPresets);
        }
    }

    public void onServerStartingEvent(ServerAboutToStartEvent serverAboutToStartEvent) {
        if (serverAboutToStartEvent.getServer() instanceof DedicatedServer) {
            mctech.u.b.b.b.a();
        }
    }

    public static boolean isAE() {
        return isAE;
    }

    public static boolean isFrozen() {
        if (System.getenv("BRAND") != null) {
            return System.getenv("BRAND").equalsIgnoreCase("frozen");
        }
        if (System.getProperty("BRAND") != null) {
            return System.getProperty("BRAND").equalsIgnoreCase("frozen");
        }
        return ModList.get().isLoaded("icecube");
    }
}
