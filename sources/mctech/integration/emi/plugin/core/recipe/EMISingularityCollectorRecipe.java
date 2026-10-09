package mctech.integration.emi.plugin.core.recipe;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import mctech.components.a.C0101n;
import mctech.integration.emi.plugin.core.EMIPlugin;
import mctech.integration.emi.plugin.core.widget.AnimatedTextureWidgetRotatable;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EMISingularityCollectorRecipe.class */
public class EMISingularityCollectorRecipe implements EmiRecipe {
    private static final String CATEGORY = "singularity_collector";
    private final ResourceLocation id;
    private final EmiRecipeCategory category;
    private final MachineTier machineTier;
    private final int ticksPerItem;
    private final ResourceLocation producingItem;

    public EMISingularityCollectorRecipe(EmiRecipeCategory emiRecipeCategory, MachineTier machineTier) {
        this.category = emiRecipeCategory;
        this.machineTier = machineTier;
        this.ticksPerItem = ticksPerItemFor(machineTier);
        this.producingItem = producingItemFor(machineTier);
        this.id = EMIPlugin.synthetic(CATEGORY, machineTier.name + "_singularity_collector");
    }

    /* JADX INFO: renamed from: mctech.integration.emi.plugin.core.recipe.EMISingularityCollectorRecipe$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipe/EMISingularityCollectorRecipe$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$mcskill$msregistry$core$MachineTier = new int[MachineTier.values().length];

        static {
            try {
                $SwitchMap$net$mcskill$msregistry$core$MachineTier[MachineTier.T3.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$mcskill$msregistry$core$MachineTier[MachineTier.T4.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$mcskill$msregistry$core$MachineTier[MachineTier.T5.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$net$mcskill$msregistry$core$MachineTier[MachineTier.T6.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$net$mcskill$msregistry$core$MachineTier[MachineTier.T7.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private static int ticksPerItemFor(MachineTier machineTier) {
        switch (AnonymousClass1.$SwitchMap$net$mcskill$msregistry$core$MachineTier[machineTier.ordinal()]) {
            case 1:
                return 1200;
            case 2:
                return 2400;
            case 3:
                return 4800;
            case 4:
                return 9600;
            case 5:
                return 19200;
            default:
                throw new IllegalStateException("Unsupported Singularity Collector tier: " + String.valueOf(machineTier));
        }
    }

    private static ResourceLocation producingItemFor(MachineTier machineTier) {
        switch (AnonymousClass1.$SwitchMap$net$mcskill$msregistry$core$MachineTier[machineTier.ordinal()]) {
            case 1:
                return ResourceLocation.fromNamespaceAndPath("kubejs", "singularity_crumb");
            case 2:
                return ResourceLocation.fromNamespaceAndPath("kubejs", "singularity_pile");
            case 3:
                return ResourceLocation.fromNamespaceAndPath("kubejs", "singularity_dust");
            case 4:
                return ResourceLocation.fromNamespaceAndPath("kubejs", "singularity_nugget");
            case 5:
                return ResourceLocation.fromNamespaceAndPath("kubejs", "singularity_fragment");
            default:
                throw new IllegalStateException("Unsupported Singularity Collector tier: " + String.valueOf(machineTier));
        }
    }

    private ItemStack getOutputStack() {
        if (!BuiltInRegistries.ITEM.containsKey(this.producingItem)) {
            return ItemStack.EMPTY;
        }
        return new ItemStack((ItemLike) BuiltInRegistries.ITEM.get(this.producingItem));
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
        int displayWidth = getDisplayWidth() / 2;
        widgetHolder.add(new AnimatedTextureWidgetRotatable(C0101n.a.a(), 2, 2, 14, 17, this.machineTier.ordinal() * 14, 179, 1600, false, false, false).rotation(-90.0f));
        List<EmiStack> outputs = getOutputs();
        if (!outputs.isEmpty()) {
            widgetHolder.addSlot((EmiIngredient) outputs.getFirst(), 4 + 17, 2).recipeContext(this);
        }
        widgetHolder.addTooltipText(List.of(Component.literal(String.format("1 шт. каждые %s сек", Float.valueOf(this.ticksPerItem / 20.0f)))), 2, 2, 17, 17);
    }
}
