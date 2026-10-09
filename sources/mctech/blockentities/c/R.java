package mctech.blockentities.c;

import java.util.Optional;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.init.MCTechItems;
import mctech.init.MCTechRecipes;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/R.class */
public class R extends BasicMachineTileEntity {
    private static Optional<RecipeHolder<Recipe<RecipeInput>>> a;

    public R(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 3, 4, 2, 400, 3200, 32);
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T3;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    public mctech.utils.math.geometry.b getProgressPosition() {
        return new mctech.utils.math.geometry.b(113, 40, 18, 16);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    public Vec2i getProgressOffset() {
        return new Vec2i(18, 41);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    public Optional<RecipeHolder<Recipe<RecipeInput>>> getRecipeFor(ItemStack itemStack) {
        Optional<RecipeHolder<Recipe<RecipeInput>>> recipeFor = super.getRecipeFor(itemStack);
        return recipeFor.isEmpty() ? a(this.level) : recipeFor;
    }

    public static Optional<RecipeHolder<Recipe<RecipeInput>>> a(Level level) {
        if (a == null) {
            for (RecipeHolder recipeHolder : level.getRecipeManager().getAllRecipesFor((RecipeType) MCTechRecipes.RECYCLER.get())) {
                ItemStack resultItem = recipeHolder.value().getResultItem(level.registryAccess());
                if (resultItem.getItem() == MCTechItems.SCRAP.get() && resultItem.getCount() == 1) {
                    a = Optional.of(recipeHolder);
                    return a;
                }
            }
            a = Optional.empty();
        }
        return a;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return (RecipeType) MCTechRecipes.RECYCLER.get();
    }
}
