package mctech.blockentities.f;

import java.util.Set;
import mctech.api.energy.tile.IEnergyEmitter;
import mctech.api.energy.tile.IEnergySink;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.readers.IEUStorage;
import mctech.blockentities.q;
import mctech.energy.EnergyNetworks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/f/a.class */
public abstract class a extends q implements IEnergySink, IWrenchableTile, IEUStorage {

    @NetworkInfo(fieldName = "energyStored")
    protected int a;

    @NetworkInfo(fieldName = "energyCapacity")
    protected int b;

    @NetworkInfo(fieldName = "energyUsage")
    protected int c;

    @NetworkInfo(fieldName = "maxEnergyInput")
    protected int d;

    @NetworkInfo(fieldName = "energyTier")
    protected int e;
    protected Set<Direction> f;

    public a(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3) {
        super(blockEntityType, blockPos, blockState);
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = EnergyNetworks.getTierFromPower(i3);
        this.f = Set.of((Object[]) Direction.values());
        this.a = 0;
    }

    @Override // mctech.api.energy.tile.IEnergySink
    public int getSinkTier() {
        return this.e;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getMaxEU() {
        return this.b;
    }

    public int a() {
        return this.d;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getStoredEU() {
        return this.a;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getTier() {
        return this.e;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return direction != getFacing();
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.7d;
    }

    @Override // mctech.api.energy.tile.IEnergyAcceptor
    public boolean canAcceptEnergy(IEnergyEmitter iEnergyEmitter, Direction direction) {
        return true;
    }
}
