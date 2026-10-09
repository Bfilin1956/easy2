package mctech.g.c.a.a;

import java.util.Locale;
import java.util.Objects;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.g.b.d;
import mctech.g.d.c.e;
import mctech.init.MCTechLang;
import mctech.v.l;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/a/b.class */
public class b extends d<e> {
    private static final Vector2i a = new Vector2i(208, 156);
    private static final ResourceLocation b = MCTech.loc("textures/conduit/filters/redstone.png");

    public b(e eVar, Inventory inventory, Component component) {
        super(eVar, inventory, component);
    }

    protected void init() {
        super.init();
        int i = this.leftPos + 15;
        int i2 = this.topPos + 27;
        mctech.g.d.c.a aVarB = ((e) getMenu()).b();
        Objects.requireNonNull(aVarB);
        Supplier supplier = aVarB::a;
        e eVar = (e) getMenu();
        Objects.requireNonNull(eVar);
        mctech.g.c.a.c.b bVarAddRenderableWidget = addRenderableWidget(new mctech.g.c.a.c.b(i + 49 + 12, i2, supplier, eVar::a, MCTechLang.GUI_REDSTONE_CHANNEL).a(24, 24));
        int x = bVarAddRenderableWidget.getX() + bVarAddRenderableWidget.getWidth() + 4;
        int y = bVarAddRenderableWidget.getY();
        mctech.g.d.c.a aVarB2 = ((e) getMenu()).b();
        Objects.requireNonNull(aVarB2);
        Supplier supplier2 = aVarB2::b;
        e eVar2 = (e) getMenu();
        Objects.requireNonNull(eVar2);
        addRenderableWidget(new mctech.g.c.a.c.b(x, y, supplier2, eVar2::b, MCTechLang.GUI_REDSTONE_CHANNEL).a(24, 24));
    }

    @Override // mctech.g.b.d
    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        super.renderLabels(guiGraphics, i, i2);
        l.b(guiGraphics, this.font, Component.literal("Редстоун фильтр".toUpperCase(Locale.ROOT)), getGuiLeft(), getGuiTop(), 104, 6, mctech.g.c.a.d.b);
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
