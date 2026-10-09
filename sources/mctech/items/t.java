package mctech.items;

import java.util.function.Consumer;
import mctech.MCTech;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/t.class */
public class t extends BlockItem implements IMachineTier, GeoItem {
    private final AnimatableInstanceCache a;
    private final MachineTier b;

    public t(mctech.blocks.c.A a, Item.Properties properties) {
        super(a, properties);
        this.a = GeckoLibUtil.createInstanceCache(this);
        this.b = a.a();
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
        consumer.accept(MCTech.REGISTRY.getGeckoModel(mctech.i.i.PLASMA_GENERATOR.getSerializedName()).itemProvider());
    }

    public MachineTier machineTier() {
        return this.b;
    }
}
