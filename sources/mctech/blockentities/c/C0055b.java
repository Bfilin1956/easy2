package mctech.blockentities.c;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import mctech.api.features.IClickable;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.api.tiles.IFluidMachine;
import mctech.api.tiles.ISortMachine;
import mctech.api.util.DirectionList;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.energy.EnergyNetworks;
import mctech.m.b.C0144d;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: mctech.blockentities.c.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/b.class */
public class C0055b extends BasicMachineTileEntity implements IClickable, INetworkFluidTankFillListener, IFluidMachine, ISortMachine, mctech.r.a.a {
    private final Map<int[], Integer> f;
    public mctech.r.a.c a;
    private int[] g;
    private int h;
    private int i;
    private int j;
    private int k;

    @NetworkInfo(fieldName = "multiProgress")
    public float[] b;

    @NetworkInfo(fieldName = "multiProgressMax")
    public float[] c;
    private mctech.r.a.d l;

    @NetworkInfo(fieldName = "inputSorter")
    private mctech.utils.s m;

    @NetworkInfo(fieldName = "inputTank")
    @GuiField(fieldName = "inputTank")
    public mctech.fluid.h<?> d;

    @NetworkInfo(fieldName = "outputTank")
    @GuiField(fieldName = "outputTank")
    public mctech.fluid.h<?> e;

