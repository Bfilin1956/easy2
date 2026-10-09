package mctech.o;

import javax.annotation.Nonnull;
import mctech.init.MCTechMenus;
import mctech.init.MCTechModules;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/b.class */
public class b extends d {
    public static final int[][] a = {new int[]{110, 31}, new int[]{150, 41}, new int[]{160, 81}, new int[]{150, 121}, new int[]{110, 131}, new int[]{70, 121}, new int[]{60, 81}, new int[]{70, 41}};
    public static final mctech.modules.e<?>[] b = {MCTechModules.EFFICIENCY, MCTechModules.AUTO_MELT, MCTechModules.FORTUNE, MCTechModules.DEPTH, MCTechModules.RADIUS, MCTechModules.SILK_TOUCH};

    @Nonnull
    private final ContainerData h;

    public b(int i, @Nonnull Inventory inventory, @Nonnull InteractionHand interactionHand, @Nonnull ItemStack itemStack, @Nonnull mctech.e.b bVar) {
        super((MenuType) MCTechMenus.DIGGER_EQUIPMENT_MENU.get(), i, interactionHand, itemStack, bVar, new int[][]{new int[]{191, 43}, new int[]{191, 66}, new int[]{191, 89}, new int[]{191, 113}}, new int[][]{new int[]{98, 69}, new int[]{122, 69}, new int[]{110, 93}});
        a(a, bVar.g());
        a(this.f, bVar.b());
        a(this.g, bVar.h());
        a(inventory);
        this.h = new SimpleContainerData(b.length);
        addDataSlots(this.h);
    }

    @Nonnull
    public ItemStack quickMoveStack(@Nonnull Player player, int i) {
        ItemStack itemStackCopy = ItemStack.EMPTY;
        Slot slot = (Slot) this.slots.get(i);
        if (slot != null && slot.hasItem() && (player instanceof ServerPlayer)) {
            ItemStack item = slot.getItem();
            itemStackCopy = item.copy();
            mctech.items.f.a aVarF = this.e.e().f();
            int maxModuleCount = aVarF.getMaxModuleCount() + aVarF.getMaxModuleCount() + aVarF.getMaxBatteryCount();
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

    @Nonnull
    public ContainerData a() {
        return this.h;
    }
}
