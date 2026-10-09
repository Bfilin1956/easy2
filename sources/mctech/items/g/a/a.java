package mctech.items.g.a;

import mctech.MCTech;
import mctech.api.items.armor.IMetalArmor;
import mctech.init.MCTechMaterials;
import mctech.items.base.o;
import mctech.items.g.b.f;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/a/a.class */
public class a extends f implements IMetalArmor {
    public a(ArmorItem.Type type) {
        super((Holder<ArmorMaterial>) MCTechMaterials.BRONZE_ARMOR, type, new o().c(type.getDurability(15)));
    }

    /* JADX INFO: renamed from: mctech.items.g.a.a$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/a/a$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[ArmorItem.Type.values().length];

        static {
            try {
                a[ArmorItem.Type.HELMET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[ArmorItem.Type.CHESTPLATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[ArmorItem.Type.BOOTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[ArmorItem.Type.LEGGINGS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public ResourceLocation getArmorTexture(ItemStack itemStack, Entity entity, EquipmentSlot equipmentSlot, ArmorMaterial.Layer layer, boolean z) {
        switch (AnonymousClass1.a[itemStack.getItem().getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return MCTech.loc("textures/item/armor/bronze/bronze_armor.png");
            case 4:
                return MCTech.loc("textures/item/armor/bronze/bronze_leggings.png");
            default:
                return super.getArmorTexture(itemStack, entity, equipmentSlot, layer, z);
        }
    }

    @Override // mctech.api.items.armor.IMetalArmor
    public boolean isMetalArmor(ItemStack itemStack, Player player, EquipmentSlot equipmentSlot) {
        return true;
    }
}
