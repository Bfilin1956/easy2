package mctech.blockentities;

import com.google.common.base.Strings;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mctech.MCTech;
import mctech.api.features.IProfileListener;
import mctech.api.features.redstone.IComparable;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkClientEventListener;
import mctech.api.network.tile.INetworkFieldNotifier;
import mctech.api.network.tile.INetworkFieldProvider;
import mctech.api.util.DirectionList;
import mctech.blocks.base.blocks.BaseActivityBlock;
import mctech.blocks.base.blocks.BaseFacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.network.PacketDistributor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/q.class */
public abstract class q extends BlockEntity implements IProfileListener, IComparable, INetworkClientEventListener, INetworkFieldNotifier, INetworkFieldProvider, mctech.utils.e.b, Nameable {
    boolean loaded;
    boolean locked;
    boolean recache;
    boolean adding;
    boolean removing;
    mctech.utils.a.g profiler;

    @NetworkInfo(fieldName = "isActive")
    private boolean isActive;

    @NetworkInfo(fieldName = "customName")
    private String customName;
    long position;
    public boolean needsRedstoneUpdate;
    public boolean redstoneSensitive;
    public boolean directionalSignal;
    public boolean inverted;
    protected byte[] sidedSignals;
    protected byte signal;

    @NetworkInfo(fieldName = "comparators")
    protected mctech.blocks.base.a.a.c comparators;
    List<mctech.d.d<?>> caches;
    boolean updatingCaches;

    protected q(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.loaded = false;
        this.locked = false;
        this.recache = false;
        this.adding = false;
        this.removing = false;
        this.profiler = null;
        this.isActive = false;
        this.customName = "";
        this.needsRedstoneUpdate = needsInitialRedstoneCheck();
        this.redstoneSensitive = true;
        this.directionalSignal = false;
        this.inverted = false;
        this.sidedSignals = new byte[6];
        this.signal = (byte) 0;
        this.comparators = new mctech.blocks.base.a.a.c(this);
        this.caches = mctech.utils.a.b.i();
        this.updatingCaches = false;
        this.position = Mth.getSeed(blockPos) & 4294967295L;
        addNetworkFields(this);
    }

    public void onClientDataReceived(Player player, int i, int i2) {
    }

    public final boolean isSimulating() {
        return false;
    }

    public final boolean isRendering() {
        return true;
    }

    public void onNetworkFieldChanged(Set<String> set, Player player) {
    }

    @Override // mctech.api.network.tile.INetworkFieldNotifier
    public void onGuiFieldChanged(Set<String> set, Player player) {
    }

    @Override // mctech.api.network.tile.INetworkFieldProvider
    public boolean isDefaultData(String str) {
        if (str.equals("isActive")) {
            return !this.isActive;
        }
        return str.equals("customName") && Strings.isNullOrEmpty(this.customName);
    }

    public boolean hasCustomName() {
        return !Strings.isNullOrEmpty(this.customName);
    }

    public Component getCustomName() {
        return Component.literal(this.customName);
    }

    public Component getName() {
        return Component.translatable(getBlockState().getBlock().getDescriptionId());
    }

    @Override // mctech.api.features.IProfileListener
    public void onProfile(long j) {
        if (this.profiler == null) {
            this.profiler = new mctech.utils.a.g(20);
        }
        this.profiler.a(j);
    }

    @Override // mctech.api.features.IProfileListener
    public long getLag() {
        if (this.profiler == null) {
            return 0L;
        }
        return this.profiler.c();
    }

    @Override // mctech.api.features.IProfileListener
    public MutableComponent showResults() {
        if (this.profiler != null) {
            long jE = this.profiler.e();
            return c("misc.mctech.tick.lag", mctech.utils.c.c.e.format(jE / 1000000), mctech.utils.c.c.e.format(jE / 1000), mctech.utils.c.c.e.format(jE));
        }
        return f("misc.mctech.tick.disabled");
    }

