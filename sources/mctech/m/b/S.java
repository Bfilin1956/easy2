package mctech.m.b;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import mctech.MCTech;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/S.class */
public abstract class S extends AbstractContainerMenu {
    private static final Container EMPTY_CONTAINER = new Container() { // from class: mctech.m.b.S.1
        public void clearContent() {
        }

        public int getContainerSize() {
            return 0;
        }

        public boolean isEmpty() {
            return false;
        }

        @NotNull
        public ItemStack getItem(int i) {
            return ItemStack.EMPTY;
        }

        @NotNull
        public ItemStack removeItem(int i, int i2) {
            return ItemStack.EMPTY;
        }

        @NotNull
        public ItemStack removeItemNoUpdate(int i) {
            return ItemStack.EMPTY;
        }

        public void setItem(int i, @NotNull ItemStack itemStack) {
        }

        public void setChanged() {
        }

        public boolean stillValid(@NotNull Player player) {
            return false;
        }
    };
    private int extra;

    public abstract int getInventorySize();

    public S(int i) {
        super((MenuType) null, i);
    }

    protected void addExtraSlots(int i) {
        this.extra += i;
    }

    public int getUpgradeSlots() {
        return 0;
    }

    public boolean moveBackwardsIntoMachine() {
        return false;
    }

    public boolean moveBackwardsIntoInventory() {
        return true;
    }

    @NotNull
    public Slot getSlot(int i) {
        try {
            return super.getSlot(i);
        } catch (Exception e) {
            MCTech.LOGGER.error("Try access slot {} in {}, slots: {}", Integer.valueOf(i), getClass(), Integer.valueOf(this.slots.size()));
            return new Slot(EMPTY_CONTAINER, i, 0, 0);
        }
    }

    public boolean canDragTo(Slot slot) {
        if (slot instanceof mctech.m.g.x) {
            ((mctech.m.g.x) slot).g();
            return true;
        }
        return true;
    }

    public void clicked(int i, int i2, @NotNull ClickType clickType, @NotNull Player player) {
        if (i >= 0 && i < this.slots.size()) {
            Slot slot = (Slot) this.slots.get(i);
            ItemStack item = slot.getItem();
            if (!item.isEmpty() && item.getCount() > item.getMaxStackSize()) {
                if (clickType == ClickType.SWAP) {
                    handleOversizedSwap(slot, i2, player);
                    return;
                } else if (clickType == ClickType.THROW) {
                    handleOversizedThrow(slot, i2, player);
                    return;
                }
            }
        }
        super.clicked(i, i2, clickType, player);
    }

    private void handleOversizedSwap(Slot slot, int i, Player player) {
        if (i >= 0) {
            if (i > 8 && i != 40) {
                return;
            }
            ItemStack item = slot.getItem();
            if (item.isEmpty() || !slot.mayPickup(player) || !player.getInventory().getItem(i).isEmpty()) {
                return;
            }
            ItemStack itemStackRemove = slot.remove(Math.min(item.getCount(), item.getMaxStackSize()));
            if (itemStackRemove.isEmpty()) {
                return;
            }
            player.getInventory().setItem(i, itemStackRemove);
            slot.onTake(player, itemStackRemove);
        }
    }

    private void handleOversizedThrow(Slot slot, int i, Player player) {
        ItemStack item = slot.getItem();
        if (item.isEmpty() || !slot.mayPickup(player)) {
            return;
        }
        ItemStack itemStackRemove = slot.remove(i == 0 ? 1 : Math.min(item.getCount(), item.getMaxStackSize()));
        if (itemStackRemove.isEmpty()) {
            return;
        }
        player.drop(itemStackRemove, true);
        slot.onTake(player, itemStackRemove);
    }

