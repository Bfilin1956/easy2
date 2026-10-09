package mctech.blockentities.f;

import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/f/d.class */
public class d extends a implements GeoBlockEntity {
    private final AnimatableInstanceCache g;

    public d(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.LINKED_TELEPORTER.get(), blockPos, blockState, mctech.h.a.c.B.a, 0, mctech.h.a.c.B.b);
        this.g = GeckoLibUtil.createInstanceCache(this);
        addNetworkFields(this);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.g;
    }
}
