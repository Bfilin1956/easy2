package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.Iterator;
import java.util.List;
import mctech.u.V;
import mctech.utils.math.a;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiRecyclerRecipe.class */
public class EmiRecyclerRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiRecipeCategory category;
    private final EmiIngredient input;
    private final EmiStack output;
    private final float chance;

    public EmiRecyclerRecipe(V v, EmiRecipeCategory emiRecipeCategory) {
        this.id = EmiPort.getId(v);
        this.category = emiRecipeCategory;
        this.input = EmiIngredient.of(v.h());
        this.output = EmiStack.of(EmiPort.getOutput(v));
        this.chance = v.b();
    }

    public EmiRecyclerRecipe(V v, EmiRecipeCategory emiRecipeCategory, List<Ingredient> list) {
        this.id = EmiPort.getId(v);
        this.category = emiRecipeCategory;
        this.input = EmiIngredient.of(Ingredient.of(BuiltInRegistries.ITEM.stream().filter(item -> {
            return (item == Items.BARRIER || item == Items.BEDROCK) ? false : true;
        }).map(item2 -> {
            return new ItemStack(item2);
        }).filter(itemStack -> {
            return canRecycle(list, itemStack);
        })));
        this.output = EmiStack.of(EmiPort.getOutput(v));
        this.chance = v.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean canRecycle(List<Ingredient> list, ItemStack itemStack) {
        Iterator<Ingredient> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().test(itemStack)) {
                return false;
            }
        }
        return true;
    }

    public EmiRecipeCategory getCategory() {
        return this.category;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return List.of(this.input);
    }

    public List<EmiStack> getOutputs() {
        return List.of(this.output);
    }

    public int getDisplayWidth() {
        return 82;
    }

    public int getDisplayHeight() {
        return 38;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addSlot(this.input, 4, 9);
        widgetHolder.addSlot(this.output, 60, 9).recipeContext(this);
        widgetHolder.addFillingArrow(26, 10, 1600);
        widgetHolder.addText(Component.literal(String.valueOf(this.chance * 100.0f) + "%"), 28, 30, a.f, false);
    }
}
