package mctech.components.b;

import mctech.components.a.C0101n;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/w.class */
public class w extends AbstractWidget {
    private final ResourceLocation a;
    private mctech.blockentities.f.e b;
    private boolean c;
    private final a d;
    private final Font e;
    private static final int f = 45;
    private static final int g = 243;
    private static final int h = 0;
    private static final int i = 238;
    private static final int j = 0;
    private static final int k = 247;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/w$a.class */
    @OnlyIn(Dist.CLIENT)
    public interface a {
        void onPress(w wVar);
    }

    public w(int i2, int i3, mctech.blockentities.f.e eVar, boolean z, Font font, a aVar) {
        super(i2, i3, 171, 13, Component.empty());
        this.b = eVar;
        this.c = z;
        this.a = C0101n.h.a();
        this.e = font;
        this.d = aVar;
    }

    protected void renderWidget(GuiGraphics guiGraphics, int i2, int i3, float f2) {
        guiGraphics.blit(this.a, getX(), getY(), 45.0f, 243.0f, getWidth(), getHeight(), mctech.utils.c.h.i, mctech.utils.c.h.i);
        if (this.b != null) {
            String strE = this.b.e();
            if (strE.length() > 20) {
                strE = strE.substring(0, 17) + "...";
            }
            guiGraphics.drawString(this.e, strE, getX() + 3, getY() + 3, 16777215);
        }
        int x = getX() + 124;
        int y = getY() + 2;
        guiGraphics.blit(this.a, x, y, this.c ? 0 : 0, this.c ? i : k, f, 9, mctech.utils.c.h.i, mctech.utils.c.h.i);
        if (isHoveredOrFocused() && this.c) {
            guiGraphics.fill(x, y, x + f, y + 1, -1);
            guiGraphics.fill(x + 44, y, x + f, y + 9, -1);
            guiGraphics.fill(x, y + 8, x + f, y + 9, -1);
            guiGraphics.fill(x, y, x + 1, y + 9, -1);
        }
    }

    public void a(mctech.blockentities.f.e eVar, boolean z) {
        this.b = eVar;
        this.c = z;
        this.visible = eVar != null;
        this.active = z && eVar != null;
    }

    public boolean mouseClicked(double d, double d2, int i2) {
        if (this.c && this.b != null) {
            int x = getX() + 124;
            int y = getY() + 2;
            if (d >= x && d < x + f && d2 >= y && d2 < y + 9) {
                this.d.onPress(this);
                return true;
            }
            return false;
        }
        return false;
    }

    protected void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
    }
}
