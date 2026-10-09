package mctech.m.g;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: renamed from: mctech.m.g.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/b.class */
public class C0168b extends Slot {
    public static final String[] a = {"item/empty_armor_slot_boots", "item/empty_armor_slot_leggings", "item/empty_armor_slot_chestplate", "item/empty_armor_slot_helmet"};
    Player b;
    EquipmentSlot c;

    public C0168b(Player player, EquipmentSlot equipmentSlot, int i, int i2, int i3) {
        super(player.getInventory(), i, i2, i3);
        this.b = player;
        this.c = equipmentSlot;
        setBackground(InventoryMenu.BLOCK_ATLAS, ResourceLocation.parse(a[equipmentSlot.getIndex()]));
    }

    public int getMaxStackSize() {
        return 1;
    }

    public boolean mayPlace(ItemStack itemStack) {
        return itemStack.canEquip(this.c, this.b);
    }

    public boolean mayPickup(Player player) {
        return (getItem().isEmpty() || player.isCreative()) && super.mayPickup(player);
    }
}
