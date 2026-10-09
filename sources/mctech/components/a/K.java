package mctech.components.a;

import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/K.class */
public class K extends Q {
    private final ResourceLocation a;
    private Vec2i b;
    private mctech.utils.math.geometry.b c;
    private boolean d;
    private int e;
    private boolean f;
    private int g;

    public K(int i, int i2, int i3, int i4, ResourceLocation resourceLocation, mctech.utils.math.geometry.b bVar, Button.OnPress onPress) {
        super(i, i2, i3, i4, Component.empty(), onPress);
        this.a = resourceLocation;
        this.c = bVar;
        this.b = new Vec2i(bVar.d(), bVar.c());
        this.d = true;
        this.e = 1;
        this.g = -1;
    }

    public K a(mctech.utils.math.geometry.b bVar) {
        this.c = bVar;
        return this;
    }

    public K a(Vec2i vec2i) {
        this.b = vec2i;
        return this;
    }

    public K a(int i, int i2) {
        return a(new Vec2i(i, i2));
    }

    public K a(int i) {
        this.g = i;
        return this;
    }

    public K a(boolean z) {
        this.d = z;
        return this;
    }

    public K b(boolean z) {
        this.f = z;
        return this;
    }

    public K b(int i) {
        this.e = i;
        return this;
    }

    public void renderWidget(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        if (!this.visible) {
            return;
        }
        a(guiGraphics, getX(), getY(), this.c.a(), this.c.b(), this.width, this.height, this.b.getX(), this.b.getY());
    }

    public void a(GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        guiGraphics.blit(this.a, i, i2, 0, i3, i4, i5, i6, i7, i8);
        if (isHoveredOrFocused() && this.d) {
            if (this.f) {
                int i9 = i - this.e;
                int i10 = i2 - this.e;
                int i11 = i5 + (this.e * 2);
                int i12 = i6 + (this.e * 2);
                guiGraphics.fill(i9, i10, i9 + i11, i10 + 1, this.g);
                guiGraphics.fill((i9 + i11) - 1, i10, i9 + i11, i10 + i12, this.g);
                guiGraphics.fill(i9, (i10 + i12) - 1, i9 + i11, i10 + i12, this.g);
                guiGraphics.fill(i9, i10, i9 + 1, i10 + i12, this.g);
                return;
            }
            guiGraphics.fill(i, i2, i + i5, i2 + 1, this.g);
            guiGraphics.fill((i + i5) - 1, i2, i + i5, i2 + i6, this.g);
            guiGraphics.fill(i, (i2 + i6) - 1, i + i5, i2 + i6, this.g);
            guiGraphics.fill(i, i2, i + 1, i2 + i6, this.g);
        }
    }
}
