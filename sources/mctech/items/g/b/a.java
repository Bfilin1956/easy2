package mctech.items.g.b;

import com.google.common.base.Suppliers;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import mctech.api.items.IHudDisplayable;
import mctech.api.items.IItemVariant;
import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.IDamagelessElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.init.MCTechDataComponent;
import mctech.items.base.MCTechElectricItem;
import mctech.utils.y;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/b/a.class */
public abstract class a extends ArmorItem implements IHudDisplayable, IItemVariant, IDamagelessElectricItem {
    protected static final int a = 13;
    protected int b;
    protected int c;
    protected boolean d;
    protected int e;
    protected int f;
    private final Supplier<ItemAttributeModifiers> g;

    public a(Holder<ArmorMaterial> holder, ArmorItem.Type type, Item.Properties properties, int i) {
        this(holder, type, properties, i, 200);
    }

    public a(Holder<ArmorMaterial> holder, ArmorItem.Type type, Item.Properties properties, int i, int i2) {
        super(holder, type, properties);
        this.g = a(getMaterial(), getType());
        this.b = i;
        this.c = i2;
        this.e = 8599551;
        this.f = MCTechElectricItem.NORMAL_COLOR;
    }

    public boolean a(@NotNull ItemStack itemStack) {
        return getCharge(itemStack) <= 0;
    }

    public boolean a(@NotNull ItemStack itemStack, int i) {
        return !a(itemStack) && ElectricItem.MANAGER.canUse(itemStack, i);
    }

    public boolean a(@NotNull ItemStack itemStack, int i, @NotNull LivingEntity livingEntity) {
        return a(itemStack, i) && ElectricItem.MANAGER.use(itemStack, i, livingEntity);
    }

    public boolean a() {
        return false;
    }

    public boolean isValidRepairItem(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public boolean canProvideEnergy(ItemStack itemStack) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTier(ItemStack itemStack) {
        return 1;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public final IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.ARMOR;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public final int getCapacity(ItemStack itemStack) {
        return this.b;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public final int getTransferLimit(ItemStack itemStack) {
        return this.c;
    }

    public final boolean isBarVisible(ItemStack itemStack) {
        if (((Boolean) itemStack.getOrDefault(MCTechDataComponent.HIDE_BAR, false)).booleanValue()) {
            return false;
        }
        return this.d || getCharge(itemStack) > 0;
    }

    public final int getBarWidth(@NotNull ItemStack itemStack) {
        return Math.round((getCharge(itemStack) / getCapacity(itemStack)) * 13.0f);
    }

    public final int getBarColor(@NotNull ItemStack itemStack) {
        float fClamp = Mth.clamp(getCharge(itemStack) / getCapacity(itemStack), 0.0f, 1.0f);
        int i = (int) ((((this.e >> 24) & 255) * (1.0f - fClamp)) + (((this.f >> 24) & 255) * fClamp));
        int i2 = (int) ((((this.e >> 16) & 255) * (1.0f - fClamp)) + (((this.f >> 16) & 255) * fClamp));
        int i3 = (int) ((((this.e >> 8) & 255) * (1.0f - fClamp)) + (((this.f >> 8) & 255) * fClamp));
        int i4 = (int) (((this.e & 255) * (1.0f - fClamp)) + ((this.f & 255) * fClamp));
        return (Math.max(0, Math.min(255, i)) << 24) | (Math.max(0, Math.min(255, i2)) << 16) | (Math.max(0, Math.min(255, i3)) << 8) | Math.max(0, Math.min(255, i4));
    }

    public final <T extends LivingEntity> int damageItem(@NotNull ItemStack itemStack, int i, @Nullable T t, @NotNull Consumer<Item> consumer) {
        AtomicInteger atomicInteger = new AtomicInteger(i);
        if (a()) {
            y.a(Enchantments.EFFICIENCY).ifPresent(reference -> {
                atomicInteger.set(atomicInteger.get() * ((int) (1.0d + (0.15d * ((double) EnchantmentHelper.getEnchantmentsForCrafting(itemStack).getLevel(reference))))));
            });
            y.a(Enchantments.UNBREAKING).ifPresent(reference2 -> {
                atomicInteger.set(atomicInteger.get() * ((int) (1.0d - (0.1d * ((double) EnchantmentHelper.getEnchantmentsForCrafting(itemStack).getLevel(reference2))))));
            });
        }
        ElectricItem.MANAGER.discharge(itemStack, atomicInteger.get(), Integer.MAX_VALUE, false, true, false);
        return super.damageItem(itemStack, i, t, consumer);
    }

    @Override // mctech.api.items.IItemVariant
    public final Collection<ItemStack> getVariants() {
        ItemStack itemStack = new ItemStack(this, 1);
        itemStack.set(MCTechDataComponent.CHARGE, 0);
        ItemStack itemStack2 = new ItemStack(this, 1);
        itemStack2.set(MCTechDataComponent.CHARGE, Integer.valueOf(getCapacity(itemStack2)));
        return List.of(itemStack, itemStack2);
    }

    public void a(EquipmentSlotGroup equipmentSlotGroup, BiConsumer<Holder<Attribute>, AttributeModifier> biConsumer) {
    }

    @NotNull
    public final ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.g.get();
    }

    private Supplier<ItemAttributeModifiers> a(Holder<ArmorMaterial> holder, ArmorItem.Type type) {
        return Suppliers.memoize(() -> {
            int defense = ((ArmorMaterial) holder.value()).getDefense(type);
            float f = ((ArmorMaterial) holder.value()).toughness();
            float fKnockbackResistance = ((ArmorMaterial) holder.value()).knockbackResistance();
            ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
            EquipmentSlotGroup equipmentSlotGroupBySlot = EquipmentSlotGroup.bySlot(type.getSlot());
            ResourceLocation resourceLocationWithDefaultNamespace = ResourceLocation.withDefaultNamespace("armor." + type.getName());
            builder.add(Attributes.ARMOR, new AttributeModifier(resourceLocationWithDefaultNamespace, defense, AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroupBySlot);
            builder.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(resourceLocationWithDefaultNamespace, f, AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroupBySlot);
            a(equipmentSlotGroupBySlot, (holder2, attributeModifier) -> {
                builder.add(holder2, attributeModifier, equipmentSlotGroupBySlot);
            });
            if (fKnockbackResistance > 0.0f) {
                builder.add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(resourceLocationWithDefaultNamespace, fKnockbackResistance, AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroupBySlot);
            }
            return builder.build();
        });
    }
}
