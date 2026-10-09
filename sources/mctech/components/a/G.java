package mctech.components.a;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.neoforged.neoforge.client.gui.widget.ExtendedSlider;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/G.class */
public class G extends ExtendedSlider implements mctech.m.d.b.b {
    private double d;
    boolean a;
    Component b;
    Consumer<G> c;

    public G(int i, int i2, int i3, int i4, Component component, Component component2, double d, double d2, double d3, boolean z, Consumer<G> consumer) {
        super(i, i2, i3, i4, component, component2, d, d2, d3, z);
        this.d = 0.0d;
        this.a = false;
        this.c = consumer;
    }

    public G(int i, int i2, int i3, int i4, Component component, Component component2, double d, double d2, double d3, Consumer<G> consumer) {
        super(i, i2, i3, i4, component, component2, d, d2, d3, true);
        this.d = 0.0d;
        this.a = false;
        this.c = consumer;
    }

    public G a(double d) {
        this.d = d / (this.maxValue - this.minValue);
        return this;
    }

    public G a(Component component) {
        this.b = component;
        return this;
    }

    public G a(String str, Object... objArr) {
        return a((Component) Component.translatable(str, objArr));
    }

    public G a(String str) {
        return a((Component) Component.translatable(str));
    }

    @Override // mctech.m.d.b.b
    public void a(mctech.m.d.b bVar, int i, int i2, Consumer<Component> consumer) {
        if (isHoveredOrFocused() && this.b != null) {
            consumer.accept(this.b);
        }
    }

    public boolean isMouseOver(double d, double d2) {
        return this.a || super.isMouseOver(d, d2);
    }

    public void onClick(double d, double d2) {
        super.onClick(d, d2);
        this.a = true;
    }

    public void onRelease(double d, double d2) {
        super.onRelease(d, d2);
        this.a = false;
    }

    public boolean a(double d, double d2, double d3) {
        if (this.d != 0.0d && this.active && this.visible) {
            this.value += this.d * d3 * ((double) (Screen.hasShiftDown() ? 10 : 1)) * ((double) (Screen.hasControlDown() ? 100 : 1));
            applyValue();
        }
        return this.d != 0.0d;
    }

    public void setValue(double d) {
        super.setValue(d);
        a(false);
    }

    protected void a(GuiGraphics guiGraphics, Minecraft minecraft, int i, int i2) {
        RenderSystem.setShaderTexture(0, getSprite());
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        guiGraphics.blitSprite(getSprite(), getX() + ((int) (this.value * ((double) (this.width - 8)))), getY(), 0, 46 + ((isHoveredOrFocused() ? 2 : 1) * 20), 8, this.height, 200, 20);
        if (this.a) {
            b(i);
        }
    }

    private void b(double d) {
        c((d - ((double) (getX() + 4))) / ((double) (this.width - 8)));
    }

    private void c(double d) {
        double d2 = this.value;
        this.value = d(d);
        if (!Mth.equal(d2, this.value)) {
            applyValue();
        }
        updateMessage();
    }

    public void applyValue() {
        a(true);
    }

    public void a(boolean z) {
        this.value = Mth.clamp(this.value, 0.0d, 1.0d);
        updateMessage();
        if (this.c != null && z) {
            this.c.accept(this);
        }
    }

    private double d(double d) {
        double dClamp;
        if (this.stepSize <= 0.0d) {
            return Mth.clamp(d, 0.0d, 1.0d);
        }
        double dRound = this.stepSize * Math.round(Mth.lerp(Mth.clamp(d, 0.0d, 1.0d), this.minValue, this.maxValue) / this.stepSize);
        if (this.minValue > this.maxValue) {
            dClamp = Mth.clamp(dRound, this.maxValue, this.minValue);
        } else {
            dClamp = Mth.clamp(dRound, this.minValue, this.maxValue);
        }
        return Mth.map(dClamp, this.minValue, this.maxValue, 0.0d, 1.0d);
    }
}
