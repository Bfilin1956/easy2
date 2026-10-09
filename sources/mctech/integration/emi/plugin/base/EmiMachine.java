package mctech.integration.emi.plugin.base;

import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.recipe.EmiRecipeSorting;
import dev.emi.emi.api.stack.EmiStack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.blocks.base.blocks.a;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.mcskill.msregistry.registry.holder.LBlock;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/base/EmiMachine.class */
public class EmiMachine<RI extends RecipeInput, R extends Recipe<RI>, B extends Block, ER extends EmiRecipe, EC extends EmiRecipeCategory> {
    public static final Comparator<EmiRecipe> MACHINE_TIER_SORTING = Comparator.comparing(emiRecipe -> {
        return emiRecipe.getCategory().getName().getString();
    }).thenComparing(emiRecipe2 -> {
        MachineTier tier = getTier(emiRecipe2);
        return Integer.valueOf(tier != null ? tier.ordinal() : Integer.MAX_VALUE);
    }).thenComparing(EmiRecipeSorting.compareOutputThenInput());
    private final ResourceLocation categoryId;
    private final Supplier<EmiStack> iconProvider;

    @Nullable
    private final RecipeCreator<RI, R, ER, EC> recipeCreator;

    @Nullable
    private final SyntheticRecipeCreator<B, ER, EC> syntheticRecipeCreator;

    @Nullable
    private final CategoryCreator<EC> categoryCreator;

    @Nullable
    private final RecipeType<R> recipeType;
    private final List<LBlock<B>> registeredBlocks;
    private EC category;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/base/EmiMachine$CategoryCreator.class */
    @FunctionalInterface
    public interface CategoryCreator<EC extends EmiRecipeCategory> {
        EC apply(ResourceLocation resourceLocation);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/base/EmiMachine$RecipeCreator.class */
    @FunctionalInterface
    public interface RecipeCreator<RI extends RecipeInput, R extends Recipe<RI>, ER extends EmiRecipe, EC extends EmiRecipeCategory> {
        @Nullable
        ER apply(EC ec, R r);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/base/EmiMachine$SyntheticRecipeCreator.class */
    @FunctionalInterface
    public interface SyntheticRecipeCreator<B extends Block, ER extends EmiRecipe, EC extends EmiRecipeCategory> {
        ER apply(EC ec, LBlock<B> lBlock);
    }

    public EmiMachine(EC ec, Collection<LBlock<B>> collection) {
        this(ec.getId(), (Supplier<EmiStack>) null, (RecipeCreator) null, (RecipeType) null, collection);
        this.category = ec;
    }

    public EmiMachine(String str, Supplier<EmiStack> supplier, @Nullable RecipeCreator<RI, R, ER, EC> recipeCreator, RecipeType<R> recipeType, Collection<LBlock<B>> collection) {
        this(str, supplier, recipeCreator, (SyntheticRecipeCreator) null, (CategoryCreator) null, recipeType, collection);
    }

    public EmiMachine(String str, Supplier<EmiStack> supplier, @Nullable RecipeCreator<RI, R, ER, EC> recipeCreator, @Nullable SyntheticRecipeCreator<B, ER, EC> syntheticRecipeCreator, Collection<LBlock<B>> collection) {
        this(str, supplier, recipeCreator, syntheticRecipeCreator, (CategoryCreator) null, (RecipeType) null, collection);
    }

    public EmiMachine(String str, Supplier<EmiStack> supplier, @Nullable SyntheticRecipeCreator<B, ER, EC> syntheticRecipeCreator, Collection<LBlock<B>> collection) {
        this(str, supplier, (RecipeCreator) null, syntheticRecipeCreator, (CategoryCreator) null, (RecipeType) null, collection);
    }

    public EmiMachine(ResourceLocation resourceLocation, Supplier<EmiStack> supplier, @Nullable RecipeCreator<RI, R, ER, EC> recipeCreator, RecipeType<R> recipeType, Collection<LBlock<B>> collection) {
        this(resourceLocation, supplier, recipeCreator, (SyntheticRecipeCreator) null, (CategoryCreator) null, recipeType, collection);
    }

    public EmiMachine(ResourceLocation resourceLocation, Supplier<EmiStack> supplier, @Nullable SyntheticRecipeCreator<B, ER, EC> syntheticRecipeCreator, Collection<LBlock<B>> collection) {
        this(resourceLocation, supplier, (RecipeCreator) null, syntheticRecipeCreator, (CategoryCreator) null, (RecipeType) null, collection);
    }

    public EmiMachine(ResourceLocation resourceLocation, Supplier<EmiStack> supplier, @Nullable RecipeCreator<RI, R, ER, EC> recipeCreator, @Nullable SyntheticRecipeCreator<B, ER, EC> syntheticRecipeCreator, RecipeType<R> recipeType, Collection<LBlock<B>> collection) {
        this(resourceLocation, supplier, recipeCreator, syntheticRecipeCreator, (CategoryCreator) null, recipeType, collection);
    }

