package mctech.blockentities;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import java.util.EnumSet;
import java.util.Set;
import mctech.MCTech;
import mctech.api.features.IInventoryMachine;
import mctech.api.features.ITileActivityProvider;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.recipes.ingridients.queue.IInputter;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.api.util.DirectionList;
import mctech.init.MCTechSounds;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.registries.DeferredHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/k.class */
public abstract class k extends e implements IInventoryMachine, ITileActivityProvider, IInputter, IProgressMachine, mctech.m.f.f {
    protected String isWorkingString;
    public final int upgradeSlots;
    protected mctech.blocks.base.a.h storage;
    protected mctech.d.d<IItemHandler> invCache;
    protected Object2IntLinkedOpenHashMap<Recipe<?>> processedRecipes;
    protected mctech.m.a.g[] inOut;

    @NetworkInfo(fieldName = "upgradeHandler")
    protected mctech.m.e.l<k> upgradeHandler;
    protected mctech.c.g audioSource;

    @NetworkInfo(fieldName = "soundLevel")
    protected float soundLevel;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/k$a.class */
    public enum a {
        FAIL,
        PASS,
        SUCCESS,
        IGNORE
    }

    protected abstract void createInvCaches();

    public k(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3, int i4, int i5, int i6) {
        super(blockEntityType, blockPos, blockState, i + i2, i6, i5);
        this.isWorkingString = "isActive";
        this.soundLevel = 1.0f;
        this.storage = new mctech.blocks.base.a.h();
        this.invCache = new mctech.d.b(this, DirectionList.ALL, Capabilities.ItemHandler.BLOCK);
        this.processedRecipes = new Object2IntLinkedOpenHashMap<>();
        this.upgradeHandler = new mctech.m.e.l<>(this, i3, i4, i5, 1.0f);
        this.upgradeSlots = i2;
        addCaches(this.invCache);
        addNetworkFields(this);
        addGuiFields(this);
    }

    public boolean canProcess() {
        return !isRedstoneSensitive() || isRedstonePowered();
    }

    public int getEnergyPerTick() {
        return this.upgradeHandler.b();
    }

    @Override // mctech.api.tiles.IMachine
    public int getAvailableEnergy() {
        return this.energy;
    }

    public boolean isMachineWorking() {
        return isActive();
    }

    @Override // mctech.api.tiles.IMachine
    public void setRedstoneSensitive(boolean z) {
        this.redstoneSensitive = z;
    }

    @Override // mctech.api.tiles.IMachine
    public boolean isRedstoneSensitive() {
        return this.redstoneSensitive;
    }

    @Override // mctech.api.tiles.IMachine
    public IItemHandler getConnectedInventory(Direction direction) {
        if (getInventoryHandler().e(direction)) {
            return this.invCache.b(direction);
        }
        return null;
    }

    public DeferredHolder<SoundEvent, SoundEvent> getWorkingSound() {
        return null;
    }

    public DeferredHolder<SoundEvent, SoundEvent> getInterruptionSound() {
        return MCTechSounds.INTERRUPTION;
    }

    protected void playMachineSound(boolean z) {
        MCTech.AUDIO.a(this, z ? getInterruptionSound() : getWorkingSound(), mctech.c.b.a.STATIC, this.soundLevel, 1.0f);
    }

    @Override // mctech.blockentities.i, mctech.blockentities.q
    @OverridingMethodsMustInvokeSuper
    public void onUnloaded(boolean z) {
        super.onUnloaded(z);
        MCTech.AUDIO.a(this);
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkFieldNotifier
    @OverridingMethodsMustInvokeSuper
    public void onNetworkFieldChanged(Set<String> set, Player player) {
        super.onNetworkFieldChanged(set, player);
        if (set.contains(this.isWorkingString)) {
            if (this.audioSource == null || !this.audioSource.a()) {
                this.audioSource = MCTech.AUDIO.a(this, getWorkingSound(), mctech.c.b.a.STATIC, this.soundLevel, true, false);
            }
            playOrStop(this.audioSource, isMachineWorking());
        }
        if (set.contains("soundLevel") && this.audioSource != null) {
            this.audioSource.a(this.soundLevel);
        }
    }

    @Override // mctech.api.features.IInventoryMachine
    public mctech.m.a.g getInputInventory() {
        if (this.inOut == null) {
            createInvCaches();
        }
        return this.inOut[0];
    }

    @Override // mctech.api.features.IInventoryMachine
    public mctech.m.a.g getOutputInventory() {
        if (this.inOut == null) {
            createInvCaches();
        }
        return this.inOut[1];
    }

    protected void onRecipeProcessed(Recipe<?> recipe) {
        this.processedRecipes.addTo(recipe, 1);
    }

    @Override // mctech.m.f.f
    public void onNotify(mctech.m.a.g gVar, int i) {
    }

    protected int getMinimumEnergyUsage() {
        return 1;
    }

    @Override // mctech.api.recipes.ingridients.queue.IInputter
    public void addItemIntoSlot(int i, ItemStack itemStack) {
        int iB;
        ItemStack itemStack2 = (ItemStack) this.inventory.get(i);
        if (itemStack2.isEmpty()) {
            if (itemStack.getCount() > itemStack.getMaxStackSize()) {
                this.inventory.set(i, mctech.utils.c.h.a(itemStack, itemStack.getMaxStackSize()));
                itemStack.shrink(itemStack.getMaxStackSize());
                return;
            } else {
                this.inventory.set(i, itemStack.copy());
                itemStack.setCount(0);
                return;
            }
        }
        if (mctech.utils.c.h.d(itemStack2, itemStack) && (iB = mctech.utils.c.h.b(itemStack2)) > 0) {
            if (iB >= itemStack.getCount()) {
                itemStack2.grow(itemStack.getCount());
                itemStack.setCount(0);
            } else {
                itemStack.shrink(iB);
                itemStack2.setCount(itemStack2.getMaxStackSize());
            }
        }
    }

    protected boolean addItemsToInventory() {
        ItemStack itemStack = (ItemStack) this.inventory.get(2);
        return itemStack.isEmpty() || itemStack.getCount() < itemStack.getMaxStackSize();
    }

    @Override // mctech.blockentities.e
    public boolean supportsNotify() {
        return true;
    }

    @Override // mctech.blockentities.e, mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return getFacing() != direction && direction.getAxis().isHorizontal();
    }

    @Override // mctech.blockentities.e, mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.blockentities.e, mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.85d - (0.05d * ((double) this.baseTier));
    }

    /* JADX INFO: renamed from: mctech.blockentities.k$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/k$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MachineTier.values().length];

        static {
            try {
                a[MachineTier.T3.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[MachineTier.T4.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[MachineTier.T5.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[MachineTier.T6.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[MachineTier.T7.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    protected EnumSet<IUpgradeItem.UpgradeType> defaultUpgrades(MachineTier machineTier) {
        switch (AnonymousClass1.a[machineTier.ordinal()]) {
            case 1:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 2:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 3:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 4:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 5:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM, IUpgradeItem.UpgradeType.COMPLEX_HANDLER_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD, IUpgradeItem.UpgradeType.TRANSFORMER_MOD);
            default:
                return EnumSet.noneOf(IUpgradeItem.UpgradeType.class);
        }
    }
}
