package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.components.a.C0101n;
import mctech.i.i;
import mctech.integration.emi.plugin.core.EMIPlugin;
import mctech.integration.emi.plugin.core.widget.AnimatedTextureWidgetRotatable;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EMIQuantumGeneratorRecipe.class */
public class EMIQuantumGeneratorRecipe implements EmiRecipe {
    private static final ResourceLocation PRODUCING_ITEM = ResourceLocation.fromNamespaceAndPath("kubejs", "singularity_ingot");
    private static final int MAX_PROGRESS = 19200;
    private static final int ENERGY_PRODUCTION = 131072;
    private static final int PACKET_COUNT = 32;
    private final ResourceLocation id = EMIPlugin.synthetic(i.QUANTUM_GENERATOR.getSerializedName(), "quantum_generator");
    private final EmiRecipeCategory category;

    public EMIQuantumGeneratorRecipe(EmiRecipeCategory emiRecipeCategory) {
        this.category = emiRecipeCategory;
    }

    private ItemStack getOutputStack() {
        if (!BuiltInRegistries.ITEM.containsKey(PRODUCING_ITEM)) {
            return ItemStack.EMPTY;
        }
        return new ItemStack((ItemLike) BuiltInRegistries.ITEM.get(PRODUCING_ITEM));
    }

    public EmiRecipeCategory getCategory() {
        return this.category;
    }

    @Nullable
    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return List.of();
    }

    public List<EmiStack> getOutputs() {
        ItemStack outputStack = getOutputStack();
        return outputStack.isEmpty() ? List.of() : List.of(EmiStack.of(outputStack));
    }

    public int getDisplayWidth() {
        return 40;
    }

    public int getDisplayHeight() {
        return 24;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.add(new AnimatedTextureWidgetRotatable(C0101n.a.a(), 2, 2, 14, 17, 0, 179, 1600, false, false, false).rotation(-90.0f));
        List<EmiStack> outputs = getOutputs();
        if (!outputs.isEmpty()) {
            widgetHolder.addSlot((EmiIngredient) outputs.getFirst(), 4 + 17, 2).recipeContext(this);
        }
        widgetHolder.addTooltipText(List.of(Component.literal(String.format("1 шт. каждые %s сек", Float.valueOf(960.0f))), Component.literal(String.format("%s EU/t", 4194304))), 2, 2, 17, 17);
    }
}
