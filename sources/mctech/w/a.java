package mctech.w;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.Nonnull;
import mctech.utils.p;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.gui.widget.ExtendedButton;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/a.class */
public class a extends AbstractContainerScreen<mctech.o.a> {
    private final int a;
    private boolean b;

    public a(mctech.o.a aVar, Inventory inventory, int i) {
        super(aVar, inventory, Component.empty());
        this.imageWidth = 160;
        this.imageHeight = 120;
        this.a = i;
    }

    protected void init() {
        clearWidgets();
        this.minecraft = Minecraft.getInstance();
        this.font = this.minecraft.font;
        super.init();
        this.leftPos = ((this.width - this.imageWidth) / 2) - 194;
        this.topPos = ((this.height - this.imageHeight) / 2) - 60;
        int i = this.topPos + 14;
        int i2 = 0;
        for (mctech.modules.e<?> eVar : mctech.o.a.e) {
            if (eVar.c()) {
                addRenderableWidget(new b(this.leftPos + 119, i, i2));
                i2 += 2;
            } else {
                int i3 = i2;
                int i4 = i2 + 1;
                addRenderableWidget(new C0051a(this.leftPos + 119, i, i3, false));
                i2 = i4 + 1;
                addRenderableWidget(new C0051a(this.leftPos + 139, i, i4, true));
            }
            i += 14;
        }
    }

    public void render(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        int i3 = this.leftPos;
        int i4 = this.topPos;
        renderBg(guiGraphics, f, i, i2);
        RenderSystem.disableDepthTest();
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(i3, i4, 0.0f);
        renderLabels(guiGraphics, i, i2);
        guiGraphics.pose().popPose();
        RenderSystem.enableDepthTest();
        Iterator it = this.renderables.iterator();
        while (it.hasNext()) {
            ((Renderable) it.next()).render(guiGraphics, i, i2, f);
        }
        renderTooltip(guiGraphics, i, i2);
    }

    protected void renderLabels(@Nonnull GuiGraphics guiGraphics, int i, int i2) {
        int i3 = 0;
        for (mctech.modules.e<?> eVar : mctech.o.a.e) {
            Objects.requireNonNull(this.font);
            guiGraphics.drawString(this.font, eVar.d(), 27, (24 + (14 * i3)) - 9, -1);
            guiGraphics.renderItem(new ItemStack(mctech.modules.h.a().d(eVar)), 10, 11 + (14 * i3));
            i3++;
        }
    }

    protected void renderBg(@Nonnull GuiGraphics guiGraphics, float f, int i, int i2) {
        ResourceLocation resourceLocationA = mctech.m.a.a(mctech.m.a.b, "configuration", ((mctech.o.a) getMenu()).c().e().e());
        guiGraphics.blit(resourceLocationA, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        float f2 = this.topPos + 19.0f;
        for (int i3 = 0; i3 < mctech.o.a.e.length; i3++) {
            mctech.modules.e<?> eVar = mctech.o.a.e[i3];
            if (!eVar.c()) {
                p.a(resourceLocationA, guiGraphics, (this.leftPos + 134.0f) - (3 / 2.0f), f2 - (5 / 2.0f), 0.0f, ((eVar.a(((mctech.o.a) getMenu()).b().get(i3)) % 10) * (3 + 1)) + 34, 251, 3, 5);
            }
            f2 += 14.0f;
        }
    }

    public boolean mouseClicked(double d, double d2, int i) {
        for (GuiEventListener guiEventListener : children()) {
            if (guiEventListener.mouseClicked(d, d2, i)) {
                setFocused(guiEventListener);
                if (i == 0) {
                    setDragging(true);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: mctech.w.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/a$a.class */
    public class C0051a extends ExtendedButton {
        private final int b;

        public C0051a(int i, int i2, int i3, boolean z) {
            super(i, i2, 9, 9, a.this.title, (Button.OnPress) null);
            this.b = i3;
        }

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

        public void onPress() {
            a.this.minecraft.gameMode.handleInventoryButtonClick(((mctech.o.a) a.this.menu).containerId, this.b);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/a$b.class */
    public class b extends ExtendedButton {
        private final int b;

        public b(int i, int i2, int i3) {
            super(i, i2, 29, 7, a.this.title, button -> {
            });
            this.b = i3;
        }

        public void renderWidget(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
            guiGraphics.blit(mctech.m.a.a(mctech.m.a.b, "configuration", ((mctech.o.a) a.this.getMenu()).c().e().e()), getX(), getY(), 0, ((mctech.o.a) a.this.getMenu()).b().get(this.b / 2) == 0 ? 249 : 242, this.width, this.height);
        }

        public void onPress() {
            a.this.minecraft.gameMode.handleInventoryButtonClick(((mctech.o.a) a.this.menu).containerId, this.b);
        }
    }

    public boolean a() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }
}
