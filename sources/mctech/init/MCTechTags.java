package mctech.init;

import mctech.MCTech;
import mctech.api.blocks.BlockRegistries;
import mctech.u.b.a;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechTags.class */
public class MCTechTags {
    public static final TagKey<Block> BEDROCK_ORE = createForgeBlockTag("bedrock_ore");
    public static final TagKey<Block> FARM_TREE_PARTS = mctechBlockTag("farm_tree_parts");
    public static final TagKey<Item> TOOLBOX = createItemTag(MCTech.MODID, "toolbox");
    public static final TagKey<Item> LOGS = ItemTags.LOGS;
    public static final TagKey<Block> ORES = createForgeBlockTag("ores");
    public static final TagKey<Item> RUBBER = createForgeItemTag("rubber");
    public static final TagKey<Item> ORE_COPPER = createForgeItemTag("ores/copper");
    public static final TagKey<Item> ORE_TIN = createForgeItemTag("ores/tin");
    public static final TagKey<Item> ORE_SILVER = createForgeItemTag("ores/silver");
    public static final TagKey<Item> ORE_URANIUM = createForgeItemTag("ores/uranium");
    public static final TagKey<Item> ORE_ALUMINIUM = createForgeItemTag("ores/aluminium");
    public static final TagKey<Block> ORE_TIN_BLOCK = createForgeBlockTag("ores/tin");
    public static final TagKey<Block> ORE_SILVER_BLOCK = createForgeBlockTag("ores/silver");
    public static final TagKey<Block> ORE_ALUMINIUM_BLOCK = createForgeBlockTag("ores/aluminium");
    public static final TagKey<Block> ORE_URANIUM_BLOCK = createForgeBlockTag("ores/uranium");
    public static final TagKey<Item> RAW_TIN = createForgeItemTag("raw_materials/tin");
    public static final TagKey<Item> RAW_SILVER = createForgeItemTag("raw_materials/silver");
    public static final TagKey<Item> RAW_URANIUM = createForgeItemTag("raw_materials/uranium");
    public static final TagKey<Item> RAW_ALUMINIUM = createForgeItemTag("raw_materials/aluminium");
    public static final TagKey<Item> RAW_TITANIUM = createForgeItemTag("raw_materials/titanium");
    public static final TagKey<Item> RAW_RUBIDIUM = createForgeItemTag("raw_materials/rubidium");
    public static final TagKey<Item> DUST_COPPER = createForgeItemTag("dusts/copper");
    public static final TagKey<Item> DUST_TIN = createForgeItemTag("dusts/tin");
    public static final TagKey<Item> DUST_SILVER = createForgeItemTag("dusts/silver");
    public static final TagKey<Item> DUST_BRONZE = createForgeItemTag("dusts/bronze");
    public static final TagKey<Item> DUST_ALUMINIUM = createForgeItemTag("dusts/aluminium");
    public static final TagKey<Item> DUST_IRON = createForgeItemTag("dusts/iron");
    public static final TagKey<Item> DUST_GOLD = createForgeItemTag("dusts/gold");
    public static final TagKey<Item> DUST_COAL = createForgeItemTag("dusts/coal");
    public static final TagKey<Item> DUST_CHARCOAL = createForgeItemTag("dusts/charcoal");
    public static final TagKey<Item> STORAGE_COPPER = createForgeItemTag("storage_blocks/copper");
    public static final TagKey<Item> STORAGE_TIN = createForgeItemTag("storage_blocks/tin");
    public static final TagKey<Item> STORAGE_SILVER = createForgeItemTag("storage_blocks/silver");
    public static final TagKey<Item> STORAGE_BRONZE = createForgeItemTag("storage_blocks/bronze");
    public static final TagKey<Item> STORAGE_ALUMINIUM = createForgeItemTag("storage_blocks/aluminium");
    public static final TagKey<Item> STORAGE_URANIUM = createForgeItemTag("storage_blocks/uranium");
    public static final TagKey<Item> STORAGE_REFINED_IRON = createForgeItemTag("storage_blocks/refined_iron");
    public static final TagKey<Block> STORAGE_COPPER_BLOCK = createForgeBlockTag("storage_blocks/copper_all");
    public static final TagKey<Block> STORAGE_TIN_BLOCK = createForgeBlockTag("storage_blocks/tin");
    public static final TagKey<Block> STORAGE_BRONZE_BLOCK = createForgeBlockTag("storage_blocks/bronze");
    public static final TagKey<Block> STORAGE_SILVER_BLOCK = createForgeBlockTag("storage_blocks/silver");
    public static final TagKey<Block> STORAGE_ALUMINIUM_BLOCK = createForgeBlockTag("storage_blocks/aluminium");
    public static final TagKey<Block> STORAGE_URANIUM_BLOCK = createForgeBlockTag("storage_blocks/uranium");
    public static final TagKey<Block> STORAGE_REFINED_BLOCK = createForgeBlockTag("storage_blocks/refined_iron");
    public static final TagKey<Item> STORAGE_RAW_TIN = createForgeItemTag("storage_blocks/raw_tin");
    public static final TagKey<Item> STORAGE_RAW_SILVER = createForgeItemTag("storage_blocks/raw_silver");
    public static final TagKey<Item> STORAGE_RAW_ALUMINIUM = createForgeItemTag("storage_blocks/raw_aluminium");
    public static final TagKey<Item> STORAGE_RAW_URANIUM = createForgeItemTag("storage_blocks/raw_uranium");

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechTags$Nuggets.class */
    public static final class Nuggets {
        public static final TagKey<Item> COPPER = MCTechTags.createForgeItemTag("nuggets/copper");
        public static final TagKey<Item> TIN = MCTechTags.createForgeItemTag("nuggets/tin");
        public static final TagKey<Item> SILVER = MCTechTags.createForgeItemTag("nuggets/silver");
        public static final TagKey<Item> BRONZE = MCTechTags.createForgeItemTag("nuggets/bronze");
        public static final TagKey<Item> ALUMINIUM = MCTechTags.createForgeItemTag("nuggets/aluminium");
        public static final TagKey<Item> ADVANCED_ALLOY = MCTechTags.createForgeItemTag("nuggets/advanced_alloy");
        public static final TagKey<Item> REFINED_IRON = MCTechTags.createForgeItemTag("nuggets/refined_iron");
        public static final TagKey<Item> URANIUM = MCTechTags.createForgeItemTag("nuggets/uranium");
        public static final TagKey<Item> POLISHED_GOLD = MCTechTags.createForgeItemTag("nuggets/polished_gold");
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechTags$Ores.class */
    public static final class Ores {
        public static final TagKey<Block> AMETHYST = MCTechTags.createForgeBlockTag("ores/amethyst");
        public static final TagKey<Block> ALUMINUM = MCTechTags.createForgeBlockTag("ores/aluminum");
        public static final TagKey<Block> RUBIDIUM = MCTechTags.createForgeBlockTag("ores/rubidium");
        public static final TagKey<Block> TITANIUM = MCTechTags.createForgeBlockTag("ores/titanium");
        public static final TagKey<Block> URANIUM = MCTechTags.createForgeBlockTag("ores/uranium");
        public static final TagKey<Block> TIN = MCTechTags.createForgeBlockTag("ores/tin");
        public static final TagKey<Block> SILVER = MCTechTags.createForgeBlockTag("ores/silver");
        public static final TagKey<Block> TUNGSTEN = MCTechTags.createForgeBlockTag("ores/tungsten");
        public static final TagKey<Block> NETHERITE = MCTechTags.createForgeBlockTag("ores/netherite");
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechTags$Tools.class */
    public static final class Tools {
        public static final TagKey<Item> TOOLS = MCTechTags.createForgeItemTag("tools");
        public static final TagKey<Item> WRENCH = MCTechTags.createForgeItemTag("tools/wrench");
        public static final TagKey<Item> BLOCK_WG_INTERACT = MCTechTags.createForgeItemTag("block_wg_interact");
    }

