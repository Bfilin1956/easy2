package mctech.blockentities.c;

import java.util.EnumSet;
import mctech.api.items.IUpgradeItem;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.init.MCTechRecipes;
import mctech.m.b.ao;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/T.class */
public class T extends BasicMachineTileEntity {
    public static final String a = "display_log";
    private static final EnumSet<IUpgradeItem.UpgradeType> b = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM, IUpgradeItem.UpgradeType.COMPLEX_HANDLER_MOD, IUpgradeItem.UpgradeType.TRANSFORMER_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD, IUpgradeItem.UpgradeType.SAWMILL_MOD);

    public T(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 3, 4, 2, 400, 3200, 32);
        this.inventoryManager = new mctech.m.e.j(this, this.upgradeSlots).a(mctech.m.g.y.f(0).a(new mctech.m.c.a.g(this))).a(mctech.m.g.y.d(1)).a(mctech.m.g.y.e(2)).a(this);
        this.inventoryManager.i();
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T3;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    public mctech.utils.math.geometry.b getProgressPosition() {
        return new mctech.utils.math.geometry.b(114, 40, 16, 16);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    public Vec2i getProgressOffset() {
        return new Vec2i(0, 57);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new ao(this, player, i);
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return (RecipeType) MCTechRecipes.SAWMILL.get();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return b;
    }
}
