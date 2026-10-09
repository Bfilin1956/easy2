package mctech.utils;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import javax.annotation.Nonnull;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/p.class */
public class p {
    public static void a(@Nonnull ResourceLocation resourceLocation, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, int i, int i2, int i3, int i4) {
        a(resourceLocation, guiGraphics, f, f + i3, f2, f2 + i4, f3, i3, i4, i, i2, mctech.utils.c.h.i, mctech.utils.c.h.i);
    }

    public static void a(@Nonnull ResourceLocation resourceLocation, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, int i, int i2, int i3, int i4, int i5, int i6) {
        a(resourceLocation, guiGraphics, f, f + i3, f2, f2 + i4, f3, i3, i4, i, i2, i5, i6);
    }

    public static void a(@Nonnull ResourceLocation resourceLocation, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4, int i5, int i6) {
        a(resourceLocation, guiGraphics, f, f + f3, f2, f2 + f4, 0.0f, i3, i4, i, i2, i5, i6);
    }

    public static void a(@Nonnull ResourceLocation resourceLocation, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5, int i, int i2, int i3, int i4, int i5, int i6) {
        a(resourceLocation, guiGraphics, f, f2, f3, f4, f5, (i3 + 0.0f) / i5, (i3 + i) / i5, (i4 + 0.0f) / i6, (i4 + i2) / i6);
    }

    public static void a(@Nonnull ResourceLocation resourceLocation, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        RenderSystem.setShaderTexture(0, resourceLocation);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferBuilderBegin.addVertex(matrix4fPose, f, f4, f5).setUv(f6, f9);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f4, f5).setUv(f7, f9);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, f5).setUv(f7, f8);
        bufferBuilderBegin.addVertex(matrix4fPose, f, f3, f5).setUv(f6, f8);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }
}
