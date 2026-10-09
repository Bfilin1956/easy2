package mctech.items.g.b;

import it.unimi.dsi.fastutil.ints.Int2DoubleLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayPriorityQueue;
import javax.annotation.Nullable;
import mctech.api.items.armor.ICustomArmor;
import mctech.items.base.o;
import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/b/f.class */
public abstract class f extends ArmorItem implements mctech.utils.e.a, mctech.utils.e.b {
    public f(Holder<ArmorMaterial> holder, ArmorItem.Type type, Item.Properties properties) {
        super(holder, type, properties);
    }

    public f(Holder<ArmorMaterial> holder, ArmorItem.Type type, @Nullable o oVar) {
        super(holder, type, (oVar == null ? new o() : oVar).g());
    }

    @OnlyIn(Dist.CLIENT)
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
    }

    public static float a(LivingEntity livingEntity, DamageSource damageSource, double d) {
        ObjectArrayPriorityQueue objectArrayPriorityQueue = new ObjectArrayPriorityQueue(4);
        Int2DoubleLinkedOpenHashMap int2DoubleLinkedOpenHashMap = new Int2DoubleLinkedOpenHashMap(4);
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            if (equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                ItemStack itemBySlot = livingEntity.getItemBySlot(equipmentSlot);
                ICustomArmor item = itemBySlot.getItem();
                if (item instanceof ICustomArmor) {
                    ICustomArmor iCustomArmor = item;
                    if (iCustomArmor.canBlockDamageSource(livingEntity, itemBySlot, damageSource, equipmentSlot)) {
                        ICustomArmor.AbsorptionProperties absorptionPropertiesCopy = iCustomArmor.getProperties(livingEntity, itemBySlot, damageSource, d, equipmentSlot).copy();
                        absorptionPropertiesCopy.slot = equipmentSlot;
                        if (absorptionPropertiesCopy.absorbRatio > 0.0d && absorptionPropertiesCopy.absorbMax > 0) {
                            objectArrayPriorityQueue.enqueue(absorptionPropertiesCopy);
                            int2DoubleLinkedOpenHashMap.addTo(absorptionPropertiesCopy.priority, absorptionPropertiesCopy.absorbRatio);
                        }
                    }
                }
            }
        }
        if (objectArrayPriorityQueue.size() > 0) {
            while (!objectArrayPriorityQueue.isEmpty()) {
                ICustomArmor.AbsorptionProperties absorptionProperties = (ICustomArmor.AbsorptionProperties) objectArrayPriorityQueue.dequeue();
                double d2 = int2DoubleLinkedOpenHashMap.get(absorptionProperties.priority);
                if (d2 > 1.0d) {
                    absorptionProperties.absorbRatio /= d2;
                }
                double dMin = Math.min(d, Math.min(d * absorptionProperties.absorbRatio, absorptionProperties.absorbMax));
                d -= dMin;
                if (dMin > 0.0d) {
                    ItemStack itemBySlot2 = livingEntity.getItemBySlot(absorptionProperties.slot);
                    int iMax = (int) Math.max(1.0d, dMin);
                    ICustomArmor item2 = itemBySlot2.getItem();
                    if (item2 instanceof ICustomArmor) {
                        item2.damageArmor(livingEntity, itemBySlot2, damageSource, iMax, absorptionProperties.slot, ICustomArmor.DamageType.MODDED);
                    }
                }
                if (d <= 0.0d) {
                    return 0.0f;
                }
            }
        }
        double armorValue = livingEntity.getArmorValue();
        double value = livingEntity.getAttribute(Attributes.ARMOR_TOUGHNESS).getValue();
        if (d > 0.0d && (armorValue > 0.0d || value > 0.0d)) {
            double dMax = Math.max(1.0d, d / 4.0d);
            for (EquipmentSlot equipmentSlot2 : EquipmentSlot.values()) {
                if (equipmentSlot2.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                    ItemStack itemBySlot3 = livingEntity.getItemBySlot(equipmentSlot2);
                    ICustomArmor item3 = itemBySlot3.getItem();
                    if (item3 instanceof ICustomArmor) {
                        item3.damageArmor(livingEntity, itemBySlot3, damageSource, (int) dMax, equipmentSlot2, ICustomArmor.DamageType.VANILLA);
                    } else if (itemBySlot3.getItem() instanceof ArmorItem) {
                        itemBySlot3.hurtAndBreak((int) dMax, livingEntity, equipmentSlot2);
                    }
                }
            }
            d = CombatRules.getDamageAfterAbsorb(livingEntity, (float) d, damageSource, (float) armorValue, (float) value);
        }
        return (float) d;
    }
}
