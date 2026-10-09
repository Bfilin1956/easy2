package mctech.api.network;

import java.util.Optional;
import java.util.function.Consumer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/network/IPlayerPacket.class */
public interface IPlayerPacket {
    default <T extends AbstractContainerMenu> T getContainer(Player player, Class<T> cls) {
        if (cls.isInstance(player.containerMenu)) {
            return (T) player.containerMenu;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    default <T extends AbstractContainerMenu> void getContainer(Player player, Class<T> cls, Consumer<T> consumer) {
        if (cls.isInstance(player.containerMenu)) {
            consumer.accept(player.containerMenu);
        }
    }

    default <T extends AbstractContainerMenu> Optional<T> getOptionalContainer(Player player, Class<T> cls) {
        return cls.isInstance(player.containerMenu) ? Optional.of(player.containerMenu) : Optional.empty();
    }

    default ItemStack findPlayerStack(Player player, ItemStack itemStack) {
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            if (ItemStack.matches(itemStack, player.getItemBySlot(equipmentSlot))) {
                return player.getItemBySlot(equipmentSlot);
            }
        }
        return ItemStack.EMPTY;
    }
}
