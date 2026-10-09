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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/h.class */
public class h extends BlockItem implements mctech.i.g, IMachineTier, GeoItem {
    private final AnimatableInstanceCache a;
    private final mctech.i.c b;
    private final MachineTier c;

    public h(mctech.blocks.c.i iVar, Item.Properties properties) {
        super(iVar, properties);
        this.a = GeckoLibUtil.createInstanceCache(this);
        this.b = iVar.b();
        this.c = iVar.a();
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
        consumer.accept(MCTech.REGISTRY.getGeckoModel(mctech.i.i.FLUID_GENERATOR.getSerializedName()).itemProvider());
    }

    @Override // mctech.i.g
    public mctech.i.c g() {
        return this.b;
    }

    @Override // mctech.i.g
    @NotNull
    public MachineTier machineTier() {
        return this.c;
    }

    @Override // mctech.i.g
    public float e() {
        return 1.0f;
    }

    @Override // mctech.i.g
    public float f() {
        return 1.0f;
    }
}
