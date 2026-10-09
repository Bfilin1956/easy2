package mctech.config.mctech;

import java.util.Objects;
import mctech.MCTech;
import mctech.blockentities.b.k;
import mctech.config.Config;
import mctech.config.ConfigEntry;
import mctech.config.ConfigHandler;
import mctech.config.ConfigSection;
import mctech.config.ConfigSettings;
import mctech.q.c;
import mctech.utils.c.h;
import mctech.v.c.a;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.IModInfo;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/mctech/MCTechConfig.class */
public class MCTechConfig {
    private ConfigHandler handler;
    public ConfigEntry.BoolValue disableBronzeTools;
    public ConfigEntry.BoolValue disableAluminumTools;
    public ConfigEntry.BoolValue disableBronzeArmor;
    public ConfigEntry.BoolValue disableAlternateVanillaCrafting;
    public ConfigEntry.BoolValue disableGlowstoneCrafting;
    public ConfigEntry.BoolValue disableGunpowderCrafting;
    public ConfigEntry.BoolValue disableExplosiveCrafting;
    public ConfigEntry.IntValue limitVillagerDrinks;
    public ConfigEntry.BoolValue disableEnergyNetCrash;
    public ConfigEntry.BoolValue tileProfiler;
    public ConfigEntry.BoolValue itemNBT;
    public ConfigEntry.BoolValue recipeHiding;
    public ConfigEntry.BoolValue showUndamagedDurability;
    public ConfigEntry.BoolValue fancyFluidExpansion;
    public ConfigEntry.BoolValue showDefaultRecyclerRecipe;
    public ConfigEntry.BoolValue boostOnSprint;
    public ConfigEntry.BoolValue pauseWiki;
    public ConfigEntry.DoubleValue masterVolume;
    public ConfigEntry.DoubleValue blockVolume;
    public ConfigEntry.DoubleValue itemVolume;
    public ConfigEntry.DoubleValue backVolume;
    public ConfigEntry.BoolValue seperateStorageTextures;
    public ConfigEntry.IntValue wikiGuiScale;
    public ConfigEntry.EnumValue<a.EnumC0046a> dockHorizontal;
    public ConfigEntry.EnumValue<a.c> dockVertical;
    public ConfigEntry.EnumValue<a.b> hudOrientation;
    public ConfigEntry.IntValue hudXOffset;
    public ConfigEntry.IntValue hudYOffset;
    public ConfigEntry.IntValue reactorOutput;
    public ConfigEntry.IntValue generatorOutput;
    public ConfigEntry.IntValue slagGenOutput;
    public ConfigEntry.IntValue geothermalOutput;
    public ConfigEntry.DoubleValue fluidGenMultiplier;
    public ConfigEntry.DoubleValue solarTurbine;
    public ConfigEntry.IntValue oceanGenOutput;
    public ConfigEntry.IntValue waveGenOutput;
    public ConfigEntry.IntValue windTurbinePassive;
    public PassiveGeneratorSetting thermalGenerator;
    public PassiveGeneratorSetting waterMill;
    public PassiveGeneratorSetting lvWaterMill;
    public PassiveGeneratorSetting mvWaterMill;
    public PassiveGeneratorSetting hvWaterMill;
    public ConfigEntry.IntValue solarPanel;
    public ConfigEntry.IntValue lvSolarPanel;
    public ConfigEntry.IntValue mvSolarPanel;
    public ConfigEntry.IntValue hvSolarPanel;
    public ConfigEntry.BoolValue energyEasyMode;
    public ConfigEntry.DoubleValue electricSuitAbsorptionScale;
    public ConfigEntry.DoubleValue electricSuitEnergyCostModifier;
    public ConfigEntry.IntValue fluxBalance;
    public ConfigEntry.IntValue industrialWorkbenchExpansionLimit;
    public ConfigEntry.IntValue maxReactorTicks;
    public ConfigEntry.DoubleValue nukeDamage;
    public ConfigEntry.DoubleValue reactorDamage;
    public ConfigEntry.IntValue windChangeTime;
    public ConfigEntry.IntValue windStreams;
    public ConfigEntry.BoolValue oreTin;
    public ConfigEntry.BoolValue oreSilver;
    public ConfigEntry.BoolValue oreUranium;
    public ConfigEntry.BoolValue oreNetherSilver;
    public ConfigEntry.BoolValue oreNetherAluminium;
    public ConfigEntry.BoolValue oreRubberTree;
    public ConfigEntry.BoolValue enableSpecialElectricArmor;
    public ConfigEntry.BoolValue enableHardEnrichedUranium;
    public ConfigEntry.BoolValue teleporterKeepItems;
    public HashSetCache<String> ignoreEnchantabilityCheck;

