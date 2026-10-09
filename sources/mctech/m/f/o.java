package mctech.m.f;

import appeng.api.stacks.AEKeyType;
import appeng.api.storage.cells.IBasicCellItem;
import mctech.init.MCTechDataComponent;
import mctech.m.b.S;
import mctech.m.b.aq;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/o.class */
public class o extends j {
    public static final int a = 5;

    public o(Player player, mctech.m.a.e eVar, ItemStack itemStack, Slot slot) {
        super(player, eVar, itemStack, slot);
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new aq(this, player, b(), i);
    }

    @Override // mctech.m.f.j, mctech.m.a.g
    public int getSlotCount() {
        return 5;
    }

    @Override // mctech.m.f.j, mctech.m.a.g
    public int getMaxStackSize(int i) {
        return 1;
    }

    @Override // mctech.m.f.j, mctech.m.a.g
    public boolean canInsert(int i, ItemStack itemStack) {
        return d(itemStack);
    }

    @Override // mctech.m.f.j
    protected void c() {
        ItemStack itemStackB = b(this.e);
        if (!itemStackB.isEmpty() && c(itemStackB)) {
            CompoundTag compoundTagA = a(itemStackB, true);
            b(compoundTagA);
            itemStackB.set(MCTechDataComponent.NBT_TAG, compoundTagA);
        }
        super.c();
    }

    public static boolean d(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return false;
        }
        mctech.a.b item = itemStack.getItem();
        if ((item instanceof mctech.a.b) && item.a()) {
            return false;
        }
        IBasicCellItem item2 = itemStack.getItem();
        return (item2 instanceof IBasicCellItem) && item2.getKeyType() == AEKeyType.items();
    }
}
