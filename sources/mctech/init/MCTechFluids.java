package mctech.init;

import java.util.function.Supplier;
import mctech.MCTech;
import mctech.blocks.a.a;
import mctech.fluid.FluidCellHandler;
import mctech.fluid.f;
import mctech.items.base.j;
import mctech.items.base.o;
import mctech.items.d.d;
import mctech.items.misc.CellItem;
import net.mcskill.msregistry.registry.holder.LBlock;
import net.mcskill.msregistry.registry.holder.LFluid;
import net.mcskill.msregistry.registry.holder.LItem;
import net.mcskill.msregistry.registry.type.BlockRegistry;
import net.mcskill.msregistry.registry.type.FluidRegistry;
import net.mcskill.msregistry.registry.type.ItemRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechFluids.class */
public class MCTechFluids {
    private static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, MCTech.MODID);
    private static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, MCTech.MODID);
    public static final FluidRegistry FLUID_TYPE_REGISTRY = MCTech.REGISTRY.fluidRegistry();
    public static final DeferredRegister<Fluid> FLUID_REGISTRY = DeferredRegister.create(Registries.FLUID, MCTech.MODID);
    public static final ItemRegistry ITEM_REGISTRY = MCTech.REGISTRY.itemRegistry();
    public static final BlockRegistry BLOCK_REGISTRY = MCTech.REGISTRY.blockRegistry();
    public static final DeferredHolder<FluidType, FluidType> BLAZING_LAVA_TYPE = registerFluidType("blazing_lava", () -> {
        return f.a(FluidType.Properties.create().density(4500).viscosity(8000).temperature(2500).descriptionId("fluid.mctech.blazing_lava"), ResourceLocation.parse("mctech:block/fluids/blazing_lava_still"), (Integer) (-1));
    });
    public static final DeferredHolder<Fluid, f> BLAZING_LAVA = registerFluid("blazing_lava", () -> {
        return new f(BLAZING_LAVA_TYPE);
    });
    public static final LItem<CellItem> CELL_EMPTY = cellItem("cell_empty", Fluids.EMPTY, "Empty cell", "Пустая капсула", (TagKey<Item>[]) new TagKey[0]);
    public static final LItem<j> CELL_AIR = cellItem("cell_air", () -> {
        return new j(new o().a((DeferredItem<?>) CELL_EMPTY));
    }, "Cell with compressed air", "Капсула со сжатым воздухом", false, new TagKey[0]);
    public static final LItem<CellItem> CELL_WATER = cellItem("cell_water", (Fluid) Fluids.WATER, "Water cell", "Капсула с водой", (TagKey<Item>[]) new TagKey[0]);
    public static final LItem<CellItem> CELL_LAVA = cellItem("cell_lava", (Fluid) Fluids.LAVA, "Lava cell", "Капсула с лавой", (TagKey<Item>[]) new TagKey[0]);
    public static final LItem<CellItem> CELL_BLAZING_LAVA = cellItem("cell_blazing_lava", () -> {
        return new CellItem((Fluid) BLAZING_LAVA.get());
    }, "Blazing lava cell", "Капсула с пылающей лавой", (TagKey<Item>[]) new TagKey[0]);
    public static final LItem<j> CELL_COAL_FUEL = cellItem("cell_coal_fuel", () -> {
        return new j(new o().a((DeferredItem<?>) CELL_EMPTY));
    }, "Cell with coal fuel", "Капсула с угольным топливом", (TagKey<Item>[]) new TagKey[0]);
    public static final LItem<j> CELL_BIO = cellItem("cell_bio", () -> {
        return new j(null);
    }, "Bio cell", "Капсула с био-жидкостью", false, new TagKey[0]);
    public static final LItem<j> CELL_BIO_FUEL = cellItem("cell_bio_fuel", () -> {
        return new j(new o().a((DeferredItem<?>) CELL_EMPTY));
    }, "Cell with bio fuel", "Капсула с биотопливом", (TagKey<Item>[]) new TagKey[0]);
    public static final LItem<j> CELL_ELECTROLYZED_WATER = cellItem("cell_electrolyzed_water", () -> {
        return new j(null);
    }, "Cell with electrolyzed water", "Капсула с электролизованной водой", false, new TagKey[0]);
    public static final LItem<j> CELL_PLASMA = cellItem("cell_plasma", () -> {
        return new j(null);
    }, "Cell with plasma", "Капсула с плазмой", false, new TagKey[0]);
    public static final LItem<d> CELL_REACTOR_FUEL = cellItem("reactor_fuel_cell", d::new, "Reactor fuel cell", "Капсула с реакторным топливом", false, new TagKey[0]).setModelProvider((lItemModelProvider, dataGenContext) -> {
        lItemModelProvider.basicItem((Item) dataGenContext.get(), MCTech.loc("item/cells/fuel"));
    });
    public static final LFluid<FluidType> SULFUR_ACID = fluid("sulfur_acid", "Sulfur acid", "Серная кислота", "Sulfur acid bucket", "Ведро серной кислоты", "Sulfur acid cell", "Капсула серной кислоты", FluidType.Properties.create().density(1000).viscosity(1000));
    public static final LFluid<FluidType> NITRIC_ACID = fluid("nitric_acid", "Nitric acid", "Азотная кислота", "Nitric acid bucket", "Ведро азотной кислоты", "Nitric acid cell", "Капсула азотной кислоты", FluidType.Properties.create().density(1000).viscosity(1000));
    public static final LFluid<FluidType> DIRTY_WATER = fluid("dirty_water", "Dirty water", "Грязная вода", "Dirty water bucket", "Ведро грязной воды", "Dirty water cell", "Капсула грязной воды", FluidType.Properties.create().density(1000).viscosity(1000));
    public static final LFluid<FluidType> LIQUID_MATTER = fluid("liquid_matter", "Liquid matter", "Жидкая материя", "Liquid matter bucket", "Ведро жидкой материи", "Liquid matter cell", "Капсула жидкой материи", FluidType.Properties.create().density(1000).viscosity(1000));
    public static final LFluid<FluidType> DISTILLED_WATER = fluid("distilled_water", "Distilled water", "Дистиллированная вода", "Distilled water bucket", "Ведро дистиллированной воды", "Distilled water cell", "Капсула дистиллированной воды", FluidType.Properties.create().density(1000).viscosity(1000));
    public static final LFluid<FluidType> LIQUID_COOLANT = fluid("liquid_coolant", "Coolant", "Хладагент", "Coolant bucket", "Ведро с хладагентом", "Coolant cell", "Капсула хладагента", FluidType.Properties.create().density(1000).viscosity(1000));
    public static final LFluid<FluidType> XP = new LFluidBuilder("xp", FluidType.Properties.create().density(800).viscosity(800)).translations("Liquid XP", "Жидкий опыт").withBlock().withBucket("Liquid XP bucket", "Ведро жидкого опыта").withCell("Liquid XP cell", "Капсула жидкого опыта").build();
    public static final LFluid<FluidType> LIQUID_HYDROGEN = fluid("liquid_hydrogen", "Hydrogen", "Водород", "Hydrogen bucket", "Ведро с жидким водородом", "Liquid hydrogen cell", "Капсула с жидким водорода", FluidType.Properties.create().density(0).viscosity(150).canSwim(false).canPushEntity(false).fallDistanceModifier(1.0f).motionScale(0.95d));
    public static final LFluid<FluidType> LIQUID_TRITIUM = fluid("liquid_tritium", "Tritium", "Тритий", "Tritium bucket", "Ведро с жидким тритием", "Liquid tritium cell", "Капсула с жидким тритием", FluidType.Properties.create().density(0).viscosity(150).canSwim(false).canPushEntity(false).fallDistanceModifier(1.0f).motionScale(0.95d));
    public static final LFluid<FluidType> LIQUID_DEUTERIUM = fluid("liquid_deuterium", "Deuterium", "Дейтерий", "Deuterium bucket", "Ведро с жидким дейтерием", "Liquid deuterium cell", "Капсула с жидким дейтерием", FluidType.Properties.create().density(0).viscosity(150).canSwim(false).canPushEntity(false).fallDistanceModifier(1.0f).motionScale(0.95d));
    public static final LFluid<FluidType> MELTED_ALUMINIUM = meltedItem("aluminium", "aluminium", "алюминий", "алюминия", 0);
    public static final LFluid<FluidType> MELTED_COAL = meltedItem("coal", "coal", "углеткань", "углеткани", 1);
    public static final LFluid<FluidType> MELTED_COMPOSITE = meltedItem("composite", "composite", "композит", "композита", 0);
    public static final LFluid<FluidType> MELTED_COPPER = meltedItem("copper", "copper", "медь", "меди", 1);
    public static final LFluid<FluidType> MELTED_DIAMOND = meltedItem("diamond", "diamond", "алмаз", "алмаза", 0);
    public static final LFluid<FluidType> MELTED_GLOWSTONE = meltedItem("glowstone", "glowstone", "светокамень", "светокамня", 0);
    public static final LFluid<FluidType> MELTED_GLASS = meltedItem("liquid_glass", "glass", "стекло", "стекла", 3);
    public static final LFluid<FluidType> MELTED_GOLD = meltedItem("gold", "gold", "золото", "золота", 3);
    public static final LFluid<FluidType> MELTED_IRIDIUM = meltedItem("iridium", "iridium", "иридий", "иридия", 0);
    public static final LFluid<FluidType> MELTED_IRON = meltedItem("iron", "iron", "железо", "железа", 3);
    public static final LFluid<FluidType> MELTED_LAPIS = meltedItem("lapis", "lapis", "лазурит", "лазурита", 0);
    public static final LFluid<FluidType> MELTED_NETHERITE = meltedItem("netherite", "netherite", "незерит", "незерита", 0);
    public static final LFluid<FluidType> MELTED_NICKEL = meltedItem("nickel", "nickel", "никель", "никеля", 0);
    public static final LFluid<FluidType> MELTED_REDSTONE = meltedItem("redstone", "redstone", "редстоун", "редстоуна", 0);
    public static final LFluid<FluidType> MELTED_RUBIDIUM = meltedItem("rubidium", "rubidium", "рубидий", "рубидия", 0);
    public static final LFluid<FluidType> MELTED_SILVER = meltedItem("silver", "silver", "серебро", "серебра", 3);
    public static final LFluid<FluidType> MELTED_TITANIUM = meltedItem("titanium", "titanium", "титан", "титана", 0);
    public static final LFluid<FluidType> BIOMASS = fluid("biomass", "Biomass", "Биомасса", "Biomass bucket", "Ведро биомассы", "Biomass cell", "Капсула биомассы", FluidType.Properties.create().density(1000).viscosity(1000)).condition(MCTech::isFrozen);
    public static final LFluid<FluidType> FRUIT_MIX = fluid("fruit_mix", "Fruit mix", "Фруктовый сок", "Fruit mix bucket", "Ведро с фруктовым соком", "Fruit mix cell", "Капсула с фруктовым соком", FluidType.Properties.create().density(1000).viscosity(1000)).condition(MCTech::isFrozen);
    public static final LFluid<FluidType> FUEL = fluid("fuel", "Fuel", "Топливо", "Fuel bucket", "Ведро с топливом", "Fuel cell", "Капсула с топливом", FluidType.Properties.create().density(1000).viscosity(1000));
    public static final LFluid<FluidType> LIQUID_SALT = fluid("liquid_salt", "Liquid salt", "Солёная вода", "Liquid salt bucket", "Ведро с солёной водой", "Liquid salt cell", "Капсула с солёной водой", FluidType.Properties.create().density(1000).viscosity(1000)).condition(MCTech::isFrozen);
    public static final LFluid<FluidType> MERCURY = fluid("mercury", "Mercury", "Ртуть", "Mercury bucket", "Ведро с ртутью", "Mercury cell", "Капсула с ртутью", FluidType.Properties.create().density(1000).viscosity(1000)).condition(MCTech::isFrozen);
    public static final LFluid<FluidType> OIL = fluid("oil", "Oil", "Нефть", "Oil bucket", "Ведро с нефтью", "Oil cell", "Капсула с нефтью", FluidType.Properties.create().density(1000).viscosity(1000)).condition(MCTech::isFrozen);
    public static final LFluid<FluidType> RAW_OIL = fluid("raw_oil", "Raw oil", "Сырая нефть", "Raw oil bucket", "Ведро с сырой нефтью", "Raw oil cell", "Капсула с сырой нефтью", FluidType.Properties.create().density(1000).viscosity(1000)).condition(MCTech::isFrozen);
    public static final LFluid<FluidType> SEED_OIL = fluid("seed_oil", "Seed oil", "Масло", "Seed oil bucket", "Ведро с маслом", "Seed oil cell", "Капсула с маслом", FluidType.Properties.create().density(1000).viscosity(1000)).condition(MCTech::isFrozen);

    private static LFluid<FluidType> fluid(String str, String str2, String str3, String str4, String str5, String str6, String str7, FluidType.Properties properties) {
        LFluid<FluidType> lFluidWithCell = baseFluid(str, properties).setTranslation(str2, str3).finishLiquidBlock().setTranslation(str2, str3).withBucket(ITEM_REGISTRY, supplier -> {
            return new BucketItem((Fluid) supplier.get(), new Item.Properties().stacksTo(1));
        }).setTab(MCTechCreativeTabs.FLUIDS).setTranslation(str4, str5).finishBucket().withCell(ITEM_REGISTRY, FLUID_TYPE_REGISTRY, str6, str7, MCTechCreativeTabs.FLUIDS);
        lFluidWithCell.getCell().clearCapabilities().addCapability(Capabilities.FluidHandler.ITEM, (itemStack, r5) -> {
            return new FluidCellHandler(itemStack);
        }).setModelProvider((lItemModelProvider, dataGenContext) -> {
            lItemModelProvider.basicItem((Item) dataGenContext.get(), MCTech.loc(String.format("item/cells/%s", dataGenContext.getName())));
        });
        return lFluidWithCell;
    }

    private static LFluid<FluidType> fluidWoBucket(String str, String str2, String str3, String str4, String str5, FluidType.Properties properties) {
        LFluid<FluidType> lFluidWithCell = baseFluid(str, properties).setTranslation(str2, str3).finishLiquidBlock().withCell(ITEM_REGISTRY, FLUID_TYPE_REGISTRY, str4, str5, MCTechCreativeTabs.FLUIDS);
        lFluidWithCell.getCell().clearCapabilities().addCapability(Capabilities.FluidHandler.ITEM, (itemStack, r5) -> {
            return new FluidCellHandler(itemStack);
        }).setModelProvider((lItemModelProvider, dataGenContext) -> {
            lItemModelProvider.basicItem((Item) dataGenContext.get(), MCTech.loc(String.format("item/cells/%s", dataGenContext.getName())));
        });
        return lFluidWithCell;
    }

    private static LFluid<FluidType> fluidWoCell(String str, String str2, String str3, String str4, String str5, FluidType.Properties properties) {
        return baseFluid(str, properties).setTranslation(str2, str3).finishLiquidBlock().withBucket(ITEM_REGISTRY, supplier -> {
            return new BucketItem((Fluid) supplier.get(), new Item.Properties().stacksTo(1));
        }).setTab(MCTechCreativeTabs.FLUIDS).setTranslation(str4, str5).finishBucket();
    }

    private static LFluid<FluidType> meltedItem(String str, String str2, String str3, String str4, int i) {
        LFluid<FluidType> lFluidFinishBucket = FLUID_TYPE_REGISTRY.registerFluid(str, FluidType.Properties.create().density(1000).viscosity(1000)).setRenderType(() -> {
            return RenderType::translucent;
        }).createFluid(FLUID_REGISTRY).withBlock(BLOCK_REGISTRY, supplier -> {
            return a.a((FlowingFluid) supplier.get());
        }).finishLiquidBlock().setTranslation(determinateEngMeltedName(str2, false), determinateRuMeltedName(str3, str4, i, false)).withBucket(ITEM_REGISTRY, supplier2 -> {
            return new BucketItem((Fluid) supplier2.get(), new Item.Properties().stacksTo(1));
        }).setTab(MCTechCreativeTabs.FLUIDS).setTranslation(determinateEngMeltedName(str2, true), determinateRuMeltedName(str3, str4, i, true)).finishBucket();
        lFluidFinishBucket.withCell(ITEM_REGISTRY, FLUID_TYPE_REGISTRY, determinateEngMeltedCellName(str2), determinateRuMeltedCellName(str3, str4, i), MCTechCreativeTabs.FLUIDS);
        lFluidFinishBucket.getCell().clearCapabilities().addCapability(Capabilities.FluidHandler.ITEM, (itemStack, r5) -> {
            return new FluidCellHandler(itemStack);
        }).setModelProvider((lItemModelProvider, dataGenContext) -> {
            lItemModelProvider.basicItem((Item) dataGenContext.get(), MCTech.loc(String.format("item/cells/%s", dataGenContext.getName())));
        });
        return lFluidFinishBucket;
    }

    private static LBlock.LLiquidBlock<? extends LiquidBlock, FluidType> baseFluid(String str, FluidType.Properties properties) {
        return FLUID_TYPE_REGISTRY.registerFluid(str, properties).setRenderType(() -> {
            return RenderType::translucent;
        }).createFluid(FLUID_REGISTRY).withBlock(BLOCK_REGISTRY, supplier -> {
            return new a((FlowingFluid) supplier.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER));
        });
    }

    public static void register(IEventBus iEventBus) {
        FLUID_TYPES.register(iEventBus);
        FLUIDS.register(iEventBus);
        FLUID_TYPE_REGISTRY.register(iEventBus);
        FLUID_REGISTRY.register(iEventBus);
        BLOCK_REGISTRY.register(iEventBus);
        ITEM_REGISTRY.register(iEventBus);
    }

    public static <I extends FluidType> DeferredHolder<FluidType, I> registerFluidType(String str, Supplier<? extends I> supplier) {
        return FLUID_TYPES.register(str, supplier);
    }

    public static <I extends Fluid> DeferredHolder<Fluid, I> registerFluid(String str, Supplier<? extends I> supplier) {
        return FLUIDS.register(str, supplier);
    }

    private static String determinateRuMeltedName(String str, String str2, int i, boolean z) {
        switch (i) {
            case 0:
                return z ? String.format("Ведро %s %s", "расплавленного", str2) : String.format("%s %s", "Расплавленный", str);
            case 1:
                return z ? String.format("Ведро %s %s", "расплавленной", str2) : String.format("%s %s", "Расплавленная", str);
            case 2:
            default:
                return str;
            case 3:
                return z ? String.format("Ведро %s %s", "расплавленного", str2) : String.format("%s %s", "Расплавленное", str);
        }
    }

    private static String determinateRuMeltedCellName(String str, String str2, int i) {
        switch (i) {
            case 0:
            case 3:
                return String.format("Капсула %s %s", "расплавленного", str2);
            case 1:
                return String.format("Капсула %s %s", "расплавленной", str2);
            case 2:
            default:
                return str;
        }
    }

    private static String determinateEngMeltedName(String str, boolean z) {
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = z ? " bucket" : "";
        return String.format("Melted %s%s", objArr);
    }

    private static String determinateEngMeltedCellName(String str) {
        return String.format("Melted %s cell", str);
    }

    @SafeVarargs
    public static LItem<CellItem> cellItem(String str, Fluid fluid, String str2, String str3, TagKey<Item>... tagKeyArr) {
        return cellItem(str, () -> {
            return new CellItem(fluid);
        }, str2, str3, tagKeyArr);
    }

    @SafeVarargs
    public static <I extends Item> LItem<I> cellItem(String str, com.google.common.base.Supplier<I> supplier, String str2, String str3, TagKey<Item>... tagKeyArr) {
        return cellItem(str, supplier, str2, str3, true, tagKeyArr);
    }

    @SafeVarargs
    public static <I extends Item> LItem<I> cellItem(String str, com.google.common.base.Supplier<I> supplier, String str2, String str3, boolean z, TagKey<Item>... tagKeyArr) {
        LItem<I> tab = ITEM_REGISTRY.registerItem(str, properties -> {
            return (Item) supplier.get();
        }).setTranslation(str2, str3).setModelProvider((lItemModelProvider, dataGenContext) -> {
            lItemModelProvider.basicItem((Item) dataGenContext.get(), MCTech.loc(String.format("item/cells/%s", dataGenContext.getName().replace("cell_", ""))));
        }).addItemTags(tagKeyArr).setTab(MCTechCreativeTabs.FLUIDS);
        if (z) {
            tab.addCapability(Capabilities.FluidHandler.ITEM, (itemStack, r5) -> {
                return new FluidCellHandler(itemStack);
            });
        }
        return tab;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechFluids$LFluidBuilder.class */
    public static class LFluidBuilder {
        private final String name;
        private final FluidType.Properties fluidProperties;
        private String engTranslation;
        private String ruTranslation;
        private String engBucketTranslation;
        private String ruBucketTranslation;
        private String engCellTranslation;
        private String ruCellTranslation;
        private boolean createBlock = true;
        private boolean createBucket = true;
        private boolean createCell = true;
        private Supplier<RenderType> renderType = RenderType::translucent;
        private BlockBehaviour.Properties blockProperties = BlockBehaviour.Properties.ofFullCopy(Blocks.WATER);
        private Item.Properties bucketProperties = new Item.Properties().stacksTo(1);
        private ResourceKey<CreativeModeTab> creativeTab = MCTechCreativeTabs.FLUIDS;

        private LFluidBuilder(String str, FluidType.Properties properties) {
            this.name = str;
            this.fluidProperties = properties;
        }

        public static LFluidBuilder create(String str, FluidType.Properties properties) {
            return new LFluidBuilder(str, properties);
        }

        public LFluidBuilder translations(String str, String str2) {
            this.engTranslation = str;
            this.ruTranslation = str2;
            return this;
        }

        public LFluidBuilder withBlock(BlockBehaviour.Properties properties, String str, String str2) {
            this.createBlock = true;
            this.blockProperties = properties;
            return this;
        }

        public LFluidBuilder withBlock() {
            this.createBlock = true;
            return this;
        }

        public LFluidBuilder withoutBlock() {
            this.createBlock = false;
            return this;
        }

        public LFluidBuilder withBucket(Item.Properties properties, String str, String str2) {
            this.createBucket = true;
            this.bucketProperties = properties;
            this.engBucketTranslation = str;
            this.ruBucketTranslation = str2;
            return this;
        }

        public LFluidBuilder withBucket(String str, String str2) {
            this.createBucket = true;
            this.engBucketTranslation = str;
            this.ruBucketTranslation = str2;
            return this;
        }

        public LFluidBuilder creativeTab(ResourceKey<CreativeModeTab> resourceKey) {
            this.creativeTab = resourceKey;
            return this;
        }

        public LFluidBuilder withoutBucket() {
            this.createBucket = false;
            return this;
        }

        public LFluidBuilder withCell(String str, String str2) {
            this.createCell = true;
            this.engCellTranslation = str;
            this.ruCellTranslation = str2;
            return this;
        }

        public LFluidBuilder withoutCell() {
            this.createCell = false;
            return this;
        }

        public LFluidBuilder renderType(Supplier<RenderType> supplier) {
            this.renderType = supplier;
            return this;
        }

        public LFluid<FluidType> build() {
            if (this.engTranslation == null || this.ruTranslation == null) {
                throw new IllegalStateException("Translations must be set for fluid: " + this.name);
            }
            LFluid<FluidType> translation = MCTechFluids.FLUID_TYPE_REGISTRY.registerFluid(this.name, this.fluidProperties).setRenderType(() -> {
                return this.renderType;
            }).createFluid(MCTechFluids.FLUID_REGISTRY).setTranslation(this.engTranslation, this.ruTranslation);
            if (this.createBlock) {
                translation = translation.withBlock(MCTechFluids.BLOCK_REGISTRY, supplier -> {
                    return new a((FlowingFluid) supplier.get(), this.blockProperties);
                }).setTranslation(this.engTranslation, this.ruTranslation).finishLiquidBlock();
            }
            if (this.createBucket) {
                translation = translation.withBucket(MCTechFluids.ITEM_REGISTRY, supplier2 -> {
                    return new BucketItem((Fluid) supplier2.get(), this.bucketProperties);
                }).setTab(this.creativeTab).setTranslation(this.engBucketTranslation, this.ruBucketTranslation).finishBucket();
            }
            if (this.createCell) {
                translation = translation.withCell(MCTechFluids.ITEM_REGISTRY, MCTechFluids.FLUID_TYPE_REGISTRY, this.engCellTranslation, this.ruCellTranslation, this.creativeTab);
                translation.getCell().clearCapabilities().addCapability(Capabilities.FluidHandler.ITEM, (itemStack, r5) -> {
                    return new FluidCellHandler(itemStack);
                }).setModelProvider((lItemModelProvider, dataGenContext) -> {
                    lItemModelProvider.basicItem((Item) dataGenContext.get(), MCTech.loc(String.format("item/cells/%s", this.name)));
                });
            }
            return translation;
        }
    }
}
