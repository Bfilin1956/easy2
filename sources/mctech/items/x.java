package mctech.items;

import java.util.function.Consumer;
import mctech.MCTech;
import mctech.blocks.c.G;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/x.class */
public class x extends BlockItem implements GeoItem {
    private final AnimatableInstanceCache a;

    public x(G g, Item.Properties properties) {
        super(g, properties);
        this.a = GeckoLibUtil.createInstanceCache(this);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(MCTech.REGISTRY.getGeckoModel("vending_machine").itemProvider());
    }
}
