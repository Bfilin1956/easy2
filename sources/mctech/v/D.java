package mctech.v;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mctech.MCTech;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.cache.texture.AutoGlowingTexture;
import software.bernie.geckolib.renderer.specialty.DynamicGeoBlockRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/D.class */
public class D extends DynamicGeoBlockRenderer<mctech.blockentities.b.l> implements i {
    private boolean a;

    public D(BlockEntityRendererProvider.Context context) {
        super(new mctech.v.f.j());
        addRenderLayer(new h(this));
    }

    @Override // mctech.v.i
    public void a(boolean z) {
        this.a = z;
    }

    @Override // mctech.v.i
    public boolean a() {
        return this.a;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RenderType getRenderType(mctech.blockentities.b.l lVar, ResourceLocation resourceLocation, @Nullable MultiBufferSource multiBufferSource, float f) {
        if (!this.a) {
            return super.getRenderType(lVar, resourceLocation, multiBufferSource, f);
        }
        return AutoGlowingTexture.getRenderType(resourceLocation != null ? resourceLocation : getTextureLocation(lVar));
    }

    protected boolean boneRenderOverride(PoseStack poseStack, GeoBone geoBone, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, float f, int i, int i2, int i3) {
        if (geoBone.getName().equals("wing1") || geoBone.getName().equals("wing2") || geoBone.getName().equals("wing3")) {
            return ((mctech.blockentities.b.l) this.animatable).f() == MachineTier.NONE;
        }
        return super.boneRenderOverride(poseStack, geoBone, multiBufferSource, vertexConsumer, f, i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureOverrideForBone(GeoBone geoBone, mctech.blockentities.b.l lVar, float f) {
        MachineTier machineTierF;
        if ((geoBone.getName().equals("wing1") || geoBone.getName().equals("wing2") || geoBone.getName().equals("wing3")) && (machineTierF = lVar.f()) != MachineTier.NONE) {
            return MCTech.loc(String.format("textures/block/windmill/turbine_t%s.png", machineTierF.asIntegerString()));
        }
        return super.getTextureOverrideForBone(geoBone, lVar, f);
    }
}
