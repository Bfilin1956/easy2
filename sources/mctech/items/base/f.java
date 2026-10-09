package mctech.items.base;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/f.class */
public class f extends g implements mctech.v.f.b {
    protected final AnimatableInstanceCache a;
    private ResourceLocation f;
    private ResourceLocation g;

    public f(Block block) {
        super(block);
        this.a = GeckoLibUtil.createInstanceCache(this);
    }

    @Override // mctech.items.base.g
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }

    public double getTick(Object obj) {
        return 0.0d;
    }

    @Override // mctech.items.base.g
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    @Override // mctech.v.f.b
    public ResourceLocation c() {
        if (this.f == null) {
            this.f = getBlock().newBlockEntity(BlockPos.ZERO, getBlock().defaultBlockState()).c();
        }
        return this.f;
    }

    @Override // mctech.v.f.b
    public ResourceLocation a(BlockState blockState) {
        if (this.g == null) {
            this.g = getBlock().newBlockEntity(BlockPos.ZERO, getBlock().defaultBlockState()).a(blockState);
        }
        return this.g;
    }
}
