package mctech.items;

import java.util.function.Consumer;
import mctech.MCTech;
import mctech.blocks.c.F;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/w.class */
public class w extends BlockItem implements GeoItem {
    private final AnimatableInstanceCache a;

    public w(F f, Item.Properties properties) {
        super(f, properties);
        this.a = GeckoLibUtil.createInstanceCache(this);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(MCTech.REGISTRY.getGeckoModel(mctech.i.i.TRANSFORMATION_ASSEMBLER.getSerializedName()).itemProvider());
    }
}
