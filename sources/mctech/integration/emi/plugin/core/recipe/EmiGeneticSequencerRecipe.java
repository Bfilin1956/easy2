package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.MCTech;
import mctech.init.MCTechItems;
import mctech.init.MCTechLang;
import mctech.k.b;
import mctech.u.C0195w;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.ItemLike;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiGeneticSequencerRecipe.class */
public class EmiGeneticSequencerRecipe implements EmiRecipe {
    private final EmiRecipeCategory recipeCategory;
    private final ResourceLocation id;
    private final EmiStack materialInput;
    private final EmiStack vialInput = EmiStack.of((ItemLike) MCTechItems.EMPTY_VIAL.get());
    private final EmiStack dnaOutput;

    public EmiGeneticSequencerRecipe(EmiRecipeCategory emiRecipeCategory, C0195w c0195w) {
        this.recipeCategory = emiRecipeCategory;
        this.id = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "/genetic_sequencer/" + c0195w.b().getPath());
        this.materialInput = EmiStack.of(b.a((EntityType<?>) BuiltInRegistries.ENTITY_TYPE.getOptional(c0195w.b()).orElse(EntityType.COW)));
        this.dnaOutput = EmiStack.of(b.a(c0195w.b(), 25.0f));
    }

    public EmiRecipeCategory getCategory() {
        return this.recipeCategory;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return List.of(this.materialInput, this.vialInput);
    }

    public List<EmiStack> getOutputs() {
        return List.of(this.dnaOutput);
    }

    public int getDisplayWidth() {
        return 164;
    }

    public int getDisplayHeight() {
        return 48;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addSlot(this.materialInput, 4, 9);
        widgetHolder.addSlot(this.vialInput, 24, 9);
        widgetHolder.addFillingArrow(48, 10, 1600);
        widgetHolder.addSlot(this.dnaOutput, 80, 9).recipeContext(this);
        widgetHolder.addText(EmiPort.ordered(MCTechLang.EMI_GENETIC_SEQUENCER_INFO.get()), 4, 32, -12566464, false);
    }
}
