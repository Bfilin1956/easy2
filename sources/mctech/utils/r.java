package mctech.utils;

import com.google.common.collect.LinkedHashMultimap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/r.class */
public interface r {
    void a(int i, ItemStack itemStack);

    ItemStack getStackInSlot(int i);

    int[] a(boolean z);

    default boolean b(int i, ItemStack itemStack) {
        if (!(this instanceof mctech.m.e.e)) {
            return true;
        }
        return ((Boolean) ((mctech.m.e.e) this).getInventoryManager().c(i).map(aVar -> {
            return Boolean.valueOf(aVar.matches(i, itemStack));
        }).orElse(true)).booleanValue();
    }

    default boolean O_() {
        int[] iArrA = a(true);
        LinkedHashMultimap linkedHashMultimapCreate = LinkedHashMultimap.create();
        IntLinkedOpenHashSet intLinkedOpenHashSet = new IntLinkedOpenHashSet();
        for (int i : iArrA) {
            ItemStack stackInSlot = getStackInSlot(i);
            if (stackInSlot.isEmpty()) {
                intLinkedOpenHashSet.add(i);
            } else {
                C c = (C) linkedHashMultimapCreate.get(stackInSlot.getItem()).stream().filter(c2 -> {
                    return c2.a(stackInSlot);
                }).findFirst().orElse(null);
                if (c != null) {
                    c.a(i, stackInSlot);
                } else {
                    linkedHashMultimapCreate.put(stackInSlot.getItem(), new C(stackInSlot, i));
                }
            }
        }
        if (linkedHashMultimapCreate.isEmpty()) {
            return false;
        }
        IntLinkedOpenHashSet intLinkedOpenHashSet2 = new IntLinkedOpenHashSet();
        for (C c3 : linkedHashMultimapCreate.values()) {
            IntLinkedOpenHashSet intLinkedOpenHashSet3 = new IntLinkedOpenHashSet();
            IntIterator it = c3.b.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!b(iIntValue, c3.a)) {
                    intLinkedOpenHashSet3.add(iIntValue);
                }
            }
            if (!intLinkedOpenHashSet3.isEmpty()) {
                c3.b.removeAll(intLinkedOpenHashSet3);
                intLinkedOpenHashSet2.addAll(intLinkedOpenHashSet3);
            }
        }
        intLinkedOpenHashSet.addAll(intLinkedOpenHashSet2);
        List<C> list = linkedHashMultimapCreate.values().stream().sorted(Comparator.comparingInt(c4 -> {
            return c4.c;
        }).reversed()).toList();
        IntIterator it2 = intLinkedOpenHashSet.iterator();
        while (it2.hasNext()) {
            int iIntValue2 = ((Integer) it2.next()).intValue();
            for (C c5 : list) {
                if (b(iIntValue2, c5.a)) {
                    c5.b.add(iIntValue2);
                    break;
                }
            }
        }
        for (C c6 : list) {
            if (c6.b.isEmpty() && c6.c > 0) {
                IntIterator it3 = intLinkedOpenHashSet2.iterator();
                while (it3.hasNext()) {
                    int iIntValue3 = ((Integer) it3.next()).intValue();
                    boolean z = false;
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        if (((C) it4.next()).b.contains(iIntValue3)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        c6.b.add(iIntValue3);
                        break;
                    }
                }
            }
        }
        Int2ObjectOpenHashMap int2ObjectOpenHashMap = new Int2ObjectOpenHashMap();
        IntIterator it5 = intLinkedOpenHashSet2.iterator();
        while (it5.hasNext()) {
            int iIntValue4 = ((Integer) it5.next()).intValue();
            boolean z2 = false;
            Iterator it6 = list.iterator();
            while (it6.hasNext()) {
                if (((C) it6.next()).b.contains(iIntValue4)) {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                int2ObjectOpenHashMap.put(iIntValue4, ItemStack.EMPTY);
            }
        }
        for (C c7 : list) {
            if (!c7.b.isEmpty()) {
                int[] intArray = c7.b.toIntArray();
                int length = intArray.length;
                int[] iArr = new int[length];
                int[] iArr2 = new int[length];
                int i2 = c7.c / length;
                int i3 = c7.c % length;
                int i4 = 0;
                while (i4 < length) {
                    iArr[i4] = e(intArray[i4]);
                    iArr2[i4] = i2 + (i4 < i3 ? 1 : 0);
                    i4++;
                }
                a(iArr2, iArr);
                for (int i5 = 0; i5 < length; i5++) {
                    ItemStack itemStackCopy = ItemStack.EMPTY;
                    if (iArr2[i5] > 0) {
                        itemStackCopy = c7.a.copy();
                        itemStackCopy.setCount(iArr2[i5]);
                    }
                    int2ObjectOpenHashMap.put(intArray[i5], itemStackCopy);
                }
            }
        }
        ObjectIterator it7 = int2ObjectOpenHashMap.int2ObjectEntrySet().iterator();
        while (it7.hasNext()) {
            Int2ObjectMap.Entry entry = (Int2ObjectMap.Entry) it7.next();
            ItemStack itemStack = (ItemStack) entry.getValue();
            int count = itemStack.getCount();
            a(entry.getIntKey(), itemStack);
            if (!itemStack.isEmpty() && itemStack.getCount() < count) {
                itemStack.setCount(count);
            }
        }
        return true;
    }

    default int e(int i) {
        if (this instanceof mctech.m.a.g) {
            return Math.max(1, ((mctech.m.a.g) this).getMaxStackSize(i));
        }
        return 64;
    }

    private static void a(int[] iArr, int[] iArr2) {
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] > iArr2[i2]) {
                i += iArr[i2] - iArr2[i2];
                iArr[i2] = iArr2[i2];
            }
        }
        for (int i3 = 0; i3 < iArr.length && i > 0; i3++) {
            int i4 = iArr2[i3] - iArr[i3];
            if (i4 > 0) {
                int iMin = Math.min(i4, i);
                int i5 = i3;
                iArr[i5] = iArr[i5] + iMin;
                i -= iMin;
            }
        }
        if (i > 0) {
            int length = iArr.length - 1;
            iArr[length] = iArr[length] + i;
        }
    }
}
