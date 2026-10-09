package mctech.blockentities.c;

import mctech.MCTech;
import mctech.blockentities.StoneBasicMachineTileEntity;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import mctech.m.b.az;
import mctech.u.AbstractC0180h;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/Z.class */
public class Z extends StoneBasicMachineTileEntity {
    public static final ResourceLocation a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/stone_extractor.png");

    public Z(BlockPos blockPos, BlockState blockState) {
        super(MCTechTiles.STONE_EXTRACTOR.get(), blockPos, blockState, 400);
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return (RecipeType) MCTechRecipes.EXTRACTOR.get();
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity
    public int getFuel(ItemStack itemStack) {
        return ((ItemStack) this.inventory.getFirst()).getBurnTime(RecipeType.SMELTING) / 2;
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity
    public RecipeInput getRecipeInput(ItemStack itemStack) {
        return new AbstractC0180h.a(itemStack, false);
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public float getProgressPerTick() {
        return 1.0f;
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new az(this, player, i);
    }

    @Override // mctech.blockentities.i, mctech.m.e.e
    public boolean allowsUI() {
        return false;
    }

    @Override // mctech.api.features.redstone.IComparable
    public boolean isAllowingUI() {
        return false;
    }
}
