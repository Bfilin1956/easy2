package mctech.a.a.a;

import appeng.api.implementations.blockentities.IColorableBlockEntity;
import appeng.api.networking.GridFlags;
import appeng.api.networking.IGridNode;
import appeng.api.networking.IGridNodeListener;
import appeng.api.upgrades.IUpgradeInventory;
import appeng.api.upgrades.IUpgradeableObject;
import appeng.api.upgrades.UpgradeInventories;
import appeng.api.util.AECableType;
import appeng.api.util.AEColor;
import appeng.blockentity.ServerTickingBlockEntity;
import appeng.blockentity.grid.AENetworkedBlockEntity;
import appeng.core.definitions.AEItems;
import com.glodblock.github.extendedae.common.me.wireless.WirelessConnect;
import com.glodblock.github.extendedae.common.me.wireless.WirelessNode;
import com.glodblock.github.extendedae.config.EAEConfig;
import com.glodblock.github.extendedae.util.CacheHolder;
import com.glodblock.github.extendedae.xmod.jade.JadeDataProvider;
import com.glodblock.github.glodium.util.GlodUtil;
import gripe._90.megacells.definition.MEGAItems;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/a/a/a.class */
public class a extends AENetworkedBlockEntity implements IColorableBlockEntity, IUpgradeableObject, ServerTickingBlockEntity, WirelessNode, JadeDataProvider, mctech.a.a {
    private final int a;
    private final IUpgradeInventory b;
    private final WirelessConnect c;
    private final CacheHolder<BlockPos> d;
    private boolean e;
    private long f;
    private double g;

    @NotNull
    private AEColor h;

    public a(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, ItemLike itemLike) {
        super(blockEntityType, blockPos, blockState);
        this.d = CacheHolder.empty();
        this.e = true;
        this.h = AEColor.TRANSPARENT;
        this.a = i;
        getMainNode().setExposedOnSides(EnumSet.allOf(Direction.class));
        getMainNode().setFlags(new GridFlags[]{GridFlags.DENSE_CAPACITY});
        this.g = 1.0d;
        getMainNode().setIdlePowerUsage(this.g);
        this.c = new WirelessConnect(this);
        this.b = UpgradeInventories.forMachine(itemLike, 4, this::b);
    }

    @Override // mctech.a.a
    public int a() {
        return this.a;
    }

    public void serverTick() {
        if (!this.e) {
            return;
        }
        this.e = false;
        this.d.expired();
        this.c.updateStatus();
        b();
        markForUpdate();
        e();
    }

    public IGridNode getGridNode() {
        return getMainNode().getNode();
    }

    public BlockEntity getBlockEntity() {
        return this;
    }

    public void b() {
        double dK = 1.0d - k();
        if (this.c.isConnected()) {
            double dMax = Math.max(this.c.getDistance(), 2.718281828459045d);
            this.g = Math.max(1.0d, dMax * Math.log(dMax) * dK);
            this.g *= EAEConfig.wirelessPowerMultiplier;
        } else {
            this.g = EAEConfig.wirelessPowerMultiplier;
        }
        getMainNode().setIdlePowerUsage(this.g);
    }

    private double k() {
        double installedUpgrades = 0.1d * ((double) this.b.getInstalledUpgrades(AEItems.ENERGY_CARD));
        if (GlodUtil.checkMod("megacells")) {
            installedUpgrades += 0.2d * ((double) this.b.getInstalledUpgrades(MEGAItems.GREATER_ENERGY_CARD));
        }
        return installedUpgrades;
    }

    public double c() {
        return this.g;
    }

    @Nullable
    public BlockPos d() {
        if (!this.c.isConnected()) {
            return null;
        }
        if (!this.d.isValid()) {
            this.d.update(this.c.getOtherSide());
        }
        return (BlockPos) this.d.get();
    }

    public void onMainNodeStateChanged(IGridNodeListener.State state) {
        this.e = true;
    }

    public void e() {
        this.c.active();
    }

    public void f() {
        e();
        getMainNode().setExposedOnSides(EnumSet.allOf(Direction.class));
    }

    public void onChunkUnloaded() {
        h();
        super.onChunkUnloaded();
    }

    public void onReady() {
        super.onReady();
        this.e = true;
    }

    public void setRemoved() {
        h();
        super.setRemoved();
    }

    public void loadTag(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadTag(compoundTag, provider);
        this.f = compoundTag.getLong("freq");
        this.b.readFromNBT(compoundTag, "upgrades", provider);
        if (compoundTag.contains("color")) {
            this.h = AEColor.valueOf(compoundTag.getString("color"));
        } else {
            this.h = AEColor.TRANSPARENT;
        }
        getMainNode().setGridColor(this.h);
        WirelessConnect.G.markUsed(Long.valueOf(this.f));
    }

    public void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        compoundTag.putLong("freq", this.f);
        this.b.writeToNBT(compoundTag, "upgrades", provider);
        compoundTag.putString("color", this.h.name());
        WirelessConnect.G.markUsed(Long.valueOf(this.f));
    }

    public void a(long j) {
        this.f = j;
        this.e = true;
        setChanged();
    }

    public long g() {
        return ((Long) WirelessConnect.G.genFreq()).longValue();
    }

    public void h() {
        this.c.destroy();
    }

    public boolean i() {
        return this.c.isConnected();
    }

    public AECableType getCableConnectionType(Direction direction) {
        return AECableType.DENSE_SMART;
    }

    public void j() {
        this.c.destroy();
    }

    public long getFrequency() {
        return this.f;
    }

    public IUpgradeInventory getUpgrades() {
        return this.b;
    }

    public void addAdditionalDrops(Level level, BlockPos blockPos, List<ItemStack> list) {
        super.addAdditionalDrops(level, blockPos, list);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            list.add((ItemStack) it.next());
        }
    }

    public void clearContent() {
        super.clearContent();
        this.b.clear();
    }

    @NotNull
    public AEColor getColor() {
        return this.h;
    }

    public boolean recolourBlock(Direction direction, AEColor aEColor, Player player) {
        if (aEColor == this.h) {
            return false;
        }
        this.h = aEColor;
        saveChanges();
        markForUpdate();
        getMainNode().setGridColor(this.h);
        return true;
    }

    public String jadeID() {
        return "wireless";
    }

    public void collectJadeInfo(CompoundTag compoundTag) {
        compoundTag.putString("color", this.h.name());
        getMainNode().ifPresent((iGrid, iGridNode) -> {
            compoundTag.putInt("used", iGridNode.getUsedChannels());
        });
    }
}
