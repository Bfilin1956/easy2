package mctech.blockentities.c;

import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import mctech.m.b.aC;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/ac.class */
public class ac extends mctech.blockentities.o<mctech.u.T.a, mctech.u.T> {
    public ac(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.STONE_RARE_EXTRACTOR.get(), blockPos, blockState);
        this.inventoryManager.a().a(mctech.m.g.y.a(a())).a(mctech.m.g.y.f(1).a(new mctech.m.c.m(this))).a(mctech.m.g.y.d(2)).i();
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new aC(this, player, i);
    }

    @Override // mctech.blockentities.o
    public int a() {
        return 0;
    }

    @Override // mctech.blockentities.o
    public boolean b() {
        return false;
    }

    @Override // mctech.blockentities.o
    public void c() {
    }

    @Override // mctech.blockentities.o
    public boolean e() {
        return false;
    }

    @Override // mctech.blockentities.o, mctech.api.tiles.IRecipeMachine
    public RecipeType<mctech.u.T> getRecipeType() {
        return MCTechRecipes.type("rare_extractor");
    }

    @Override // mctech.blockentities.o
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public mctech.u.T.a d() {
        return new mctech.u.T.a(getStackInSlot(1));
    }

    @Override // mctech.blockentities.o
    public RecipeHolder<mctech.u.T> g() {
        RecipeHolder<mctech.u.T> recipeHolderG = super.g();
        if (recipeHolderG != null) {
            this.maxProgress = ((mctech.u.T) recipeHolderG.value()).d();
            updateNetworkField(this, "maxProgress");
        }
        return recipeHolderG;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public float getProgressPerTick() {
        return 1.0f;
    }
}
