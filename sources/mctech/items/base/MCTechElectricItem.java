package mctech.items.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.IDamagelessElectricItem;
import mctech.init.MCTechDataComponent;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/MCTechElectricItem.class */
public abstract class MCTechElectricItem extends i implements IDamagelessElectricItem, IItemExtension {
    public static final int DAMAGE_COLOR = 8600319;
    public static final int NORMAL_COLOR = 717055;
    public static final double DAMAGED_R = 131.0d;
    public static final double DAMAGED_G = 58.0d;
    public static final double DAMAGED_B = 255.0d;
    public static final double NORMAL_R = 10.0d;
    public static final double NORMAL_G = 240.0d;
    public static final double NORMAL_B = 255.0d;
    public int capacity;
    public int tier;
    public int transferLimit;
    public boolean provider;

    protected abstract int getEnergyCost(ItemStack itemStack);

    public MCTechElectricItem(@Nullable o oVar) {
        super((oVar == null ? new o() : oVar).d().a(1));
    }

    public MCTechElectricItem() {
        this((o) null);
    }

    public MCTechElectricItem(@NotNull Item.Properties properties) {
        super(properties.setNoRepair().stacksTo(1));
    }

    @Override // mctech.api.items.electric.IElectricItem
    public boolean canProvideEnergy(ItemStack itemStack) {
        return this.provider;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getCapacity(ItemStack itemStack) {
        return this.capacity;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTier(ItemStack itemStack) {
        return this.tier;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTransferLimit(ItemStack itemStack) {
        return this.transferLimit;
    }

    public boolean isBarVisible(ItemStack itemStack) {
        return !((Boolean) itemStack.getOrDefault((DataComponentType) MCTechDataComponent.HIDE_BAR.get(), false)).booleanValue();
    }

    public int getBarWidth(@NotNull ItemStack itemStack) {
        return getElectricWidth(itemStack);
    }

    public int getBarColor(@NotNull ItemStack itemStack) {
        return getRGBDurability(itemStack);
    }

    public static int getElectricWidth(ItemStack itemStack) {
        return (int) Math.round((((double) ElectricItem.MANAGER.getCharge(itemStack)) / ((double) ElectricItem.MANAGER.getCapacity(itemStack))) * 13.0d);
    }

    public static int getRGBDurability(ItemStack itemStack) {
        return mctech.utils.math.a.a(NORMAL_COLOR, DAMAGE_COLOR, 1.0f - (itemStack.getItem().getBarWidth(itemStack) / 13.0f)) | mctech.utils.math.a.f;
    }

    public <T extends LivingEntity> int damageItem(@NotNull ItemStack itemStack, int i, T t, @NotNull Consumer<Item> consumer) {
        ElectricItem.MANAGER.discharge(itemStack, ElectricItem.applyEnchantmentEffect(itemStack, getEnergyCost(itemStack) * i), Integer.MAX_VALUE, true, false, false);
        return 0;
    }

    @Override // mctech.items.base.i, mctech.api.items.IItemVariant
    public Collection<ItemStack> getVariants() {
        ArrayList arrayList = new ArrayList();
        addEmptyAndFullToGroup((ItemLike) this, (List<ItemStack>) arrayList);
        return arrayList;
    }

    public static void addEmptyAndFullToGroup(ItemLike itemLike, List<ItemStack> list) {
        ItemStack itemStack = new ItemStack(itemLike, 1);
        ItemStack itemStack2 = new ItemStack(itemLike, 1);
        ElectricItem.MANAGER.discharge(itemStack, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false, false);
        ElectricItem.MANAGER.charge(itemStack2, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false);
        list.add(itemStack);
        list.add(itemStack2);
    }

    public static void addEmptyAndFullToGroup(ItemStack itemStack, List<ItemStack> list) {
        ItemStack itemStackCopy = itemStack.copy();
        ItemStack itemStackCopy2 = itemStack.copy();
        ElectricItem.MANAGER.discharge(itemStackCopy, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false, false);
        ElectricItem.MANAGER.charge(itemStackCopy2, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false);
        list.add(itemStackCopy);
        list.add(itemStackCopy2);
    }
}
