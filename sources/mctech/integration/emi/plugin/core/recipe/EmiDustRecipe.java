package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.u.C0188p;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiDustRecipe.class */
public class EmiDustRecipe implements EmiRecipe {
    private final EmiRecipeCategory category;
    private final ResourceLocation id;
    private final NonNullList<EmiIngredient> input = NonNullList.withSize(9, EmiIngredient.of(Ingredient.EMPTY));
    private final NonNullList<EmiStack> output = NonNullList.withSize(9, EmiStack.EMPTY);

    public EmiDustRecipe(EmiRecipeCategory emiRecipeCategory, C0188p c0188p) {
        this.category = emiRecipeCategory;
        this.id = EmiPort.getId(c0188p);
        List<ItemStack> listB = c0188p.b();
        for (int i = 0; i < listB.size(); i++) {
            this.input.set(i, EmiIngredient.of(Ingredient.of(new ItemStack[]{listB.get(i)})));
        }
        List<ItemStack> listC = c0188p.c();
        for (int i2 = 0; i2 < listC.size(); i2++) {
            this.output.set(i2, EmiStack.of(listC.get(i2)));
        }
    }

    public EmiRecipeCategory getCategory() {
        return this.category;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return this.input;
    }

    public List<EmiStack> getOutputs() {
        return this.output;
    }

    public int getDisplayWidth() {
        return 142;
    }

    public int getDisplayHeight() {
        return 62;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        for (int i = 0; i < 9; i++) {
            int i2 = 18 * (i % 3);
            int i3 = 18 * (i / 3);
            EmiIngredient emiIngredient = (EmiIngredient) this.input.get(i);
            if (!emiIngredient.isEmpty()) {
                widgetHolder.addSlot(emiIngredient, 4 + i2, 4 + i3);
            } else {
                widgetHolder.addSlot(EmiStack.EMPTY, 4 + i2, 4 + i3);
            }
            EmiStack emiStack = (EmiStack) this.output.get(i);
            if (!emiStack.isEmpty()) {
                widgetHolder.addSlot(emiStack, 84 + i2, 4 + i3).recipeContext(this);
            } else {
                widgetHolder.addSlot(EmiStack.EMPTY, 84 + i2, 4 + i3);
            }
        }
        widgetHolder.addFillingArrow(58, 23, 1600);
    }

    public static void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
