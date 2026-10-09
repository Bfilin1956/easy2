package mctech.v;

import java.util.List;
import java.util.Map;
import mctech.MCTech;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.ChunkRenderTypeSet;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.model.data.ModelData;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/q.class */
public class q {
    public static final q a = new q();
    List<mctech.v.c.b> b = mctech.utils.a.b.i();

    @SubscribeEvent
    public void a(ModelEvent.ModifyBakingResult modifyBakingResult) {
        modifyBakingResult.getModels().put(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "obscurator")), new mctech.v.f.c((BakedModel) modifyBakingResult.getModels().get(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "obscurator")))));
    }

    public static boolean a(BakedModel bakedModel) {
        return bakedModel.getParticleIcon(ModelData.EMPTY) == Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(MissingTextureAtlasSprite.getLocation());
    }

    private void a(Map<ModelResourceLocation, BakedModel> map, BakedModel bakedModel, ModelResourceLocation modelResourceLocation) {
        if (a(map.get(modelResourceLocation))) {
            map.put(modelResourceLocation, bakedModel);
        }
    }

    public static ChunkRenderTypeSet a(BlockState blockState, RandomSource randomSource) {
        return a(blockState, randomSource, ModelData.EMPTY);
    }

    public static ChunkRenderTypeSet a(BlockState blockState, RandomSource randomSource, ModelData modelData) {
        return Minecraft.getInstance().getBlockRenderer().getBlockModel(blockState).getRenderTypes(blockState, randomSource, modelData);
    }
}
