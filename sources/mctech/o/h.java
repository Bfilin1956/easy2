package mctech.o;

import javax.annotation.Nonnull;
import mctech.init.MCTechMenus;
import mctech.m.g.u;
import mctech.modules.config.BasicModularItemTierConfig;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/h.class */
public class h extends e {
    public static final int[][] d = {new int[]{31, 26}, new int[]{55, 26}, new int[]{31, 50}, new int[]{55, 50}, new int[]{133, 26}, new int[]{157, 26}, new int[]{133, 50}, new int[]{157, 50}};
    public static final int[][] e = {new int[]{43, 76}, new int[]{43, 102}, new int[]{145, 76}, new int[]{145, 102}};
    public static final int[][] f = {new int[]{94, 89}};

    public h(int i, @Nonnull Inventory inventory, @Nonnull InteractionHand interactionHand, @Nonnull ItemStack itemStack, @Nonnull mctech.e.c cVar) {
        super(MCTechMenus.SABER_EQUIPMENT_MENU.get(), i, interactionHand, itemStack, cVar);
        a(d, cVar.g());
        a(e, cVar.h());
        addSlot(new u(cVar.c(), 0, 86, 81));
        a(inventory);
    }

    @Nonnull
    public ItemStack quickMoveStack(@Nonnull Player player, int i) {
        ItemStack itemStackCopy = ItemStack.EMPTY;
        Slot slot = (Slot) this.slots.get(i);
        if (slot != null && slot.hasItem() && (player instanceof ServerPlayer)) {
            ItemStack item = slot.getItem();
            itemStackCopy = item.copy();
            BasicModularItemTierConfig basicModularItemTierConfigF = this.c.e().f();
            int maxModuleCount = basicModularItemTierConfigF.getMaxModuleCount() + basicModularItemTierConfigF.getMaxBatteryCount() + 1;
            if (i < maxModuleCount) {
                if (!moveItemStackTo(item, maxModuleCount, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!moveItemStackTo(item, 0, maxModuleCount, false)) {
                return ItemStack.EMPTY;
            }
            if (item.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return itemStackCopy;
    }

    public static e.b a(@Nonnull InteractionHand interactionHand, @Nonnull ItemStack itemStack, @Nonnull mctech.e.c cVar) {
        return new e.b(h::new, interactionHand, itemStack, cVar);
    }
}
