package mctech.blocks.base.a;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Objects;
import mctech.api.items.IUpgradeItem;
import mctech.api.tiles.IMachine;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/h.class */
public class h {
    EnumMap<IUpgradeItem.Functions, IntList> a = new EnumMap<>(IUpgradeItem.Functions.class);

    public void a() {
        this.a.clear();
    }

    public void a(int i, EnumSet<IUpgradeItem.Functions> enumSet) {
        if (enumSet == null) {
            return;
        }
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            ((IntList) this.a.computeIfAbsent((IUpgradeItem.Functions) it.next(), functions -> {
                return new IntArrayList();
            })).add(i);
        }
    }

    public boolean a(IUpgradeItem.Functions functions) {
        return this.a.get(functions) != null;
    }

    public boolean a(IUpgradeItem.Functions functions, IUpgradeItem.Functions functions2) {
        return Objects.equals(this.a.get(functions), this.a.get(functions2));
    }

    public void a(NonNullList<ItemStack> nonNullList, IMachine iMachine) {
        IntList intList = this.a.get(IUpgradeItem.Functions.TICK);
        if (intList == null) {
            return;
        }
        int size = intList.size();
        for (int i = 0; i < size; i++) {
            ItemStack itemStack = (ItemStack) nonNullList.get(intList.getInt(i));
            IUpgradeItem item = itemStack.getItem();
            if (item instanceof IUpgradeItem) {
                item.onTick(itemStack, iMachine);
            }
        }
    }

    public void b(NonNullList<ItemStack> nonNullList, IMachine iMachine) {
        IntList intList = this.a.get(IUpgradeItem.Functions.RECIPE);
        if (intList == null) {
            return;
        }
        int size = intList.size();
        for (int i = 0; i < size; i++) {
            ItemStack itemStack = (ItemStack) nonNullList.get(intList.getInt(i));
            IUpgradeItem item = itemStack.getItem();
            if (item instanceof IUpgradeItem) {
                item.onMachineProcessed(itemStack, iMachine);
            }
        }
    }

    public void a(NonNullList<ItemStack> nonNullList, IMachine iMachine, Recipe<?> recipe, CompoundTag compoundTag) {
        IntList intList = this.a.get(IUpgradeItem.Functions.RECIPE);
        if (intList == null) {
            return;
        }
        int size = intList.size();
        for (int i = 0; i < size; i++) {
            ItemStack itemStack = (ItemStack) nonNullList.get(intList.getInt(i));
            IUpgradeItem item = itemStack.getItem();
            if (item instanceof IUpgradeItem) {
                item.onMachineFinishedRecipePre(itemStack, iMachine, recipe, compoundTag);
            }
        }
    }

    public void a(NonNullList<ItemStack> nonNullList, IMachine iMachine, Recipe<?> recipe) {
        IntList intList = this.a.get(IUpgradeItem.Functions.RECIPE);
        if (intList == null) {
            return;
        }
        int size = intList.size();
        for (int i = 0; i < size; i++) {
            ItemStack itemStack = (ItemStack) nonNullList.get(intList.getInt(i));
            IUpgradeItem item = itemStack.getItem();
            if (item instanceof IUpgradeItem) {
                item.onMachineFinishedRecipePost(itemStack, iMachine, recipe, nonNullList);
            }
        }
    }
}
