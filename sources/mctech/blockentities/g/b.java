package mctech.blockentities.g;

import mctech.MCTech;
import mctech.api.energy.tile.IEnergyAcceptor;
import mctech.api.energy.tile.IEnergyEmitter;
import mctech.api.energy.tile.IEnergySink;
import mctech.api.energy.tile.IMultiEnergySource;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkClientEventListener;
import mctech.api.tiles.ICopyableSettings;
import mctech.api.tiles.readers.IEUStorage;
import mctech.blockentities.q;
import mctech.energy.EnergyNetworks;
import mctech.m.b.C0127a;
import mctech.m.b.S;
import net.mcskill.msregistry.core.IMachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/g/b.class */
public abstract class b extends q implements IEnergySink, IMultiEnergySource, IWrenchableTile, INetworkClientEventListener, ICopyableSettings, IEUStorage, mctech.m.a.k, mctech.v.f.b, IMachineTier {
    private static final ResourceLocation g = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "geo/transformator.geo.json");
    private final AnimatableInstanceCache h;

    @NetworkInfo(fieldName = "energy")
    public int a;

    @NetworkInfo(fieldName = "packetCount")
    public int b;

    @NetworkInfo(fieldName = "energyPacket")
    public int c;

    @NetworkInfo(fieldName = "maxEnergy")
    public int d;
    public int e;
    public int f;
    private int i;

    public b(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, mctech.h.a.b.c cVar) {
        super(blockEntityType, blockPos, blockState);
        this.h = GeckoLibUtil.createInstanceCache(this);
        this.b = 1;
        this.c = 32;
        this.e = cVar.a;
        this.f = cVar.b;
        this.d = this.f * 32;
        this.i = EnergyNetworks.getTierFromPower(cVar.b);
        addGuiFields(this);
        addComparator(new mctech.blocks.base.a.a.a.a.b("eu_storage", mctech.blocks.base.a.a.d.e, this));
    }

    @Override // mctech.api.features.redstone.IComparable
    public boolean isAllowingUI() {
        return false;
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0127a(this, player, i);
    }

    @Override // mctech.api.tiles.ICopyableSettings
    public void saveSettings(CompoundTag compoundTag, HolderLookup.Provider provider) {
    }

    @Override // mctech.api.tiles.ICopyableSettings
    public void loadSettings(CompoundTag compoundTag, HolderLookup.Provider provider) {
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkClientEventListener
    public void onClientDataReceived(Player player, int i, int i2) {
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return getFacing() != direction;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    public double getDropRate(Player player) {
        return 0.8d;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getSourceTier() {
        return EnergyNetworks.getTierFromPower(this.c);
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getMaxEnergyOutput() {
        return this.f;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getProvidedEnergy() {
        if (this.a < this.c) {
            return 0;
        }
        return this.c;
    }

    @Override // mctech.api.energy.tile.IEnergyEmitter
    public boolean canEmitEnergy(IEnergyAcceptor iEnergyAcceptor, Direction direction) {
        return getFacing() != direction;
    }

    @Override // mctech.api.energy.tile.IEnergyAcceptor
    public boolean canAcceptEnergy(IEnergyEmitter iEnergyEmitter, Direction direction) {
        return getFacing() == direction;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getStoredEU() {
        return this.a;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getMaxEU() {
        return this.d;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getTier() {
        return this.i;
    }

    @Override // mctech.api.energy.tile.IEnergySink
    public int getSinkTier() {
        return this.i;
    }

    @Override // mctech.api.energy.tile.IMultiEnergySource
    public boolean hasMultiplePackets() {
        return this.b > 1;
    }

    @Override // mctech.api.energy.tile.IMultiEnergySource
    public int getPacketCount() {
        return this.b;
    }

    @Override // mctech.v.f.b
    public ResourceLocation c() {
        return g;
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.h;
    }

    public double getTick(Object obj) {
        return 0.0d;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }
}
