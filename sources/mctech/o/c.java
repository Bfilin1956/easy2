package mctech.o;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.items.EnumC0125a;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.neoforged.neoforge.network.IContainerFactory;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/c.class */
public abstract class c extends AbstractContainerMenu {

    @Nonnull
    protected final ItemStack f;

    @Nonnull
    protected final mctech.e.a g;

    @Nonnull
    public final int[][] h;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/c$a.class */
    @FunctionalInterface
    public interface a<T extends AbstractContainerMenu> {
        @Nonnull
        T createMenu(int i, @Nonnull Inventory inventory, @Nonnull ItemStack itemStack, @Nonnull mctech.e.a aVar);
    }

    protected c(@Nullable MenuType<?> menuType, int i, @Nonnull ItemStack itemStack, @Nonnull mctech.e.a aVar, @Nonnull int[][] iArr) {
        super(menuType, i);
        this.f = itemStack;
        this.g = aVar;
        this.h = iArr;
    }

    protected void a(@Nonnull int[][] iArr, @Nonnull IItemHandler iItemHandler) {
        for (int i = 0; i < iItemHandler.getSlots(); i++) {
            addSlot(new SlotItemHandler(this, iItemHandler, i, iArr[i][0], iArr[i][1]) { // from class: mctech.o.c.1
                public int getMaxStackSize() {
                    return 1;
                }

                public int getMaxStackSize(ItemStack itemStack) {
                    return 1;
                }
            });
        }
    }

    protected void a(@Nonnull Inventory inventory) {
        int i = 169;
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
    public mctech.e.a c() {
        return this.g;
    }

    public boolean stillValid(@Nonnull Player player) {
        return player.getItemBySlot(EquipmentSlot.CHEST) == this.f;
    }

    @Nonnull
    public static <T extends AbstractContainerMenu> IContainerFactory<T> a(@Nonnull a<T> aVar) {
        return (i, inventory, registryFriendlyByteBuf) -> {
            ItemStack itemBySlot = inventory.player.getItemBySlot(EquipmentSlot.CHEST);
            return aVar.createMenu(i, inventory, itemBySlot, new mctech.e.a(itemBySlot, (EnumC0125a) registryFriendlyByteBuf.readEnum(EnumC0125a.class)));
        };
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/c$b.class */
    public static class b implements MenuProvider {

        @Nonnull
        private final a<?> a;

        @Nonnull
        private final ItemStack b;

        @Nonnull
        private final mctech.e.a c;

        public b(@Nonnull a<?> aVar, @Nonnull ItemStack itemStack, @Nonnull mctech.e.a aVar2) {
            this.a = aVar;
            this.b = itemStack;
            this.c = aVar2;
        }

        @Nonnull
        public Component getDisplayName() {
            return Component.literal("empty");
        }

        @Nullable
        public AbstractContainerMenu createMenu(int i, @Nonnull Inventory inventory, @Nonnull Player player) {
            if (player.getItemBySlot(EquipmentSlot.CHEST) == this.b) {
                return this.a.createMenu(i, inventory, this.b, this.c);
            }
            return null;
        }

        public void a(@Nonnull FriendlyByteBuf friendlyByteBuf) {
            friendlyByteBuf.writeEnum(this.c.e());
        }
    }
}
