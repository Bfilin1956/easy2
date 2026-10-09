package mctech.blockentities.c;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.IntStream;
import mctech.api.util.DirectionList;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.init.MCTechLang;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import mctech.m.b.C0135ah;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/M.class */
public class M extends BasicMachineTileEntity implements mctech.a.b.a.a, GeoBlockEntity {
    public static final mctech.m.e.k a = mctech.m.e.k.a("crafting_matrix", MCTechLang.TOOLTIP_ASSEMBLY_CRAFTING_MATRIX, mctech.m.e.k.b);
    private final AnimatableInstanceCache b;

    public M(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.QUANTUM_WORKBENCH.get(), blockPos, blockState);
    }

    public M(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 50, 0, mctech.h.a.c.y.b, 0, mctech.h.a.c.y.a, mctech.h.a.c.y.c);
        this.b = GeckoLibUtil.createInstanceCache(this);
        this.inventoryManager = new mctech.m.e.j(this).a(mctech.m.g.y.d(49)).a(new mctech.m.g.y(a, IntStream.range(0, 49).toArray()).a(mctech.m.e.a.IMPORT).a(new mctech.m.c.o(this)).a(DirectionList.ALL));
        this.inventoryManager.i();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0135ah(this, player, i);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ((Integer) this.inventory.stream().filter(itemStack2 -> {
            return mctech.utils.c.h.d(itemStack, itemStack2);
        }).map(mctech.utils.c.h::b).filter(num -> {
            return num.intValue() > 0;
        }).findAny().orElse(0)).intValue();
    }

    @Override // mctech.a.b.a.a
    public boolean a() {
        if (isOperating()) {
            return false;
        }
        Iterator<Integer> it = this.inventoryManager.b(a).iterator();
        while (it.hasNext()) {
            if (!getStackInSlot(it.next().intValue()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    @Override // mctech.blockentities.q
    public void onLoad() {
        super.onLoad();
    }

    @Override // mctech.blockentities.k, mctech.blockentities.q, mctech.api.network.tile.INetworkFieldNotifier
    public void onNetworkFieldChanged(Set<String> set, Player player) {
        super.onNetworkFieldChanged(set, player);
        if (set.contains(this.isWorkingString)) {
            if (isActive()) {
                triggerAnim("main", "loop");
            } else {
                stopTriggeredAnim("main", "loop");
            }
        }
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "main", animationState -> {
            return isOperating() ? PlayState.CONTINUE : PlayState.STOP;
        }).triggerableAnim("loop", RawAnimation.begin().thenLoop("animation")));
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.b;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get(mctech.i.i.QUANTUM_WORKBENCH.getSerializedName()).get();
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T6;
    }
}
