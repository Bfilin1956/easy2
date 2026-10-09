package mctech.g.c.b;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mctech.init.MCTechDataComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SingleThreadedRandomSource;
import net.neoforged.neoforge.client.RenderTypeGroup;
import net.neoforged.neoforge.client.model.BakedModelWrapper;
import net.neoforged.neoforge.client.model.IModelBuilder;
import net.neoforged.neoforge.client.model.IQuadTransformer;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/d.class */
public class d extends BakedModelWrapper<BakedModel> {
    private final a a;

    public d(BakedModel bakedModel) {
        super(bakedModel);
        this.a = new a();
    }

    public ItemOverrides getOverrides() {
        return this.a;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/d$a.class */
    public static class a extends ItemOverrides {
        private final Map<Holder<mctech.g.a.a<?, ?>>, BakedModel> a = new HashMap();

        @Nullable
        public BakedModel resolve(BakedModel bakedModel, ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity, int i) {
            return this.a.computeIfAbsent((Holder) itemStack.get(MCTechDataComponent.CONDUIT), holder -> {
                return a((Holder<mctech.g.a.a<?, ?>>) holder, bakedModel);
            });
        }

        private BakedModel a(@Nullable Holder<mctech.g.a.a<?, ?>> holder, BakedModel bakedModel) {
            ResourceLocation location = MissingTextureAtlasSprite.getLocation();
            if (holder != null) {
                location = ((mctech.g.a.a) holder.value()).a();
            }
            TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite) Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(location);
            IModelBuilder iModelBuilderOf = IModelBuilder.of(bakedModel.useAmbientOcclusion(), bakedModel.usesBlockLight(), bakedModel.isGui3d(), bakedModel.getTransforms(), bakedModel.getOverrides(), textureAtlasSprite, RenderTypeGroup.EMPTY);
            SingleThreadedRandomSource singleThreadedRandomSource = new SingleThreadedRandomSource(42L);
            Iterator it = bakedModel.getQuads((BlockState) null, (Direction) null, singleThreadedRandomSource, ModelData.EMPTY, (RenderType) null).iterator();
            while (it.hasNext()) {
                iModelBuilderOf.addUnculledFace(a((BakedQuad) it.next(), textureAtlasSprite));
            }
            for (Direction direction : Direction.values()) {
                singleThreadedRandomSource.setSeed(42L);
                Iterator it2 = bakedModel.getQuads((BlockState) null, direction, singleThreadedRandomSource, ModelData.EMPTY, (RenderType) null).iterator();
                while (it2.hasNext()) {
                    iModelBuilderOf.addCulledFace(direction, a((BakedQuad) it2.next(), textureAtlasSprite));
                }
            }
            return iModelBuilderOf.build();
        }

        protected BakedQuad a(BakedQuad bakedQuad, TextureAtlasSprite textureAtlasSprite) {
            BakedQuad bakedQuad2 = new BakedQuad(Arrays.copyOf(bakedQuad.getVertices(), 32), -1, bakedQuad.getDirection(), textureAtlasSprite, bakedQuad.isShade());
            for (int i = 0; i < 4; i++) {
                float[] fArrA = mctech.g.c.g.a(bakedQuad2.getVertices(), i, IQuadTransformer.UV0, 2);
                fArrA[0] = (((fArrA[0] - bakedQuad.getSprite().getU0()) * textureAtlasSprite.contents().width()) / bakedQuad.getSprite().contents().width()) + textureAtlasSprite.getU0();
                fArrA[1] = (((fArrA[1] - bakedQuad.getSprite().getV0()) * textureAtlasSprite.contents().height()) / bakedQuad.getSprite().contents().height()) + textureAtlasSprite.getV0();
                int[] iArrA = mctech.g.c.g.a(fArrA[0], fArrA[1]);
                bakedQuad2.getVertices()[IQuadTransformer.UV0 + (i * IQuadTransformer.STRIDE)] = iArrA[0];
                bakedQuad2.getVertices()[IQuadTransformer.UV0 + 1 + (i * IQuadTransformer.STRIDE)] = iArrA[1];
            }
            return bakedQuad2;
        }
    }
}
