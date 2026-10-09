package mctech.components.b;

import mctech.components.a.Q;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/r.class */
public class r extends Q {
    private final ResourceLocation a;
    private int b;
    private int c;
    private mctech.utils.s d;

    public r(int i, int i2, int i3, int i4, mctech.utils.s sVar, Button.OnPress onPress, ResourceLocation resourceLocation, Vec2i vec2i) {
        super(i, i2, i3, i4, Component.empty(), onPress);
        a("gui.mctech.sort.button");
        this.a = resourceLocation;
        this.d = sVar;
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
            a(guiGraphics, height);
        } else {
            if (this.b != -9999 && this.c != -9999) {
                Minecraft minecraft = Minecraft.getInstance();
                guiGraphics.blitSprite(SPRITES.get(this.active, isHoveredOrFocused()), x, y, width, height);
                guiGraphics.drawCenteredString(minecraft.font, Language.getInstance().getVisualOrder(minecraft.font.ellipsize(getMessage(), this.width)), x + (this.width / 2), y + ((this.height - 8) / 2), getFGColor());
                return;
            }
            a(guiGraphics, -1);
        }
    }

    public void a(GuiGraphics guiGraphics, int i) {
        int x = getX();
        int y = getY();
        int width = getWidth();
        int height = getHeight();
        if (isHoveredOrFocused()) {
            guiGraphics.fill(x, y, x + width, y + 1, i);
            guiGraphics.fill(x, (y + height) - 1, x + width, y + height, i);
            guiGraphics.fill(x, y, x + 1, y + height, i);
            guiGraphics.fill((x + width) - 1, y, x + width, y + height, i);
        }
        int i2 = this.d.a() ? -16744448 : -7862264;
        guiGraphics.fill(x, y - 1, x + width, y, i2);
        guiGraphics.fill(x, y + height, x + width, y + height + 1, i2);
        guiGraphics.fill(x - 1, y - 1, x, y + height + 1, i2);
        guiGraphics.fill(x + width, y - 1, x + width + 1, y + height + 1, i2);
    }
}
