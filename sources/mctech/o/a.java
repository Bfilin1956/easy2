package mctech.o;

import javax.annotation.Nonnull;
import mctech.init.MCTechMenus;
import mctech.init.MCTechModules;
import mctech.items.EnumC0125a;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/a.class */
public class a extends c {
    public static final int[][] a = {new int[]{57, 31}, new int[]{91, 31}, new int[]{123, 31}, new int[]{157, 31}, new int[]{157, 65}, new int[]{157, 97}, new int[]{157, 131}, new int[]{123, 131}, new int[]{91, 131}, new int[]{57, 131}, new int[]{57, 97}, new int[]{57, 65}};
    public static final int[][] b = {new int[]{191, 42}};
    public static final int[][] c = {new int[]{191, 77}};
    public static final int[][] d = {new int[]{191, 113}};
    public static final mctech.modules.e<?>[] e = {MCTechModules.JUMP_BOOST, MCTechModules.MOVEMENT_SPEED, MCTechModules.REGENERATION, MCTechModules.XRAY_VISION, MCTechModules.NIGHT_VISION, MCTechModules.CREATIVE_FLIGHT};

    @Nonnull
    private final ContainerData i;
    private final Slot j;

    public a(int i, @Nonnull Inventory inventory, @Nonnull ItemStack itemStack, @Nonnull mctech.e.a aVar) {
        super(MCTechMenus.ARMOR_EQUIPMENT_MENU.get(), i, itemStack, aVar, new int[][]{new int[]{93, 67}, new int[]{121, 67}, new int[]{107, 95}});
        a(a, aVar.g());
        a(this.h, aVar.h());
        a(b, aVar.c());
        a(c, aVar.b());
        a(d, aVar.d());
        a(inventory);
        this.j = addSlot(new Slot(this, inventory, inventory.items.size() + 2, 999999, 999999) { // from class: mctech.o.a.1
            public boolean mayPickup(@NotNull Player player) {
                return false;
            }
        });
        this.i = new SimpleContainerData(e.length);
        addDataSlots(this.i);
    }

    @Nonnull
    public ItemStack quickMoveStack(@Nonnull Player player, int i) {
        ItemStack itemStackCopy = ItemStack.EMPTY;
        Slot slot = (Slot) this.slots.get(i);
        if (slot != null && slot.hasItem() && (player instanceof ServerPlayer)) {
            ItemStack item = slot.getItem();
            itemStackCopy = item.copy();
            EnumC0125a.C0021a c0021aF = this.g.e().f();
            int maxModuleCount = c0021aF.getMaxModuleCount() + c0021aF.getMaxBatteryCount() + c0021aF.c();
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

    public Slot a() {
        return this.j;
    }

    @Nonnull
    public ContainerData b() {
        return this.i;
    }
}
