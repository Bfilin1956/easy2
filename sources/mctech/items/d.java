package mctech.items;

import java.util.function.Consumer;
import mctech.MCTech;
import mctech.blocks.c.C0085f;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d.class */
public class d extends BlockItem implements mctech.i.e, IMachineTier, GeoItem {
    private final AnimatableInstanceCache a;
    private final MachineTier b;

    public d(C0085f c0085f, Item.Properties properties) {
        super(c0085f, properties);
        this.a = GeckoLibUtil.createInstanceCache(this);
        this.b = c0085f.a();
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    @NotNull
    public Component getName(@NotNull ItemStack itemStack) {
        return super.getName(itemStack);
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(MCTech.REGISTRY.getGeckoModel(mctech.i.i.COBBLESTONE_GENERATOR.getSerializedName()).itemProvider());
    }

    public MachineTier machineTier() {
        return this.b;
    }

    @Override // mctech.i.e
    public float c() {
        return 1.0f;
    }

    @Override // mctech.i.e
    public float d() {
        return 1.0f;
    }
}
