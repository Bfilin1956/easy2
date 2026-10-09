package mctech.w;

import java.util.Objects;
import javax.annotation.Nonnull;
import mctech.MCTech;
import mctech.m.b.aI;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/n.class */
public class n extends AbstractContainerScreen<mctech.o.i> {
    private static final ResourceLocation a = MCTech.loc("textures/gui/container/gui_singular_armor.png");
    private static final ResourceLocation b = MCTech.loc("textures/gui/gui_singular_armor_atlas.png");
    private static final int c = 29;
    private static final int d = 7;
    private static final int e = 242;
    private static final int f = 249;
    private static final int g = 26;
    private static final int h = 22;
    private static final int i = 46;
    private static final int j = 97;
    private static final int k = 81;
    private static final int l = 20;
    private static final int m = 120;
    private static final int n = 100;
    private static final int o = 14;
    private static final int p = 4;
    private static final int q = 2;
    private static final int r = 2;
    private int s;
    private boolean t;

    public n(mctech.o.i iVar, Inventory inventory, Component component) {
        super(iVar, inventory, component);
        this.imageWidth = aI.f;
        this.imageHeight = 248;
        this.s = 0;
    }

    private int a() {
        return Math.max(0, (mctech.items.g.a.d.s.length * o) - 100);
    }

    private int b() {
        if (c()) {
            return 114;
        }
        return m;
    }

    private boolean c() {
        return mctech.items.g.a.d.s.length * o > 100;
    }

    private void d() {
        this.s = Mth.clamp(this.s, 0, a());
    }

    protected void init() {
        super.init();
        d();
    }

