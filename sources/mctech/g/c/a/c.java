package mctech.g.c.a;

import com.mojang.datafixers.util.Pair;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.init.MCTechLang;
import mctech.utils.c.h;
import mctech.utils.math.geometry.Vec2i;
import mctech.v.l;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/c.class */
public class c extends mctech.g.b.a<mctech.g.d.a.b.b.a.c> {
    private static final ResourceLocation c = MCTech.loc("textures/conduit/filters/filter_2x9.png");
    private final ResourceLocation d;
    protected Function<Boolean, Component> b;

    public c(mctech.g.d.a.b.b.a.c cVar, Inventory inventory, Component component) {
        super(cVar, inventory, component);
        this.b = bool -> {
            return a(new Pair<>("да", ChatFormatting.DARK_GREEN), new Pair<>("нет", ChatFormatting.DARK_RED), bool.booleanValue());
        };
        this.imageWidth = 208;
        this.imageHeight = 181;
        this.d = c;
    }

    protected void init() {
        super.init();
        int guiLeft = getGuiLeft();
        int guiTop = getGuiTop() + 27 + 36;
        mctech.g.d.a.b.b.a.c cVar = (mctech.g.d.a.b.b.a.c) getMenu();
        Objects.requireNonNull(cVar);
        Supplier supplier = cVar::h;
        mctech.g.d.a.b.b.a.c cVar2 = (mctech.g.d.a.b.b.a.c) getMenu();
        Objects.requireNonNull(cVar2);
        addRenderableWidget(new mctech.g.c.a.c.a(guiLeft + 29, guiTop + 4, supplier, cVar2::a, MCTechLang.DAMAGE_FILTER));
        ResourceLocation resourceLocation = this.d;
        mctech.g.d.a.b.b.a.c cVar3 = (mctech.g.d.a.b.b.a.c) getMenu();
        Objects.requireNonNull(cVar3);
        addRenderableWidget(mctech.g.b.b.d.a(guiLeft + 159, guiTop + 14, 26, 7, resourceLocation, cVar3::g, bool -> {
            a(2);
        }).a(bool2 -> {
            return new Vec2i(53, bool2.booleanValue() ? 221 : d.d);
        }).b(bool3 -> {
            return Component.literal("Сравнивает NBT: ").append(this.b.apply(bool3));
        }));
    }

    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int i2) {
        guiGraphics.blit(this.d, getGuiLeft(), getGuiTop(), 0, 0, this.imageWidth, this.imageHeight);
        int guiLeft = getGuiLeft();
        int guiTop = getGuiTop() + 27 + 36;
        guiGraphics.blit(this.d, guiLeft + 159, guiTop + 10, 42, 11, 182.0f, 244.0f, 42, 11, h.i, h.i);
        guiGraphics.blit(this.d, guiLeft + 22, guiTop + 4, 30, 22, 225.0f, 233.0f, 30, 22, h.i, h.i);
    }

    @Override // mctech.g.b.a
    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        super.renderLabels(guiGraphics, i, i2);
        l.a(guiGraphics, this.font, (Component) Component.literal("Сравнение NBT:"), getGuiLeft(), getGuiTop(), 0 + 157, 63 + 13, d.b);
        l.a(guiGraphics, this.font, Component.literal(getTitle().copy().getString().toUpperCase(Locale.ROOT)), getGuiLeft(), getGuiTop(), 26, 6, 156, d.b);
    }

    @Override // mctech.g.b.a
    public boolean a(int i, int i2, int i3) {
        if (this.minecraft != null && i == 256 && this.minecraft.player != null) {
            a(0);
            return true;
        }
        return super.a(i, i2, i3);
    }

    @Override // mctech.g.b.a
    protected boolean b() {
        return true;
    }

    protected Component a(Pair<String, ChatFormatting> pair, Pair<String, ChatFormatting> pair2, boolean z) {
        return z ? Component.literal((String) pair.getFirst()).withStyle((ChatFormatting) pair.getSecond()) : Component.literal((String) pair2.getFirst()).withStyle((ChatFormatting) pair2.getSecond());
    }
}
