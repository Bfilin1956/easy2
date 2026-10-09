package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.api.neoforge.NeoForgeEmiIngredient;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.MCTech;
import mctech.components.a.C0101n;
import mctech.h.a.c;
import mctech.i.i;
import mctech.integration.emi.plugin.core.EMIPlugin;
import mctech.integration.emi.plugin.core.widget.AnimatedTextureWidgetRotatable;
import mctech.integration.emi.plugin.core.widget.CustomBackground;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EMICobblestoneGeneratorRecipe.class */
public class EMICobblestoneGeneratorRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiRecipeCategory category;
    private final MachineTier machineTier;

    public EMICobblestoneGeneratorRecipe(EmiRecipeCategory emiRecipeCategory, MachineTier machineTier) {
        String str = String.format("%s_cobblestone_generator", machineTier.name);
        this.machineTier = machineTier;
        this.category = emiRecipeCategory;
        this.id = EMIPlugin.synthetic(i.COBBLESTONE_GENERATOR.getSerializedName(), str);
    }

    public EmiRecipeCategory getCategory() {
        return this.category;
    }

    @Nullable
    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        c.C0020c c0020c = c.c.get(this.machineTier);
        return List.of(NeoForgeEmiIngredient.of(SizedFluidIngredient.of(new FluidStack(Fluids.WATER, c0020c.a))), NeoForgeEmiIngredient.of(SizedFluidIngredient.of(new FluidStack(Fluids.LAVA, c0020c.b))));
    }

    public List<EmiStack> getOutputs() {
        return List.of(EmiStack.of(new ItemStack(Items.COBBLESTONE, c.c.get(this.machineTier).f)));
    }

    public int getDisplayWidth() {
        return 132;
    }

    public int getDisplayHeight() {
        return 32;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        new CustomBackground(MCTech.loc("textures/gui/emi/emi_background.png"), -16, 0, getDisplayWidth() + 16, getDisplayHeight()).apply(widgetHolder);
        int displayWidth = (-16) + (getDisplayWidth() / 2);
        List<EmiIngredient> inputs = getInputs();
        for (int i = 0; i < inputs.size(); i++) {
            widgetHolder.addSlot(inputs.get(i), ((displayWidth - 17) - (4 * 2)) - (16 * i), (getDisplayHeight() / 2) - 8);
        }
        widgetHolder.add(new AnimatedTextureWidgetRotatable(C0101n.a.a(), displayWidth, (getDisplayHeight() / 2) - 7, 14, 17, this.machineTier.ordinal() * 14, 179, 1600, false, false, false).rotation(-90.0f));
        widgetHolder.addSlot((EmiIngredient) getOutputs().getFirst(), displayWidth + 17, (getDisplayHeight() / 2) - 8).recipeContext(this);
    }

    public static void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
