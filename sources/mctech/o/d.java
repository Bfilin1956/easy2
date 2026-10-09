package mctech.o;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.network.RegistryFriendlyByteBuf;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/d.class */
public abstract class d extends AbstractContainerMenu {

    @Nonnull
    protected final InteractionHand c;

    @Nonnull
    protected final ItemStack d;

    @Nonnull
    protected final mctech.e.b e;

    @Nonnull
    public final int[][] f;

    @Nonnull
    public final int[][] g;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/d$a.class */
    @FunctionalInterface
    public interface a<T extends AbstractContainerMenu> {
        @Nonnull
        T createMenu(int i, @Nonnull Inventory inventory, @Nonnull InteractionHand interactionHand, @Nonnull ItemStack itemStack, @Nonnull mctech.e.b bVar);
    }

    protected d(@Nullable MenuType<?> menuType, int i, @Nonnull InteractionHand interactionHand, @Nonnull ItemStack itemStack, @Nonnull mctech.e.b bVar, @Nonnull int[][] iArr, @Nonnull int[][] iArr2) {
        super(menuType, i);
        this.c = interactionHand;
        this.d = itemStack;
        this.e = bVar;
        this.f = iArr;
        this.g = iArr2;
    }

    protected void a(@Nonnull int[][] iArr, @Nonnull IItemHandler iItemHandler) {
        for (int i = 0; i < iItemHandler.getSlots(); i++) {
            addSlot(new SlotItemHandler(this, iItemHandler, i, iArr[i][0], iArr[i][1]) { // from class: mctech.o.d.1
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
    public mctech.e.b b() {
        return this.e;
    }

    public boolean stillValid(@Nonnull Player player) {
        return player.getItemInHand(this.c) == this.d && ItemStack.isSameItemSameComponents(player.getItemInHand(this.c), this.d);
    }

    public ItemStack c() {
        return this.d;
    }

    @Nonnull
    public static <T extends AbstractContainerMenu> IContainerFactory<T> a(@Nonnull a<T> aVar) {
        return (i, inventory, registryFriendlyByteBuf) -> {
            InteractionHand interactionHand = (InteractionHand) registryFriendlyByteBuf.readEnum(InteractionHand.class);
            return aVar.createMenu(i, inventory, interactionHand, inventory.player.getItemInHand(interactionHand), new mctech.e.b((ItemStack) ItemStack.STREAM_CODEC.decode(registryFriendlyByteBuf), (mctech.items.f) registryFriendlyByteBuf.readEnum(mctech.items.f.class)));
        };
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/d$b.class */
    public static class b implements MenuProvider {

        @Nonnull
        private final a<?> a;

        @Nonnull
        private final InteractionHand b;

        @Nonnull
        private final ItemStack c;

        @Nonnull
        private final mctech.e.b d;

        public b(@Nonnull a<?> aVar, @Nonnull InteractionHand interactionHand, @Nonnull ItemStack itemStack, @Nonnull mctech.e.b bVar) {
            this.a = aVar;
            this.b = interactionHand;
            this.c = itemStack;
            this.d = bVar;
        }

        @Nonnull
        public Component getDisplayName() {
            return Component.literal("empty");
        }

        @Nullable
        public AbstractContainerMenu createMenu(int i, @Nonnull Inventory inventory, @Nonnull Player player) {
            if (player.getItemInHand(this.b) == this.c) {
                return this.a.createMenu(i, inventory, this.b, this.c, this.d);
            }
            return null;
        }

        public void a(@Nonnull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            registryFriendlyByteBuf.writeEnum(this.b);
            registryFriendlyByteBuf.writeEnum(this.d.e());
            ItemStack.STREAM_CODEC.encode(registryFriendlyByteBuf, this.c);
        }
    }
}
