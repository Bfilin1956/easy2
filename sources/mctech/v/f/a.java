package mctech.v.f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.ChunkRenderTypeSet;
import net.neoforged.neoforge.client.model.data.ModelData;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/a.class */
@OnlyIn(Dist.CLIENT)
public abstract class a implements BakedModel {
    public static final ChunkRenderTypeSet a = ChunkRenderTypeSet.of(new RenderType[]{RenderType.solid()});
    public static final ResourceLocation b = ResourceLocation.parse("mctech:internal");
    TextureAtlasSprite c;
    ItemTransforms d;
    ChunkRenderTypeSet e = a;

    /* JADX INFO: renamed from: mctech.v.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/a$a.class */
    public static class C0048a extends ItemOverrides {
        public static final C0048a a = new C0048a();
    }

    public abstract void a();

    public void a(ItemTransforms itemTransforms) {
        this.d = itemTransforms;
    }

    public ItemTransforms b() {
        return this.d;
    }

    protected void a(TextureAtlasSprite textureAtlasSprite) {
    }

    public void a(ChunkRenderTypeSet chunkRenderTypeSet) {
        this.e = chunkRenderTypeSet;
    }

    public ItemOverrides getOverrides() {
        return C0048a.a;
    }

    public TextureAtlasSprite getParticleIcon() {
        return this.c;
    }

    public TextureAtlasSprite getParticleIcon(ModelData modelData) {
        return super.getParticleIcon(modelData);
    }

    public List<BakedQuad> getQuads(BlockState blockState, Direction direction, RandomSource randomSource, ModelData modelData, RenderType renderType) {
        return c();
    }

    public List<BakedQuad> getQuads(BlockState blockState, Direction direction, RandomSource randomSource) {
        return getQuads(blockState, direction, randomSource, ModelData.EMPTY, null);
    }

    public boolean useAmbientOcclusion() {
        return true;
    }

    public boolean isCustomRenderer() {
        return false;
    }

    public boolean isGui3d() {
        return true;
    }

    public boolean usesBlockLight() {
        return false;
    }

    protected static <T> List<T> c() {
        return Collections.emptyList();
    }

    protected static List<BakedQuad>[] a(int i) {
        List<BakedQuad>[] listArr = new List[i];
        for (int i2 = 0; i2 < i; i2++) {
            listArr[i2] = new ArrayList();
        }
        return listArr;
    }
}
