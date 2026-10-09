package mctech.v;

import com.mojang.blaze3d.Blaze3D;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import mctech.blockentities.c.ad;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/A.class */
public class A extends GeoRenderLayer<ad> {
    public A(GeoRenderer<ad> geoRenderer) {
        super(geoRenderer);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(PoseStack poseStack, ad adVar, BakedGeoModel bakedGeoModel, @Nullable RenderType renderType, MultiBufferSource multiBufferSource, @Nullable VertexConsumer vertexConsumer, float f, int i, int i2) {
        ItemStack itemStack = adVar.d;
        if (itemStack.isEmpty() || !adVar.isActive()) {
            return;
        }
        poseStack.pushPose();
        float time = (float) Blaze3D.getTime();
        poseStack.translate(0.0d, 0.4d + (0.15d * Math.sin(time * 4.0f)), 0.0d);
        poseStack.mulPose(Axis.YP.rotation((float) Math.cos(time * 4.0f)));
        poseStack.scale(0.7f, 0.7f, 0.7f);
        Minecraft.getInstance().getItemRenderer().renderStatic(itemStack, ItemDisplayContext.GROUND, 15728880, OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, adVar.getLevel(), 0);
        poseStack.popPose();
    }
}
