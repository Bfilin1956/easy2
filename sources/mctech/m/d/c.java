package mctech.m.d;

import mctech.MCTech;
import mctech.components.a.G;
import mctech.config.ConfigEntry;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.client.gui.widget.ExtendedButton;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/d/c.class */
public class c extends Screen implements mctech.utils.e.b {
    Screen a;

    public c(Screen screen) {
        super(Component.literal("MCTech Sound Options"));
        this.a = screen;
    }

    protected void init() {
        int i = this.width / 2;
        int i2 = this.height / 2;
        addRenderableWidget(new G(i - 155, i2 - 80, 310, 20, f("gui.mctech.audio.master"), e("%"), 0.0d, 100.0d, MCTech.CONFIG.masterVolume.get() * 100.0d, g -> {
            a(MCTech.CONFIG.masterVolume, g.getValueInt());
        })).a(1.0d);
        addRenderableWidget(new G(i - 155, i2 - 55, 150, 20, f("gui.mctech.audio.block"), e("%"), 0.0d, 100.0d, MCTech.CONFIG.blockVolume.get() * 100.0d, g2 -> {
            a(MCTech.CONFIG.blockVolume, g2.getValueInt());
        })).a(1.0d);
        addRenderableWidget(new G(i + 5, i2 - 55, 150, 20, f("gui.mctech.audio.item"), e("%"), 0.0d, 100.0d, MCTech.CONFIG.itemVolume.get() * 100.0d, g3 -> {
            a(MCTech.CONFIG.itemVolume, g3.getValueInt());
        })).a(1.0d);
        addRenderableWidget(new G(i - 155, i2 - 30, 150, 20, f("gui.mctech.audio.back"), e("%"), 0.0d, 100.0d, MCTech.CONFIG.backVolume.get() * 100.0d, g4 -> {
            a(MCTech.CONFIG.backVolume, g4.getValueInt());
        })).a(1.0d);
        addRenderableWidget(new ExtendedButton(i + 5, i2 - 30, 150, 20, f("gui.mctech.audio.clear"), button -> {
            a();
        }));
        addRenderableWidget(new ExtendedButton(i - 100, i2, 200, 20, CommonComponents.GUI_DONE, button2 -> {
            this.minecraft.setScreen(this.a);
        }));
    }

    public void a() {
    }

    public void a(ConfigEntry.DoubleValue doubleValue, double d) {
        doubleValue.set(Double.valueOf(d * 0.01d));
        MCTech.CONFIG.save();
    }

    public void render(GuiGraphics guiGraphics, int i, int i2, float f) {
        renderBackground(guiGraphics, i, i2, f);
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 15, 16777215);
        super.render(guiGraphics, i, i2, f);
    }
}
