package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.neoforge.NeoForgeEmiIngredient;
import dev.emi.emi.api.neoforge.NeoForgeEmiStack;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.SlotWidget;
import dev.emi.emi.api.widget.WidgetHolder;
import dev.emi.emi.runtime.EmiDrawContext;
import java.util.ArrayList;
import java.util.List;
import mctech.MCTech;
import mctech.api.items.Consumables;
import mctech.blockentities.b.k;
import mctech.components.a.C0101n;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.core.widget.AnimatedTextureWidgetRotatable;
import mctech.integration.emi.plugin.core.widget.EmiRecipeBackground;
import mctech.integration.emi.plugin.core.widget.TexturedBackground;
import mctech.u.C0177e;
import mctech.utils.c.h;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EMIAtomicSmelterRecipe.class */
public class EMIAtomicSmelterRecipe implements EmiRecipe, EmiRecipeBackground {
    public static final ResourceLocation BACKGROUND = MCTech.loc("textures/gui/emi/atomic_smelter_emi.png");
    private final ResourceLocation id;
    private final EmiRecipeCategory category;
    private final C0177e recipe;

    public EMIAtomicSmelterRecipe(EmiRecipeCategory emiRecipeCategory, C0177e c0177e) {
        this.category = emiRecipeCategory;
        this.id = EmiPort.getId(c0177e);
        this.recipe = c0177e;
    }

    public EmiRecipeCategory getCategory() {
        return this.category;
    }

    @Nullable
    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiStack> getOutputs() {
        return List.of(NeoForgeEmiStack.of(new FluidStack(this.recipe.d().getFluid(), this.recipe.d().getAmount())));
    }

    public int getDisplayWidth() {
        return 137;
    }

    public int getDisplayHeight() {
        return 123;
    }

    public List<EmiIngredient> getInputs() {
        ArrayList arrayList = new ArrayList(this.recipe.a().stream().map(itemStack -> {
            return EmiIngredient.of(Ingredient.of(new ItemStack[]{itemStack}));
        }).toList());
        arrayList.add(NeoForgeEmiIngredient.of(SizedFluidIngredient.of(this.recipe.b().getFluid(), this.recipe.b().getAmount())));
        return arrayList;
    }

    private void addFluid(FluidStack fluidStack, int i, WidgetHolder widgetHolder, boolean z) {
        SlotWidget slotWidgetDrawBack = widgetHolder.addTank(NeoForgeEmiIngredient.of(SizedFluidIngredient.of(fluidStack)), i, 11, 18, 60, 1000).drawBack(false);
        if (z) {
            slotWidgetDrawBack.recipeContext(this);
        }
        widgetHolder.addTexture(C0101n.a.a(), i, 11, 18, 60, 90, 196, 18, 60, h.i, h.i);
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        new TexturedBackground(BACKGROUND, getDisplayWidth(), getDisplayHeight()).apply(widgetHolder);
        addFluid(this.recipe.b(), 38, widgetHolder, false);
        addFluid(this.recipe.d(), 108, widgetHolder, true);
        for (int i = 0; i < this.recipe.a().size(); i++) {
            widgetHolder.addSlot(EmiStack.of(this.recipe.a().get(i)), 12, 10 + (46 * i)).drawBack(false);
            if (i > 1) {
                break;
            }
        }
        widgetHolder.addSlot(EmiIngredient.of(Consumables.FUEL.getCategory().b().stream().map((v1) -> {
            return new ItemStack(v1);
        }).map(EmiStack::of).toList()), 34, 82).drawBack(false).appendTooltip(MCTechLang.EMI_ASSEMBLY_STATION_CONSUMABLES_TOOLTIP);
        widgetHolder.addSlot(EmiIngredient.of(Consumables.CATALYST.getCategory().b().stream().map((v1) -> {
            return new ItemStack(v1);
        }).map(EmiStack::of).toList()), 59, 82).drawBack(false).appendTooltip(MCTechLang.EMI_ASSEMBLY_STATION_CONSUMABLES_TOOLTIP);
        widgetHolder.add(new AnimatedTextureWidgetRotatable(BACKGROUND, 57, 19, 49, 44, 3, 123, 45, 44, h.i, h.i, k.i, true, false, false));
    }

    public static void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }

    @Override // mctech.integration.emi.plugin.core.widget.EmiRecipeBackground
    public void renderRecipeBackground(EmiRecipe emiRecipe, EmiDrawContext emiDrawContext, int i, int i2) {
        draw(BACKGROUND, emiRecipe, emiDrawContext, i, i2);
    }
}
