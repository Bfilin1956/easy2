package mctech.g.d.c;

import mctech.g.b.a.s;
import mctech.init.MCTechMenus;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/c/e.class */
public class e extends AbstractContainerMenu {
    private final ItemStack a;
    private final mctech.g.a.e.e b;
    private final a c;

    protected e(@Nullable MenuType<?> menuType, int i, Inventory inventory, ItemStack itemStack) {
        super(menuType, i);
        this.a = itemStack;
        Object capability = itemStack.getCapability(mctech.g.a.d.d);
        capability = capability == null ? itemStack.getCapability(mctech.g.a.d.e) : capability;
        if (!(capability instanceof mctech.g.a.e.e)) {
            throw new IllegalArgumentException();
        }
        this.b = (mctech.g.a.e.e) capability;
        if (!(capability instanceof a)) {
            throw new IllegalArgumentException();
        }
        this.c = (a) capability;
        a(24, 74, inventory);
    }

    protected e(int i, Inventory inventory, ItemStack itemStack) {
        this((MenuType) MCTechMenus.REDSTONE_DOUBLE_CHANNEL_FILTER.get(), i, inventory, itemStack);
    }

    public static e a(int i, Inventory inventory, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return new e(i, inventory, inventory.player.getMainHandItem());
    }

    public mctech.g.a.e.e a() {
        return this.b;
    }

    public a b() {
        return this.c;
    }

    @NotNull
    public ItemStack quickMoveStack(@NotNull Player player, int i) {
        return ItemStack.EMPTY;
    }

    public boolean stillValid(Player player) {
        return player.getItemInHand(InteractionHand.MAIN_HAND).equals(this.a);
    }

    public void a(DyeColor dyeColor) {
        this.c.a(dyeColor);
        PacketDistributor.sendToServer(new s(this.c.a(), this.c.b()), new CustomPacketPayload[0]);
    }

    public void b(DyeColor dyeColor) {
        this.c.b(dyeColor);
        PacketDistributor.sendToServer(new s(this.c.a(), this.c.b()), new CustomPacketPayload[0]);
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
