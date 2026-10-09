package mctech.utils;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import javax.annotation.Nonnull;
import net.minecraft.client.gui.GuiGraphics;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/l.class */
public class l {
    public static void a(@Nonnull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5, float f6, int i) {
        a(guiGraphics, f, f2, f3, f4, f5, f6, ((i >> 16) & 255) / 255.0f, ((i >> 8) & 255) / 255.0f, (i & 255) / 255.0f, ((i >> 24) & 255) / 255.0f);
    }

    public static void a(@Nonnull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        if (f10 != 1.0f) {
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
        }
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        a(matrix4fPose, bufferBuilderBegin, f, f2, f3, f4, f6, f7, f8, f9, f10);
        a(matrix4fPose, bufferBuilderBegin, f, (f2 + f5) - f6, f3, f4, f6, f7, f8, f9, f10);
        a(matrix4fPose, bufferBuilderBegin, f, f2 + f6, f3, f6, f5 - (f6 * 2.0f), f7, f8, f9, f10);
        a(matrix4fPose, bufferBuilderBegin, (f + f4) - f6, f2 + f6, f3, f6, f5 - (f6 * 2.0f), f7, f8, f9, f10);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }

    private static void a(@Nonnull Matrix4f matrix4f, BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        bufferBuilder.addVertex(matrix4f, f + f4, f2, f3).setColor(f6, f7, f8, f9);
        bufferBuilder.addVertex(matrix4f, f, f2, f3).setColor(f6, f7, f8, f9);
        bufferBuilder.addVertex(matrix4f, f, f2 + f5, f3).setColor(f6, f7, f8, f9);
        bufferBuilder.addVertex(matrix4f, f + f4, f2 + f5, f3).setColor(f6, f7, f8, f9);
    }

    public static void a(@Nonnull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        bufferBuilderBegin.addVertex(matrix4fPose, f + f4, f2, f3).setColor(f6, f7, f8, f9);
        bufferBuilderBegin.addVertex(matrix4fPose, f, f2, f3).setColor(f6, f7, f8, f9);
        bufferBuilderBegin.addVertex(matrix4fPose, f, f2 + f5, f3).setColor(f6, f7, f8, f9);
        bufferBuilderBegin.addVertex(matrix4fPose, f + f4, f2 + f5, f3).setColor(f6, f7, f8, f9);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }

    public static void a(GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5) {
        int iAbs = Math.abs(i3 - i);
        int iAbs2 = Math.abs(i4 - i2);
        int i6 = i < i3 ? 1 : -1;
        int i7 = i2 < i4 ? 1 : -1;
        int i8 = i;
        int i9 = i2;
        int i10 = iAbs - iAbs2;
        while (true) {
            guiGraphics.hLine(i8, i8, i9, i5);
            if (i8 != i3 || i9 != i4) {
                int i11 = 2 * i10;
                if (i11 > (-iAbs2)) {
                    i10 -= iAbs2;
                    i8 += i6;
                }
                if (i11 < iAbs) {
                    i10 += iAbs;
                    i9 += i7;
                }
            } else {
                return;
            }
        }
    }
}
