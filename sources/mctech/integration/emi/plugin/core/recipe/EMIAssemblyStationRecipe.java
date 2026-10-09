package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.neoforge.NeoForgeEmiIngredient;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.SlotWidget;
import dev.emi.emi.api.widget.WidgetHolder;
import dev.emi.emi.runtime.EmiDrawContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mctech.MCTech;
import mctech.components.a.C0101n;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.core.widget.EmiRecipeBackground;
import mctech.integration.emi.plugin.core.widget.TexturedBackground;
import mctech.items.b.c;
import mctech.u.C0172d;
import mctech.utils.c.h;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EMIAssemblyStationRecipe.class */
public class EMIAssemblyStationRecipe implements EmiRecipe, EmiRecipeBackground {
    private static final ResourceLocation BACKGROUND = MCTech.loc("textures/gui/emi/assembly_station_emi.png");
    private final ResourceLocation id;
    private final EmiRecipeCategory category;
    private final C0172d recipe;

    public EMIAssemblyStationRecipe(EmiRecipeCategory emiRecipeCategory, C0172d c0172d) {
        this.category = emiRecipeCategory;
        this.id = EmiPort.getId(c0172d);
        this.recipe = c0172d;
    }

    public C0172d getRecipe() {
        return this.recipe;
    }

    public EmiRecipeCategory getCategory() {
        return this.category;
    }

    @Nullable
    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiStack> getOutputs() {
        return List.of(EmiStack.of(this.recipe.n()));
    }

    public int getDisplayWidth() {
        return 199;
    }

    public int getDisplayHeight() {
        return 116;
    }

