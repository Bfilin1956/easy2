package mctech.items.g.c;

import java.util.function.Consumer;
import mctech.api.items.armor.MultiTexturedGeoItem;
import mctech.api.items.electric.ElectricItem;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechMaterials;
import mctech.items.base.MCTechElectricItem;
import mctech.s.d;
import mctech.v.C0207a;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.level.Level;
import net.neoforged.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;
import top.theillusivec4.curios.api.CuriosApi;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/c/a.class */
public class a extends ArmorItem implements MultiTexturedGeoItem {
    private final AnimatableInstanceCache a;
    private int b;
    private int c;

    public a(Item.Properties properties, int i) {
        super(MCTechMaterials.ELECTRIC_ARMOR, ArmorItem.Type.CHESTPLATE, properties.stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(false)).component(MCTechDataComponent.ENERGY_STORED, 0).component(MCTechDataComponent.ENERGY_CAPACITY, Integer.valueOf(i)).component(MCTechDataComponent.ENABLED, false).component(MCTechDataComponent.JETPACK_HOVERING, false).setNoRepair());
        this.a = GeckoLibUtil.createInstanceCache(this);
        this.b = i;
        this.c = 250;
    }

    public a(int i) {
        this(new Item.Properties(), i);
    }

    public boolean isEnchantable(@NotNull ItemStack itemStack) {
        return false;
    }

    public boolean isBookEnchantable(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2) {
        return false;
    }

    public boolean isRepairable(@NotNull ItemStack itemStack) {
        return false;
    }

    public boolean isValidRepairItem(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2) {
        return false;
    }

    public boolean isBarVisible(@NotNull ItemStack itemStack) {
        return d(itemStack);
    }

    public int getBarWidth(@NotNull ItemStack itemStack) {
        return (int) Math.round(((double) a(itemStack)) / (((double) b(itemStack)) * 13.0d));
    }

    public int getMaxStackSize(@NotNull ItemStack itemStack) {
        return a(itemStack) > 0 ? 1 : 16;
    }

    public int getBarColor(@NotNull ItemStack itemStack) {
        return MCTechElectricItem.getRGBDurability(itemStack);
    }

    public int a(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(MCTechDataComponent.ENERGY_STORED, 0)).intValue();
    }

    public int b(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(MCTechDataComponent.ENERGY_CAPACITY, 0)).intValue();
    }

    public boolean c(@NotNull ItemStack itemStack) {
        return ((Boolean) itemStack.getOrDefault(MCTechDataComponent.ENABLED, false)).booleanValue();
    }

    public boolean d(@NotNull ItemStack itemStack) {
        return a(itemStack) > 0;
    }

    public boolean e(@NotNull ItemStack itemStack) {
        return ((Boolean) itemStack.getOrDefault(MCTechDataComponent.JETPACK_HOVERING, false)).booleanValue();
    }

    public void a(@NotNull ItemStack itemStack, int i) {
        ElectricItem.MANAGER.discharge(itemStack, i, Integer.MAX_VALUE, true, false, false);
    }

    public int a(ItemStack itemStack, int i, boolean z, boolean z2) {
        if (!(itemStack.getItem() instanceof a) || itemStack.getCount() > 1) {
            return 0;
        }
        int iMin = z ? Math.min(this.c, i) : i;
        int iA = a(itemStack);
        int iMin2 = Math.min(iMin, this.b - iA);
        if (!z2) {
            itemStack.set((DataComponentType) MCTechDataComponent.CRYSTAL_CHARGE.get(), Integer.valueOf(Math.min(iA + iMin2, this.b)));
        }
        return iMin2;
    }

    public int b(ItemStack itemStack, int i, boolean z, boolean z2) {
        if (!(itemStack.getItem() instanceof a) || itemStack.getCount() > 1) {
            return 0;
        }
        int iMin = z ? Math.min(this.c, i) : i;
        int iA = a(itemStack);
        int iMin2 = Math.min(iMin, iA);
        if (!z2) {
            itemStack.set((DataComponentType) MCTechDataComponent.CRYSTAL_CHARGE.get(), Integer.valueOf(Math.max(0, iA - iMin2)));
        }
        return iMin2;
    }

    public int a() {
        return this.c;
    }

    public <T extends LivingEntity> int damageItem(@NotNull ItemStack itemStack, int i, @Nullable T t, @NotNull Consumer<Item> consumer) {
        a(itemStack, i);
        return 0;
    }

    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) {
        super.inventoryTick(itemStack, level, entity, i, z);
    }

    public static ItemStack a(Player player) {
        ItemStack itemBySlot = player.getItemBySlot(EquipmentSlot.CHEST);
        if (itemBySlot.getItem() instanceof a) {
            return itemBySlot;
        }
        ItemStack itemStack = ItemStack.EMPTY;
        return ModList.get().isLoaded("curios") ? (ItemStack) CuriosApi.getCuriosInventory(player).map(iCuriosItemHandler -> {
            return (ItemStack) iCuriosItemHandler.findCurios(new String[]{"back"}).stream().map((v0) -> {
                return v0.stack();
            }).filter(itemStack2 -> {
                return itemStack2.getItem() instanceof a;
            }).findFirst().orElse(itemStack);
        }).orElse(itemStack) : itemStack;
    }

    public static boolean b(Player player) {
        if (player.isSpectator()) {
            return false;
        }
        ItemStack itemStackA = a(player);
        a item = itemStackA.getItem();
        if (item instanceof a) {
            a aVar = item;
            if (!itemStackA.isEmpty() && aVar.c(itemStackA)) {
                if (aVar.d(itemStackA) || player.isCreative()) {
                    if (aVar.e(itemStackA)) {
                        return !player.onGround();
                    }
                    return d.a(player).s;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // mctech.api.items.armor.MultiTexturedGeoItem
    public int getTextureId() {
        return 1;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: mctech.items.g.c.a.1
            private GeoArmorRenderer<b> a;

            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(T t, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<T> humanoidModel) {
                if (this.a != null) {
                    return this.a;
                }
                C0207a c0207a = new C0207a(mctech.v.a.a.EnumC0045a.JETPACK);
                this.a = c0207a;
                return c0207a;
            }
        });
    }
}
