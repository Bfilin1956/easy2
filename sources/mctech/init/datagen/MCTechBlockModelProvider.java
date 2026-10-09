package mctech.init.datagen;

import mctech.MCTech;
import mctech.init.MCTechProperties;
import net.mcskill.msregistry.registry.holder.LBlock;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/datagen/MCTechBlockModelProvider.class */
public class MCTechBlockModelProvider extends BlockStateProvider {
    public MCTechBlockModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, MCTech.MODID, existingFileHelper);
    }

    protected void registerStatesAndModels() {
    }

    private <B extends Block> void createOre(@NotNull DeferredBlock<B> deferredBlock) {
        Block block = (Block) deferredBlock.get();
        String path = deferredBlock.getId().getPath();
        BuiltInRegistries.BLOCK.getKey(block);
        getVariantBuilder(block).forAllStates(blockState -> {
            return ConfiguredModel.builder().modelFile(models().cubeAll(path, ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/ore/%s", path))).texture("particle", ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/ore/%s", path)))).build();
        });
    }

    private <B extends Block> void createAllSidedActiveInactive(@NotNull LBlock<B> lBlock, @Nullable String str) {
        Block block = (Block) lBlock.get();
        String path = lBlock.getId().getPath();
        ResourceLocation key = BuiltInRegistries.BLOCK.getKey(block);
        getVariantBuilder(block).forAllStates(blockState -> {
            String str2 = ((Boolean) blockState.getValue(MCTechProperties.ACTIVE)).booleanValue() ? "active" : "inactive";
            ConfiguredModel.Builder builder = ConfiguredModel.builder();
            BlockModelProvider blockModelProviderModels = models();
            String str3 = String.format("%s_%s", str2, key.getPath());
            Object[] objArr = new Object[3];
            objArr[0] = str == null ? path : String.format("%s/%s", str, path);
            objArr[1] = str2;
            objArr[2] = Direction.DOWN.getName();
            ResourceLocation resourceLocationFromNamespaceAndPath = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", objArr));
            Object[] objArr2 = new Object[3];
            objArr2[0] = str == null ? path : String.format("%s/%s", str, path);
            objArr2[1] = str2;
            objArr2[2] = Direction.UP.getName();
            ResourceLocation resourceLocationFromNamespaceAndPath2 = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", objArr2));
            Object[] objArr3 = new Object[3];
            objArr3[0] = str == null ? path : String.format("%s/%s", str, path);
            objArr3[1] = str2;
            objArr3[2] = Direction.NORTH.getName();
            ResourceLocation resourceLocationFromNamespaceAndPath3 = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", objArr3));
            Object[] objArr4 = new Object[3];
            objArr4[0] = str == null ? path : String.format("%s/%s", str, path);
            objArr4[1] = str2;
            objArr4[2] = Direction.SOUTH.getName();
            ResourceLocation resourceLocationFromNamespaceAndPath4 = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", objArr4));
            Object[] objArr5 = new Object[3];
            objArr5[0] = str == null ? path : String.format("%s/%s", str, path);
            objArr5[1] = str2;
            objArr5[2] = Direction.EAST.getName();
            ResourceLocation resourceLocationFromNamespaceAndPath5 = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", objArr5));
            Object[] objArr6 = new Object[3];
            objArr6[0] = str == null ? path : String.format("%s/%s", str, path);
            objArr6[1] = str2;
            objArr6[2] = Direction.WEST.getName();
            BlockModelBuilder blockModelBuilderCube = blockModelProviderModels.cube(str3, resourceLocationFromNamespaceAndPath, resourceLocationFromNamespaceAndPath2, resourceLocationFromNamespaceAndPath3, resourceLocationFromNamespaceAndPath4, resourceLocationFromNamespaceAndPath5, ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", objArr6)));
            Object[] objArr7 = new Object[3];
            objArr7[0] = str == null ? path : String.format("%s/%s", str, path);
            objArr7[1] = str2;
            objArr7[2] = Direction.NORTH.getName();
            return builder.modelFile(blockModelBuilderCube.texture("particle", ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("block/%s/%s_%s", objArr7)))).rotationY(((int) blockState.getValue(MCTechProperties.ALL_FACINGS).toYRot()) % 360).build();
        });
    }
}
