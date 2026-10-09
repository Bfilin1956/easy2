package mctech.blockentities;

import java.util.Iterator;
import mctech.api.energy.tile.IEnergyEmitter;
import mctech.api.energy.tile.IEnergySink;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IMachineInfo;
import mctech.api.tiles.INotifiableMachine;
import mctech.api.tiles.readers.IEUStorage;
import mctech.energy.EnergyNetworks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/e.class */
public abstract class e extends i implements IEnergySink, IWrenchableTile, IMachineInfo, IEUStorage {

    @NetworkInfo(fieldName = "energy", networkSyncRate = 5)
    public int energy;

    @NetworkInfo(fieldName = "maxEnergy")
    public int maxEnergy;

    @NetworkInfo(fieldName = "maxInput")
    public int maxInput;

    @NetworkInfo(fieldName = "tier")
    public int tier;
    public int baseTier;
    public int fuelSlot;
    protected boolean redstoneIsFull;
    public boolean charge_slot;
    mctech.d.b<INotifiableMachine> listeners;

    public abstract boolean supportsNotify();

    public e(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3) {
        super(blockEntityType, blockPos, blockState, i);
        this.fuelSlot = -1;
        this.redstoneIsFull = true;
        this.charge_slot = false;
        this.maxInput = i2;
        this.maxEnergy = i3;
        this.tier = EnergyNetworks.getTierFromPower(i2);
        this.baseTier = this.tier;
        addGuiFields(this);
        if (supportsNotify()) {
            addCaches(this.listeners);
        }
        addComparator(new mctech.blocks.base.a.a.a.a.b("eu_storage", mctech.blocks.base.a.a.d.e, this));
    }

    public void setFuelSlot(int i) {
        this.fuelSlot = i;
    }

    @Override // mctech.api.energy.tile.IEnergyAcceptor
    public boolean canAcceptEnergy(IEnergyEmitter iEnergyEmitter, Direction direction) {
        return true;
    }

    @Override // mctech.api.energy.tile.IEnergySink
    public int getSinkTier() {
        return this.tier;
    }

    @Override // mctech.api.tiles.IMachineInfo, mctech.api.tiles.readers.IEUStorage
    public int getMaxEU() {
        return this.maxEnergy;
    }

    @Override // mctech.api.tiles.IMachineInfo, mctech.api.tiles.readers.IEUStorage
    public int getStoredEU() {
        return this.energy;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getTier() {
        return this.tier;
    }

    @Override // mctech.api.tiles.IMachineInfo
    public int getMaxInput() {
        return this.maxInput;
    }

    public boolean hasEnergy(int i) {
        if (i < 0) {
            i = Integer.MAX_VALUE;
        }
        return this.energy >= i;
    }

    public boolean canSetFacing(Direction direction) {
        return direction != getFacing() && direction.getAxis().isHorizontal();
    }

    public boolean canRemoveBlock(Player player) {
        return true;
    }

    public double getDropRate(Player player) {
        return 0.85d - (0.05d * ((double) this.baseTier));
    }

    public void notifyListeners() {
        if (this.listeners == null) {
            return;
        }
        Iterator<Direction> it = this.listeners.iterator();
        while (it.hasNext()) {
            INotifiableMachine iNotifiableMachineB = this.listeners.b(it.next());
            if (iNotifiableMachineB != null) {
                iNotifiableMachineB.onNotify();
            }
        }
    }
}
