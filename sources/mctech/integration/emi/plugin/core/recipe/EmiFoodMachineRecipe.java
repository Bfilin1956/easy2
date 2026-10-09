package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.init.MCTechItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiFoodMachineRecipe.class */
public class EmiFoodMachineRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiIngredient input0;
    private final EmiIngredient input1;
    private final EmiStack output;
    private final EmiRecipeCategory category;

    public EmiFoodMachineRecipe(ItemStack itemStack, ItemStack itemStack2, EmiRecipeCategory emiRecipeCategory) {
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(itemStack.getItem());
        this.id = ResourceLocation.parse("mctech:food/" + key.getNamespace() + "/" + key.getPath());
        this.input0 = EmiStack.of(itemStack);
        this.input1 = EmiStack.of(new ItemStack((ItemLike) MCTechItems.TIN_CAN.get(), itemStack2.getCount()));
        this.output = EmiStack.of(itemStack2);
        this.category = emiRecipeCategory;
    }

    public EmiRecipeCategory getCategory() {
        return this.category;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return List.of(this.input0, this.input1);
    }

    public List<EmiStack> getOutputs() {
        return List.of(this.output);
    }

    public int getDisplayWidth() {
        return 100;
    }

    public int getDisplayHeight() {
        return 38;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addSlot(this.input0, 4, 9);
        widgetHolder.addSlot(this.input1, 24, 9);
        widgetHolder.addSlot(this.output, 76, 9).recipeContext(this);
        widgetHolder.addFillingArrow(47, 10, 1600);
    }
}
