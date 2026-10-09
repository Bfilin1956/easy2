package mctech.blockentities;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import java.util.EnumSet;
import java.util.Set;
import mctech.MCTech;
import mctech.api.features.IInventoryMachine;
import mctech.api.features.IWrenchableTile;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.util.DirectionList;
import mctech.init.MCTechSounds;
import net.mcskill.msregistry.core.IMachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.registries.DeferredHolder;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/t.class */
public abstract class t extends i implements IInventoryMachine, IWrenchableTile, mctech.m.a.k, mctech.m.f.f, IMachineTier, GeoAnimatable, GeoBlockEntity {
    private final AnimatableInstanceCache f;
    protected String a;
    protected mctech.d.d<IItemHandler> b;
    protected mctech.m.a.g[] c;
    protected mctech.c.g d;

    @NetworkInfo(fieldName = "soundLevel")
    protected float e;

    public abstract void a();

    public t(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        this(blockEntityType, blockPos, blockState, 0);
    }

    public t(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i) {
        super(blockEntityType, blockPos, blockState, i);
        this.f = GeckoLibUtil.createInstanceCache(this);
        this.a = "isActive";
        mctech.d.b bVar = new mctech.d.b(this, DirectionList.ALL, Capabilities.ItemHandler.BLOCK);
        this.b = bVar;
        addCaches(bVar);
        addNetworkFields(this);
    }

    public boolean canSetFacing(Direction direction) {
        return getFacing() != direction && direction.getAxis().isHorizontal();
    }

    public boolean canRemoveBlock(Player player) {
        return true;
    }

    public double getDropRate(Player player) {
        return 1.0d;
    }

    @Override // mctech.m.f.f
    public void onNotify(mctech.m.a.g gVar, int i) {
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.f;
    }

    @Override // mctech.api.features.IInventoryMachine
    public mctech.m.a.g getInputInventory() {
        if (this.c == null) {
            a();
        }
        return this.c[0];
    }

    @Override // mctech.api.features.IInventoryMachine
    public mctech.m.a.g getOutputInventory() {
        if (this.c == null) {
            a();
        }
        return this.c[1];
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return EnumSet.noneOf(IUpgradeItem.UpgradeType.class);
    }

    @Override // mctech.api.tiles.IMachine
    public int getAvailableEnergy() {
        return 0;
    }

    @Override // mctech.api.tiles.IMachine
    public boolean isMachineWorking() {
        return isActive();
    }

    @Override // mctech.api.tiles.IMachine
    public void setRedstoneSensitive(boolean z) {
        this.redstoneSensitive = z;
    }

    @Override // mctech.api.tiles.IMachine
    public boolean isRedstoneSensitive() {
        return this.redstoneSensitive;
    }

    @Override // mctech.api.tiles.IMachine
    public IItemHandler getConnectedInventory(Direction direction) {
        if (getInventoryHandler().e(direction)) {
            return this.b.b(direction);
        }
        return null;
    }

    public DeferredHolder<SoundEvent, SoundEvent> b() {
        return null;
    }

    public DeferredHolder<SoundEvent, SoundEvent> W_() {
        return MCTechSounds.INTERRUPTION;
    }

    protected void a(boolean z) {
        MCTech.AUDIO.a(this, z ? W_() : b(), mctech.c.b.a.STATIC, this.e, 1.0f);
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkFieldNotifier
    @OverridingMethodsMustInvokeSuper
    public void onNetworkFieldChanged(Set<String> set, Player player) {
        if (set.contains("isActive")) {
            if (this.d == null || !this.d.a()) {
                this.d = MCTech.AUDIO.a(this, b(), mctech.c.b.a.STATIC, this.e, true, false);
            }
            playOrStop(this.d, isMachineWorking());
        }
        if (set.contains("soundLevel") && this.d != null) {
            this.d.a(this.e);
        }
    }
}
