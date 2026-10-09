package mctech.v;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.texture.AutoGlowingTexture;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/h.class */
public class h<T extends GeoAnimatable> extends GeoRenderLayer<T> {
    public h(GeoRenderer<T> geoRenderer) {
        super(geoRenderer);
    }

    public void render(PoseStack poseStack, T t, BakedGeoModel bakedGeoModel, RenderType renderType, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, float f, int i, int i2) {
        i renderer = getRenderer();
        RenderType renderType2 = AutoGlowingTexture.getRenderType(renderer.getTextureLocation(t));
        int iArgbInt = renderer.getRenderColor(t, f, i).argbInt();
        i iVar = renderer instanceof i ? renderer : null;
        if (iVar != null) {
            iVar.a(true);
        }
        try {
            renderer.reRender(bakedGeoModel, poseStack, multiBufferSource, t, renderType2, multiBufferSource.getBuffer(renderType2), f, 15728880, i2, iArgbInt);
        } finally {
            if (iVar != null) {
                iVar.a(false);
            }
        }
    }
}
