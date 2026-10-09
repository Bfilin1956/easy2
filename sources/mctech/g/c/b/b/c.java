package mctech.g.c.b.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mctech.g.e.f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.IDynamicBakedModel;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/b/c.class */
public class c implements IDynamicBakedModel {
    private final Map<Block, List<BakedModel>> a;
    private final Block b;
    private final BakedModel c;

    public c(BakedModel bakedModel) {
        this.a = new HashMap();
        this.b = null;
        this.c = bakedModel;
    }

    private c(BakedModel bakedModel, Block block) {
        this.a = new HashMap();
        this.b = block;
        this.c = bakedModel;
    }

    public List<BakedQuad> getQuads(@Nullable BlockState blockState, @Nullable Direction direction, RandomSource randomSource, ModelData modelData, @Nullable RenderType renderType) {
        ArrayList arrayList = new ArrayList();
        if (this.b != null) {
            arrayList.addAll(a().getQuads(this.b.defaultBlockState(), direction, randomSource, modelData, renderType));
            arrayList.addAll(mctech.g.c.b.c.a(mctech.g.c.b.c.b).getQuads((BlockState) null, direction, randomSource, modelData, renderType));
        } else {
            arrayList.addAll(this.c.getQuads((BlockState) null, direction, randomSource, modelData, renderType));
        }
        return arrayList;
    }

    public boolean useAmbientOcclusion() {
        return false;
    }

    public boolean isGui3d() {
        return true;
    }

    public boolean usesBlockLight() {
        return true;
    }

    public boolean isCustomRenderer() {
        return false;
    }

    public TextureAtlasSprite getParticleIcon() {
        return f.a();
    }

    public ItemOverrides getOverrides() {
        return ItemOverrides.EMPTY;
    }

    public ItemTransforms getTransforms() {
        return mctech.g.c.b.c.a(mctech.g.c.b.c.b).getTransforms();
    }

    public List<RenderType> getRenderTypes(ItemStack itemStack, boolean z) {
        return List.of(RenderType.solid());
    }

    public List<BakedModel> getRenderPasses(ItemStack itemStack, boolean z) {
        return List.of(this);
    }

    private BakedModel a() {
        return Minecraft.getInstance().getItemRenderer().getModel(this.b.asItem().getDefaultInstance(), (Level) null, (LivingEntity) null, 0);
    }
}
