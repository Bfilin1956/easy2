package mctech.api.tiles;

import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/IRecipeMachine.class */
public interface IRecipeMachine extends IInputMachine {
    <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType();

    float getProgressPerTick();
}
