package mctech.blockentities;

import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntIterators;
import it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.stream.IntStream;
import mctech.api.features.IXPMachine;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.recipes.IExperienceRecipe;
import mctech.api.tiles.IRecipeMachine;
import mctech.api.util.DirectionList;
import mctech.m.g.y;
import mctech.u.AbstractC0180h;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/BasicMachineTileEntityAdvanced.class */
public abstract class BasicMachineTileEntityAdvanced extends mctech.blockentities.b implements IXPMachine, IRecipeMachine, mctech.m.a.k {

    @NetworkInfo(fieldName = "slotsInUse")
    protected int slotsInUse;

    @NetworkInfo(fieldName = "progress")
    public float[] progress;

    @NetworkInfo(fieldName = "recipeOperation")
    public int[] recipeOperation;
    protected Recipe<RecipeInput>[] activeRecipe;
    protected Recipe<RecipeInput>[] usedRecipe;
    protected int dirtyRecipes;
    protected int activeRecipeProgress;
    protected IntSet activeRecipes;
    private int outputSlotsState;
    public mctech.m.e.j<BasicMachineTileEntityAdvanced> inventoryManager;

    public BasicMachineTileEntityAdvanced(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i) {
        super(blockEntityType, blockPos, blockState, i * blockState.getBlock().getAdvancedTier().b(), 4);
        int iB = blockState.getBlock().getAdvancedTier().b();
        this.dirtyRecipes = 0;
        this.activeRecipeProgress = 0;
        this.activeRecipes = new IntLinkedOpenHashSet();
        this.progress = new float[iB];
        this.recipeOperation = new int[iB];
        this.activeRecipe = new Recipe[iB];
        this.usedRecipe = new Recipe[iB];
        setFuelSlot(-1);
        Arrays.fill(this.recipeOperation, 1);
        this.slotsInUse = iB;
        addGuiFields(this);
        addNetworkFields(this);
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
        for (int i2 = 0; i2 < iB; i2++) {
            addComparator(new mctech.blocks.base.a.a.a.a.f("progress_" + i2, c("comparator.mctech.multiprogress", Integer.valueOf(i2)), this).a(new a(this, i2)));
        }
        this.inventoryManager = new mctech.m.e.j<>(this, 4);
        int iB2 = getBlockState().getBlock().getAdvancedTier().b();
        this.inventoryManager.a(new y(mctech.m.e.k.g, getAllSlots(true)).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(this::canInsertInSlot));
        this.inventoryManager.a(new y(mctech.m.e.k.l, getAllSlots(false)).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT));
        this.inventoryManager.a(new y(mctech.m.e.k.m, IntStream.range(this.inventoryManager.c(), this.inventoryManager.c() + iB2).toArray()).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT));
        this.inventoryManager.a(this);
        this.inventoryManager.i();
    }

    public int getRecipeSlots(int i, boolean z) {
        if (z) {
            if (i < 0 || i >= this.progress.length) {
                return 0;
            }
            return i;
        }
        if (i < this.progress.length || i > (this.progress.length * 2) - 1) {
            return -1;
        }
        return i - this.progress.length;
    }

    public int getOutputSlot(int i) {
        if (i < this.progress.length || i > (this.progress.length * 2) - 1) {
            return -1;
        }
        return i - this.progress.length;
    }

    @Override // mctech.blockentities.i, mctech.m.e.e
    public boolean allowsUI() {
        return false;
    }

    @Override // mctech.api.features.redstone.IComparable
    public boolean isAllowingUI() {
        return false;
    }

    public int getInputSlot(int i) {
        return i;
    }

    public int[] getOutputSlots(int i) {
        return new int[]{i + this.progress.length};
    }

    public int[] getAllSlots(boolean z) {
        int iB = getBlockState().getBlock().getAdvancedTier().b();
        if (this.progress == null) {
            this.progress = new float[iB];
        }
        int[] iArr = new int[iB];
        int i = z ? 0 : iB;
        for (int i2 = 0; i2 < iB; i2++) {
            iArr[i2] = i + i2;
        }
        return iArr;
    }

    public int getSlotsInUse() {
        return this.slotsInUse;
    }

    public IntIterator getActiveSlots() {
        return IntIterators.unmodifiable(this.activeRecipes.iterator());
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgressSlot(int i) {
        return this.recipeOperation[i];
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgressSlot(int i) {
        return this.progress[i];
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public int getSlots() {
        return this.progress.length;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        if (getSlots() <= 0) {
            return 0.0f;
        }
        return this.progress[0];
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        if (getSlots() <= 0) {
            return 0.0f;
        }
        return this.recipeOperation[0];
    }

    @NotNull
    protected IntSet getExportSlots() {
        return new IntOpenHashSet(getAllSlots(false));
    }

    private void handleExportOutputs() {
        IntSet exportSlots = getExportSlots();
        for (Direction direction : this.invCache.c()) {
            IItemHandler iItemHandlerB = this.invCache.b(direction);
            if (iItemHandlerB != null && getInventoryHandler().d(direction).d()) {
                IntIterator intIterator = exportSlots.intIterator();
                while (intIterator.hasNext()) {
                    int iNextInt = intIterator.nextInt();
                    ItemStack stackInSlot = getStackInSlot(iNextInt);
                    if (stackInSlot.isEmpty()) {
                        intIterator.remove();
                    } else {
                        ItemStack itemStackInsertItem = ItemHandlerHelper.insertItem(iItemHandlerB, stackInSlot, false);
                        if (itemStackInsertItem.getCount() != stackInSlot.getCount()) {
                            if (itemStackInsertItem.isEmpty()) {
                                intIterator.remove();
                            }
                            setStackInSlot(iNextInt, itemStackInsertItem);
                        }
                    }
                }
            }
        }
    }

    protected void dropSlot(int i) {
        int inputSlot = getInputSlot(i);
        ItemStack itemStack = (ItemStack) this.inventory.get(inputSlot);
        this.inventory.set(inputSlot, ItemStack.EMPTY);
        if (!itemStack.isEmpty()) {
            Block.popResource(this.level, this.worldPosition, itemStack);
        }
        for (int i2 : getOutputSlots(i)) {
            ItemStack itemStack2 = (ItemStack) this.inventory.get(i2);
            this.inventory.set(i2, ItemStack.EMPTY);
            if (!itemStack2.isEmpty()) {
                Block.popResource(this.level, this.worldPosition, itemStack2);
            }
        }
    }

    protected void checkTank(FluidTank fluidTank) {
    }

    protected float getExperienceForRecipe(@NotNull Recipe<?> recipe) {
        return ((IExperienceRecipe) recipe).getExperience();
    }

    protected int getRecipeInputCount(@NotNull Recipe<?> recipe) {
        return ((AbstractC0180h) recipe).a();
    }

    protected List<ItemStack> assembleAll(RecipeInput recipeInput, @NotNull Recipe<?> recipe) {
        return ((AbstractC0180h) recipe).a(recipeInput, this.level.registryAccess());
    }

    public int getCreatedXP(boolean z) {
        if (this.processedRecipes.isEmpty()) {
            return 0;
        }
        float experienceForRecipe = 0.0f;
        ObjectIterator it = Object2IntMaps.fastIterable(this.processedRecipes).iterator();
        while (it.hasNext()) {
            Object2IntMap.Entry entry = (Object2IntMap.Entry) it.next();
            experienceForRecipe += getExperienceForRecipe((Recipe) entry.getKey()) * entry.getIntValue();
        }
        if (z) {
            this.processedRecipes.clear();
        }
        return (int) experienceForRecipe;
    }

    protected boolean canStopTicking(boolean z) {
        return (z || canWorkWithoutItems() || this.activeRecipeProgress > 0 || this.storage.a(IUpgradeItem.Functions.TICK) || isNeedExport()) ? false : true;
    }

    protected void onPreTick(boolean z, boolean z2, boolean z3) {
    }

    public void operate(int i, @NotNull Recipe<? extends RecipeInput> recipe) {
        operateOnce(i, recipe, ((ItemStack) this.inventory.get(getInputSlot(i))).copy(), new CompoundTag());
        onRecipeProcessed(recipe);
        if (!this.outputs.isEmpty()) {
            addItemsToInventory();
        }
    }

    protected int countComplexUpgrades() {
        return Math.toIntExact(this.inventory.stream().filter(itemStack -> {
            return !itemStack.isEmpty() && (itemStack.getItem() instanceof mctech.items.f.a);
        }).count());
    }

    public void operateOnce(int i, @NotNull Recipe<?> recipe, @NotNull ItemStack itemStack, CompoundTag compoundTag) {
        this.outputCount = Math.min(1, countComplexUpgrades());
        int recipeInputCount = getRecipeInputCount(recipe);
        int outputMultiplier = getOutputMultiplier(recipeInputCount, getInputSlot(i));
        handleOutputs(i, outputMultiplier, assembleAll(getRecipeInput(itemStack), recipe), compoundTag);
        consumeInput(recipeInputCount, i, consumeContainers(), outputMultiplier);
    }

    protected void handleOutputs(int i, int i2, List<ItemStack> list, CompoundTag compoundTag) {
        if (i2 == 1) {
            Iterator<ItemStack> it = list.iterator();
            while (it.hasNext()) {
                addOutput(i, it.next().copy());
            }
            return;
        }
        for (ItemStack itemStack : list) {
            int count = itemStack.getCount() * i2;
            do {
                ItemStack itemStackCopy = itemStack.copy();
                itemStackCopy.setCount(Math.min(itemStack.getMaxStackSize(), count));
                count -= itemStackCopy.getCount();
                addOutput(i, itemStackCopy);
            } while (count > 0);
        }
    }

    public void consumeInput(int i, int i2, boolean z, int i3) {
        int inputSlot = getInputSlot(i2);
        if (i > 0 || !((ItemStack) this.inventory.get(inputSlot)).isEmpty()) {
            ItemStack itemStack = (ItemStack) this.inventory.get(inputSlot);
            if (!z && itemStack.hasCraftingRemainingItem()) {
                for (int i4 = 0; i4 < i3; i4++) {
                    addOutput(i2, itemStack.getCraftingRemainingItem());
                }
            }
            itemStack.shrink(i * i3);
        }
    }

    private int getOutputMultiplier(int i, int i2) {
        ItemStack itemStack = (ItemStack) this.inventory.get(i2);
        if (i == 0) {
            return 1;
        }
        return Math.min(itemStack.getCount() / i, this.outputCount);
    }

    protected void addOutput(int i, ItemStack itemStack) {
        this.outputs.add(new mctech.u.c.d(itemStack, getOutputSlots(i)));
    }

    public Recipe<RecipeInput> getRecipe(int i) {
        Recipe<RecipeInput> recipe;
        if ((this.dirtyRecipes & (1 << i)) == 0 && (recipe = this.usedRecipe[i]) != null && recipe.matches(getRecipeInput(((ItemStack) this.inventory.get(i)).copy()), this.level)) {
            return recipe;
        }
        int inputSlot = getInputSlot(i);
        if (((ItemStack) this.inventory.get(inputSlot)).isEmpty() && !canWorkWithoutItems()) {
            return setRecipe(i, null, true);
        }
        Recipe<RecipeInput> recipe2 = this.activeRecipe[i];
        if (recipe2 != null) {
            Ingredient ingredient = (Ingredient) recipe2.getIngredients().getFirst();
            boolean z = ingredient == Ingredient.EMPTY;
            if (z && !ingredient.test((ItemStack) this.inventory.get(inputSlot))) {
                setRecipe(i, null, true);
            } else if (!z) {
                switch (isRecipeStillValid(i, recipe2)) {
                    case FAIL:
                        setRecipe(i, null, true);
                        break;
                    case PASS:
                        return setRecipe(i, null, false);
                    case IGNORE:
                        if (!((ItemStack) this.inventory.get(inputSlot)).isEmpty() && ingredient.test((ItemStack) this.inventory.get(inputSlot))) {
                            if (getRecipeInputCount(recipe2) > ((ItemStack) this.inventory.get(inputSlot)).getCount()) {
                                return setRecipe(i, null, false);
                            }
                        } else {
                            setRecipe(i, null, true);
                        }
                        break;
                }
            }
        }
        if (recipe2 == null) {
            Optional<RecipeHolder<Recipe<RecipeInput>>> recipeFor = getRecipeFor(((ItemStack) this.inventory.get(inputSlot)).copy());
            if (recipeFor.isEmpty()) {
                return setRecipe(i, null, true);
            }
            recipe2 = setRecipe(i, recipeFor.get().value(), true);
            handleMods(i, recipeFor.get().value());
        }
        switch (AnonymousClass1.b[canFillRecipeIntoOutputs(i, recipe2).ordinal()]) {
            case 1:
                return setRecipe(i, recipe2, false);
            case 2:
                return setRecipe(i, null, false);
            default:
                List<ItemStack> listAssembleAll = assembleAll(getRecipeInput((ItemStack) this.inventory.get(getInputSlot(i))), recipe2);
                for (int i2 : getOutputSlots(i)) {
                    ItemStack itemStack = (ItemStack) this.inventory.get(i2);
                    if (itemStack.isEmpty()) {
                        return setRecipe(i, recipe2, false);
                    }
                    if (mctech.utils.c.h.b(itemStack) > 0) {
                        Iterator<ItemStack> it = listAssembleAll.iterator();
                        while (it.hasNext()) {
                            if (mctech.utils.c.h.b(itemStack, it.next())) {
                                return setRecipe(i, recipe2, false);
                            }
                        }
                    }
                }
                return setRecipe(i, null, false);
        }
    }

    /* JADX INFO: renamed from: mctech.blockentities.BasicMachineTileEntityAdvanced$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/BasicMachineTileEntityAdvanced$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] b = new int[InteractionResult.values().length];

        static {
            try {
                b[InteractionResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[InteractionResult.PASS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            a = new int[mctech.blockentities.b.a.values().length];
            try {
                a[mctech.blockentities.b.a.FAIL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[mctech.blockentities.b.a.PASS.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[mctech.blockentities.b.a.IGNORE.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[mctech.blockentities.b.a.SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    protected Recipe<RecipeInput> setRecipe(int i, Recipe<RecipeInput> recipe, boolean z) {
        if (z) {
            this.activeRecipe[i] = recipe;
        }
        this.usedRecipe[i] = recipe;
        return recipe;
    }

    protected mctech.blockentities.b.a isRecipeStillValid(int i, Recipe<RecipeInput> recipe) {
        return mctech.blockentities.b.a.IGNORE;
    }

    protected InteractionResult canFillRecipeIntoOutputs(int i, Recipe<RecipeInput> recipe) {
        return InteractionResult.FAIL;
    }

    protected boolean canWorkWithoutItems() {
        return false;
    }

    protected boolean consumeContainers() {
        return false;
    }

    public <T extends RecipeInput> ItemStack assemble(Recipe<T> recipe, ItemStack itemStack) {
        return this.level == null ? ItemStack.EMPTY : recipe.assemble(getRecipeInput(itemStack), this.level.registryAccess());
    }

    public Optional<RecipeHolder<Recipe<RecipeInput>>> getRecipeFor(ItemStack itemStack) {
        return this.level == null ? Optional.empty() : this.level.getRecipeManager().getRecipeFor(getRecipeType(), getRecipeInput(itemStack), this.level);
    }

    public RecipeInput getRecipeInput(ItemStack itemStack) {
        return isVanilla() ? new SingleRecipeInput(itemStack) : new AbstractC0180h.a(itemStack, false);
    }

    public boolean isVanilla() {
        return false;
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        if (getRecipeFor(itemStack).isPresent()) {
            return ((Integer) this.inventory.stream().filter(itemStack2 -> {
                return mctech.utils.c.h.d(itemStack, itemStack2);
            }).map(mctech.utils.c.h::b).filter(num -> {
                return num.intValue() > 0;
            }).findAny().orElse(0)).intValue();
        }
        return 0;
    }

    public boolean canInsertInSlot(int i, ItemStack itemStack) {
        int recipeSlots = getRecipeSlots(i, true);
        if (recipeSlots >= 0 && recipeSlots < this.slotsInUse && getRecipeFor(itemStack).isPresent()) {
            ItemStack stackInSlot = getStackInSlot(i);
            return stackInSlot.isEmpty() || mctech.utils.c.h.d(stackInSlot, itemStack);
        }
        return false;
    }

    @Override // mctech.blockentities.b
    protected boolean isNeedExport() {
        return this.outputSlotsState != 0;
    }

    @Override // mctech.blockentities.b
    protected void updateAutoExportSlotsState() {
        IntIterator it = getExportSlots().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            int outputSlot = getOutputSlot(iIntValue);
            if (outputSlot != -1) {
                updateOutputSlotState(outputSlot, ((ItemStack) this.inventory.get(iIntValue)).isEmpty());
            }
        }
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    @Override // mctech.blockentities.q
    public void onComparatorUpdate(BlockPos blockPos) {
        super.onComparatorUpdate(blockPos);
        for (int i : getAllSlots(false)) {
            int outputSlot = getOutputSlot(i);
            if (outputSlot != -1) {
                updateOutputSlotState(outputSlot, getStackInSlot(outputSlot).isEmpty());
            }
        }
    }

    private void updateOutputSlotState(int i, boolean z) {
        if (z) {
            this.outputSlotsState &= (1 << i) ^ (-1);
        } else {
            this.outputSlotsState |= 1 << i;
        }
    }

    @Override // mctech.blockentities.b, mctech.api.recipes.ingridients.queue.IInputter
    public void addItemIntoSlot(int i, ItemStack itemStack) {
        int outputSlot;
        super.addItemIntoSlot(i, itemStack);
        if (isAutoExport() && (outputSlot = getOutputSlot(i)) != -1) {
            updateOutputSlotState(outputSlot, ((ItemStack) this.inventory.get(i)).isEmpty());
        }
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        int outputSlot;
        if (isSimulating()) {
            updateRecipeForSlot(i);
        }
        if (isAutoSort() && getRecipeSlots(i, true) != -1) {
            this.needSort = true;
        }
        if (isAutoExport() && (outputSlot = getOutputSlot(i)) != -1) {
            updateOutputSlotState(outputSlot, itemStack.isEmpty());
        }
        super.setStackInSlot(i, itemStack);
    }

    private void updateRecipeForSlot(int i) {
    }

    @Override // mctech.blockentities.b
    protected void createInvCaches() {
        this.inOut = new mctech.m.a.g[2];
        this.inOut[0] = new mctech.m.f.k(this, getAllSlots(true));
        this.inOut[1] = new mctech.m.f.k(this, getAllSlots(false)).a();
    }

    @Override // mctech.api.tiles.IMachine
    public void handleMods() {
        for (int i = 0; i < this.slotsInUse; i++) {
            handleMods(i, this.usedRecipe[i]);
        }
    }

    protected void handleMods(int i, Recipe<?> recipe) {
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/BasicMachineTileEntityAdvanced$a.class */
    private static class a implements BooleanSupplier {
        BasicMachineTileEntityAdvanced a;
        int b;

        public a(BasicMachineTileEntityAdvanced basicMachineTileEntityAdvanced, int i) {
            this.a = basicMachineTileEntityAdvanced;
            this.b = i;
        }

        @Override // java.util.function.BooleanSupplier
        public boolean getAsBoolean() {
            return this.a.slotsInUse > this.b;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/BasicMachineTileEntityAdvanced$b.class */
    private static class b {

        @NotNull
        private final ItemStack a;
        private final IntSet b = new IntLinkedOpenHashSet();
        private int c;
        private int d;

        private b(@NotNull ItemStack itemStack, int i) {
            this.a = itemStack;
            a(i, itemStack);
        }

        public boolean a(ItemStack itemStack) {
            return ItemStack.isSameItemSameComponents(this.a, itemStack);
        }

        public void a(int i, @NotNull ItemStack itemStack) {
            this.b.add(i);
            this.c += itemStack.getCount();
            if (itemStack.getCount() > this.d) {
                this.d = itemStack.getCount();
            }
        }
    }
}
