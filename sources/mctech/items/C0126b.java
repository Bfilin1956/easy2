package mctech.items;

import java.util.function.Consumer;
import mctech.MCTech;
import mctech.blocks.c.C0083d;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: mctech.items.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/b.class */
public class C0126b extends BlockItem implements IMachineTier, GeoItem {
    private final AnimatableInstanceCache a;

    public C0126b(C0083d c0083d, Item.Properties properties) {
        super(c0083d, properties);
        this.a = GeckoLibUtil.createInstanceCache(this);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(MCTech.REGISTRY.getGeckoModel(mctech.i.i.ASSEMBLY_STATION.getSerializedName()).itemProvider());
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T6;
    }
}
