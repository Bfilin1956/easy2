package mctech.items;

import java.util.List;
import java.util.function.Consumer;
import mctech.api.items.IWindmillBlade;
import mctech.v.E;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/z.class */
public class z extends Item implements IWindmillBlade, GeoItem {
    private final AnimatableInstanceCache a;
    private final A b;

    public z(Item.Properties properties, A a) {
        super(properties);
        this.a = GeckoLibUtil.createInstanceCache(this);
        this.b = a;
    }

    public A a() {
        return this.b;
    }

    @Override // mctech.api.items.IWindmillBlade
    public int getEnergyPerTick(ItemStack itemStack) {
        return this.b.b();
    }

    @Override // mctech.api.items.IWindmillBlade
    public int getMaxRotorDurability(ItemStack itemStack) {
        return this.b.c();
    }

    @Override // mctech.api.items.IWindmillBlade
    public boolean isInfinite(ItemStack itemStack) {
        return this.b.d();
    }

    @Override // mctech.api.items.IWindmillBlade
    public MachineTier getRotorTier(ItemStack itemStack) {
        return this.b.a();
    }

    public boolean isBarVisible(@NotNull ItemStack itemStack) {
        return !isInfinite(itemStack) && super.isBarVisible(itemStack);
    }

    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        list.add(a("tooltip.item.mctech.windmill_rotor.output", mctech.utils.c.c.c.format(getEnergyPerTick(itemStack)) + " EU/t"));
        if (isInfinite(itemStack)) {
            list.add(a("tooltip.item.mctech.windmill_rotor.durability_infinite", "∞"));
        } else {
            list.add(a("tooltip.item.mctech.windmill_rotor.durability", mctech.utils.c.c.c.format(getRemainingDurability(itemStack)) + "/" + mctech.utils.c.c.c.format(getMaxRotorDurability(itemStack))));
        }
    }

    private static MutableComponent a(String str, String str2) {
        return Component.translatable(str, new Object[]{str2}).withStyle(ChatFormatting.AQUA);
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: mctech.items.z.1
            private E a;

            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.a == null) {
                    this.a = new E();
                }
                return this.a;
            }
        });
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }
}