    @NotNull
    public ItemStack quickMoveStack(@NotNull Player player, int i) {
        ItemStack itemStackCopy = ItemStack.EMPTY;
        Slot slot = (Slot) this.slots.get(i);
        int inventorySize = getInventorySize() - getUpgradeSlots();
        if (slot.hasItem() && !(slot instanceof mctech.m.g.o)) {
            ItemStack item = slot.getItem();
            if (i < inventorySize && item.getCount() > item.getMaxStackSize()) {
                int maxStackSize = item.getMaxStackSize();
                ItemStack itemStackCopyWithCount = item.copyWithCount(maxStackSize);
                ItemStack itemStackCopy2 = itemStackCopyWithCount.copy();
                if (!moveItemStackTo(itemStackCopyWithCount, inventorySize + this.extra, this.slots.size(), moveBackwardsIntoInventory())) {
                    return ItemStack.EMPTY;
                }
                int count = maxStackSize - itemStackCopyWithCount.getCount();
                if (count <= 0) {
                    return ItemStack.EMPTY;
                }
                item.shrink(count);
                if (item.isEmpty()) {
                    slot.set(ItemStack.EMPTY);
                } else {
                    slot.setChanged();
                }
                ItemStack itemStackCopyWithCount2 = itemStackCopy2.copyWithCount(count);
                slot.onTake(player, itemStackCopyWithCount2);
                return itemStackCopyWithCount2;
            }
            itemStackCopy = item.copy();
            if (i < inventorySize) {
                if (!moveItemStackTo(item, inventorySize + this.extra, this.slots.size(), moveBackwardsIntoInventory())) {
                    return ItemStack.EMPTY;
                }
            } else if (!moveItemStackTo(item, 0, inventorySize + this.extra, moveBackwardsIntoMachine())) {
                return ItemStack.EMPTY;
            }
            if (item.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
            if (item.getCount() == itemStackCopy.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, item);
        }
        return itemStackCopy;
    }

    protected boolean moveItemStackTo(ItemStack itemStack, int i, int i2, boolean z) {
        return moveItemStackTo(itemStack, this.slots, i, i2, z);
    }

    protected boolean moveItemStackToPriorizeUpgradeSlots(ItemStack itemStack, int i, int i2, boolean z) {
        List objectArrayList = new ObjectArrayList(i2 - i);
        List objectArrayList2 = new ObjectArrayList(i2 - i);
        for (int i3 = i; i3 < i2; i3++) {
            Slot slot = (Slot) this.slots.get(i3);
            (slot instanceof mctech.m.g.z ? objectArrayList : objectArrayList2).add(slot);
        }
        objectArrayList.addAll(objectArrayList2);
        return moveItemStackTo(itemStack, objectArrayList, 0, objectArrayList.size(), z);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0091  */
    /* JADX WARN: Code duplicated, block: B:29:0x00af  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:52:0x011b  */
    /* JADX WARN: Code duplicated, block: B:61:0x0170  */
    /* JADX WARN: Code duplicated, block: B:62:0x0174  */
    protected boolean moveItemStackTo(ItemStack itemStack, List<Slot> list, int i, int i2, boolean z) {
        Slot slot;
        int i3;
        Slot slot2;
        ItemStack item;
        int i4;
        int count;
        int iMin;
        boolean z2 = false;
        int i5 = z ? i2 - 1 : i;
        if (itemStack.isStackable()) {
            while (!itemStack.isEmpty()) {
                if (z) {
                    if (i5 < i) {
                        break;
                    }
                    slot2 = list.get(i5);
                    item = slot2.getItem();
                    if (!item.isEmpty() && slot2.mayPlace(itemStack) && !(slot2 instanceof mctech.m.g.o) && ItemStack.isSameItemSameComponents(itemStack, item)) {
                        count = item.getCount() + itemStack.getCount();
                        iMin = Math.min(slot2.getMaxStackSize(item), itemStack.getMaxStackSize());
                        if (count <= iMin) {
                            itemStack.setCount(0);
                            item.setCount(count);
                            slot2.set(item);
                            slot2.setChanged();
                            z2 = true;
                        } else if (item.getCount() < iMin) {
                            itemStack.shrink(iMin - item.getCount());
                            item.setCount(iMin);
                            slot2.set(item);
                            slot2.setChanged();
                            z2 = true;
                        }
                    }
                    int i6 = i5;
                    if (z) {
                        i4 = -1;
                    } else {
                        i4 = 1;
                    }
                    i5 = i6 + i4;
                } else {
                    if (i5 >= i2) {
                        break;
                    }
                    slot2 = list.get(i5);
                    item = slot2.getItem();
                    if (!item.isEmpty()) {
                        count = item.getCount() + itemStack.getCount();
                        iMin = Math.min(slot2.getMaxStackSize(item), itemStack.getMaxStackSize());
                        if (count <= iMin) {
                            itemStack.setCount(0);
                            item.setCount(count);
                            slot2.set(item);
                            slot2.setChanged();
                            z2 = true;
                        } else if (item.getCount() < iMin) {
                            itemStack.shrink(iMin - item.getCount());
                            item.setCount(iMin);
                            slot2.set(item);
                            slot2.setChanged();
                            z2 = true;
                        }
                    }
                    int i7 = i5;
                    if (z) {
                        i4 = -1;
                    } else {
                        i4 = 1;
                    }
                    i5 = i7 + i4;
                }
            }
        }
        if (!itemStack.isEmpty()) {
            int i8 = z ? i2 - 1 : i;
            while (true) {
                int i9 = i8;
                if (z) {
                    if (i9 >= i) {
                        slot = list.get(i9);
                        if (!slot.getItem().isEmpty() && slot.mayPlace(itemStack) && !(slot instanceof mctech.m.g.o)) {
                            slot.set(itemStack.split(Math.min(itemStack.getCount(), slot.getMaxStackSize(itemStack))));
                            slot.setChanged();
                            z2 = true;
                            break;
                        }
                        if (z) {
                            i3 = -1;
                        } else {
                            i3 = 1;
                        }
                        i8 = i9 + i3;
                    } else {
                        break;
                    }
                } else {
                    if (i9 >= i2) {
                        break;
                    }
                    slot = list.get(i9);
                    if (!slot.getItem().isEmpty()) {
                    }
                    if (z) {
                        i3 = -1;
                    } else {
                        i3 = 1;
                    }
                    i8 = i9 + i3;
                }
            }
        }
        return z2;
    }
}
