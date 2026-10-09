package mctech.x.b;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.shaders.Uniform;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import mctech.MCTech;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/b/a.class */
public class a implements AutoCloseable {
    private static final ResourceLocation b;
    private static final int c = 1;
    private final RenderTarget[] d;
    private final RenderTarget[] e;
    private final int f;
    static final /* synthetic */ boolean a;

    static {
        a = !a.class.desiredAssertionStatus();
        b = MCTech.loc("textures/noise/noise_128x128.png");
    }

    public a(int i) {
        this.d = new RenderTarget[i];
        this.e = new RenderTarget[i - 1];
        this.f = i;
        Window window = Minecraft.getInstance().getWindow();
        a(window.getWidth(), window.getHeight(), true);
    }

    public void a(int i, int i2) {
        a(i, i2, false);
    }

    public void a(int i, int i2, boolean z) {
        int iMax = Math.max(1, i >> 1);
        int iMax2 = Math.max(1, i2 >> 1);
        for (int i3 = 0; i3 < this.f; i3++) {
            if (this.d[i3] == null) {
                this.d[i3] = new TextureTarget(iMax, iMax2, false, Minecraft.ON_OSX);
            }
            this.d[i3].resize(iMax, iMax2, true);
            this.d[i3].setFilterMode(9729);
            if (z) {
                this.d[i3].setClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            }
            if (i3 < this.f - 1) {
                if (this.e[i3] == null) {
                    this.e[i3] = new TextureTarget(iMax, iMax2, false, Minecraft.ON_OSX);
                }
                this.e[i3].resize(iMax, iMax2, true);
                this.e[i3].setFilterMode(9729);
                if (z) {
                    this.e[i3].setClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                }
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        for (RenderTarget renderTarget : this.d) {
            renderTarget.destroyBuffers();
        }
        for (RenderTarget renderTarget2 : this.e) {
            renderTarget2.destroyBuffers();
        }
    }

    public void a(RenderTarget renderTarget, float f) {
        Minecraft minecraft = Minecraft.getInstance();
        RenderTarget mainRenderTarget = minecraft.getMainRenderTarget();
        AbstractTexture texture = minecraft.getTextureManager().getTexture(b);
        a(renderTarget, texture);
        a(texture);
        mainRenderTarget.bindWrite(true);
        RenderSystem.disableBlend();
        ShaderInstance shaderInstanceC = mctech.x.b.d.c();
        shaderInstanceC.setSampler("DiffuseSampler", this.e[0]);
        shaderInstanceC.setSampler("ScreenSampler", mainRenderTarget);
        shaderInstanceC.setSampler("BaseSampler", renderTarget);
        shaderInstanceC.apply();
        shaderInstanceC.safeGetUniform("BloomIntensity").set(f);
        BufferBuilder bufferBuilderBegin = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.BLIT_SCREEN);
        bufferBuilderBegin.addVertex(0.0f, 0.0f, 0.0f);
        bufferBuilderBegin.addVertex(1.0f, 0.0f, 0.0f);
        bufferBuilderBegin.addVertex(1.0f, 1.0f, 0.0f);
        bufferBuilderBegin.addVertex(0.0f, 1.0f, 0.0f);
        BufferUploader.draw(bufferBuilderBegin.buildOrThrow());
        shaderInstanceC.clear();
    }

    private void a(RenderTarget renderTarget, AbstractTexture abstractTexture) {
        ShaderInstance shaderInstanceC = mctech.x.b.b.c();
        this.d[0].bindWrite(true);
        shaderInstanceC.apply();
        int iGlGetUniformLocation = Uniform.glGetUniformLocation(shaderInstanceC.getId(), "CurrentSampler");
        int iGlGetUniformLocation2 = Uniform.glGetUniformLocation(shaderInstanceC.getId(), "NoiseSampler");
        GlStateManager._activeTexture(33985);
        abstractTexture.bind();
        Uniform uniform = shaderInstanceC.getUniform("Resolution");
        Uniform uniform2 = shaderInstanceC.getUniform("FrameIndex");
        if (!a && uniform == null) {
            throw new AssertionError();
        }
        if (!a && uniform2 == null) {
            throw new AssertionError();
        }
        Uniform.uploadInteger(iGlGetUniformLocation, 0);
        Uniform.uploadInteger(iGlGetUniformLocation2, 1);
        uniform.set(1.0f / renderTarget.width, 1.0f / renderTarget.height);
        uniform.upload();
        uniform2.set(0);
        uniform2.upload();
        this.d[0].clear(false);
        a(renderTarget, this.d[0], uniform);
        for (int i = 1; i < this.f; i++) {
            RenderTarget renderTarget2 = this.d[i - 1];
            RenderTarget renderTarget3 = this.d[i];
            renderTarget3.clear(false);
            renderTarget2.bindRead();
            GlStateManager._activeTexture(33984);
            renderTarget2.bindRead();
            uniform2.set(i);
            uniform2.upload();
            a(renderTarget2, renderTarget3, uniform);
        }
        shaderInstanceC.clear();
    }

    private void a(AbstractTexture abstractTexture) {
        ShaderInstance shaderInstanceC = mctech.x.b.c.c();
        shaderInstanceC.apply();
        int iGlGetUniformLocation = Uniform.glGetUniformLocation(shaderInstanceC.getId(), "CurrentSampler");
        int iGlGetUniformLocation2 = Uniform.glGetUniformLocation(shaderInstanceC.getId(), "PreviousSampler");
        int iGlGetUniformLocation3 = Uniform.glGetUniformLocation(shaderInstanceC.getId(), "NoiseSampler");
        GlStateManager._activeTexture(33986);
        abstractTexture.bind();
        Uniform.uploadInteger(iGlGetUniformLocation, 0);
        Uniform.uploadInteger(iGlGetUniformLocation2, 1);
        Uniform.uploadInteger(iGlGetUniformLocation3, 2);
        Uniform uniform = shaderInstanceC.getUniform("Resolution");
        Uniform uniform2 = shaderInstanceC.getUniform("FrameIndex");
        if (!a && uniform == null) {
            throw new AssertionError();
        }
        if (!a && uniform2 == null) {
            throw new AssertionError();
        }
        GlStateManager._activeTexture(33985);
        this.d[this.f - 1].bindRead();
        uniform2.set(this.f - 1);
        uniform2.upload();
        this.e[this.f - 2].clear(false);
        a(this.d[this.f - 2], this.e[this.f - 2], uniform);
        for (int i = this.f - 2; i > 0; i--) {
            GlStateManager._activeTexture(33985);
            this.e[i].bindRead();
            RenderTarget renderTarget = this.d[i - 1];
            RenderTarget renderTarget2 = this.e[i - 1];
            renderTarget2.clear(false);
            uniform2.set(i);
            uniform2.upload();
            a(renderTarget, renderTarget2, uniform);
        }
    }

    private static void a(RenderTarget renderTarget, RenderTarget renderTarget2, Uniform uniform) {
        GlStateManager._activeTexture(33984);
        renderTarget.bindRead();
        renderTarget2.bindWrite(true);
        uniform.set(1.0f / renderTarget.width, 1.0f / renderTarget.height);
        uniform.upload();
        BufferBuilder bufferBuilderBegin = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.BLIT_SCREEN);
        bufferBuilderBegin.addVertex(0.0f, 0.0f, 0.0f);
        bufferBuilderBegin.addVertex(1.0f, 0.0f, 0.0f);
        bufferBuilderBegin.addVertex(1.0f, 1.0f, 0.0f);
        bufferBuilderBegin.addVertex(0.0f, 1.0f, 0.0f);
        BufferUploader.draw(bufferBuilderBegin.buildOrThrow());
    }
}
