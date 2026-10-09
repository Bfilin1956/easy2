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

/* JADX INFO: renamed from: mctech.components.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/d.class */
public class C0110d extends mctech.m.d.a.a {
    protected ResourceLocation a;
    protected Supplier<ResourceLocation> b;
    protected final Vec2i c;
    protected final Vec2i d;
    protected Supplier<Boolean> e;
    protected boolean f;

    public C0110d(ResourceLocation resourceLocation, mctech.utils.math.geometry.b bVar, Vec2i vec2i, Vec2i vec2i2) {
        this(resourceLocation, bVar, vec2i, vec2i2, null);
    }

    public C0110d(ResourceLocation resourceLocation, mctech.utils.math.geometry.b bVar, Vec2i vec2i, Vec2i vec2i2, Supplier<Boolean> supplier) {
        super(bVar);
        this.a = resourceLocation;
        this.c = vec2i;
        this.d = vec2i2;
        this.e = supplier;
        this.f = true;
    }

    public C0110d a(Supplier<ResourceLocation> supplier) {
        this.b = supplier;
        return this;
    }

    public C0110d a(ResourceLocation resourceLocation) {
        this.a = resourceLocation;
        return this;
    }

    public C0110d a(boolean z) {
        this.f = z;
        return this;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.e != null && !this.e.get().booleanValue()) {
            return;
        }
        this.q.c(this.b != null ? this.b.get() : this.a);
        if (this.f) {
            a(guiGraphics, this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b(), this.d.getX(), this.d.getY(), this.o.d(), this.o.c(), this.c.getX(), this.c.getY());
        } else {
            this.q.a(guiGraphics, this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b(), this.d.getX(), this.d.getY(), this.o.d(), this.o.c(), this.c.getX(), this.c.getY());
        }
        this.q.c();
    }

    @OnlyIn(Dist.CLIENT)
    protected void a(GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        float f9 = f + f5;
        float f10 = f2 + f6;
        float x = f3 / this.c.getX();
        float y = f4 / this.c.getY();
        float x2 = (f3 + f7) / this.c.getX();
        float y2 = (f4 + f8) / this.c.getY();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        bufferBuilderBegin.addVertex(matrix4fPose, f, f10, 0.0f).setUv(x, y2);
        bufferBuilderBegin.addVertex(matrix4fPose, f9, f10, 0.0f).setUv(x2, y2);
        bufferBuilderBegin.addVertex(matrix4fPose, f9, f2, 0.0f).setUv(x2, y);
        bufferBuilderBegin.addVertex(matrix4fPose, f, f2, 0.0f).setUv(x, y);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
    }
}
