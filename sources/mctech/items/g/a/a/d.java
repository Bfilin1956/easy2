package mctech.items.g.a.a;

import java.util.function.Consumer;
import mctech.MCTech;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechMaterials;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Unbreakable;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/a/a/d.class */
public class d extends mctech.items.g.b.a implements GeoItem {
    private final AnimatableInstanceCache g;

    public d(Item.Properties properties, int i, int i2) {
        super(MCTechMaterials.ELECTRIC_ARMOR, ArmorItem.Type.HELMET, properties.stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(false)).component(MCTechDataComponent.RADIUS, Integer.valueOf(i2)), i);
        this.g = GeckoLibUtil.createInstanceCache(this);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.g;
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() { // from class: mctech.items.g.a.a.d.1
            private GeoArmorRenderer<?> b;
            private GeoItemRenderer<?> c;

            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T t, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> humanoidModel) {
                if (this.b == null) {
                    this.b = new GeoArmorRenderer<d>(this, new DefaultedItemGeoModel(MCTech.loc(BuiltInRegistries.ITEM.getKey(itemStack.getItem()).getPath())).withAltTexture(MCTech.loc(String.format("xray_goggles/%s", BuiltInRegistries.ITEM.getKey(itemStack.getItem()).getPath())))) { // from class: mctech.items.g.a.a.d.1.1
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public RenderType getRenderType(d dVar, ResourceLocation resourceLocation, @Nullable MultiBufferSource multiBufferSource, float f) {
                            return RenderType.entityTranslucent(resourceLocation);
                        }
                    };
                }
                return this.b;
            }

            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.c == null) {
                    this.c = new GeoItemRenderer<d>(this, new DefaultedItemGeoModel(MCTech.loc(BuiltInRegistries.ITEM.getKey(d.this.asItem()).getPath())).withAltTexture(MCTech.loc(String.format("xray_goggles/%s", BuiltInRegistries.ITEM.getKey(d.this.asItem()).getPath())))) { // from class: mctech.items.g.a.a.d.1.2
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public RenderType getRenderType(d dVar, ResourceLocation resourceLocation, @Nullable MultiBufferSource multiBufferSource, float f) {
                            return RenderType.entityTranslucent(resourceLocation);
                        }
                    };
                }
                return this.c;
            }
        });
    }
}
