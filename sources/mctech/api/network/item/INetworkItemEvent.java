package mctech.api.network.item;

import mctech.api.network.IPlayerPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/network/item/INetworkItemEvent.class */
public interface INetworkItemEvent extends IPlayerPacket {
    void onEventReceived(ItemStack itemStack, Player player, int i, int i2, Dist dist);
}
