package mctech.integration.emi.plugin.core.categories;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.blocks.c.C0080a;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechRecipes;
import mctech.integration.emi.plugin.core.EMIPlugin;
import mctech.q.c;
import mctech.u.C0186n;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/categories/CrystalGrowthChamberCategory.class */
public class CrystalGrowthChamberCategory extends EmiRecipeCategory {
    private final EmiTexture background;
    private final EmiTexture arrow;

    public CrystalGrowthChamberCategory() {
        super(MCTechRecipes.typeLocation("crystal_growth_chamber"), EmiStack.of(MCTechBlocks.CRYSTAL_GROWTH_CHAMBER));
        this.background = new EmiTexture(EMIPlugin.TEXTURE, 0, 222, 147, 89, 147, 89, c.c, c.c);
        this.arrow = new EmiTexture(EMIPlugin.TEXTURE, 147, 222, 16, 9, 16, 9, c.c, c.c);
    }

    public Component getName() {
        return ((C0080a) MCTechBlocks.CRYSTAL_GROWTH_CHAMBER.get()).getName();
    }

    public void addArrow(@NotNull WidgetHolder widgetHolder, @NotNull C0186n c0186n) {
        widgetHolder.addAnimatedTexture(this.arrow, 63, 46, (int) ((c0186n.b() / 20.0f) * 1000.0f), false, false, false).tooltip((num, num2) -> {
            return List.of(ClientTooltipComponent.create(EmiPort.ordered(EmiPort.literal(c0186n.b() + " тиков"))));
        });
    }

    public EmiTexture getBackground() {
        return this.background;
    }
}
