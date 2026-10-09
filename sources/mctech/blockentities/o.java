package mctech.blockentities;

import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/o.class */
public abstract class o<I extends RecipeInput, R extends Recipe<I>> extends StoneBasicMachineTileEntity implements IMachineTier {
    protected RecipeHolder<R> a;
    protected boolean b;

    public abstract int a();

    public abstract boolean b();

    public abstract void c();

    public abstract boolean e();

    public o(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 400);
        this.a = null;
        this.b = true;
    }

    public I d() {
        return null;
    }

    public RecipeType<R> getRecipeType() {
        return null;
    }

    public RecipeHolder<R> f() {
        RecipeInput recipeInputD;
        if (this.level == null || (recipeInputD = d()) == null) {
            return null;
        }
        return (RecipeHolder) this.level.getRecipeManager().getRecipeFor(getRecipeType(), recipeInputD, this.level).orElse(null);
    }

    public RecipeHolder<R> g() {
        if (!this.b && this.a != null) {
            return this.a;
        }
        this.a = f();
        this.b = false;
        return this.a;
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity, mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ((Integer) this.inventory.stream().filter(itemStack2 -> {
            return mctech.utils.c.h.d(itemStack, itemStack2);
        }).map(mctech.utils.c.h::b).filter(num -> {
            return num.intValue() > 0;
        }).findAny().orElse(0)).intValue();
    }

    @NotNull
    public MachineTier machineTier() {
        return (MachineTier) getBlockState().getOptionalValue(MachineTier.PROPERTY).orElse(MachineTier.T1);
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        this.b = true;
        super.setStackInSlot(i, itemStack);
    }
}
