package mctech.v;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import org.joml.Matrix4f;

/* JADX INFO: renamed from: mctech.v.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c.class */
public class C0209c extends EntityRenderer<Entity> {
    ResourceLocation a;

    public C0209c(EntityRendererProvider.Context context, ResourceLocation resourceLocation) {
        super(context);
        this.a = resourceLocation;
    }

    public void render(Entity entity, float f, float f2, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(f2, entity.yRotO, entity.getYRot()) - 90.0f));
        poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(f2, entity.xRotO, entity.getXRot())));
        poseStack.mulPose(Axis.XP.rotationDegrees(45.0f));
        poseStack.scale(0.05625f, 0.05625f, 0.05625f);
        poseStack.translate(-4.0d, 0.0d, 0.0d);
        VertexConsumer buffer = multiBufferSource.getBuffer(RenderType.entityCutout(getTextureLocation(entity)));
        PoseStack.Pose poseLast = poseStack.last();
        Matrix4f matrix4fPose = poseLast.pose();
        a(matrix4fPose, poseLast, buffer, -7, -2, -2, 0.0f, 0.15625f, -1, 0, 0, i);
        a(matrix4fPose, poseLast, buffer, -7, -2, 2, 0.15625f, 0.15625f, -1, 0, 0, i);
        a(matrix4fPose, poseLast, buffer, -7, 2, 2, 0.15625f, 0.3125f, -1, 0, 0, i);
        a(matrix4fPose, poseLast, buffer, -7, 2, -2, 0.0f, 0.3125f, -1, 0, 0, i);
        a(matrix4fPose, poseLast, buffer, -7, 2, -2, 0.0f, 0.15625f, 1, 0, 0, i);
        a(matrix4fPose, poseLast, buffer, -7, 2, 2, 0.15625f, 0.15625f, 1, 0, 0, i);
        a(matrix4fPose, poseLast, buffer, -7, -2, 2, 0.15625f, 0.3125f, 1, 0, 0, i);
        a(matrix4fPose, poseLast, buffer, -7, -2, -2, 0.0f, 0.3125f, 1, 0, 0, i);
        for (int i2 = 0; i2 < 4; i2++) {
            poseStack.mulPose(Axis.XP.rotationDegrees(90.0f));
            a(matrix4fPose, poseLast, buffer, -8, -2, 0, 0.0f, 0.0f, 0, 1, 0, i);
            a(matrix4fPose, poseLast, buffer, 8, -2, 0, 0.5f, 0.0f, 0, 1, 0, i);
            a(matrix4fPose, poseLast, buffer, 8, 2, 0, 0.5f, 0.15625f, 0, 1, 0, i);
            a(matrix4fPose, poseLast, buffer, -8, 2, 0, 0.0f, 0.15625f, 0, 1, 0, i);
        }
        poseStack.popPose();
        super.render(entity, f, f2, poseStack, multiBufferSource, i);
    }

    public void a(Matrix4f matrix4f, PoseStack.Pose pose, VertexConsumer vertexConsumer, int i, int i2, int i3, float f, float f2, int i4, int i5, int i6, int i7) {
        vertexConsumer.addVertex(matrix4f, i, i2, i3).setColor(255, 255, 255, 255).setUv(f, f2).setOverlay(OverlayTexture.NO_OVERLAY).setLight(i7).setNormal(pose, i4, i6, i5);
    }

    public ResourceLocation getTextureLocation(Entity entity) {
        return this.a;
    }
}
