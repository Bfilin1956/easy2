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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.gui.widget.ExtendedButton;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/d.class */
@OnlyIn(Dist.CLIENT)
public class d extends AbstractContainerScreen<mctech.o.b> {
    private final int a;
    private boolean b;

    public d(mctech.o.b bVar, Inventory inventory, int i) {
        super(bVar, inventory, Component.empty());
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
        for (mctech.modules.e<?> eVar : mctech.o.b.b) {
            if (eVar.c()) {
                addRenderableWidget(new b(this.leftPos + 119, i, i2));
                i2 += 2;
            } else {
                int i3 = i2;
                int i4 = i2 + 1;
                addRenderableWidget(new a(this.leftPos + 119, i, i3, false));
                i2 = i4 + 1;
                addRenderableWidget(new a(this.leftPos + 139, i, i4, true));
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
        for (mctech.modules.e<?> eVar : mctech.o.b.b) {
            Objects.requireNonNull(this.font);
            guiGraphics.drawString(this.font, eVar.d(), 27, (24 + (14 * i3)) - 9, -1);
            guiGraphics.renderItem(new ItemStack(mctech.modules.h.a().d(eVar)), 10, 11 + (14 * i3));
            i3++;
        }
    }

    protected void renderBg(@Nonnull GuiGraphics guiGraphics, float f, int i, int i2) {
        ResourceLocation resourceLocationA = mctech.m.a.a(mctech.m.a.b, "pickme_properties", ((mctech.o.b) getMenu()).b().e().e());
        guiGraphics.blit(resourceLocationA, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        float f2 = this.topPos + 19.0f;
        for (int i3 = 0; i3 < mctech.o.b.b.length; i3++) {
            mctech.modules.e<?> eVar = mctech.o.b.b[i3];
            if (!eVar.c()) {
                p.a(resourceLocationA, guiGraphics, (this.leftPos + 134.0f) - (3 / 2.0f), f2 - (5 / 2.0f), 0.0f, ((eVar.a(((mctech.o.b) getMenu()).a().get(i3)) % 10) * (3 + 1)) + 29, 251, 3, 5);
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

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/d$a.class */
    public class a extends ExtendedButton {
        private final int b;

        public a(int i, int i2, int i3, boolean z) {
            super(i, i2, 9, 9, d.this.title, (Button.OnPress) null);
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
            d.this.minecraft.gameMode.handleInventoryButtonClick(((mctech.o.b) d.this.menu).containerId, this.b);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/d$b.class */
    public class b extends ExtendedButton {
        private final int b;

        public b(int i, int i2, int i3) {
            super(i, i2, 29, 7, d.this.title, button -> {
            });
            this.b = i3;
        }

        public void renderWidget(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
            guiGraphics.blit(mctech.m.a.a(mctech.m.a.b, "pickme_properties", ((mctech.o.b) d.this.getMenu()).b().e().e()), getX(), getY(), 0, ((mctech.o.b) d.this.getMenu()).a().get(this.b / 2) == 0 ? 249 : 242, this.width, this.height);
        }

        public void onPress() {
            d.this.minecraft.gameMode.handleInventoryButtonClick(((mctech.o.b) d.this.menu).containerId, this.b);
        }
    }

    public boolean a() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }
}
