package mctech.g.b.b;

import mctech.utils.c.h;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/b/c.class */
public class c extends b {
    private Vec2i a;
    private Vec2i b;
    private final ResourceLocation c;
    private final Runnable d;

    public c(int i, int i2, int i3, int i4, ResourceLocation resourceLocation, @Nullable Component component, Runnable runnable) {
        super(i, i2, i3, i4, Component.empty());
        this.a = new Vec2i(h.i, h.i);
        this.b = Vec2i.EMPTY;
        this.c = resourceLocation;
        this.d = runnable;
        if (component != null) {
            setTooltip(Tooltip.create(component));
        }
    }

    public c a(int i, int i2) {
        this.b = new Vec2i(i, i2);
        return this;
    }

    public c a(Vec2i vec2i) {
        this.a = vec2i;
        return this;
    }

    @Override // mctech.g.b.b.b
    public void b() {
        this.d.run();
    }

    @Override // mctech.g.b.b.b
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.b.isEmpty()) {
            guiGraphics.blit(this.c, getX(), getY(), this.width, this.height, 0.0f, 0.0f, this.width, this.height, this.width, this.height);
        } else {
            guiGraphics.blit(this.c, getX(), getY(), this.width, this.height, this.b.getX(), this.b.getY(), this.width, this.height, this.a.getX(), this.a.getY());
        }
    }

    protected void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
    }
}
