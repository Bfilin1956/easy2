package mctech.integration.emi.plugin.core;

import dev.emi.emi.api.EmiDragDropHandler;
import dev.emi.emi.api.stack.EmiIngredient;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/EMIConduitFilterDropHandler.class */
public class EMIConduitFilterDropHandler implements EmiDragDropHandler<Screen> {
    public boolean dropStack(Screen screen, EmiIngredient emiIngredient, int i, int i2) {
        return false;
    }

    public void render(Screen screen, EmiIngredient emiIngredient, GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
