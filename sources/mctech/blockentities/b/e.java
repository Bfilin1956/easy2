package mctech.blockentities.b;

import mctech.api.energy.IEnergyCrystal;
import mctech.api.energy.tile.IEnergyAcceptor;
import mctech.api.energy.tile.IEnergySource;
import mctech.api.energy.tile.IMultiEnergySource;
import mctech.api.features.ITileActivityProvider;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.readers.IEUProducer;
import mctech.api.tiles.readers.IEUStorage;
import mctech.energy.EnergyNetworks;
import mctech.init.MCTechTiles;
import mctech.m.b.C0134ag;
import mctech.m.b.S;
import mctech.m.g.y;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/e.class */
public class e extends mctech.blockentities.i implements IEnergySource, IMultiEnergySource, ITileActivityProvider, IWrenchableTile, IEUProducer, IEUStorage, mctech.m.a.k, IMachineTier, GeoBlockEntity {
    private final AnimatableInstanceCache a;
    private final ResourceLocation b;

    @NetworkInfo(fieldName = "energyStored")
    private int c;

    @NetworkInfo(fieldName = "energyStorage")
    private int d;

    @NetworkInfo(fieldName = "energyProduction")
    private int e;

    @NetworkInfo(fieldName = "energyOutput")
    private int f;

    @NetworkInfo(fieldName = "progress")
    private int g;

    @NetworkInfo(fieldName = "maxProgress")
    private int h;
    private int i;

    public e(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.QUANTUM_GENERATOR.get(), blockPos, blockState);
    }

    public e(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 0);
        this.a = GeckoLibUtil.createInstanceCache(this);
        this.b = ResourceLocation.fromNamespaceAndPath("kubejs", "singularity_dust");
        this.c = 0;
        this.d = 13107200;
        this.e = 131072;
        this.f = 131072;
        this.i = EnergyNetworks.getTierFromPower(this.e);
        this.g = 0;
        this.h = 300;
        this.inventoryManager = new mctech.m.e.j(this).a(y.d(0)).a(y.c(1).a(itemStack -> {
            return mctech.m.c.a.c.f.matches(itemStack) || (itemStack.getItem() instanceof IEnergyCrystal);
        }));
        this.inventoryManager.i();
        addNetworkFields(this);
    }

    @Override // mctech.blockentities.q
    public void onLoad() {
        super.onLoad();
        triggerAnim("main", "loop");
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return getFacing() != direction;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.api.energy.tile.IMultiEnergySource
    public boolean hasMultiplePackets() {
        return true;
    }

    @Override // mctech.api.energy.tile.IMultiEnergySource
    public int getPacketCount() {
        return 32;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getSourceTier() {
        return this.i;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getMaxEnergyOutput() {
        return this.f;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getProvidedEnergy() {
        return Math.min(this.c, this.e);
    }

    @Override // mctech.api.tiles.readers.IEUProducer
    public float getEUProduction() {
        return getProvidedEnergy();
    }

    @Override // mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.85d;
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0134ag(this, player, i);
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "main", animationState -> {
            return PlayState.CONTINUE;
        }).triggerableAnim("loop", RawAnimation.begin().thenLoop("animation")));
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T9;
    }

    @Override // mctech.api.energy.tile.IEnergyEmitter
    public boolean canEmitEnergy(IEnergyAcceptor iEnergyAcceptor, Direction direction) {
        return false;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.g;
    }

    public int d() {
        return this.h;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getStoredEU() {
        return this.c;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getMaxEU() {
        return this.d;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getTier() {
        return this.i;
    }
}
