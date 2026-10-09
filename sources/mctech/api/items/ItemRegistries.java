package mctech.api.items;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntComparators;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntLists;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSets;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mctech.api.items.armor.IMetalArmor;
import net.minecraft.core.NonNullList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/ItemRegistries.class */
public final class ItemRegistries {
    static final Int2ObjectMap<Item> COIN_MAP = Int2ObjectMaps.synchronize(new Int2ObjectLinkedOpenHashMap());
    static final IntList SORTED_COINS = IntLists.synchronize(new IntArrayList());
    static final Map<Item, IMetalArmor> METAL_ARMORS = Object2ObjectMaps.synchronize(new Object2ObjectOpenHashMap());
    static final Multimap<Item, IBoxableItem> BOX_ITEMS = Multimaps.synchronizedListMultimap(ArrayListMultimap.create());
    static final Map<ShieldItem, Set<String>> SHIELD_BLOCKABLE = Object2ObjectMaps.synchronize(new Object2ObjectLinkedOpenHashMap());
    static final Set<String> SHIELD_BLOCKABLE_GLOBAL = ObjectSets.synchronize(new ObjectLinkedOpenHashSet());

    public static void registerMetalArmor(IMetalArmor iMetalArmor, Item... itemArr) {
        for (Item item : itemArr) {
            METAL_ARMORS.put(item, iMetalArmor);
        }
    }

    public static boolean isMetalArmor(Player player, EquipmentSlot equipmentSlot) {
        ItemStack itemBySlot = player.getItemBySlot(equipmentSlot);
        if (itemBySlot.isEmpty()) {
            return false;
        }
        IMetalArmor iMetalArmor = METAL_ARMORS.get(itemBySlot.getItem());
        if (iMetalArmor == null && (itemBySlot.getItem() instanceof IMetalArmor)) {
            iMetalArmor = (IMetalArmor) itemBySlot.getItem();
        }
        return iMetalArmor != null && iMetalArmor.isMetalArmor(itemBySlot, player, equipmentSlot);
    }

    public static void registerBoxableItems(IBoxableItem iBoxableItem, Item... itemArr) {
        for (Item item : itemArr) {
            BOX_ITEMS.put(item, iBoxableItem);
        }
    }

    public static boolean isBoxable(ItemStack itemStack) {
        IBoxableItem item = itemStack.getItem();
        Iterator it = BOX_ITEMS.get(item).iterator();
        while (it.hasNext()) {
            if (((IBoxableItem) it.next()).canStoreIntoBox(itemStack)) {
                return true;
            }
        }
        return (item instanceof IBoxableItem) && item.canStoreIntoBox(itemStack);
    }

    public static void registerCoin(Item item) {
        int moneyValue;
        if ((item instanceof ICoinItem) && (moneyValue = ((ICoinItem) item).getMoneyValue(new ItemStack(item))) > 0) {
            COIN_MAP.put(moneyValue, item);
            SORTED_COINS.clear();
            SORTED_COINS.addAll(COIN_MAP.keySet());
            SORTED_COINS.sort(IntComparators.OPPOSITE_COMPARATOR);
        }
    }

    public static NonNullList<ItemStack> generateCoins(int i, NonNullList<ItemStack> nonNullList, boolean z) {
        Item item;
        int size = SORTED_COINS.size();
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = SORTED_COINS.getInt(i2);
            if (i >= i3 && (item = (Item) COIN_MAP.get(i3)) != null) {
                int count = i / i3;
                if (!z || count >= 7 || i2 + 1 >= size) {
                    i -= count * i3;
                    while (count > 0) {
                        ItemStack itemStack = new ItemStack(item);
                        itemStack.setCount(Math.min(itemStack.getMaxStackSize(), count));
                        count -= itemStack.getCount();
                        nonNullList.add(itemStack);
                    }
                    if (i <= 0) {
                        return nonNullList;
                    }
                }
            }
        }
        return nonNullList;
    }

    public static void registerBlockableDamageSource(ShieldItem shieldItem, DamageSource damageSource) {
        Set<String> objectLinkedOpenHashSet = SHIELD_BLOCKABLE.get(shieldItem);
        if (objectLinkedOpenHashSet == null) {
            objectLinkedOpenHashSet = new ObjectLinkedOpenHashSet<>();
            SHIELD_BLOCKABLE.put(shieldItem, objectLinkedOpenHashSet);
        }
        objectLinkedOpenHashSet.add(damageSource.getMsgId());
    }

    public static void registerBlockableDamageSource(DamageSource damageSource) {
        SHIELD_BLOCKABLE_GLOBAL.add(damageSource.getMsgId());
    }

    public static boolean isDamageSourceBlockable(ShieldItem shieldItem, DamageSource damageSource) {
        return SHIELD_BLOCKABLE_GLOBAL.contains(damageSource.getMsgId()) || SHIELD_BLOCKABLE.getOrDefault(shieldItem, Collections.emptySet()).contains(damageSource.getMsgId());
    }
}
