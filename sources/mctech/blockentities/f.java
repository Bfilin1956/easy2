package mctech.blockentities;

import mctech.MCTech;
import mctech.api.energy.tile.IEnergyAcceptor;
import mctech.api.energy.tile.IEnergyEmitter;
import mctech.api.energy.tile.IEnergySink;
import mctech.api.energy.tile.IEnergySource;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IElectrolyzerProvider;
import mctech.api.tiles.IMachineInfo;
import mctech.api.util.DirectionList;
import mctech.energy.EnergyNetworks;
import mctech.m.b.C0159s;
import mctech.m.b.S;
import mctech.m.g.y;
import net.mcskill.msregistry.core.IMachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/f.class */
public abstract class f extends i implements IEnergySink, IEnergySource, IWrenchableTile, IElectrolyzerProvider, IMachineInfo, mctech.m.a.k, IMachineTier {
    public int a;
    public int b;
    public long c;

    @NetworkInfo(fieldName = "energy")
    public long d;

    @NetworkInfo(fieldName = "state")
    public byte e;
    public int f;

    public abstract int b();

    public f(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, mctech.h.a.b.a aVar) {
        super(blockEntityType, blockPos, blockState, 2);
        this.d = 0L;
        this.e = (byte) 0;
        this.f = 0;
        this.b = aVar.b;
        this.c = aVar.a;
        this.a = EnergyNetworks.getTierFromPower(this.b);
        this.inventoryManager.a().a(new y(mctech.m.e.k.q, 0).a(mctech.m.e.a.IMPORT).a(DirectionList.ALL).a(mctech.m.c.a.c.g).b(mctech.m.c.a.c.h).a(1)).a(new y(mctech.m.e.k.b, 1).a(mctech.m.e.a.EXPORT).a(DirectionList.ALL).a(1)).i();
        addNetworkFields(this);
        addGuiFields(this);
    }

    public ResourceLocation a() {
        MCTech.LOGGER.error(String.format("Class %s was not override gui texture location!", getClass().getSimpleName()));
        return null;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return direction != getFacing();
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getStoredEU() {
        return (int) Math.min(2147483647L, this.d);
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getMaxEU() {
        return (int) Math.min(2147483647L, this.c);
    }

    @Override // mctech.api.tiles.IEnergyStorage
    public int addEnergy(int i) {
        return 0;
    }

    @Override // mctech.api.tiles.IEnergyStorage
    public int drawEnergy(int i) {
        return 0;
    }

    @Override // mctech.api.tiles.IElectrolyzerProvider
    public int getProcessRate() {
        return this.b / 16;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getTier() {
        return this.a;
    }

    @Override // mctech.api.energy.tile.IEnergyAcceptor
    public boolean canAcceptEnergy(IEnergyEmitter iEnergyEmitter, Direction direction) {
        return getFacing() != direction;
    }

    @Override // mctech.api.energy.tile.IEnergyEmitter
    public boolean canEmitEnergy(IEnergyAcceptor iEnergyAcceptor, Direction direction) {
        return getFacing() == direction;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getSourceTier() {
        return this.a;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getMaxEnergyOutput() {
        return this.b;
    }

    @Override // mctech.api.tiles.IMachineInfo
    public long getMaxLongEU() {
        return this.c;
    }

    @Override // mctech.api.tiles.IMachineInfo
    public long getStoredLongEU() {
        return this.d;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public long getLongMaxEU() {
        return this.c;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public long getLongStoredEU() {
        return this.d;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getProvidedEnergy() {
        if (this.d < this.b) {
            return 0;
        }
        return this.b;
    }

    @Override // mctech.api.energy.tile.IEnergySink
    public int getSinkTier() {
        return this.a;
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        super.setStackInSlot(i, itemStack);
        if (isSimulating()) {
            if (itemStack.isEmpty()) {
                this.f &= (1 << i) ^ (-1);
            } else {
                this.f |= 1 << i;
            }
        }
    }

    public byte c() {
        float f = this.d / this.c;
        if (f <= 0.01f) {
            return (byte) 0;
        }
        if (f >= 0.99f) {
            return (byte) 3;
        }
        if (f < 0.5f) {
            return (byte) 1;
        }
        return (byte) 2;
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0159s(this, player, i);
    }
}
