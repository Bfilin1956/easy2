package mctech.g.d.c;

import mctech.g.b.a.x;
import mctech.init.MCTechMenus;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/c/n.class */
public class n extends AbstractContainerMenu {
    private final ItemStack a;
    private final m b;

    public n(@Nullable MenuType<?> menuType, int i, Inventory inventory, ItemStack itemStack) {
        super(menuType, i);
        this.a = itemStack;
        mctech.g.a.e.d dVar = (mctech.g.a.e.d) itemStack.getCapability(mctech.g.a.d.e);
        if (!(dVar instanceof m)) {
            throw new IllegalArgumentException();
        }
        this.b = (m) dVar;
        a(24, 74, inventory);
    }

    protected n(int i, Inventory inventory, ItemStack itemStack) {
        this((MenuType) MCTechMenus.REDSTONE_TIMER_FILTER.get(), i, inventory, itemStack);
    }

    public static n a(int i, Inventory inventory, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return new n(i, inventory, inventory.player.getMainHandItem());
    }

    public m a() {
        return this.b;
    }

    public void a(String str) {
        try {
            this.b.a(Integer.parseInt(str));
            PacketDistributor.sendToServer(new x(Math.max(1, this.b.b()), Math.max(1, this.b.a())), new CustomPacketPayload[0]);
        } catch (Exception e) {
        }
    }

    @NotNull
    public ItemStack quickMoveStack(@NotNull Player player, int i) {
        return ItemStack.EMPTY;
    }

    public boolean stillValid(Player player) {
        return player.getItemInHand(InteractionHand.MAIN_HAND).equals(this.a);
    }

    public void a(int i, int i2, Inventory inventory) {
        for (int i3 = 0; i3 < 9; i3++) {
            addSlot(new Slot(inventory, i3, i + (i3 * 18), i2 + 58));
        }
        for (int i4 = 0; i4 < 3; i4++) {
            for (int i5 = 0; i5 < 9; i5++) {
                addSlot(new Slot(inventory, i5 + (i4 * 9) + 9, i + (i5 * 18), i2 + (i4 * 18)));
            }
        }
    }
}
