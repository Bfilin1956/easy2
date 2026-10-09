package mctech.components;

import dev.emi.emi.api.EmiApi;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/G.class */
@OnlyIn(Dist.CLIENT)
public class G extends AbstractWidget {
    private final EmiRecipeCategory a;

    public G(int i, int i2, int i3, int i4, EmiRecipeCategory emiRecipeCategory) {
        super(i, i2, i3, i4, Component.literal("recipe area"));
        this.a = emiRecipeCategory;
    }

    public void a(GuiGraphics guiGraphics, int i, int i2) {
        guiGraphics.renderTooltip(Minecraft.getInstance().font, Component.literal("Открыть список рецептов"), i, i2);
    }

    public void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (isHoveredOrFocused()) {
            a(guiGraphics, i, i2);
        }
    }

    public void onClick(double d, double d2) {
        EmiApi.displayRecipeCategory(this.a);
    }

    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {
    }
}
