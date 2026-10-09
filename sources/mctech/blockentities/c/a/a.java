package mctech.blockentities.c.a;

import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/a/a.class */
public class a extends BlockEntity implements GeoBlockEntity {
    private final AnimatableInstanceCache a;

    public a(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.FARMING_STATION_CULTIVATOR.get(), blockPos, blockState);
        this.a = GeckoLibUtil.createInstanceCache(this);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }
}
