package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import mctech.integration.emi.plugin.core.EMIRecipeCategory;
import mctech.utils.math.a;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.joml.Math;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiRareEarthRecipe.class */
public class EmiRareEarthRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiIngredient input;
    private final EmiStack output;
    private final float value;
    private final float maxValue;

    public EmiRareEarthRecipe(String str, RareData rareData, Ingredient ingredient, Float f) {
        this.id = ResourceLocation.tryParse(str);
        this.input = EmiIngredient.of(ingredient, (int) Math.floor(rareData.amount() / f.floatValue()));
        this.output = EmiStack.of(rareData.itemStack());
        this.value = f.floatValue();
        this.maxValue = rareData.amount();
    }

    public EmiRecipeCategory getCategory() {
        return EMIRecipeCategory.RARE_EARTH;
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
        return 100;
    }

    public int getDisplayHeight() {
        return 38;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addSlot(this.input, 4, 9);
        widgetHolder.addSlot(this.output, 76, 9).recipeContext(this);
        widgetHolder.addFillingArrow(38, 10, 1600);
        widgetHolder.addText(Component.literal(String.valueOf(this.value) + "/" + String.valueOf(this.maxValue)), 19, 30, a.f, false);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiRareEarthRecipe$RareData.class */
    public static final class RareData extends Record {
        private final ItemStack itemStack;
        private final float amount;

        public RareData(ItemStack itemStack, float f) {
            this.itemStack = itemStack;
            this.amount = f;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, RareData.class), RareData.class, "itemStack;amount", "FIELD:Lmctech/integration/emi/plugin/core/recipe/EmiRareEarthRecipe$RareData;->itemStack:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/EmiRareEarthRecipe$RareData;->amount:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, RareData.class), RareData.class, "itemStack;amount", "FIELD:Lmctech/integration/emi/plugin/core/recipe/EmiRareEarthRecipe$RareData;->itemStack:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/EmiRareEarthRecipe$RareData;->amount:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, RareData.class, Object.class), RareData.class, "itemStack;amount", "FIELD:Lmctech/integration/emi/plugin/core/recipe/EmiRareEarthRecipe$RareData;->itemStack:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/EmiRareEarthRecipe$RareData;->amount:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack itemStack() {
            return this.itemStack;
        }

        public float amount() {
            return this.amount;
        }
    }
}
