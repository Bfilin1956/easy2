package mctech.items.e;

import java.util.function.Consumer;
import javax.annotation.Nonnull;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechMaterials;
import mctech.items.EnumC0125a;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/a.class */
public class a extends ArmorItem implements GeoItem {
    private static final RawAnimation c = RawAnimation.begin().thenLoop("idle");
    public final AnimatableInstanceCache a;

    @Nonnull
    protected final EnumC0125a b;

    public a(@Nonnull EnumC0125a enumC0125a, @Nonnull ArmorItem.Type type) {
        super(MCTechMaterials.ADVANCED_ARMOR, type, new Item.Properties().stacksTo(1).setNoRepair().component(DataComponents.STORED_ENCHANTMENTS, ItemEnchantments.EMPTY.withTooltip(false)).component(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY.withTooltip(false)).component(MCTechDataComponent.MODULES_INFO, MCTechDataComponent.ModulesInfo.EMPTY));
        this.a = GeckoLibUtil.createInstanceCache(this);
        this.b = enumC0125a;
    }

    @Nonnull
    public EnumC0125a b() {
        return this.b;
    }

    public boolean isBookEnchantable(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2) {
        return false;
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

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "controller", 0, animationState -> {
            if (this.b.compareTo(EnumC0125a.ARMOR_NANO) > 0 && (this.type == ArmorItem.Type.HELMET || this.type == ArmorItem.Type.CHESTPLATE)) {
                animationState.getController().setAnimation(c);
            }
            return PlayState.CONTINUE;
        }));
    }

    @OnlyIn(Dist.CLIENT)
    public void createGeoRenderer(@NotNull Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() { // from class: mctech.items.e.a.1
            private BlockEntityWithoutLevelRenderer b;
            private mctech.v.d.b c;

            @NotNull
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                mctech.v.d.a aVar;
                if (this.b == null) {
                    switch (AnonymousClass2.a[a.this.type.ordinal()]) {
                        case 1:
                            aVar = new mctech.v.d.a(ArmorItem.Type.BOOTS, a.this.getDefaultInstance());
                            break;
                        case 2:
                            aVar = new mctech.v.d.a(ArmorItem.Type.LEGGINGS, a.this.getDefaultInstance());
                            break;
                        case 3:
                            aVar = new mctech.v.d.a(ArmorItem.Type.CHESTPLATE, a.this.getDefaultInstance());
                            break;
                        case 4:
                            aVar = new mctech.v.d.a(ArmorItem.Type.HELMET, a.this.getDefaultInstance());
                            break;
                        default:
                            throw new UnsupportedOperationException();
                    }
                    this.b = aVar;
                }
                return this.b;
            }

            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T t, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> humanoidModel) {
                if (this.c == null) {
                    this.c = new mctech.v.d.b();
                }
                return this.c;
            }
        });
    }

    /* JADX INFO: renamed from: mctech.items.e.a$2, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/a$2.class */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a = new int[ArmorItem.Type.values().length];

        static {
            try {
                a[ArmorItem.Type.BOOTS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[ArmorItem.Type.LEGGINGS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[ArmorItem.Type.CHESTPLATE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[ArmorItem.Type.HELMET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }
}
