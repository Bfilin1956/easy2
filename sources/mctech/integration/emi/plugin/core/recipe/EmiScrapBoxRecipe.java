package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.SlotWidget;
import dev.emi.emi.api.widget.WidgetHolder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mctech.init.MCTechItems;
import mctech.integration.emi.plugin.core.EMIRecipeCategory;
import mctech.u.Y;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiScrapBoxRecipe.class */
public class EmiScrapBoxRecipe implements EmiRecipe {
    private static final Comparator<SlotChance> CHANCE_SORTER = new Comparator<SlotChance>() { // from class: mctech.integration.emi.plugin.core.recipe.EmiScrapBoxRecipe.1
        @Override // java.util.Comparator
        public int compare(SlotChance slotChance, SlotChance slotChance2) {
            return Float.compare(slotChance2.chance.floatValue(), slotChance.chance.floatValue());
        }
    };
    private final List<SlotChance> output = new ArrayList();
    private final ResourceLocation id = ResourceLocation.parse("mctech:use/scrapbox");
    private final EmiIngredient input = EmiIngredient.of(Ingredient.of(new ItemLike[]{MCTechItems.SCRAPBOX}));

    public EmiScrapBoxRecipe(Iterable<Y> iterable) {
        iterable.forEach(y -> {
            this.output.add(new SlotChance(EmiStack.of(y.b()), Float.valueOf(y.a())));
        });
        this.output.sort(CHANCE_SORTER);
    }

    public EmiRecipeCategory getCategory() {
        return EMIRecipeCategory.SCRAP_BOX;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return List.of(this.input);
    }

    public List<EmiStack> getOutputs() {
        return this.output.stream().map(slotChance -> {
            return slotChance.stack;
        }).toList();
    }

    public int getDisplayWidth() {
        return 144;
    }

    public int getDisplayHeight() {
        return 80;
    }

    public void addWidgets(WidgetHolder widgetHolder) {
        widgetHolder.addSlot(this.input, 63, 0);
        int height = (widgetHolder.getHeight() - 42) / 18;
        int i = (height + 1) * 8;
        PageManager pageManager = new PageManager(this, this.output, i);
        if (i < this.output.size()) {
            widgetHolder.addButton(2, 2, 12, 12, 0, 0, () -> {
                return true;
            }, (d, d2, i2) -> {
                pageManager.scroll(-1);
            });
            widgetHolder.addButton(widgetHolder.getWidth() - 14, 2, 12, 12, 12, 0, () -> {
                return true;
            }, (d3, d4, i3) -> {
                pageManager.scroll(1);
            });
        }
        for (int i4 = 0; i4 < this.output.size() && i4 / 8 <= height; i4++) {
            widgetHolder.add(new PageSlotWidget(this, pageManager, i4, (i4 % 8) * 18, ((i4 / 8) * 18) + 24));
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiScrapBoxRecipe$PageManager.class */
    private class PageManager {
        public final List<SlotChance> stacks;
        public final int pageSize;
        public int currentPage;

        public PageManager(EmiScrapBoxRecipe emiScrapBoxRecipe, List<SlotChance> list, int i) {
            this.stacks = list;
            this.pageSize = i;
        }

        public void scroll(int i) {
            this.currentPage += i;
            int size = ((this.stacks.size() - 1) / this.pageSize) + 1;
            if (this.currentPage < 0) {
                this.currentPage = size - 1;
            }
            if (this.currentPage >= size) {
                this.currentPage = 0;
            }
        }

        public EmiStack getStack(int i) {
            int i2 = i + (this.pageSize * this.currentPage);
            if (i2 < this.stacks.size()) {
                return this.stacks.get(i2).stack;
            }
            return EmiStack.EMPTY;
        }

        public float getChance(int i) {
            int i2 = i + (this.pageSize * this.currentPage);
            if (i2 < this.stacks.size()) {
                return this.stacks.get(i2).chance.floatValue();
            }
            return 0.0f;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiScrapBoxRecipe$PageSlotWidget.class */
    private class PageSlotWidget extends SlotWidget {
        public final PageManager manager;
        public final int offset;

        public PageSlotWidget(EmiScrapBoxRecipe emiScrapBoxRecipe, PageManager pageManager, int i, int i2, int i3) {
            super(EmiStack.EMPTY, i2, i3);
            this.manager = pageManager;
            this.offset = i;
        }

        public EmiIngredient getStack() {
            return this.manager.getStack(this.offset);
        }

        protected void addSlotTooltip(List<ClientTooltipComponent> list) {
            super.addSlotTooltip(list);
            list.add(ClientTooltipComponent.create(Component.literal("Шанс: " + this.manager.getChance(this.offset) + "%").getVisualOrderText()));
        }

        public void render(GuiGraphics guiGraphics, int i, int i2, float f) {
            if (!getStack().isEmpty()) {
                super.render(guiGraphics, i, i2, f);
            }
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EmiScrapBoxRecipe$SlotChance.class */
    private static final class SlotChance extends Record {
        private final EmiStack stack;
        private final Float chance;

        private SlotChance(EmiStack emiStack, Float f) {
            this.stack = emiStack;
            this.chance = f;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, SlotChance.class), SlotChance.class, "stack;chance", "FIELD:Lmctech/integration/emi/plugin/core/recipe/EmiScrapBoxRecipe$SlotChance;->stack:Ldev/emi/emi/api/stack/EmiStack;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/EmiScrapBoxRecipe$SlotChance;->chance:Ljava/lang/Float;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, SlotChance.class), SlotChance.class, "stack;chance", "FIELD:Lmctech/integration/emi/plugin/core/recipe/EmiScrapBoxRecipe$SlotChance;->stack:Ldev/emi/emi/api/stack/EmiStack;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/EmiScrapBoxRecipe$SlotChance;->chance:Ljava/lang/Float;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, SlotChance.class, Object.class), SlotChance.class, "stack;chance", "FIELD:Lmctech/integration/emi/plugin/core/recipe/EmiScrapBoxRecipe$SlotChance;->stack:Ldev/emi/emi/api/stack/EmiStack;", "FIELD:Lmctech/integration/emi/plugin/core/recipe/EmiScrapBoxRecipe$SlotChance;->chance:Ljava/lang/Float;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public EmiStack stack() {
            return this.stack;
        }

        public Float chance() {
            return this.chance;
        }
    }
}
