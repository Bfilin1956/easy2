package mctech.integration.emi.plugin.core.categories;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import mctech.blocks.c.p;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechRecipes;
import mctech.integration.emi.plugin.core.EMIPlugin;
import mctech.q.c;
import mctech.u.B;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/categories/IndustrialForgeRecipeCategory.class */
public class IndustrialForgeRecipeCategory extends EmiRecipeCategory {
    private final EmiTexture background;
    private final EmiTexture arrow;

    public IndustrialForgeRecipeCategory() {
        super(MCTechRecipes.typeLocation("industrial_forge"), EmiStack.of(MCTechBlocks.INDUSTRIAL_FORGE));
        this.background = new EmiTexture(EMIPlugin.TEXTURE, 0, 148, 147, 74, 147, 74, c.c, c.c);
        this.arrow = new EmiTexture(EMIPlugin.TEXTURE, 147, 148, 9, 16, 9, 16, c.c, c.c);
    }

    public void addArrow(@NotNull WidgetHolder widgetHolder, @NotNull B b) {
        widgetHolder.addAnimatedTexture(this.arrow, 109, 29, (int) ((b.d() / 20.0f) * 1000.0f), true, false, false).tooltip((num, num2) -> {
            return List.of(ClientTooltipComponent.create(EmiPort.ordered(EmiPort.literal(NumberFormat.getIntegerInstance(Locale.US).format(b.d()) + " тиков"))), ClientTooltipComponent.create(EmiPort.ordered(EmiPort.literal(NumberFormat.getIntegerInstance(Locale.US).format(b.c()) + " EU"))));
        });
    }

    public EmiTexture getBackground() {
        return this.background;
    }

    public Component getName() {
        return ((p) MCTechBlocks.INDUSTRIAL_FORGE.get()).getName();
    }
}
