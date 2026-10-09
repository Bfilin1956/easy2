package mctech.api.items.electric;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.function.Function;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.items.IItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/electric/ElectricItem.class */
public final class ElectricItem {
    static final Map<Item, IElectricItemManager> BACKUPS = new Object2ObjectOpenHashMap();
    static Function<Player, IItemHandler> CURIO_ACCESSOR;
    public static IElectricItemManager MANAGER;
    public static IElectricItemManager DIRECT_MANAGER;

    public static void registerBackupManager(IElectricItemManager iElectricItemManager, ItemLike... itemLikeArr) {
        for (ItemLike itemLike : itemLikeArr) {
            BACKUPS.put(itemLike.asItem(), iElectricItemManager);
        }
    }

    public static void setCurioSupport(Function<Player, IItemHandler> function) {
        CURIO_ACCESSOR = function;
    }

    public static IElectricItemManager getBackupManager(Item item) {
        return BACKUPS.get(item);
    }

    public static int chargeArmor(Player player, int i) {
        return chargeArmor(player, i, true, EquipmentSlot.values());
    }

    public static int chargeArmor(Player player, int i, boolean z, EquipmentSlot... equipmentSlotArr) {
        return chargeArmor(player, i, z, true, equipmentSlotArr);
    }

    public static int chargeArmor(Player player, int i, boolean z, boolean z2, EquipmentSlot... equipmentSlotArr) {
        if (z) {
            for (EquipmentSlot equipmentSlot : equipmentSlotArr) {
                if (i <= 0) {
                    break;
                }
                if (equipmentSlot.getType() != EquipmentSlot.Type.HAND) {
                    i -= MANAGER.charge(player.getItemBySlot(equipmentSlot), i, Integer.MAX_VALUE, false, false);
                }
            }
            if (i > 0 && z2 && CURIO_ACCESSOR != null) {
                i -= chargeCurio(CURIO_ACCESSOR.apply(player), i);
            }
            return i;
        }
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) ObjectArrayList.wrap(equipmentSlotArr));
        for (EquipmentSlot equipmentSlot2 : EquipmentSlot.values()) {
            if (i <= 0) {
                break;
            }
            if (equipmentSlot2.getType() != EquipmentSlot.Type.HAND && !enumSetCopyOf.contains(equipmentSlot2)) {
                i -= MANAGER.charge(player.getItemBySlot(equipmentSlot2), i, Integer.MAX_VALUE, false, false);
            }
        }
        if (i > 0 && z2 && CURIO_ACCESSOR != null) {
            i -= chargeCurio(CURIO_ACCESSOR.apply(player), i);
        }
        return i;
    }

    public static int chargeCurio(IItemHandler iItemHandler, int i) {
        if (iItemHandler == null) {
            return 0;
        }
        int iCharge = 0;
        int slots = iItemHandler.getSlots();
        for (int i2 = 0; i2 < slots && iCharge < i; i2++) {
            iCharge += MANAGER.charge(iItemHandler.getStackInSlot(i2), i - iCharge, Integer.MAX_VALUE, false, false);
        }
        return iCharge;
    }

    public static int applyEnchantmentEffect(ItemStack itemStack, int i) {
        return i;
    }
}
