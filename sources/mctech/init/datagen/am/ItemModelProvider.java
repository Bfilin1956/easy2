package mctech.init.datagen.am;

import java.util.Objects;
import mctech.MCTech;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/datagen/am/ItemModelProvider.class */
public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, MCTech.MODID, existingFileHelper);
    }

    protected void registerModels() {
        miscItem(MCTechItems.ADMIN_CIRCUIT);
        miscItem(MCTechItems.ADMIN_SCRAP);
        miscItem(MCTechItems.ADMIN_SCRAP_BOX);
        miscItem(MCTechItems.ANTI_UU_MATTER);
        miscItem(MCTechItems.ANTI_UU_MATTER_2);
        miscItem(MCTechItems.ANTI_UU_MATTER_3);
        miscItem(MCTechItems.COMP_SCRAP);
        miscItem(MCTechItems.COMP_SCRAP_BOX);
        miscItem(MCTechItems.COMPOSITE_CIRCUIT);
        miscItem(MCTechItems.IRIDIUM_INGOT);
        miscItem(MCTechItems.LAPIS_PLATE);
        miscItem(MCTechItems.NANO_CIRCUIT);
        miscItem(MCTechItems.NANO_SCRAP);
        miscItem(MCTechItems.NANO_SCRAP_BOX);
        miscItem(MCTechItems.QUANT_SCRAP);
        miscItem(MCTechItems.QUANT_SCRAP_BOX);
        miscItem(MCTechItems.QUANTUM_CIRCUIT);
        miscItem(MCTechItems.SIGN_SCRAP);
        miscItem(MCTechItems.SIGN_SCRAP_BOX);
        miscItem(MCTechItems.SINGULAR_CIRCUIT);
        miscItem(MCTechItems.UU_MATTER_2);
        miscItem(MCTechItems.UU_MATTER_3);
        miscItem(MCTechItems.TITANIUM_PLATE);
        createBlockItem(MCTechBlocks.RUBIDIUM_ORE, "rubidium_ore");
        createBlockItem(MCTechBlocks.TITANIUM_ORE, "titanium_ore");
        createBlockItem(MCTechBlocks.CRYSTAL_GROWTH_CHAMBER, "active_crystal_growth_chamber");
        createBlockItem(MCTechBlocks.NANO_RECYCLER, "active_nano_recycler");
        createBlockItem(MCTechBlocks.NANO_REFINERY, "active_nano_refinery");
        createBlockItem(MCTechBlocks.QUANTUM_RECYCLER, "active_quantum_recycler");
        createBlockItem(MCTechBlocks.QUANTUM_REFINERY, "active_quantum_refinery");
        createBlockItem(MCTechBlocks.SINGULAR_RECYCLER, "active_singular_recycler");
        createBlockItem(MCTechBlocks.SINGULAR_REFINERY, "active_singular_refinery");
        createBlockItem(MCTechBlocks.STONE_COMPRESSOR, "stone_compressor");
        createBlockItem(MCTechBlocks.STONE_EXTRACTOR, "stone_extractor");
        upgradeItem(MCTechItems.UPGRADE_ADMIN_OVERCLOCKER, "machines");
        upgradeItem(MCTechItems.COMPLEX_HANDLER_UPDATE, "machines");
        upgradeItem(MCTechItems.UPGRADE_COMPOSITE_OVERCLOCKER, "machines");
        upgradeItem(MCTechItems.UPGRADE_DENSE_MATTER_1, "machines");
        upgradeItem(MCTechItems.UPGRADE_DENSE_MATTER_2, "machines");
        upgradeItem(MCTechItems.UPGRADE_MASS_FABRICATOR_FORTUNE_1, "machines");
        upgradeItem(MCTechItems.UPGRADE_MASS_FABRICATOR_FORTUNE_2, "machines");
        upgradeItem(MCTechItems.UPGRADE_MASS_FABRICATOR_FORTUNE_3, "machines");
        upgradeItem(MCTechItems.UPGRADE_MASS_FABRICATOR_FORTUNE_4, "machines");
        upgradeItem(MCTechItems.UPGRADE_NANO_OVERCLOCKER, "machines");
        upgradeItem(MCTechItems.UPGRADE_QUANTUM_OVERCLOCKER, "machines");
        upgradeItem(MCTechItems.UPGRADE_SCRAP_GENERATION, "machines");
        upgradeItem(MCTechItems.UPGRADE_SINGULAR_OVERCLOCKER, "machines");
    }

    private ItemModelBuilder createBlockItem(DeferredBlock<?> deferredBlock) {
        return createBlockItem(deferredBlock, "");
    }

    private ItemModelBuilder createBlockItem(DeferredBlock<?> deferredBlock, String str) {
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(deferredBlock.asItem());
        if (str.isEmpty()) {
            str = key.getPath();
        }
        return withExistingParent(key.toString(), modLoc(String.format("block/%s", str)));
    }

    private ItemModelBuilder miscItem(DeferredItem<?> deferredItem) {
        return advBasicItem(deferredItem, "misc/");
    }

    private ItemModelBuilder upgradeItem(DeferredItem<?> deferredItem, String str) {
        return advBasicItem(deferredItem, String.format("upgrades/%s/", str));
    }

    private ItemModelBuilder advBasicItem(DeferredItem<?> deferredItem, String str) {
        ResourceLocation resourceLocation = (ResourceLocation) Objects.requireNonNull(BuiltInRegistries.ITEM.getKey((Item) deferredItem.get()));
        return getBuilder(resourceLocation.toString()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", ResourceLocation.fromNamespaceAndPath(resourceLocation.getNamespace(), "item/" + str + resourceLocation.getPath()));
    }
}