    public List<EmiIngredient> getInputs() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.recipe.l().stream().map(itemStack -> {
            return EmiIngredient.of(Ingredient.of(new ItemStack[]{itemStack}));
        }).toList());
        arrayList.addAll(this.recipe.d().stream().map(fluidStack -> {
            return NeoForgeEmiIngredient.of(SizedFluidIngredient.of(fluidStack.getFluid(), fluidStack.getAmount()));
        }).toList());
        arrayList.addAll(this.recipe.e().stream().map(str -> {
            return ResourceLocation.bySeparator(str, ':');
        }).filter(resourceLocation -> {
            return c.a().b(resourceLocation);
        }).map(resourceLocation2 -> {
            return c.a().a(resourceLocation2);
        }).map(aVar -> {
            return EmiIngredient.of(aVar.c());
        }).toList());
        return arrayList;
    }

    private void addFluid(FluidStack fluidStack, int i, WidgetHolder widgetHolder) {
        widgetHolder.addTank(NeoForgeEmiIngredient.of(SizedFluidIngredient.of(fluidStack)), i, 10, 18, 60, 1000).drawBack(false);
        widgetHolder.addTexture(C0101n.a.a(), i, 10, 18, 60, 90, 196, 18, 60, h.i, h.i);
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        new TexturedBackground(BACKGROUND, getDisplayWidth(), getDisplayHeight()).apply(widgetHolder);
        if (this.recipe.m()) {
            List<ItemStack> listC = this.recipe.c();
            for (int i = 0; i < listC.size(); i++) {
                int i2 = i % 4;
                int i3 = i / 4;
                if (i2 == 0) {
                    widgetHolder.add(new SlotWidget(EmiStack.of(listC.get(i)), 56, 9 + (22 * i3)).drawBack(false));
                } else {
                    widgetHolder.add(new SlotWidget(EmiStack.of(listC.get(i)), 74 + (i2 * 19), 12 + (i3 * 19)).drawBack(false));
                }
            }
        } else {
            Map<String, ItemStack> mapA = this.recipe.a();
            List<String> listB = this.recipe.b();
            for (int i4 = 0; i4 < this.recipe.j(); i4++) {
                for (int i5 = 0; i5 < this.recipe.k(); i5++) {
                    char cCharAt = listB.get(i5).charAt(i4);
                    if (cCharAt != ' ') {
                        if (i4 == 0) {
                            widgetHolder.add(new SlotWidget(EmiStack.of(mapA.get(String.valueOf(cCharAt))), 56, 9 + (22 * i5)).drawBack(false));
                        } else {
                            widgetHolder.add(new SlotWidget(EmiStack.of(mapA.get(String.valueOf(cCharAt))), 74 + (i4 * 19), 12 + (i5 * 19)).drawBack(false));
                        }
                    }
                }
            }
        }
        List<FluidStack> listD = this.recipe.d();
        for (int i6 = 0; i6 < listD.size(); i6++) {
            addFluid(listD.get(i6), 11 + (i6 * 23), widgetHolder);
        }
        c cVarA = c.a();
        List<String> listE = this.recipe.e();
        for (int i7 = 0; i7 < listE.size(); i7++) {
            String str = listE.get(i7);
            ResourceLocation resourceLocationBySeparator = ResourceLocation.bySeparator(str, ':');
            if (cVarA.b(resourceLocationBySeparator)) {
                c.a aVarA = cVarA.a(resourceLocationBySeparator);
                if (aVarA != null) {
                    widgetHolder.addSlot(EmiIngredient.of(aVarA.b().stream().map((v1) -> {
                        return new ItemStack(v1);
                    }).filter(itemStack -> {
                        return !itemStack.isEmpty();
                    }).map(EmiStack::of).toList()), 10 + (i7 * 23), 86).drawBack(false).appendTooltip(MCTechLang.EMI_ASSEMBLY_STATION_CONSUMABLES_TOOLTIP);
                }
            } else {
                widgetHolder.add(new SlotWidget(EmiStack.of(Items.BARRIER), 10 + (i7 * 23), 86).drawBack(false).appendTooltip(Component.literal("Категория ").append(Component.literal(str).withStyle(new ChatFormatting[]{ChatFormatting.BOLD, ChatFormatting.YELLOW, ChatFormatting.UNDERLINE})).append(Component.literal(" ОТСУТСТВУЕТ!").withStyle(ChatFormatting.RED))));
            }
        }
        if (8 - this.recipe.e().size() > 0) {
            for (int size = this.recipe.e().size(); size < 9 - this.recipe.e().size(); size++) {
                widgetHolder.addSlot(10 + (size * 23), 86).drawBack(false);
                widgetHolder.addTooltipText(List.of(MCTechLang.EMI_ASSEMBLY_STATION_CONSUMABLES_TOOLTIP), 10 + (size * 23), 86, 18, 18);
            }
        }
        widgetHolder.addSlot(EmiIngredient.of(List.of(EmiStack.of(this.recipe.n()))), 172, 31).drawBack(false).recipeContext(this);
        widgetHolder.addTooltipText(List.of(this.recipe.m() ? MCTechLang.EMI_ASSEMBLY_STATION_SHAPELESS_RECIPE_TOOLTIP.withStyle(ChatFormatting.AQUA) : MCTechLang.EMI_ASSEMBLY_STATION_SHAPED_RECIPE_TOOLTIP.withStyle(ChatFormatting.AQUA), mctech.g.d.e.h.a(MCTechLang.EMI_ASSEMBLY_STATION_TIME_CONSUME_TOOLTIP, Float.valueOf(this.recipe.g() / 20.0f)), mctech.g.d.e.h.a(MCTechLang.EMI_ASSEMBLY_STATION_ENERGY_CONSUME_TOOLTIP, Integer.valueOf(this.recipe.f()))), 153, 31, 17, 14);
    }

    public static void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }

    @Override // mctech.integration.emi.plugin.core.widget.EmiRecipeBackground
    public void renderRecipeBackground(EmiRecipe emiRecipe, EmiDrawContext emiDrawContext, int i, int i2) {
        draw(BACKGROUND, emiRecipe, emiDrawContext, i, i2);
    }
}
