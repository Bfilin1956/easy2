package mctech.o;

import javax.annotation.Nonnull;
import mctech.init.MCTechMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.neoforged.neoforge.network.IContainerFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/i.class */
public class i extends AbstractContainerMenu {
    public static final int[][] a = {new int[]{26, 130}, new int[]{49, 130}, new int[]{72, 130}, new int[]{95, 130}, new int[]{118, 130}};
    public static final int[][] b = {new int[]{141, 130}, new int[]{164, 130}};
    public static final int[][] c = {new int[]{187, 130}};
    public static final int d = 35;
    public static final int e = 166;

    @Nonnull
    protected final ItemStack f;

    @Nonnull
    protected final mctech.e.d g;

    @Nonnull
    protected final ContainerData h;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/i$a.class */
    @FunctionalInterface
    public interface a {
        @Nonnull
        i a(int i, @Nonnull Inventory inventory, @Nonnull ItemStack itemStack, @Nonnull mctech.e.d dVar);
    }

    public i(int i, @NotNull Inventory inventory, @NotNull ItemStack itemStack, @NotNull mctech.e.d dVar) {
        super(MCTechMenus.SINGULAR_ARMOR_MENU.get(), i);
        this.f = itemStack;
        this.g = dVar;
        this.h = new SimpleContainerData(mctech.items.g.a.d.s.length);
        a();
        addDataSlots(this.h);
        a(a, dVar.b());
        a(b, dVar.c());
        a(c, dVar.d());
        a(inventory);
    }

    protected void a() {
        for (int i = 0; i < mctech.items.g.a.d.s.length; i++) {
            this.h.set(i, mctech.items.g.a.c.a(this.f, mctech.items.g.a.d.s[i]) ? 1 : 0);
        }
    }

    protected void a(@Nonnull int[][] iArr, @Nonnull IItemHandler iItemHandler) {
        for (int i = 0; i < iItemHandler.getSlots(); i++) {
            addSlot(new SlotItemHandler(this, iItemHandler, i, iArr[i][0], iArr[i][1]) { // from class: mctech.o.i.1
                public int getMaxStackSize() {
                    return 1;
                }

                public int getMaxStackSize(@NotNull ItemStack itemStack) {
                    return 1;
                }
            });
        }
    }

    protected void a(@Nonnull Inventory inventory) {
        int i = 166;
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 9; i3++) {
                addSlot(new Slot(inventory, i3 + (i2 * 9) + 9, 35 + (i3 * 18), i));
            }
            i += 18;
        }
        int i4 = i + 4;
        for (int i5 = 0; i5 < 9; i5++) {
            addSlot(new Slot(inventory, i5, 35 + (i5 * 18), i4));
        }
    }

    @Nonnull
    public mctech.e.d b() {
        return this.g;
    }

    @Nonnull
    public ItemStack c() {
        return this.f;
    }

    @Nonnull
    public ContainerData d() {
        return this.h;
    }

    public boolean stillValid(@Nonnull Player player) {
        return player.getItemBySlot(EquipmentSlot.CHEST) == this.f && (this.f.getItem() instanceof mctech.items.g.a.c) && mctech.items.g.a.c.a(player);
    }

    @NotNull
    public ItemStack quickMoveStack(@NotNull Player player, int i) {
        ItemStack itemStackCopy = ItemStack.EMPTY;
        Slot slot = (Slot) this.slots.get(i);
        if (slot.hasItem()) {
            ItemStack item = slot.getItem();
            itemStackCopy = item.copy();
            int slots = this.g.b().getSlots() + this.g.c().getSlots() + this.g.d().getSlots();
            if (i < slots) {
                if (!moveItemStackTo(item, slots, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!moveItemStackTo(item, 0, slots, false)) {
                return ItemStack.EMPTY;
            }
            if (item.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return itemStackCopy;
    }

    @Nonnull
    public static IContainerFactory<i> e() {
        return (i, inventory, registryFriendlyByteBuf) -> {
            ItemStack itemBySlot = inventory.player.getItemBySlot(EquipmentSlot.CHEST);
            return new i(i, inventory, itemBySlot, new mctech.e.d(itemBySlot));
        };
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/i$b.class */
    public static class b implements MenuProvider {

        @Nonnull
        private final ItemStack a;

        @Nonnull
        private final mctech.e.d b;

        @Nonnull
        private final a c;

        public b(@Nonnull a aVar, @Nonnull ItemStack itemStack, @Nonnull mctech.e.d dVar) {
            this.c = aVar;
            this.a = itemStack;
            this.b = dVar;
        }

        @Nonnull
        public Component getDisplayName() {
            return Component.translatable("gui.mctech.singular_armor");
        }

        @Nullable
        public AbstractContainerMenu createMenu(int i, @Nonnull Inventory inventory, @Nonnull Player player) {
            if (player.getItemBySlot(EquipmentSlot.CHEST) == this.a) {
                return this.c.a(i, inventory, this.a, this.b);
            }
            return null;
        }

        public void a(@Nonnull FriendlyByteBuf friendlyByteBuf) {
        }
    }
}
