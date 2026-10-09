package mctech.items.base;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/g.class */
public class g extends BlockItem implements mctech.utils.d.b, GeoItem {
    protected AnimatableInstanceCache b;
    boolean c;
    protected String d;
    protected ResourceLocation e;

    public g(Block block, Item.Properties properties) {
        super(block, properties);
        this.b = GeckoLibUtil.createInstanceCache(this);
    }

    public g(Block block) {
        this(block, new Item.Properties());
    }

    public g(Block block, String str) {
        super(block, new Item.Properties());
        this.b = GeckoLibUtil.createInstanceCache(this);
    }

    public g a() {
        this.c = true;
        return this;
    }

    @Override // mctech.utils.d.b
    public ResourceLocation b() {
        return this.e;
    }

    @Override // mctech.utils.d.b
    public void a(ResourceLocation resourceLocation) {
        this.e = resourceLocation;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.b;
    }
}
