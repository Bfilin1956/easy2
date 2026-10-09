package mctech.components.a;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/L.class */
public class L extends Q {
    private ResourceLocation a;
    private int b;
    private int c;

    public L(int i, int i2, int i3, int i4, ResourceLocation resourceLocation, int i5, int i6, Button.OnPress onPress) {
        super(i, i2, i3, i4, Component.empty(), onPress);
        this.a = resourceLocation;
        this.b = i5;
        this.c = i6;
    }

    public void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (isHovered()) {
            guiGraphics.blit(this.a, getX(), getY(), 0, this.b, this.c, getWidth(), getHeight(), mctech.utils.c.h.i, mctech.utils.c.h.i);
        }
    }
}
