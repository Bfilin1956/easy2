package mctech.items.base;

import java.util.function.Consumer;
import mctech.MCTech;
import net.mcskill.msregistry.registry.render.GeneratedModel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/a.class */
public class a extends BlockItem implements GeoItem {
    public final AnimatableInstanceCache a;

    public a(Block block, Item.Properties properties) {
        super(block, properties);
        this.a = GeckoLibUtil.createInstanceCache(this);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        GeneratedModel geckoModel = MCTech.REGISTRY.getGeckoModel(BuiltInRegistries.ITEM.getKey(this).getPath());
        if (geckoModel == null) {
            return;
        }
        consumer.accept(geckoModel.itemProvider());
    }
}