    public boolean needsUpdateTick() {
        return false;
    }

    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public final void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
    }

    protected final void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
    }

    public void setRemoved() {
        if (this.loaded) {
            onUnloaded(false);
        }
        super.setRemoved();
    }

    public void onChunkUnloaded() {
        if (this.loaded) {
            onUnloaded(true);
        }
        super.onChunkUnloaded();
    }

    public void onLoad() {
        super.onLoad();
        if (!this.loaded) {
            onLoaded();
        }
    }

    public void onLoaded() {
        this.loaded = true;
    }

    public void onUnloaded(boolean z) {
        this.loaded = false;
        this.caches.clear();
    }

    public boolean isActive() {
        return this.isActive;
    }

    public boolean setActive(boolean z) {
        if (this.level != null) {
            boolean zHasProperty = getBlockState().hasProperty(BaseActivityBlock.ACTIVE);
            if (((Boolean) getBlockState().getOptionalValue(BaseActivityBlock.ACTIVE).orElse(false)).booleanValue() != z && zHasProperty) {
                this.level.setBlock(getBlockPos(), (BlockState) getBlockState().setValue(BaseActivityBlock.ACTIVE, Boolean.valueOf(z)), 2);
            }
        }
        if (this.isActive == z) {
            return false;
        }
        this.isActive = z;
        updateNetworkField(this, "isActive");
        updateGuiField(this, "isActive");
        return true;
    }

    public Direction getFacing() {
        return getBlockState().getValue(BaseFacingBlock.FACING);
    }

    protected void disableProfiling() {
        this.profiler = null;
    }

    protected boolean isRemoving() {
        return this.removing;
    }

    protected boolean isAdding() {
        return this.adding;
    }

    public void handleRedstone() {
        if (this.needsRedstoneUpdate && this.redstoneSensitive) {
            this.needsRedstoneUpdate = false;
            if (this.directionalSignal) {
                byte bMax = 0;
                for (Direction direction : DirectionList.ALL) {
                    byte bClamp = (byte) Mth.clamp(this.level.getSignal(getBlockPos(), direction), 0, 15);
                    bMax = (byte) Math.max((int) bMax, (int) bClamp);
                    this.sidedSignals[direction.get3DDataValue()] = bClamp;
                }
                this.signal = bMax;
                return;
            }
            this.signal = (byte) Mth.clamp(this.level.getBestNeighborSignal(this.worldPosition), 0, 15);
        }
    }

    public int getRedstoneStrength() {
        if (this.redstoneSensitive) {
            return this.inverted ? 15 - this.signal : this.signal;
        }
        return this.inverted ? 15 : 0;
    }

    public int getSidedRedstoneStrength(Direction direction) {
        if (this.redstoneSensitive) {
            return this.inverted ? 15 - this.sidedSignals[direction.get3DDataValue()] : this.sidedSignals[direction.get3DDataValue()];
        }
        return this.inverted ? 15 : 0;
    }

    public boolean isRedstonePowered() {
        return getRedstoneStrength() > 0;
    }

    public boolean isSideRedstonePowered(Direction direction) {
        return getSidedRedstoneStrength(direction) > 0;
    }

    public void addCaches(mctech.d.d<?>... dVarArr) {
        this.caches.addAll(ObjectArrayList.wrap(dVarArr));
        for (mctech.d.d<?> dVar : dVarArr) {
            if (dVar != null) {
                dVar.a(this::recache);
            }
        }
    }

    protected void recache() {
        if (this.recache || isRendering() || !this.loaded) {
            return;
        }
        this.recache = true;
        MCTech.TICK_HANDLER.addWorldCallback(getLevel(), level -> {
            this.recache = false;
            if (!this.loaded) {
                return 0;
            }
            Iterator<mctech.d.d<?>> it = this.caches.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            onCachesUpdated();
            return 0;
        });
    }

    protected void onCachesUpdated() {
    }

    public final long clockTime(int i) {
        return Math.abs(this.level.getGameTime() + this.position) % ((long) i);
    }

    public final boolean clock(int i) {
        return Math.abs(this.level.getGameTime() + this.position) % ((long) i) == 0;
    }

    public final boolean invClock(int i) {
        return Math.abs(this.level.getGameTime() + this.position) % ((long) i) != 0;
    }

    public final boolean isAreaLoaded(int i) {
        return this.level.isAreaLoaded(this.worldPosition, i);
    }

    public final boolean isAreaLoaded(BlockPos blockPos, int i) {
        return this.level.isAreaLoaded(blockPos, i);
    }

    public void onBlockUpdate(Block block, BlockPos blockPos) {
        this.needsRedstoneUpdate = this.redstoneSensitive;
        if (isSimulating() && this.caches.size() > 0) {
            for (mctech.d.d<?> dVar : this.caches) {
                if (dVar != null) {
                    dVar.d();
                }
            }
            onCachesUpdated();
        }
    }

    public mctech.blocks.base.a.a.c getManager() {
        return this.comparators;
    }

    public boolean shouldBlockUpdateEnableTick() {
        return false;
    }

    public final void sendToServer(int i, int i2) {
        PacketDistributor.sendToServer(new mctech.q.d.a.a.C0034a(getBlockPos(), i, i2), new CustomPacketPayload[0]);
    }

    public final <T extends Comparable<T>> boolean withState(Property<T> property, T t) {
        return setState((BlockState) getBlockState().setValue(property, t));
    }

    public final boolean setState(BlockState blockState) {
        return blockState != getBlockState() && this.level.isLoaded(this.worldPosition) && this.level.setBlockAndUpdate(this.worldPosition, blockState);
    }

    public final boolean setState(BlockState blockState, int i) {
        return blockState != getBlockState() && this.level.isLoaded(this.worldPosition) && this.level.setBlock(this.worldPosition, blockState, i);
    }

    public final <T extends Comparable<T>> boolean withState(Property<T> property, T t, int i) {
        return setState((BlockState) getBlockState().setValue(property, t), i);
    }

    public final <T extends Comparable<T>> T getValue(Property<T> property) {
        return (T) getBlockState().getValue(property);
    }

    public final <T extends Comparable<T>> T getValue(Property<T> property, T t) {
        return getBlockState().hasProperty(property) ? (T) getBlockState().getValue(property) : t;
    }

    public final void sendToServer(String str, INetworkDataBuffer iNetworkDataBuffer) {
        PacketDistributor.sendToServer(new mctech.q.d.a.c.b(new mctech.q.d.a.c.a(getBlockPos(), str, iNetworkDataBuffer)), new CustomPacketPayload[0]);
    }

    public final void addComparator(mctech.blocks.base.a.a.a aVar) {
        this.comparators.a(aVar);
    }

    public final void lock() {
        this.locked = true;
    }

    public final void unlock() {
        this.locked = false;
    }

    public void setFacing(Direction direction) {
        if (direction == null) {
        }
    }

    protected boolean needsInitialRedstoneCheck() {
        return false;
    }

    public void onComparatorUpdate(BlockPos blockPos) {
    }

    public void notifyChanges(boolean z, DirectionList directionList, BlockPos blockPos) {
        if (z) {
            this.level.neighborChanged(blockPos, getBlockState().getBlock(), blockPos);
        }
        Iterator<Direction> it = directionList.iterator();
        while (it.hasNext()) {
            BlockPos blockPosRelative = blockPos.relative(it.next());
            if (this.level.isLoaded(blockPosRelative)) {
                this.level.neighborChanged(blockPosRelative, getBlockState().getBlock(), blockPos);
            }
        }
    }

    public void notifyChanges(boolean z, DirectionList directionList) {
        if (z) {
            this.level.neighborChanged(getBlockPos(), getBlockState().getBlock(), getBlockPos());
        }
        this.level.updateNeighborsAt(getBlockPos(), getBlockState().getBlock());
        for (Direction direction : directionList) {
            BlockPos blockPosRelative = getBlockPos().relative(direction);
            if (this.level.isLoaded(blockPosRelative)) {
                this.level.updateNeighborsAtExceptFromFacing(blockPosRelative, getBlockState().getBlock(), direction.getOpposite());
            }
        }
    }

    public final boolean isLoaded() {
        return this.loaded;
    }

    protected final void playOrStop(mctech.c.g gVar, boolean z) {
        playLopping(gVar, z);
    }

    protected final void playLopping(mctech.c.g gVar, boolean z) {
        if (gVar == null || !gVar.a()) {
            return;
        }
        if (!gVar.c() && z) {
            gVar.i();
        } else if (gVar.c() && !z) {
            gVar.k();
        }
    }
}
