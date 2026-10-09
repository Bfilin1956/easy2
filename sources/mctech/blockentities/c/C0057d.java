package mctech.blockentities.c;

import java.util.EnumSet;
import java.util.List;
import mctech.api.features.IClickable;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.api.tiles.IFluidMachine;
import mctech.api.util.DirectionList;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.init.MCTechLang;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import mctech.m.b.C0148h;
import mctech.m.b.C0158r;
import mctech.u.C0171c;
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
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: mctech.blockentities.c.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/d.class */
public class C0057d extends BasicMachineTileEntity implements mctech.a.b.a.a, IClickable, INetworkFluidTankFillListener, IFluidMachine, IMachineTier, GeoBlockEntity {
    public static final mctech.m.e.k a = mctech.m.e.k.a("crafting_matrix", MCTechLang.TOOLTIP_ASSEMBLY_CRAFTING_MATRIX, mctech.m.e.k.b);
    private final AnimatableInstanceCache e;

    @NetworkInfo(fieldName = "leftTank")
    @GuiField(fieldName = "leftTank")
    public mctech.fluid.h<?> b;

    @NetworkInfo(fieldName = "rightTank")
    @GuiField(fieldName = "rightTank")
    public mctech.fluid.h<?> c;
    public boolean d;

    public C0057d(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.ASSEMBLY_STATION.get(), blockPos, blockState);
    }

    public C0057d(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 20, 0, mctech.h.a.c.f.d, 0, mctech.h.a.c.f.e, mctech.h.a.c.f.c);
        this.e = GeckoLibUtil.createInstanceCache(this);
        this.inventoryManager = new mctech.m.e.j(this).a(mctech.m.g.y.d(0)).a(new mctech.m.g.y(a, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12).a(mctech.m.e.a.IMPORT).a(new mctech.m.c.o(this)).a(DirectionList.ALL)).a(new mctech.m.g.y(mctech.m.e.k.B, 13, 14, 15, 16, 17, 18, 19, 20).a(mctech.m.e.a.IMPORT).a(new C0158r()).a(DirectionList.ALL));
        this.inventoryManager.i();
        setFuelSlot(-1);
        this.b = new mctech.fluid.h(mctech.h.a.c.f.a, fluidStack -> {
            return fluidStack.isEmpty() || this.c.getFluid().isEmpty() || !this.c.getFluid().is(fluidStack.getFluid());
        }).a(true);
        this.c = new mctech.fluid.h(mctech.h.a.c.f.b, fluidStack2 -> {
            return fluidStack2.isEmpty() || this.b.getFluid().isEmpty() || !this.b.getFluid().is(fluidStack2.getFluid());
        }).a(true);
        addComparator(new mctech.blocks.base.a.a.a.a.i("leftTank", mctech.blocks.base.a.a.d.o, this.b));
        addComparator(new mctech.blocks.base.a.a.a.a.i("rightTank", mctech.blocks.base.a.a.d.o, this.c));
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0148h(this, player, i);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.blockentities.k
    protected void createInvCaches() {
        this.inOut = this.inventoryManager.g();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ((Integer) this.inventory.stream().filter(itemStack2 -> {
            return mctech.utils.c.h.d(itemStack, itemStack2);
        }).map(mctech.utils.c.h::b).filter(num -> {
            return num.intValue() > 0;
        }).findAny().orElse(0)).intValue();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    public boolean isVanilla() {
        return false;
    }

    @Override // mctech.api.tiles.IFluidMachine
    public IFluidHandler getConnectedTank(@NotNull Direction direction) {
        return provide(direction, getInventoryHandler(), this.b, this.c);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return BASIC_MACHINE_UPGRADES;
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
        if (this.c.isEmpty() || FluidStack.isSameFluidSameComponents(fluidStack, this.c.getFluid())) {
            return mctech.utils.c.b.a(itemInHand, player, (IFluidHandler) this.c);
        }
        return false;
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    public List<ItemStack> b() {
        return this.inventoryManager.a(a);
    }

    public List<ItemStack> c() {
        return this.inventoryManager.a(mctech.m.e.k.B);
    }

    public RecipeInput d() {
        return new C0171c(b(), c(), this.b, this.c);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public void a(int i) {
        sendToServer(0, i);
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.e;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get(mctech.i.i.ASSEMBLY_STATION.getSerializedName()).get();
    }

    @Override // mctech.api.network.tile.INetworkFluidTankFillListener
    @Nullable
    public IFluidHandler getFluidHandler(int i) {
        switch (i) {
            case 0:
                return this.b;
            case 1:
                return this.c;
            default:
                return null;
        }
    }

    public NonNullList<ItemStack> e() {
        return this.inventory;
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T6;
    }
}
