package mctech.blockentities.c;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import mctech.api.features.IClickable;
import mctech.api.features.IXPMachine;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.api.tiles.IFluidMachine;
import mctech.api.tiles.IRecipeMachine;
import mctech.api.util.DirectionList;
import mctech.init.MCTechRecipes;
import mctech.m.b.C0141an;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/S.class */
public class S extends mctech.blockentities.k implements IClickable, IXPMachine, INetworkFluidTankFillListener, IFluidMachine, IRecipeMachine, mctech.m.a.k {
    public static final EnumSet<IUpgradeItem.UpgradeType> a = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);

    @NetworkInfo(fieldName = "firstTank")
    public mctech.fluid.h<?> b;

    @NetworkInfo(fieldName = "secondTank")
    public mctech.fluid.h<?> c;

    @NetworkInfo(fieldName = "outputTank")
    public mctech.fluid.h<?> d;

    @NetworkInfo(fieldName = "progress")
    public float e;

    @NetworkInfo(fieldName = "recipeOperation")
    public int f;

    @NetworkInfo(fieldName = "recipeEnergy")
    public int g;
    protected Recipe<RecipeInput> h;
    protected Recipe<RecipeInput> i;
    protected boolean j;
    List<FluidStack> k;
    mctech.d.d<IFluidHandler> l;
    public final mctech.m.e.j<S> m;

    public S(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 5, 4, 8, 600, 204900, 2048);
        this.b = new mctech.fluid.h(8000, fluidStack -> {
            return fluidStack.isEmpty() || this.c.getFluid().isEmpty() || !this.c.getFluid().is(fluidStack.getFluid());
        }).a(true).a(gVar -> {
            a();
        });
        this.c = new mctech.fluid.h(8000, fluidStack2 -> {
            return fluidStack2.isEmpty() || this.b.getFluid().isEmpty() || !this.b.getFluid().is(fluidStack2.getFluid());
        }).a(true).a(gVar2 -> {
            a();
        });
        this.d = new mctech.fluid.h(8000).b(true).a(gVar3 -> {
            a();
        });
        this.m = new mctech.m.e.j<>(this, 4);
        this.m.a(new mctech.m.g.y(mctech.m.e.k.p, 0).a(DirectionList.ALL).a(mctech.m.e.a.BOTH).a(mctech.m.c.r.a()).b(mctech.m.c.a.c.e));
        this.m.a(new mctech.m.g.y(mctech.m.e.k.g, 1).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(new mctech.m.c.o(this)));
        this.m.a(new mctech.m.g.y(mctech.m.e.k.l, 2, 3, 4).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c).b(mctech.m.c.r.d));
        this.m.a(this);
        this.m.i();
        this.e = 0.0f;
        this.h = null;
        this.i = null;
        this.j = true;
        this.k = mctech.utils.a.b.i();
        this.l = new mctech.d.b(this, DirectionList.ALL, Capabilities.FluidHandler.BLOCK);
        addCaches(this.l);
        setFuelSlot(0);
        addGuiFields(this);
        addNetworkFields(this);
        addComparator(new mctech.blocks.base.a.a.a.a.f("progress", mctech.blocks.base.a.a.d.m, this));
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
    }

    protected void a() {
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public float getProgressPerTick() {
        return this.upgradeHandler.a();
    }

    @Override // mctech.blockentities.k, mctech.blockentities.e
    public boolean supportsNotify() {
        return false;
    }

    @Override // mctech.api.features.IClickable
    public boolean onRightClick(Player player, InteractionHand interactionHand, Direction direction, BlockHitResult blockHitResult) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (itemInHand.isEmpty()) {
            return false;
        }
        return mctech.utils.c.b.b(itemInHand, player, new mctech.fluid.i(this.b, this.c)) || mctech.utils.c.b.a(itemInHand, player, new mctech.fluid.i(this.b, this.c));
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0141an(this, player, i);
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.e;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return this.f;
    }

    @Override // mctech.blockentities.k
    protected void createInvCaches() {
        this.inOut = this.m.g();
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return a;
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        if (a(itemStack).isEmpty()) {
            return 0;
        }
        ItemStack itemStack2 = (ItemStack) this.inventory.get(1);
        if (!itemStack2.isEmpty()) {
            if (mctech.utils.c.h.d(itemStack2, itemStack)) {
                return mctech.utils.c.h.b(itemStack2);
            }
            return 0;
        }
        return itemStack.getMaxStackSize();
    }

    @Override // mctech.api.tiles.IFluidMachine
    public IFluidHandler getConnectedTank(Direction direction) {
        if (direction == null) {
            return new mctech.fluid.i(this.b, this.c, this.d);
        }
        if (getInventoryHandler().d(direction) != mctech.m.e.a.DISABLED) {
            return new mctech.fluid.i(this.b, this.c, this.d);
        }
        return null;
    }

    @Override // mctech.api.network.tile.INetworkFluidTankFillListener
    @Nullable
    public IFluidHandler getFluidHandler(int i) {
        switch (i) {
            case 0:
                return this.b;
            case 1:
                return this.c;
            case 2:
                return this.d;
            default:
                return null;
        }
    }

    @Override // mctech.api.tiles.IMachine
    public void handleMods() {
        addGuiFields(this);
    }

    public Recipe<RecipeInput> b() {
        if (((ItemStack) this.inventory.get(1)).isEmpty() && this.b.isEmpty() && this.c.isEmpty()) {
            this.i = null;
            return null;
        }
        RecipeInput recipeInputB = b((ItemStack) this.inventory.get(1), this.b.getFluid(), this.c.getFluid());
        if (this.i != null && this.i.matches(recipeInputB, this.level)) {
            return this.i;
        }
        this.i = null;
        Optional<RecipeHolder<Recipe<RecipeInput>>> optionalA = a((ItemStack) this.inventory.get(1), this.b.getFluid(), this.c.getFluid());
        if (optionalA.isPresent()) {
            this.i = optionalA.get().value();
            this.g = (int) ((mctech.u.W) optionalA.get().value()).m();
            if (!c()) {
                return null;
            }
            return this.i;
        }
        this.i = null;
        return null;
    }

    public boolean c() {
        if (this.i == null) {
            return false;
        }
        mctech.u.W.a aVarA = ((mctech.u.W) this.i).a(b((ItemStack) this.inventory.get(1), this.b.getFluid(), this.c.getFluid()), this.level.registryAccess());
        if (!this.d.getFluid().isEmpty() && !FluidStack.isSameFluidSameComponents(this.d.getFluid(), aVarA.d())) {
            return false;
        }
        if (!this.d.getFluid().isEmpty() && this.d.getCapacity() < this.d.getFluidAmount() + aVarA.d().getAmount()) {
            return false;
        }
        return a(aVarA.a(), aVarA.b(), aVarA.c(), true);
    }

    public boolean a(ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3, boolean z) {
        NonNullList<ItemStack> nonNullListCreate = NonNullList.create();
        nonNullListCreate.add(((ItemStack) this.inventory.get(2)).copy());
        nonNullListCreate.add(((ItemStack) this.inventory.get(3)).copy());
        nonNullListCreate.add(((ItemStack) this.inventory.get(4)).copy());
        if (!itemStack.isEmpty() && !a(nonNullListCreate, itemStack.copy())) {
            return false;
        }
        if (!itemStack2.isEmpty() && !a(nonNullListCreate, itemStack2.copy())) {
            return false;
        }
        if (!itemStack3.isEmpty() && !a(nonNullListCreate, itemStack3.copy())) {
            return false;
        }
        if (!z) {
            this.inventory.set(2, (ItemStack) nonNullListCreate.get(0));
            this.inventory.set(3, (ItemStack) nonNullListCreate.get(1));
            this.inventory.set(4, (ItemStack) nonNullListCreate.get(2));
            return true;
        }
        return true;
    }

    public boolean a(NonNullList<ItemStack> nonNullList, ItemStack itemStack) {
        int iMin;
        if (itemStack.isEmpty()) {
            return true;
        }
        boolean[] zArr = new boolean[nonNullList.size()];
        for (int i = 0; i < nonNullList.size(); i++) {
            ItemStack itemStack2 = (ItemStack) nonNullList.get(i);
            if (itemStack2.isEmpty()) {
                zArr[i] = true;
            }
            if (ItemStack.isSameItemSameComponents(itemStack2, itemStack) && (iMin = Math.min(itemStack.getCount(), itemStack2.getMaxStackSize() - itemStack2.getCount())) > 0) {
                itemStack.shrink(iMin);
                itemStack2.grow(iMin);
            }
        }
        if (!itemStack.isEmpty()) {
            for (int i2 = 0; i2 < zArr.length; i2++) {
                if (zArr[i2]) {
                    nonNullList.set(i2, itemStack.copy());
                    return true;
                }
            }
        }
        return itemStack.isEmpty();
    }

    public Optional<RecipeHolder<Recipe<RecipeInput>>> a(ItemStack itemStack, FluidStack fluidStack, FluidStack fluidStack2) {
        return this.level.getRecipeManager().getRecipeFor(getRecipeType(), b(itemStack, fluidStack, fluidStack2), this.level);
    }

    public Optional<RecipeHolder<Recipe<RecipeInput>>> a(ItemStack itemStack) {
        return a(itemStack, this.b.getFluid(), this.c.getFluid());
    }

    public RecipeInput b(ItemStack itemStack, FluidStack fluidStack, FluidStack fluidStack2) {
        return new mctech.u.W.b(itemStack, fluidStack, fluidStack2);
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return (RecipeType) MCTechRecipes.REFINERY.get();
    }
}
