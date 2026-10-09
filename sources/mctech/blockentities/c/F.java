package mctech.blockentities.c;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.ISortMachine;
import mctech.api.util.DirectionList;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechSounds;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/F.class */
public class F extends BasicMachineTileEntity implements ISortMachine, InterfaceC0102o, IMachineTier {
    private final Map<int[], Integer> g;
    private int[] h;

    @NetworkInfo(fieldName = "multiProgress")
    public float[] a;

    @NetworkInfo(fieldName = "multiProgressMax")
    public float[] b;
    public double[] c;
    private Recipe<?>[] i;

    @NetworkInfo(fieldName = "inputSorter")
    private mctech.utils.s j;

    @NetworkInfo(fieldName = "inputTank")
    @GuiField(fieldName = "inputTank")
    public mctech.fluid.h<?> d;

    @NetworkInfo(fieldName = "outputTank")
    @GuiField(fieldName = "outputTank")
    public mctech.fluid.h<?> e;
    public mctech.m.e.j<F> f;
    private mctech.h.a.b.C0019b k;
    private int l;
    private MachineTier m;

    /* JADX INFO: renamed from: mctech.blockentities.c.F$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/F$1.class */
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

    private static int a(MachineTier machineTier) {
        switch (AnonymousClass1.a[machineTier.ordinal()]) {
            case 1:
                return 3;
            case 2:
                return 5;
            case 3:
                return 9;
            default:
                return 0;
        }
    }

    public F(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        this(blockEntityType, blockPos, blockState, blockState.getValue(MachineTier.PROPERTY));
    }

    public F(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, MachineTier machineTier) {
        super(blockEntityType, blockPos, blockState, a(machineTier) * a(machineTier), 4, mctech.h.a.b.m.get(machineTier).a, 400, mctech.h.a.b.m.get(machineTier).b, mctech.h.a.b.m.get(machineTier).c);
        this.g = new HashMap();
        this.m = machineTier;
        this.l = a(machineTier);
        this.k = mctech.h.a.b.m.get(machineTier);
        this.f = new mctech.m.e.j<>(this, 4);
        int i = 0;
        for (int i2 = 0; i2 < this.l; i2++) {
            this.f.a(new mctech.m.g.y(mctech.m.e.k.g, i).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(new mctech.m.c.a.g(this)));
            this.f.a(new mctech.m.g.y(mctech.m.e.k.l, i + 1).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c).b(mctech.m.c.r.d));
            this.f.a(new mctech.m.g.y(mctech.m.e.k.l, i + 2).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c).b(mctech.m.c.r.d));
            i += 3;
        }
        this.f.a(this);
        this.f.i();
        this.j = new mctech.utils.s(getInventoryHandler());
        this.a = new float[this.l];
        this.b = new float[this.l];
        this.i = new Recipe[this.l];
        this.c = new double[this.l];
        this.recipeEnergy = this.k.a;
        addGuiFields(this);
        addNetworkFields(this);
    }

    @Override // mctech.blockentities.k
    public DeferredHolder<SoundEvent, SoundEvent> getWorkingSound() {
        return MCTechSounds.MACERATOR;
    }

    public int a() {
        return this.l;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return (RecipeType) mctech.u.E.a.get();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new mctech.m.b.Z(this, player, i);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.blockentities.k, mctech.api.tiles.IMachineInfo
    public int getEnergyPerTick() {
        long j = 0;
        for (int i = 0; i < this.i.length; i++) {
            if (this.i[i] != null) {
                int energyPerTick = super.getEnergyPerTick() + ((int) this.c[i]);
                j += energyPerTick < 0 ? 2147483647L : energyPerTick;
            }
        }
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public int getSlots() {
        return this.b.length;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgressSlot(int i) {
        return this.a[i];
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgressSlot(int i) {
        return this.b[i];
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
        return this.j;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.blockentities.k
    protected void createInvCaches() {
        this.inOut = this.f.g();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    protected InteractionResult canFillRecipeIntoOutputs(int i, Recipe<?> recipe) {
        return InteractionResult.SUCCESS;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        float f = 0.0f;
        for (float f2 : this.a) {
            f += f2;
        }
        return f / this.l;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        switch (AnonymousClass1.a[this.m.ordinal()]) {
            case 1:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 2:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 3:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM, IUpgradeItem.UpgradeType.COMPLEX_HANDLER_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD, IUpgradeItem.UpgradeType.TRANSFORMER_MOD);
            default:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
        }
    }

    @NotNull
    public MachineTier machineTier() {
        return this.m;
    }

    @Override // mctech.components.a.InterfaceC0102o
    public int tierIndex() {
        return this.m.ordinal();
    }
}
