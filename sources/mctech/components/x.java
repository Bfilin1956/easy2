package mctech.components;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.Nonnull;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/x.class */
@OnlyIn(Dist.CLIENT)
public class x implements ClientTooltipComponent {

    @Nonnull
    private final y a;
    private final int b = 20;
    private final int c = 18;

    public x(@Nonnull y yVar) {
        this.a = yVar;
    }

    public int getHeight() {
        return (this.a.b().length * 18) + 3;
    }

    public int getWidth(@Nonnull Font font) {
        return Math.max(20 + Arrays.stream(this.a.b()).mapToInt(itemStack -> {
            return font.width(itemStack.getHoverName());
        }).max().orElse(0), font.width(this.a.a()));
    }

    public void renderImage(@NotNull Font font, int i, int i2, @NotNull GuiGraphics guiGraphics) {
        int iMax = Math.max(font.width(this.a.a()), getWidth(font)) - 2;
        int i3 = (int) (iMax * 0.4f);
        int i4 = iMax - i3;
        int i5 = i4 / 2;
        RenderSystem.enableDepthTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        a(guiGraphics.pose().last().pose(), i + 1 + i5, i2, i3, 1, 0, -1, -1);
        a(guiGraphics.pose().last().pose(), i + 1, i2, i5, 1, 0, 16777215, -1);
        a(guiGraphics.pose().last().pose(), i + 1 + i5 + i3, i2, i4 - i5, 1, 0, -1, 16777215);
        int i6 = i2 + 3;
        for (ItemStack itemStack : this.a.b()) {
            guiGraphics.renderItem(itemStack, i, i6);
            Objects.requireNonNull(font);
            guiGraphics.drawString(font, itemStack.getHoverName().getString(), i + 20, (i6 + 9.0f) - (9.0f / 2.0f), -1, true);
            i6 += 18;
        }
    }

    private void a(@Nonnull Matrix4f matrix4f, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + i3;
        int i9 = i2 + i4;
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        float f = ((i6 >> 24) & 255) / 255.0f;
        float f2 = ((i6 >> 16) & 255) / 255.0f;
        float f3 = ((i6 >> 8) & 255) / 255.0f;
        float f4 = (i6 & 255) / 255.0f;
        float f5 = ((i7 >> 24) & 255) / 255.0f;
        float f6 = ((i7 >> 16) & 255) / 255.0f;
        float f7 = ((i7 >> 8) & 255) / 255.0f;
        float f8 = (i7 & 255) / 255.0f;
        bufferBuilderBegin.addVertex(matrix4f, i8, i2, i5).setColor(f6, f7, f8, f5);
        bufferBuilderBegin.addVertex(matrix4f, i, i2, i5).setColor(f2, f3, f4, f);
        bufferBuilderBegin.addVertex(matrix4f, i, i9, i5).setColor(f2, f3, f4, f);
        bufferBuilderBegin.addVertex(matrix4f, i8, i9, i5).setColor(f6, f7, f8, f5);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        RenderSystem.disableBlend();
    }
}
