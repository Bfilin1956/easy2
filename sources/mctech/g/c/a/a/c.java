package mctech.g.c.a.a;

import java.util.Locale;
import mctech.MCTech;
import mctech.g.b.d;
import mctech.g.d.c.n;
import mctech.v.l;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/a/c.class */
public class c extends d<n> {
    private static final Vector2i a = new Vector2i(208, 156);
    private static final ResourceLocation b = MCTech.loc("textures/conduit/filters/redstone.png");

    public c(n nVar, Inventory inventory, Component component) {
        super(nVar, inventory, component);
    }

    protected void init() {
        super.init();
        int i = this.leftPos + 15;
        EditBox editBox = new EditBox(this, this.font, i + 62, this.topPos + 27, 55, 18, Component.literal(((n) getMenu()).a().a())) { // from class: mctech.g.c.a.a.c.1
            public boolean charTyped(char c, int i2) {
                return Character.isDigit(c) && super.charTyped(c, i2);
            }
        };
        editBox.setValue(((n) getMenu()).a().a());
        addRenderableWidget(editBox);
        addRenderableWidget(new mctech.g.b.b.c(editBox.getX() + 1, editBox.getY() + editBox.getHeight() + 1, 53, 9, b, null, () -> {
            ((n) getMenu()).a(editBox.getValue());
        }).a(121, 247));
    }

    @Override // mctech.g.b.d
    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        super.renderLabels(guiGraphics, i, i2);
        l.b(guiGraphics, this.font, Component.literal("Редстоун таймер".toUpperCase(Locale.ROOT)), getGuiLeft(), getGuiTop(), 104, 6, mctech.g.c.a.d.b);
    }

    @Override // mctech.g.b.d
    public ResourceLocation a() {
        return b;
    }

    @Override // mctech.g.b.d
    protected Vector2i b() {
        return a;
    }
}
