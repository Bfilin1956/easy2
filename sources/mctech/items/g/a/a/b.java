package mctech.items.g.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import mctech.api.items.IHudDisplayable;
import mctech.api.items.armor.MultiTexturedGeoItem;
import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.IDamagelessElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.init.MCTechMaterials;
import mctech.items.base.MCTechElectricItem;
import mctech.items.base.o;
import mctech.items.g.b.e;
import mctech.v.C0207a;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/a/a/b.class */
public class b extends e implements IHudDisplayable, MultiTexturedGeoItem, IDamagelessElectricItem {
    private static final RawAnimation e = RawAnimation.begin().then("Idle2", Animation.LoopType.LOOP);
    private final AnimatableInstanceCache f;
    int a;
    int b;
    int c;
    int d;

    public b(ArmorItem.Type type, @Nullable Rarity rarity, int i, int i2, int i3, int i4) {
        super((Holder<ArmorMaterial>) MCTechMaterials.ELECTRIC_ARMOR, type, new o().c(0).a(rarity == null ? Rarity.COMMON : rarity));
        this.f = GeckoLibUtil.createInstanceCache(this);
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.c = i4;
    }

    public b(Rarity rarity, mctech.h.a.b.a aVar, int i, int i2) {
        this(ArmorItem.Type.CHESTPLATE, rarity, Math.toIntExact(aVar.a), i, i2, aVar.b);
    }

    public b(mctech.h.a.b.a aVar, int i, int i2) {
        this(ArmorItem.Type.CHESTPLATE, null, Math.toIntExact(aVar.a), i, i2, aVar.b);
    }

    public b(ArmorItem.Type type, int i, int i2, int i3, int i4) {
        this(type, null, i, i2, i3, i4);
    }

    @Override // mctech.items.g.b.e
    public Ingredient a() {
        return Ingredient.EMPTY;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public boolean canProvideEnergy(ItemStack itemStack) {
        return true;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getCapacity(ItemStack itemStack) {
        return this.a;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTier(ItemStack itemStack) {
        return this.b;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTransferLimit(ItemStack itemStack) {
        return this.c;
    }

    @Override // mctech.items.g.b.e, mctech.api.items.IItemVariant
    public Collection<ItemStack> getVariants() {
        ArrayList arrayList = new ArrayList();
        MCTechElectricItem.addEmptyAndFullToGroup((ItemLike) this, (List<ItemStack>) arrayList);
        return arrayList;
    }

    public int getBarWidth(ItemStack itemStack) {
        return MCTechElectricItem.getElectricWidth(itemStack);
    }

    public int getBarColor(ItemStack itemStack) {
        return MCTechElectricItem.getRGBDurability(itemStack);
    }

    public boolean isBarVisible(ItemStack itemStack) {
        return true;
    }

    public <T extends LivingEntity> int damageItem(ItemStack itemStack, int i, T t, Consumer<Item> consumer) {
        return 0;
    }

    @Override // mctech.api.items.armor.MultiTexturedGeoItem
    public int getTextureId() {
        return this.d;
    }

    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean z) {
        if (level.isClientSide() || i != 38 || level.getGameTime() % 10 != 0 || !(entity instanceof Player)) {
            return;
        }
        Player player = (Player) entity;
        int charge = ElectricItem.DIRECT_MANAGER.getCharge(itemStack);
        int i2 = 0;
        Inventory inventory = player.getInventory();
        int iA = a(inventory.getSelected(), charge);
        while (iA > 0 && i2 <= 40) {
            if (i2 == 36 || i2 == 37 || i2 == 38 || i2 == 39 || i2 == inventory.selected) {
                i2++;
            } else {
                iA = a(inventory.getItem(i2), iA);
                i2++;
            }
        }
        ElectricItem.DIRECT_MANAGER.discharge(itemStack, ElectricItem.DIRECT_MANAGER.getCharge(itemStack) - iA, this.b, true, false, false);
    }

    private int a(ItemStack itemStack, int i) {
        if (!itemStack.isEmpty()) {
            IElectricItem item = itemStack.getItem();
            if ((item instanceof IElectricItem) && item.getElectricType(itemStack).isHandUse()) {
                i -= ElectricItem.DIRECT_MANAGER.charge(itemStack, i, this.b, true, false);
            }
        }
        return i;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.LAPPACK;
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.f;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, this::a));
    }

    private <P extends GeoAnimatable> PlayState a(AnimationState<b> animationState) {
        animationState.getController().setAnimation(e);
        return PlayState.CONTINUE;
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: mctech.items.g.a.a.b.1
            private GeoArmorRenderer<b> a;

            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(T t, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<T> humanoidModel) {
                if (this.a == null) {
                    this.a = new C0207a(mctech.v.a.a.EnumC0045a.ENERGYPACK);
                }
                return this.a;
            }
        });
    }
}
