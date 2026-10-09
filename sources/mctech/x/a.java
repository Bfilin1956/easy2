package mctech.x;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import mctech.utils.c.h;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.ShaderInstance;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL30C;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/a.class */
public class a {
    public static void a(RenderTarget renderTarget, RenderTarget renderTarget2, int i, int i2, float f) {
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE);
        RenderSystem.assertOnRenderThread();
        GlStateManager._colorMask(true, true, true, false);
        GlStateManager._disableDepthTest();
        GlStateManager._depthMask(false);
        GlStateManager._viewport(0, 0, i, i2);
        ShaderInstance shaderInstanceC = b.a.c();
        shaderInstanceC.setSampler("ScreenSampler", Integer.valueOf(renderTarget2.getColorTextureId()));
        shaderInstanceC.setSampler("DiffuseSampler", Integer.valueOf(renderTarget.getColorTextureId()));
        shaderInstanceC.safeGetUniform("Blend").set(f);
        shaderInstanceC.apply();
        BufferBuilder bufferBuilderBegin = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.BLIT_SCREEN);
        bufferBuilderBegin.addVertex(0.0f, 0.0f, 0.0f);
        bufferBuilderBegin.addVertex(1.0f, 0.0f, 0.0f);
        bufferBuilderBegin.addVertex(1.0f, 1.0f, 0.0f);
        bufferBuilderBegin.addVertex(0.0f, 1.0f, 0.0f);
        BufferUploader.draw(bufferBuilderBegin.buildOrThrow());
        shaderInstanceC.clear();
        GlStateManager._depthMask(true);
        GlStateManager._colorMask(true, true, true, true);
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    }

    public static void a(RenderTarget renderTarget, int i, int i2, float f) {
        a(renderTarget, Minecraft.getInstance().getMainRenderTarget(), i, i2, f);
    }

    public static void a(RenderTarget renderTarget, RenderTarget renderTarget2, int i, int i2) {
        GL30C.glBindFramebuffer(36008, renderTarget.frameBufferId);
        GL30C.glBindFramebuffer(36009, renderTarget2.frameBufferId);
        GL30C.glBlitFramebuffer(0, 0, i, i2, 0, 0, i, i2, h.i, 9728);
        GL30C.glBindFramebuffer(36160, 0);
        Minecraft.getInstance().getMainRenderTarget().bindWrite(false);
    }

    private static void a(GuiGraphics guiGraphics, float f, float f2, float f3, float f4) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferBuilderBegin.addVertex(matrix4fPose, f, f2, 0.0f).setUv(0.0f, 0.0f);
        bufferBuilderBegin.addVertex(matrix4fPose, f, f4, 0.0f).setUv(0.0f, 1.0f);
        bufferBuilderBegin.addVertex(matrix4fPose, f3, f4, 0.0f).setUv(1.0f, 1.0f);
        bufferBuilderBegin.addVertex(matrix4fPose, f3, f2, 0.0f).setUv(1.0f, 0.0f);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }

    private static void a(GuiGraphics guiGraphics, float f, float f2, float f3, float f4, int i) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
        bufferBuilderBegin.addVertex(matrix4fPose, f, f2, 0.0f).setUv(0.0f, 0.0f).setColor(i);
        bufferBuilderBegin.addVertex(matrix4fPose, f, f4, 0.0f).setUv(0.0f, 1.0f).setColor(i);
        bufferBuilderBegin.addVertex(matrix4fPose, f3, f4, 0.0f).setUv(1.0f, 1.0f).setColor(i);
        bufferBuilderBegin.addVertex(matrix4fPose, f3, f2, 0.0f).setUv(1.0f, 0.0f).setColor(i);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }
}