    public C0055b(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 3, 2, 400, 32);
        this.f = new HashMap();
        addGuiFields(this);
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return (RecipeType) this.l.d().get();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0144d(this, player, i);
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public int getSlots() {
        return this.c.length;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgressSlot(int i) {
        return this.b[i];
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgressSlot(int i) {
        return this.c[i];
    }

    protected void a(mctech.m.e.i iVar) {
        iVar.a(DirectionList.ALL);
        iVar.a(DirectionList.ALL, mctech.m.e.a.BOTH);
        createInputSlots(iVar, new mctech.m.c.a.g(this), IntStream.range(0, this.i).toArray());
        switch (this.l) {
            case CHEMICAL_PURIFICATING:
            case INGOT_FOUNDRY:
            case HYDRAULIC_WASHER:
                createOutputSlots(iVar, IntStream.range(this.i, this.i + this.j).toArray());
                break;
            case ORE_MACERATOR:
            case CONCENTRATOR:
                createOutputSlots(iVar, IntStream.range(this.i, this.i + (this.j * 2)).toArray());
                break;
            case ORE_COMBINE:
                createOutputSlots(iVar, IntStream.range(this.i, this.i + (this.j * 3)).toArray());
                break;
        }
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        ItemStack itemStackCopy = itemStack.copy();
        itemStackCopy.setCount(itemStackCopy.getMaxStackSize());
        if (getRecipeFor(itemStackCopy).isEmpty()) {
            return 0;
        }
        return itemStackCopy.getMaxStackSize();
    }

    @Override // mctech.api.features.redstone.IComparable
    public boolean isAllowingUI() {
        return false;
    }

    @Override // mctech.blockentities.i, mctech.m.e.e
    public boolean allowsUI() {
        return false;
    }

    @Override // mctech.api.tiles.ISortMachine
    public mctech.utils.s getSorter() {
        return this.m;
    }

    @Override // mctech.r.a.a
    public void a(mctech.r.a.c cVar) {
        this.a = cVar;
        createInvCaches();
        this.i = cVar.e();
        this.j = cVar.o();
        this.k = this.i + this.j;
        this.b = new float[this.i];
        this.c = new float[this.i];
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.blockentities.k
    protected void createInvCaches() {
        this.inOut = new mctech.m.a.g[2];
        this.inOut[0] = new mctech.m.f.k(this, IntStream.range(0, this.i).toArray());
        this.inOut[1] = new mctech.m.f.k(this, IntStream.range(this.i, this.i + (this.j * 2)).toArray()).a();
    }

    @Override // mctech.r.a.a
    public mctech.r.a.c a() {
        return this.a;
    }

    @Override // mctech.r.a.a
    public int[] b() {
        return this.g;
    }

    @Override // mctech.r.a.a
    public void a(int[] iArr) {
        this.g = iArr;
    }

    @Override // mctech.r.a.a
    public Map<int[], Integer> c() {
        return this.f;
    }

    @Override // mctech.r.a.a
    public void a(int[] iArr, int i) {
        this.f.put(iArr, Integer.valueOf(i));
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public void setSlotCount(int i) {
        this.inventorySize = i;
        this.inventory = NonNullList.withSize(i, ItemStack.EMPTY);
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public void updateInventory(NonNullList<ItemStack> nonNullList) {
        this.inventory = nonNullList;
    }

    @Override // mctech.r.a.a
    public void a(int i) {
        this.h = i;
    }

    @Override // mctech.r.a.a
    public int d() {
        return this.h;
    }

    @Override // mctech.r.a.a
    public void a(mctech.r.a.d dVar) {
        mctech.h.a.b.C0019b c0019b;
        this.l = dVar;
        MachineTier machineTier = MachineTier.values()[this.a.b().tierIndex()];
        switch (this.l) {
            case CHEMICAL_PURIFICATING:
                c0019b = mctech.h.a.b.o.get(machineTier);
                break;
            case INGOT_FOUNDRY:
                c0019b = mctech.h.a.b.n.get(machineTier);
                break;
            case HYDRAULIC_WASHER:
                c0019b = mctech.h.a.b.l.get(machineTier);
                break;
            case ORE_MACERATOR:
                c0019b = mctech.h.a.b.m.get(machineTier);
                break;
            case CONCENTRATOR:
                c0019b = mctech.h.a.b.q.get(machineTier);
                break;
            case ORE_COMBINE:
                c0019b = mctech.h.a.b.p.get(machineTier);
                break;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
        mctech.h.a.b.C0019b c0019b2 = c0019b;
        this.maxInput = c0019b2.c;
        this.maxEnergy = c0019b2.b;
        this.tier = EnergyNetworks.getTierFromPower(this.maxInput);
        this.baseTier = this.tier;
        setSlotCount(this.k + this.upgradeSlots);
        getInventoryHandler().g();
        getInventoryHandler().a(DirectionList.ALL);
        getInventoryHandler().a(DirectionList.ALL, mctech.m.e.a.BOTH);
        a(getInventoryHandler());
        getInventoryHandler().c();
        this.m = new mctech.utils.s(getInventoryHandler());
        b(dVar);
        addGuiFields(this);
        addNetworkFields(this);
    }

    @Override // mctech.r.a.a
    public mctech.r.a.d e() {
        return this.l;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    protected InteractionResult canFillRecipeIntoOutputs(int i, Recipe<?> recipe) {
        return InteractionResult.SUCCESS;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.blockentities.k, mctech.api.tiles.IMachineInfo
    public int getEnergyPerTick() {
        return this.upgradeHandler.b();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        float f = 0.0f;
        for (float f2 : this.b) {
            f += f2;
        }
        return f / this.i;
    }

    @Override // mctech.api.tiles.IFluidMachine
    public IFluidHandler getConnectedTank(@NotNull Direction direction) {
        return provide(direction, getInventoryHandler(), this.d, this.e);
    }

    @Override // mctech.api.features.IClickable
    public boolean onRightClick(Player player, InteractionHand interactionHand, Direction direction, BlockHitResult blockHitResult) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        return !itemInHand.isEmpty() && (mctech.utils.c.b.b(itemInHand, player, this.d) || mctech.utils.c.b.a(itemInHand, player, (IFluidHandler) this.d));
    }

    @Override // mctech.api.network.tile.INetworkFluidTankFillListener
    @Nullable
    public IFluidHandler getFluidHandler(int i) {
        switch (i) {
            case 0:
                return this.d;
            case 1:
                return this.e;
            default:
                return null;
        }
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkClientEventListener
    public void onClientDataReceived(Player player, int i, int i2) {
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        switch (this.a) {
            case NANO:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case QUANT:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case SINGULAR:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM, IUpgradeItem.UpgradeType.COMPLEX_HANDLER_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD, IUpgradeItem.UpgradeType.TRANSFORMER_MOD);
            default:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
        }
    }

    private void b(mctech.r.a.d dVar) {
        int i;
        switch (this.a) {
            case NANO:
                i = 32000;
                break;
            case QUANT:
                i = 64000;
                break;
            case SINGULAR:
                i = 128000;
                break;
            default:
                i = 16000;
                break;
        }
        if (dVar.g() > 0) {
            this.d = new mctech.fluid.h(i).a(true);
        }
        if (dVar.g() > 1) {
            this.e = new mctech.fluid.h(i).b(true);
        }
    }

    public MachineTier machineTier() {
        return MachineTier.values()[this.a.b().tierIndex()];
    }
}
