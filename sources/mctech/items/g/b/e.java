package mctech.items.g.b;

import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;
import mctech.api.items.IItemVariant;
import mctech.api.items.armor.ICustomArmor;
import mctech.init.MCTechMaterials;
import mctech.items.base.o;
import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/b/e.class */
public abstract class e extends f implements IItemVariant, ICustomArmor {
    public abstract Ingredient a();

    public e(Holder<ArmorMaterial> holder, ArmorItem.Type type, @Nullable o oVar) {
        super(holder, type, (oVar == null ? new o() : oVar).d());
    }

    public e(ArmorItem.Type type, @Nullable o oVar) {
        this((Holder<ArmorMaterial>) MCTechMaterials.ELECTRIC_ARMOR, type, oVar);
    }

    public e(ArmorItem.Type type, Item.Properties properties) {
        this((Holder<ArmorMaterial>) MCTechMaterials.ELECTRIC_ARMOR, type, properties);
    }

    public e(Holder<ArmorMaterial> holder, ArmorItem.Type type, Item.Properties properties) {
        super(holder, type, properties);
    }

    @Override // mctech.api.items.armor.ICustomArmor
    public ICustomArmor.AbsorptionProperties getProperties(LivingEntity livingEntity, ItemStack itemStack, DamageSource damageSource, double d, EquipmentSlot equipmentSlot) {
        return new ICustomArmor.AbsorptionProperties(0, 0.0d, 0);
    }

    @Override // mctech.api.items.armor.ICustomArmor
    public void damageArmor(LivingEntity livingEntity, ItemStack itemStack, DamageSource damageSource, int i, EquipmentSlot equipmentSlot, ICustomArmor.DamageType damageType) {
    }

    public boolean isEnchantable(ItemStack itemStack) {
        return false;
    }

    public boolean isValidRepairItem(ItemStack itemStack, ItemStack itemStack2) {
        return a().test(itemStack2);
    }

    public Collection<ItemStack> getVariants() {
        return Collections.singleton(new ItemStack(this));
    }
}
