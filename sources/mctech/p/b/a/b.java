package mctech.p.b.a;

import java.util.Set;
import mctech.api.energy.tile.IEnergyEmitter;
import mctech.api.energy.tile.IEnergySink;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IMachineInfo;
import mctech.api.tiles.INotifiableMachine;
import mctech.api.tiles.readers.IEUStorage;
import mctech.energy.EnergyNetworks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/b/a/b.class */
public abstract class b extends c implements IEnergySink, IMachineInfo, IEUStorage {

    @NetworkInfo(fieldName = "energy")
    public int a;

    @NetworkInfo(fieldName = "maxEnergy")
    public int b;

    @NetworkInfo(fieldName = "maxInput")
    public int c;

    @NetworkInfo(fieldName = "tier")
    public int d;
    public int e;
    mctech.d.b<INotifiableMachine> f;
    public boolean g;
    protected Set<Direction> h;

    public abstract boolean l();

    public b(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3) {
        super(blockEntityType, blockPos, blockState, i);
        this.g = false;
        this.c = i2;
        this.b = i3;
        this.d = EnergyNetworks.getTierFromPower(i2);
        this.e = this.d;
        this.h = Set.of((Object[]) Direction.values());
        addGuiFields(this);
        if (l()) {
            a(this.f);
        }
    }

    @Override // mctech.api.energy.tile.IEnergyAcceptor
    public boolean canAcceptEnergy(IEnergyEmitter iEnergyEmitter, Direction direction) {
        return false;
    }

    @Override // mctech.api.energy.tile.IEnergyAcceptor
    public boolean canAcceptEnergy(Direction direction) {
        return false;
    }

    @Override // mctech.api.energy.tile.IEnergySink
    public int getSinkTier() {
        return this.d;
    }

    @Override // mctech.api.tiles.IMachineInfo, mctech.api.tiles.readers.IEUStorage
    public int getMaxEU() {
        return this.b;
    }

    @Override // mctech.api.tiles.IMachineInfo, mctech.api.tiles.readers.IEUStorage
    public int getStoredEU() {
        return this.a;
    }

    public void setMaxEnergy(int i) {
        this.b = i;
        updateGuiField(this, "maxEnergy");
    }

    public void setMaxInput(int i) {
        this.c = i;
        this.d = EnergyNetworks.getTierFromPower(i);
        updateGuiField(this, "maxInput");
        updateGuiField(this, "tier");
    }

    public void setTier(int i) {
        this.d = i;
        this.c = EnergyNetworks.getPowerFromTier(i);
        updateGuiField(this, "maxInput");
        updateGuiField(this, "tier");
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getTier() {
        return this.d;
    }

    @Override // mctech.api.tiles.IMachineInfo
    public int getMaxInput() {
        return this.c;
    }
}
