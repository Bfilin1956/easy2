package mctech.integration.emi.plugin.core.categories;

import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechRecipes;
import mctech.integration.emi.plugin.core.EMIPlugin;
import mctech.integration.emi.plugin.core.recipe.BonusItemRecipe;
import mctech.items.e.a.i;
import mctech.q.c;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/categories/BonusItemRecipeCategory.class */
public class BonusItemRecipeCategory extends EmiRecipeCategory {
    private final EmiTexture background;
    private final EmiTexture arrow;

    public BonusItemRecipeCategory() {
        super(MCTechRecipes.typeLocation("macerator_bonus_item"), EmiStack.of(MCTechBlocks.REGISTERED_MACERATORS.get(MachineTier.T5)));
        this.background = new EmiTexture(EMIPlugin.TEXTURE, 0, 0, 121, 74, 121, 74, c.c, c.c);
        this.arrow = new EmiTexture(EMIPlugin.TEXTURE, 121, 0, 23, 13, 23, 13, c.c, c.c);
    }

    public void addArrow(@NotNull WidgetHolder widgetHolder, BonusItemRecipe bonusItemRecipe) {
        widgetHolder.addAnimatedTexture(this.arrow, 45, 31, i.b, true, false, false);
        MutableComponent mutableComponentLiteral = Component.literal((bonusItemRecipe.chance() * 100.0f) + "%");
        widgetHolder.addText(mutableComponentLiteral, 57 - (Minecraft.getInstance().font.width(mutableComponentLiteral) / 2), 47, -1, false);
    }

    public Component getName() {
        return Component.literal("Побочка от дробления");
    }

    public EmiTexture getBackground() {
        return this.background;
    }
}
