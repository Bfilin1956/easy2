package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.stack.FluidEmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.r.a.d;
import mctech.u.A;
import mctech.u.AbstractC0179g;
import mctech.u.C;
import mctech.u.C0183k;
import mctech.u.C0185m;
import mctech.u.M;
import mctech.u.N;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiCustomRecipe.class */
public class EmiCustomRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiRecipeCategory category;
    private final EmiIngredient input;
    private final EmiIngredient inputFluid;
    private final EmiStack output0;
    private final EmiStack output1;
    private final EmiStack output2;
    private final EmiIngredient outputFluid;
    private final d recipe;

    public EmiCustomRecipe(AbstractC0179g abstractC0179g, EmiRecipeCategory emiRecipeCategory) {
        this.id = EmiPort.getId(abstractC0179g);
        this.category = emiRecipeCategory;
        this.input = EmiIngredient.of((Ingredient) abstractC0179g.getIngredients().get(0), abstractC0179g.a());
        this.inputFluid = (abstractC0179g.e() == null || abstractC0179g.e().isEmpty()) ? EmiStack.EMPTY : FluidEmiStack.of(abstractC0179g.e().getStacks()[0].getFluid(), abstractC0179g.g());
        this.output0 = EmiStack.of(abstractC0179g.b());
        this.output1 = EmiStack.of(abstractC0179g.c());
        this.output2 = EmiStack.of(abstractC0179g.d());
        this.outputFluid = (abstractC0179g.f() == null || abstractC0179g.f().isEmpty()) ? EmiStack.EMPTY : FluidEmiStack.of(abstractC0179g.f().getFluid(), abstractC0179g.f().getAmount());
        this.recipe = getType(abstractC0179g);
    }

    private static d getType(AbstractC0179g abstractC0179g) {
        if (abstractC0179g instanceof N) {
            return d.ORE_MACERATOR;
        }
        if (abstractC0179g instanceof M) {
            return d.ORE_COMBINE;
        }
        if (abstractC0179g instanceof C) {
            return d.INGOT_FOUNDRY;
        }
        if (abstractC0179g instanceof C0185m) {
            return d.CONCENTRATOR;
        }
        if (abstractC0179g instanceof A) {
            return d.HYDRAULIC_WASHER;
        }
        if (abstractC0179g instanceof C0183k) {
            return d.CHEMICAL_PURIFICATING;
        }
        return d.ORE_MACERATOR;
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
        return List.of(this.output0, this.output1, this.output2);
    }

    public int getDisplayWidth() {
        switch (this.recipe) {
            case CHEMICAL_PURIFICATING:
            case CONCENTRATOR:
                return 104;
            case HYDRAULIC_WASHER:
                return 122;
            default:
                return 82;
        }
    }

    public int getDisplayHeight() {
        switch (this.recipe) {
            case CHEMICAL_PURIFICATING:
            case HYDRAULIC_WASHER:
            case INGOT_FOUNDRY:
                return 38;
            case CONCENTRATOR:
            case ORE_MACERATOR:
                return 41;
            default:
                return 62;
        }
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        switch (this.recipe) {
            case CHEMICAL_PURIFICATING:
                widgetHolder.addSlot(this.input, 25, 9);
                widgetHolder.addSlot(this.inputFluid, 5, 9);
                widgetHolder.addSlot(this.output0, 81, 9).recipeContext(this);
                widgetHolder.addFillingArrow(50, 10, 1600);
                break;
            case CONCENTRATOR:
                widgetHolder.addSlot(this.input, 25, 12);
                widgetHolder.addSlot(this.inputFluid, 5, 12);
                widgetHolder.addSlot(this.output0, 81, 2).recipeContext(this);
                widgetHolder.addSlot(this.output1, 81, 22).recipeContext(this);
                widgetHolder.addFillingArrow(50, 13, 1600);
                break;
            case HYDRAULIC_WASHER:
                widgetHolder.addSlot(this.input, 25, 9);
                widgetHolder.addSlot(this.inputFluid, 5, 9);
                widgetHolder.addSlot(this.output0, 81, 9).recipeContext(this);
                widgetHolder.addSlot(this.outputFluid, 101, 9);
                widgetHolder.addFillingArrow(50, 10, 1600);
                break;
            case INGOT_FOUNDRY:
                widgetHolder.addSlot(this.input, 4, 9);
                widgetHolder.addSlot(this.output0, 60, 9).recipeContext(this);
                widgetHolder.addFillingArrow(29, 10, 1600);
                break;
            case ORE_MACERATOR:
                widgetHolder.addSlot(this.input, 4, 12);
                widgetHolder.addSlot(this.output0, 60, 2).recipeContext(this);
                widgetHolder.addSlot(this.output1, 60, 22).recipeContext(this);
                widgetHolder.addFillingArrow(29, 13, 1600);
                break;
            case ORE_COMBINE:
                widgetHolder.addSlot(this.input, 4, 22);
                widgetHolder.addSlot(this.output0, 60, 2).recipeContext(this);
                widgetHolder.addSlot(this.output1, 60, 22).recipeContext(this);
                widgetHolder.addSlot(this.output2, 60, 42).recipeContext(this);
                widgetHolder.addFillingArrow(29, 22, 1600);
                break;
            default:
                widgetHolder.addSlot(this.input, 4, 22);
                widgetHolder.addSlot(this.output0, 60, 2).recipeContext(this);
                widgetHolder.addSlot(this.output1, 60, 22).recipeContext(this);
                widgetHolder.addSlot(this.output2, 60, 42).recipeContext(this);
                widgetHolder.addFillingArrow(29, 22, 1600);
                break;
        }
    }

    public static void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
