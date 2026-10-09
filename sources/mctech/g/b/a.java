package mctech.g.b;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ComponentPath;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.navigation.FocusNavigationEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a.class */
public abstract class a<T extends AbstractContainerMenu> extends AbstractContainerScreen<T> {
    private final Multimap<Integer, Renderable> b;
    private final Multimap<Integer, GuiEventListener> c;
    private final Map<String, e> d;
    protected boolean a;

    public a(T t, Inventory inventory, Component component) {
        super(t, inventory, component);
        this.b = HashMultimap.create();
        this.c = HashMultimap.create();
        this.d = new HashMap();
        this.a = false;
    }

    protected void a(int i) {
        ((MultiPlayerGameMode) Objects.requireNonNull(getMinecraft().gameMode)).handleInventoryButtonClick(getMenu().containerId, i);
    }

    protected void a() {
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        guiGraphics.pose().pushPose();
        renderTooltip(guiGraphics, i, i2);
        guiGraphics.pose().popPose();
    }

    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        if (this.a) {
            super.renderLabels(guiGraphics, i, i2);
        }
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(-this.leftPos, -this.topPos, 0.0d);
        int iB = 200;
        for (Integer num : this.b.keySet()) {
            guiGraphics.pose().pushPose();
            iB += 150;
            guiGraphics.pose().translate(0.0d, 0.0d, iB);
            for (c cVar : this.b.get(num)) {
                if (!(cVar instanceof AbstractWidget) || cVar.isActive()) {
                    cVar.render(guiGraphics, i, i2, Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(false));
                    if (cVar instanceof c) {
                        iB += cVar.b();
                    }
                }
            }
            guiGraphics.pose().popPose();
        }
        guiGraphics.pose().popPose();
    }

    protected final void renderTooltip(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            for (AbstractWidget abstractWidget : this.c.get((Integer) it.next())) {
                if (!(abstractWidget instanceof AbstractWidget) || abstractWidget.isActive()) {
                    if (abstractWidget.isMouseOver(i, i2)) {
                        return;
                    }
                }
            }
        }
        if (!a(guiGraphics, i, i2)) {
            super.renderTooltip(guiGraphics, i, i2);
        }
    }

    protected boolean a(GuiGraphics guiGraphics, int i, int i2) {
        return false;
    }

    protected void renderSlotContents(@NotNull GuiGraphics guiGraphics, @NotNull ItemStack itemStack, @NotNull Slot slot, @Nullable String str) {
        super.renderSlotContents(guiGraphics, itemStack, slot, str);
    }

    public <U extends e> U a(String str, U u) {
        this.d.put(str, u);
        return u;
    }

    public <U extends Renderable> U a(int i, U u) {
        this.b.put(Integer.valueOf(i), u);
        return u;
    }

    public <U extends Renderable & GuiEventListener> U b(int i, U u) {
        this.b.put(Integer.valueOf(i), u);
        this.c.put(Integer.valueOf(i), u);
        return u;
    }

    protected void clearWidgets() {
        this.b.clear();
        this.c.clear();
        this.d.clear();
        super.clearWidgets();
    }

    public void resize(@NotNull Minecraft minecraft, int i, int i2) {
        Map map = (Map) this.d.entrySet().stream().collect(Collectors.toMap((v0) -> {
            return v0.getKey();
        }, entry -> {
            return ((e) entry.getValue()).a();
        }));
        super.resize(minecraft, i, i2);
        for (String str : map.keySet()) {
            this.d.get(str).a(map.get(str));
        }
    }

    public void mouseMoved(double d, double d2) {
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            for (AbstractWidget abstractWidget : this.c.get((Integer) it.next())) {
                if (!(abstractWidget instanceof AbstractWidget) || abstractWidget.isActive()) {
                    abstractWidget.mouseMoved(d, d2);
                }
            }
        }
        super.mouseMoved(d, d2);
    }

    public boolean mouseClicked(double d, double d2, int i) {
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            for (AbstractWidget abstractWidget : this.c.get((Integer) it.next())) {
                if (!(abstractWidget instanceof AbstractWidget) || abstractWidget.isActive()) {
                    if (abstractWidget.isMouseOver(d, d2)) {
                        setFocused(abstractWidget);
                        return abstractWidget.mouseClicked(d, d2, i);
                    }
                }
            }
        }
        return super.mouseClicked(d, d2, i);
    }

    public boolean mouseReleased(double d, double d2, int i) {
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            for (AbstractWidget abstractWidget : this.c.get((Integer) it.next())) {
                if (!(abstractWidget instanceof AbstractWidget) || abstractWidget.isActive()) {
                    if (abstractWidget.isMouseOver(d, d2)) {
                        return abstractWidget.mouseReleased(d, d2, i);
                    }
                }
            }
        }
        return super.mouseReleased(d, d2, i);
    }

    public boolean mouseDragged(double d, double d2, int i, double d3, double d4) {
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            for (AbstractWidget abstractWidget : this.c.get((Integer) it.next())) {
                if (!(abstractWidget instanceof AbstractWidget) || abstractWidget.isActive()) {
                    if (abstractWidget.isMouseOver(d, d2)) {
                        return abstractWidget.mouseDragged(d, d2, i, d3, d4);
                    }
                }
            }
        }
        AbstractWidget focused = getFocused();
        if (focused instanceof AbstractWidget) {
            AbstractWidget abstractWidget2 = focused;
            if (abstractWidget2.isActive()) {
                return abstractWidget2.mouseDragged(d, d2, i, d3, d4);
            }
        }
        return super.mouseDragged(d, d2, i, d3, d4);
    }

    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            for (AbstractWidget abstractWidget : this.c.get((Integer) it.next())) {
                if (!(abstractWidget instanceof AbstractWidget) || abstractWidget.isActive()) {
                    if (abstractWidget.isMouseOver(d, d2)) {
                        return abstractWidget.mouseScrolled(d, d2, d3, d4);
                    }
                }
            }
        }
        return super.mouseScrolled(d, d2, d3, d4);
    }

    protected boolean b() {
        return false;
    }

    @Deprecated
    public final boolean keyPressed(int i, int i2, int i3) {
        if (!b() && this.minecraft != null && i == 256 && this.minecraft.player != null) {
            this.minecraft.player.closeContainer();
            return true;
        }
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            for (AbstractWidget abstractWidget : this.c.get((Integer) it.next())) {
                if (!(abstractWidget instanceof AbstractWidget) || abstractWidget.isActive()) {
                    if (abstractWidget.keyPressed(i, i2, i3)) {
                        return true;
                    }
                }
            }
        }
        if (a(i, i2, i3)) {
            return true;
        }
        return super.keyPressed(i, i2, i3);
    }

    public boolean a(int i, int i2, int i3) {
        return false;
    }

    public boolean keyReleased(int i, int i2, int i3) {
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            for (AbstractWidget abstractWidget : this.c.get((Integer) it.next())) {
                if (!(abstractWidget instanceof AbstractWidget) || abstractWidget.isActive()) {
                    if (abstractWidget.keyReleased(i, i2, i3)) {
                        return true;
                    }
                }
            }
        }
        return super.keyReleased(i, i2, i3);
    }

    public boolean charTyped(char c, int i) {
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            for (AbstractWidget abstractWidget : this.c.get((Integer) it.next())) {
                if (!(abstractWidget instanceof AbstractWidget) || abstractWidget.isActive()) {
                    if (abstractWidget.charTyped(c, i)) {
                        return true;
                    }
                }
            }
        }
        return super.charTyped(c, i);
    }

    @Nullable
    public ComponentPath nextFocusPath(@NotNull FocusNavigationEvent focusNavigationEvent) {
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            for (AbstractWidget abstractWidget : this.c.get((Integer) it.next())) {
                if (!(abstractWidget instanceof AbstractWidget) || abstractWidget.isActive()) {
                    ComponentPath componentPathNextFocusPath = abstractWidget.nextFocusPath(focusNavigationEvent);
                    if (componentPathNextFocusPath != null) {
                        return componentPathNextFocusPath;
                    }
                }
            }
        }
        return super.nextFocusPath(focusNavigationEvent);
    }

    public boolean isMouseOver(double d, double d2) {
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            for (AbstractWidget abstractWidget : this.c.get((Integer) it.next())) {
                if (!(abstractWidget instanceof AbstractWidget) || abstractWidget.isActive()) {
                    if (abstractWidget.isMouseOver(d, d2)) {
                        return true;
                    }
                }
            }
        }
        return super.isMouseOver(d, d2);
    }
}
