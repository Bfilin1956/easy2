package mctech.blockentities.c;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import mctech.api.items.IUpgradeItem;
import mctech.blockentities.BasicMachineTileEntityAdvanced;
import mctech.init.MCTechItems;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import mctech.m.b.C0145e;
import mctech.u.AbstractC0180h;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/Q.class */
public class Q extends BasicMachineTileEntityAdvanced {
    private static Optional<RecipeHolder<Recipe<RecipeInput>>> d;
    public static final EnumSet<IUpgradeItem.UpgradeType> a = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
    public static final EnumSet<IUpgradeItem.UpgradeType> b = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
    public static final EnumSet<IUpgradeItem.UpgradeType> c = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM, IUpgradeItem.UpgradeType.COMPLEX_HANDLER_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD, IUpgradeItem.UpgradeType.TRANSFORMER_MOD);

    public Q(BlockPos blockPos, BlockState blockState) {
        super(MCTechTiles.ADVANCED_RECYCLER.get(), blockPos, blockState, 3);
        this.inventoryManager.a(mctech.m.e.k.g, yVar -> {
            return yVar.a(itemStack -> {
                return getRecipeFor(itemStack).isPresent();
            });
        }).i();
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return (RecipeType) MCTechRecipes.RECYCLER.get();
    }

    @Override // mctech.blockentities.BasicMachineTileEntityAdvanced
    public Optional<RecipeHolder<Recipe<RecipeInput>>> getRecipeFor(ItemStack itemStack) {
        Optional<RecipeHolder<Recipe<RecipeInput>>> recipeFor = super.getRecipeFor(itemStack);
        return recipeFor.isEmpty() ? a(this.level) : recipeFor;
    }

    public static Optional<RecipeHolder<Recipe<RecipeInput>>> a(Level level) {
        if (d == null) {
            for (RecipeHolder recipeHolder : level.getRecipeManager().getAllRecipesFor((RecipeType) MCTechRecipes.RECYCLER.get())) {
                ItemStack resultItem = recipeHolder.value().getResultItem(level.registryAccess());
                if (resultItem.getItem() == MCTechItems.SCRAP.get() && resultItem.getCount() == 1) {
                    d = Optional.of(recipeHolder);
                    return d;
                }
            }
            d = Optional.empty();
        }
        return d;
    }

    @Override // mctech.blockentities.BasicMachineTileEntityAdvanced
    public RecipeInput getRecipeInput(ItemStack itemStack) {
        return new AbstractC0180h.a(itemStack, true);
    }

    @Override // mctech.blockentities.BasicMachineTileEntityAdvanced
    public void operateOnce(int i, @NotNull Recipe<?> recipe, @NotNull ItemStack itemStack, CompoundTag compoundTag) {
        if (recipe instanceof mctech.u.V) {
            mctech.u.V v = (mctech.u.V) recipe;
            if (this.level != null) {
                if (this.level.getRandom().nextInt(1000) <= v.b() * 1000.0f) {
                    handleOutputs(i, 1, v.a(getRecipeInput(getStackInSlot(i)), this.level.registryAccess()), compoundTag);
                }
                consumeInput(1, i, consumeContainers(), 1);
            }
        }
    }

    @Override // mctech.blockentities.BasicMachineTileEntityAdvanced
    protected List<ItemStack> assembleAll(RecipeInput recipeInput, @NotNull Recipe<?> recipe) {
        if (recipe instanceof mctech.u.V) {
            mctech.u.V v = (mctech.u.V) recipe;
            if (this.level != null) {
                return List.of(v.assemble(recipeInput, this.level.registryAccess()));
            }
        }
        return List.of();
    }

    @Override // mctech.blockentities.BasicMachineTileEntityAdvanced
    protected boolean consumeContainers() {
        return true;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0145e(this, player, i);
    }

    @Override // mctech.blockentities.b, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        if (getAdvancedTier().equals(mctech.i.a.SINGULAR)) {
            return c;
        }
        if (getAdvancedTier().equals(mctech.i.a.QUANTUM)) {
            return b;
        }
        return a;
    }
}
