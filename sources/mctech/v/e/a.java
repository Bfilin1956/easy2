package mctech.v.e;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.GameRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/e/a.class */
@OnlyIn(Dist.CLIENT)
public class a {
    public static void a(boolean z) {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        if (z) {
            RenderSystem.disableDepthTest();
        } else {
            RenderSystem.enableDepthTest();
        }
    }

    public static void b(boolean z) {
        if (z) {
            RenderSystem.enableDepthTest();
        }
    }

    public static void a(PoseStack poseStack, int i, int i2, int i3, int i4) {
        GlStateManager._enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        int i5 = 4 + i;
        int i6 = i5 + i3;
        int i7 = 4 + i2;
        int i8 = i7 + i4;
        a(poseStack, i5 - 3, i7 - 4, i6 + 3, i7 - 3, -267386864, bufferBuilderBegin);
        a(poseStack, i5 - 3, i8 + 3, i6 + 3, i8 + 4, -267386864, bufferBuilderBegin);
        a(poseStack, i5 - 3, i7 - 3, i6 + 3, i8 + 3, -267386864, bufferBuilderBegin);
        a(poseStack, i5 - 4, i7 - 3, i5 - 3, i8 + 3, -267386864, bufferBuilderBegin);
        a(poseStack, i6 + 3, i7 - 3, i6 + 4, i8 + 3, -267386864, bufferBuilderBegin);
        a(poseStack, i5 - 3, (i7 - 3) + 1, (i5 - 3) + 1, (i8 + 3) - 1, 1347420415, bufferBuilderBegin);
        a(poseStack, i6 + 2, (i7 - 3) + 1, i6 + 3, (i8 + 3) - 1, 1347420415, bufferBuilderBegin);
        a(poseStack, i5 - 3, i7 - 3, i6 + 3, (i7 - 3) + 1, 1347420415, bufferBuilderBegin);
        a(poseStack, i5 - 3, i8 + 2, i6 + 3, i8 + 3, 1344798847, bufferBuilderBegin);
        GlStateManager._enableDepthTest();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        GlStateManager._disableDepthTest();
        GlStateManager._disableBlend();
    }

    public static void a(PoseStack poseStack, int i, int i2, int i3, int i4, int i5, BufferBuilder bufferBuilder) {
        float f = ((i5 >> 24) & 255) / 255.0f;
        float f2 = ((i5 >> 16) & 255) / 255.0f;
        float f3 = ((i5 >> 8) & 255) / 255.0f;
        float f4 = (i5 & 255) / 255.0f;
        Matrix4f matrix4fPose = poseStack.last().pose();
        bufferBuilder.addVertex(matrix4fPose, i3, i2, -10.0f).setColor(f2, f3, f4, f);
        bufferBuilder.addVertex(matrix4fPose, i, i2, -10.0f).setColor(f2, f3, f4, f);
        bufferBuilder.addVertex(matrix4fPose, i, i4, -10.0f).setColor(f2, f3, f4, f);
        bufferBuilder.addVertex(matrix4fPose, i3, i4, -10.0f).setColor(f2, f3, f4, f);
    }
}
