package mctech.utils;

import java.util.function.Consumer;
import mctech.MCTech;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.gui.widget.ExtendedButton;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/i.class */
public class i extends ExtendedButton implements mctech.m.d.b.b {
    public ResourceLocation a;
    private Component b;

    public i(int i, int i2, int i3, int i4, Component component, Button.OnPress onPress, String str, int i5, int i6) {
        super(i, i2, i3, i4, component, onPress);
        this.a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str);
    }

    public i a(Component component) {
        this.b = component;
        return this;
    }

    public void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
        Minecraft minecraft = Minecraft.getInstance();
        guiGraphics.blitSprite(SPRITES.get(this.active, isHoveredOrFocused()), getX(), getY(), 11, 9);
        FormattedText message = getMessage();
        int iWidth = minecraft.font.width(message);
        int iWidth2 = minecraft.font.width("...");
        if (iWidth > this.width - 6 && iWidth > iWidth2) {
            message = Component.literal(minecraft.font.substrByWidth(message, (this.width - 6) - iWidth2).getString() + "...");
        }
        guiGraphics.drawCenteredString(minecraft.font, message, getX() + (this.width / 2) + 1, getY() + ((this.height - 8) / 2) + 1, getFGColor());
    }

    public i a(String str, Object... objArr) {
        return a(Component.translatable(str, objArr));
    }

    @Override // mctech.m.d.b.b
    public void a(mctech.m.d.b bVar, int i, int i2, Consumer<Component> consumer) {
        if (isHoveredOrFocused() && this.b != null) {
            consumer.accept(this.b);
        }
    }
}
