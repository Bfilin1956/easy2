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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/j.class */
public abstract class j extends i implements IEnergySink, IWrenchableTile, IMachineInfo, IEUStorage {

    @NetworkInfo(fieldName = "energy")
    public long f;

    @NetworkInfo(fieldName = "maxEnergy")
    public long g;

    @NetworkInfo(fieldName = "maxInput")
    public int h;

    @NetworkInfo(fieldName = "tier")
    public int i;
    public int j;
    public int k;
    protected boolean l;
    public boolean m;
    mctech.d.b<INotifiableMachine> n;

    public abstract boolean a();

    public j(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, long j) {
        super(blockEntityType, blockPos, blockState, i);
        this.k = -1;
        this.l = true;
        this.m = false;
        this.h = i2;
        this.g = j;
        this.i = EnergyNetworks.getTierFromPower(i2);
        this.j = this.i;
        addGuiFields(this);
        if (a()) {
            addCaches(this.n);
        }
        addComparator(new mctech.blocks.base.a.a.a.a.b("eu_storage", mctech.blocks.base.a.a.d.e, this));
    }

    public void b(int i) {
        this.k = i;
    }

    @Override // mctech.api.energy.tile.IEnergyAcceptor
    public boolean canAcceptEnergy(IEnergyEmitter iEnergyEmitter, Direction direction) {
        return true;
    }

    @Override // mctech.api.energy.tile.IEnergySink
    public int getSinkTier() {
        return this.i;
    }

    @Override // mctech.api.tiles.IMachineInfo, mctech.api.tiles.readers.IEUStorage
    public int getMaxEU() {
        if (this.g > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.g;
    }

    @Override // mctech.api.tiles.IMachineInfo, mctech.api.tiles.readers.IEUStorage
    public int getStoredEU() {
        if (this.f > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.f;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public long getLongMaxEU() {
        return this.g;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public long getLongStoredEU() {
        return this.f;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getTier() {
        return this.i;
    }

    @Override // mctech.api.tiles.IMachineInfo
    public int getMaxInput() {
        return this.h;
    }

    public boolean c(int i) {
        return this.f >= ((long) i);
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        super.setStackInSlot(i, itemStack);
        if (isSimulating() && i == this.k) {
            this.m = !itemStack.isEmpty();
        }
    }

    public boolean canSetFacing(Direction direction) {
        return direction != getFacing() && direction.getAxis().isHorizontal();
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    public double getDropRate(Player player) {
        return 0.85d - (0.05d * ((double) this.j));
    }

    public void d() {
        if (this.n == null) {
            return;
        }
        Iterator<Direction> it = this.n.iterator();
        while (it.hasNext()) {
            INotifiableMachine iNotifiableMachineB = this.n.b(it.next());
            if (iNotifiableMachineB != null) {
                iNotifiableMachineB.onNotify();
            }
        }
    }
}
