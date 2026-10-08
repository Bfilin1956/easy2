package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.ElementaVersion;
import gg.essential.elementa.UIComponent;
import gg.essential.elementa.constraints.ColorConstraint;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.state.State;
import gg.essential.universal.UGraphics;
import gg.essential.universal.UMatrixStack;
import gg.essential.universal.graphics.CommonVertexFormats;
import gg.essential.universal.graphics.DrawMode;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TriangleBlock.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/TriangleBlock.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0007B\u0017\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\u0004\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J.\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J6\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0006J>\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0006¨\u0006\u0016"}, d2 = {"Lnet/mcskill/shop/client/screen/component/TriangleBlock;", "Lgg/essential/elementa/UIComponent;", "color", "Lgg/essential/elementa/constraints/ColorConstraint;", "<init>", "(Lgg/essential/elementa/constraints/ColorConstraint;)V", "Ljava/awt/Color;", "(Ljava/awt/Color;)V", "Lgg/essential/elementa/state/State;", "(Lgg/essential/elementa/state/State;)V", "draw", "", "matrixStack", "Lgg/essential/universal/UMatrixStack;", "drawTriangle", "x", "", "y", "w", "h", "tess", "Lgg/essential/universal/UGraphics;", "MSShop"})
public final class TriangleBlock extends UIComponent {
    public TriangleBlock() {
        this(null, 1, null);
    }

    public TriangleBlock(@NotNull ColorConstraint color) {
        Intrinsics.checkNotNullParameter(color, "color");
        setColor(color);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TriangleBlock(ColorConstraint colorConstraint, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            Color color = Color.WHITE;
            Intrinsics.checkNotNullExpressionValue(color, "WHITE");
            colorConstraint = (ColorConstraint) UtilitiesKt.toConstraint(color);
        }
        this(colorConstraint);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TriangleBlock(@NotNull Color color) {
        this(UtilitiesKt.toConstraint(color));
        Intrinsics.checkNotNullParameter(color, "color");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TriangleBlock(@NotNull State<Color> state) {
        this(ExtensionsKt.toConstraint(state));
        Intrinsics.checkNotNullParameter(state, "color");
    }

    public void draw(@NotNull UMatrixStack matrixStack) {
        Intrinsics.checkNotNullParameter(matrixStack, "matrixStack");
        beforeDrawCompat(matrixStack);
        double x = getLeft();
        double y = getTop();
        double width = getRight();
        double height = getBottom();
        drawTriangle(matrixStack, x, y, width, height);
        super.draw(matrixStack);
    }

    public final void drawTriangle(@NotNull UMatrixStack matrixStack, double x, double y, double w, double h) {
        Intrinsics.checkNotNullParameter(matrixStack, "matrixStack");
        Color color = getColor();
        if (color.getAlpha() == 0) {
            return;
        }
        drawTriangle(matrixStack, x, y, w, h, color);
    }

    public final void drawTriangle(@NotNull UMatrixStack matrixStack, double x, double y, double w, double h, @NotNull Color color) {
        Intrinsics.checkNotNullParameter(matrixStack, "matrixStack");
        Intrinsics.checkNotNullParameter(color, "color");
        UGraphics.Companion.enableBlend();
        UGraphics.Companion.tryBlendFuncSeparate(770, 771, 1, 0);
        UGraphics buf = UGraphics.Companion.getFromTessellator();
        buf.beginWithDefaultShader(DrawMode.TRIANGLES, CommonVertexFormats.POSITION_COLOR);
        drawTriangle(buf, matrixStack, x, y, w, h, color);
        UGraphics.Companion.disableBlend();
    }

    public final void drawTriangle(@NotNull UGraphics tess, @NotNull UMatrixStack matrixStack, double x, double y, double w, double h, @NotNull Color color) {
        Intrinsics.checkNotNullParameter(tess, "tess");
        Intrinsics.checkNotNullParameter(matrixStack, "matrixStack");
        Intrinsics.checkNotNullParameter(color, "color");
        float red = color.getRed() / 255.0f;
        float green = color.getGreen() / 255.0f;
        float blue = color.getBlue() / 255.0f;
        float alpha = color.getAlpha() / 255.0f;
        tess.pos(matrixStack, x, y, 0.0d).color(red, green, blue, alpha).endVertex();
        tess.pos(matrixStack, w, h, 0.0d).color(red, green, blue, alpha).endVertex();
        tess.pos(matrixStack, w, y, 0.0d).color(red, green, blue, alpha).endVertex();
        if (ElementaVersion.Companion.isActive().compareTo(ElementaVersion.V2) >= 0) {
            UGraphics.Companion.enableDepth();
            UGraphics.Companion.depthFunc(519);
            tess.drawDirect();
            UGraphics.Companion.disableDepth();
            UGraphics.Companion.depthFunc(515);
            return;
        }
        tess.drawDirect();
    }
}