    public static void initTags() {
        BlockRegistries.registerListener(new a());
    }

    public static TagKey<Block> mctechBlockTag(String str) {
        return createBlockTag(MCTech.MODID, str);
    }

    public static TagKey<Item> mctechItemTag(String str) {
        return createItemTag(MCTech.MODID, str);
    }

    public static TagKey<Item> createItemTag(String str) {
        return createItemTag("minecraft", str);
    }

    public static TagKey<Item> createForgeItemTag(String str) {
        return createItemTag(mctech.g.d.d.a.a, str);
    }

    public static TagKey<Item> createItemTag(String str, String str2) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(str, str2));
    }

    public static TagKey<Block> createBlockTag(String str) {
        return createBlockTag("minecraft", str);
    }

    public static TagKey<Block> createForgeBlockTag(String str) {
        return createBlockTag(mctech.g.d.d.a.a, str);
    }

    public static TagKey<Block> createBlockTag(String str, String str2) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(str, str2));
    }

    public static TagKey<Fluid> createFluidTag(String str) {
        return createFluidTag("minecraft", str);
    }

    public static TagKey<Fluid> createForgeFluidTag(String str) {
        return createFluidTag(mctech.g.d.d.a.a, str);
    }

    public static TagKey<Fluid> createFluidTag(String str, String str2) {
        return FluidTags.create(ResourceLocation.fromNamespaceAndPath(str, str2));
    }
}
