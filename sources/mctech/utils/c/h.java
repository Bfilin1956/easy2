package mctech.utils.c;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Iterator;
import java.util.List;
import mctech.api.items.ITagItem;
import mctech.init.MCTechDataComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c/h.class */
public class h {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 4;
    public static final int d = 8;
    public static final int e = 16;
    public static final int f = 32;
    public static final int g = 64;
    public static final int h = 128;
    public static final int i = 256;
    public static final int j = 20;
    public static final int k = 22;

    public static void a(Player player, BlockPos blockPos, ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return;
        }
        if (!player.addItem(itemStack)) {
            Block.popResource(player.level(), blockPos, itemStack);
        } else {
            player.containerMenu.broadcastChanges();
        }
    }

    public static void a(Level level, BlockPos blockPos, ItemStack itemStack) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        a(itemStack, itemStack.getCount(), (List<ItemStack>) objectArrayList);
        Iterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            Block.popResource(level, blockPos, (ItemStack) it.next());
        }
    }

    public static void a(Player player, ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return;
        }
        if (!player.addItem(itemStack)) {
            player.drop(itemStack, false);
        } else {
            player.containerMenu.broadcastChanges();
        }
    }

    public static CompoundTag a(ItemStack itemStack) {
        CompoundTag compoundTag = (CompoundTag) itemStack.get(MCTechDataComponent.NBT_TAG);
        if (compoundTag == null) {
            compoundTag = new CompoundTag();
            itemStack.set(MCTechDataComponent.NBT_TAG, compoundTag);
        }
        return compoundTag;
    }

    public static void a(ItemStack itemStack, Component component) {
    }

    public static void a(ItemStack itemStack, String str) {
    }

    public static int b(ItemStack itemStack) {
        return itemStack.getMaxStackSize() - itemStack.getCount();
    }

    public static ItemStack a(ItemStack itemStack, int i2) {
        ItemStack itemStackCopy = itemStack.copy();
        itemStackCopy.setCount(i2);
        return itemStackCopy;
    }

    public static List<ItemStack> a(List<ItemStack> list) {
        ObjectArrayList objectArrayList = new ObjectArrayList(list.size());
        Iterator<ItemStack> it = list.iterator();
        while (it.hasNext()) {
            objectArrayList.add(it.next().copy());
        }
        return objectArrayList;
    }

    public static List<ItemStack> b(List<ItemStack> list) {
        ObjectArrayList objectArrayList = new ObjectArrayList(list.size());
        for (ItemStack itemStack : list) {
            if (!itemStack.isEmpty()) {
                objectArrayList.add(itemStack.copy());
            }
        }
        return objectArrayList;
    }

    public static boolean a(CompoundTag compoundTag, CompoundTag compoundTag2, boolean z) {
        if (compoundTag == null || compoundTag2 == null) {
            return compoundTag2 == null || compoundTag2.isEmpty();
        }
        for (String str : compoundTag.getAllKeys()) {
            if (!z || !str.equals("Damage")) {
                Tag tag = compoundTag.get(str);
                Tag tag2 = compoundTag2.get(str);
                if (tag2 == null || tag.getId() != tag2.getId() || !tag.equals(tag2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean a(ItemStack itemStack, ItemStack itemStack2, boolean z) {
        if (0 == 0 && 0 == 0) {
            return true;
        }
        if (0 == 0 || 0 == 0) {
            return false;
        }
        return true;
    }

    public static boolean a(ItemStack itemStack, ItemStack itemStack2) {
        return (itemStack.isEmpty() && itemStack2.isEmpty()) || ((itemStack.getItem() instanceof ITagItem) && itemStack.getItem().matches(itemStack, itemStack2));
    }

    public static boolean b(ItemStack itemStack, ItemStack itemStack2) {
        return d(itemStack, itemStack2) && b(itemStack) >= itemStack2.getCount();
    }

    public static boolean a(ItemStack itemStack, ItemStack itemStack2, int i2) {
        return b(itemStack, itemStack2, i2) && b(itemStack) >= itemStack2.getCount();
    }

    public static boolean c(ItemStack itemStack, ItemStack itemStack2) {
        return FluidStack.isSameFluidSameComponents((FluidStack) FluidUtil.getFluidContained(itemStack).orElse(FluidStack.EMPTY), (FluidStack) FluidUtil.getFluidContained(itemStack2).orElse(FluidStack.EMPTY));
    }

    public static boolean d(ItemStack itemStack, ItemStack itemStack2) {
        return ItemStack.isSameItemSameComponents(itemStack, itemStack2);
    }

    public static boolean e(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack.isEmpty() || itemStack2.isEmpty()) {
            return false;
        }
        return ItemStack.isSameItemSameComponents(itemStack, itemStack2);
    }

    public static boolean f(ItemStack itemStack, ItemStack itemStack2) {
        return !itemStack2.isEmpty() && itemStack.is(itemStack2.getItem());
    }

    public static boolean b(ItemStack itemStack, ItemStack itemStack2, int i2) {
        boolean zIsEmpty = itemStack.isEmpty();
        boolean zIsEmpty2 = itemStack2.isEmpty();
        if (zIsEmpty && zIsEmpty2) {
            return (i2 & 1) != 0;
        }
        if (zIsEmpty || zIsEmpty2) {
            return itemStack.isEmpty() && (i2 & 2) != 0;
        }
        if ((i2 & 4) != 0 && !f(itemStack, itemStack2)) {
            return ((i2 & 32) != 0 && a(itemStack, itemStack2)) || ((i2 & 128) != 0 && c(itemStack, itemStack2));
        }
        if ((i2 & 4) == 0) {
            if ((i2 & 32) != 0 && a(itemStack, itemStack2)) {
                return true;
            }
            if ((i2 & 128) != 0 && c(itemStack, itemStack2)) {
                return true;
            }
        }
        if (((i2 & 64) == 0 || itemStack.getDamageValue() == itemStack2.getDamageValue()) && (i2 & 8) == 0) {
            if ((i2 & 16) != 0) {
                if (a(itemStack, itemStack2, (i2 & i) != 0)) {
                }
            }
            return true;
        }
        return false;
    }

    public static void a(ItemStack itemStack, int i2, List<ItemStack> list) {
        while (i2 > 0) {
            int iMin = Math.min(i2, itemStack.getMaxStackSize());
            list.add(a(itemStack, iMin));
            i2 -= iMin;
        }
    }

    public static boolean a(List<ItemStack> list, ItemStack itemStack) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (d(itemStack, list.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(NonNullList<ItemStack> nonNullList) {
        boolean z = true;
        for (int i2 = 0; i2 < nonNullList.size(); i2++) {
            if (!((ItemStack) nonNullList.get(i2)).isEmpty()) {
                z = false;
                break;
            }
        }
        return z;
    }

    public static int c(List<ItemStack> list) {
        int count = 0;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            count += list.get(i2).getCount();
        }
        return count;
    }

    public static List<ItemStack> d(List<ItemStack> list) {
        ObjectList objectListI = mctech.utils.a.b.i();
        for (ItemStack itemStack : list) {
            if (!itemStack.isEmpty()) {
                objectListI.add(itemStack);
            }
        }
        return objectListI;
    }

    public static int a(NonNullList<ItemStack> nonNullList, mctech.m.c.g... gVarArr) {
        if (gVarArr.length > 30 || nonNullList == null || nonNullList.size() <= 0) {
            return 0;
        }
        int i2 = 0;
        int length = gVarArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int size = nonNullList.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (gVarArr[i3].matches((ItemStack) nonNullList.get(i4))) {
                    i2 |= 1 << i3;
                    break;
                }
            }
        }
        return i2;
    }

    public static boolean a(Player player, mctech.m.c.g gVar) {
        if (player == null) {
            return false;
        }
        Inventory inventory = player.getInventory();
        for (int i2 = 0; i2 < 9; i2++) {
            if (gVar.matches(inventory.getItem(i2))) {
                return true;
            }
        }
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            if (gVar.matches(player.getItemBySlot(equipmentSlot))) {
                return true;
            }
        }
        return false;
    }

    public static int a(Player player, mctech.m.c.g... gVarArr) {
        if (gVarArr.length > 30 || player == null) {
            return 0;
        }
        ObjectList objectListI = mctech.utils.a.b.i();
        for (int i2 = 0; i2 < 9; i2++) {
            ItemStack item = player.getInventory().getItem(i2);
            if (!item.isEmpty()) {
                objectListI.add(item);
            }
        }
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            if (equipmentSlot != EquipmentSlot.MAINHAND) {
                ItemStack itemBySlot = player.getItemBySlot(equipmentSlot);
                if (!itemBySlot.isEmpty()) {
                    objectListI.add(itemBySlot);
                }
            }
        }
        if (objectListI.isEmpty()) {
            return 0;
        }
        int i3 = 0;
        int length = gVarArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            int size = objectListI.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (gVarArr[i4].matches((ItemStack) objectListI.get(i5))) {
                    i3 |= 1 << i4;
                    break;
                }
            }
        }
        return i3;
    }
}
