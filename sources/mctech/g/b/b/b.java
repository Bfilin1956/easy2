package mctech.g.b.b;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/b/b.class */
public abstract class b extends AbstractWidget {
    public abstract void b();

    public abstract void a(GuiGraphics guiGraphics, int i, int i2, float f);

    public b(int i, int i2, int i3, int i4, Component component) {
        super(i, i2, i3, i4, component);
    }

    protected void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
        guiGraphics.setColor(1.0f, 1.0f, 1.0f, this.alpha);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        guiGraphics.fill(getX(), getY(), getX() + getWidth(), getY() + getHeight(), -14145496);
        guiGraphics.fill(getX(), getY(), getX() + getWidth(), getY() + 2, -13027015);
        guiGraphics.fill(getX() + 1, getY() + 1, (getX() + getWidth()) - 1, (getY() + getHeight()) - 1, -15000805);
        guiGraphics.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        a(guiGraphics, i, i2, f);
        a(guiGraphics, i, i2);
    }

    protected void a(GuiGraphics guiGraphics, int i, int i2) {
        if (isMouseOver(i, i2)) {
            guiGraphics.pose().pushPose();
            guiGraphics.pose().translate(0.0f, 0.0f, 399.0f);
            guiGraphics.fill(getX() - 1, getY() - 1, getX() + getWidth() + 1, getY(), -1);
            guiGraphics.fill(getX() - 1, getY() + getHeight(), getX() + getWidth() + 1, getY() + getHeight() + 1, -1);
            guiGraphics.fill(getX() - 1, getY() - 1, getX(), getY() + getHeight() + 1, -1);
            guiGraphics.fill(getX() + getWidth(), getY() - 1, getX() + getWidth() + 1, getY() + getHeight() + 1, -1);
            guiGraphics.pose().popPose();
        }
    }

    public void onClick(double d, double d2) {
        b();
    }
}
