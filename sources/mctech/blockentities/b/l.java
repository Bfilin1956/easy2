package mctech.blockentities.b;

import java.util.Set;
import mctech.MCTech;
import mctech.api.energy.tile.IEnergyAcceptor;
import mctech.api.energy.tile.IEnergySource;
import mctech.api.features.ITileActivityProvider;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.readers.IEUProducer;
import mctech.api.tiles.readers.IEUStorage;
import mctech.energy.EnergyNetworks;
import mctech.init.MCTechSounds;
import mctech.init.MCTechTiles;
import mctech.m.b.S;
import mctech.m.b.aM;
import mctech.m.c.r;
import mctech.m.g.y;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/l.class */
public class l extends mctech.blockentities.i implements IEnergySource, ITileActivityProvider, IWrenchableTile, IEUProducer, IEUStorage, mctech.m.a.k, GeoBlockEntity {
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    private static final RawAnimation e = RawAnimation.begin().thenPlay("start").thenLoop("working");
    private static final RawAnimation f = RawAnimation.begin().thenPlayAndHold("stop");
    private final AnimatableInstanceCache g;

    @NetworkInfo(fieldName = "energyStored")
    private int h;

    @NetworkInfo(fieldName = "energyStorage")
    private int i;

    @NetworkInfo(fieldName = "energyProduction")
    private int j;

    @NetworkInfo(fieldName = "rotorDurability")
    private int k;

    @NetworkInfo(fieldName = "status")
    private int l;

    @NetworkInfo(fieldName = "rotorTier")
    private int m;

    @NetworkInfo(fieldName = "sourceTier")
    private int n;
    private mctech.c.g o;

    public l(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.WINDMILL_GENERATOR.get(), blockPos, blockState);
    }

    public l(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 1);
        this.g = GeckoLibUtil.createInstanceCache(this);
        this.h = 0;
        this.i = 32;
        this.j = 0;
        this.k = -1;
        this.m = -1;
        this.l = 1;
        this.n = EnergyNetworks.getTierFromPower(this.j);
        this.inventoryManager = new mctech.m.e.j(this).a(y.f(0).a(r.r));
        this.inventoryManager.i();
        addNetworkFields(this);
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkFieldNotifier
    public void onNetworkFieldChanged(Set<String> set, Player player) {
        super.onNetworkFieldChanged(set, player);
        if (set.contains("status")) {
            g();
        }
    }

    @Override // mctech.blockentities.q
    public void onLoaded() {
        super.onLoaded();
        g();
    }

    private void g() {
        if (this.o == null) {
            this.o = MCTech.AUDIO.a(this, MCTechSounds.WINDMILL, mctech.c.b.a.STATIC, 0.7f, true, true);
        }
        if (this.l == 0) {
            triggerAnim("main", "start");
        } else {
            triggerAnim("main", "stop");
        }
        playLopping(this.o, this.l == 0);
    }

    @Override // mctech.blockentities.q
    public Direction getFacing() {
        return (Direction) getBlockState().getOptionalValue(mctech.p.b.c.b).orElse(Direction.NORTH);
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return false;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.api.energy.tile.IEnergyEmitter
    public boolean canEmitEnergy(IEnergyAcceptor iEnergyAcceptor, Direction direction) {
        return false;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getSourceTier() {
        return this.n;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getMaxEnergyOutput() {
        return this.j;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getProvidedEnergy() {
        return this.h;
    }

    @Override // mctech.api.tiles.readers.IEUProducer
    public float getEUProduction() {
        return c();
    }

    @Override // mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 1.0d;
    }

    public int a() {
        return this.h;
    }

    public int b() {
        return this.i;
    }

    public int c() {
        if (this.l == 0) {
            return this.j;
        }
        return 0;
    }

    public int d() {
        return this.k;
    }

    public int e() {
        return this.l;
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new aM(this, player, i);
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "main", animationState -> {
            return PlayState.CONTINUE;
        }).triggerableAnim("start", e).triggerableAnim("stop", f));
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.g;
    }

    @NotNull
    public MachineTier f() {
        if (this.m == -1) {
            return MachineTier.NONE;
        }
        return MachineTier.values()[this.m];
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getStoredEU() {
        return this.h;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getMaxEU() {
        return this.i;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getTier() {
        return this.n;
    }
}
