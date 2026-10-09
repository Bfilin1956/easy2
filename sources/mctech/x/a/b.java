package mctech.x.a;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.shaders.Uniform;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.minecraft.util.FastColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/a/b.class */
@OnlyIn(Dist.CLIENT)
public class b extends ShaderInstance {
    public final Uniform a;
    public final int b;
    private final Vector4f c;
    private ResourceLocation d;

    public b(ResourceProvider resourceProvider, ResourceLocation resourceLocation, VertexFormat vertexFormat) throws IOException {
        super(resourceProvider, resourceLocation, vertexFormat);
        this.c = new Vector4f(1.0f);
        this.a = getUniform("TransMat");
        this.b = Uniform.glGetUniformLocation(getId(), "Sampler0");
    }

    public void apply() {
        super.apply();
        this.d = null;
        if (this.b != -1) {
            RenderSystem.assertOnRenderThread();
            Uniform.uploadInteger(this.b, 0);
            if (GlStateManager._getActiveTexture() != 33984) {
                GlStateManager._activeTexture(33984);
            }
        }
    }

    public void a(@NotNull ResourceLocation resourceLocation) {
        if (resourceLocation.equals(this.d)) {
            return;
        }
        RenderSystem.assertOnRenderThread();
        RenderSystem.setShaderTexture(0, Minecraft.getInstance().getTextureManager().getTexture(resourceLocation).getId());
        RenderSystem.bindTexture(RenderSystem.getShaderTexture(0));
        this.d = resourceLocation;
    }

    public void a(int i) {
        float fAlpha = FastColor.ARGB32.alpha(i) / 255.0f;
        float fRed = FastColor.ARGB32.red(i) / 255.0f;
        float fGreen = FastColor.ARGB32.green(i) / 255.0f;
        float fBlue = FastColor.ARGB32.blue(i) / 255.0f;
        if (this.c.x != fAlpha || this.c.y != fRed || this.c.z != fGreen || this.c.w != fBlue) {
            this.c.set(fAlpha, fRed, fGreen, fBlue);
            if (this.COLOR_MODULATOR != null) {
                this.COLOR_MODULATOR.set(this.c.y, this.c.z, this.c.w, this.c.x);
                this.COLOR_MODULATOR.upload();
            }
        }
    }
}
