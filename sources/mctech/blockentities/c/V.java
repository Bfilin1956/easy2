package mctech.blockentities.c;

import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import mctech.m.b.av;
import mctech.u.C0170b;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/V.class */
public class V extends mctech.blockentities.o<C0170b.a, C0170b> {
    public V(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.STONE_ALLOY_SMELTER.get(), blockPos, blockState);
        this.inventoryManager.a().a(mctech.m.g.y.a(a())).a(mctech.m.g.y.f(1).a(new mctech.m.c.m(this))).a(mctech.m.g.y.g(2).a(new mctech.m.c.m(this))).a(mctech.m.g.y.d(3)).i();
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new av(this, player, i);
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
    public RecipeType<C0170b> getRecipeType() {
        return (RecipeType) MCTechRecipes.ALLOY_SMELTER.get();
    }

    @Override // mctech.blockentities.o
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0170b.a d() {
        return new C0170b.a(getStackInSlot(1), getStackInSlot(2));
    }

    @Override // mctech.blockentities.o
    public RecipeHolder<C0170b> g() {
        RecipeHolder<C0170b> recipeHolderG = super.g();
        if (recipeHolderG != null) {
            this.maxProgress = ((C0170b) recipeHolderG.value()).f();
            updateNetworkField(this, "maxProgress");
        }
        return recipeHolderG;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public float getProgressPerTick() {
        return 1.0f;
    }
}
