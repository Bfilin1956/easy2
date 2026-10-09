package mctech.items.e;

import com.google.common.util.concurrent.AtomicDouble;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import mctech.blocks.c.G;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechModules;
import mctech.items.base.MCTechElectricItem;
import mctech.items.base.n;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/c.class */
public class c extends PickaxeItem implements mctech.items.base.k, GeoItem {
    private static final RawAnimation b = RawAnimation.begin().thenLoop("idle");
    private final AnimatableInstanceCache c;

    @Nonnull
    protected final mctech.items.f a;

    public c(@Nonnull mctech.items.f fVar) {
        super(n.a, new Item.Properties().attributes(createAttributes(n.a, 1.0f, -2.8f)).component(DataComponents.UNBREAKABLE, new Unbreakable(false)).durability(0).setNoRepair().component(MCTechDataComponent.MODULES_INFO, MCTechDataComponent.ModulesInfo.EMPTY));
        this.c = GeckoLibUtil.createInstanceCache(this);
        this.a = fVar;
    }

    public boolean isCorrectToolForDrops(@NotNull ItemStack itemStack, @NotNull BlockState blockState) {
        if (blockState.hasProperty(G.d) && ((Boolean) blockState.getOptionalValue(G.d).orElse(false)).booleanValue()) {
            return false;
        }
        if (blockState.getBlock() instanceof mctech.blocks.e.b) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            mctech.modules.f.b(MCTechModules.BEDROCK_ORE_DESTROYER, itemStack, mctech.items.f.class, null, (energyCost, fVar) -> {
                atomicBoolean.set(true);
            });
            return atomicBoolean.get();
        }
        return super.isCorrectToolForDrops(itemStack, blockState);
    }

    protected float a(@Nonnull ItemStack itemStack, @Nonnull BlockState blockState) {
        return super.getDestroySpeed(itemStack, blockState);
    }

    public float getDestroySpeed(@Nonnull ItemStack itemStack, @Nonnull BlockState blockState) {
        if (blockState.hasProperty(G.d) && ((Boolean) blockState.getOptionalValue(G.d).orElse(false)).booleanValue()) {
            return 0.0f;
        }
        AtomicDouble atomicDouble = new AtomicDouble(a(itemStack, blockState));
        if ((blockState.getBlock() instanceof mctech.blocks.e.b) && isCorrectToolForDrops(itemStack, blockState)) {
            float fA = a(itemStack, Blocks.STONE.defaultBlockState());
            if (atomicDouble.floatValue() < fA) {
                atomicDouble.set(fA);
            }
        }
        mctech.modules.f.a(MCTechModules.EFFICIENCY, itemStack, mctech.items.f.class, (Player) null, multiplierCost -> {
            atomicDouble.set(atomicDouble.floatValue() * multiplierCost.multiplier());
        });
        return atomicDouble.floatValue();
    }

    public boolean shouldCauseBlockBreakReset(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2) {
        return false;
    }

    @Override // mctech.items.base.k
    @Nonnull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public mctech.items.f a() {
        return this.a;
    }

    public boolean isEnchantable(@Nonnull ItemStack itemStack) {
        return false;
    }

    public boolean isFoil(@Nonnull ItemStack itemStack) {
        return false;
    }

    public boolean isValidRepairItem(@Nonnull ItemStack itemStack, @Nonnull ItemStack itemStack2) {
        return false;
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: mctech.items.e.c.1
            private mctech.v.d.c a;

            @Nonnull
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.a == null) {
                    this.a = new mctech.v.d.c();
                }
                return this.a;
            }
        });
    }

    public void registerControllers(@Nonnull AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "controller", 0, animationState -> {
            animationState.getController().setAnimation(b);
            return PlayState.CONTINUE;
        }));
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.c;
    }

    public int getBarWidth(@Nonnull ItemStack itemStack) {
        return MCTechElectricItem.getElectricWidth(itemStack);
    }

    public int getBarColor(@Nonnull ItemStack itemStack) {
        return MCTechElectricItem.getRGBDurability(itemStack);
    }

    public boolean isBarVisible(@NotNull ItemStack itemStack) {
        return !((Boolean) itemStack.getOrDefault((DataComponentType) MCTechDataComponent.HIDE_BAR.get(), false)).booleanValue();
    }
}
