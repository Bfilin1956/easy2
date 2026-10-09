package mctech.blockentities;

import mctech.MCTech;
import mctech.api.energy.tile.IEnergyAcceptor;
import mctech.api.energy.tile.IEnergyEmitter;
import mctech.api.energy.tile.IEnergySink;
import mctech.api.energy.tile.IMultiEnergySource;
import mctech.api.features.ITileActivityProvider;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.readers.IEUStorage;
import mctech.energy.EnergyNetworks;
import net.mcskill.msregistry.core.IMachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/r.class */
public abstract class r extends q implements IEnergySink, IMultiEnergySource, ITileActivityProvider, IWrenchableTile, IEUStorage, mctech.v.f.b, IMachineTier {
    private static final ResourceLocation e = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "geo/transformator.geo.json");
    private final AnimatableInstanceCache f;
    public int a;
    public int b;
    public int c;

    @NetworkInfo(fieldName = "energy")
    public int d;

    public r(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, mctech.h.a.b.c cVar) {
        super(blockEntityType, blockPos, blockState);
        this.f = GeckoLibUtil.createInstanceCache(this);
        this.d = 0;
        this.a = cVar.a;
        this.b = cVar.b;
        this.c = cVar.b * 2;
        addGuiFields(this);
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getMaxEU() {
        return this.c;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getStoredEU() {
        return this.d;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getTier() {
        return getSinkTier();
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return getFacing() != direction;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.api.energy.tile.IEnergyAcceptor
    public boolean canAcceptEnergy(IEnergyEmitter iEnergyEmitter, Direction direction) {
        return isActive() == (getFacing() != direction);
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getSourceTier() {
        return EnergyNetworks.getTierFromPower(isActive() ? this.b : this.a);
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getMaxEnergyOutput() {
        return isActive() ? this.b : this.a;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getProvidedEnergy() {
        int i = isActive() ? this.b : this.a;
        if (this.d >= i) {
            return i;
        }
        return 0;
    }

    @Override // mctech.api.energy.tile.IEnergyEmitter
    public boolean canEmitEnergy(IEnergyAcceptor iEnergyAcceptor, Direction direction) {
        return isActive() == (getFacing() == direction);
    }

    @Override // mctech.api.energy.tile.IMultiEnergySource
    public boolean hasMultiplePackets() {
        return !isActive();
    }

    @Override // mctech.api.energy.tile.IMultiEnergySource
    public int getPacketCount() {
        return isActive() ? 1 : 4;
    }

    @Override // mctech.api.energy.tile.IEnergySink
    public int getSinkTier() {
        return EnergyNetworks.getTierFromPower(isActive() ? this.a : this.b);
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.f;
    }

    public double getTick(Object obj) {
        return 0.0d;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    @Override // mctech.v.f.b
    public ResourceLocation c() {
        return e;
    }
}
