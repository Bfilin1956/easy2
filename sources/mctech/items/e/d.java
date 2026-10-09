package mctech.items.e;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.text.DecimalFormat;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/d.class */
public class d extends Item implements GeoItem {
    public final AnimatableInstanceCache a;
    private static final Int2ObjectMap<d> d = new Int2ObjectOpenHashMap();
    public static final DecimalFormat b = new DecimalFormat("#.##");
    public static final int c = 13;
    private final int e;

    public d(int i) {
        super(new Item.Properties().stacksTo(1));
        this.a = GeckoLibUtil.createInstanceCache(this);
        this.e = i;
        d.put(i, this);
        GeckoLibUtil.SYNCED_ANIMATABLES.put(b(), this);
    }

    public int a() {
        return this.e;
    }

    public String b() {
        return String.format("%s_%s", "blade", Integer.valueOf(this.e));
    }

    @NotNull
    public Component getName(@NotNull ItemStack itemStack) {
        return Component.translatable(getDescriptionId(itemStack)).append(Component.literal(" " + this.e));
    }

    @NotNull
    public String getDescriptionId() {
        return "item.mctech.blade";
    }

    public void appendHoverText(@Nonnull ItemStack itemStack, @Nullable Item.TooltipContext tooltipContext, @Nonnull List<Component> list, @Nonnull TooltipFlag tooltipFlag) {
        mctech.h.a.d.a aVarA = mctech.h.a.d.a(this.e);
        if (aVarA != null) {
            list.add(Component.literal(String.valueOf(ChatFormatting.YELLOW) + "Урон: " + String.valueOf(ChatFormatting.GOLD) + aVarA.a()));
        }
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<d>(this, this, "controller", 1, animationState -> {
            return PlayState.CONTINUE;
        }) { // from class: mctech.items.e.d.1
            public boolean tryTriggerAnimation(String str) {
                if (str.equals("1")) {
                    forceAnimationReset();
                    setAnimation(RawAnimation.begin().thenPlay("activating").thenLoop("activated"));
                    return true;
                }
                forceAnimationReset();
                setAnimation(RawAnimation.begin().thenPlayAndHold("disabling"));
                return true;
            }
        });
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }

    @OnlyIn(Dist.CLIENT)
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions(this) { // from class: mctech.items.e.d.2
            private final mctech.v.d.d a = new mctech.v.d.d();

            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return this.a;
            }
        });
    }

    @org.jetbrains.annotations.Nullable
    public static d a(int i) {
        return (d) d.get(i);
    }
}
