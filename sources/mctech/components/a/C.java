package mctech.components.a;

import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/C.class */
public class C extends Q {
    private final ResourceLocation a;
    private int b;
    private int c;

    public C(int i, int i2, int i3, int i4, Component component, Button.OnPress onPress) {
        this(i, i2, i3, i4, component, onPress, null, Vec2i.ZERO);
    }

    public C(int i, int i2, int i3, int i4, Component component, Button.OnPress onPress, ResourceLocation resourceLocation, Vec2i vec2i) {
        super(i, i2, i3, i4, component, onPress);
        this.a = resourceLocation;
        this.b = vec2i.getX();
        this.c = vec2i.getY();
    }

    public void onPress() {
        super.onPress();
        setFocused(false);
    }

    public void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
        int x = getX();
        int y = getY();
        int width = getWidth();
        int height = getHeight();
        if (this.a != null) {
            guiGraphics.blit(this.a, x, y, 0, this.b, this.c, width, height, mctech.utils.c.h.i, mctech.utils.c.h.i);
            a(guiGraphics);
        } else {
            if (this.b != -9999 && this.c != -9999) {
                Minecraft minecraft = Minecraft.getInstance();
                guiGraphics.blitSprite(SPRITES.get(this.active, isHoveredOrFocused()), x, y, width, height);
                guiGraphics.drawCenteredString(minecraft.font, Language.getInstance().getVisualOrder(minecraft.font.ellipsize(getMessage(), this.width)), x + (this.width / 2), y + ((this.height - 8) / 2), getFGColor());
                return;
            }
            a(guiGraphics);
        }
    }

    public void a(GuiGraphics guiGraphics) {
        if (isHoveredOrFocused()) {
            int x = getX();
            int y = getY();
            int width = getWidth();
            int height = getHeight();
            guiGraphics.fill(x, y, x + width, y + 1, -1);
            guiGraphics.fill(x, (y + height) - 1, x + width, y + height, -1);
            guiGraphics.fill(x, y, x + 1, y + height, -1);
            guiGraphics.fill((x + width) - 1, y, x + width, y + height, -1);
        }
    }
}
