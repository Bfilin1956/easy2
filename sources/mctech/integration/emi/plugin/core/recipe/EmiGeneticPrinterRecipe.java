package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.SlotWidget;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import mctech.k.b;
import mctech.u.C0195w;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiGeneticPrinterRecipe.class */
public class EmiGeneticPrinterRecipe implements EmiRecipe {
    private final EmiRecipeCategory recipeCategory;
    private final ResourceLocation id;
    private final List<SlotWidget> outputs = new ArrayList();
    private final EntityType<? extends LivingEntity> entityType;

    public EmiGeneticPrinterRecipe(EmiRecipeCategory emiRecipeCategory, C0195w c0195w) {
        this.recipeCategory = emiRecipeCategory;
        this.id = EmiPort.getId(c0195w);
        this.entityType = (EntityType) BuiltInRegistries.ENTITY_TYPE.getOptional(c0195w.b()).orElse(null);
        int i = 0;
        for (int i2 = 0; i2 < c0195w.c().size(); i2++) {
            C0195w.b bVar = c0195w.c().get(i2);
            if (bVar.a()) {
                this.outputs.add(new SlotWidget(EmiStack.of(bVar.c().copyWithCount(bVar.d())), 94 + ((i % 3) * 20), 2 + ((i / 3) * 20)).appendTooltip(luckTooltip(bVar.d(), 1)).appendTooltip(luckTooltip(bVar.d(), 25)).appendTooltip(luckTooltip(bVar.d(), 50)).appendTooltip(luckTooltip(bVar.d(), 75)).appendTooltip(luckTooltip(bVar.d(), 100)).recipeContext(this));
                i++;
            }
        }
    }

    private static Component luckTooltip(int i, int i2) {
        return Component.literal(String.format("При %s уровне удачи: ", Integer.valueOf(i2))).append(Component.literal(String.format("%s шт", Integer.valueOf(b.a(i, i2)))).withStyle(ChatFormatting.GOLD)).append(Component.literal(String.format(" (x%.0f)", Float.valueOf(b.a(i2)))).withStyle(ChatFormatting.DARK_GREEN));
    }

    public EmiRecipeCategory getCategory() {
        return this.recipeCategory;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return List.of();
    }

    public List<EmiStack> getOutputs() {
        return this.outputs.stream().map(slotWidget -> {
            return slotWidget.getStack();
        }).toList();
    }

    public int getDisplayWidth() {
        return 156;
    }

    public int getDisplayHeight() {
        return 62;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addText(Component.translatable(this.entityType.getDescriptionId()), 2, 6, -12566464, false);
        widgetHolder.addFillingArrow(65, 2, 1600);
        List<SlotWidget> list = this.outputs;
        Objects.requireNonNull(widgetHolder);
        list.forEach((v1) -> {
            r1.add(v1);
        });
    }
}
