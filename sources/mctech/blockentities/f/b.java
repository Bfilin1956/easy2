package mctech.blockentities.f;

import mctech.api.network.buffer.NetworkInfo;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/f/b.class */
public class b extends a implements GeoBlockEntity {
    private final AnimatableInstanceCache i;
    public static final RawAnimation g = RawAnimation.begin().then("Start", Animation.LoopType.PLAY_ONCE).then("Looping", Animation.LoopType.LOOP);
    public static final RawAnimation h = RawAnimation.begin().then("End", Animation.LoopType.HOLD_ON_LAST_FRAME);

    @NetworkInfo(fieldName = "hasPlayerStanding")
    private boolean j;

    public b(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.ELEVATOR_TELEPORTER.get(), blockPos, blockState, mctech.h.a.c.s.a, mctech.h.a.c.s.b, mctech.h.a.c.s.c);
        this.i = GeckoLibUtil.createInstanceCache(this);
        this.j = false;
        addNetworkFields(this);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "main", animationState -> {
            return PlayState.CONTINUE;
        }).triggerableAnim("start", g).triggerableAnim("end", h));
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.i;
    }

    public boolean b() {
        return this.j;
    }

    public boolean c() {
        return (a(Direction.UP).equals(this.worldPosition) && a(Direction.DOWN).equals(this.worldPosition)) ? false : true;
    }

    public BlockPos a(Direction direction) {
        if (this.level == null) {
            return this.worldPosition;
        }
        int height = this.level.getHeight();
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 1:
                BlockPos blockPos = this.worldPosition;
                for (int i = 1; i <= height; i++) {
                    BlockPos blockPosAbove = this.worldPosition.above(i);
                    if (blockPosAbove.getY() <= this.level.getMaxBuildHeight()) {
                        if (this.level.getBlockEntity(blockPosAbove) instanceof b) {
                            blockPos = blockPosAbove;
                        }
                    }
                    return blockPos;
                }
                return blockPos;
            case 2:
                BlockPos blockPos2 = this.worldPosition;
                for (int i2 = 1; i2 <= height; i2++) {
                    BlockPos blockPosBelow = this.worldPosition.below(i2);
                    if (blockPosBelow.getY() >= this.level.getMinBuildHeight()) {
                        if (this.level.getBlockEntity(blockPosBelow) instanceof b) {
                            blockPos2 = blockPosBelow;
                        }
                    }
                    return blockPos2;
                }
                return blockPos2;
            default:
                return this.worldPosition;
        }
    }

    /* JADX INFO: renamed from: mctech.blockentities.f.b$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/f/b$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Direction.values().length];

        static {
            try {
                a[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }
}
