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
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import org.apache.commons.lang3.NotImplementedException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/b.class */
public class b extends mctech.g.b.a<mctech.g.d.a.b.b.c> {
    private static final ResourceLocation f = MCTech.loc("textures/conduit/filters/filter_1x9.png");
    private static final ResourceLocation g = MCTech.loc("textures/conduit/filters/filter_2x9.png");
    private static final ResourceLocation h = MCTech.loc("textures/conduit/filters/filter_3x9.png");
    private static final ResourceLocation i = MCTech.loc("textures/conduit/filters/filter_4x9.png");
    private final ResourceLocation j;
    protected Function<Boolean, Component> b;
    protected Function<Boolean, Component> c;
    protected boolean d;
    protected boolean e;

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.commons.lang3.NotImplementedException */
    public b(mctech.g.d.a.b.b.c cVar, Inventory inventory, Component component) throws NotImplementedException {
        super(cVar, inventory, component);
        this.b = bool -> {
            return a(new Pair<>("да", ChatFormatting.DARK_GREEN), new Pair<>("нет", ChatFormatting.DARK_RED), bool.booleanValue());
        };
        this.c = bool2 -> {
            return a(new Pair<>("черный", ChatFormatting.DARK_GRAY), new Pair<>("белый", ChatFormatting.WHITE), bool2.booleanValue());
        };
        this.imageWidth = 208;
        this.d = ((mctech.g.d.a.b.b.c) getMenu()).e.c();
        this.e = ((mctech.g.d.a.b.b.c) getMenu()).e.d();
        switch (cVar.e.a()) {
            case 1:
                this.j = f;
                this.imageHeight = 163;
                return;
            case 2:
                this.j = g;
                this.imageHeight = 181;
                return;
            case 3:
                this.j = h;
                this.imageHeight = 199;
                return;
            case 4:
                this.j = i;
                this.imageHeight = 217;
                return;
            default:
                throw new NotImplementedException();
        }
    }

    protected void init() {
        super.init();
        int guiLeft = getGuiLeft();
        int guiTop = getGuiTop() + 27 + (((mctech.g.d.a.b.b.c) this.menu).e.a() * 18);
        if (this.e) {
            mctech.g.d.a.b.b.c cVar = (mctech.g.d.a.b.b.c) getMenu();
            Objects.requireNonNull(cVar);
            Supplier supplier = cVar::i;
            mctech.g.d.a.b.b.c cVar2 = (mctech.g.d.a.b.b.c) getMenu();
            Objects.requireNonNull(cVar2);
            addRenderableWidget(new mctech.g.c.a.c.a(guiLeft + 29, guiTop + 4, supplier, cVar2::a, MCTechLang.DAMAGE_FILTER));
        }
        if (this.d) {
            ResourceLocation resourceLocation = this.j;
            mctech.g.d.a.b.b.c cVar3 = (mctech.g.d.a.b.b.c) getMenu();
            Objects.requireNonNull(cVar3);
            addRenderableWidget(mctech.g.b.b.d.a(guiLeft + 159, guiTop + 2, 26, 7, resourceLocation, cVar3::h, bool -> {
                a(2);
            }).a(bool2 -> {
                return new Vec2i(53, bool2.booleanValue() ? 221 : d.d);
            }).b(bool3 -> {
                return Component.literal("Сравнивает NBT: ").append(this.b.apply(bool3));
            }));
        }
        ResourceLocation resourceLocation2 = this.j;
        mctech.g.d.a.b.b.c cVar4 = (mctech.g.d.a.b.b.c) getMenu();
        Objects.requireNonNull(cVar4);
        addRenderableWidget(mctech.g.b.b.d.a(guiLeft + 159, guiTop + 14, 26, 7, resourceLocation2, cVar4::g, bool4 -> {
            a(1);
        }).a(bool5 -> {
            return new Vec2i(53, bool5.booleanValue() ? 221 : d.d);
        }).b(bool6 -> {
            return Component.literal("Список: ").append(this.c.apply(bool6));
        }));
    }

    protected void renderBg(GuiGraphics guiGraphics, float f2, int i2, int i3) {
        guiGraphics.blit(this.j, getGuiLeft(), getGuiTop(), 0, 0, this.imageWidth, this.imageHeight);
        int guiLeft = getGuiLeft();
        int guiTop = getGuiTop() + 27 + (((mctech.g.d.a.b.b.c) this.menu).e.a() * 18);
        if (this.d) {
            guiGraphics.blit(this.j, guiLeft + 159, guiTop + 2, 41, 12, 182.0f, 231.0f, 41, 12, h.i, h.i);
        }
        if (this.e) {
            guiGraphics.blit(this.j, guiLeft + 22, guiTop + 4, 30, 22, 225.0f, 233.0f, 30, 22, h.i, h.i);
        }
        guiGraphics.blit(this.j, guiLeft + 159, guiTop + 10, 42, 11, 182.0f, 244.0f, 42, 11, h.i, h.i);
    }

    @Override // mctech.g.b.a
    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int i2, int i3) {
        super.renderLabels(guiGraphics, i2, i3);
        int iA = 27 + (((mctech.g.d.a.b.b.c) this.menu).e.a() * 18);
        if (this.d) {
            l.a(guiGraphics, this.font, (Component) Component.literal("Сравнение NBT:"), getGuiLeft(), getGuiTop(), 0 + 157, iA + 1, d.b);
        }
        l.a(guiGraphics, this.font, (Component) Component.literal("Список:"), getGuiLeft(), getGuiTop(), 0 + 157, iA + 13, d.b);
        l.a(guiGraphics, this.font, Component.literal(getTitle().copy().getString().toUpperCase(Locale.ROOT)), getGuiLeft(), getGuiTop(), 26, 6, 156, d.b);
    }

    protected void slotClicked(@NotNull Slot slot, int i2, int i3, @NotNull ClickType clickType) {
        super.slotClicked(slot, i2, i3, clickType);
    }

    @Override // mctech.g.b.a
    public boolean a(int i2, int i3, int i4) {
        if (this.minecraft != null && i2 == 256 && this.minecraft.player != null) {
            a(0);
            return true;
        }
        return super.a(i2, i3, i4);
    }

    @Override // mctech.g.b.a
    protected boolean b() {
        return true;
    }

    protected Component a(Pair<String, ChatFormatting> pair, Pair<String, ChatFormatting> pair2, boolean z) {
        return z ? Component.literal((String) pair.getFirst()).withStyle((ChatFormatting) pair.getSecond()) : Component.literal((String) pair2.getFirst()).withStyle((ChatFormatting) pair2.getSecond());
    }
}
