package mctech.api.util;

import java.util.Objects;
import java.util.stream.IntStream;
import mctech.m.a.g;
import mctech.m.e.e;
import mctech.m.e.j;
import mctech.utils.c.h;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/util/ItemInsertionHelper.class */
public class ItemInsertionHelper {
    public static <Machine extends BlockEntity & g> int getValidRoom(Machine machine, ItemStack itemStack) {
        int iB;
        if (machine instanceof e) {
            j<?> inventoryManager = ((e) machine).getInventoryManager();
            for (int i = 0; i < machine.getSlotCount(); i++) {
                if (inventoryManager.c(i).isPresent() && machine.canInsert(i, itemStack) && (iB = h.b(machine.getStackInSlot(i))) > 0) {
                    return iB;
                }
            }
            return 0;
        }
        IntStream intStreamRange = IntStream.range(0, machine.getSlotCount());
        Machine machine2 = machine;
        Objects.requireNonNull(machine2);
        return ((Integer) intStreamRange.mapToObj(machine2::getStackInSlot).filter(itemStack2 -> {
            return h.d(itemStack, itemStack2);
        }).map(h::b).filter(num -> {
            return num.intValue() > 0;
        }).findAny().orElse(Integer.valueOf(itemStack.getCount()))).intValue();
    }
}
