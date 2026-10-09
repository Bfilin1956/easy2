package mctech.init.datagen.am;

import mctech.MCTech;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechProperties;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/datagen/am/BlockModelProvider.class */
public class BlockModelProvider extends BlockStateProvider {
    public BlockModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, MCTech.MODID, existingFileHelper);
    }

    protected void registerStatesAndModels() {
        createAllSidedActiveInactive(MCTechBlocks.CRYSTAL_GROWTH_CHAMBER);
        createAllSidedActiveInactive(MCTechBlocks.NANO_RECYCLER);
        createAllSidedActiveInactive(MCTechBlocks.NANO_REFINERY);
        createAllSidedActiveInactive(MCTechBlocks.QUANTUM_RECYCLER);
        createAllSidedActiveInactive(MCTechBlocks.QUANTUM_REFINERY);
        createAllSidedActiveInactive(MCTechBlocks.SINGULAR_RECYCLER);
        createAllSidedActiveInactive(MCTechBlocks.SINGULAR_REFINERY);
        createSided(MCTechBlocks.STONE_COMPRESSOR);
        createSided(MCTechBlocks.STONE_EXTRACTOR);
    }

    private void createSimple(@NotNull DeferredBlock<?> deferredBlock) {
        createSimple(deferredBlock, "misc/");
    }

    private void createSimple(@NotNull DeferredBlock<?> deferredBlock, String str) {
        Block block = (Block) deferredBlock.get();
        ResourceLocation key = BuiltInRegistries.BLOCK.getKey(block);
        simpleBlock(block, models().cubeAll(key.getPath(), modLoc("block/" + str + key.getPath())));
    }

    private void createSided(@NotNull DeferredBlock<?> deferredBlock) {
        Block block = (Block) deferredBlock.get();
        String path = deferredBlock.getId().getPath();
        horizontalICBlock(block, models().orientableWithBottom(BuiltInRegistries.BLOCK.getKey(block).getPath(), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/side", path)), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/front", path)), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/down", path)), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/up", path))));
    }

    private void createAllSidedActiveInactive(@NotNull DeferredBlock<?> deferredBlock) {
        Block block = (Block) deferredBlock.get();
        String path = deferredBlock.getId().getPath();
        ResourceLocation key = BuiltInRegistries.BLOCK.getKey(block);
        getVariantBuilder(block).forAllStates(blockState -> {
            String str = ((Boolean) blockState.getValue(MCTechProperties.ACTIVE)).booleanValue() ? "active" : "inactive";
            return ConfiguredModel.builder().modelFile(models().cube(String.format("%s_%s", str, key.getPath()), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", path, str, Direction.DOWN.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", path, str, Direction.UP.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", path, str, Direction.NORTH.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", path, str, Direction.SOUTH.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", path, str, Direction.EAST.getName())), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", path, str, Direction.WEST.getName()))).texture("particle", ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", path, str, Direction.NORTH.getName())))).rotationY(((int) blockState.getValue(MCTechProperties.ALL_FACINGS).toYRot()) % 360).build();
        });
    }

    private void horizontalICBlock(Block block, ModelFile modelFile) {
        getVariantBuilder(block).forAllStates(blockState -> {
            return ConfiguredModel.builder().modelFile(modelFile).rotationY((((int) blockState.getValue(MCTechProperties.ALL_FACINGS).toYRot()) + 180) % 360).build();
        });
    }
}
