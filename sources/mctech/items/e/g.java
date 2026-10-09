package mctech.items.e;

import java.util.function.Consumer;
import mctech.init.MCTechBlocks;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/g.class */
public final class g extends mctech.items.base.g implements GeoItem {
    private final AnimatableInstanceCache a;

    public g() {
        super((Block) MCTechBlocks.GRINDING_MACHINE.get(), new Item.Properties());
        this.a = GeckoLibUtil.createInstanceCache(this);
    }

    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions(this) { // from class: mctech.items.e.g.1
            private BlockEntityWithoutLevelRenderer a;

            @NotNull
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.a == null) {
                    this.a = new mctech.v.d.g();
                }
                return this.a;
            }
        });
    }

    @Override // mctech.items.base.g
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    @Override // mctech.items.base.g
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }
}
