package mctech.items.g.a;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import mctech.MCTech;
import mctech.api.items.IHudDisplayable;
import mctech.api.items.IItemVariant;
import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.IDamagelessElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechMaterials;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Unbreakable;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/a/c.class */
public class c extends ArmorItem implements IHudDisplayable, IItemVariant, IDamagelessElectricItem, IItemExtension {
    private static final int b = 8600319;
    private static final int c = 717055;
    public static final Consumer<Item> a = item -> {
    };
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public c(ArmorItem.Type type, Item.Properties properties) {
        super(MCTechMaterials.SINGULAR_ARMOR, type, properties.stacksTo(1).setNoRepair().component(DataComponents.UNBREAKABLE, new Unbreakable(false)));
        mctech.h.a.a.C0017a c0017a = mctech.h.a.a.a.get(type);
        this.d = c0017a.a();
        this.e = 1;
        this.f = c0017a.b();
        this.g = c0017a.c();
    }

    @Nullable
    public ResourceLocation getArmorTexture(ItemStack itemStack, @NotNull Entity entity, @NotNull EquipmentSlot equipmentSlot, ArmorMaterial.Layer layer, boolean z) {
        ArmorItem item = itemStack.getItem();
        if (item instanceof ArmorItem) {
            Object[] objArr = new Object[1];
            objArr[0] = item.getType() == ArmorItem.Type.LEGGINGS ? "leggings" : "armor";
            return MCTech.loc(String.format("textures/item/armor/singular/singular_%s.png", objArr));
        }
        return null;
    }

    @NotNull
    public ItemAttributeModifiers getDefaultAttributeModifiers(@NotNull ItemStack itemStack) {
        return b(itemStack) ? super.getDefaultAttributeModifiers(itemStack) : ItemAttributeModifiers.builder().build();
    }

    public <T extends LivingEntity> int damageItem(@NotNull ItemStack itemStack, int i, @Nullable T t, @NotNull Consumer<Item> consumer) {
        ElectricItem.MANAGER.discharge(itemStack, ElectricItem.applyEnchantmentEffect(itemStack, a(itemStack) * i), getTier(itemStack), true, false, false);
        return 0;
    }

    public <T extends LivingEntity> int a(@NotNull ItemStack itemStack, int i, @Nullable T t) {
        return damageItem(itemStack, i, t, a);
    }

    public boolean isBarVisible(@NotNull ItemStack itemStack) {
        return !((Boolean) itemStack.getOrDefault((DataComponentType) MCTechDataComponent.HIDE_BAR.get(), false)).booleanValue();
    }

    public int getBarWidth(@NotNull ItemStack itemStack) {
        return (int) Math.round((((double) ElectricItem.MANAGER.getCharge(itemStack)) / ((double) ElectricItem.MANAGER.getCapacity(itemStack))) * 13.0d);
    }

    public int getBarColor(@NotNull ItemStack itemStack) {
        return mctech.utils.math.a.a(717055, 8600319, 1.0f - (itemStack.getItem().getBarWidth(itemStack) / 13.0f)) | mctech.utils.math.a.f;
    }

    public int a(@NotNull ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return 0;
        }
        return this.g;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public boolean canProvideEnergy(@NotNull ItemStack itemStack) {
        return true;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getCapacity(ItemStack itemStack) {
        return this.f;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTier(ItemStack itemStack) {
        return this.e;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTransferLimit(ItemStack itemStack) {
        return this.d;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.ARMOR;
    }

    public boolean isEnchantable(@NotNull ItemStack itemStack) {
        return false;
    }

    public boolean b(@NotNull ItemStack itemStack) {
        return getCharge(itemStack) <= 0;
    }

    public boolean c(@NotNull ItemStack itemStack) {
        return getCharge(itemStack) >= getCapacity(itemStack);
    }

    public boolean a(@NotNull ItemStack itemStack, int i) {
        return getCharge(itemStack) >= i;
    }

    @Override // mctech.api.items.IHudDisplayable
    public float getDurabilityPercent(ItemStack itemStack) {
        c item = itemStack.getItem();
        if (item instanceof c) {
            c cVar = item;
            int charge = cVar.getCharge(itemStack);
            int capacity = cVar.getCapacity(itemStack);
            if (capacity > 0) {
                return charge / capacity;
            }
            return 0.0f;
        }
        return 0.0f;
    }

    @Override // mctech.api.items.IHudDisplayable
    public int getDurabilityBarColor(ItemStack itemStack) {
        c item = itemStack.getItem();
        if (item instanceof c) {
            return item.getBarColor(itemStack);
        }
        return mctech.utils.math.a.f;
    }

    @Override // mctech.api.items.IHudDisplayable
    public boolean shouldRenderInHUD(ItemStack itemStack) {
        return itemStack.getItem() instanceof c;
    }

    @Override // mctech.api.items.IItemVariant
    public Collection<ItemStack> getVariants() {
        ItemStack itemStack = new ItemStack(this, 1);
        ItemStack itemStack2 = new ItemStack(this, 1);
        ElectricItem.MANAGER.discharge(itemStack, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false, false);
        ElectricItem.MANAGER.charge(itemStack2, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false);
        return List.of(itemStack, itemStack2);
    }

    public static boolean a(@NotNull Player player) {
        for (EquipmentSlot equipmentSlot : new EquipmentSlot[]{EquipmentSlot.FEET, EquipmentSlot.LEGS, EquipmentSlot.CHEST, EquipmentSlot.HEAD}) {
            if (!(player.getItemBySlot(equipmentSlot).getItem() instanceof c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(@NotNull ItemStack itemStack, @NotNull d dVar) {
        return ((MCTechDataComponent.SingularFeaturesInfo) itemStack.getOrDefault(MCTechDataComponent.SINGULAR_FEATURES.get(), MCTechDataComponent.SingularFeaturesInfo.EMPTY)).isEnabled(dVar.getSerializedName());
    }
}
