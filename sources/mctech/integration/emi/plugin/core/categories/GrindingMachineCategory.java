package mctech.integration.emi.plugin.core.categories;

import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.text.DecimalFormat;
import mctech.blocks.c.n;
import mctech.h.a.d;
import mctech.init.MCTechBlocks;
import mctech.integration.emi.plugin.core.EMIPlugin;
import mctech.integration.emi.plugin.core.recipe.GrindingMachineRecipe;
import mctech.items.e.a.i;
import mctech.q.c;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/categories/GrindingMachineCategory.class */
public class GrindingMachineCategory extends EmiRecipeCategory {
    private static final DecimalFormat CHANCE_FORMAT = new DecimalFormat("#.##");
    private final EmiTexture background;
    private final EmiTexture arrow;

    public GrindingMachineCategory() {
        super(MCTechBlocks.GRINDING_MACHINE.getId(), EmiStack.of(MCTechBlocks.GRINDING_MACHINE));
        this.background = new EmiTexture(EMIPlugin.TEXTURE, 0, 311, 135, 74, 135, 74, c.c, c.c);
        this.arrow = new EmiTexture(EMIPlugin.TEXTURE, 135, 311, 9, 16, 9, 16, c.c, c.c);
    }

    public void addArrow(@NotNull WidgetHolder widgetHolder, @NotNull GrindingMachineRecipe grindingMachineRecipe) {
        widgetHolder.addAnimatedTexture(this.arrow, 95, 29, i.b, true, false, false);
        d.c cVarA = d.a(grindingMachineRecipe.getWhetstone());
        if (cVarA != null) {
            float fA = cVarA.a(grindingMachineRecipe.getNextLevelBlade().a());
            Font font = Minecraft.getInstance().font;
            String str = "Шанс: " + CHANCE_FORMAT.format(fA * 100.0f) + "%";
            widgetHolder.addText(Component.literal(str), (int) ((this.background.width * 0.5f) - (font.width(str) * 0.5f)), (int) 55.0f, 16777215, true);
        }
    }

    public EmiTexture getBackground() {
        return this.background;
    }

    public Component getName() {
        return ((n) MCTechBlocks.GRINDING_MACHINE.get()).getName();
    }
}
