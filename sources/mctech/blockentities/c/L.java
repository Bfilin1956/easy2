package mctech.blockentities.c;

import java.util.EnumSet;
import mctech.api.features.IClickable;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.api.tiles.IFluidMachine;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import mctech.m.b.C0133af;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/L.class */
public class L extends BasicMachineTileEntity implements mctech.a.b.a.a, IClickable, INetworkFluidTankFillListener, IFluidMachine, IMachineTier {
    public static final int a = 0;

    @NetworkInfo(fieldName = "fluidTank")
    private mctech.fluid.h<?> b;

    @NetworkInfo(fieldName = "workingType")
    private int c;

    public L(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.QUANTUM_COMPOSTER.get(), blockPos, blockState);
    }

    public L(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 1, 4, mctech.h.a.c.g.c, 0, mctech.h.a.c.g.d, mctech.h.a.c.g.b);
        this.c = 0;
        this.inventoryManager.a();
        this.inventoryManager = new mctech.m.e.j(this).a(mctech.m.g.y.d(0)).a(mctech.m.g.y.a(this, 1, 2, 3, 4));
        this.inventoryManager.i();
        this.b = new mctech.fluid.h(mctech.h.a.c.g.a, fluidStack -> {
            return fluidStack.is(Fluids.WATER);
        }).a(true);
        setFuelSlot(-1);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0133af(this, player, i);
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkClientEventListener
    public void onClientDataReceived(Player player, int i, int i2) {
        super.onClientDataReceived(player, i, i2);
    }

    public int b() {
        return this.c;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ((Integer) this.inventory.stream().filter(itemStack2 -> {
            return mctech.utils.c.h.d(itemStack, itemStack2);
        }).map(mctech.utils.c.h::b).filter(num -> {
            return num.intValue() > 0;
        }).findAny().orElse(0)).intValue();
    }

    @Override // mctech.api.tiles.IFluidMachine
    public IFluidHandler getConnectedTank(Direction direction) {
        return provide(direction, getInventoryHandler(), (IFluidHandler) this.b);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return defaultUpgrades(machineTier());
    }

    @Override // mctech.api.features.IClickable
    public boolean onRightClick(Player player, InteractionHand interactionHand, Direction direction, BlockHitResult blockHitResult) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        FluidStack fluidStack = (FluidStack) FluidUtil.getFluidContained(itemInHand).orElse(FluidStack.EMPTY);
        if (FluidStack.isSameFluid(fluidStack, FluidStack.EMPTY)) {
            return false;
        }
        if (this.b.isEmpty() || FluidStack.isSameFluidSameComponents(fluidStack, this.b.getFluid())) {
            return mctech.utils.c.b.a(itemInHand, player, (IFluidHandler) this.b);
        }
        return false;
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get(mctech.i.i.ASSEMBLY_STATION.getSerializedName()).get();
    }

    @Override // mctech.api.network.tile.INetworkFluidTankFillListener
    @Nullable
    public IFluidHandler getFluidHandler(int i) {
        return this.b;
    }

    public NonNullList<ItemStack> c() {
        return this.inventory;
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T6;
    }

    public mctech.fluid.h<?> d() {
        return this.b;
    }
}
