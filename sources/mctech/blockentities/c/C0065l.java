package mctech.blockentities.c;

import mctech.blockentities.BasicMachineTileEntity;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.blockentities.c.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/l.class */
public class C0065l extends BasicMachineTileEntity {
    public C0065l(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 3, 4, 2, 600, 3200, 32);
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T3;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean isHarvestWrenchRequired(Player player) {
        return false;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    public boolean isVanilla() {
        return true;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    public mctech.utils.math.geometry.b getProgressPosition() {
        return new mctech.utils.math.geometry.b(113, 41, 18, 14);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    public Vec2i getProgressOffset() {
        return new Vec2i(0, 108);
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return RecipeType.SMELTING;
    }
}
