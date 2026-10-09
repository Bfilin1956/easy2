package mctech.w;

import it.unimi.dsi.fastutil.ints.IntIntPair;
import javax.annotation.Nonnull;
import mctech.init.MCTechItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.gui.widget.ExtendedButton;
import net.neoforged.neoforge.items.SlotItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/b.class */
@OnlyIn(Dist.CLIENT)
public class b extends AbstractContainerScreen<mctech.o.a> {
    public final int a;
    protected final g b;
    private a d;
    private c e;
    protected ExtendedButton[] c;

    public b(mctech.o.a aVar, Inventory inventory, Component component) {
        super(aVar, inventory, component);
        this.c = new ExtendedButton[2];
        this.imageWidth = 225;
        this.imageHeight = 251;
        this.b = new g(this, g.a(aVar, mctech.o.a.a), g.c(aVar), g.a(aVar), g.b(aVar), new g.a(mctech.o.a.b, "ваттметр", new ItemStack((ItemLike) MCTechItems.EU_READER.get())));
        this.a = aVar.c().e().ordinal();
        this.d = new a(aVar, inventory, this.a);
        this.d.a(false);
        this.e = new c(this, inventory);
        this.e.a(false);
    }

    protected void init() {
        this.d.width = this.width;
        this.d.height = this.height;
        this.e.width = this.width;
        this.e.height = this.height;
        super.init();
        this.c[0] = (ExtendedButton) addRenderableWidget(new ExtendedButton(this, this.leftPos, this.topPos + 17, 11, 12, this.title, button -> {
            this.d.a(false);
            this.e.a(!this.e.a());
        }) { // from class: mctech.w.b.1
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
            this.e.a(false);
            this.d.a(!this.d.a());
        }) { // from class: mctech.w.b.2
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
        this.d.init();
        this.e.init();
    }

    public void render(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        if (this.d.a()) {
            this.d.render(guiGraphics, i, i2, f);
        }
        if (this.e.a()) {
            this.e.render(guiGraphics, i, i2, f);
            for (Slot slot : ((mctech.o.a) getMenu()).slots) {
                if (slot.x < 999999 && (slot instanceof SlotItemHandler)) {
                    int i3 = (this.leftPos + slot.x) - 1;
                    int i4 = (this.topPos + slot.y) - 1;
                    guiGraphics.fill(i3, i4, i3 + 18, i4 + 18, this.e.b() == slot ? 1895804974 : 1426112511);
                }
            }
        }
        renderTooltip(guiGraphics, i, i2);
    }

    protected void renderLabels(@Nonnull GuiGraphics guiGraphics, int i, int i2) {
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
        ResourceLocation resourceLocationA = mctech.m.a.a("equipment", ((mctech.o.a) getMenu()).c().e().e());
        guiGraphics.blit(resourceLocationA, this.leftPos, (this.height - this.imageHeight) / 2, 0, 0, this.imageWidth, this.imageHeight);
        this.b.a(guiGraphics);
        float fA = a();
        if (fA != 0.0f) {
            int i3 = (int) (fA * 91.0f);
            guiGraphics.blit(resourceLocationA, this.leftPos + 21, this.topPos + 40 + (91 - i3), 237, 91 - i3, 19, i3);
        }
    }

    private float a() {
        IntIntPair intIntPairB = b();
        if (intIntPairB.leftInt() == 0.0f) {
            return 0.0f;
        }
        return intIntPairB.rightInt() / intIntPairB.leftInt();
    }

    public boolean mouseClicked(double d, double d2, int i) {
        return (this.d.a() && this.d.mouseClicked(d, d2, i)) || this.e.mouseClicked(d, d2, i) || super.mouseClicked(d, d2, i);
    }

    public boolean keyPressed(int i, int i2, int i3) {
        return (this.e.a() && this.e.keyPressed(i, i2, i3)) || super.keyPressed(i, i2, i3);
    }

    public boolean keyReleased(int i, int i2, int i3) {
        return (this.e.a() && this.e.keyReleased(i, i2, i3)) || super.keyReleased(i, i2, i3);
    }

    public GuiEventListener getFocused() {
        return (!this.e.a() || this.e.getFocused() == null) ? super.getFocused() : this.e.getFocused();
    }

    @Nonnull
    private IntIntPair b() {
        ItemStack item = ((mctech.o.a) getMenu()).a().getItem();
        return IntIntPair.of(mctech.e.a.d(item), mctech.e.a.c(item));
    }
}
