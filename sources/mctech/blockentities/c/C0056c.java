package mctech.blockentities.c;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.IntStream;
import mctech.api.features.IClickable;
import mctech.api.features.IXPMachine;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.api.tiles.IFluidMachine;
import mctech.api.tiles.IRecipeMachine;
import mctech.api.util.DirectionList;
import mctech.api.util.ItemInsertionHelper;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import mctech.m.b.C0146f;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: mctech.blockentities.c.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/c.class */
public class C0056c extends mctech.blockentities.b implements IClickable, IXPMachine, INetworkFluidTankFillListener, IFluidMachine, IRecipeMachine, mctech.m.a.k {

    @NetworkInfo(fieldName = "firstTank")
    public mctech.fluid.h<?> a;

    @NetworkInfo(fieldName = "secondTank")
    public mctech.fluid.h<?> b;

    @NetworkInfo(fieldName = "outputTank")
    public mctech.fluid.h<?> c;

    @NetworkInfo(fieldName = "progress")
    @GuiField(fieldName = "progress")
    public float[] d;

    @NetworkInfo(fieldName = "maxProgress")
    @GuiField(fieldName = "maxProgress")
    public float[] e;
    public final mctech.m.e.j<C0056c> f;
    public static final EnumSet<IUpgradeItem.UpgradeType> g = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
    public static final EnumSet<IUpgradeItem.UpgradeType> h = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
    public static final EnumSet<IUpgradeItem.UpgradeType> i = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM, IUpgradeItem.UpgradeType.COMPLEX_HANDLER_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD, IUpgradeItem.UpgradeType.TRANSFORMER_MOD);

    public C0056c(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.ADVANCED_REFINERY.get(), blockPos, blockState, 3 * blockState.getBlock().getAdvancedTier().b(), 4);
        int iB = blockState.getBlock().getAdvancedTier().b();
        setFuelSlot(-1);
        mctech.h.a.c.s sVarB = mctech.h.a.c.b(blockState.getBlock());
        this.a = new mctech.fluid.h(sVarB.f).a(true);
        this.b = new mctech.fluid.h(sVarB.g).a(true);
        this.c = new mctech.fluid.h(sVarB.h).b(true);
        this.f = new mctech.m.e.j<>(this, 4);
        this.f.a(new mctech.m.g.y(mctech.m.e.k.g, IntStream.range(0, iB).toArray()).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(new mctech.m.c.o(this)));
        this.f.a(new mctech.m.g.y(mctech.m.e.k.l, IntStream.range(this.f.c(), this.f.c() + iB).toArray()).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c).b(mctech.m.c.r.d));
        this.f.a(this);
        this.f.i();
        this.d = new float[iB];
        this.e = new float[iB];
        Arrays.fill(this.d, 0.0f);
        Arrays.fill(this.e, 0.0f);
        addGuiFields(this);
        addNetworkFields(this);
        addCaches(new mctech.d.b(this, DirectionList.ALL, Capabilities.FluidHandler.BLOCK));
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
    }

    @Override // mctech.blockentities.b
    protected mctech.h.a.c.k getConfig(Block block) {
        mctech.h.a.c.s sVarB = mctech.h.a.c.b(block);
        return new mctech.h.a.c.k(sVarB.b, sVarB.c, sVarB.d, sVarB.e);
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return 0.0f;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return 0.0f;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public int getSlots() {
        return this.f.b(mctech.m.e.k.g).size();
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return (RecipeType) MCTechRecipes.REFINERY.get();
    }

    @Override // mctech.api.features.IClickable
    public boolean onRightClick(Player player, InteractionHand interactionHand, Direction direction, BlockHitResult blockHitResult) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (itemInHand.isEmpty()) {
            return false;
        }
        return mctech.utils.c.b.b(itemInHand, player, new mctech.fluid.i(this.a, this.b)) || mctech.utils.c.b.a(itemInHand, player, new mctech.fluid.i(this.a, this.b));
    }

    @Override // mctech.api.tiles.IFluidMachine
    public IFluidHandler getConnectedTank(Direction direction) {
        if (direction == null) {
            return new mctech.fluid.i(this.a, this.b, this.c);
        }
        if (getInventoryHandler().d(direction) != mctech.m.e.a.DISABLED) {
            return new mctech.fluid.i(this.a, this.b, this.c);
        }
        return null;
    }

    @Override // mctech.api.network.tile.INetworkFluidTankFillListener
    @Nullable
    public IFluidHandler getFluidHandler(int i2) {
        switch (i2) {
            case 0:
                return this.a;
            case 1:
                return this.b;
            case 2:
                return this.c;
            default:
                return null;
        }
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i2) {
        return new C0146f(this, player, i2);
    }

    @Override // mctech.blockentities.i, mctech.m.e.e
    public boolean allowsUI() {
        return false;
    }

    @Override // mctech.api.features.redstone.IComparable
    public boolean isAllowingUI() {
        return false;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgressSlot(int i2) {
        if (i2 < 0 || i2 >= this.e.length) {
            return 0.0f;
        }
        return this.e[i2];
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgressSlot(int i2) {
        if (i2 < 0 || i2 >= this.d.length) {
            return 0.0f;
        }
        return this.d[i2];
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ItemInsertionHelper.getValidRoom(this, itemStack);
    }

    @Override // mctech.blockentities.b
    protected boolean isNeedExport() {
        return false;
    }

    @Override // mctech.blockentities.b
    protected void updateAutoExportSlotsState() {
    }

    @Override // mctech.blockentities.b
    protected void createInvCaches() {
        this.inOut = this.f.g();
    }

    @Override // mctech.blockentities.b, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        if (getAdvancedTier().equals(mctech.i.a.SINGULAR)) {
            return i;
        }
        if (getAdvancedTier().equals(mctech.i.a.QUANTUM)) {
            return h;
        }
        return g;
    }

    /* JADX INFO: renamed from: mctech.blockentities.c.c$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/c$a.class */
    private static class a {
        final int a;
        mctech.u.W b;
        float c = 0.0f;
        int d;

        a(int i, mctech.u.W w, int i2) {
            this.a = i;
            this.b = w;
            this.d = i2;
        }
    }
}