    protected void renderBg(@Nonnull GuiGraphics guiGraphics, float f2, int i2, int i3) {
        guiGraphics.blit(a, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        a(guiGraphics, i2, i3);
        b(guiGraphics, i2, i3);
    }

    private void a(@Nonnull GuiGraphics guiGraphics, int i2, int i3) {
        if (this.minecraft == null || this.minecraft.player == null) {
            return;
        }
        int i4 = this.leftPos + 26;
        int i5 = this.topPos + 22;
        InventoryScreen.renderEntityInInventoryFollowsMouse(guiGraphics, i4, i5, i4 + i, i5 + j, 37, 0.0625f, i2, i3, this.minecraft.player);
    }

    private void b(@Nonnull GuiGraphics guiGraphics, int i2, int i3) {
        int i4 = this.leftPos + k;
        int i5 = this.topPos + 20;
        int iB = b();
        int i6 = (iB - c) - 6;
        guiGraphics.fill(i4, i5, i4 + m, i5 + 100, -12961218);
        for (int i7 = 0; i7 < mctech.items.g.a.d.s.length; i7++) {
            int i8 = (i5 + (i7 * o)) - this.s;
            int i9 = i8 + o;
            if (i9 > i5 && i8 < i5 + 100) {
                boolean zA = a(i7, i2, i3);
                int iMax = Math.max(i8, i5);
                int iMin = Math.min(i9, i5 + 100);
                if (i7 % 2 == 0) {
                    guiGraphics.fill(i4, iMax, i4 + iB, iMin - 1, -1441064165);
                }
                Objects.requireNonNull(this.font);
                a(guiGraphics, Component.translatable("gui.mctech.singular_armor.feature." + mctech.items.g.a.d.s[i7].getSerializedName()), i4 + 2, i8 + ((o - 9) / 2), i6, i5, i5 + 100);
                boolean z = ((mctech.o.i) this.menu).d().get(i7) != 0;
                int i10 = ((i4 + iB) - c) - 2;
                int i11 = i8 + 3;
                if (i11 + 7 > i5 && i11 < i5 + 100) {
                    guiGraphics.blit(b, i10, i11, 0, z ? e : f, c, 7);
                }
                if (zA && i11 + 7 > i5 && i11 < i5 + 100) {
                    guiGraphics.blit(b, i10 - 1, i11 - 1, 0, 233, 31, 9);
                }
            }
        }
        if (c()) {
            c(guiGraphics, i4, i5);
        }
    }

    private void a(@Nonnull GuiGraphics guiGraphics, @Nonnull Component component, int i2, int i3, int i4, int i5, int i6) {
        String string = component.getString();
        int iWidth = this.font.width(string);
        int iMax = Math.max(i3, i5);
        Objects.requireNonNull(this.font);
        int iMin = Math.min(i3 + 9, i6);
        if (iMin <= iMax) {
            return;
        }
        if (iWidth <= i4) {
            guiGraphics.enableScissor(i2, iMax, i2 + i4, iMin);
            guiGraphics.drawString(this.font, string, i2, i3, 14737632, false);
            guiGraphics.disableScissor();
        } else {
            int iRound = (int) Math.round(((Math.sin((Util.getMillis() / 1000.0d) * 0.55d) + 1.0d) / 2.0d) * ((double) ((iWidth - i4) + 20)));
            guiGraphics.enableScissor(i2, iMax, i2 + i4, iMin);
            guiGraphics.drawString(this.font, string, i2 - iRound, i3, 14737632, false);
            guiGraphics.disableScissor();
        }
    }

    private void c(@Nonnull GuiGraphics guiGraphics, int i2, int i3) {
        int i4 = (i2 + m) - 4;
        guiGraphics.fill(i4, i3, i4 + 4, i3 + 100, -14013906);
        int iA = a();
        int iMax = Math.max(12, (100 * 100) / (mctech.items.g.a.d.s.length * o));
        int i5 = i3 + (iA == 0 ? 0 : ((100 - iMax) * this.s) / iA);
        guiGraphics.fill(i4 + 1, i5, (i4 + 4) - 1, i5 + iMax, -6598712);
    }

    protected void renderLabels(@Nonnull GuiGraphics guiGraphics, int i2, int i3) {
    }

    public void render(@Nonnull GuiGraphics guiGraphics, int i2, int i3, float f2) {
        super.render(guiGraphics, i2, i3, f2);
        renderTooltip(guiGraphics, i2, i3);
    }

    private int a(double d2, double d3) {
        int i2;
        int i3;
        int i4 = this.leftPos + k;
        int i5 = this.topPos + 20;
        int iB = b();
        if (d2 < i4 || d2 >= i4 + iB || d3 < i5 || d3 >= i5 + 100 || (i2 = (((int) d3) - i5) + this.s) < 0 || (i3 = i2 / o) >= mctech.items.g.a.d.s.length) {
            return -1;
        }
        return i3;
    }

    private boolean a(int i2, double d2, double d3) {
        if (i2 < 0) {
            return false;
        }
        int i3 = this.leftPos + k;
        int i4 = this.topPos + 20;
        int iB = b();
        int i5 = (i4 + (i2 * o)) - this.s;
        int i6 = ((i3 + iB) - c) - 2;
        int i7 = i5 + 3;
        return d2 >= ((double) i6) && d2 < ((double) (i6 + c)) && d3 >= ((double) i7) && d3 < ((double) (i7 + 7));
    }

    private boolean b(double d2, double d3) {
        if (!c()) {
            return false;
        }
        int i2 = ((this.leftPos + k) + m) - 4;
        int i3 = this.topPos + 20;
        return d2 >= ((double) i2) && d2 < ((double) (i2 + 4)) && d3 >= ((double) i3) && d3 < ((double) (i3 + 100));
    }

    private void a(double d2) {
        int i2 = this.topPos + 20;
        int iMax = Math.max(12, 10000 / (mctech.items.g.a.d.s.length * o));
        int i3 = 100 - iMax;
        if (i3 <= 0) {
            this.s = 0;
        } else {
            this.s = (int) Math.round((((d2 - ((double) i2)) - (((double) iMax) / 2.0d)) * ((double) a())) / ((double) i3));
            d();
        }
    }

    private void e() {
        Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0f));
    }

    public boolean mouseClicked(double d2, double d3, int i2) {
        if (i2 == 0) {
            if (b(d2, d3)) {
                this.t = true;
                a(d3);
                return true;
            }
            int iA = a(d2, d3);
            if (a(iA, d2, d3)) {
                e();
                if (this.minecraft != null && this.minecraft.gameMode != null) {
                    this.minecraft.gameMode.handleInventoryButtonClick(((mctech.o.i) this.menu).containerId, iA);
                    return true;
                }
                return true;
            }
        }
        return super.mouseClicked(d2, d3, i2);
    }

    public boolean mouseReleased(double d2, double d3, int i2) {
        if (i2 == 0) {
            this.t = false;
        }
        return super.mouseReleased(d2, d3, i2);
    }

    public boolean mouseDragged(double d2, double d3, int i2, double d4, double d5) {
        if (this.t && i2 == 0) {
            a(d3);
            return true;
        }
        return super.mouseDragged(d2, d3, i2, d4, d5);
    }

    public boolean mouseScrolled(double d2, double d3, double d4, double d5) {
        int i2 = this.leftPos + k;
        int i3 = this.topPos + 20;
        if (d2 >= i2 && d2 < i2 + m && d3 >= i3 && d3 < i3 + 100 && c()) {
            this.s -= ((int) Math.signum(d5)) * o;
            d();
            return true;
        }
        return super.mouseScrolled(d2, d3, d4, d5);
    }
}
