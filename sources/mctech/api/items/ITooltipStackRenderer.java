package mctech.api.items;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.inventory.Slot;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/ITooltipStackRenderer.class */
public interface ITooltipStackRenderer {
    void renderTooltipItemStacks(GuiGraphics guiGraphics, Slot slot, int i, int i2, float f);
}
