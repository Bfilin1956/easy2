package mctech.blockentities.c;

import java.util.EnumSet;
import java.util.Optional;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.util.ItemInsertionHelper;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechSounds;
import mctech.init.MCTechTiles;
import mctech.m.b.C0143c;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.blockentities.c.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/a.class */
public class C0054a extends BasicMachineTileEntity implements IMachineTier {
    private static final String a = "interruption";
    private static final String b = "working";
    private final MachineTier c;
    private final int d;

    @NetworkInfo(fieldName = "multiProgress")
    private float[] e;

    @NetworkInfo(fieldName = "multiProgressMax")
    private int[] f;

    @NetworkInfo(fieldName = "multiRecipeEnergy")
    private int[] g;

    public C0054a(BlockPos blockPos, BlockState blockState) {
        this(blockPos, blockState, blockState.getValue(MachineTier.PROPERTY), mctech.h.a.b.i.get(blockState.getValue(MachineTier.PROPERTY)));
    }

    public C0054a(BlockPos blockPos, BlockState blockState, MachineTier machineTier, mctech.h.a.b.C0019b c0019b) {
        super((BlockEntityType) MCTechTiles.ALLOY_SMELTER.get(), blockPos, blockState, 0, 0, c0019b.a, 800, c0019b.b, c0019b.c);
        this.inventoryManager = new mctech.m.e.j<>(this, machineTier.isAtLeast(MachineTier.T3) ? 4 : 0);
        this.c = machineTier;
        this.d = a(machineTier);
        this.e = new float[this.d];
        this.f = new int[this.d];
        this.g = new int[this.d];
        for (int i = 0; i < this.d; i++) {
            this.inventoryManager.a(mctech.m.g.y.f(a(i)).a(new mctech.m.c.n(this, 0)));
            this.inventoryManager.a(mctech.m.g.y.f(b(i)).a(new mctech.m.c.n(this, 1)));
            this.inventoryManager.a(mctech.m.g.y.d(c(i)));
        }
        this.inventoryManager.a(this);
        this.inventoryManager.i();
        addGuiFields(this);
        addNetworkFields(this);
    }

    @Override // mctech.blockentities.k
    public DeferredHolder<SoundEvent, SoundEvent> getWorkingSound() {
        return MCTechSounds.ELECTRIC_FURNACE;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ItemInsertionHelper.getValidRoom(this, itemStack);
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return (RecipeType) MCTechRecipes.ALLOY_SMELTER.get();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.blockentities.k, mctech.api.tiles.IMachineInfo
    public int getEnergyPerTick() {
        return this.upgradeHandler.b();
    }

    public int a() {
        return this.d;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public int getSlots() {
        return a();
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgressSlot(int i) {
        return this.e[i];
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgressSlot(int i) {
        return this.f[i];
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return getProgressSlot(0);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return getMaxProgressSlot(0);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return defaultUpgrades(machineTier());
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0143c(this, player, i);
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    public Optional<RecipeHolder<Recipe<RecipeInput>>> getRecipeFor(ItemStack itemStack) {
        return Optional.empty();
    }

    private int a(int i) {
        return i * 3;
    }

    private int b(int i) {
        return a(i) + 1;
    }

    private int c(int i) {
        return b(i) + 1;
    }

    private void d(int i) {
        this.e[i] = 0.0f;
        updateGuiField(this, "multiProgress");
        updateNetworkField(this, "multiProgress");
    }

    private void b() {
        for (int i = 0; i < this.d; i++) {
            d(i);
        }
    }

    private void e(int i) {
        float[] fArr = this.e;
        fArr[i] = fArr[i] + this.upgradeHandler.a();
        updateGuiField(this, "multiProgress");
        updateNetworkField(this, "multiProgress");
    }

    private void f(int i) {
        this.e[i] = Math.max(0.0f, this.e[i] - 1.0f);
        updateGuiField(this, "multiProgress");
        updateNetworkField(this, "multiProgress");
    }

    private void c() {
        for (int i = 0; i < this.d; i++) {
            f(i);
        }
    }

    private void d() {
        for (int i = 0; i < this.d; i++) {
            e(i);
        }
    }

    @Override // mctech.api.features.redstone.IComparable
    public boolean isAllowingUI() {
        return false;
    }

    @Override // mctech.blockentities.i, mctech.m.e.e
    public boolean allowsUI() {
        return false;
    }

    @NotNull
    public MachineTier machineTier() {
        return this.c;
    }

    /* JADX INFO: renamed from: mctech.blockentities.c.a$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/a$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MachineTier.values().length];

        static {
            try {
                a[MachineTier.T2.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[MachineTier.T3.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[MachineTier.T4.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[MachineTier.T5.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[MachineTier.T6.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[MachineTier.T7.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private static int a(MachineTier machineTier) {
        switch (AnonymousClass1.a[machineTier.ordinal()]) {
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 5;
            case 6:
                return 9;
            default:
                return 0;
        }
    }
}
