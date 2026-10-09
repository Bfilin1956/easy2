package mctech.items.g.c;

import java.util.function.Consumer;
import mctech.api.items.IHudDisplayable;
import mctech.api.items.armor.MultiTexturedGeoItem;
import mctech.items.g.b.g;
import mctech.items.g.b.h;
import mctech.v.C0207a;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/c/b.class */
public class b extends g implements IHudDisplayable, MultiTexturedGeoItem {
    private static final RawAnimation a = RawAnimation.begin().then("Idle2", Animation.LoopType.LOOP);
    private final AnimatableInstanceCache b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final h.a g;
    private final boolean h;

    public b(int i, int i2, int i3, int i4, h.a aVar, boolean z) {
        super(ArmorItem.Type.CHESTPLATE, null);
        this.b = GeckoLibUtil.createInstanceCache(this);
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = aVar;
        this.h = z;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public boolean canProvideEnergy(ItemStack itemStack) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getCapacity(ItemStack itemStack) {
        return this.d;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTier(ItemStack itemStack) {
        return this.e;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTransferLimit(ItemStack itemStack) {
        return this.f;
    }

    @Override // mctech.items.g.b.h
    public boolean c(ItemStack itemStack) {
        return this.h;
    }

    @Override // mctech.items.g.b.h
    public boolean d(ItemStack itemStack) {
        return this.g == h.a.BASIC;
    }

    @Override // mctech.items.g.b.h
    public boolean e(ItemStack itemStack) {
        return this.g == h.a.ADV;
    }

    @Override // mctech.items.g.b.h
    public boolean f(ItemStack itemStack) {
        return true;
    }

    @Override // mctech.items.g.b.h
    public float g(ItemStack itemStack) {
        return this.h ? 1.8f : 0.7f;
    }

    @Override // mctech.items.g.b.h
    public float a(ItemStack itemStack, h.a aVar) {
        switch (aVar) {
            case BASIC:
                return 0.3f;
            case ADV:
                return 5.0f;
            default:
                return 0.65f;
        }
    }

    @Override // mctech.items.g.b.h
    public float h(ItemStack itemStack) {
        return 0.05f;
    }

    @Override // mctech.items.g.b.h
    public int a(ItemStack itemStack, int i) {
        return this.g == h.a.NONE ? (int) (i / 1.28f) : i;
    }

    @Override // mctech.items.g.b.h
    public int i(ItemStack itemStack) {
        return this.h ? 30000 : 0;
    }

    @Override // mctech.items.g.b.h
    public int b(ItemStack itemStack, h.a aVar) {
        return aVar == h.a.NONE ? 7 : 4;
    }

    @Override // mctech.api.items.armor.MultiTexturedGeoItem
    public int getTextureId() {
        return this.c;
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.b;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, this::a));
    }

    private <P extends GeoAnimatable> PlayState a(AnimationState<b> animationState) {
        animationState.getController().setAnimation(a);
        return PlayState.CONTINUE;
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: mctech.items.g.c.b.1
            private GeoArmorRenderer<b> a;

            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(T t, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<T> humanoidModel) {
                if (this.a == null) {
                    this.a = new C0207a(mctech.v.a.a.EnumC0045a.JETPACK);
                }
                return this.a;
            }
        });
    }
}
