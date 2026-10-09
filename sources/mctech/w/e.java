package mctech.w;

import it.unimi.dsi.fastutil.ints.IntIntPair;
import javax.annotation.Nonnull;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.gui.widget.ExtendedButton;
import net.neoforged.neoforge.items.SlotItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/e.class */
@OnlyIn(Dist.CLIENT)
public class e extends AbstractContainerScreen<mctech.o.b> {
    private static final int[][] d = {new int[]{125, 33, 122, 28, 47, 46}, new int[]{126, 96, 123, 91, 48, 49}, new int[]{61, 96, 59, 91, 48, 49}, new int[]{64, 38, 61, 33, 47, 44}};
    public final int a;
    protected final o b;
    private d e;
    private f f;
    protected ExtendedButton[] c;

    public e(mctech.o.b bVar, Inventory inventory, Component component) {
        super(bVar, inventory, component);
        this.c = new ExtendedButton[2];
        this.imageWidth = 225;
        this.imageHeight = 251;
        this.b = new o(this, o.a(bVar, mctech.o.b.a), o.b(bVar), o.a(bVar));
        this.a = bVar.b().e().ordinal();
        this.e = new d(bVar, inventory, this.a);
        this.e.a(false);
        this.f = new f(this, inventory);
        this.f.a(false);
    }

    protected void init() {
        this.e.width = this.width;
        this.e.height = this.height;
        this.f.width = this.width;
        this.f.height = this.height;
        super.init();
        this.c[0] = (ExtendedButton) addRenderableWidget(new ExtendedButton(this, this.leftPos, this.topPos + 17, 11, 12, this.title, button -> {
            this.e.a(false);
            this.f.a(!this.f.a());
        }) { // from class: mctech.w.e.1
            public void renderWidget(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
                if (isHovered()) {
                    int x = getX();
                    int y = getY();
                    guiGraphics.fill(x, y, x + this.width, y + 1, -1);
                    guiGraphics.fill(x, (y + this.height) - 1, x + this.width, y + this.height, -1);
                    guiGraphics.fill(x, y, x + 1, y + this.height, -1);
                    guiGraphics.fill((x + this.width) - 1, y, x + this.width, y + this.height, -1);
                }
            }
        });
        this.c[1] = (ExtendedButton) addRenderableWidget(new ExtendedButton(this, this.leftPos, this.topPos + 30, 11, 12, this.title, button2 -> {
            this.f.a(false);
            this.e.a(!this.e.a());
        }) { // from class: mctech.w.e.2
            public void renderWidget(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
                if (isHovered()) {
                    int x = getX();
                    int y = getY();
                    guiGraphics.fill(x, y, x + this.width, y + 1, -1);
                    guiGraphics.fill(x, (y + this.height) - 1, x + this.width, y + this.height, -1);
                    guiGraphics.fill(x, y, x + 1, y + this.height, -1);
                    guiGraphics.fill((x + this.width) - 1, y, x + this.width, y + this.height, -1);
                }
            }
        });
        this.e.init();
        this.f.init();
    }

    public void render(GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        if (this.e.a()) {
            this.e.render(guiGraphics, i, i2, f);
        }
        if (this.f.a()) {
            this.f.render(guiGraphics, i, i2, f);
            for (Slot slot : ((mctech.o.b) getMenu()).slots) {
                if (slot.x < 999999 && (slot instanceof SlotItemHandler)) {
                    int i3 = (this.leftPos + slot.x) - 1;
                    int i4 = (this.topPos + slot.y) - 1;
                    guiGraphics.fill(i3, i4, i3 + 18, i4 + 18, this.f.b() == slot ? 1895804974 : 1426112511);
                }
            }
        }
        renderTooltip(guiGraphics, i, i2);
    }

    protected void renderLabels(GuiGraphics guiGraphics, int i, int i2) {
    }

    protected void renderTooltip(@Nonnull GuiGraphics guiGraphics, int i, int i2) {
        super.renderTooltip(guiGraphics, i, i2);
        this.b.a(guiGraphics, i, i2, this.hoveredSlot);
        int i3 = 20 + this.leftPos;
        int i4 = 39 + this.topPos;
        if (i > i3 && i <= i3 + 19 && i2 > i4 && i2 <= i4 + 91) {
            IntIntPair intIntPairB = b();
            guiGraphics.renderTooltip(this.font, Component.literal(a(intIntPairB.rightInt()) + " / " + a(intIntPairB.leftInt()) + " EU").withStyle(ChatFormatting.AQUA), i, i2);
        }
    }

    @Nonnull
    private String a(int i) {
        StringBuilder sbAppend = new StringBuilder().append(i);
        for (int length = sbAppend.length() - 3; length > 0; length -= 3) {
            sbAppend.insert(length, ',');
        }
        return sbAppend.toString();
    }

    protected void renderBg(@Nonnull GuiGraphics guiGraphics, float f, int i, int i2) {
        ResourceLocation resourceLocationA = mctech.m.a.a("pickaxe", ((mctech.o.b) getMenu()).b().e().e());
        guiGraphics.blit(resourceLocationA, this.leftPos, (this.height - this.imageHeight) / 2, 0, 0, this.imageWidth, this.imageHeight);
        this.b.a(guiGraphics);
        float fA = a();
        if (fA != 0.0f) {
            int i3 = (int) (fA * 91.0f);
            guiGraphics.blit(resourceLocationA, this.leftPos + 21, this.topPos + 40 + (91 - i3), 237, 91 - i3, 19, i3);
        }
        int slots = ((mctech.o.b) getMenu()).b().g().getSlots() / 2;
        ResourceLocation resourceLocationA2 = mctech.m.a.a(mctech.m.a.b, "pickme_lines", ((mctech.o.b) getMenu()).b().e().e());
        for (int i4 = 0; i4 < slots; i4++) {
            guiGraphics.blit(resourceLocationA2, this.leftPos + d[i4][0], this.topPos + d[i4][1], d[i4][2], d[i4][3], d[i4][4], d[i4][5], mctech.utils.c.h.i, mctech.utils.c.h.i);
        }
    }

    private float a() {
        IntIntPair intIntPairB = b();
        if (intIntPairB.leftInt() == 0.0f) {
            return 0.0f;
        }
        return intIntPairB.rightInt() / intIntPairB.leftInt();
    }

    public boolean mouseClicked(double d2, double d3, int i) {
        return (this.e.a() && this.e.mouseClicked(d2, d3, i)) || this.f.mouseClicked(d2, d3, i) || super.mouseClicked(d2, d3, i);
    }

    public boolean keyPressed(int i, int i2, int i3) {
        return (this.f.a() && this.f.keyPressed(i, i2, i3)) || super.keyPressed(i, i2, i3);
    }

    public boolean keyReleased(int i, int i2, int i3) {
        return (this.f.a() && this.f.keyReleased(i, i2, i3)) || super.keyReleased(i, i2, i3);
    }

    public GuiEventListener getFocused() {
        return (!this.f.a() || this.f.getFocused() == null) ? super.getFocused() : this.f.getFocused();
    }

    @Nonnull
    private IntIntPair b() {
        ItemStack itemStackC = ((mctech.o.b) getMenu()).c();
        return IntIntPair.of(mctech.e.b.d(itemStackC), mctech.e.b.c(itemStackC));
    }
}
