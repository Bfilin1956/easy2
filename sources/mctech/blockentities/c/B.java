package mctech.blockentities.c;

import java.util.EnumSet;
import mctech.api.features.ITileActivityProvider;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.api.tiles.IFluidMachine;
import mctech.api.tiles.IMachine;
import mctech.api.tiles.IRecipeMachine;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.api.util.ItemInsertionHelper;
import mctech.init.MCTechItems;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.core.IMachineTier;
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
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/B.class */
public class B extends mctech.blockentities.e implements ITileActivityProvider, INetworkFluidTankFillListener, IFluidMachine, IMachine, IRecipeMachine, IProgressMachine, mctech.m.a.k, IMachineTier {
    private final MachineTier b;

    @NetworkInfo(fieldName = "fluidTank")
    public final mctech.fluid.h<?> a;

    @NetworkInfo(fieldName = "amplifier")
    private int c;

    @NetworkInfo(fieldName = "maxAmplifier")
    private int d;

    public B(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.MASS_FABRICATOR.get(), blockPos, blockState, mctech.h.a.c.k.get(blockState.getValue(MachineTier.PROPERTY)));
    }

    public B(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, mctech.h.a.c.l lVar) {
        super(blockEntityType, blockPos, blockState, 0, lVar.a, lVar.b);
        this.b = blockState.getValue(MachineTier.PROPERTY);
        this.a = new mctech.fluid.h(lVar.c).b(true);
        this.inventoryManager = new mctech.m.e.j<>(this, lVar.d);
        switch (AnonymousClass1.a[this.b.ordinal()]) {
            case 1:
                this.inventoryManager.a(mctech.m.g.y.f(0).a(new mctech.m.c.m(this))).a(mctech.m.g.y.d(1));
                break;
            case 2:
            case 3:
                this.inventoryManager.a(mctech.m.g.y.f(0).a(new mctech.m.c.m(this))).a(mctech.m.g.y.f(1).a(itemStack -> {
                    return itemStack.is(MCTechItems.SCRAPBOX);
                })).a(mctech.m.g.y.d(2)).a(this);
                break;
        }
        this.inventoryManager.i();
    }

    /* JADX INFO: renamed from: mctech.blockentities.c.B$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/B$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MachineTier.values().length];

        static {
            try {
                a[MachineTier.T5.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[MachineTier.T6.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[MachineTier.T7.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    @Override // mctech.blockentities.e
    public boolean supportsNotify() {
        return false;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return getStoredEU();
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return getMaxEU();
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public mctech.fluid.h<?> c() {
        return this.a;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new mctech.m.b.U(this, player, i);
    }

    @Override // mctech.api.tiles.IMachine
    public int getAvailableEnergy() {
        return this.energy;
    }

    @Override // mctech.api.tiles.IMachine
    public boolean isMachineWorking() {
        return isActive();
    }

    @Override // mctech.api.tiles.IMachine
    public void setRedstoneSensitive(boolean z) {
    }

    @Override // mctech.api.tiles.IMachine
    public boolean isRedstoneSensitive() {
        return false;
    }

    @Override // mctech.api.tiles.IMachine
    public IItemHandler getConnectedInventory(Direction direction) {
        return null;
    }

    @Override // mctech.api.tiles.IFluidMachine
    @Nullable
    public IFluidHandler getConnectedTank(@Nullable Direction direction) {
        return null;
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return EnumSet.of(IUpgradeItem.UpgradeType.MASS_FABRICATOR_MOD);
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ItemInsertionHelper.getValidRoom(this, itemStack);
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return MCTechRecipes.type("mass_fabricator");
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public float getProgressPerTick() {
        return 1.0f;
    }

    @NotNull
    public MachineTier machineTier() {
        return this.b;
    }

    @Override // mctech.api.network.tile.INetworkFluidTankFillListener
    @Nullable
    public IFluidHandler getFluidHandler(int i) {
        return this.a;
    }
}
