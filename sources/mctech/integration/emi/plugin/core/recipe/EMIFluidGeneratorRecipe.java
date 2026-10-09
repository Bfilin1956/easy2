package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.api.neoforge.NeoForgeEmiStack;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import mctech.components.a.C0101n;
import mctech.i.c;
import mctech.i.i;
import mctech.integration.emi.plugin.core.EMIPlugin;
import mctech.integration.emi.plugin.core.widget.AnimatedTextureWidgetRotatable;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EMIFluidGeneratorRecipe.class */
public class EMIFluidGeneratorRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiRecipeCategory category;
    private final c fluidType;
    private final MachineTier machineTier;

    public EMIFluidGeneratorRecipe(EmiRecipeCategory emiRecipeCategory, c cVar, MachineTier machineTier) {
        String str = String.format("%s_%s_generator", machineTier.name, cVar.getSerializedName());
        this.fluidType = cVar;
        this.machineTier = machineTier;
        this.category = emiRecipeCategory;
        this.id = EMIPlugin.synthetic(i.FLUID_GENERATOR.getSerializedName(), str);
    }

    public EmiRecipeCategory getCategory() {
        return this.category;
    }

    @Nullable
    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return this.fluidType == c.LAVA ? List.of(EmiIngredient.of(Ingredient.fromValues(Stream.of((Object[]) new Ingredient.TagValue[]{new Ingredient.TagValue(Tags.Items.STONES), new Ingredient.TagValue(Tags.Items.COBBLESTONES)})))) : List.of();
    }

    public List<EmiStack> getOutputs() {
        return List.of(NeoForgeEmiStack.of(new FluidStack(this.fluidType.a(), (this.fluidType == c.WATER ? mctech.h.a.c.a.get(this.machineTier) : mctech.h.a.c.b.get(this.machineTier)).b)));
    }

    public int getDisplayWidth() {
        return 132;
    }

    public int getDisplayHeight() {
        return 32;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        mctech.h.a.c.g gVar = this.fluidType == c.WATER ? mctech.h.a.c.a.get(this.machineTier) : mctech.h.a.c.b.get(this.machineTier);
        int displayWidth = getDisplayWidth() / 2;
        List<EmiIngredient> inputs = getInputs();
        if (this.fluidType == c.LAVA) {
            widgetHolder.addSlot(inputs.get(new Random().nextInt(inputs.size())), (displayWidth - 17) - (4 * 2), getDisplayHeight() - 24);
        }
        widgetHolder.add(new AnimatedTextureWidgetRotatable(C0101n.a.a(), displayWidth, (getDisplayHeight() / 2) - 7, 14, 17, 0, 179, 1600, false, false, false).rotation(-90.0f));
        widgetHolder.addSlot((EmiIngredient) getOutputs().getFirst(), displayWidth + 17, (getDisplayHeight() / 2) - 8).recipeContext(this);
        widgetHolder.addTooltipText(List.of(Component.literal(String.format("%s мВ каждые %s сек", Integer.valueOf(gVar.b), Float.valueOf(gVar.c / 20.0f)))), displayWidth - 6, (getDisplayHeight() / 2) - (17 / 2), 17, 17);
    }

    public static void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