    public EmiMachine(String str, Supplier<EmiStack> supplier, @Nullable RecipeCreator<RI, R, ER, EC> recipeCreator, @Nullable SyntheticRecipeCreator<B, ER, EC> syntheticRecipeCreator, @Nullable CategoryCreator<EC> categoryCreator, RecipeType<R> recipeType, Collection<LBlock<B>> collection) {
        this(MCTech.loc(str), supplier, recipeCreator, syntheticRecipeCreator, categoryCreator, recipeType, collection);
    }

    public EmiMachine(ResourceLocation resourceLocation, Supplier<EmiStack> supplier, @Nullable RecipeCreator<RI, R, ER, EC> recipeCreator, @Nullable SyntheticRecipeCreator<B, ER, EC> syntheticRecipeCreator, @Nullable CategoryCreator<EC> categoryCreator, @Nullable RecipeType<R> recipeType, Collection<LBlock<B>> collection) {
        this.categoryId = resourceLocation;
        this.iconProvider = supplier;
        this.recipeCreator = recipeCreator;
        this.syntheticRecipeCreator = syntheticRecipeCreator;
        this.categoryCreator = categoryCreator;
        this.recipeType = recipeType;
        this.registeredBlocks = new ArrayList(collection);
    }

    public EmiMachine<RI, R, B, ER, EC> addWorkstation(@NotNull LBlock<? extends Block> lBlock) {
        this.registeredBlocks.add(lBlock);
        return this;
    }

    private CategoryCreator<EC> getDefaultCategoryCreator() {
        return resourceLocation -> {
            return new EmiRecipeCategory(this, resourceLocation, this.iconProvider.get(), EmiStack.EMPTY, MACHINE_TIER_SORTING) { // from class: mctech.integration.emi.plugin.base.EmiMachine.1
                public void renderSimplified(GuiGraphics guiGraphics, int i, int i2, float f) {
                    render(guiGraphics, i, i2, f);
                }
            };
        };
    }

    public EC getOrCreateCategory() {
        if (this.category == null) {
            this.category = this.categoryCreator == null ? (EC) getDefaultCategoryCreator().apply(this.categoryId) : (EC) this.categoryCreator.apply(this.categoryId);
        }
        return this.category;
    }

    public void registerCategory(EmiRegistry emiRegistry) {
        emiRegistry.addCategory(getOrCreateCategory());
    }

    public void registerWorkstations(EmiRegistry emiRegistry) {
        Iterator<LBlock<B>> it = this.registeredBlocks.stream().sorted((lBlock, lBlock2) -> {
            return Integer.compare(getTierFromBlock(lBlock).ordinal(), getTierFromBlock(lBlock2).ordinal());
        }).toList().iterator();
        while (it.hasNext()) {
            emiRegistry.addWorkstation(getOrCreateCategory(), EmiStack.of(it.next()));
        }
    }

    public void registerRecipes(EmiRegistry emiRegistry, RecipeManager recipeManager) {
        if (this.recipeCreator != null && this.recipeType != null) {
            Iterator it = recipeManager.getAllRecipesFor(this.recipeType).iterator();
            while (it.hasNext()) {
                EmiRecipe emiRecipeApply = this.recipeCreator.apply(getOrCreateCategory(), ((RecipeHolder) it.next()).value());
                if (emiRecipeApply != null) {
                    emiRegistry.addRecipe(emiRecipeApply);
                }
            }
        }
        if (this.syntheticRecipeCreator != null) {
            this.registeredBlocks.forEach(lBlock -> {
                emiRegistry.addRecipe(this.syntheticRecipeCreator.apply(getOrCreateCategory(), lBlock));
            });
        }
    }

    public String getCategoryName() {
        return this.categoryId.getPath();
    }

    public ResourceLocation getCategoryId() {
        return this.categoryId;
    }

    private static MachineTier getTier(EmiRecipe emiRecipe) {
        try {
            return getTierFromBlock((Block) BuiltInRegistries.BLOCK.get(emiRecipe.getId()));
        } catch (Exception e) {
            return MachineTier.T1;
        }
    }

    private static MachineTier getTierFromBlock(Block block) {
        if (block instanceof a) {
            return ((a) block).a();
        }
        BlockState blockStateDefaultBlockState = block.defaultBlockState();
        if (blockStateDefaultBlockState.hasProperty(MachineTier.PROPERTY)) {
            return blockStateDefaultBlockState.getValue(MachineTier.PROPERTY);
        }
        if (block instanceof IMachineTier) {
            return ((IMachineTier) block).machineTier();
        }
        return MachineTier.T1;
    }

    private <T extends Block> MachineTier getTierFromBlock(LBlock<T> lBlock) {
        return getTierFromBlock((Block) lBlock.get());
    }
}
