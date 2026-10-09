package mctech.items.a;

import mctech.items.base.g;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/a/a.class */
public class a extends g implements GeoItem {
    private final AnimatableInstanceCache a;

    public a(Block block) {
        super(block, new Item.Properties());
        this.a = GeckoLibUtil.createInstanceCache(this);
    }

    @Override // mctech.items.base.g
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    @Override // mctech.items.base.g
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }
}
