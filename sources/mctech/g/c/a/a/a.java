package mctech.g.c.a.a;

import java.util.Locale;
import java.util.Objects;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.g.b.d;
import mctech.init.MCTechLang;
import mctech.v.l;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/a/a.class */
public class a extends d<mctech.g.d.c.d> {
    private static final Vector2i a = new Vector2i(208, 156);
    private static final ResourceLocation b = MCTech.loc("textures/conduit/filters/redstone.png");

    public a(mctech.g.d.c.d dVar, Inventory inventory, Component component) {
        super(dVar, inventory, component);
    }

    protected void init() {
        super.init();
        int i = this.leftPos + 15;
        int i2 = this.topPos + 27;
        mctech.g.d.c.c cVarA = ((mctech.g.d.c.d) getMenu()).a();
        Objects.requireNonNull(cVarA);
        Supplier supplier = cVarA::a;
        mctech.g.d.c.d dVar = (mctech.g.d.c.d) getMenu();
        Objects.requireNonNull(dVar);
        mctech.g.c.a.c.b bVarAddRenderableWidget = addRenderableWidget(new mctech.g.c.a.c.b(i + 49, i2, supplier, dVar::a, MCTechLang.GUI_REDSTONE_CHANNEL).a(24, 24));
        EditBox editBox = new EditBox(this, this.font, bVarAddRenderableWidget.getX() + bVarAddRenderableWidget.getWidth() + 4, bVarAddRenderableWidget.getY(), 55, 18, Component.literal(((mctech.g.d.c.d) getMenu()).a().b())) { // from class: mctech.g.c.a.a.a.1
            public boolean charTyped(char c, int i3) {
                return Character.isDigit(c) && super.charTyped(c, i3);
            }
        };
        editBox.setValue(((mctech.g.d.c.d) getMenu()).a().b());
        addRenderableWidget(editBox);
        addRenderableWidget(new mctech.g.b.b.c(editBox.getX() + 1, editBox.getY() + editBox.getHeight() + 1, 53, 9, b, null, () -> {
            ((mctech.g.d.c.d) getMenu()).a(editBox.getValue());
        }).a(121, 247));
    }

    @Override // mctech.g.b.d
    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        super.renderLabels(guiGraphics, i, i2);
        l.b(guiGraphics, this.font, Component.literal("Редстоун счетчик".toUpperCase(Locale.ROOT)), getGuiLeft(), getGuiTop(), 104, 6, mctech.g.c.a.d.b);
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
