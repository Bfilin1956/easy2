package mctech.blockentities.c;

import java.util.EnumSet;
import java.util.Set;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.util.DirectionList;
import mctech.init.MCTechItems;
import mctech.init.MCTechSounds;
import mctech.init.MCTechTiles;
import mctech.m.b.aD;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/ad.class */
public class ad extends mctech.blockentities.k implements mctech.m.a.k, GeoBlockEntity {
    public static final int[] a = {0, 1, 2};
    public static final int[] b = {3, 4, 5, 6, 7, 8, 9, 10, 11};
    private static final RawAnimation e = RawAnimation.begin().thenLoop("working");
    private static final RawAnimation f = RawAnimation.begin().thenLoop("idle");
    private final AnimatableInstanceCache g;

    @NetworkInfo(fieldName = "progress")
    public final float[] c;

    @NetworkInfo(fieldName = "visualStack")
    public ItemStack d;

    public ad(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.SYNTHETIC_PRINTER.get(), blockPos, blockState, 12, 0, mctech.k.a.r(), mctech.k.a.q(), mctech.k.a.t(), mctech.k.a.s());
        this.g = GeckoLibUtil.createInstanceCache(this);
        this.c = new float[a.length];
        this.d = ItemStack.EMPTY;
        this.inventoryManager = new mctech.m.e.j(this, 0).a(new mctech.m.g.y(mctech.m.e.k.g, a).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a((i, itemStack) -> {
            return itemStack.is((Item) MCTechItems.DNA_SAMPLE.get());
        })).a(new mctech.m.g.y(mctech.m.e.k.l, b).a(DirectionList.ALL).a(5000).a(mctech.m.e.a.EXPORT));
        this.inventoryManager.i();
        addNetworkFields(this);
    }

    @Override // mctech.blockentities.k, mctech.blockentities.q, mctech.api.network.tile.INetworkFieldNotifier
    public void onNetworkFieldChanged(Set<String> set, Player player) {
        super.onNetworkFieldChanged(set, player);
        if (set.contains("isActive")) {
            triggerAnim("main", isActive() ? "working" : "idle");
        }
    }

    @Override // mctech.blockentities.q
    public void onLoaded() {
        super.onLoaded();
        triggerAnim("main", isActive() ? "working" : "idle");
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "main", animationState -> {
            return PlayState.CONTINUE;
        }).triggerableAnim("idle", f).triggerableAnim("working", e));
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.g;
    }

    @Override // mctech.blockentities.k
    public DeferredHolder<SoundEvent, SoundEvent> getWorkingSound() {
        return MCTechSounds.ELECTRIC_FURNACE;
    }

    @Override // mctech.blockentities.k
    protected void createInvCaches() {
        this.inOut = this.inventoryManager.g();
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new aD(this, player, i);
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public int getSlots() {
        return this.c.length;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgressSlot(int i) {
        return this.c[i];
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgressSlot(int i) {
        return mctech.k.a.q();
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        for (float f2 : this.c) {
            if (f2 > 0.0f) {
                return f2;
            }
        }
        return 0.0f;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return mctech.k.a.q();
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        if (!itemStack.is((Item) MCTechItems.DNA_SAMPLE.get())) {
            return 0;
        }
        for (int i : a) {
            if (getStackInSlot(i).isEmpty()) {
                return 1;
            }
        }
        return 0;
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return EnumSet.noneOf(IUpgradeItem.UpgradeType.class);
    }
}
