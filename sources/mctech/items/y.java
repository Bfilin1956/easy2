package mctech.items;

import java.util.function.Consumer;
import mctech.v.C;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/y.class */
public class y extends BlockItem implements GeoItem {
    private final AnimatableInstanceCache a;

    public y(mctech.blocks.b.j jVar, Item.Properties properties) {
        super(jVar, properties);
        this.a = GeckoLibUtil.createInstanceCache(this);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: mctech.items.y.1
            private C a;

            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.a == null) {
                    this.a = new C();
                }
                return this.a;
            }
        });
    }
}
