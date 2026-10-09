package mctech.components;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.function.IntConsumer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.gui.ScreenUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/J.class */
@OnlyIn(Dist.CLIENT)
public class J extends AbstractWidget {
    ResourceLocation a;
    private final mctech.utils.math.geometry.b i;
    private final mctech.utils.math.geometry.b j;
    protected int b;
    protected double c;
    protected int d;
    protected int e;
    protected int f;
    protected boolean g;
    protected IntConsumer h;

    public J(mctech.utils.math.geometry.b bVar, mctech.utils.math.geometry.b bVar2) {
        this(bVar, bVar2, 1);
    }

    public J(mctech.utils.math.geometry.b bVar, mctech.utils.math.geometry.b bVar2, int i) {
        super(bVar.a(), bVar.b(), bVar.d(), bVar.c(), Component.empty());
        this.i = bVar;
        this.a = null;
        this.f = 0;
        this.g = false;
        this.h = null;
        this.j = bVar2;
        this.e = Math.max(1, i);
    }

    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {
    }

    public J a(int i) {
        this.f = Math.max(0, i);
        return this;
    }

    public J a(IntConsumer intConsumer) {
        this.h = intConsumer;
        return this;
    }

    public J a(ResourceLocation resourceLocation) {
        this.a = resourceLocation;
        return this;
    }

    public J b(int i) {
        int iMax = Math.max(0, i);
        if (this.d != iMax) {
            this.d = iMax;
            int iA = a();
            int i2 = this.b;
            if (this.b > iA) {
                this.b = iA;
            }
            this.c = iA <= 0 ? 0.0d : ((double) this.b) / ((double) iA);
            if (this.b != i2 && this.h != null) {
                this.h.accept(b());
            }
        }
        return this;
    }

    public J c(int i) {
        int i2 = this.b;
        int iA = a();
        this.b = Mth.clamp(i / this.e, 0, iA);
        if (this.b != i2) {
            this.c = iA <= 0 ? 0.0d : ((double) this.b) / ((double) iA);
        }
        return this;
    }

    public int a() {
        return Math.max(0, (this.d / this.e) - this.f);
    }

    public int b() {
        return this.b * this.e;
    }

    public boolean d(int i) {
        return b() + i < a() + this.f;
    }

    public void renderWidget(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.g) {
            a(this.i, i2);
        }
        if (this.a != null) {
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, this.a);
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, this.alpha);
        }
        ScreenUtils.drawTexturedModalRect(guiGraphics, getX(), getY() + ((int) (((double) (this.i.c() - this.j.c())) * this.c)), this.j.a(), this.j.b(), this.j.d(), this.j.c(), 0.0f);
    }

    public boolean mouseClicked(double d, double d2, int i) {
        a(this.i, (int) d2);
        this.g = true;
        return false;
    }

    public boolean mouseReleased(double d, double d2, int i) {
        this.g = false;
        return false;
    }

    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        int i = this.b;
        int iA = a();
        this.c = iA <= 0 ? 0.0d : Mth.clamp(this.c - (d4 * (1.0d / ((double) iA))), 0.0d, 1.0d);
        this.b = iA <= 0 ? 0 : (int) Mth.clamp(((double) iA) * this.c, 0.0d, iA);
        if (this.b != i && this.h != null) {
            this.h.accept(b());
            return true;
        }
        return true;
    }

    protected void a(@NotNull mctech.utils.math.geometry.b bVar, int i) {
        int i2 = this.b;
        int iA = a();
        this.c = Mth.clamp((((double) i) - (((double) bVar.b()) + (((double) this.j.c()) * 0.5d))) / ((double) (bVar.c() - this.j.c())), 0.0d, 1.0d);
        this.b = (int) Mth.clamp(((double) iA) * this.c, 0.0d, iA);
        if (iA <= 0) {
            this.c = 0.0d;
        }
        if (this.b != i2 && this.h != null) {
            this.h.accept(b());
        }
    }
}
