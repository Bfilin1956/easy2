package mctech.o;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.items.v;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.neoforged.neoforge.network.IContainerFactory;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/e.class */
public abstract class e extends AbstractContainerMenu {

    @Nonnull
    protected final InteractionHand a;

    @Nonnull
    protected final ItemStack b;

    @Nonnull
    protected final mctech.e.c c;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/e$a.class */
    @FunctionalInterface
    public interface a<T extends AbstractContainerMenu> {
        @Nonnull
        T createMenu(int i, @Nonnull Inventory inventory, @Nonnull InteractionHand interactionHand, @Nonnull ItemStack itemStack, @Nonnull mctech.e.c cVar);
    }

    protected e(@Nullable MenuType<?> menuType, int i, @Nonnull InteractionHand interactionHand, @Nonnull ItemStack itemStack, @Nonnull mctech.e.c cVar) {
        super(menuType, i);
        this.a = interactionHand;
        this.b = itemStack;
        this.c = cVar;
    }

    protected void a(@Nonnull int[][] iArr, @Nonnull IItemHandler iItemHandler) {
        for (int i = 0; i < iItemHandler.getSlots(); i++) {
            addSlot(new SlotItemHandler(iItemHandler, i, iArr[i][0], iArr[i][1]));
        }
    }

    protected void a(@Nonnull Inventory inventory) {
        int i = 155;
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 9; i3++) {
                addSlot(new Slot(inventory, i3 + (i2 * 9) + 9, 22 + (i3 * 18), i));
            }
            i += 18;
        }
        int i4 = i + 4;
        for (int i5 = 0; i5 < 9; i5++) {
            addSlot(new Slot(inventory, i5, 22 + (i5 * 18), i4));
        }
    }

    @Nonnull
    public InteractionHand a() {
        return this.a;
    }

    @Nonnull
    public ItemStack b() {
        return this.b;
    }

    @Nonnull
    public mctech.e.c c() {
        return this.c;
    }

    public boolean stillValid(@Nonnull Player player) {
        return player.getItemInHand(this.a) == this.b && ItemStack.isSameItemSameComponents(player.getItemInHand(this.a), this.b);
    }

    @Nonnull
    public static <T extends AbstractContainerMenu> IContainerFactory<T> a(@Nonnull a<T> aVar) {
        return (i, inventory, registryFriendlyByteBuf) -> {
            InteractionHand interactionHand = (InteractionHand) registryFriendlyByteBuf.readEnum(InteractionHand.class);
            ItemStack itemInHand = inventory.player.getItemInHand(interactionHand);
            return aVar.createMenu(i, inventory, interactionHand, itemInHand, new mctech.e.c(itemInHand, (v) registryFriendlyByteBuf.readEnum(v.class)));
        };
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/e$b.class */
    public static class b implements MenuProvider {

        @Nonnull
        private final a<?> a;

        @Nonnull
        private final InteractionHand b;

        @Nonnull
        private final ItemStack c;

        @Nonnull
        private final mctech.e.c d;

        public b(@Nonnull a<?> aVar, @Nonnull InteractionHand interactionHand, @Nonnull ItemStack itemStack, @Nonnull mctech.e.c cVar) {
            this.a = aVar;
            this.b = interactionHand;
            this.c = itemStack;
            this.d = cVar;
        }

        @Nonnull
        public Component getDisplayName() {
            return Component.empty();
        }

        @Nullable
        public AbstractContainerMenu createMenu(int i, @Nonnull Inventory inventory, @Nonnull Player player) {
            if (player.getItemInHand(this.b) == this.c) {
                return this.a.createMenu(i, inventory, this.b, this.c, this.d);
            }
            return null;
        }

        public void a(@Nonnull FriendlyByteBuf friendlyByteBuf) {
            friendlyByteBuf.writeEnum(this.b);
            friendlyByteBuf.writeEnum(this.d.e());
        }
    }
}
