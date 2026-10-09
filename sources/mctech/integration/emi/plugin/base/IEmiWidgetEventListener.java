package mctech.integration.emi.plugin.base;

import dev.emi.emi.api.widget.Bounds;
import dev.emi.emi.screen.WidgetGroup;
import net.minecraft.client.gui.GuiGraphics;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/base/IEmiWidgetEventListener.class */
public interface IEmiWidgetEventListener {
    default void render(GuiGraphics guiGraphics, int i, int i2, float f, WidgetGroup widgetGroup) {
    }

    default void mouseMoved(double d, double d2, Bounds bounds) {
    }

    default boolean mouseClicked(double d, double d2, int i, Bounds bounds) {
        return false;
    }

    default boolean mouseReleased(double d, double d2, int i, Bounds bounds) {
        return false;
    }

    default boolean mouseDragged(double d, double d2, int i, double d3, double d4, Bounds bounds) {
        return false;
    }

    default boolean mouseScrolled(double d, double d2, double d3, double d4, Bounds bounds) {
        return false;
    }

    default boolean keyPressed(int i, int i2, int i3, Bounds bounds) {
        return false;
    }

    default boolean keyReleased(int i, int i2, int i3, Bounds bounds) {
        return false;
    }

    default boolean charTyped(char c, int i, Bounds bounds) {
        return false;
    }
}
