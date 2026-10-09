package mctech.v;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.texture.AutoGlowingTexture;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

/* JADX INFO: renamed from: mctech.v.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/b.class */
public class C0208b<T extends GeoAnimatable> extends AutoGlowingGeoLayer<T> {
    public C0208b(GeoRenderer<T> geoRenderer) {
        super(geoRenderer);
    }

    @Nullable
    protected RenderType getRenderType(T t, @Nullable MultiBufferSource multiBufferSource) {
        return AutoGlowingTexture.getRenderType(getTextureResource(t));
    }

    public void render(PoseStack poseStack, T t, BakedGeoModel bakedGeoModel, @Nullable RenderType renderType, MultiBufferSource multiBufferSource, @Nullable VertexConsumer vertexConsumer, float f, int i, int i2) {
        int iArgbInt = getRenderer().getRenderColor(t, f, i).argbInt();
        poseStack.pushPose();
        getRenderer().actuallyRender(poseStack, t, bakedGeoModel, getRenderType(t, multiBufferSource), multiBufferSource, vertexConsumer, true, f, i, i2, iArgbInt);
        poseStack.popPose();
    }
}
