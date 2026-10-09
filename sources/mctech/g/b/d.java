package mctech.g.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/d.class */
public abstract class d<T extends AbstractContainerMenu> extends AbstractContainerScreen<T> {
    private final boolean a;
    private final List<EditBox> b;

    public abstract ResourceLocation a();

    protected abstract Vector2i b();

    protected d(T t, Inventory inventory, Component component) {
        this(t, inventory, component, false);
    }

    protected d(T t, Inventory inventory, Component component, boolean z) {
        super(t, inventory, component);
        this.b = new ArrayList();
        this.a = z;
        this.imageWidth = b().x();
        this.imageHeight = b().y();
    }

    public void resize(@NotNull Minecraft minecraft, int i, int i2) {
        HashMap map = new HashMap();
        for (EditBox editBox : this.b) {
            map.put(editBox.getMessage().getString(), editBox.getValue());
        }
        this.b.clear();
        super.resize(minecraft, i, i2);
        for (EditBox editBox2 : this.b) {
            editBox2.setValue((String) map.getOrDefault(editBox2.getMessage().getString(), ""));
        }
    }

    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        renderTooltip(guiGraphics, i, i2);
    }

    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int i2) {
        guiGraphics.blit(a(), getGuiLeft(), getGuiTop(), 0, 0, this.imageWidth, this.imageHeight);
    }

    public boolean keyPressed(int i, int i2, int i3) {
        if (this.minecraft != null && i == 256 && this.minecraft.player != null) {
            this.minecraft.player.closeContainer();
            return true;
        }
        for (EditBox editBox : this.b) {
            if (editBox.keyPressed(i, i2, i3) || editBox.canConsumeInput()) {
                return true;
            }
        }
        return super.keyPressed(i, i2, i3);
    }

    public boolean mouseDragged(double d, double d2, int i, double d3, double d4) {
        AbstractWidget focused = getFocused();
        if (focused instanceof AbstractWidget) {
            AbstractWidget abstractWidget = focused;
            if (abstractWidget.isActive()) {
                return abstractWidget.mouseDragged(d, d2, i, d3, d4);
            }
        }
        return super.mouseDragged(d, d2, i, d3, d4);
    }

    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        if (this.a) {
            super.renderLabels(guiGraphics, i, i2);
        }
    }

    @NotNull
    protected <U extends GuiEventListener & NarratableEntry> U addWidget(@NotNull U u) {
        if (u instanceof EditBox) {
            this.b.add((EditBox) u);
        }
        return (U) super.addWidget(u);
    }

    protected void removeWidget(@NotNull GuiEventListener guiEventListener) {
        super.removeWidget(guiEventListener);
        if (guiEventListener instanceof EditBox) {
            this.b.remove((EditBox) guiEventListener);
        }
    }
}