    public MCTechConfig() {
        Config config = new Config(MCTech.MODID);
        this.handler = MCTech.FILE_WATCHER.createConfig(config, ConfigSettings.withFolder("mctechc"));
        ConfigSection configSectionAdd = config.add("balance");
        ConfigSection configSectionAddSubSection = configSectionAdd.addSubSection("generators");
        this.reactorOutput = configSectionAddSubSection.addInt("nuclearGeneratorMultiplier", 20);
        this.generatorOutput = (ConfigEntry.IntValue) configSectionAddSubSection.addInt("fuelGeneratorBase", 10).setServerSynced();
        this.slagGenOutput = (ConfigEntry.IntValue) configSectionAddSubSection.addInt("slagGenBase", 60).setServerSynced();
        this.geothermalOutput = (ConfigEntry.IntValue) configSectionAddSubSection.addInt("geoGeneratorBase", 20).setServerSynced();
        this.solarTurbine = (ConfigEntry.DoubleValue) configSectionAddSubSection.addDouble("solarTurbineMultiplier", 1.0d).setMin(0.1d).setServerSynced();
        this.fluidGenMultiplier = (ConfigEntry.DoubleValue) configSectionAddSubSection.addDouble("fluidGeneratorMultiplier", 1.0d).setServerSynced();
        this.oceanGenOutput = (ConfigEntry.IntValue) configSectionAddSubSection.addInt("oceanGenBase", 100).setServerSynced();
        this.waveGenOutput = (ConfigEntry.IntValue) configSectionAddSubSection.addInt("waveGenBase", 15).setServerSynced();
        this.windTurbinePassive = (ConfigEntry.IntValue) configSectionAddSubSection.addInt("windTubrinePassive", 100, "How much passive energy should be required per fuel. Lower => more Production").setServerSynced();
        this.thermalGenerator = new PassiveGeneratorSetting(configSectionAddSubSection, "thermalGenerator", 30, k.i);
        this.waterMill = new PassiveGeneratorSetting(configSectionAddSubSection, "waterMill", 1, 100);
        this.lvWaterMill = new PassiveGeneratorSetting(configSectionAddSubSection, "lvWaterMill", 4, 100);
        this.mvWaterMill = new PassiveGeneratorSetting(configSectionAddSubSection, "mvWaterMill", 32, 100);
        this.hvWaterMill = new PassiveGeneratorSetting(configSectionAddSubSection, "hvWaterMill", h.i, 100);
        this.solarPanel = (ConfigEntry.IntValue) configSectionAddSubSection.addInt("solarPanelBase", 1).setServerSynced();
        this.lvSolarPanel = (ConfigEntry.IntValue) configSectionAddSubSection.addInt("lvSolarPanelBase", 8).setServerSynced();
        this.mvSolarPanel = (ConfigEntry.IntValue) configSectionAddSubSection.addInt("mvSolarPanelBase", 64).setServerSynced();
        this.hvSolarPanel = (ConfigEntry.IntValue) configSectionAddSubSection.addInt("hvSolarPanelBase", c.c).setServerSynced();
        this.energyEasyMode = configSectionAdd.addBool("energyEasyMode", false, "Disables Explosions due to overcharging them. Energy will simply not flow if an explosion was to happend instead. Also disables Transformer Upgrades");
        ConfigSection configSectionAddSubSection2 = configSectionAdd.addSubSection("blocks");
        ConfigSection configSectionAddSubSection3 = configSectionAdd.addSubSection("items");
        this.electricSuitAbsorptionScale = configSectionAddSubSection3.addDouble("electricSuitAbsorptionScale", 1.0d, "Sets the Absorption Ratio of Electric Armor");
        this.electricSuitEnergyCostModifier = configSectionAddSubSection3.addDouble("electricSuitEnergyCostModifier", 1.0d, "Modifies the Energy Cost per damage");
        this.fluxBalance = configSectionAddSubSection2.addInt("fluxBalance", 4, "RF per EU Produced");
        this.industrialWorkbenchExpansionLimit = (ConfigEntry.IntValue) configSectionAddSubSection2.addInt("expansion_limit", 6, "Defines the Expansion Limit for the Industrial Worktable").setRange(0, 20).setServerSynced();
        this.maxReactorTicks = configSectionAddSubSection2.addInt("maxSimulationTicks", 100, "This limits how many simulation ticks can be done in the reactor planner. This logic is offthread and is dumped into a threadpool.").setRange(0, 10000);
        ConfigSection configSectionAdd2 = config.add("client");
        this.showUndamagedDurability = configSectionAdd2.addBool("showUndamagedDurability", true, "Show durability for undamaged, damageable items in advanced tooltip");
        this.fancyFluidExpansion = configSectionAdd2.addBool("enableFluidExpansionRenderer", true, "Show the Tanks contents in the World");
        this.showDefaultRecyclerRecipe = configSectionAdd2.addBool("showDefaultRecyclerRecipe", true, "Shows the default recycle recipe in JEI");
        this.boostOnSprint = configSectionAdd2.addBool("boostOnSprint", true, "Decides if you use Speed Module Boost on Sprinting or requring a dedicated key");
        this.pauseWiki = configSectionAdd2.addBool("pauseWiki", false, "Decides if the Wiki Pauses the game in singleplayer or not. Reduces the chance to be blown up by creepers while reading");
        this.seperateStorageTextures = configSectionAdd2.addBool("separateStorageTextures", false, "Changes that the energy storage textures are seperate files instead of a single one that morphs. Some resource packs may require this");
        this.wikiGuiScale = configSectionAdd2.addInt("wikiGuiScale", -1, "Sets the Scale of the wiki. -1 uses the default system. >=0 basically sets the MC gui scale for just the wiki.");
        ConfigSection configSectionAddSubSection4 = configSectionAdd2.addSubSection("audio");
        this.masterVolume = configSectionAddSubSection4.addDouble("master", 0.5d);
        this.blockVolume = configSectionAddSubSection4.addDouble("block", 1.0d);
        this.itemVolume = configSectionAddSubSection4.addDouble("item", 1.0d);
        this.backVolume = configSectionAddSubSection4.addDouble("backpack", 1.0d);
        ConfigSection configSectionAddSubSection5 = configSectionAdd2.addSubSection("armorHUD");
        this.dockHorizontal = configSectionAddSubSection5.addEnum("dockHorizontal", a.EnumC0046a.LEFT, a.EnumC0046a.class);
        this.dockVertical = configSectionAddSubSection5.addEnum("dockVertical", a.c.CENTER, a.c.class);
        this.hudOrientation = configSectionAddSubSection5.addEnum("hudOrientation", a.b.VERTICAL, a.b.class);
        this.hudXOffset = configSectionAddSubSection5.addInt("xOffset", 0);
        this.hudYOffset = configSectionAddSubSection5.addInt("yOffset", 0);
        ConfigSection configSectionAdd3 = config.add("crafting");
        this.disableBronzeTools = configSectionAdd3.addBool("disableBronzeTools", false, "Disable the recipes for bronze tools");
        this.disableAluminumTools = configSectionAdd3.addBool("disableAluminumTools", false, "Disable the recipes for aluminum tools");
        this.disableBronzeArmor = configSectionAdd3.addBool("disableBronzeArmor", false, "Disable the recipes for bronze armor");
        this.disableAlternateVanillaCrafting = configSectionAdd3.addBool("disableAlternateVanillaRecipes", false, "Disable the alternate crafting recipes for Vanilla stuff");
        this.recipeHiding = configSectionAdd3.addBool("enableSecretRecipeHiding", true, "Enable hiding of secret recipes in CraftGuide/NEI/JEI");
        this.disableGlowstoneCrafting = configSectionAdd3.addBool("disableGlowstoneRecipe", false, "Disable the Glowstone crafting recipe");
        this.disableGunpowderCrafting = configSectionAdd3.addBool("disableGunpowderRecipe", false, "Disable the Gunpowder crafting recipe");
        this.disableExplosiveCrafting = configSectionAdd3.addBool("disableExplosiveRecipes", false, "Disable the crafting recipes for MCTech Explosives");
        this.limitVillagerDrinks = configSectionAdd3.addInt("limitVillagerDrinks", -1, "Defines how many drinks in total are going to be added max to villagers trades. -1 as many as it wants, 5 means that it will at most add 5 trades into each tade pool. Which ones are left is random").setRange(-1, 100);
        ConfigSection configSectionAdd4 = config.add("features");
        this.enableSpecialElectricArmor = configSectionAdd4.addBool("enableSpecialElectricArmor", true, "Enables Electric Damage absorption on Electric Armor");
        this.enableHardEnrichedUranium = configSectionAdd4.addBool("enableHardEnrichedUranium", true, "Enable Harder Enriched Uranium Processing. Making it harder to create the enriched rods");
        this.teleporterKeepItems = configSectionAdd4.addBool("enableTeleporterInventory", true, "Enable calculation of inventory weight when going through a teleporter");
        ConfigSection configSectionAdd5 = config.add("world");
        this.nukeDamage = configSectionAdd5.addDouble("nukeDamage", 35.0d, "Sets the strength of a Nuclear Explosion");
        this.reactorDamage = configSectionAdd5.addDouble("reactorDamage", 45.0d, "Sets the max strength of a Nuclear Reactor Explosion");
        this.windChangeTime = configSectionAdd5.addInt("windUpdateRate", 6000, "Sets the time in Ticks for the Wind Update Cycle");
        this.windStreams = configSectionAdd5.addInt("windStreams", 5, "Sets how many Wind Streams there are").setRange(1, 20);
        ConfigSection configSectionAddSubSection6 = configSectionAdd5.addSubSection("gen");
        this.oreTin = configSectionAddSubSection6.addBool("Tin Ore Gen", true);
        this.oreSilver = configSectionAddSubSection6.addBool("Silver Ore Gen", true);
        this.oreUranium = configSectionAddSubSection6.addBool("Uranium Ore Gen", true);
        this.oreRubberTree = configSectionAddSubSection6.addBool("Rubber Tree Gen", true);
        this.oreNetherSilver = configSectionAddSubSection6.addBool("Nether Silver Ore Gen", true);
        this.oreNetherAluminium = configSectionAddSubSection6.addBool("Nether Aluminium Ore Gen", true);
        this.ignoreEnchantabilityCheck = HashSetCache.create(config.add("compat").addArray("ignoreEnchantmentCompatibilityCheck", "Enchantment/Mod IDs for enchantments where canApplyAtEnchantingTable should be ignored").setServerSynced(), this.handler);
        ConfigSection configSectionAdd6 = config.add("debug");
        this.tileProfiler = configSectionAdd6.addBool("Enable Tile Profiler", false, "Enables the Tile Profiler, Doubles Lag in worst cases. Requires TheOneProbe to see data, Uses Hud Key when looking at a block shows lag of Ticking Block");
        this.itemNBT = configSectionAdd6.addBool("Display Item NBT", false, "Enables that Ctrl shows Item NBTData and Shift Prettifies it.");
        this.disableEnergyNetCrash = configSectionAdd6.addBool("Disable Crash Validation", false, "Just a Temp Config that exists as a failsafe if a fix didn't work so it can be solved temporarily. Will be removed if validated that this crash was solved");
        this.handler.register();
        mctech.h hVar = MCTech.PLATFORM;
        Objects.requireNonNull(hVar);
        Objects.requireNonNull(hVar);
        addLoadedListener(hVar::d);
    }

    public void loadSuggestions() {
        ConfigEntry.ArrayValue arrayValue = (ConfigEntry.ArrayValue) this.ignoreEnchantabilityCheck.configEntry;
        for (IModInfo iModInfo : ModList.get().getMods()) {
            arrayValue.addSuggestion(iModInfo.getDisplayName(), iModInfo.getModId());
        }
    }

    public void load() {
        this.handler.load();
    }

    public void save() {
        this.handler.save();
    }

    public void addLoadedListener(Runnable runnable) {
        this.handler.addLoadedListener(runnable);
    }

    public Config getConfig() {
        return this.handler.getConfig();
    }

    public ConfigHandler getHandler() {
        return this.handler;
    }
}
