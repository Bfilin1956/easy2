package mctech.utils;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/G.class */
public final class G extends Record {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;

    public G(int i, int i2, int i3, int i4, int i5, int i6) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, G.class), G.class, "x;y;width;height;offsetX;offsetY", "FIELD:Lmctech/utils/G;->a:I", "FIELD:Lmctech/utils/G;->b:I", "FIELD:Lmctech/utils/G;->c:I", "FIELD:Lmctech/utils/G;->d:I", "FIELD:Lmctech/utils/G;->e:I", "FIELD:Lmctech/utils/G;->f:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, G.class), G.class, "x;y;width;height;offsetX;offsetY", "FIELD:Lmctech/utils/G;->a:I", "FIELD:Lmctech/utils/G;->b:I", "FIELD:Lmctech/utils/G;->c:I", "FIELD:Lmctech/utils/G;->d:I", "FIELD:Lmctech/utils/G;->e:I", "FIELD:Lmctech/utils/G;->f:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, G.class, Object.class), G.class, "x;y;width;height;offsetX;offsetY", "FIELD:Lmctech/utils/G;->a:I", "FIELD:Lmctech/utils/G;->b:I", "FIELD:Lmctech/utils/G;->c:I", "FIELD:Lmctech/utils/G;->d:I", "FIELD:Lmctech/utils/G;->e:I", "FIELD:Lmctech/utils/G;->f:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public int g() {
        return this.f;
    }

    public G(mctech.utils.math.geometry.b bVar, int i, int i2) {
        this(bVar.a(), bVar.b(), bVar.d(), bVar.c(), i, i2);
    }

    public G a(int i, int i2) {
        return new G(this.a + i, this.b + i2, this.c, this.d, this.e, this.f);
    }

    public G b(int i, int i2) {
        return new G(this.a, this.b, this.c, this.d, this.e + i, this.f + i2);
    }

    public mctech.utils.math.geometry.b a() {
        return new mctech.utils.math.geometry.b(b(), c(), d(), e());
    }

    public boolean c(int i, int i2) {
        return a().a(i, i2);
    }

    public void a(@NotNull GuiGraphics guiGraphics, @NotNull mctech.m.d.b bVar) {
        bVar.b(guiGraphics, bVar.getGuiLeft() + b(), bVar.getGuiTop() + c(), f(), g(), d(), e());
    }

    public void a(@NotNull GuiGraphics guiGraphics, @NotNull mctech.m.d.b bVar, int i) {
        bVar.a(guiGraphics, bVar.getGuiLeft() + b(), bVar.getGuiTop() + c(), f(), g(), d(), e(), i);
    }

    public void b(@NotNull GuiGraphics guiGraphics, @NotNull mctech.m.d.b bVar, int i) {
        a(guiGraphics, bVar.getGuiLeft() + b(), bVar.getGuiTop() + c(), f(), g(), d(), e(), i);
    }

    private void a(GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5, float f6, int i) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        float f7 = f + f5;
        float f8 = f2 + f6;
        float f9 = f3 / 256.0f;
        float f10 = f4 / 256.0f;
        float f11 = (f3 + f5) / 256.0f;
        float f12 = (f4 + f6) / 256.0f;
        int i2 = (i >> 24) & 255;
        int i3 = (i >> 16) & 255;
        int i4 = (i >> 8) & 255;
        int i5 = i & 255;
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
        bufferBuilderBegin.addVertex(matrix4fPose, f, f8, 0.0f).setColor(i3, i4, i5, i2).setUv(f9, f12);
        bufferBuilderBegin.addVertex(matrix4fPose, f7, f8, 0.0f).setColor(i3, i4, i5, i2).setUv(f11, f12);
        bufferBuilderBegin.addVertex(matrix4fPose, f7, f2, 0.0f).setColor(i3, i4, i5, i2).setUv(f11, f10);
        bufferBuilderBegin.addVertex(matrix4fPose, f, f2, 0.0f).setColor(i3, i4, i5, i2).setUv(f9, f10);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }

    public void c(GuiGraphics guiGraphics, mctech.m.d.b bVar, int i) {
        bVar.a(guiGraphics, b(), c(), d(), e(), i);
    }
}
