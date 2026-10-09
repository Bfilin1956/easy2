package mctech.components;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.Set;
import java.util.function.Supplier;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

/* JADX INFO: renamed from: mctech.components.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/p.class */
public class C0122p extends mctech.m.d.a.a {
    protected final ResourceLocation a;
    protected final Vec2i b;
    protected final Vec2i c;
    protected Supplier<Boolean> d;

    public C0122p(ResourceLocation resourceLocation, mctech.utils.math.geometry.b bVar, Vec2i vec2i, Vec2i vec2i2, Supplier<Boolean> supplier) {
        super(bVar);
        this.a = resourceLocation;
        this.b = vec2i;
        this.c = vec2i2;
        this.d = supplier;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND_PRE);
    }

    @Override // mctech.m.d.a.a
    public void b(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.d.get().booleanValue()) {
            this.q.c(this.a);
            a(guiGraphics, this.q.getGuiLeft() + this.o.a() + ((this.o.d() - this.b.getX()) / 2.0f), this.q.getGuiTop() + this.o.b() + ((this.o.c() - this.b.getY()) / 2.0f), this.c.getX(), this.c.getY(), this.b.getX(), this.b.getY(), this.b.getX(), this.b.getY());
        }
    }

    @OnlyIn(Dist.CLIENT)
    protected void a(GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        float f9 = f + f5;
        float f10 = f2 + f6;
        float x = f3 / this.b.getX();
        float y = f4 / this.b.getY();
        float x2 = (f3 + f7) / this.b.getX();
        float y2 = (f4 + f8) / this.b.getY();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        bufferBuilderBegin.addVertex(matrix4fPose, f, f10, 0.0f).setUv(x, y2);
        bufferBuilderBegin.addVertex(matrix4fPose, f9, f10, 0.0f).setUv(x2, y2);
        bufferBuilderBegin.addVertex(matrix4fPose, f9, f2, 0.0f).setUv(x2, y);
        bufferBuilderBegin.addVertex(matrix4fPose, f, f2, 0.0f).setUv(x, y);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }
}
