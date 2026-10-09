package mctech.v;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mctech.MCTech;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.texture.AutoGlowingTexture;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/j.class */
public class j<T extends GeoAnimatable> extends GeoRenderLayer<T> {
    public j(GeoRenderer<T> geoRenderer) {
        super(geoRenderer);
    }

    public void render(PoseStack poseStack, T t, BakedGeoModel bakedGeoModel, RenderType renderType, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, float f, int i, int i2) {
        ResourceLocation textureLocation = this.renderer.getTextureLocation(t);
        try {
            RenderType renderType2 = AutoGlowingTexture.getRenderType(textureLocation);
            getRenderer().reRender(bakedGeoModel, poseStack, multiBufferSource, t, renderType2, multiBufferSource.getBuffer(renderType2), f, 15728880, i2, this.renderer.getRenderColor(t, f, i).argbInt());
        } catch (Exception e) {
            MCTech.LOGGER.warn("Failed to load emissive texture for {}: {}", textureLocation, e.toString());
        }
    }
}
