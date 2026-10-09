package mctech.blockentities;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import mctech.MCTech;
import mctech.api.features.IInventoryMachine;
import mctech.api.features.ITileActivityProvider;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.recipes.ingridients.queue.IInputter;
import mctech.api.tiles.IMachineInfo;
import mctech.api.tiles.IRecipeMachine;
import mctech.api.util.DirectionList;
import mctech.blocks.base.blocks.BaseFacingBlock;
import mctech.init.MCTechSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b.class */
public abstract class b extends e implements IInventoryMachine, ITileActivityProvider, IInputter, IMachineInfo, IRecipeMachine, s {
    public static final EnumSet<IUpgradeItem.UpgradeType> TYPES = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_NANO);
    protected String isWorkingString;
    public final int upgradeSlots;
    protected mctech.blocks.base.a.h storage;
    protected mctech.d.d<IItemHandler> invCache;
    protected Object2IntLinkedOpenHashMap<Recipe<?>> processedRecipes;
    protected List<mctech.u.c.c> outputs;
    protected mctech.m.a.g[] inOut;
    protected IItemHandler[] buildInvCache;
    private int defaultMaxInput;
    protected int outputCount;

    @NetworkInfo(fieldName = "autoExport")
    private boolean autoExport;

    @NetworkInfo(fieldName = "distribution")
    private boolean distribution;
    protected boolean needSort;
    protected final mctech.i.a tier;

    @NetworkInfo(fieldName = "upgradeHandler")
    protected mctech.m.e.l<b> upgradeHandler;
    protected mctech.c.g audioSource;

    @NetworkInfo(fieldName = "soundLevel")
    protected float soundLevel;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b$a.class */
    public enum a {
        FAIL,
        PASS,
        SUCCESS,
        IGNORE
    }

    protected abstract void createInvCaches();

    protected abstract boolean isNeedExport();

    protected abstract void updateAutoExportSlotsState();

    public b(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3, int i4) {
        super(blockEntityType, blockPos, blockState, i + i2, i3, i4);
        this.isWorkingString = "isActive";
        this.storage = new mctech.blocks.base.a.h();
        this.defaultMaxInput = mctech.q.c.c;
        this.outputCount = 1;
        this.tier = blockState.getBlock().getAdvancedTier();
        this.invCache = new mctech.d.b(this, DirectionList.ALL, Capabilities.ItemHandler.BLOCK);
        this.processedRecipes = new Object2IntLinkedOpenHashMap<>();
        this.outputs = mctech.utils.a.b.i();
        this.buildInvCache = null;
        this.soundLevel = 1.0f;
        mctech.h.a.c.k config = getConfig(blockState.getBlock());
        this.defaultMaxInput = config.b;
        setMaxInput(config.b);
        this.baseTier = getTier();
        setMaxEnergy(config.c);
        this.upgradeHandler = new mctech.m.e.l<>(this, config.d, config.e, config.c, 1.0f);
        this.upgradeSlots = i2;
        addCaches(this.invCache);
        addGuiFields(this);
        addNetworkFields(this);
    }

    public DeferredHolder<SoundEvent, SoundEvent> getInterruptionSound() {
        return MCTechSounds.INTERRUPTION;
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

    protected void playMachineSound(boolean z) {
        MCTech.AUDIO.a(this, z ? getInterruptionSound() : getWorkingSound(), mctech.c.b.a.STATIC, this.soundLevel, 1.0f);
    }

    public b(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2) {
        this(blockEntityType, blockPos, blockState, i, i2, 32, 6000);
    }

    protected mctech.h.a.c.k getConfig(Block block) {
        return mctech.h.a.c.a(block);
    }

    @Override // mctech.blockentities.s
    @NotNull
    public Direction getFrontDirection() {
        return getBlockState().getValue(BaseFacingBlock.FACING);
    }

    @Override // mctech.blockentities.q
    public void onBlockUpdate(Block block, BlockPos blockPos) {
        super.onBlockUpdate(block, blockPos);
    }

    @Override // mctech.blockentities.s
    public boolean isAutoExport() {
        return this.autoExport;
    }

    @Override // mctech.blockentities.s
    public boolean isAutoSort() {
        return this.distribution;
    }

    @Override // mctech.blocks.c.o
    @NotNull
    public mctech.i.a getAdvancedTier() {
        return this.tier;
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkClientEventListener
    public void onClientDataReceived(Player player, int i, int i2) {
    }

    public boolean canProcess() {
        return !isRedstoneSensitive() || isRedstonePowered();
    }

    protected DeferredHolder<SoundEvent, SoundEvent> getInterruptSound() {
        return null;
    }

    protected DeferredHolder<SoundEvent, SoundEvent> getStartupSound() {
        return null;
    }

    protected DeferredHolder<SoundEvent, SoundEvent> getWorkingSound() {
        return null;
    }

    @Override // mctech.api.tiles.IMachineInfo
    public int getEnergyPerTick() {
        return this.upgradeHandler.b();
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

    @Override // mctech.api.tiles.IRecipeMachine
    public float getProgressPerTick() {
        return this.upgradeHandler.a();
    }

    protected void onRecipeProcessed(Recipe<?> recipe) {
        this.processedRecipes.addTo(recipe, 1);
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return TYPES;
    }

    protected int getMinimumEnergyUsage() {
        return 1;
    }

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
        if (this.outputs.isEmpty()) {
            return true;
        }
        if (this.autoExport) {
            for (Direction direction : this.invCache.c()) {
                IItemHandler iItemHandlerB = this.invCache.b(direction);
                if (iItemHandlerB != null && getInventoryHandler().d(direction).d()) {
                    this.outputs.removeIf(cVar -> {
                        ItemStack itemStackInsertItem = ItemHandlerHelper.insertItem(iItemHandlerB, cVar.a().copy(), false);
                        if (!itemStackInsertItem.isEmpty()) {
                            cVar.a().setCount(itemStackInsertItem.getCount());
                            return false;
                        }
                        return true;
                    });
                    if (this.outputs.isEmpty()) {
                        break;
                    }
                }
            }
        }
        this.outputs.removeIf(cVar2 -> {
            return cVar2.a(this);
        });
        return this.outputs.isEmpty();
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
}
